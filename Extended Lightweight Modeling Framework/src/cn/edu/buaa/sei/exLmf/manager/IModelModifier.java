package cn.edu.buaa.sei.exLmf.manager;

import cn.edu.buaa.sei.exLmf.metamodel.LAttribute;
import cn.edu.buaa.sei.exLmf.metamodel.LClass;
import cn.edu.buaa.sei.exLmf.metamodel.LEnum;
import cn.edu.buaa.sei.exLmf.metamodel.LEnumLiteral;
import cn.edu.buaa.sei.exLmf.metamodel.LPackage;
import cn.edu.buaa.sei.exLmf.metamodel.LReference;

public interface IModelModifier {
	public Boolean generalize(LClass parant,LClass child);
	public Boolean removeGeneralize(LClass parant,LClass child);
	
	public Boolean appendAttribute(LClass type,LAttribute attribute);
	public Boolean appendReference(LClass type,LReference reference);
	public Boolean removeAttribute(LClass type,LAttribute attribute);
	public Boolean removeReference(LClass type,LReference reference);
	public Boolean appendLiteral(LEnum type,LEnumLiteral literal);
	public Boolean removeLiteral(LEnum type,LEnumLiteral literal);
	
	public Boolean appendClass(LPackage p,LClass type);
	public Boolean removeClass(LPackage p,LClass type);
	public Boolean appendEnum(LPackage p,LEnum type);
	public Boolean removeEnum(LPackage p,LEnum type);
	public Boolean appendPackage(LPackage parant,LPackage child);
	public Boolean removePackage(LPackage parant,LPackage child);
	
	public LReference addAssociation(String name,LClass type1,LClass type2,Boolean bi_direct);
	public Boolean removeAssociation(LReference ref);
}
