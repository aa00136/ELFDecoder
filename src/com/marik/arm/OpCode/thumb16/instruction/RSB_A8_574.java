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

public class RSB_A8_574 extends ParseSupport {

	public static final RSB_A8_574 INSTANCE = new RSB_A8_574();

	@Override
	protected String getOpCode() {
		return "RSBS";
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