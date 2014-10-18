package cn.edu.buaa.sei.SVI.interpreter.group.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.edu.buaa.sei.SVI.interpreter.group.GroupInterpreter;
import cn.edu.buaa.sei.SVI.interpreter.group.UnionInterpreter;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.core.function.impl.FunctionBodyAPIImpl;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.core.variable.impl.VariableFactory;
import cn.edu.buaa.sei.SVI.struct.group.AbstractGroup;
import cn.edu.buaa.sei.SVI.struct.group.Group;
import cn.edu.buaa.sei.SVI.struct.group.Union;
import cn.edu.buaa.sei.SVI.struct.group.impl.ConditionGroup;
import cn.edu.buaa.sei.SVI.struct.group.impl.SetGroup;
import cn.edu.buaa.sei.SVI.struct.logic.Disjunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicExpression;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunction;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.SVI.struct.logic.impl.LogicFactory;

public class UnionInterpreterImpl implements UnionInterpreter{

	@Override
	public Group interpret(GroupStruct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof Union))throw new Exception("Union required");
		
		Union op = (Union) input;
		return this.interpret(op);
	}

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof Union))throw new Exception("Union required");
		
		Union op = (Union) input;
		return this.interpret(op);
	}

	@Override
	public Group interpret(Union op) throws Exception {
		if(op==null)throw new Exception("Null operator is invalid");
		
		GroupStruct[] operands = op.getOperands();
		if(operands==null||operands.length<2)
			throw new Exception("Structure Error: at least 2 operands");
		
		List<AbstractGroup> alist = new ArrayList<AbstractGroup>();
		List<Group> blist = new ArrayList<Group>();
		
		for(int i=0;i<operands.length;i++){
			GroupInterpreter interpreter = (GroupInterpreter) register.get(operands[i]);
			Group group = interpreter.interpret(operands[i]);
			
			if(group==null)
				throw new Exception("operands["+i+"] interpretation failed: "+operands[i].hashCode());
			
			if(i==0)blist.add(group);
			else if(group instanceof AbstractGroup)alist.add((AbstractGroup) group);
			else blist.add(group);
		}
		
		Group domain = this.mergeAll(blist);
		
		if(alist.isEmpty())return domain;
		else{
			LogicFunctionTemplate template = LogicFactory.createLogicFunctionTemplate("pand", 
					new Variable[]{VariableFactory.createFreeVariable("x")});
			LogicFunction function = LogicFactory.createLogicFunction(template);
			
			final LogicStruct[] ops = new LogicStruct[alist.size()];
			for(int i=0;i<alist.size();i++)
				ops[i]=alist.get(i).getCondition();
			
			function.setBody(new FunctionBodyAPIImpl(){
				LogicExpression expr = LogicFactory.createDisjunction(ops);
				@Override
				public void execute() throws Exception {
					Object val = this.getFunction().getTemplate().getArguments()[0];
					
					Disjunction op = (Disjunction) expr.getOperator();
					LogicStruct[] operands = op.getOperands();
					for(int i=0;i<operands.length;i++){
						LogicFunction fi = (LogicFunction) operands[i];
						fi.getTemplate().getArguments()[0].assign(val);
					}
					
					Inferencer inferencer = (Inferencer) register.get(expr);
					Boolean result = inferencer.interpret(expr);
					
					this.getFunction().getTemplate().getOutput().assign(result);
				}});
			
			return new ConditionGroup(function,domain);
		}
	}
	
	protected Group merge(Group a,Group b){
		if(a==null||b==null)return null;
		
		if(a.size()==0)return b;
		else if(b.size()==0)return a;
		else{
			Group c = new SetGroup();
			
			c.addAll(a);
			c.addAll(b);
			
			return c;
		}
	}
	protected Group mergeAll(List<Group> list){
		if(list==null)return null;
		
		Queue<Group> qlist = new LinkedList<Group>();
		for(int i=0;i<list.size();i++)
			qlist.add(list.get(i));
		
		while(!qlist.isEmpty()){
			if(qlist.size()==1)return qlist.poll();
			
			Group a = qlist.poll();
			Group b = qlist.poll();
			Group c = this.merge(a, b);
			
			if(c==null)
				try {
					throw new Exception("Merge exception happened: {"+a.hashCode()+"} + {"+b.hashCode()+"}");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			qlist.add(c);
		}
		return new SetGroup();
	}

}
