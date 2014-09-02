package cn.edu.buaa.exLmf.test;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.exLmf.metamodel.LAttribute;
import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LFactory;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;
import cn.edu.buaa.exLmf.metamodel.LReference;
import cn.edu.buaa.exLmf.metamodel.LStructuralFeature;
import cn.edu.buaa.exLmf.metamodel.impl.LAttributeImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LClassImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LPackageImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LPrimitiveTypeImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LReferenceImpl;
import cn.edu.buaa.exLmf.metamodel.impl.LTypedElementImpl;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		
		list.add(4, 8);
		
		System.out.println(list);
	}
	
	public static void test1(){
LPackage p = createPackage1();
		
		System.out.println(p.getName());
		System.out.println(p.getNsPrefix());
		System.out.println(p.getNsURI());
		
		List<LClassifier> types = p.getTypes();
		System.out.println(types.size());
		
		
		
		LFactory factory = p.getFactory();
		LClass person = (LClass) p.getClassifierByName("Person");
		LClassObject a = factory.create(person);
		a.set(person.getFeatureByName("name"), factory.create(LPrimitiveTypeImpl.STRING, "John Horse"));
		a.set(person.getFeatureByName("age"),factory.create(LPrimitiveTypeImpl.INT, "20"));
		a.set(person.getFeatureByName("tall"), factory.create(LPrimitiveTypeImpl.FLOAT, "180.0"));
		
		LClassObject b = factory.create(person);
		b.set(person.getFeatureByName("name"), factory.create(LPrimitiveTypeImpl.STRING, "John Steve"));
		b.set(person.getFeatureByName("age"),factory.create(LPrimitiveTypeImpl.INT, "50"));
		b.set(person.getFeatureByName("tall"), factory.create(LPrimitiveTypeImpl.FLOAT, "170.0"));
		
		LClassObject c = factory.create(person);
		c.set(person.getFeatureByName("name"), factory.create(LPrimitiveTypeImpl.STRING, "QA"));
		c.set(person.getFeatureByName("age"),factory.create(LPrimitiveTypeImpl.INT, "48"));
		c.set(person.getFeatureByName("tall"), factory.create(LPrimitiveTypeImpl.FLOAT, "170.0"));
		
		a.set(person.getFeatureByName("father"), b);
		a.set(person.getFeatureByName("mother"), c);
		
		System.out.println(printLClassObject(a));
		System.out.println(printLClassObject(b));
		System.out.println(printLClassObject(c));
	}
	
	public static LPackage createPackage1(){
		LPackage p = new LPackageImpl("test","www.example.com/Test","Test");
		
		LClass person = new LClassImpl("Person");person.setClassifierID(0);
		LClass family = new LClassImpl("Family");family.setClassifierID(1);
		LClass house = new LClassImpl("House");house.setClassifierID(2);
		
		LAttribute p_name = new LAttributeImpl(0,"name",person);
		LAttribute p_age  = new LAttributeImpl(1,"age",person);
		LAttribute p_tall = new LAttributeImpl(2,"tall",null);
		
		p_name.setDataType(LPrimitiveTypeImpl.STRING);
		p_name.setUpperBound(1);p_name.setLowerBound(0);
		p_age.setDataType(LPrimitiveTypeImpl.INT);
		p_age.setUpperBound(1);p_age.setLowerBound(0);
		p_tall.setDataType(LPrimitiveTypeImpl.FLOAT);
		p_tall.setUpperBound(1);p_tall.setLowerBound(0);
		
		person.addAttribute(p_name);
		person.addAttribute(p_age);
		person.addAttribute(p_tall);
		
		LReference p_parant = new LReferenceImpl(3,"father",person);
		LReference p_mother = new LReferenceImpl(4,"mother",null);
		LReference p_friend = new LReferenceImpl(5,"friends",null);
		
		p_parant.setContainment(true);
		p_mother.setContainment(false);
		p_friend.setContainment(true);
		p_parant.setLClass(person);
		p_mother.setLClass(person);
		p_friend.setLClass(person);
		p_parant.setLowerBound(0);p_parant.setUpperBound(1);
		p_friend.setLowerBound(0);p_friend.setUpperBound(LTypedElementImpl.UNBOUNDED);
		
		person.addReference(p_parant);
		person.addReference(p_mother);
		person.addReference(p_friend);
		
		LReference f_members = new LReferenceImpl(0,"members",null);
		LReference f_house = new LReferenceImpl(1,"house",null);
		
		f_members.setLClass(person);
		f_members.setUpperBound(10);
		f_house.setLClass(family);
		
		family.addFeature(f_members);
		family.addFeature(f_house);
	
		p.addType(person);
		p.addType(family);
		p.addType(house);
		
		return p;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public static String printClass(LClass type){
		if(type==null)return null;
		StringBuilder code = new StringBuilder();
		
		code.append(type.getName()).append("[").append(type.getClassifierID()).append("]:");
		for(int i=0;i<type.getFeatures().size();i++){
			LStructuralFeature feature = type.getFeatures().get(i);
			code.append("\n\t-").append(feature.getName()).append("[").append(feature.getFeatureID()).
			append("]: ").append(feature.getType().getName()).append("(").append(feature.getLowerBound()).
			append("-").append(feature.getUpperBound()).append(")");
		}
		
		return code.toString();
	}
	public static String printLClassObject(LClassObject obj){
		if(obj==null)return null;
		LClass type = obj.getType();
		StringBuilder code = new StringBuilder();
		
		code.append("{").append("\n\t<<").append(obj.hashCode()).append(">>");
		List<LStructuralFeature> features = type.getAllFeatures();
		for(int i=0;i<features.size();i++){
			LStructuralFeature feature = features.get(i);
			LObject val = obj.get(feature);
			
			code.append("\n\t").append(feature.getName()).append("[").append(feature.getType().getName()).append("]: ");
			if(val==null)code.append("null");
			else if(val instanceof LDataObject)code.append(printDataObject((LDataObject) val));
			else if(val instanceof LClassObject)code.append(val.hashCode());
			else code.append("Unknown");
		}
		
		code.append("}");
		return code.toString();
	}
	public static String printDataObject(LDataObject obj){
		if(obj==null)return null;
		return obj.getValue().toString();
	}
}
