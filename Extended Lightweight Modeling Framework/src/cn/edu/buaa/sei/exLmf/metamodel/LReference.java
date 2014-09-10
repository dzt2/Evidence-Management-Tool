package cn.edu.buaa.sei.exLmf.metamodel;

public interface LReference extends LStructuralFeature{
	public LClass getLClass();
	public void setLClass(LClass type);
	
	public LReference getOpposite();
	public void setOpposite(LReference opposite);
	void release_opposite();
	void link_opposite(LReference opposite);
	
	public Boolean isContainment();
	public void setContainment(Boolean containment);
}
