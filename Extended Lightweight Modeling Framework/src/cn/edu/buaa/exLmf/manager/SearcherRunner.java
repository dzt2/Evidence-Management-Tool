package cn.edu.buaa.exLmf.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LEnum;
import cn.edu.buaa.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.exLmf.metamodel.LModelElement;
import cn.edu.buaa.exLmf.metamodel.LMultipleObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.impl.LMFException;

public class SearcherRunner implements ISearcherRunner{
	public static final String PACKAGE = "package_searcher";
	public static final String CLASS = "class_searcher";
	public static final String ENUM = "enum_searcher";
	public static final String ATTRIBUTE = "attribute_searcher";
	public static final String REFERENCE = "reference_searcher";
	public static final String LITERAL = "literal_searcher";
	public static final String DATAOBJECT = "dataObject_searcher";
	public static final String MULTIPLEOBJECT = "multipleObject_searcher";
	public static final String CLASSOBJECT = "classObject_searcher";
 	
	String name;
	LModelElement element;
	Map<String,ILModeSearcher> install_map = new HashMap<String,ILModeSearcher>();
	
	List<String> ins = new ArrayList<String>();
	int cur = 0;
	public static final int MAX_TASK = 1024;

	public SearcherRunner(String name){
		this.name=name;
		this.initial();
	}
	/*	Tool Functions   */
	Exception getException(String func,String arg,String reason){
		return LMFException.create("Searcher Runner "+this.name, "LMFCreator", func, arg, reason);
	}
	void initial(){
		this.install_map.put(PACKAGE, new LPackageSearcher());
		this.install_map.put(CLASS, new LClassSearcher());
		this.install_map.put(ENUM, new LEnumSearcher());
		this.install_map.put(ATTRIBUTE, new LAttributeSearcher());
		this.install_map.put(REFERENCE, new LReferenceSearcher());
		this.install_map.put(LITERAL, new LEnumLiteralSearcher());
		this.install_map.put(DATAOBJECT, new LDataObjectSearcher());
		this.install_map.put(MULTIPLEOBJECT, new LMultipleObjectSearcher());
		this.install_map.put(CLASSOBJECT, new LClassObjectSearcher());
	}
	
	
	@Override
	public void install(String name, ILModeSearcher searcher) {
		if(this.install_map.containsKey(name)){
			System.err.println("Installed Searcher \""+name+"\" is coverred.");
		}
		this.install_map.put(name, searcher);
	}
	@Override
	public void uninstall(String name) {
		if(!this.install_map.containsKey(name)){
			System.err.println("Searcher \""+name+"\" has not been installed");
			return;
		}
		this.install_map.remove(name);
	}
	@Override
	public Boolean isInstalled(String name) {return this.install_map.containsKey(name);}

	@Override
	public void setMainObject(LModelElement element) {this.element=element;}
	@Override
	public void pushTask(String path) throws Exception {
		if(cur>MAX_TASK){
			throw this.getException("pushTask(path)", "cur", "Larger than MAX_TASK: "+MAX_TASK);
		}
		this.ins.add(path);cur++;
	}
	@Override
	public String popTask() throws Exception {
		if(cur<=0){
			cur=0;
			throw this.getException("pushTask(path)", "cur", "Task List is empty");
		}
		return this.ins.remove(--cur);
	}

	@Override
	public Object runOne() throws Exception {
		String path = this.popTask();
		TaskRunner runner = new TaskRunner();
		runner.path=path;
		runner.element=this.element;
		
		Thread t = new Thread(runner);
		t.start();
		
		t.join();
		return runner.result;
	}

	@Override
	public Map<String, Object> runAll() throws Exception {
		Map<String,Object> results = new HashMap<String,Object>();
		
		List<TaskRunner> runners = new ArrayList<TaskRunner>();
		for(int i=0;i<this.ins.size();i++){
			TaskRunner runner = new TaskRunner();
			runner.element=this.element;
			runner.path=this.ins.get(i);
			runners.add(runner);
		}
		
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0;i<runners.size();i++)
			threads.add(new Thread(runners.get(i)));
		
		for(int i=0;i<threads.size();i++)
			threads.get(i).start();
		
		for(int i=0;i<threads.size();i++)
			threads.get(i).join();
		
		for(int i=0;i<runners.size();i++)
			results.put(runners.get(i).path, runners.get(i).result);
		
		return results;
	}
	
	class TaskRunner implements Runnable{
		public String path;
		public LModelElement element;
		public Object result;
		@Override
		public void run() {
			if(path==null||element==null)
				try {
					throw getException("TaskRunner", "arguments", "Null");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Object cur = this.element;
			String[] ans = path.split("\\"+ILModeSearcher.DOT);
			
			for(int i=0;i<ans.length;i++){
				try {
					cur = this.iterator(cur, ans[i]);
					if(cur==null)
						System.err.println("Searching failed at ["+i+"]: \""+ans[i]+"\"");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.result=cur;
			
		}
		
		Object iterator(Object obj,String next) throws Exception{
			if(obj==null||next==null)return null;
			
			ILModeSearcher searcher = null;
			if(obj instanceof LPackage)searcher = install_map.get(PACKAGE);
			if(obj instanceof LClass)searcher = install_map.get(CLASS);
			if(obj instanceof LEnum)searcher = install_map.get(ENUM);
			if(obj instanceof LAttribute)searcher = install_map.get(ATTRIBUTE);
			if(obj instanceof LReference)searcher = install_map.get(REFERENCE);
			if(obj instanceof LEnumLiteral)searcher = install_map.get(LITERAL);
			if(obj instanceof LDataObject)searcher = install_map.get(DATAOBJECT);
			if(obj instanceof LMultipleObject)searcher = install_map.get(MULTIPLEOBJECT);
			if(obj instanceof LClassObject)searcher = install_map.get(CLASSOBJECT);
			
			if(searcher==null)
				throw getException("iterator(obj,next)","obj","Undefined Type at: "+next);
			
			if(obj instanceof LModelElement){
				searcher.setElement((LModelElement) obj);
				return searcher.next(next);
			}
			throw getException("iterator(obj,next)","obj","Undefined Type at: "+next);
		}
		
	}

}
