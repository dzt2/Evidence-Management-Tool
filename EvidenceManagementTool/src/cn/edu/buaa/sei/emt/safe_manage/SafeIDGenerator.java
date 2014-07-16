package cn.edu.buaa.sei.emt.safe_manage;

import java.util.Calendar;

import cn.edu.buaa.sei.emt.core.ModelElement;


public class SafeIDGenerator {
	/*Perhaps unused ... */
	public String getID(ModelElement elm){
		if(elm==null)return null;
		return elm.type().getFullName()+":"+elm.hashCode()+":"+Calendar.getInstance().getTimeInMillis();
	}
}
