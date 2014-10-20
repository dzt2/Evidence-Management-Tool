package cn.edu.buaa.sei.SVI.interpreter.core.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.core.InterpreterRegister;
import cn.edu.buaa.sei.SVI.struct.core.Struct;

/**
 * SInterpreterRegister is an <b>Static Interpreter Register</b> for 
 * each type of element referring to only one interpreter, very 
 * good for iteration/sequence program (un-thread)
 * */
public class SInterpreterRegister implements InterpreterRegister{
	
	
	@SuppressWarnings("rawtypes")
	Queue<Class> types = new LinkedList<Class>();
	
	@SuppressWarnings("rawtypes")
	Map<Class,Interpreter> map = 
			new HashMap<Class,Interpreter>();

	public static InterpreterRegister register = new SInterpreterRegister();
	public static InterpreterRegister create(){return register;}
	
	private SInterpreterRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Bind Struct with a type of Interpreter.
	 * @exception Exception type==null||iType==null;
	 * @exception Exception iType.isInstanceable == false;
	 * */
	@SuppressWarnings("rawtypes")
	@Override
	public synchronized void register(Class type,Class iType) throws Exception{
		if(type==null||iType==null)
			throw new Exception("Null Type cannot be binded with each other");
		
		try{
			Interpreter interpreter = (Interpreter) iType.newInstance();
			this.map.put(type, interpreter);
		}
		catch(Exception ex){
			throw new Exception(iType.getName()+" cannot generate any objects {no arguments constructor}");
		}
	}
	/**
	 * Return an Interpreter for interpreting the given Struct.
	 * @exception Exception struct has not been binded with any interpreter.
	 * @exception Exception element==null
	 * */
	@Override
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
			
			if(this.map.containsKey(type))return this.map.get(type);
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
			return this.map.get(type);
		}
	}
	/**
	 * Return whether a given element has been binded with Interpreter.
	 * */
	@Override
	public synchronized boolean isRegistered(Struct element){
		if(element==null)return false;
		else return this.map.containsKey(element.getClass());
	}
	/**
	 * Logoff a given Struct and its binded interpreter.
	 * */
	@SuppressWarnings("rawtypes")
	@Override
	public synchronized void logoff(Class type){
		if(this.map.containsKey(type))
			this.map.remove(type);
	}
}
