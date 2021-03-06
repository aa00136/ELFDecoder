package com.marik.elf;

public class ELF_Constant {

	public static class ELFUnit {

		public static final int uint16_t = 0x2;
		public static final int uint32_t = 0x4;
		public static final int uint64_t = 0x8;

		public static final int ELF32_Half = uint16_t;
		public static final int ELF32_Word = uint32_t;
		public static final int ELF32_Off = uint32_t;
		public static final int ELF32_Addr = uint32_t;
		public static final int ELF32_Sword = uint32_t;

		public static final int ELF64_Half = uint16_t;
		public static final int ELF64_Word = uint32_t;
		public static final int ELF64_Off = uint64_t;
		public static final int ELF64_Addr = uint64_t;
		public static final int ELF64_Sword = uint32_t;
		public static final int ELF64_Xword = uint64_t;
		public static final int ELF64_Sxword = uint64_t;

	}

	public static class HeaderContent {

		public static final int EI_NIDENT = 0x10;
		public static final byte[] ELFMagicCode = { 0x7f, 0x45, 0x4c, 0x46 };

		public static final int EI_CALSS = 4;
		public static final int ELFCLASS32 = 1;
		public static final int ELFCLASS64 = 2;
		public static final int ELFCLASSNONE = 0;

		public static final int EI_DATA = 5;
		public static final int ELFDATANONE = 0;
		public static final int ELFDATA2LSB = 1;
		public static final int ELFDATA2MSB = 2;

		public static final int EI_VERSION = 6;
		public static final int EV_CURRENT = 1;

		/*----------------------------------------------------*/

		public static final int ET_NONE = 0;
		public static final int ET_REL = 1;
		public static final int ET_EXEC = 2;
		public static final int ET_DYN = 3;
		public static final int ET_CORE = 4;
		public static final int ET_LOPROC = 0Xff00;
		public static final int ET_HIPROC = 0xffff;

		/*----------------------------------------------------*/

		public static final int EM_NONE = 0; // No machine
		public static final int EM_M32 = 1; // AT&T WE 32100
		public static final int EM_SPARC = 2; // SPARC
		public static final int EM_386 = 3; // Intel 386
		public static final int EM_68K = 4; // Motorola 68000
		public static final int EM_88K = 5; // Motorola 88000
		public static final int EM_486 = 6; // Intel 486 (deprecated)
		public static final int EM_860 = 7; // Intel 80860
		public static final int EM_MIPS = 8; // MIPS R3000
		public static final int EM_S370 = 9; // IBM System/370
		public static final int EM_MIPS_RS3_LE = 10; // MIPS RS3000
														// Little-endian
		public static final int EM_PARISC = 15; // Hewlett-Packard PA-RISC
		public static final int EM_VPP500 = 17; // Fujitsu VPP500
		public static final int EM_SPARC32PLUS = 18; // Enhanced instruction set
														// SPARC
		public static final int EM_960 = 19; // Intel 80960
		public static final int EM_PPC = 20; // PowerPC
		public static final int EM_PPC64 = 21; // PowerPC64
		public static final int EM_S390 = 22; // IBM System/390
		public static final int EM_SPU = 23; // IBM SPU/SPC
		public static final int EM_V800 = 36; // NEC V800
		public static final int EM_FR20 = 37; // Fujitsu FR20
		public static final int EM_RH32 = 38; // TRW RH-32
		public static final int EM_RCE = 39; // Motorola RCE
		public static final int EM_ARM = 40; // ARM
		public static final int EM_ALPHA = 41; // DEC Alpha
		public static final int EM_SH = 42; // Hitachi SH
		public static final int EM_SPARCV9 = 43; // SPARC V9
		public static final int EM_TRICORE = 44; // Siemens TriCore
		public static final int EM_ARC = 45; // Argonaut RISC Core
		public static final int EM_H8_300 = 46; // Hitachi H8/300
		public static final int EM_H8_300H = 47; // Hitachi H8/300H
		public static final int EM_H8S = 48; // Hitachi H8S
		public static final int EM_H8_500 = 49; // Hitachi H8/500
		public static final int EM_IA_64 = 50; // Intel IA-64 processor
												// architecture
		public static final int EM_MIPS_X = 51; // Stanford MIPS-X
		public static final int EM_COLDFIRE = 52; // Motorola ColdFire
		public static final int EM_68HC12 = 53; // Motorola M68HC12
		public static final int EM_MMA = 54; // Fujitsu MMA Multimedia
												// Accelerator
		public static final int EM_PCP = 55; // Siemens PCP
		public static final int EM_NCPU = 56; // Sony nCPU embedded RISC
												// processor
		public static final int EM_NDR1 = 57; // Denso NDR1 microprocessor
		public static final int EM_STARCORE = 58; // Motorola Star*Core
													// processor
		public static final int EM_ME16 = 59; // Toyota ME16 processor
		public static final int EM_ST100 = 60; // STMicroelectronics ST100
												// processor
		public static final int EM_TINYJ = 61; // Advanced Logic Corp. TinyJ
												// embedded processor family
		public static final int EM_X86_64 = 62; // AMD x86-64 architecture
		public static final int EM_PDSP = 63; // Sony DSP Processor
		public static final int EM_PDP10 = 64; // Digital Equipment Corp. PDP-10
		public static final int EM_PDP11 = 65; // Digital Equipment Corp. PDP-11
		public static final int EM_FX66 = 66; // Siemens FX66 microcontroller
		public static final int EM_ST9PLUS = 67; // STMicroelectronics ST9+ 8/16
													// bit microcontroller
		public static final int EM_ST7 = 68; // STMicroelectronics ST7 8-bit
												// microcontroller
		public static final int EM_68HC16 = 69; // Motorola MC68HC16
												// Microcontroller
		public static final int EM_68HC11 = 70; // Motorola MC68HC11
												// Microcontroller
		public static final int EM_68HC08 = 71; // Motorola MC68HC08
												// Microcontroller
		public static final int EM_68HC05 = 72; // Motorola MC68HC05
												// Microcontroller
		public static final int EM_SVX = 73; // Silicon Graphics SVx
		public static final int EM_ST19 = 74; // STMicroelectronics ST19 8-bit
												// microcontroller
		public static final int EM_VAX = 75; // Digital VAX
		public static final int EM_CRIS = 76; // Axis Communications 32-bit
												// embedded processor
		public static final int EM_JAVELIN = 77; // Infineon Technologies 32-bit
													// embedded processor
		public static final int EM_FIREPATH = 78; // Element 14 64-bit DSP
													// Processor
		public static final int EM_ZSP = 79; // LSI Logic 16-bit DSP Processor
		public static final int EM_MMIX = 80; // Donald Knuth's educational
												// 64-bit processor
		public static final int EM_HUANY = 81; // Harvard University
												// machine-independent object
												// files
		public static final int EM_PRISM = 82; // SiTera Prism
		public static final int EM_AVR = 83; // Atmel AVR 8-bit microcontroller
		public static final int EM_FR30 = 84; // Fujitsu FR30
		public static final int EM_D10V = 85; // Mitsubishi D10V
		public static final int EM_D30V = 86; // Mitsubishi D30V
		public static final int EM_V850 = 87; // NEC v850
		public static final int EM_M32R = 88; // Mitsubishi M32R
		public static final int EM_MN10300 = 89; // Matsushita MN10300
		public static final int EM_MN10200 = 90; // Matsushita MN10200
		public static final int EM_PJ = 91; // picoJava
		public static final int EM_OPENRISC = 92; // OpenRISC 32-bit embedded
													// processor
		public static final int EM_ARC_COMPACT = 93; // ARC International
														// ARCompact processor
														// (old
		// spelling/synonym: public static final int EM_ARC_A5)
		public static final int EM_XTENSA = 94; // Tensilica Xtensa Architecture
		public static final int EM_VIDEOCORE = 95; // Alphamosaic VideoCore
													// processor
		public static final int EM_TMM_GPP = 96; // Thompson Multimedia General
													// Purpose Processor
		public static final int EM_NS32K = 97; // National Semiconductor 32000
												// series
		public static final int EM_TPC = 98; // Tenor Network TPC processor
		public static final int EM_SNP1K = 99; // Trebia SNP 1000 processor
		public static final int EM_ST200 = 100; // STMicroelectronics
												// (www.st.com) ST200
		public static final int EM_IP2K = 101; // Ubicom IP2xxx microcontroller
												// family
		public static final int EM_MAX = 102; // MAX Processor
		public static final int EM_CR = 103; // National Semiconductor
												// CompactRISC microprocessor
		public static final int EM_F2MC16 = 104; // Fujitsu F2MC16
		public static final int EM_MSP430 = 105; // Texas Instruments embedded
													// microcontroller msp430
		public static final int EM_BLACKFIN = 106; // Analog Devices Blackfin
													// (DSP) processor
		public static final int EM_SE_C33 = 107; // S1C33 Family of Seiko Epson
													// processors
		public static final int EM_SEP = 108; // Sharp embedded microprocessor
		public static final int EM_ARCA = 109; // Arca RISC Microprocessor
		public static final int EM_UNICORE = 110; // Microprocessor series from
													// PKU-Unity Ltd. and MPRC
													// of Peking University
		public static final int EM_EXCESS = 111; // eXcess: 16/32/64-bit
													// configurable embedded CPU
		public static final int EM_DXP = 112; // Icera Semiconductor Inc. Deep
												// Execution Processor
		public static final int EM_ALTERA_NIOS2 = 113; // Altera Nios II
														// soft-core processor
		public static final int EM_CRX = 114; // National Semiconductor
												// CompactRISC CRX
		public static final int EM_XGATE = 115; // Motorola XGATE embedded
												// processor
		public static final int EM_C166 = 116; // Infineon C16x/XC16x processor
		public static final int EM_M16C = 117; // Renesas M16C series
												// microprocessors
		public static final int EM_DSPIC30F = 118; // Microchip Technology
													// dsPIC30F Digital Signal
		// Controller
		public static final int EM_CE = 119; // Freescale Communication Engine
												// RISC core
		public static final int EM_M32C = 120; // Renesas M32C series
												// microprocessors
		public static final int EM_TSK3000 = 131; // Altium TSK3000 core
		public static final int EM_RS08 = 132; // Freescale RS08 embedded
												// processor
		public static final int EM_SHARC = 133; // Analog Devices SHARC family
												// of 32-bit DSP
		// processors
		public static final int EM_ECOG2 = 134; // Cyan Technology eCOG2
												// microprocessor
		public static final int EM_SCORE7 = 135; // Sunplus S+core7 RISC
													// processor
		public static final int EM_DSP24 = 136; // New Japan Radio (NJR) 24-bit
												// DSP Processor
		public static final int EM_VIDEOCORE3 = 137; // Broadcom VideoCore III
														// processor
		public static final int EM_LATTICEMICO32 = 138; // RISC processor for
														// Lattice FPGA
														// architecture
		public static final int EM_SE_C17 = 139; // Seiko Epson C17 family
		public static final int EM_TI_C6000 = 140; // The Texas Instruments
													// TMS320C6000 DSP family
		public static final int EM_TI_C2000 = 141; // The Texas Instruments
													// TMS320C2000 DSP family
		public static final int EM_TI_C5500 = 142; // The Texas Instruments
													// TMS320C55x DSP family
		public static final int EM_MMDSP_PLUS = 160; // STMicroelectronics 64bit
														// VLIW Data Signal
														// Processor
		public static final int EM_CYPRESS_M8C = 161; // Cypress M8C
														// microprocessor
		public static final int EM_R32C = 162; // Renesas R32C series
												// microprocessors
		public static final int EM_TRIMEDIA = 163; // NXP Semiconductors
													// TriMedia architecture
													// family
		public static final int EM_HEXAGON = 164; // Qualcomm Hexagon processor
		public static final int EM_8051 = 165; // Intel 8051 and variants
		public static final int EM_STXP7X = 166; // STMicroelectronics STxP7x
													// family of configurable
		// and extensible RISC processors
		public static final int EM_NDS32 = 167; // Andes Technology compact code
												// size embedded RISC
		// processor family
		public static final int EM_ECOG1 = 168; // Cyan Technology eCOG1X family
		public static final int EM_ECOG1X = 168; // Cyan Technology eCOG1X
													// family
		public static final int EM_MAXQ30 = 169; // Dallas Semiconductor MAXQ30
													// Core Micro-controllers
		public static final int EM_XIMO16 = 170; // New Japan Radio (NJR) 16-bit
													// DSP Processor
		public static final int EM_MANIK = 171; // M2000 Reconfigurable RISC
												// Microprocessor
		public static final int EM_CRAYNV2 = 172; // Cray Inc. NV2 vector
													// architecture
		public static final int EM_RX = 173; // Renesas RX family
		public static final int EM_METAG = 174; // Imagination Technologies META
												// processor
		// architecture
		public static final int EM_MCST_ELBRUS = 175; // MCST Elbrus general
														// purpose hardware
														// architecture
		public static final int EM_ECOG16 = 176; // Cyan Technology eCOG16
													// family
		public static final int EM_CR16 = 177; // National Semiconductor
												// CompactRISC CR16 16-bit
		// microprocessor
		public static final int EM_ETPU = 178; // Freescale Extended Time
												// Processing Unit
		public static final int EM_SLE9X = 179; // Infineon Technologies SLE9X
												// core
		public static final int EM_L10M = 180; // Intel L10M
		public static final int EM_K10M = 181; // Intel K10M
		public static final int EM_AARCH64 = 183; // ARM AArch64
		public static final int EM_AVR32 = 185; // Atmel Corporation 32-bit
												// microprocessor family
		public static final int EM_STM8 = 186; // STMicroeletronics STM8 8-bit
												// microcontroller
		public static final int EM_TILE64 = 187; // Tilera TILE64 multicore
													// architecture family
		public static final int EM_TILEPRO = 188; // Tilera TILEPro multicore
													// architecture family
		public static final int EM_CUDA = 190; // NVIDIA CUDA architecture
		public static final int EM_TILEGX = 191; // Tilera TILE-Gx multicore
													// architecture family
		public static final int EM_CLOUDSHIELD = 192; // CloudShield
														// architecture family
		public static final int EM_COREA_1ST = 193; // KIPO-KAIST Core-A 1st
													// generation processor
													// family
		public static final int EM_COREA_2ND = 194; // KIPO-KAIST Core-A 2nd
													// generation processor
													// family
		public static final int EM_ARC_COMPACT2 = 195; // Synopsys ARCompact V2
		public static final int EM_OPEN8 = 196; // Open8 8-bit RISC soft
												// processor core
		public static final int EM_RL78 = 197; // Renesas RL78 family
		public static final int EM_VIDEOCORE5 = 198; // Broadcom VideoCore V
														// processor
		public static final int EM_78KOR = 199; // Renesas 78KOR family
		public static final int EM_56800EX = 200; // Freescale 56800EX Digital
													// Signal Controller (DSC)

		/*-----------------------------------------------*/

	}

	public static class ProgramHeaderContent {

		public static final int PT_NULL = 0;
		public static final int PT_LOAD = 1;
		public static final int PT_DYNAMIC = 2;
		public static final int PT_INTERP = 3;
		public static final int PT_NOTE = 4;
		public static final int PT_SHLIB = 5;
		public static final int PT_PHDR = 6;
		public static final int PT_GUN_STACK = 0x6474E551;
		public static final int PT_LOPROC = 0x70000000;
		public static final int PT_HIPROC = 0x7fffffff;

	}

	@Deprecated
	public static class SectionHeaderContent {

		public static final int SHT_NULL = 0;
		public static final int SHT_PROGBITS = 1;
		public static final int SHT_SYMTAB = 2;
		public static final int SHT_STRTAB = 3;
		public static final int SHT_RELA = 4;
		public static final int SHT_HASH = 5;
		public static final int SHT_DYNAMIC = 6;
		public static final int SHT_NOTE = 7;
		public static final int SHT_NOBITS = 8;
		public static final int SHT_REL = 9;
		public static final int SHT_SHLIB = 10;
		public static final int SHT_DYMSYM = 11;
		public static final int SHT_NUM = 12;
		public static final int SHT_LOPROC = 0x70000000;
		public static final int SHT_HIPROC = 0x7fffffff;
		public static final int SHT_LOUSER = 0x80000000;
		public static final int SHT_HIUSER = 0x8fffffff;

		/**
		 * writable section
		 */
		public static final int SHF_WRITE = 0x1;
		public static final int SHF_ALLOC = 0x2;
		/**
		 * executable section
		 */
		public static final int SHF_EXECINSTR = 0x4;
		public static final int SHF_MASKPROC = 0xf0000000;
	}

	@Deprecated
	public static class SectionName {
		public static final String BSS = ".bss";
		public static final String COMMENT = ".comment";
		public static final String DATA = ".data";
		public static final String DATAL = ".datal";
		public static final String DEBUG = ".debug";
		public static final String DYNAMIC = ".dynamic";
		public static final String DYNSTR = ".dynstr";
		public static final String FINI = ".fini";
		public static final String GOT = ".got";
		public static final String HASH = ".hash";
		public static final String INIT = ".init";
		public static final String INTERP = ".interp";
		public static final String LINE = ".line";
		public static final String NOTE = ".note";
		public static final String PLT = ".plt";
		public static final String RELNAME = ".relname";
		public static final String RELANAME = ".relaname";
		public static final String RODATA = ".rodata";
		public static final String RODATA1 = ".rodata1";
		public static final String SHSTRTAB = ".shstrtab";
		public static final String STRTAB = ".strtab";
		public static final String SYMTAB = ".symtab";
		public static final String TEXT = ".text";

	}

	public static class PT_Dynamic {
		public static final int DT_NULL = 0;
		public static final int DT_NEEDED = 1;
		public static final int DT_PLTRELSZ = 2;
		public static final int DT_PLTGOT = 3;
		public static final int DT_HASH = 4;
		public static final int DT_STRTAB = 5;
		public static final int DT_SYMTAB = 6;
		public static final int DT_RELA = 7;
		public static final int DT_RELASZ = 8;
		public static final int DT_RELAENT = 9;
		public static final int DT_STRSZ = 10;
		public static final int DT_SYMENT = 11;
		public static final int DT_INIT = 12;
		public static final int DT_FINI = 13;
		public static final int DT_SONAME = 14;
		public static final int DT_RPATH = 15;
		public static final int DT_SYMBOLIC = 16;
		public static final int DT_REL = 17;
		public static final int DT_RELSZ = 18;
		public static final int DT_RELENT = 19;
		public static final int DT_PLTREL = 20;
		public static final int DT_DEBUG = 21;
		public static final int DT_TEXTREL = 22;
		public static final int DT_JMPREL = 23;
		public static final int DT_INIT_ARRAY = 0x19;
		public static final int DT_FINI_ARRAY = 0x1a;
		public static final int DT_INIT_ARRAYSZ = 0x1b;
		public static final int DT_FINI_ARRAYSZ = 0x1c;
		public static final int DT_RELCOUNT = 0x6ffffffa;
		public static final int DT_FLAGS_1 = 0x6ffffffb;
		public static final int DT_FLAGS = 0x1e;
		public static final int DT_LOOS = 0x6000000d;
		public static final int DT_ANDROID_REL = DT_LOOS + 2;
		public static final int DT_ANDROID_RELSZ = DT_LOOS + 3;

		public static final int DT_GNU_HASH = 0x6ffffef5;
		public static final int DT_LOPROC = 0x70000000;
		public static final int DT_HIPROC = 0x7fffffff;
	}

	public static class DT_RelType {

		public static final int R_ARM_NONE = 0; /* No reloc */
		public static final int R_ARM_PC24 = 1; /* PC relative 26 bit branch */
		public static final int R_ARM_ABS32 = 2; /* Direct 32 bit */
		public static final int R_ARM_REL32 = 3; /* PC relative 32 bit */
		public static final int R_ARM_PC13 = 4;
		public static final int R_ARM_ABS16 = 5; /* Direct 16 bit */
		public static final int R_ARM_ABS12 = 6; /* Direct 12 bit */
		public static final int R_ARM_THM_ABS5 = 7;
		public static final int R_ARM_ABS8 = 8; /* Direct 8 bit */
		public static final int R_ARM_SBREL32 = 9;
		public static final int R_ARM_THM_PC22 = 10;
		public static final int R_ARM_THM_PC8 = 11;
		public static final int R_ARM_AMP_VCALL9 = 12;
		public static final int R_ARM_SWI24 = 13; /*
													 * Obsolete static
													 * relocation.
													 */
		public static final int R_ARM_TLS_DESC = 13; /* Dynamic relocation. */
		public static final int R_ARM_THM_SWI8 = 14;
		public static final int R_ARM_XPC25 = 15;
		public static final int R_ARM_THM_XPC22 = 16;
		public static final int R_ARM_TLS_DTPMOD32 = 17; /*
															 * ID of module
															 * containing symbol
															 */
		public static final int R_ARM_TLS_DTPOFF32 = 18; /*
															 * Offset in TLS
															 * block
															 */
		public static final int R_ARM_TLS_TPOFF32 = 19; /*
														 * Offset in static TLS
														 * block
														 */
		public static final int R_ARM_COPY = 20; /* Copy symbol at runtime */
		public static final int R_ARM_GLOB_DAT = 21; /* Create GOT entry */
		public static final int R_ARM_JUMP_SLOT = 22; /* Create PLT entry */
		public static final int R_ARM_RELATIVE = 23; /*
														 * Adjust by program
														 * base
														 */
		public static final int R_ARM_GOTOFF = 24; /* 32 bit offset to GOT */
		public static final int R_ARM_GOTPC = 25; /*
													 * 32 bit PC relative offset
													 * to GOT
													 */
		public static final int R_ARM_GOT32 = 26; /* 32 bit GOT entry */
		public static final int R_ARM_PLT32 = 27; /* 32 bit PLT address */
		public static final int R_ARM_ALU_PCREL_7_0 = 32;
		public static final int R_ARM_ALU_PCREL_15_8 = 33;
		public static final int R_ARM_ALU_PCREL_23_15 = 34;
		public static final int R_ARM_LDR_SBREL_11_0 = 35;
		public static final int R_ARM_ALU_SBREL_19_12 = 36;
		public static final int R_ARM_ALU_SBREL_27_20 = 37;
		public static final int R_ARM_TLS_GOTDESC = 90;
		public static final int R_ARM_TLS_CALL = 91;
		public static final int R_ARM_TLS_DESCSEQ = 92;
		public static final int R_ARM_THM_TLS_CALL = 93;
		public static final int R_ARM_GNU_VTENTRY = 100;
		public static final int R_ARM_GNU_VTINHERIT = 101;
		public static final int R_ARM_THM_PC11 = 102; /*
														 * thumb unconditional
														 * branch
														 */
		public static final int R_ARM_THM_PC9 = 103; /*
														 * thumb conditional
														 * branch
														 */
		public static final int R_ARM_TLS_GD32 = 104; /*
														 * PC-rel 32 bit for
														 * global dynamic thread
														 * local data
														 */
		public static final int R_ARM_TLS_LDM32 = 105; /*
														 * PC-rel 32 bit for
														 * local dynamic thread
														 * local data
														 */
		public static final int R_ARM_TLS_LDO32 = 106; /*
														 * 32 bit offset
														 * relative to TLS block
														 */
		public static final int R_ARM_TLS_IE32 = 107; /*
														 * PC-rel 32 bit for GOT
														 * entry of static TLS
														 * block offset
														 */
		public static final int R_ARM_TLS_LE32 = 108; /*
														 * 32 bit offset
														 * relative to static
														 * TLS block
														 */
		public static final int R_ARM_THM_TLS_DESCSEQ = 129;
		public static final int R_ARM_IRELATIVE = 160;
		public static final int R_ARM_RXPC25 = 249;
		public static final int R_ARM_RSBREL32 = 250;
		public static final int R_ARM_THM_RPC22 = 251;
		public static final int R_ARM_RREL32 = 252;
		public static final int R_ARM_RABS22 = 253;
		public static final int R_ARM_RPC24 = 254;
		public static final int R_ARM_RBASE = 255;
		/* Keep this the last entry. */
		public static final int R_ARM_NUM = 256;

	}

	public static class STB_Info {
		public static final int STB_LOCAL = 0;
		public static final int STB_GLOBAL = 1;
		public static final int STB_WEAK = 2;
		public static final int STB_LOPROC = 13;
		public static final int STB_HIPROC = 15;
	}

	public static class ST_TYPE {
		public static final int STT_NOTYPE = 0;
		public static final int STT_OBJECT = 1;
		public static final int STT_FUNC = 2;
		public static final int STT_SECTION = 3;
		public static final int STT_FILE = 4;
		public static final int STT_LOPROC = 13;
		public static final int STT_HIPROC = 15;
	}

	public static class SHN_Info {
		public static final int SHN_UNDEF = 0;
		public static final int SHN_LORESERVE = 0xff00;
		public static final int SHN_LOPROC = 0xff00;
		public static final int SHN_HIPROC = 0xff1f;
		public static final int SHN_ABS = 0xfff1;
		public static final int SHN_COMMON = 0xfff2;
		public static final int SHN_HIRESERVE = 0xffff;
	}

}
