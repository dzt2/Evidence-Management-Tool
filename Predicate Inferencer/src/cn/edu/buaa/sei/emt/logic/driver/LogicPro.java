package cn.edu.buaa.sei.emt.logic.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cn.edu.buaa.sei.emt.logic.computer.IMachine_Iterater;
import cn.edu.buaa.sei.emt.logic.computer.InferenceMachine;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;

public class LogicPro {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		if(args.length!=4){
			System.err.println("Format errors: IM def_file value_file target_name");
			return;
		}
		
		File def_file = new File(args[1]);
		File val_file = new File(args[2]);
		
		LogicDriver driver = new LogicDriver("IM_II");
		try {
			driver.setDef_in(new FileInputStream(def_file));
			driver.setVal_in(new FileInputStream(val_file));
			driver.reconfig();
			LogicFormulation target = driver.getTarget(args[3]);
			
			InferenceMachine im = new IMachine_Iterater("IM_II");
			im.setFormulation(target);
			Boolean res = im.safeInference();
			
			System.out.println("Inference Result: "+res);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
