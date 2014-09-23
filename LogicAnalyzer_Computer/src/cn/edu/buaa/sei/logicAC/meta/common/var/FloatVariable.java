package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface FloatVariable extends AtomicVariable{
	public void assign(Float val);
	public Float read();
}
