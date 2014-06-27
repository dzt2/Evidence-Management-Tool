package cn.edu.buaa.sei.emt.logic;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import cn.edu.buaa.sei.lmf.AttributeBuilder;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.TypeBuilder;
import cn.edu.buaa.sei.lmf.TypeLoader;

public class LogicTypeLoader implements TypeLoader {
	
	
	
	@Override
	public Set<TypeBuilder> loadTypes(Map<String, TypeBuilder> existingTypes) {
		Set<TypeBuilder> types = new HashSet<TypeBuilder>();
		
		// Type Definition: LogicElement
		TypeBuilder type_LogicElement = new TypeBuilder("logicformulation", "LogicElement");
		type_LogicElement.isAbstract = true;
		type_LogicElement.isFinal = false;
		type_LogicElement.superTypeNames.add("core.ModelElement");
		{
		}
		types.add(type_LogicElement);
		
		// Type Definition: LogicFormulation
		TypeBuilder type_LogicFormulation = new TypeBuilder("logicformulation", "LogicFormulation");
		type_LogicFormulation.isAbstract = true;
		type_LogicFormulation.isFinal = false;
		type_LogicFormulation.superTypeNames.add("logicformulation.LogicElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "logicformulation";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_LogicFormulation.attributes.add(attr_name);
			
			// Attribute Definition: statement
			AttributeBuilder attr_statement = new AttributeBuilder("statement");
			attr_statement.extensionID = "logicformulation";
			attr_statement.valueTypeName = "logicformulation.Statement";
			attr_statement.isContainment = false;
			type_LogicFormulation.attributes.add(attr_statement);
			
		}
		types.add(type_LogicFormulation);
		
		// Type Definition: Statement
		TypeBuilder type_Statement = new TypeBuilder("logicformulation", "Statement");
		type_Statement.isAbstract = false;
		type_Statement.isFinal = false;
		type_Statement.superTypeNames.add("core.ModelElement");
		{
			// Attribute Definition: content
			AttributeBuilder attr_content = new AttributeBuilder("content");
			attr_content.extensionID = "logicformulation";
			attr_content.valueTypeName = "primitives.<string>";
			attr_content.isContainment = true;
			type_Statement.attributes.add(attr_content);
			
		}
		types.add(type_Statement);
		
		// Type Definition: AtomicLogicFormulation
		TypeBuilder type_AtomicLogicFormulation = new TypeBuilder("logicformulation", "AtomicLogicFormulation");
		type_AtomicLogicFormulation.isAbstract = true;
		type_AtomicLogicFormulation.isFinal = false;
		type_AtomicLogicFormulation.superTypeNames.add("logicformulation.LogicFormulation");
		{
		}
		types.add(type_AtomicLogicFormulation);
		
		// Type Definition: PropositionVariable
		TypeBuilder type_PropositionVariable = new TypeBuilder("logicformulation", "PropositionVariable");
		type_PropositionVariable.isAbstract = false;
		type_PropositionVariable.isFinal = false;
		type_PropositionVariable.superTypeNames.add("logicformulation.AtomicLogicFormulation");
		type_PropositionVariable.superTypeNames.add("variable.ValueVariable");
		{
		}
		types.add(type_PropositionVariable);
		
		// Type Definition: PredicateFormulation
		TypeBuilder type_PredicateFormulation = new TypeBuilder("logicformulation", "PredicateFormulation");
		type_PredicateFormulation.isAbstract = false;
		type_PredicateFormulation.isFinal = false;
		type_PredicateFormulation.superTypeNames.add("logicformulation.LogicFormulation");
		type_PredicateFormulation.superTypeNames.add("variable.RelationVariable");
		{
			// Attribute Definition: arguments
			AttributeBuilder attr_arguments = new AttributeBuilder("arguments");
			attr_arguments.extensionID = "logicformulation";
			attr_arguments.valueTypeName = "primitives.<list>";
			attr_arguments.isContainment = false;
			attr_arguments.valueTypeParameter = "variable.Variable";
			type_PredicateFormulation.attributes.add(attr_arguments);
			
		}
		types.add(type_PredicateFormulation);
		
		// Type Definition: LogicOperation
		TypeBuilder type_LogicOperation = new TypeBuilder("logicformulation", "LogicOperation");
		type_LogicOperation.isAbstract = true;
		type_LogicOperation.isFinal = false;
		type_LogicOperation.superTypeNames.add("logicformulation.LogicFormulation");
		{
		}
		types.add(type_LogicOperation);
		
		// Type Definition: UnaryLogicOperation
		TypeBuilder type_UnaryLogicOperation = new TypeBuilder("logicformulation", "UnaryLogicOperation");
		type_UnaryLogicOperation.isAbstract = true;
		type_UnaryLogicOperation.isFinal = false;
		type_UnaryLogicOperation.superTypeNames.add("logicformulation.LogicOperation");
		{
			// Attribute Definition: formulation
			AttributeBuilder attr_formulation = new AttributeBuilder("formulation");
			attr_formulation.extensionID = "logicformulation";
			attr_formulation.valueTypeName = "logicformulation.LogicFormulation";
			attr_formulation.isContainment = false;
			type_UnaryLogicOperation.attributes.add(attr_formulation);
			
		}
		types.add(type_UnaryLogicOperation);
		
		// Type Definition: Negation
		TypeBuilder type_Negation = new TypeBuilder("logicformulation", "Negation");
		type_Negation.isAbstract = false;
		type_Negation.isFinal = false;
		type_Negation.superTypeNames.add("logicformulation.UnaryLogicOperation");
		{
		}
		types.add(type_Negation);
		
		// Type Definition: BinaryLogicOperation
		TypeBuilder type_BinaryLogicOperation = new TypeBuilder("logicformulation", "BinaryLogicOperation");
		type_BinaryLogicOperation.isAbstract = true;
		type_BinaryLogicOperation.isFinal = false;
		type_BinaryLogicOperation.superTypeNames.add("logicformulation.LogicOperation");
		{
			// Attribute Definition: op1
			AttributeBuilder attr_op1 = new AttributeBuilder("op1");
			attr_op1.extensionID = "logicformulation";
			attr_op1.valueTypeName = "logicformulation.LogicFormulation";
			attr_op1.isContainment = false;
			type_BinaryLogicOperation.attributes.add(attr_op1);
			
			// Attribute Definition: op2
			AttributeBuilder attr_op2 = new AttributeBuilder("op2");
			attr_op2.extensionID = "logicformulation";
			attr_op2.valueTypeName = "logicformulation.LogicFormulation";
			attr_op2.isContainment = false;
			type_BinaryLogicOperation.attributes.add(attr_op2);
			
		}
		types.add(type_BinaryLogicOperation);
		
		// Type Definition: ExclusiveDisjunction
		TypeBuilder type_ExclusiveDisjunction = new TypeBuilder("logicformulation", "ExclusiveDisjunction");
		type_ExclusiveDisjunction.isAbstract = false;
		type_ExclusiveDisjunction.isFinal = false;
		type_ExclusiveDisjunction.superTypeNames.add("logicformulation.BinaryLogicOperation");
		{
		}
		types.add(type_ExclusiveDisjunction);
		
		// Type Definition: Equivalence
		TypeBuilder type_Equivalence = new TypeBuilder("logicformulation", "Equivalence");
		type_Equivalence.isAbstract = false;
		type_Equivalence.isFinal = false;
		type_Equivalence.superTypeNames.add("logicformulation.BinaryLogicOperation");
		{
		}
		types.add(type_Equivalence);
		
		// Type Definition: Implication
		TypeBuilder type_Implication = new TypeBuilder("logicformulation", "Implication");
		type_Implication.isAbstract = false;
		type_Implication.isFinal = false;
		type_Implication.superTypeNames.add("logicformulation.BinaryLogicOperation");
		{
			// Attribute Definition: antecedent
			AttributeBuilder attr_antecedent = new AttributeBuilder("antecedent");
			attr_antecedent.extensionID = "logicformulation";
			attr_antecedent.valueTypeName = "logicformulation.LogicFormulation";
			attr_antecedent.isContainment = false;
			type_Implication.attributes.add(attr_antecedent);
			
			// Attribute Definition: consequent
			AttributeBuilder attr_consequent = new AttributeBuilder("consequent");
			attr_consequent.extensionID = "logicformulation";
			attr_consequent.valueTypeName = "logicformulation.LogicFormulation";
			attr_consequent.isContainment = false;
			type_Implication.attributes.add(attr_consequent);
			
		}
		types.add(type_Implication);
		
		// Type Definition: NAND
		TypeBuilder type_NAND = new TypeBuilder("logicformulation", "NAND");
		type_NAND.isAbstract = false;
		type_NAND.isFinal = false;
		type_NAND.superTypeNames.add("logicformulation.BinaryLogicOperation");
		{
		}
		types.add(type_NAND);
		
		// Type Definition: NOR
		TypeBuilder type_NOR = new TypeBuilder("logicformulation", "NOR");
		type_NOR.isAbstract = false;
		type_NOR.isFinal = false;
		type_NOR.superTypeNames.add("logicformulation.BinaryLogicOperation");
		{
		}
		types.add(type_NOR);
		
		// Type Definition: ArbitaryLogicOperation
		TypeBuilder type_ArbitaryLogicOperation = new TypeBuilder("logicformulation", "ArbitaryLogicOperation");
		type_ArbitaryLogicOperation.isAbstract = true;
		type_ArbitaryLogicOperation.isFinal = false;
		type_ArbitaryLogicOperation.superTypeNames.add("logicformulation.LogicOperation");
		{
			// Attribute Definition: operators
			AttributeBuilder attr_operators = new AttributeBuilder("operators");
			attr_operators.extensionID = "logicformulation";
			attr_operators.valueTypeName = "primitives.<list>";
			attr_operators.isContainment = false;
			attr_operators.valueTypeParameter = "logicformulation.LogicFormulation";
			type_ArbitaryLogicOperation.attributes.add(attr_operators);
			
		}
		types.add(type_ArbitaryLogicOperation);
		
		// Type Definition: Conjunction
		TypeBuilder type_Conjunction = new TypeBuilder("logicformulation", "Conjunction");
		type_Conjunction.isAbstract = false;
		type_Conjunction.isFinal = false;
		type_Conjunction.superTypeNames.add("logicformulation.ArbitaryLogicOperation");
		{
		}
		types.add(type_Conjunction);
		
		// Type Definition: Disjunction
		TypeBuilder type_Disjunction = new TypeBuilder("logicformulation", "Disjunction");
		type_Disjunction.isAbstract = false;
		type_Disjunction.isFinal = false;
		type_Disjunction.superTypeNames.add("logicformulation.ArbitaryLogicOperation");
		{
		}
		types.add(type_Disjunction);
		
		// Type Definition: Quantification
		TypeBuilder type_Quantification = new TypeBuilder("logicformulation", "Quantification");
		type_Quantification.isAbstract = true;
		type_Quantification.isFinal = false;
		type_Quantification.superTypeNames.add("logicformulation.LogicFormulation");
		{
			// Attribute Definition: variable
			AttributeBuilder attr_variable = new AttributeBuilder("variable");
			attr_variable.extensionID = "logicformulation";
			attr_variable.valueTypeName = "variable.Variable";
			attr_variable.isContainment = false;
			type_Quantification.attributes.add(attr_variable);
			
			// Attribute Definition: scope
			AttributeBuilder attr_scope = new AttributeBuilder("scope");
			attr_scope.extensionID = "logicformulation";
			attr_scope.valueTypeName = "logicformulation.LogicFormulation";
			attr_scope.isContainment = false;
			type_Quantification.attributes.add(attr_scope);
			
			// Attribute Definition: domain
			AttributeBuilder attr_domain = new AttributeBuilder("domain");
			attr_domain.extensionID = "logicformulation";
			attr_domain.valueTypeName = "variable.SetVariable";
			attr_domain.isContainment = false;
			type_Quantification.attributes.add(attr_domain);
			
		}
		types.add(type_Quantification);
		
		// Type Definition: UniversalQuantification
		TypeBuilder type_UniversalQuantification = new TypeBuilder("logicformulation", "UniversalQuantification");
		type_UniversalQuantification.isAbstract = false;
		type_UniversalQuantification.isFinal = false;
		type_UniversalQuantification.superTypeNames.add("logicformulation.Quantification");
		{
		}
		types.add(type_UniversalQuantification);
		
		// Type Definition: AtLeastQuantification
		TypeBuilder type_AtLeastQuantification = new TypeBuilder("logicformulation", "AtLeastQuantification");
		type_AtLeastQuantification.isAbstract = false;
		type_AtLeastQuantification.isFinal = false;
		type_AtLeastQuantification.superTypeNames.add("logicformulation.Quantification");
		{
			// Attribute Definition: lower_bound
			AttributeBuilder attr_lower_bound = new AttributeBuilder("lower_bound");
			attr_lower_bound.extensionID = "logicformulation";
			attr_lower_bound.valueTypeName = "primitives.<int>";
			attr_lower_bound.isContainment = true;
			type_AtLeastQuantification.attributes.add(attr_lower_bound);
			
		}
		types.add(type_AtLeastQuantification);
		
		// Type Definition: ExistentialQuantification
		TypeBuilder type_ExistentialQuantification = new TypeBuilder("logicformulation", "ExistentialQuantification");
		type_ExistentialQuantification.isAbstract = false;
		type_ExistentialQuantification.isFinal = false;
		type_ExistentialQuantification.superTypeNames.add("logicformulation.AtLeastQuantification");
		{
		}
		types.add(type_ExistentialQuantification);
		
		// Type Definition: AtMostQuantification
		TypeBuilder type_AtMostQuantification = new TypeBuilder("logicformulation", "AtMostQuantification");
		type_AtMostQuantification.isAbstract = false;
		type_AtMostQuantification.isFinal = false;
		type_AtMostQuantification.superTypeNames.add("logicformulation.Quantification");
		{
			// Attribute Definition: upper_bound
			AttributeBuilder attr_upper_bound = new AttributeBuilder("upper_bound");
			attr_upper_bound.extensionID = "logicformulation";
			attr_upper_bound.valueTypeName = "primitives.<int>";
			attr_upper_bound.isContainment = true;
			type_AtMostQuantification.attributes.add(attr_upper_bound);
			
		}
		types.add(type_AtMostQuantification);
		
		// Type Definition: AtMostOneQuantification
		TypeBuilder type_AtMostOneQuantification = new TypeBuilder("logicformulation", "AtMostOneQuantification");
		type_AtMostOneQuantification.isAbstract = false;
		type_AtMostOneQuantification.isFinal = false;
		type_AtMostOneQuantification.superTypeNames.add("logicformulation.AtMostQuantification");
		{
		}
		types.add(type_AtMostOneQuantification);
		
		// Type Definition: NumbericRangeQuantification
		TypeBuilder type_NumbericRangeQuantification = new TypeBuilder("logicformulation", "NumbericRangeQuantification");
		type_NumbericRangeQuantification.isAbstract = false;
		type_NumbericRangeQuantification.isFinal = false;
		type_NumbericRangeQuantification.superTypeNames.add("logicformulation.Quantification");
		{
			// Attribute Definition: upper_bound
			AttributeBuilder attr_upper_bound = new AttributeBuilder("upper_bound");
			attr_upper_bound.extensionID = "logicformulation";
			attr_upper_bound.valueTypeName = "primitives.<int>";
			attr_upper_bound.isContainment = true;
			type_NumbericRangeQuantification.attributes.add(attr_upper_bound);
			
			// Attribute Definition: lower_bound
			AttributeBuilder attr_lower_bound = new AttributeBuilder("lower_bound");
			attr_lower_bound.extensionID = "logicformulation";
			attr_lower_bound.valueTypeName = "primitives.<int>";
			attr_lower_bound.isContainment = true;
			type_NumbericRangeQuantification.attributes.add(attr_lower_bound);
			
		}
		types.add(type_NumbericRangeQuantification);
		
		// Type Definition: BindableElement
		TypeBuilder type_BindableElement = new TypeBuilder("variable", "BindableElement");
		type_BindableElement.isAbstract = true;
		type_BindableElement.isFinal = false;
		type_BindableElement.superTypeNames.add("core.ModelElement");
		{
			// Attribute Definition: bindTo
			AttributeBuilder attr_bindTo = new AttributeBuilder("bindTo");
			attr_bindTo.extensionID = "variable";
			attr_bindTo.valueTypeName = "data.EntityElement";
			attr_bindTo.isContainment = false;
			type_BindableElement.attributes.add(attr_bindTo);
			
		}
		types.add(type_BindableElement);
		
		// Type Definition: Variable
		TypeBuilder type_Variable = new TypeBuilder("variable", "Variable");
		type_Variable.isAbstract = true;
		type_Variable.isFinal = false;
		type_Variable.superTypeNames.add("variable.BindableElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "variable";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Variable.attributes.add(attr_name);
			
		}
		types.add(type_Variable);
		
		// Type Definition: IndividualVariable
		TypeBuilder type_IndividualVariable = new TypeBuilder("variable", "IndividualVariable");
		type_IndividualVariable.isAbstract = false;
		type_IndividualVariable.isFinal = false;
		type_IndividualVariable.superTypeNames.add("variable.Variable");
		{
		}
		types.add(type_IndividualVariable);
		
		// Type Definition: SetVariable
		TypeBuilder type_SetVariable = new TypeBuilder("variable", "SetVariable");
		type_SetVariable.isAbstract = false;
		type_SetVariable.isFinal = false;
		type_SetVariable.superTypeNames.add("variable.Variable");
		{
		}
		types.add(type_SetVariable);
		
		// Type Definition: RelationVariable
		TypeBuilder type_RelationVariable = new TypeBuilder("variable", "RelationVariable");
		type_RelationVariable.isAbstract = false;
		type_RelationVariable.isFinal = false;
		type_RelationVariable.superTypeNames.add("variable.Variable");
		{
		}
		types.add(type_RelationVariable);
		
		// Type Definition: ValueVariable
		TypeBuilder type_ValueVariable = new TypeBuilder("variable", "ValueVariable");
		type_ValueVariable.isAbstract = false;
		type_ValueVariable.isFinal = false;
		type_ValueVariable.superTypeNames.add("variable.Variable");
		{
		}
		types.add(type_ValueVariable);
		
		// Type Definition: EntityElement
		TypeBuilder type_EntityElement = new TypeBuilder("data", "EntityElement");
		type_EntityElement.isAbstract = false;
		type_EntityElement.isFinal = false;
		type_EntityElement.superTypeNames.add("core.ModelElement");
		{
		}
		types.add(type_EntityElement);
		
		// Type Definition: EntityIndividual
		TypeBuilder type_EntityIndividual = new TypeBuilder("data", "EntityIndividual");
		type_EntityIndividual.isAbstract = false;
		type_EntityIndividual.isFinal = false;
		type_EntityIndividual.superTypeNames.add("data.EntityElement");
		{
			// Attribute Definition: value
			AttributeBuilder attr_value = new AttributeBuilder("value");
			attr_value.extensionID = "data";
			attr_value.valueTypeName = "core.ModelElement";
			attr_value.isContainment = false;
			type_EntityIndividual.attributes.add(attr_value);
			
		}
		types.add(type_EntityIndividual);
		
		// Type Definition: EntitySet
		TypeBuilder type_EntitySet = new TypeBuilder("data", "EntitySet");
		type_EntitySet.isAbstract = false;
		type_EntitySet.isFinal = false;
		type_EntitySet.superTypeNames.add("data.EntityElement");
		{
			// Attribute Definition: elements
			AttributeBuilder attr_elements = new AttributeBuilder("elements");
			attr_elements.extensionID = "data";
			attr_elements.valueTypeName = "primitives.<list>";
			attr_elements.isContainment = false;
			attr_elements.valueTypeParameter = "data.EntityElement";
			type_EntitySet.attributes.add(attr_elements);
			
		}
		types.add(type_EntitySet);
		
		// Type Definition: EntityRelation
		TypeBuilder type_EntityRelation = new TypeBuilder("data", "EntityRelation");
		type_EntityRelation.isAbstract = false;
		type_EntityRelation.isFinal = false;
		type_EntityRelation.superTypeNames.add("data.EntityElement");
		{
			// Attribute Definition: elements
			AttributeBuilder attr_elements = new AttributeBuilder("elements");
			attr_elements.extensionID = "data";
			attr_elements.valueTypeName = "primitives.<list>";
			attr_elements.isContainment = false;
			attr_elements.valueTypeParameter = "data.EntityElement";
			type_EntityRelation.attributes.add(attr_elements);
			
		}
		types.add(type_EntityRelation);
		
		// Type Definition: EntityValue
		TypeBuilder type_EntityValue = new TypeBuilder("data", "EntityValue");
		type_EntityValue.isAbstract = false;
		type_EntityValue.isFinal = false;
		type_EntityValue.superTypeNames.add("data.EntityElement");
		{
			// Attribute Definition: boolValue
			AttributeBuilder attr_boolValue = new AttributeBuilder("boolValue");
			attr_boolValue.extensionID = "data";
			attr_boolValue.valueTypeName = "primitives.<bool>";
			attr_boolValue.isContainment = true;
			type_EntityValue.attributes.add(attr_boolValue);
			
			// Attribute Definition: intValue
			AttributeBuilder attr_intValue = new AttributeBuilder("intValue");
			attr_intValue.extensionID = "data";
			attr_intValue.valueTypeName = "primitives.<int>";
			attr_intValue.isContainment = true;
			type_EntityValue.attributes.add(attr_intValue);
			
			// Attribute Definition: floatValue
			AttributeBuilder attr_floatValue = new AttributeBuilder("floatValue");
			attr_floatValue.extensionID = "data";
			attr_floatValue.valueTypeName = "primitives.<float>";
			attr_floatValue.isContainment = true;
			type_EntityValue.attributes.add(attr_floatValue);
			
			// Attribute Definition: doubleValue
			AttributeBuilder attr_doubleValue = new AttributeBuilder("doubleValue");
			attr_doubleValue.extensionID = "data";
			attr_doubleValue.valueTypeName = "primitives.<double>";
			attr_doubleValue.isContainment = true;
			type_EntityValue.attributes.add(attr_doubleValue);
			
			// Attribute Definition: stringValue
			AttributeBuilder attr_stringValue = new AttributeBuilder("stringValue");
			attr_stringValue.extensionID = "data";
			attr_stringValue.valueTypeName = "primitives.<string>";
			attr_stringValue.isContainment = true;
			type_EntityValue.attributes.add(attr_stringValue);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "data";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "data.EntityValueType";
			type_EntityValue.attributes.add(attr_type);
			
		}
		types.add(type_EntityValue);
		
		// Type Definition: EntityValueType
		TypeBuilder type_EntityValueType = new TypeBuilder("data", "EntityValueType");
		type_EntityValueType.enumValues = new String[] { "Boolean", "Integer", "Float", "Double", "String", };
		types.add(type_EntityValueType);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("logicformulation.Statement", cn.edu.buaa.sei.emt.logic.StatementImpl.class);
		map.put("logicformulation.PropositionVariable", cn.edu.buaa.sei.emt.logic.PropositionVariableImpl.class);
		map.put("logicformulation.PredicateFormulation", cn.edu.buaa.sei.emt.logic.PredicateFormulationImpl.class);
		map.put("logicformulation.Negation", cn.edu.buaa.sei.emt.logic.NegationImpl.class);
		map.put("logicformulation.ExclusiveDisjunction", cn.edu.buaa.sei.emt.logic.ExclusiveDisjunctionImpl.class);
		map.put("logicformulation.Equivalence", cn.edu.buaa.sei.emt.logic.EquivalenceImpl.class);
		map.put("logicformulation.Implication", cn.edu.buaa.sei.emt.logic.ImplicationImpl.class);
		map.put("logicformulation.NAND", cn.edu.buaa.sei.emt.logic.NANDImpl.class);
		map.put("logicformulation.NOR", cn.edu.buaa.sei.emt.logic.NORImpl.class);
		map.put("logicformulation.Conjunction", cn.edu.buaa.sei.emt.logic.ConjunctionImpl.class);
		map.put("logicformulation.Disjunction", cn.edu.buaa.sei.emt.logic.DisjunctionImpl.class);
		map.put("logicformulation.UniversalQuantification", cn.edu.buaa.sei.emt.logic.UniversalQuantificationImpl.class);
		map.put("logicformulation.AtLeastQuantification", cn.edu.buaa.sei.emt.logic.AtLeastQuantificationImpl.class);
		map.put("logicformulation.ExistentialQuantification", cn.edu.buaa.sei.emt.logic.ExistentialQuantificationImpl.class);
		map.put("logicformulation.AtMostQuantification", cn.edu.buaa.sei.emt.logic.AtMostQuantificationImpl.class);
		map.put("logicformulation.AtMostOneQuantification", cn.edu.buaa.sei.emt.logic.AtMostOneQuantificationImpl.class);
		map.put("logicformulation.NumbericRangeQuantification", cn.edu.buaa.sei.emt.logic.NumbericRangeQuantificationImpl.class);
		map.put("variable.IndividualVariable", cn.edu.buaa.sei.emt.logic.IndividualVariableImpl.class);
		map.put("variable.SetVariable", cn.edu.buaa.sei.emt.logic.SetVariableImpl.class);
		map.put("variable.RelationVariable", cn.edu.buaa.sei.emt.logic.RelationVariableImpl.class);
		map.put("variable.ValueVariable", cn.edu.buaa.sei.emt.logic.ValueVariableImpl.class);
		map.put("data.EntityElement", cn.edu.buaa.sei.emt.logic.EntityElementImpl.class);
		map.put("data.EntityIndividual", cn.edu.buaa.sei.emt.logic.EntityIndividualImpl.class);
		map.put("data.EntitySet", cn.edu.buaa.sei.emt.logic.EntitySetImpl.class);
		map.put("data.EntityRelation", cn.edu.buaa.sei.emt.logic.EntityRelationImpl.class);
		map.put("data.EntityValue", cn.edu.buaa.sei.emt.logic.EntityValueImpl.class);
		return map;
	}
	
}
