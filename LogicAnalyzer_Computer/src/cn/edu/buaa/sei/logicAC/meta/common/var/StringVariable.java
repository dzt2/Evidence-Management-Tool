package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface StringVariable extends AtomicVariable{
	public String read();
	public void assign(String val);
}
