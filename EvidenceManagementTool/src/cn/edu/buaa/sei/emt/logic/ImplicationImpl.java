package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ImplicationImpl extends ManagedObjectImpl implements Implication, BinaryLogicOperation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ImplicationImpl() {
		super(LMFContext.typeForName(Implication.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(Implication.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(Implication.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(Implication.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(Implication.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(Implication.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getOp1() {
		return (LogicFormulation) get(Implication.KEY_OP1);
	}
	
	@Override
	public void setOp1(LogicFormulation value) {
		set(Implication.KEY_OP1, value);
	}
	
	@Override
	public LogicFormulation getAntecedent() {
		return (LogicFormulation) get(Implication.KEY_ANTECEDENT);
	}
	
	@Override
	public void setAntecedent(LogicFormulation value) {
		set(Implication.KEY_ANTECEDENT, value);
	}
	
	@Override
	public LogicFormulation getOp2() {
		return (LogicFormulation) get(Implication.KEY_OP2);
	}
	
	@Override
	public void setOp2(LogicFormulation value) {
		set(Implication.KEY_OP2, value);
	}
	
	@Override
	public LogicFormulation getConsequent() {
		return (LogicFormulation) get(Implication.KEY_CONSEQUENT);
	}
	
	@Override
	public void setConsequent(LogicFormulation value) {
		set(Implication.KEY_CONSEQUENT, value);
	}
	
	@Override
	public String getName() {
		return get(Implication.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(Implication.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(Implication.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(Implication.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(Implication.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
