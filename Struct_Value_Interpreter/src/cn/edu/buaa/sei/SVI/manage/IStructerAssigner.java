package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface IStructerAssigner {
	public void assign(Struct base,String path,Object value)throws Exception;
}
