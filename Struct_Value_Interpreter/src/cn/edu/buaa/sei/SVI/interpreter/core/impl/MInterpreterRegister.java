package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.InterpreterRegister;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

public class MInterpreterRegister implements InterpreterRegister{
	@SuppressWarnings("rawtypes")
	Queue<Class> types = new LinkedList<Class>();
	
	@SuppressWarnings("rawtypes")
	Map<Class,Class> map = 
			new HashMap<Class,Class>();

	public static InterpreterRegister register = new MInterpreterRegister();
	public static InterpreterRegister create(){return register;}
	
	private MInterpreterRegister(){}
	
	/**
	 * Bind Struct with a type of Interpreter.
	 * @exception Exception type==null||iType==null;
	 * @exception Exception iType.isInstanceable == false;
	 * */
	@SuppressWarnings("rawtypes")
	public synchronized void register(Class type,Class iType) throws Exception{
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
	/**
	 * Return an Interpreter for interpreting the given Struct.
	 * @exception Exception struct has not been binded with any interpreter.
	 * @exception Exception element==null
	 * */
	@SuppressWarnings("rawtypes")
	public synchronized Interpreter get(Struct element) throws Exception{
		if(element==null)
			throw new Exception("Null element cannot be interpreted");
		
		Class type = element.getClass();
		this.types.clear();
		this.types.add(type);
		
		while(!this.types.isEmpty()){
			type = this.types.poll();
			if(type==null)continue;
			
			if(this.map.containsKey(type))return (Interpreter) this.map.get(type).newInstance();
			else{
				this.types.add(type.getSuperclass());
				Class[] interfaces = type.getInterfaces();
				if(interfaces!=null)
					for(int i=0;i<interfaces.length;i++)
						this.types.add(interfaces[i]);
			}
		}
		/*while(type!=null&&!this.map.containsKey(type)){
			Class[] interfaces = type.getInterfaces();
			if(interfaces!=null){
				for(int i=0;i<interfaces.length;i++){
					if(this.map.containsKey(interfaces[i]))
						return this.map.get(interfaces[i]);
				}
			}
			type = type.getSuperclass();
		}*/
		
		if(type==null)
			throw new Exception(element.getClass().getName()+" has not been registered");
		else{
			return (Interpreter) this.map.get(type).newInstance();
		}
	}
	/**
	 * Return whether a given element has been binded with Interpreter.
	 * */
	public synchronized boolean isRegistered(Struct element){
		if(element==null)return false;
		else return this.map.containsKey(element.getClass());
	}
	/**
	 * Logoff a given Struct and its binded interpreter.
	 * */
	@SuppressWarnings("rawtypes")
	public synchronized void logoff(Class type){
		if(this.map.containsKey(type))
			this.map.remove(type);
	}
}
