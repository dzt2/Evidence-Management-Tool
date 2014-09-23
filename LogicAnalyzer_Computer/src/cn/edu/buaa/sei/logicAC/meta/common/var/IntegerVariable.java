package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface IntegerVariable extends AtomicVariable{
	public Integer read();
	public void assign(Integer val);
}
