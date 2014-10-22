package cn.edu.buaa.sei.SVI.manage.impl.xml_struct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.edu.buaa.sei.SVI.struct.core.CompositeStruct;
import cn.edu.buaa.sei.SVI.struct.core.Struct;
import cn.edu.buaa.sei.SVI.struct.core.expression.Expression;
import cn.edu.buaa.sei.SVI.struct.core.function.Function;
import cn.edu.buaa.sei.SVI.struct.core.variable.Variable;

public class XMLStructPrinterContainer {
	public Map<Struct,Element> results = new HashMap<Struct,Element>();
	public Map<String,Struct> input_map = new HashMap<String,Struct>();
	public Map<Struct,String> rv_map = new HashMap<Struct,String>();
	
	Document doc;
	public XMLPrinter vp,ep,fp;
	
	public XMLStructPrinterContainer(Document doc) throws Exception{
		if(doc==null)throw new Exception("Null doc is invalid");
		
		this.vp = new XMLVariablePrinter(this,doc);
		this.ep = new XMLExpressionPrinter(this,doc);
		this.fp = new XMLFunctionPrinter(this,doc);
	}
	
	Long id=0L;
	public static final long TIMES = Long.MAX_VALUE;
	protected String id() throws Exception{
		int times = 0;
		while(this.input_map.containsKey(id.toString())){
			if(times>TIMES)throw new Exception("ID Space has been used out");
			id++;times++;
		}
		return id.toString();
	}
	
	public void addStruct(Struct struct) throws Exception{
		if(struct==null)throw new Exception("Null struct is invalid");
		
		if(this.input_map.containsValue(struct))return;
		
		String id = this.id();
		if(id==null)throw new Exception("ID Generation Failed");
		this.input_map.put(id, struct);
		this.rv_map.put(struct, id);
	}
	public void addAllStruct(Struct struct) throws Exception{
		if(struct==null)throw new Exception("Null struct is invalid");
		
		if(this.input_map.containsValue(struct))return;
		
		Queue<Struct> queue = new LinkedList<Struct>();
		queue.add(struct);
		
		while(!queue.isEmpty()){
			Struct e = queue.poll();
			this.addStruct(e);
			
			if(e instanceof CompositeStruct){
				Struct[] children = ((CompositeStruct) e).getChildrenStructs();
				int n = ((CompositeStruct) e).getChildrenStructSize();
				for(int i=0;i<n;i++)
					if(children[i]!=null)
						queue.add(children[i]);
			}
		}
		
	}
	
	public void removeStruct(Struct struct) throws Exception{
		if(struct==null)throw new Exception("Null struct is invalid");
		
		if(this.rv_map.containsKey(struct)){
			String id = this.rv_map.get(struct);
			this.input_map.remove(id);
			this.rv_map.remove(struct);
			if(this.results.containsKey(struct))
				this.results.remove(struct);
		}
		else throw new Exception("Undefined struct");
	}
	
	public boolean containResult(Struct struct){
		if(struct==null)return false;
		else return this.results.containsKey(struct);
	}
	public void setResult(Struct struct,Element element) throws Exception{
		if(struct==null||element==null)throw new Exception("Null struct|element is invalid");
		
		if(this.results.containsKey(struct))
			throw new Exception("Duplicated Struct");
		if(this.results.containsValue(element))
			throw new Exception("Duplicated Element: <"+element.getTagName()+">");
		
		this.results.put(struct, element);
	}
	public Element getResult(Struct struct) throws Exception{
		if(struct==null)throw new Exception("Null struct is invalid");
		if(this.results.containsKey(struct))return this.results.get(struct);
		else throw new Exception("Result has not been solved.");
	}
	
	public Map<String,Struct> getInputMap(){return this.input_map;}
	public Map<Struct,String> getRMap(){return this.rv_map;}
	
	public void clear(){
		this.input_map.clear();
		this.rv_map.clear();
		this.results.clear();
	}
	
	public XMLPrinter getPrinter(Struct struct)throws Exception{
		if(struct==null)throw new Exception("Null struct is invalid");
		
		if(struct instanceof Variable){return this.vp;}
		else if(struct instanceof Expression){return this.ep;}
		else if(struct instanceof Function){return this.fp;}
		else throw new Exception("Unknown type: "+struct.getClass().getCanonicalName());
	}
}
