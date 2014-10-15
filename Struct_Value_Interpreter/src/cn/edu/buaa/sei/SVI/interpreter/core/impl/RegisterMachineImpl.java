package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import java.util.HashMap;
import java.util.Map;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.RegisterMachine;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class RegisterMachineImpl implements RegisterMachine{
	static RegisterMachine machine=new RegisterMachineImpl();
	
	Map<Class<Struct>,Class<Interpreter>> map = 
			new HashMap<Class<Struct>,Class<Interpreter>>();

	private RegisterMachineImpl(){}
	
	public static RegisterMachine create(){return machine;}
	
	@Override
	public synchronized void register(Class<Struct> type, Class<Interpreter> iType)
			throws Exception {
		if(type==null||iType==null)
			throw new Exception("Null Type cannot be binded with each other");
		
		try{
			iType.newInstance();
		}
		catch(Exception ex){
			throw new Exception(iType.getName()+" cannot generate any objects");
		}
		
		this.map.put(type, iType);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public synchronized Interpreter get(Struct element) throws Exception {
		if(element==null)
			throw new Exception("Null element cannot be interpreted");
		
		Class type = element.getClass();
		while(type!=null&&!this.map.containsKey(type)){
			Class[] interfaces = type.getInterfaces();
			if(interfaces!=null){
				for(int i=0;i<interfaces.length;i++){
					if(this.map.containsKey(interfaces[i]))
						return this.map.get(interfaces[i]).newInstance();
				}
			}
			type = type.getSuperclass();
		}
		
		if(type==null)
			throw new Exception(element.getClass().getName()+" has not been registered");
		else{
			return this.map.get(type).newInstance();
		}
	}

	@Override
	public synchronized boolean isRegistered(Struct element) {
		if(element==null)return false;
		else return this.map.containsKey(element.getClass());
	}

	@Override
	public synchronized void logoff(Class<Struct> type) {
		if(this.map.containsKey(type))
			this.map.remove(type);
	}
}
