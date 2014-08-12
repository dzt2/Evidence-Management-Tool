package cn.edu.buss.sei.emt.creator;

import cn.edu.buaa.sei.emt.logic.predicate.core.LObject;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelation;
import cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSet;
import cn.edu.buaa.sei.emt.logic.predicate.core.LSet;

public class ValueModifier {
	
	static Exception getArgException(String args,String func,String reason){
		StringBuilder code = new StringBuilder();
		code.append("Type: Argument Errors: ");
		code.append("\nArgument <"+args).append(">");
		code.append(" in function <").append(func).append(">");
		code.append("\nReason: ").append(reason);
		return new Exception(code.toString());
	}
	
	/*
	 *	Formulation Modifier: change values
	 *		1. LRelation
	 *		2. LSet
	 *		3. LRelationSet
	 */
	public static Boolean appendSet(LSet set, LObject obj){
		if(set==null||obj==null){
			try {
				throw getArgException("set|obj","appendSet(set,obj)",
						"try to call appendSet("+set+","+obj+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		/*if(set.getValues().contains(obj)){
			try {
				throw getArgException("obj","appendSet(set,obj)","obj have been included in set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}*/
		
		set.getValues().add(obj);
		return true;
	}
	/*public static Boolean removeSet(LSet set, int i){
		if(set==null)return false;
		if(i<0||i>=set.getValues().size()){
			try {
				throw getArgException("i","removedSet(set,i)",
						i+" have been out of range: size = "+set.getValues().size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		set.getValues().remove(i);
		return true;
	}*/
	public static Boolean removeSet(LSet set,LObject obj){
		if(set==null||obj==null)return false;
		if(set.getValues().contains(obj)){
			set.getValues().remove(obj);
			return true;
		}
		else{
			try {
				throw getArgException("obj","removeSet(set,obj)","obj have not been included in set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	public static Boolean clearSet(LSet set){
		if(set==null){
			try {
				throw getArgException("set","clearSet(set)","try to clear null set.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		set.getValues().clear();
		return true;
	}
	
	public static Boolean appendLRelationSet(LRelationSet rset,LRelation r){
		if(rset==null||r==null){
			try {
				throw getArgException("rset|r","appendLRelationSet(rset,r)",
						"try to call appendLRelationSet("+rset+","+r+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		/*if(rset.getRelations().contains(r)){
			try {
				throw getArgException("r","appendLRelationSet(rset,r)",
						"relation r has been included in rset.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}*/
		
		rset.getRelations().add(r);
		return true;
	}
	public static Boolean removeLRelationSet(LRelationSet rset,LRelation r){
		if(rset==null||r==null){
			try {
				throw getArgException("rset|r","removeLRelationSet(rset,r)",
						"try to call appendLRelationSet("+rset+","+r+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		if(!rset.getRelations().contains(r)){
			try {
				throw getArgException("r","removeLRelationSet(rset,r)",
						"the r have not been included in rset.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		rset.getRelations().remove(r);
		return true;
	}
	public static Boolean clearLRelationSet(LRelationSet rset){
		if(rset==null){
			try {
				throw getArgException("rset","clearLRelationSet(rset)","try to clear null rset.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		rset.getRelations().clear();
		return true;
	}
	
	// It is better not to use these methods
	@SuppressWarnings("unused")
	private static Boolean appendRelation(LRelation r,LObject e){
		if(r==null||e==null){
			try {
				throw getArgException("r|e","appendRelation(r,e)",
						"try to call appendRelation("+r+","+e+")");
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return false;
		}
		
		r.getElements().add(e);
		return true;
	}
	@SuppressWarnings("unused")
	private static Boolean removeRelation(LRelation r,int i){
		if(r==null||i<0){
			try {
				throw getArgException("r|i","removeRelation(r,i)",
						"try to call appendRelation("+r+","+i+")");
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return false;
		}
		
		if(i>=r.getElements().size()){
			try {
				throw getArgException("i","removeRelation(r,i)",
						i+" has been out of range: size = "+r.getElements().size());
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return false;
		}
		
		r.getElements().remove(i);
		return true;
	}
	@SuppressWarnings("unused")
	private static Boolean clearRelation(LRelation r){
		if(r==null){
			try {
				throw getArgException("r","clearRelation(r)","try to clear null relation r.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		r.getElements().clear();
		return true;
	}
	
	
}
