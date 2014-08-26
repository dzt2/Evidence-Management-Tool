package cn.edu.buaa.sei.emt.logic.script;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.sei.emt.logic.predicate.core.LogicFormulationTypeLoader;
import cn.edu.buaa.sei.emt.logic.predicate.core.Value;
import cn.edu.buaa.sei.lmf.LMFContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LMFContext.load(new LogicFormulationTypeLoader());
		LMFContext.pack();
		
		File file = new File("assign.txt");
		String text = read(file);
		System.out.println(text);
		
		ValueAnalyzer analyzer = new ValueAnalyzerImpl("ANALYZER_I");
		try {
			analyzer.input(text);
			List<ValueUnit> units = analyzer.analyze();
			for(int i=0;i<units.size();i++){
				System.out.println(units.get(i).toString());
			}
			
			System.out.println("\n\n");
			
			ValueProcesser processer = new ValueProcesserImpl("PROCESSER_I",new ValueInterpreterImpl("INTERPRETER"));
			processer.appendUnitList(units);
			Map<String,Value> map=processer.compile();
			
			for(String name:map.keySet()){
				System.out.println(name+": "+map.get(name).type().getSimpleName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static String read(File file){
		try {
			DataInputStream din = new DataInputStream(new FileInputStream(file));
			
			StringBuilder text= new StringBuilder();
			String line = null;
			
			while((line=din.readLine())!=null){
				text.append(line).append("\n");
			}
			din.close();
			
			return text.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
