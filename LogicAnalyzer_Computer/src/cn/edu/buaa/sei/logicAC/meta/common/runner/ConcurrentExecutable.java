package cn.edu.buaa.sei.logicAC.meta.common.runner;

import cn.edu.buaa.sei.logicAC.meta.common.core.Executable;

public interface ConcurrentExecutable extends Executable{
	public void execute() throws Exception;
}
