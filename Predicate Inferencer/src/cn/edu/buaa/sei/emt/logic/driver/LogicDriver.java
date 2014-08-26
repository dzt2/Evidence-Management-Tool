package cn.edu.buaa.sei.emt.logic.driver;

import java.io.InputStream;

public class LogicDriver {
	private InputStream def_in;
	private InputStream val_in;
	
	
	
	
	public InputStream getDef_in() {
		return def_in;
	}
	public void setDef_in(InputStream def_in) {
		this.def_in = def_in;
	}
	public InputStream getVal_in() {
		return val_in;
	}
	public void setVal_in(InputStream val_in) {
		this.val_in = val_in;
	}
}
