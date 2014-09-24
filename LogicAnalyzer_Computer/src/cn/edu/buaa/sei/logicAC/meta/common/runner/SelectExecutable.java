package cn.edu.buaa.sei.logicAC.meta.common.runner;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.core.Executable;

public interface SelectExecutable extends Executable{
	public Computable execute(int i) throws Exception;
	public int size();
}
