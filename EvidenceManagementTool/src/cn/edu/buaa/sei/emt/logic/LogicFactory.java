package cn.edu.buaa.sei.emt.logic;

public class LogicFactory {
	
	
	
	public static Statement createStatement() {
		return new StatementImpl();
	}
	
	public static PropositionVariable createPropositionVariable() {
		return new PropositionVariableImpl();
	}
	
	public static PredicateFormulation createPredicateFormulation() {
		return new PredicateFormulationImpl();
	}
	
	public static Negation createNegation() {
		return new NegationImpl();
	}
	
	public static ExclusiveDisjunction createExclusiveDisjunction() {
		return new ExclusiveDisjunctionImpl();
	}
	
	public static Equivalence createEquivalence() {
		return new EquivalenceImpl();
	}
	
	public static Implication createImplication() {
		return new ImplicationImpl();
	}
	
	public static NAND createNAND() {
		return new NANDImpl();
	}
	
	public static NOR createNOR() {
		return new NORImpl();
	}
	
	public static Conjunction createConjunction() {
		return new ConjunctionImpl();
	}
	
	public static Disjunction createDisjunction() {
		return new DisjunctionImpl();
	}
	
	public static UniversalQuantification createUniversalQuantification() {
		return new UniversalQuantificationImpl();
	}
	
	public static AtLeastQuantification createAtLeastQuantification() {
		return new AtLeastQuantificationImpl();
	}
	
	public static ExistentialQuantification createExistentialQuantification() {
		return new ExistentialQuantificationImpl();
	}
	
	public static AtMostQuantification createAtMostQuantification() {
		return new AtMostQuantificationImpl();
	}
	
	public static AtMostOneQuantification createAtMostOneQuantification() {
		return new AtMostOneQuantificationImpl();
	}
	
	public static NumbericRangeQuantification createNumbericRangeQuantification() {
		return new NumbericRangeQuantificationImpl();
	}
	
	public static IndividualVariable createIndividualVariable() {
		return new IndividualVariableImpl();
	}
	
	public static SetVariable createSetVariable() {
		return new SetVariableImpl();
	}
	
	public static RelationVariable createRelationVariable() {
		return new RelationVariableImpl();
	}
	
	public static ValueVariable createValueVariable() {
		return new ValueVariableImpl();
	}
	
	public static EntityElement createEntityElement() {
		return new EntityElementImpl();
	}
	
	public static EntityIndividual createEntityIndividual() {
		return new EntityIndividualImpl();
	}
	
	public static EntitySet createEntitySet() {
		return new EntitySetImpl();
	}
	
	public static EntityRelation createEntityRelation() {
		return new EntityRelationImpl();
	}
	
	public static EntityValue createEntityValue() {
		return new EntityValueImpl();
	}
	
}
