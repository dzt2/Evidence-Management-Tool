package cn.edu.buaa.sei.exLmf.schema.impl;

import java.io.OutputStream;

import cn.edu.buaa.sei.exLmf.manager.IObjectSpace;
import cn.edu.buaa.sei.exLmf.schema.IObjectWriter;

public class XMLObjectWriter implements IObjectWriter{
	OutputStream out;
	IObjectSpace os;
	String name;
	
	public XMLObjectWriter(String name){this.name=name;}
	

	@Override
	public void setOutputStream(OutputStream out) {this.out=out;}
	@Override
	public void setObjectSpace(IObjectSpace os) {this.os=os;}
	@Override
	public boolean validate() {return (this.os!=null)&&(this.out!=null);}

	@Override
	public void translate() throws Exception {
		
	}

}
