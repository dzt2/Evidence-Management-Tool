package cn.edu.buaa.sei.logicAC.meta.common.impl.context;

import cn.edu.buaa.sei.logicAC.meta.common.context.GeneralParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.context.NormativeParameterList;
import cn.edu.buaa.sei.logicAC.meta.common.context.RunnerEnvironment;
import cn.edu.buaa.sei.logicAC.meta.common.context.VariablePool;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.ArrayContext;
import cn.edu.buaa.sei.logicAC.meta.common.impl.core.SetContext;
public class ContextFactory {
	public static final int ARRY_MODE = 0;
	public static final int SET_MODE = 1;
	
	public static VariablePool createVariablePool(int mode) throws Exception{
		switch(mode){
		case ARRY_MODE:return new ArrayVariablePool(new ArrayContext());
		case SET_MODE: return new ArrayVariablePool(new SetContext());
		default: throw new Exception("Unknown mode: "+mode);
		}
	}
	public static VariablePool createFastVariablePool(int mode) throws Exception{
		switch(mode){
		case ARRY_MODE:return new SetVariablePool(new ArrayContext());
		case SET_MODE: return new SetVariablePool(new SetContext());
		default: throw new Exception("Unknown mode: "+mode);
		}
	}
	public static NormativeParameterList createNormParameterList(int mode) throws Exception{
		switch(mode){
		case ARRY_MODE:return new ArrayParameterList(new ArrayContext());
		case SET_MODE: return new ArrayParameterList(new SetContext());
		default: throw new Exception("Unknown mode: "+mode);
		}
	}
	public static GeneralParameterList createGeneralParameterList(int mode) throws Exception{
		switch(mode){
		case ARRY_MODE:return new ListParameterList(new ArrayContext());
		case SET_MODE: return new ListParameterList(new SetContext());
		default: throw new Exception("Unknown mode: "+mode);
		}
	}
	public static RunnerEnvironment createRunnerEnvironment(int mode,RunnerEnvironment parent) throws Exception{
		switch(mode){
		case ARRY_MODE:return new MapRunnerEnvironment(new ArrayContext(),parent);
		case SET_MODE: return new MapRunnerEnvironment(new SetContext(),parent);
		default: throw new Exception("Unknown mode: "+mode);
		}
	}
}
