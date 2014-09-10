package cn.edu.buaa.exLmf.manager;

import java.util.Set;

import cn.edu.buaa.exLmf.metamodel.LClass;
import cn.edu.buaa.exLmf.metamodel.LClassObject;
import cn.edu.buaa.exLmf.metamodel.LClassifier;
import cn.edu.buaa.exLmf.metamodel.LDataObject;
import cn.edu.buaa.exLmf.metamodel.LDataType;
import cn.edu.buaa.exLmf.metamodel.LObject;
import cn.edu.buaa.exLmf.metamodel.LPackage;

public interface IObjectSpace {
	public void register(LPackage p);
	
	public Boolean isInstancable(LClassifier type);
	public LClassObject createClassObject(LClass type);
	public LDataObject createDataObject(LDataType type,String code);
	public Boolean removeObject(LObject obj);
	
	public Boolean containObject(LObject obj);
	public Boolean containObject(int id);
	
	public Integer getIDof(LObject obj);
	public LObject getObject(int id);
	public Set<LClassObject> getObjects(LClass type);
	
	public void clearSpace();
}
