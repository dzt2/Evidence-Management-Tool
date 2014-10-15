package cn.edu.buaa.sei.SVI.struct.group;

import java.util.Iterator;

public interface EnumerateGroup extends Group{
	public void add(Object obj);
	public void remove(Object obj);
	public void addAll(EnumerateGroup grp);
	
	Iterator<Object> iterator();
}
