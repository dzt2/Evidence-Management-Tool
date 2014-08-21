package cn.edu.buaa.sei.emt.logic.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.buaa.sei.emt.logic.predicate.core.Bindable;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.lmf.LMFContext;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		File file = new File("test.txt");
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			String line = null;
			StringBuilder text = new StringBuilder();
			while((line=in.readLine())!=null){
				text.append(line).append("\n");
			}
			in.close();
			//System.out.println("\n\n"+text.toString()+"\n\n");
			
			//System.out.println("Reading in:\n"+text.toString());
			
			TextualAnalyzer analyzer = new DefinitionTextualAnalyzer("Test_II");
			analyzer.setText(text.toString());
			List<LogicSyntaxUnit> units = analyzer.analysis();
			
			System.out.println("\nGenerating "+units.size()+" syntax unit.");
			for(int i=0;i<units.size();i++)
				System.out.println(units.get(i).toString());
			
			SyntaxProcesser processer = new LogicSyntaxProcesser("LogicCompiler");
			processer.appendUnits(units);
			System.out.println("\n\nImported Units: "+processer.size());
			
			Map<String,Object> var_map = processer.compile();
			Set<String> names = var_map.keySet();
			
			for(String name:names){
				Object value = var_map.get(name);
				if(value instanceof Bindable){
					System.out.println(name+": "+((Bindable)value).type().getSimpleName());
				}
				else if(value instanceof LogicFormulation)
					System.out.println(name+": "+((LogicFormulation)value).type().getSimpleName());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
