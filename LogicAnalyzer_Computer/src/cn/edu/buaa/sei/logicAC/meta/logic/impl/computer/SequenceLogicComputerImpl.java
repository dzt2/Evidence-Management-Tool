package cn.edu.buaa.sei.logicAC.meta.logic.impl.computer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import cn.edu.buaa.sei.logicAC.meta.common.core.Computable;
import cn.edu.buaa.sei.logicAC.meta.logic.common.LogicFormulation;
import cn.edu.buaa.sei.logicAC.meta.logic.computer.LogicComputerUnit;
import cn.edu.buaa.sei.logicAC.meta.logic.computer.LogicComputerUnit.Compute_State;
import cn.edu.buaa.sei.logicAC.meta.logic.computer.SequenceLogicComputer;

public class SequenceLogicComputerImpl implements SequenceLogicComputer{
	
	Queue<LogicFormulation> tasks = new LinkedList<LogicFormulation>();
	LogicComputerUnit unit = new LogicComputerUnit_R();

	@Override
	public void setTasks(LogicFormulation[] tasks) throws Exception {
		if(tasks==null)
			throw new Exception("Null task list is invalid null.");
		
		this.tasks.clear();
		for(int i=0;i<tasks.length;i++)
			if(tasks[i]!=null)
				this.tasks.add(tasks[i]);
		
	}

	@Override
	public LogicFormulation[] getTasks() {
		LogicFormulation[] tasks = new LogicFormulation[this.tasks.size()];
		
		Iterator<LogicFormulation> itor = this.tasks.iterator();
		int k=0;
		while(itor.hasNext())
			tasks[k++]=itor.next();
		
		return tasks;
	}

	@Override
	public void setTasks(Computable[] tasks) throws Exception {
		if(tasks==null)
			throw new Exception("Null task list is invalid null.");
		
		this.tasks.clear();
		for(int i=0;i<tasks.length;i++)
			if(tasks[i]!=null&&tasks[i] instanceof LogicFormulation)
				this.tasks.add((LogicFormulation) tasks[i]);
	}

	@Override
	public void clear() throws Exception {this.tasks.clear();}

	@Override
	public boolean hasNext() {return !this.tasks.isEmpty();}

	@Override
	public LogicFormulation executeOne() throws Exception {
		if(!this.hasNext())throw new Exception("No next task");
		
		LogicFormulation x = this.tasks.poll();
		System.out.println("Start to compute: "+x.hashCode());
		Compute_State state = this.unit.compute(x);
		if(state!=Compute_State.COMPUTABLE)
			System.err.println("Invalid Computation: "+state);
		return x;
	}

}
