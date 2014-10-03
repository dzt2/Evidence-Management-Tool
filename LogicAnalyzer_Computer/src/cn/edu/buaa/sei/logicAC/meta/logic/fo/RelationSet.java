package cn.edu.buaa.sei.logicAC.meta.logic.fo;

public interface RelationSet {
	public boolean containRelation(Object[] elements);
	public void addRelation(Object[] elements) throws Exception;
	public void removeRelation(Object[] elements) throws Exception;
	public void clearRelations();
}
