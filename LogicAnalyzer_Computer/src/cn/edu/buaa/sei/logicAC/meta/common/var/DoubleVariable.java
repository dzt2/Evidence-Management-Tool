package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface DoubleVariable extends AtomicVariable{
	public Double read();
	public void assign(Double val);
}
