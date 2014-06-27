package cn.edu.buaa.sei.emt.logic;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import java.util.List;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class ExclusiveDisjunctionImpl extends ManagedObjectImpl implements ExclusiveDisjunction, BinaryLogicOperation {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ExclusiveDisjunctionImpl() {
		super(LMFContext.typeForName(ExclusiveDisjunction.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(ExclusiveDisjunction.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(ExclusiveDisjunction.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(ExclusiveDisjunction.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(ExclusiveDisjunction.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(ExclusiveDisjunction.KEY_STATEMENT, value);
	}
	
	@Override
	public LogicFormulation getOp1() {
		return (LogicFormulation) get(ExclusiveDisjunction.KEY_OP1);
	}
	
	@Override
	public void setOp1(LogicFormulation value) {
		set(ExclusiveDisjunction.KEY_OP1, value);
	}
	
	@Override
	public LogicFormulation getOp2() {
		return (LogicFormulation) get(ExclusiveDisjunction.KEY_OP2);
	}
	
	@Override
	public void setOp2(LogicFormulation value) {
		set(ExclusiveDisjunction.KEY_OP2, value);
	}
	
	@Override
	public String getName() {
		return get(ExclusiveDisjunction.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(ExclusiveDisjunction.KEY_NAME, value);
	}
	
	@Override
	public String getGid() {
		return get(ExclusiveDisjunction.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(ExclusiveDisjunction.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(ExclusiveDisjunction.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
}
