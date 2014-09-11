package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import cn.edu.buaa.sei.exLmf.manager.IModelCreator;
import cn.edu.buaa.sei.exLmf.manager.impl.ModelCreatorImpl;
import cn.edu.buaa.sei.exLmf.metamodel.LAttribute;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LClassifier;
import cn.edu.buaa.sei.exLmf.metamodel.LDataType;
import cn.edu.buaa.sei.exLmf.metamodel.LEnum;
import cn.edu.buaa.sei.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.sei.exLmf.metamodel.LModelElement;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.metamodel.LReference;
import cn.edu.buaa.sei.exLmf.metamodel.impl.LMFException;
import cn.edu.buaa.sei.exLmf.metamodel.impl.LPrimitiveTypeImpl;

public class EcoreModelImporter implements IModelImporter{
	
	String name;
	File file;
	EPackage p;
	IModelCreator creator = new ModelCreatorImpl("CREATOR");
	
	Map<EModelElement,LModelElement> map = new HashMap<EModelElement,LModelElement>();
	
	public EcoreModelImporter(String name){this.name=name;}
	
	/*Tool Functions*/
	Exception getException(String func,String arg,String reason){
		return LMFException.create("Ecore Importer "+this.name, "LMFCreator", func, arg, reason);
	}
	EPackage read(){
		URI uri = URI.createFileURI(file.getAbsolutePath());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Resource resource = resourceSet.getResource(uri,true);
		
		EPackage p =(EPackage) resource.getContents().get(0);
		
		return p;
	}

	/*Core Functions*/
	@Override
	public void setResource(File file) {this.file=file;}
	@Override
	public boolean validate() throws Exception {
		if(this.file==null){
			throw this.getException("validate()", "file", "Null");
		}
		this.p=this.read();
		if(p==null){
			throw this.getException("validate()", "file", "Reading \""+this.file.getAbsolutePath()+"\" failed.");
		}
		return true;
	}

	@Override
	public LPackage translate() throws Exception {
		if(!this.validate()){
			throw this.getException("translate()", "file", "Interpretation failed");
		}
		
		this.map.clear();
		//code...
		LPackage np = (LPackage) this.generateElement(this.p);
		this.map.clear();
		
		return np;
	}
	
	LModelElement generateElement(EModelElement elm) throws Exception{
		if(elm==null){
			return null;
		}
		if(this.map.containsKey(elm))return this.map.get(elm);
		
		if(elm instanceof EPackage){return this.generatePackage((EPackage) elm);}
		else if(elm instanceof EClass){return this.generateClass((EClass) elm);}
		else if(elm instanceof EAttribute){return this.generateAttribute((EAttribute) elm);}
		else if(elm instanceof EReference){return this.generateReference((EReference) elm);}
		else if(elm instanceof EEnumLiteral){return this.generateLiteral((EEnumLiteral) elm);}
		else if(elm instanceof EEnum){return this.generateEnum((EEnum) elm);}
		else if(elm instanceof EDataType){return this.generateDataType((EDataType) elm);}
		
		throw this.getException("generateElement(elm)", "elm", "Unknown Ecore Model Elements (\""+elm.getClass().getName()+"\")");
	}
	LPackage generatePackage(EPackage p) throws Exception{
		LPackage np = this.creator.createPackage(this.creator.getRoot(), name,p.getNsURI(),p.getNsPrefix());
		this.map.put(p, np);
		
		List<EPackage> subs = p.getESubpackages();
		for(int i=0;i<subs.size();i++){
			LPackage sp = (LPackage) this.generateElement(subs.get(i));
			np.addSubPackage(sp);
		}
		
		List<EClassifier> types = p.getEClassifiers();
		for(int i=0;i<types.size();i++){
			EClassifier type = types.get(i);
			np.addType((LClassifier) this.generateElement(type));
		}
		
		return np;
	}
	LClass generateClass(EClass type) throws Exception{
		String ins = type.getInstanceClassName();
		if(ins==null)ins=type.getName();
		
		LClass ctype = this.creator.createClass(this.creator.getRoot(), type.getName(), ins);
		ctype.setAbstract(type.isAbstract());
		this.map.put(type, ctype);
		
		if(type.getEIDAttribute()!=null)
			ctype.setIDAttribute((LAttribute) this.generateElement(type.getEIDAttribute()));
		
		List<EAttribute> attributes = type.getEAllAttributes();
		for(int i=0;i<attributes.size();i++){
			EAttribute a = attributes.get(i);
			LAttribute attr = (LAttribute) this.generateElement(a);
			ctype.addAttribute(attr);
		}
		
		List<EReference> references = type.getEReferences();
		for(int i=0;i<references.size();i++){
			EReference r = references.get(i);
			LReference ref = (LReference) this.generateElement(r);
			ctype.addReference(ref);
		}
		
		List<EClass> supers = type.getESuperTypes();
		for(int i=0;i<supers.size();i++)
			ctype.addSuperType((LClass) this.generateElement(supers.get(i)));
		
		return ctype;
	}
	LEnum generateEnum(EEnum type) throws Exception{
		String ins = type.getName();
		if(type.getInstanceClassName()!=null)ins = type.getInstanceClassName();
		
		LEnum etype = this.creator.createEnum((LPackage) this.generateElement(type.getEPackage()), type.getName(),ins);
		this.map.put(type, etype);
		
		List<EEnumLiteral> ls = type.getELiterals();
		for(int i=0;i<ls.size();i++){
			EEnumLiteral l = ls.get(i);
			etype.addLiteral((LEnumLiteral) this.generateElement(l));
		}
		
		return etype;
	}
	LAttribute generateAttribute(EAttribute attribute) throws Exception{
		LAttribute attr = this.creator.createAttribute((LClass)this.generateElement(attribute.getEContainingClass()), 
				attribute.getName(), (LDataType)this.generateElement(attribute.getEAttributeType()));
		this.map.put(attribute, attr);
		
		attr.setChangable(attribute.isChangeable());
		attr.setLowerBound(attribute.getLowerBound());
		attr.setOrdered(attribute.isOrdered());
		attr.setUnique(attribute.isUnique());
		attr.setUpperBound(attribute.getUpperBound());
		
		return attr;
	}
	LReference generateReference(EReference ref) throws Exception{
		LReference r = this.creator.createReference((LClass)this.generateElement(ref.getEContainingClass()), 
				ref.getName(), (LClass)this.generateElement(ref.getEReferenceType()));
		this.map.put(ref, r);
		
		r.setChangable(ref.isChangeable());
		r.setContainment(ref.isContainment());
		r.setLowerBound(ref.getLowerBound());
		r.setUpperBound(ref.getUpperBound());
		r.setOrdered(ref.isOrdered());
		r.setUnique(ref.isUnique());
		r.setOpposite((LReference) this.generateElement(ref.getEOpposite()));
		
		return r;
	}
	LEnumLiteral generateLiteral(EEnumLiteral literal) throws Exception{
		String li = literal.getLiteral();
		if(li==null)li = literal.getName();
		LEnumLiteral l = this.creator.createLiteral((LEnum) this.generateElement(literal.getEEnum()), 
				literal.getName(), literal.getValue(), li);
		this.map.put(literal, l);
		
		return l;
	}
	LDataType generateDataType(EDataType type) throws Exception{
		String name = type.getName();
		
		if(name.equals("EBoolean")||name.equals("EBooleanObject"))return LPrimitiveTypeImpl.BOOL;
		if(name.equals("EInt")||name.equals("EIntegerObject"))return LPrimitiveTypeImpl.INT;
		if(name.equals("ELong")||name.equals("ELongObject"))return LPrimitiveTypeImpl.LONG;
		if(name.equals("EFloat")||name.equals("EFloatObject"))return LPrimitiveTypeImpl.FLOAT;
		if(name.equals("EDouble")||name.equals("EDoubleObject"))return LPrimitiveTypeImpl.DOUBLE;
		if(name.equals("EString"))return LPrimitiveTypeImpl.STRING;
		
		throw this.getException("generateDataType", "type", "Unknown Basic Type \""+type.getClass().getName()+"\"");
	}
	
}
