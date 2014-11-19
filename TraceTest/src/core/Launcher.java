package core;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import cn.edu.buaa.sei.SVI.editor.treeNode.SVIEditorPanel;
import cn.edu.buaa.sei.SVI.interpreter.logic.Inferencer;
import cn.edu.buaa.sei.SVI.manage.IStructAssigner;
import cn.edu.buaa.sei.SVI.manage.InterpreterRegisterMachine;
import cn.edu.buaa.sei.SVI.manage.impl.SVIManageFactory;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.function.impl.FunctionExecutor;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;
import cn.edu.buaa.sei.SVI.struct.logic.LogicFunctionTemplate;
import cn.edu.buaa.sei.emt.exLmf.viewer.model.ExLMFEditorPane;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassObject;
import cn.edu.buaa.sei.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.ogm.IObjectWorld;


public class Launcher {
	
	final static InterpreterRegisterMachine rm = SVIManageFactory.getRegisterMachine();
	
	@SuppressWarnings("static-access")
	public static void MH(){
		try {
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.translucencyAppleLike;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		
		MH();
		
		final ExLMFEditorPane db_pan = new ExLMFEditorPane();
		final SVIEditorPanel svi_pan = new SVIEditorPanel();
		
		
		
		db_pan.setBorder(new TitledBorder("Model-based Data Manager"));
		svi_pan.setBorder(new TitledBorder("Logic Expression Editor"));
		
		JButton assign = new JButton("assign");
		assign.addActionListener(new ActionListener(){
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(db_pan.getModel()==null){
					JOptionPane.showMessageDialog(null, "Model has not been loaded", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(db_pan.getData()==null){
					JOptionPane.showMessageDialog(null, "Data has not been imported", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(svi_pan.getResult()==null||svi_pan.getResult().getTopStructs().isEmpty()){
					JOptionPane.showMessageDialog(null, "Expression has not been constructed", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(svi_pan.getResult().getTopStructs().size()!=1){
					JOptionPane.showMessageDialog(null, "Only 1 struct is required", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JFileChooser dialog = new JFileChooser(new File(getCurrentPath()));
				//JFileChooser dialog = new JFileChooser(new File("D:/java/eclipse model tool/rucm_workspace/TraceTest/"));
				int ret = dialog.showSaveDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					return;
				}
				
				File file = dialog.getSelectedFile();
				try {
					String class_name = getClassName(file);
					Class type = Class.forName(class_name);
					Object obj = type.newInstance();
					
					if(obj instanceof Assigner){
						Assigner a = (Assigner) obj;
						a.assign(db_pan.getModel(), db_pan.getData(), svi_pan.getResult().getTopStructs().iterator().next());
						JOptionPane.showMessageDialog(null,"Assign Successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else{
						JOptionPane.showMessageDialog(null,class_name+" is not inerited from Assigner.java", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				/*try {
					assign(db_pan.getModel(),db_pan.getData(),svi_pan.getResult().getTopStructs().iterator().next());
					JOptionPane.showMessageDialog(null, "Assignment complete!", "assign", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}*/
			}});
		JButton compute = new JButton("Computation");
		compute.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Struct top = svi_pan.getResult().getTopStructs().iterator().next();
				try {
					Inferencer inferencer = (Inferencer) rm.get(top);
					Boolean result = (Boolean) inferencer.interpret(top);
					JOptionPane.showMessageDialog(null, "Computation Result: "+result, "Result", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		JFrame f = new JFrame();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,2));
		pan.add(svi_pan);pan.add(db_pan);
		JPanel sp = new JPanel();
		sp.add(assign);sp.add(compute);
		
		BorderLayout frame = new BorderLayout();
		frame.setHgap(20);
		f.setLayout(frame);
		f.setTitle("DO178Logic");
		f.add(BorderLayout.CENTER,pan);
		f.add(BorderLayout.SOUTH,sp);
		
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@SuppressWarnings("deprecation")
	public static String getCurrentPath(){
		String path = URLDecoder.decode(Class.class.getResource("/").getPath());
		int k = path.lastIndexOf("/");
		path = path.substring(1, k).trim();
		k = path.lastIndexOf("/");
		path = path.substring(0, k).trim();
		return path+"/";
	}
	
	public static String getClassName(File file) throws Exception{
		if(file==null||file.isDirectory())throw new Exception("Null file is invalid");
		
		String path = file.getName().trim();
		if(!path.endsWith(".java"))throw new Exception(".java file is required");
		
		int k1 = path.lastIndexOf("\\")+1;
		int k2 = path.lastIndexOf(".");
		String class_name = path.substring(k1, k2).trim();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null; String pack_name = null;
		while((line=reader.readLine())!=null){
			line=line.trim();
			if(line.startsWith("package")){
				int k = line.lastIndexOf(";");
				pack_name = line.substring(7, k).trim();
			}
		}
		
		reader.close();
		if(pack_name==null)throw new Exception("Invalid java file: "+file.getAbsolutePath());
		
		return pack_name+"."+class_name;
	}
	
	public static void assign(LPackage model,IObjectWorld db,Struct top) throws Exception{
		if(model==null||db==null||top==null)throw new Exception("Null model|data|top is invalid");
		
		LClass HLRequirement = (LClass) model.getClassifierByName("HLRequirement");
		LClass LLRequirement = (LClass) model.getClassifierByName("LLRequirement");
		Set<LClassObject> hlrs = db.getObjectGroup(HLRequirement).getObjects();
		Set<LClassObject> llrs = db.getObjectGroup(LLRequirement).getObjects();
		
		IStructAssigner assigner = SVIManageFactory.createStructAssigner();
		assigner.assignByName(top, "HLR", hlrs, 0);
		assigner.assignByName(top, "LLR", llrs, 0);
		
		Function trace = assigner.getFunctionByName(top, "traceable", 0);
		assigner.assignFunction(trace, new FunctionExecutor(){
			@Override
			public void execute() throws Exception {
				LogicFunctionTemplate template = (LogicFunctionTemplate) this.getFunction().getTemplate();
				Variable hlr = template.getArguments()[0];
				Variable llr = template.getArguments()[1];
				LClassObject hobj = (LClassObject) hlr.read();
				LClassObject lobj = (LClassObject) llr.read();
				if(hobj==null||lobj==null)throw new Exception("Invalid arguments in traceable(hlr,llr)");
				
				LMultipleObject llrs = (LMultipleObject) hobj.get(hobj.getType().getFeatureByName("llrs"));
				Boolean res = llrs.containObject(lobj);
				template.getOutput().assign(res);
			}});
	}
}
