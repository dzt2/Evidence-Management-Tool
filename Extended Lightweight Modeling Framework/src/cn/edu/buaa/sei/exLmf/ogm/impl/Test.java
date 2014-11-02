package cn.edu.buaa.sei.exLmf.ogm.impl;

public class Test {

	public static void main(String[] args) {
		String str="www.baidu.com.cn";
		String[] cols = str.split("\\.");
		System.out.println(cols.length);
		for(int i=0;i<cols.length;i++)
			System.out.println(cols[i]);
	}

}
