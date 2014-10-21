package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface InterpreterRegisterMachine {
	public StructClassLib getStructClassLibrary();
	public InterpreterClassLib getInterpreterClassLibrary();
	public StructInterpreterClassLinker getLinker();
	
	/**
	 * Loading the register map from a given resource {.i file(xml)|database}
	 * */
	public void loadRegisterMap(SVIResource resource) throws Exception;
	/**
	 * Return Interpreter of a given Struct whose class has been linked {registered} with it.
	 * */
	public Interpreter getInterpreter(Struct element) throws Exception;
	/**
	 * Return Interpreter of a given Struct class which has been linked {registered} with it.
	 * */
	@SuppressWarnings("rawtypes")
	public Interpreter getInterpreter(Class stype) throws Exception;
}
