package cn.edu.buaa.sei.SVI.struct.group.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.SVI.struct.group.EnumerateGroup;

public class SetGroup implements EnumerateGroup{
	Set<Object> set = new HashSet<Object>();

	@Override
	public int size() {return this.set.size();}
	@Override
	public boolean contains(Object val) {return this.set.contains(val);}

	@Override
	public void add(Object obj) {this.set.add(obj);}
	@Override
	public void remove(Object obj) {this.set.remove(obj);}
	@Override
	public void addAll(EnumerateGroup grp) {
		if(grp==null)return;
		Iterator<Object> itor = grp.iterator();
		while(itor.hasNext())
			this.add(itor.next());
	}
	@Override
	public void removeAll(EnumerateGroup grp) {
		if(grp==null)return;
		Iterator<Object> itor = grp.iterator();
		while(itor.hasNext())
			this.remove(itor.next());
	}

	@Override
	public Iterator<Object> iterator() {return this.set.iterator();}
	
}
