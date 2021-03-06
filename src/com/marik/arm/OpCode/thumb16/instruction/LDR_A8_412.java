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

public class LDR_A8_412 extends ParseSupport {

	public static final LDR_A8_412 INSTANCE = new LDR_A8_412();
	
	@Override
	protected String getOpCode() {
		return "LDR";
	}

	@Override
	protected String getRn(int data) {
		return parseRegister(getShiftInt(data, 0, 3));
	}

	@Override
	protected String getRm(int data) {
		return parseRegister(getShiftInt(data, 3, 3)) + " , "
				+ parseRegister(getShiftInt(data, 6, 3));
	}

	@Override
	protected boolean isRmMenory() {
		return true;
	}

	@Override
	public void performExecuteCommand(int data) {
	}

}
