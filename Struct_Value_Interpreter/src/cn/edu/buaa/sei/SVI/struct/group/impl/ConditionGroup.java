package cn.edu.buaa.sei.SVI.struct.group.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.buaa.sei.SVI.interpreter.core.Interpreter;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.group.AbstractGroup;
import cn.edu.buaa.sei.SVI.struct.group.Group;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class ConditionGroup implements AbstractGroup{
	
	public static final int LOAD_DEPTH = 256;
	
	Group domain;
	LogicFunction function;
	Variable variable;
	Inferencer inferencer;
	
	Set<Object> cache;
	
	public ConditionGroup(LogicFunction condition,Group domain)throws Exception{
		if(function==null||domain==null)
			throw new Exception("Null Function|Domain is invalid");
		
		LogicFunctionTemplate template = function.getTemplate();
		if(template==null)
			throw new Exception("Structure Error: null template");
		
		if(template.getArguments()==null||template.getArguments().length!=1)
			throw new Exception("Invalid Template: P(x) required");
		
		this.function=condition;
		this.variable=template.getArguments()[0];
		this.domain=domain;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Boolean contains(Object val) {
		Boolean in = this.domain.contains(val);
		if(in==null||in==true){
			try{
				this.variable.assign(val);
				Boolean in2 = this.inferencer.interpret(function);
				if(in2==null)return null;
				else if(in2==true)return in;
				else return false;
			}catch(Exception ex){
				System.err.println(ex.getMessage());
				return null;
			}
		}
		else
			return false;
	}
	
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addAll(Group grp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeAll(Group grp) {
		
	}

	@Override
	public Iterator<Object> iterator() {
		try {
			this.load();
			if(this.cache!=null)
				return this.cache.iterator();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public LogicFunction getCondition() {return this.function;}
	@Override
	public Variable getVariable() {return this.variable;}
	@Override
	public Group getDomain() {return this.domain;}

	protected void load() throws Exception{
		LogicFunction[] conditions = new LogicFunction[LOAD_DEPTH];
		int k=0;
		conditions[k++]=this.getCondition();
		Group cur = this.domain;
		
		while(cur instanceof AbstractGroup){
			if(k>=LOAD_DEPTH)
				throw new Exception("Out of Limitation of Loading Depth: "+LOAD_DEPTH);
			
			conditions[k++]=((AbstractGroup)cur).getCondition();
			cur = ((AbstractGroup)cur).getDomain();
		}
		
		Iterator<Object> itor = cur.iterator();
		if(itor==null)
			throw new Exception("Interpretation for iterator of domain failed");
		
		LogicFunction[] cacheConditions = new LogicFunction[k];
		for(int i=0;i<k;i++)
			cacheConditions[i]=conditions[i];
		
		LogicExpression condition = LogicFactory.createConjunction(cacheConditions);
		
		Inferencer inferencer = (Inferencer) Interpreter.register.get(condition);
		if(inferencer==null)
			throw new Exception("Interpreter has not been registered: "+condition.getClass().getCanonicalName());
		
		this.cache = new HashSet<Object>();
		while(itor.hasNext()){
			Object val = itor.next();
			
			this.variable.assign(val);
			Boolean in = inferencer.interpret(function);
			if(in!=null&&in==true)
				this.cache.add(val);
		}
	}
	
}
