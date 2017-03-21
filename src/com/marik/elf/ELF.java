package com.marik.elf;

import static com.marik.elf.ELFConstant.ELFUnit.uint32_t;
import static com.marik.elf.ELFConstant.DT_RelType.*;
import static com.marik.elf.ELFConstant.ELFUnit.*;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.UnsupportedDataTypeException;

import com.marik.elf.ELF_ProgramHeader.ELF_Phdr;
import com.marik.elf.ELF_Relocate.Elf_rel;
import com.marik.elf.ELF_SectionHeader.ELF_Shdr;
import com.marik.util.Log;
import com.marik.util.Util;
import com.marik.vm.OS;

/**
 * Construct a new Elf decoder which only support arm/32bit
 * 
 * @author lingb
 *
 */
public class ELF {

	private static class ReserseLoadableSegment {
		long min_address;
		long max_address;
	}

	private ELF_Header elf_header;
	private ELF_ProgramHeader elf_phdr;
	private ELF_Dynamic elf_dynamic;

	private int nbucket;
	private int nchain;
	private int bucket;
	private int chain;

	private int symtab;

	private int strtab;

	private int plt_rel;
	private int plt_rel_count;

	private int rel;
	private int rel_count;

	private int init_func;
	private int init_array;
	private int init_array_sz;

	private int fini_func;
	private int fini_array;
	private int fini_array_sz;

	private int elf_start;
	private int elf_load_bias;

	public ELF_Header getElf_header() {
		return elf_header;
	}

	public ELF_ProgramHeader getElf_phdr() {
		return elf_phdr;
	}

	public ELF(String file) throws Exception {
		this(new File(file));
	}

	public ELF(File file) throws Exception {

		// Log.DEBUG = false;

		RandomAccessFile raf = new RandomAccessFile(file, "r");

		try {

			elf_header = new ELF_Header(raf);
			if (!elf_header.isLittleEndian())
				throw new UnsupportedDataTypeException("ELFDecoder don't support big endian architecture");

			elf_phdr = new ELF_ProgramHeader(raf, elf_header, false);
			elf_dynamic = new ELF_Dynamic(raf, elf_phdr.getDynamicSegment());

			reserseAddressSpace();

			loadSegments(raf);

			link_image();

			OS.dumpMemory();

			relocate();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private void reserseAddressSpace() {

		List<ELF_Phdr> allLoadableSegment = elf_phdr.getAllLoadableSegment();

		ReserseLoadableSegment r = phdr_table_get_load_size(allLoadableSegment);

		elf_start = OS.mmap(0, (int) (r.max_address - r.min_address), (byte) 0, null, 0);
		if (elf_start < 0)
			throw new RuntimeException("mmap fail while reserse space");

		elf_load_bias = (int) (elf_start - r.min_address);
	}

	private ReserseLoadableSegment phdr_table_get_load_size(List<ELF_Phdr> loadableSegment) {

		int minAddress = Integer.MAX_VALUE;
		int maxAddress = 0;

		for (ELF_Phdr phdr : loadableSegment) {/*
												 * if (phdr->p_vaddr <
												 * min_vaddr) { min_vaddr =
												 * phdr->p_vaddr; // 记录最小的虚拟地址 }
												 * if (phdr->p_vaddr +
												 * phdr->p_memsz > max_vaddr) {
												 * max_vaddr = phdr->p_vaddr +
												 * phdr->p_memsz; // 记录最大的虚拟地址 }
												 */

			int address = Util.bytes2Int32(phdr.p_vaddr);
			int memsize = Util.bytes2Int32(phdr.p_memsz);
			if (address < minAddress)
				minAddress = address;

			if (address + memsize > maxAddress) {
				System.out.println("Change : " + address + " memsz " + memsize);
				maxAddress = address + memsize;
			}

		}

		ReserseLoadableSegment r = new ReserseLoadableSegment();
		r.min_address = OS.PAGE_START(minAddress);
		r.max_address = OS.PAGE_END(maxAddress);

		return r;
	}

	private void loadSegments(RandomAccessFile raf) {

		List<ELF_Phdr> phs = elf_phdr.getAllLoadableSegment();
		for (ELF_Phdr ph : phs) {

			long seg_start = Util.bytes2Int64(ph.p_vaddr) + elf_load_bias;
			long seg_end = seg_start + Util.bytes2Int64(ph.p_memsz);

			long seg_page_start = OS.PAGE_START(seg_start);
			long seg_page_end = OS.PAGE_END(seg_end);

			long seg_file_end = seg_start + Util.bytes2Int64(ph.p_filesz);

			// 文件偏移
			long file_start = Util.bytes2Int64(ph.p_offset);
			long file_end = file_start + Util.bytes2Int64(ph.p_filesz);

			long file_page_start = OS.PAGE_START(file_start);
			long file_length = file_end - file_page_start;

			// System.out.println("seg_start : " +
			// Long.toHexString(seg_start));
			// System.out.println("seg_end : " + Long.toHexString(seg_end));
			// System.out.println("seg_page_start : " +
			// Long.toHexString(seg_page_start));
			// System.out.println("seg_page_end : " +
			// Long.toHexString(seg_page_end));
			// System.out.println("seg_file_end : " +
			// Long.toHexString(seg_file_end));
			// System.out.println("file_start : " +
			// Long.toHexString(file_start));
			// System.out.println("file_end : " +
			// Long.toHexString(file_end));
			// System.out.println("file_page_start : " +
			// Long.toHexString(file_page_start));
			// System.out.println("file_length : " +
			// Long.toHexString(file_length));
			// System.out.println();
			// System.out.println("Segment p_vaddr : " +
			// Util.bytes2Hex(ph.p_vaddr));
			// System.out.println("Segment p_memsz : " +
			// Util.bytes2Hex(ph.p_memsz));
			// System.out.println("Segment p_offset : " +
			// Util.bytes2Hex(ph.p_offset));
			// System.out.println("Segment p_filesz : " +
			// Util.bytes2Hex(ph.p_filesz));

			if (0 > OS.mmap((int) seg_page_start, (int) file_length, OS.MAP_FIXED, raf, file_page_start))
				throw new RuntimeException("Unable to mmap segment : " + ph.toString());
		}

	}

	public void link_image() {
		nbucket = Util.bytes2Int32(OS.getMemory(), elf_dynamic.getDT_HASH() + elf_start + uint32_t * 0, uint32_t,
				elf_header.isLittleEndian());
		nchain = Util.bytes2Int32(OS.getMemory(), elf_dynamic.getDT_HASH() + elf_start + uint32_t * 1, uint32_t,
				elf_header.isLittleEndian());
		bucket = Util.bytes2Int32(OS.getMemory(), elf_dynamic.getDT_HASH() + elf_start + 8, uint32_t,
				elf_header.isLittleEndian());
		chain = Util.bytes2Int32(OS.getMemory(), elf_dynamic.getDT_HASH() + elf_start + nbucket * 4, uint32_t,
				elf_header.isLittleEndian()); // value

		symtab = elf_dynamic.getDT_SYMTAB() + elf_start; // index

		strtab = elf_dynamic.getDT_STRTAB() + elf_start; // index

		plt_rel = elf_dynamic.getDT_PLTREL() + elf_start;
		plt_rel_count = (elf_dynamic.getDT_PLTRELSZ() + elf_start) >> 3;

		rel = elf_dynamic.getDT_REL() + elf_start;
		rel_count = (elf_dynamic.getDT_RELSZ() + elf_start) >> 3;

		init_func = elf_dynamic.getDT_INIT() + elf_start;
		init_array = elf_dynamic.getDT_INIT_ARRAY() + elf_start;
		init_array_sz = elf_dynamic.getDT_INIT_ARRAYSZ();

		fini_func = elf_dynamic.getDT_FINI() + elf_start;
		fini_array = elf_dynamic.getDT_FINI_ARRAY() + elf_start;
		fini_array_sz = elf_dynamic.getDT_FINI_ARRAYSZ();

		if (nbucket == 0)
			throw new RuntimeException("empty/missing DT_HASH");
		if (strtab == 0)
			throw new RuntimeException("empty/missing DT_STRTAB");
		if (symtab == 0)
			throw new RuntimeException("empty/missing DT_SYMTAB");

		System.out.println("nbucket : " + nbucket);
		System.out.println("nchain : " + nchain);
		System.out.println("bucket : " + bucket);
		System.out.println("chain : " + chain);
		System.out.println("symtab : " + symtab);
		System.out.println("strtab : " + strtab);
		System.out.println("plt_rel : " + plt_rel);
		System.out.println("plt_rel_count : " + plt_rel_count);
		System.out.println("rel : " + rel);
		System.out.println("rel_count : " + rel_count);
		System.out.println("init_func : " + init_func);
		System.out.println("init_array : " + init_array);
		System.out.println("init_array_sz : " + init_array_sz);
		System.out.println("fini_func : " + fini_func);
		System.out.println("fini_array : " + fini_array);
		System.out.println("fini_array_sz : " + fini_array_sz);
	}

	public int get_addend(Elf_rel rel, int reloc_addr) {

		if (rel.getType() == R_GENERIC_RELATIVE)
			return Util.bytes2Int32(OS.getMemory(), reloc_addr, ELF32_Addr, elf_header.isLittleEndian());

		return 0; /*
					 * if (ELFW(R_TYPE)(rel->r_info) == R_GENERIC_RELATIVE ||
					 * ELFW(R_TYPE)(rel->r_info) == R_GENERIC_IRELATIVE) {
					 * return *reinterpret_cast<ElfW(Addr)*>(reloc_addr); }
					 * return 0;
					 */
	}

	/**
	 * what is relocation ? relocation fix a pointer which point at somewhere in
	 * file , but we need to let it point to memory correct
	 */
	public void relocate() {

		List<ELF_Relocate> rels = elf_dynamic.getRelocateSections();

		for (ELF_Relocate r : rels) {
			Elf_rel[] entries = r.getRelocateEntry();
			for (Elf_rel rel : entries) {
				// ElfW(Addr) reloc = static_cast<ElfW(Addr)>(rel->r_offset +
				// load_bias);
				int reloc = Util.bytes2Int32(rel.r_offset) + elf_load_bias;
				int sym = rel.getSym();
				int type = rel.getType();
				int addend = get_addend(rel, reloc);

				if (sym > 0) { // sym > 0 means the symbol are global , not in
								// this file
					byte[] st_name = new byte[4];

					System.arraycopy(OS.getMemory(), symtab + sym * 0x10, st_name, 0, 4); // we
																							// get
																							// st_name(index)
																							// from
																							// symtab

					String sym_name = Util.getStringFromMemory(Util.bytes2Int32(st_name) + strtab);
					Log.e("sym : " + sym + "  index : " + (Util.bytes2Int32(st_name) + strtab) + "  st_name : "
							+ sym_name);
				} else
					Log.e("  sym : " + sym + "  addend : " + Integer.toHexString(addend));

				switch (type) {
				case R_GENERIC_GLOB_DAT:
					break;
				case R_GENERIC_JUMP_SLOT:
					break;
				case R_GENERIC_RELATIVE: { // *reinterpret_cast<ElfW(Addr)*>(reloc)
											// = (load_bias + addend);
					System.arraycopy(Util.int2bytes(elf_load_bias + addend), 0, OS.getMemory(), reloc, 4);  //yeah ! we need to pull the data out , fix it , then push it back

					Log.e("reloc : " + Integer.toHexString(reloc) + "  become : "
							+ Integer.toHexString(elf_load_bias + addend));

				}
					break;

				default:
					throw new RuntimeException("unknown weak reloc type" + type);
				}

			}
		}
	}

	public Map<ELF_Phdr, List<ELF_Shdr>> getProgramSectionMapping(ELF_ProgramHeader programHeader,
			ELF_SectionHeader sectionHeader) {

		Map<ELF_Phdr, List<ELF_Shdr>> map = new HashMap<>();

		ELF_ProgramHeader.ELF_Phdr[] programs = programHeader.getAllDecodedProgramHeader();
		ELF_SectionHeader.ELF_Shdr[] sections = sectionHeader.getAllDecodedSectionHeader();

		boolean puts = false;

		for (ELF_SectionHeader.ELF_Shdr section : sections) {
			puts = false;
			for (ELF_ProgramHeader.ELF_Phdr program : programs)

				if ((section.getMemoryOffset() >= program.getMemoryOffset()) && ((section.getMemoryOffset()
						+ section.getMemorySize()) <= (program.getMemoryOffset() + program.getMemorySize()))) { // os
																												// mapping
																												// it
																												// in
																												// memory
																												// ,
																												// so
																												// we
																												// use
																												// memory
																												// address
																												// to
																												// map
																												// it

					List<ELF_SectionHeader.ELF_Shdr> list = map.get(program);
					if (list == null) {
						list = new ArrayList<>();
						map.put(program, list);
					}

					list.add(section);
					puts = true;
					break;
				}
			if (!puts)
				Log.e("Unable to mapping " + section.getName() + " , offset at " + Util.bytes2Hex(section.sh_offset)
						+ " , program offset : " + section.getSectionOffset() + " , size : "
						+ section.getSectionSize());
		}
		return map;
	}
}
