package cn.edu.buaa.sei.SVI.struct.group.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.SVI.struct.group.EnumerateGroup;

public class EnumerateGroupImpl implements EnumerateGroup{
	Set<Object> set = new HashSet<Object>();

	public EnumerateGroupImpl(){}
	
	@Override
	public int size() {return this.set.size();}
	@Override
	public boolean contains(Object val) {return this.set.contains(val);}
	
	@Override
	public void add(Object obj) {this.set.add(obj);}
	@Override
	public void remove(Object obj) {
		if(this.set.contains(obj))
			this.set.remove(obj);
	}
	@Override
	public void addAll(EnumerateGroup grp) {
		Iterator<Object> itor = grp.iterator();
		while(itor.hasNext())
			this.set.add(itor.next());
	}
	@Override
	public Iterator<Object> iterator() {return this.set.iterator();}

}
