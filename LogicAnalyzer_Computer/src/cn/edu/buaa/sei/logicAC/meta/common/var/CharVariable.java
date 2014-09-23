package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface CharVariable extends AtomicVariable{
	public Character read();
	public void assign(Character val);
}
