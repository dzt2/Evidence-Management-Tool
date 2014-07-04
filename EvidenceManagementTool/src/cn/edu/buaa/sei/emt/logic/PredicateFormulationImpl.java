package cn.edu.buaa.sei.emt.logic;
import java.util.List;
import cn.edu.buaa.sei.emt.core.TaggedValue;
import cn.edu.buaa.sei.emt.core.Annotation;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.LMFContext;

public class PredicateFormulationImpl extends ManagedObjectImpl implements PredicateFormulation, LogicFormulation, RelationVariable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PredicateFormulationImpl() {
		super(LMFContext.typeForName(PredicateFormulation.TYPE_NAME));
	}
	
	@Override
	public List<TaggedValue> getTags() {
		return get(PredicateFormulation.KEY_TAGS).listContent().toGenericList(TaggedValue.class);
	}
	
	@Override
	public String getId() {
		return get(PredicateFormulation.KEY_ID).stringValue();
	}
	
	@Override
	public void setId(String value) {
		set(PredicateFormulation.KEY_ID, value);
	}
	
	@Override
	public Statement getStatement() {
		return (Statement) get(PredicateFormulation.KEY_STATEMENT);
	}
	
	@Override
	public void setStatement(Statement value) {
		set(PredicateFormulation.KEY_STATEMENT, value);
	}
	
	@Override
	public List<Variable> getArguments() {
		return get(PredicateFormulation.KEY_ARGUMENTS).listContent().toGenericList(Variable.class);
	}
	
	@Override
	public String getName() {
		return get(PredicateFormulation.KEY_NAME).stringValue();
	}
	
	@Override
	public void setName(String value) {
		set(PredicateFormulation.KEY_NAME, value);
	}
	
	@Override
	public EntityRelation getRelation() {
		return (EntityRelation) get(PredicateFormulation.KEY_RELATION);
	}
	
	@Override
	public void setRelation(EntityRelation value) {
		set(PredicateFormulation.KEY_RELATION, value);
	}
	
	@Override
	public String getGid() {
		return get(PredicateFormulation.KEY_GID).stringValue();
	}
	
	@Override
	public void setGid(String value) {
		set(PredicateFormulation.KEY_GID, value);
	}
	
	@Override
	public List<Annotation> getAnnotations() {
		return get(PredicateFormulation.KEY_ANNOTATIONS).listContent().toGenericList(Annotation.class);
	}
	
	@Override
	public EntityElement getBindTo() {
		return (EntityElement) get(PredicateFormulation.KEY_BINDTO);
	}
	
	@Override
	public void setBindTo(EntityElement value) {
		set(PredicateFormulation.KEY_BINDTO, value);
	}
	
}
