package cn.edu.buaa.sei.SVI.manage;

import cn.edu.buaa.sei.SVI.struct.core.Struct;

public interface IStructSearcher {
	public Struct get(Struct base,String path) throws Exception;
}
