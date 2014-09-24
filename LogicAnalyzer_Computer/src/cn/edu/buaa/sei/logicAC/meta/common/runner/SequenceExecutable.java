package cn.edu.buaa.sei.logicAC.meta.common.runner;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.common.core.Executable;

public interface SequenceExecutable extends Executable{
	public Computable executeOne() throws Exception;
	public boolean hasNext();
}
