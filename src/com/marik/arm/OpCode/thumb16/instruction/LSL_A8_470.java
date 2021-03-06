/*-------------------------------
 Auto Generated By AutoGenetate.java
     Don't remove or modify
        License GPL/GNU
-------------------------------*/
package com.marik.arm.OpCode.thumb16.instruction;

import static com.marik.vm.OS.*;
import static com.marik.vm.Register.*;
import static com.marik.arm.OpCode.OpUtil.*;
import com.marik.arm.OpCode.thumb16.instruction.factory.ParseSupport;

public class LSL_A8_470 extends ParseSupport {

	public static final LSL_A8_470 INSTANCE = new LSL_A8_470();

	@Override
	protected String getOpCode() {
		return "LSLS";
	}
	@Override
	protected String getRn(int data) {
		return parseRegister(getShiftInt(data, 0, 3));
	}

	@Override
	protected String getRm(int data) {
		return parseRegister(getShiftInt(data, 3, 3));
	}
	@Override
	public void performExecuteCommand(int data) {
	}

}