package cn.edu.buaa.sei.emt.logic;

public interface Implication extends BinaryLogicOperation {
	
	public static final String TYPE_NAME = "logicformulation.Implication";
	public static final String KEY_ANTECEDENT = "antecedent";
	public static final String KEY_NAME = "name";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_OP1 = "op1";
	public static final String KEY_STATEMENT = "statement";
	public static final String KEY_OP2 = "op2";
	public static final String KEY_GID = "gid";
	public static final String KEY_CONSEQUENT = "consequent";
	public static final String KEY_ID = "id";
	public static final String KEY_ANNOTATIONS = "annotations";
	
	
	public LogicFormulation getAntecedent();
	
	public void setAntecedent(LogicFormulation value);
	
	public LogicFormulation getConsequent();
	
	public void setConsequent(LogicFormulation value);
	
}
