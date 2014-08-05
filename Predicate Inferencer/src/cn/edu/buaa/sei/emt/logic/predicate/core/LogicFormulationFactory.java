package cn.edu.buaa.sei.emt.logic.predicate.core;

public class LogicFormulationFactory {
	
	
	
	public static LogicExpression createLogicExpression() {
		return new LogicExpressionImpl();
	}
	
	public static PropositionVariable createPropositionVariable() {
		return new PropositionVariableImpl();
	}
	
	public static PredicateFormulation createPredicateFormulation() {
		return new PredicateFormulationImpl();
	}
	
	public static Universal createUniversal() {
		return new UniversalImpl();
	}
	
	public static Existential createExistential() {
		return new ExistentialImpl();
	}
	
	public static Conjunction createConjunction() {
		return new ConjunctionImpl();
	}
	
	public static Disjunction createDisjunction() {
		return new DisjunctionImpl();
	}
	
	public static Negation createNegation() {
		return new NegationImpl();
	}
	
	public static Implication createImplication() {
		return new ImplicationImpl();
	}
	
	public static Equivalence createEquivalence() {
		return new EquivalenceImpl();
	}
	
	public static Variable createVariable() {
		return new VariableImpl();
	}
	
	public static DiscourseDomain createDiscourseDomain() {
		return new DiscourseDomainImpl();
	}
	
	public static Value createValue() {
		return new ValueImpl();
	}
	
	public static LObject createLObject() {
		return new LObjectImpl();
	}
	
	public static BooleanObject createBooleanObject() {
		return new BooleanObjectImpl();
	}
	
	public static LSet createLSet() {
		return new LSetImpl();
	}
	
	public static LRelation createLRelation() {
		return new LRelationImpl();
	}
	
	public static LRelationSet createLRelationSet() {
		return new LRelationSetImpl();
	}
	
}
