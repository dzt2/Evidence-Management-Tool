package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface BooleanVariable extends AtomicVariable{
	public Boolean read();
	public void assign(Boolean val);
}
