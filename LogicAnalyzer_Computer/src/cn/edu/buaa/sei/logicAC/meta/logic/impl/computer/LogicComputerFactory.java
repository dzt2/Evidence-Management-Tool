package cn.edu.buaa.sei.logicAC.meta.logic.impl.computer;

import cn.edu.buaa.sei.logicAC.meta.logic.computer.SequenceLogicComputer;

public class LogicComputerFactory {
	public static SequenceLogicComputer createSequenceLogicComputer(){return new SequenceLogicComputerImpl();}
}
