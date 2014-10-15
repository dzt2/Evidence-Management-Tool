package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import cn.edu.buaa.sei.SVI.interpreter.core.IterationInterpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.RegisterMachine;

/**
 * IterationInterpreterImpl is an important class to provide register machine for its subclasses.
 * */
public abstract class IterationInterpreterImpl implements IterationInterpreter{
	/**
	 * Return the register machine for selecting interpreter for each depended Structs.
	 * */
	@Override
	public RegisterMachine getRegisterMachine() {return RegisterMachineImpl.machine;}
}
