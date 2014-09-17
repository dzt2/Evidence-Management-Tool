package cn.edu.buaa.sei.exLmf.schema;

import java.io.OutputStream;
import org.jdom2.Namespace;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

public class XMLSchemaGenerator implements ISchemaGenerator{
	String name;
	LPackage p;
	OutputStream out;
	static Namespace ns = Namespace.getNamespace("xs","http://www.w3.org/2001/XMLSchema");;
	
	public XMLSchemaGenerator(String name){this.name=name;}
	
	
	@Override
	public void setModel(LPackage p) {this.p=p;}
	@Override
	public void setOPipe(OutputStream out) {this.out=out;}
	@Override
	public boolean validate() {
		if(out==null||p==null)return false;
		else return true;
	}

	@Override
	public void generateSchema() {
		
	}

}
