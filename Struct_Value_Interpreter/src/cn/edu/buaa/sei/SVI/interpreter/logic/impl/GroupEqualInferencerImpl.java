package cn.edu.buaa.sei.SVI.interpreter.logic.impl;

import java.util.Iterator;

import cn.edu.buaa.sei.SVI.interpreter.group.GroupInterpreter;
import cn.edu.buaa.sei.SVI.interpreter.logic.GroupEqualInferencer;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.extend.GroupStruct;
import cn.edu.buaa.sei.SVI.struct.core.extend.LogicStruct;
import cn.edu.buaa.sei.SVI.struct.group.EnumerateGroup;
import cn.edu.buaa.sei.SVI.struct.group.Group;
import cn.edu.buaa.sei.SVI.struct.group.GroupEqual;

public class GroupEqualInferencerImpl implements GroupEqualInferencer{

	@Override
	public Boolean interpret(LogicStruct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof GroupEqual))throw new Exception("GroupEqual required");
		GroupEqual op = (GroupEqual) input;
		return this.interpret(op);
	}

	@Override
	public Object interpret(Struct input) throws Exception {
		if(input==null)throw new Exception("Null input is invalid");
		if(!(input instanceof GroupEqual))throw new Exception("GroupEqual required");
		GroupEqual op = (GroupEqual) input;
		return this.interpret(op);
	}

	@Override
	public Boolean interpret(GroupEqual op) throws Exception {
		if(op==null)
			throw new Exception("Null operator is invalid");
		
		GroupStruct x = op.getLeftOperand();
		GroupStruct y = op.getRightOperand();
		
		if(x==null||y==null)
			throw new Exception("Structure Error: null operands");
		
		GroupInterpreter xi = (GroupInterpreter) register.get(x);
		GroupInterpreter yi = (GroupInterpreter) register.get(y);
		
		if(xi==null)
			throw new Exception("Left operand: "+x.getClass().getCanonicalName()+" has not been registered");
		if(yi==null)
			throw new Exception("Right operand: "+y.getClass().getCanonicalName()+" has not been registered");
		
		Group xv = xi.interpret(x);
		Group yv = yi.interpret(y);
		
		if(xv==null||yv==null)return null;
		
		Boolean r1 = this.contain(xv, yv);
		if(r1==null)return null;
		else if(!r1)return false;
		else{
			Boolean r2 = this.contain(yv, xv);
			return r2;
		}
	}
	
	/**
	 * Return whether B contains A
	 * */
	Boolean contain(Group A,Group B){
		if(A instanceof EnumerateGroup){
			Iterator<Object> itor = ((EnumerateGroup) A).iterator();
			while(itor.hasNext()){
				if(!B.contains(itor.next()))
					return false;
			}
			return true;
		}
		else{
			return null;
		}
	}
}
