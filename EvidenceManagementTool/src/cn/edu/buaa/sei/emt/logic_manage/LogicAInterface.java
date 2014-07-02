package cn.edu.buaa.sei.emt.logic_manage;

import java.util.List;

import cn.edu.buaa.sei.emt.logic.AtLeastQuantification;
import cn.edu.buaa.sei.emt.logic.AtMostQuantification;
import cn.edu.buaa.sei.emt.logic.AtomicLogicFormulation;
import cn.edu.buaa.sei.emt.logic.Conjunction;
import cn.edu.buaa.sei.emt.logic.Disjunction;
import cn.edu.buaa.sei.emt.logic.Equivalence;
import cn.edu.buaa.sei.emt.logic.ExclusiveDisjunction;
import cn.edu.buaa.sei.emt.logic.ExistentialQuantification;
import cn.edu.buaa.sei.emt.logic.Implication;
import cn.edu.buaa.sei.emt.logic.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.LogicOperation;
import cn.edu.buaa.sei.emt.logic.NAND;
import cn.edu.buaa.sei.emt.logic.NOR;
import cn.edu.buaa.sei.emt.logic.Negation;
import cn.edu.buaa.sei.emt.logic.NumbericRangeQuantification;
import cn.edu.buaa.sei.emt.logic.PredicateFormulation;
import cn.edu.buaa.sei.emt.logic.PropositionVariable;
import cn.edu.buaa.sei.emt.logic.Quantification;
import cn.edu.buaa.sei.emt.logic.UniversalQuantification;
import cn.edu.buaa.sei.emt.logic.Variable;

public class LogicAInterface {
	public static String printFormulation(LogicFormulation formulation){
		if(formulation==null)return null;
		
		if(formulation instanceof LogicOperation){
			if(formulation instanceof Negation){
				Negation n = (Negation) formulation;
				return "Not ("+printFormulation(n.getFormulation())+")";
			}
			else if(formulation instanceof Conjunction){
				Conjunction c = (Conjunction) formulation;
				List<LogicFormulation> arguments = c.getOperators();
				StringBuilder res = new StringBuilder();
				res.append("(");
				for(int i=0;i<arguments.size();i++){
					LogicFormulation arg = arguments.get(i);
					if(arg==null)continue;
					res.append(printFormulation(arg));
					if(i<arguments.size()-1)
						res.append("&");
				}
				res.append(")");
				return res.toString();
			}
			else if(formulation instanceof Disjunction){
				Disjunction d = (Disjunction) formulation;
				List<LogicFormulation> arguments = d.getOperators();
				StringBuilder res = new StringBuilder();
				res.append("(");
				for(int i=0;i<arguments.size();i++){
					LogicFormulation arg = arguments.get(i);
					if(arg==null)continue;
					res.append(printFormulation(arg));
					if(i<arguments.size()-1)
						res.append("|");
				}
				res.append(")");
				return res.toString();
			}
			else if(formulation instanceof ExclusiveDisjunction){
				ExclusiveDisjunction d = (ExclusiveDisjunction) formulation;
				LogicFormulation op1 = d.getOp1();
				LogicFormulation op2 = d.getOp2();
				
				return "("+printFormulation(op1)+" ~ "+printFormulation(op2)+")";
			}
			else if(formulation instanceof Equivalence){
				Equivalence d = (Equivalence) formulation;
				LogicFormulation op1 = d.getOp1();
				LogicFormulation op2 = d.getOp2();
				
				return "("+printFormulation(op1)+" <--> "+printFormulation(op2)+")";
			}
			else if(formulation instanceof Implication){
				Implication i = (Implication) formulation;
				LogicFormulation pre = i.getAntecedent();
				LogicFormulation con = i.getConsequent();
				
				return "("+printFormulation(pre)+" --> "+printFormulation(con)+")";
			}
			else if(formulation instanceof NAND){
				NAND d = (NAND) formulation;
				LogicFormulation op1 = d.getOp1();
				LogicFormulation op2 = d.getOp2();
				
				return "("+printFormulation(op1)+" NAND "+printFormulation(op2)+")";
			}
			else if(formulation instanceof NOR){
				NOR d = (NOR) formulation;
				LogicFormulation op1 = d.getOp1();
				LogicFormulation op2 = d.getOp2();
				
				return "("+printFormulation(op1)+" NOR "+printFormulation(op2)+")";
			}
		}
		else if(formulation instanceof Quantification){
			Quantification q = (Quantification) formulation;
			String code = null;
			if(q instanceof UniversalQuantification){
				code = "Any";
			}
			else if(q instanceof ExistentialQuantification)
				code = "Exist";
			else if(q instanceof AtMostQuantification)
				code = "At most "+((AtMostQuantification)q).getUpper_bound();
			else if(q instanceof AtLeastQuantification){
				code = "At least "+((AtLeastQuantification)q).getLower_bound();
			}
			else if(q instanceof NumbericRangeQuantification){
				NumbericRangeQuantification nq = (NumbericRangeQuantification) q;
				int low = nq.getLower_bound();
				int up = nq.getUpper_bound();
				
				code = "At least "+low+" and at most "+up;
			}
			if(code == null)return null;
			else return "("+code+q.getVariable().getName()+", "+printFormulation(q.getScope())+":-"+q.getDomain().getName()+")";
		}
		else if(formulation instanceof AtomicLogicFormulation){
			if(formulation instanceof PropositionVariable){
				PropositionVariable var = (PropositionVariable) formulation;
				return var.getName();
			}
			else if(formulation instanceof PredicateFormulation){
				PredicateFormulation pre = (PredicateFormulation) formulation;
				StringBuilder res = new StringBuilder();
				
				res.append(pre.getName()).append("(");
				for(int i=0;i<pre.getArguments().size();i++){
					Variable var = pre.getArguments().get(i);
					if(var==null)continue;
					res.append(var.getName());
					
					if(i<pre.getArguments().size()-1)
						res.append(", ");
				}
				res.append(")");
				
				return res.toString();
			}
		}
		return null;
	}

	
	
	
	
	
	
	
	
}
