package cn.edu.buaa.sei.emt.logic.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cn.edu.buaa.sei.emt.logic.computer.IMachine_Iterater;
import cn.edu.buaa.sei.emt.logic.io.AssignerProcesserImpl;
import cn.edu.buaa.sei.emt.logic.io.AssignerTextualAnalyzerImpl;
import cn.edu.buaa.sei.emt.logic.io.DefinitionTextualAnalyzer;
import cn.edu.buaa.sei.emt.logic.io.LogicSyntaxProcesser;
import cn.edu.buaa.sei.emt.logic.io.TextualValueInterpreter;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.lmf.LMFContext;

public class Test {
	public static void main(String[] args) throws Exception{
		if(args.length!=4){
			throw new Exception("Formation Errors: IM def_file assign_file target_name");
		}
		
		if(!args[0].equals("IM"))
			throw new Exception("Command Name must be \"IM\"");
		
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		StreamLogicMachine machine = new StreamLogicMachine("LM-I");
		
		machine.configDefinition(new DefinitionTextualAnalyzer("DEF_ANALYZER"), 
				new LogicSyntaxProcesser("DEF_PROCESSER"));
		machine.configAssigner(new AssignerTextualAnalyzerImpl("ASSIGN_ANALYZER"),
				new AssignerProcesserImpl("ASSIGN_PROCESSER"));
		machine.configInferencer(new IMachine_Iterater("INFERENCER_ITER"));
		machine.configValueInterpreter(new TextualValueInterpreter("VINTERPRETER_I"));
		
		try {
			machine.configDefinitionInput(new FileInputStream(args[1]));
			machine.configAssignmentInput(new FileInputStream(args[2]));
			
			String id = args[3];
			Boolean res = machine.compute(id);
			System.out.println("Inference Result: "+res);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
