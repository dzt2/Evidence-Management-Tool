package cn.edu.buaa.sei.logicAC.meta.common.var;

public interface LongVariable extends AtomicVariable{
	public void assign(Long val);
	public Long read();
}
