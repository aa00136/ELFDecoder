package com.marik.arm.OpCode;

import static com.marik.arm.OpCode.OpUtil.*;

import com.marik.arm.OpCode.arm.instructionSet.factory.ConditionParseFactory;
import com.marik.arm.OpCode.arm.instructionSet.factory.UnConditionParseFactory;
import com.marik.arm.OpCode.thumb16.instruction.factory.ParseSupport;
import com.marik.arm.OpCode.thumb16.instructionSet.Thumb16Factory;
import com.marik.util.ByteUtil;

public class OpCode {

	public static String decode(byte[] data) {
		return decodeArm32(ByteUtil.bytes2Int32(data));
	}

	public static String decodeArm32(int data) {

		if (!assert1(data, 28, 29, 30, 31))
			return ConditionParseFactory.parseCondition(data);
		else
			return UnConditionParseFactory.parseUncondition(data);
	}

	public static ParseTemplate decodeThumb16(int data) {
		return Thumb16Factory.parse(data & 0xffff);
	}

	public static String decodeThumb32(int data) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println(decodeThumb16(0xbf0e).parse(0xbf0e));
	}

}
