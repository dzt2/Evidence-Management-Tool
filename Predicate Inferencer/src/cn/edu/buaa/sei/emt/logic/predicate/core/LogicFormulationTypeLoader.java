package cn.edu.buaa.sei.emt.logic.predicate.core;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import cn.edu.buaa.sei.lmf.AttributeBuilder;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.TypeBuilder;
import cn.edu.buaa.sei.lmf.TypeLoader;

public class LogicFormulationTypeLoader implements TypeLoader {
	
	
	
	@Override
	public Set<TypeBuilder> loadTypes(Map<String, TypeBuilder> existingTypes) {
		Set<TypeBuilder> types = new HashSet<TypeBuilder>();
		
		// Type Definition: LogicFormulation
		TypeBuilder type_LogicFormulation = new TypeBuilder("logic_form", "LogicFormulation");
		type_LogicFormulation.isAbstract = true;
		type_LogicFormulation.isFinal = false;
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "logic_form";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_LogicFormulation.attributes.add(attr_name);
			
		}
		types.add(type_LogicFormulation);
		
		// Type Definition: LogicExpression
		TypeBuilder type_LogicExpression = new TypeBuilder("logic_form", "LogicExpression");
		type_LogicExpression.isAbstract = false;
		type_LogicExpression.isFinal = false;
		type_LogicExpression.superTypeNames.add("logic_form.LogicFormulation");
		{
			// Attribute Definition: operator
			AttributeBuilder attr_operator = new AttributeBuilder("operator");
			attr_operator.extensionID = "logic_form";
			attr_operator.valueTypeName = "logic_form.LogicOperator";
			attr_operator.isContainment = false;
			type_LogicExpression.attributes.add(attr_operator);
			
		}
		types.add(type_LogicExpression);
		
		// Type Definition: AtomFormulation
		TypeBuilder type_AtomFormulation = new TypeBuilder("logic_form", "AtomFormulation");
		type_AtomFormulation.isAbstract = true;
		type_AtomFormulation.isFinal = false;
		type_AtomFormulation.superTypeNames.add("logic_form.LogicFormulation");
		{
		}
		types.add(type_AtomFormulation);
		
		// Type Definition: PropositionVariable
		TypeBuilder type_PropositionVariable = new TypeBuilder("logic_form", "PropositionVariable");
		type_PropositionVariable.isAbstract = false;
		type_PropositionVariable.isFinal = false;
		type_PropositionVariable.superTypeNames.add("logic_form.AtomFormulation");
		type_PropositionVariable.superTypeNames.add("variable.Variable");
		{
			// Attribute Definition: t_value
			AttributeBuilder attr_t_value = new AttributeBuilder("t_value");
			attr_t_value.extensionID = "logic_form";
			attr_t_value.valueTypeName = "value.BooleanObject";
			attr_t_value.isContainment = false;
			type_PropositionVariable.attributes.add(attr_t_value);
			
		}
		types.add(type_PropositionVariable);
		
		// Type Definition: PredicateFormulation
		TypeBuilder type_PredicateFormulation = new TypeBuilder("logic_form", "PredicateFormulation");
		type_PredicateFormulation.isAbstract = false;
		type_PredicateFormulation.isFinal = false;
		type_PredicateFormulation.superTypeNames.add("logic_form.AtomFormulation");
		type_PredicateFormulation.superTypeNames.add("variable.Bindable");
		{
			// Attribute Definition: variables
			AttributeBuilder attr_variables = new AttributeBuilder("variables");
			attr_variables.extensionID = "logic_form";
			attr_variables.valueTypeName = "primitives.<list>";
			attr_variables.isContainment = false;
			attr_variables.valueTypeParameter = "variable.Variable";
			type_PredicateFormulation.attributes.add(attr_variables);
			
		}
		types.add(type_PredicateFormulation);
		
		// Type Definition: Quantification
		TypeBuilder type_Quantification = new TypeBuilder("logic_form", "Quantification");
		type_Quantification.isAbstract = true;
		type_Quantification.isFinal = false;
		type_Quantification.superTypeNames.add("logic_form.LogicFormulation");
		{
			// Attribute Definition: domain
			AttributeBuilder attr_domain = new AttributeBuilder("domain");
			attr_domain.extensionID = "logic_form";
			attr_domain.valueTypeName = "variable.DiscourseDomain";
			attr_domain.isContainment = false;
			type_Quantification.attributes.add(attr_domain);
			
			// Attribute Definition: scope_formulation
			AttributeBuilder attr_scope_formulation = new AttributeBuilder("scope_formulation");
			attr_scope_formulation.extensionID = "logic_form";
			attr_scope_formulation.valueTypeName = "logic_form.LogicFormulation";
			attr_scope_formulation.isContainment = false;
			type_Quantification.attributes.add(attr_scope_formulation);
			
		}
		types.add(type_Quantification);
		
		// Type Definition: Universal
		TypeBuilder type_Universal = new TypeBuilder("logic_form", "Universal");
		type_Universal.isAbstract = false;
		type_Universal.isFinal = false;
		type_Universal.superTypeNames.add("logic_form.Quantification");
		{
		}
		types.add(type_Universal);
		
		// Type Definition: Existential
		TypeBuilder type_Existential = new TypeBuilder("logic_form", "Existential");
		type_Existential.isAbstract = false;
		type_Existential.isFinal = false;
		type_Existential.superTypeNames.add("logic_form.Quantification");
		{
		}
		types.add(type_Existential);
		
		// Type Definition: LogicOperator
		TypeBuilder type_LogicOperator = new TypeBuilder("logic_form", "LogicOperator");
		type_LogicOperator.isAbstract = true;
		type_LogicOperator.isFinal = false;
		{
		}
		types.add(type_LogicOperator);
		
		// Type Definition: Conjunction
		TypeBuilder type_Conjunction = new TypeBuilder("logic_form", "Conjunction");
		type_Conjunction.isAbstract = false;
		type_Conjunction.isFinal = false;
		type_Conjunction.superTypeNames.add("logic_form.LogicOperator");
		{
			// Attribute Definition: formulations
			AttributeBuilder attr_formulations = new AttributeBuilder("formulations");
			attr_formulations.extensionID = "logic_form";
			attr_formulations.valueTypeName = "primitives.<list>";
			attr_formulations.isContainment = false;
			attr_formulations.valueTypeParameter = "logic_form.LogicFormulation";
			type_Conjunction.attributes.add(attr_formulations);
			
		}
		types.add(type_Conjunction);
		
		// Type Definition: Disjunction
		TypeBuilder type_Disjunction = new TypeBuilder("logic_form", "Disjunction");
		type_Disjunction.isAbstract = false;
		type_Disjunction.isFinal = false;
		type_Disjunction.superTypeNames.add("logic_form.LogicOperator");
		{
			// Attribute Definition: formulations
			AttributeBuilder attr_formulations = new AttributeBuilder("formulations");
			attr_formulations.extensionID = "logic_form";
			attr_formulations.valueTypeName = "primitives.<list>";
			attr_formulations.isContainment = false;
			attr_formulations.valueTypeParameter = "logic_form.LogicFormulation";
			type_Disjunction.attributes.add(attr_formulations);
			
		}
		types.add(type_Disjunction);
		
		// Type Definition: Negation
		TypeBuilder type_Negation = new TypeBuilder("logic_form", "Negation");
		type_Negation.isAbstract = false;
		type_Negation.isFinal = false;
		type_Negation.superTypeNames.add("logic_form.LogicOperator");
		{
			// Attribute Definition: formulation
			AttributeBuilder attr_formulation = new AttributeBuilder("formulation");
			attr_formulation.extensionID = "logic_form";
			attr_formulation.valueTypeName = "logic_form.LogicFormulation";
			attr_formulation.isContainment = false;
			type_Negation.attributes.add(attr_formulation);
			
		}
		types.add(type_Negation);
		
		// Type Definition: Implication
		TypeBuilder type_Implication = new TypeBuilder("logic_form", "Implication");
		type_Implication.isAbstract = false;
		type_Implication.isFinal = false;
		type_Implication.superTypeNames.add("logic_form.LogicOperator");
		{
			// Attribute Definition: premise
			AttributeBuilder attr_premise = new AttributeBuilder("premise");
			attr_premise.extensionID = "logic_form";
			attr_premise.valueTypeName = "logic_form.LogicFormulation";
			attr_premise.isContainment = false;
			type_Implication.attributes.add(attr_premise);
			
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "logic_form";
			attr_conclusion.valueTypeName = "logic_form.LogicFormulation";
			attr_conclusion.isContainment = false;
			type_Implication.attributes.add(attr_conclusion);
			
		}
		types.add(type_Implication);
		
		// Type Definition: Equivalence
		TypeBuilder type_Equivalence = new TypeBuilder("logic_form", "Equivalence");
		type_Equivalence.isAbstract = false;
		type_Equivalence.isFinal = false;
		type_Equivalence.superTypeNames.add("logic_form.LogicOperator");
		{
			// Attribute Definition: formulation1
			AttributeBuilder attr_formulation1 = new AttributeBuilder("formulation1");
			attr_formulation1.extensionID = "logic_form";
			attr_formulation1.valueTypeName = "logic_form.LogicFormulation";
			attr_formulation1.isContainment = false;
			type_Equivalence.attributes.add(attr_formulation1);
			
			// Attribute Definition: formulation2
			AttributeBuilder attr_formulation2 = new AttributeBuilder("formulation2");
			attr_formulation2.extensionID = "logic_form";
			attr_formulation2.valueTypeName = "logic_form.LogicFormulation";
			attr_formulation2.isContainment = false;
			type_Equivalence.attributes.add(attr_formulation2);
			
		}
		types.add(type_Equivalence);
		
		// Type Definition: Bindable
		TypeBuilder type_Bindable = new TypeBuilder("variable", "Bindable");
		type_Bindable.isAbstract = true;
		type_Bindable.isFinal = false;
		{
			// Attribute Definition: value
			AttributeBuilder attr_value = new AttributeBuilder("value");
			attr_value.extensionID = "variable";
			attr_value.valueTypeName = "value.Value";
			attr_value.isContainment = false;
			type_Bindable.attributes.add(attr_value);
			
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "variable";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Bindable.attributes.add(attr_name);
			
		}
		types.add(type_Bindable);
		
		// Type Definition: Variable
		TypeBuilder type_Variable = new TypeBuilder("variable", "Variable");
		type_Variable.isAbstract = false;
		type_Variable.isFinal = false;
		type_Variable.superTypeNames.add("variable.Bindable");
		{
			// Attribute Definition: object
			AttributeBuilder attr_object = new AttributeBuilder("object");
			attr_object.extensionID = "variable";
			attr_object.valueTypeName = "value.LObject";
			attr_object.isContainment = false;
			type_Variable.attributes.add(attr_object);
			
		}
		types.add(type_Variable);
		
		// Type Definition: DiscourseDomain
		TypeBuilder type_DiscourseDomain = new TypeBuilder("variable", "DiscourseDomain");
		type_DiscourseDomain.isAbstract = false;
		type_DiscourseDomain.isFinal = false;
		type_DiscourseDomain.superTypeNames.add("variable.Bindable");
		{
			// Attribute Definition: set
			AttributeBuilder attr_set = new AttributeBuilder("set");
			attr_set.extensionID = "variable";
			attr_set.valueTypeName = "value.LSet";
			attr_set.isContainment = false;
			type_DiscourseDomain.attributes.add(attr_set);
			
		}
		types.add(type_DiscourseDomain);
		
		// Type Definition: Value
		TypeBuilder type_Value = new TypeBuilder("value", "Value");
		type_Value.isAbstract = false;
		type_Value.isFinal = false;
		{
		}
		types.add(type_Value);
		
		// Type Definition: LObject
		TypeBuilder type_LObject = new TypeBuilder("value", "LObject");
		type_LObject.isAbstract = false;
		type_LObject.isFinal = false;
		type_LObject.superTypeNames.add("value.Value");
		{
			// Attribute Definition: id
			AttributeBuilder attr_id = new AttributeBuilder("id");
			attr_id.extensionID = "value";
			attr_id.valueTypeName = "primitives.<string>";
			attr_id.isContainment = true;
			type_LObject.attributes.add(attr_id);
			
		}
		types.add(type_LObject);
		
		// Type Definition: BooleanObject
		TypeBuilder type_BooleanObject = new TypeBuilder("value", "BooleanObject");
		type_BooleanObject.isAbstract = false;
		type_BooleanObject.isFinal = false;
		type_BooleanObject.superTypeNames.add("value.LObject");
		{
			// Attribute Definition: bool_val
			AttributeBuilder attr_bool_val = new AttributeBuilder("bool_val");
			attr_bool_val.extensionID = "value";
			attr_bool_val.valueTypeName = "primitives.<bool>";
			attr_bool_val.isContainment = true;
			type_BooleanObject.attributes.add(attr_bool_val);
			
		}
		types.add(type_BooleanObject);
		
		// Type Definition: LSet
		TypeBuilder type_LSet = new TypeBuilder("value", "LSet");
		type_LSet.isAbstract = false;
		type_LSet.isFinal = false;
		type_LSet.superTypeNames.add("value.Value");
		{
			// Attribute Definition: values
			AttributeBuilder attr_values = new AttributeBuilder("values");
			attr_values.extensionID = "value";
			attr_values.valueTypeName = "primitives.<list>";
			attr_values.isContainment = false;
			attr_values.valueTypeParameter = "value.LObject";
			type_LSet.attributes.add(attr_values);
			
		}
		types.add(type_LSet);
		
		// Type Definition: LRelation
		TypeBuilder type_LRelation = new TypeBuilder("value", "LRelation");
		type_LRelation.isAbstract = false;
		type_LRelation.isFinal = false;
		type_LRelation.superTypeNames.add("value.Value");
		{
			// Attribute Definition: elements
			AttributeBuilder attr_elements = new AttributeBuilder("elements");
			attr_elements.extensionID = "value";
			attr_elements.valueTypeName = "primitives.<list>";
			attr_elements.isContainment = false;
			attr_elements.valueTypeParameter = "value.LObject";
			type_LRelation.attributes.add(attr_elements);
			
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "value";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_LRelation.attributes.add(attr_name);
			
		}
		types.add(type_LRelation);
		
		// Type Definition: LRelationSet
		TypeBuilder type_LRelationSet = new TypeBuilder("value", "LRelationSet");
		type_LRelationSet.isAbstract = false;
		type_LRelationSet.isFinal = false;
		type_LRelationSet.superTypeNames.add("value.Value");
		{
			// Attribute Definition: relations
			AttributeBuilder attr_relations = new AttributeBuilder("relations");
			attr_relations.extensionID = "value";
			attr_relations.valueTypeName = "primitives.<list>";
			attr_relations.isContainment = false;
			attr_relations.valueTypeParameter = "value.LRelation";
			type_LRelationSet.attributes.add(attr_relations);
			
		}
		types.add(type_LRelationSet);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("logic_form.LogicExpression", cn.edu.buaa.sei.emt.logic.predicate.core.LogicExpressionImpl.class);
		map.put("logic_form.PropositionVariable", cn.edu.buaa.sei.emt.logic.predicate.core.PropositionVariableImpl.class);
		map.put("logic_form.PredicateFormulation", cn.edu.buaa.sei.emt.logic.predicate.core.PredicateFormulationImpl.class);
		map.put("logic_form.Universal", cn.edu.buaa.sei.emt.logic.predicate.core.UniversalImpl.class);
		map.put("logic_form.Existential", cn.edu.buaa.sei.emt.logic.predicate.core.ExistentialImpl.class);
		map.put("logic_form.Conjunction", cn.edu.buaa.sei.emt.logic.predicate.core.ConjunctionImpl.class);
		map.put("logic_form.Disjunction", cn.edu.buaa.sei.emt.logic.predicate.core.DisjunctionImpl.class);
		map.put("logic_form.Negation", cn.edu.buaa.sei.emt.logic.predicate.core.NegationImpl.class);
		map.put("logic_form.Implication", cn.edu.buaa.sei.emt.logic.predicate.core.ImplicationImpl.class);
		map.put("logic_form.Equivalence", cn.edu.buaa.sei.emt.logic.predicate.core.EquivalenceImpl.class);
		map.put("variable.Variable", cn.edu.buaa.sei.emt.logic.predicate.core.VariableImpl.class);
		map.put("variable.DiscourseDomain", cn.edu.buaa.sei.emt.logic.predicate.core.DiscourseDomainImpl.class);
		map.put("value.Value", cn.edu.buaa.sei.emt.logic.predicate.core.ValueImpl.class);
		map.put("value.LObject", cn.edu.buaa.sei.emt.logic.predicate.core.LObjectImpl.class);
		map.put("value.BooleanObject", cn.edu.buaa.sei.emt.logic.predicate.core.BooleanObjectImpl.class);
		map.put("value.LSet", cn.edu.buaa.sei.emt.logic.predicate.core.LSetImpl.class);
		map.put("value.LRelation", cn.edu.buaa.sei.emt.logic.predicate.core.LRelationImpl.class);
		map.put("value.LRelationSet", cn.edu.buaa.sei.emt.logic.predicate.core.LRelationSetImpl.class);
		return map;
	}
	
}
