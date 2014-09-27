package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface RelationSet {
	public boolean containRelation(Object src,Object trg);
	public void addRelation(Object src,Object trg) throws Exception;
	public void removeRelation(Object src,Object trg) throws Exception;
}
