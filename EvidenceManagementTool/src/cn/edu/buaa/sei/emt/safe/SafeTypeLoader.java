package cn.edu.buaa.sei.emt.safe;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import cn.edu.buaa.sei.lmf.AttributeBuilder;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.TypeBuilder;
import cn.edu.buaa.sei.lmf.TypeLoader;

public class SafeTypeLoader implements TypeLoader {
	
	
	
	@Override
	public Set<TypeBuilder> loadTypes(Map<String, TypeBuilder> existingTypes) {
		Set<TypeBuilder> types = new HashSet<TypeBuilder>();
		
		// Type Definition: SElement
		TypeBuilder type_SElement = new TypeBuilder("safe", "SElement");
		type_SElement.isAbstract = true;
		type_SElement.isFinal = false;
		type_SElement.superTypeNames.add("core.Element");
		{
		}
		types.add(type_SElement);
		
		// Type Definition: SNode
		TypeBuilder type_SNode = new TypeBuilder("safe", "SNode");
		type_SNode.isAbstract = true;
		type_SNode.isFinal = false;
		type_SNode.superTypeNames.add("safe.SElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "safe";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_SNode.attributes.add(attr_name);
			
		}
		types.add(type_SNode);
		
		// Type Definition: Assertion
		TypeBuilder type_Assertion = new TypeBuilder("safe", "Assertion");
		type_Assertion.isAbstract = true;
		type_Assertion.isFinal = false;
		type_Assertion.superTypeNames.add("safe.SNode");
		{
			// Attribute Definition: statement
			AttributeBuilder attr_statement = new AttributeBuilder("statement");
			attr_statement.extensionID = "safe";
			attr_statement.valueTypeName = "primitives.<string>";
			attr_statement.isContainment = true;
			type_Assertion.attributes.add(attr_statement);
			
			// Attribute Definition: assured_result
			AttributeBuilder attr_assured_result = new AttributeBuilder("assured_result");
			attr_assured_result.extensionID = "safe";
			attr_assured_result.valueTypeName = "primitives.<bool>";
			attr_assured_result.isContainment = true;
			type_Assertion.attributes.add(attr_assured_result);
			
			// Attribute Definition: result
			AttributeBuilder attr_result = new AttributeBuilder("result");
			attr_result.extensionID = "safe";
			attr_result.valueTypeName = "primitives.<bool>";
			attr_result.isContainment = true;
			type_Assertion.attributes.add(attr_result);
			
		}
		types.add(type_Assertion);
		
		// Type Definition: Inference
		TypeBuilder type_Inference = new TypeBuilder("safe", "Inference");
		type_Inference.isAbstract = true;
		type_Inference.isFinal = false;
		type_Inference.superTypeNames.add("safe.Assertion");
		{
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.Assertion";
			attr_conclusion.isContainment = false;
			type_Inference.attributes.add(attr_conclusion);
			
			// Attribute Definition: premise
			AttributeBuilder attr_premise = new AttributeBuilder("premise");
			attr_premise.extensionID = "safe";
			attr_premise.valueTypeName = "primitives.<list>";
			attr_premise.isContainment = false;
			attr_premise.valueTypeParameter = "safe.Assertion";
			type_Inference.attributes.add(attr_premise);
			
			// Attribute Definition: rationale
			AttributeBuilder attr_rationale = new AttributeBuilder("rationale");
			attr_rationale.extensionID = "safe";
			attr_rationale.valueTypeName = "primitives.<string>";
			attr_rationale.isContainment = true;
			type_Inference.attributes.add(attr_rationale);
			
		}
		types.add(type_Inference);
		
		// Type Definition: Claim
		TypeBuilder type_Claim = new TypeBuilder("safe", "Claim");
		type_Claim.isAbstract = false;
		type_Claim.isFinal = false;
		type_Claim.superTypeNames.add("safe.Assertion");
		{
		}
		types.add(type_Claim);
		
		// Type Definition: Assumption
		TypeBuilder type_Assumption = new TypeBuilder("safe", "Assumption");
		type_Assumption.isAbstract = false;
		type_Assumption.isFinal = false;
		type_Assumption.superTypeNames.add("safe.Assertion");
		{
		}
		types.add(type_Assumption);
		
		// Type Definition: Justification
		TypeBuilder type_Justification = new TypeBuilder("safe", "Justification");
		type_Justification.isAbstract = false;
		type_Justification.isFinal = false;
		type_Justification.superTypeNames.add("safe.Assertion");
		{
		}
		types.add(type_Justification);
		
		// Type Definition: Context
		TypeBuilder type_Context = new TypeBuilder("safe", "Context");
		type_Context.isAbstract = false;
		type_Context.isFinal = false;
		type_Context.superTypeNames.add("safe.SNode");
		{
			// Attribute Definition: context
			AttributeBuilder attr_context = new AttributeBuilder("context");
			attr_context.extensionID = "safe";
			attr_context.valueTypeName = "primitives.<string>";
			attr_context.isContainment = true;
			type_Context.attributes.add(attr_context);
			
		}
		types.add(type_Context);
		
		// Type Definition: EvidenceReference
		TypeBuilder type_EvidenceReference = new TypeBuilder("safe", "EvidenceReference");
		type_EvidenceReference.isAbstract = true;
		type_EvidenceReference.isFinal = false;
		type_EvidenceReference.superTypeNames.add("safe.SNode");
		{
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "safe";
			attr_evidence.valueTypeName = "evidence.EvidenceElement";
			attr_evidence.isContainment = false;
			type_EvidenceReference.attributes.add(attr_evidence);
			
		}
		types.add(type_EvidenceReference);
		
		// Type Definition: SRelation
		TypeBuilder type_SRelation = new TypeBuilder("safe", "SRelation");
		type_SRelation.isAbstract = true;
		type_SRelation.isFinal = false;
		type_SRelation.superTypeNames.add("safe.SElement");
		{
			// Attribute Definition: source
			AttributeBuilder attr_source = new AttributeBuilder("source");
			attr_source.extensionID = "safe";
			attr_source.valueTypeName = "safe.SNode";
			attr_source.isContainment = false;
			type_SRelation.attributes.add(attr_source);
			
			// Attribute Definition: target
			AttributeBuilder attr_target = new AttributeBuilder("target");
			attr_target.extensionID = "safe";
			attr_target.valueTypeName = "safe.SNode";
			attr_target.isContainment = false;
			type_SRelation.attributes.add(attr_target);
			
		}
		types.add(type_SRelation);
		
		// Type Definition: SupportByClaim
		TypeBuilder type_SupportByClaim = new TypeBuilder("safe", "SupportByClaim");
		type_SupportByClaim.isAbstract = false;
		type_SupportByClaim.isFinal = false;
		type_SupportByClaim.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: premise
			AttributeBuilder attr_premise = new AttributeBuilder("premise");
			attr_premise.extensionID = "safe";
			attr_premise.valueTypeName = "safe.Claim";
			attr_premise.isContainment = false;
			type_SupportByClaim.attributes.add(attr_premise);
			
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.Claim";
			attr_conclusion.isContainment = false;
			type_SupportByClaim.attributes.add(attr_conclusion);
			
		}
		types.add(type_SupportByClaim);
		
		// Type Definition: ChallengeByClaim
		TypeBuilder type_ChallengeByClaim = new TypeBuilder("safe", "ChallengeByClaim");
		type_ChallengeByClaim.isAbstract = false;
		type_ChallengeByClaim.isFinal = false;
		type_ChallengeByClaim.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: premise
			AttributeBuilder attr_premise = new AttributeBuilder("premise");
			attr_premise.extensionID = "safe";
			attr_premise.valueTypeName = "safe.Claim";
			attr_premise.isContainment = false;
			type_ChallengeByClaim.attributes.add(attr_premise);
			
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.Claim";
			attr_conclusion.isContainment = false;
			type_ChallengeByClaim.attributes.add(attr_conclusion);
			
		}
		types.add(type_ChallengeByClaim);
		
		// Type Definition: SupportByEvidence
		TypeBuilder type_SupportByEvidence = new TypeBuilder("safe", "SupportByEvidence");
		type_SupportByEvidence.isAbstract = false;
		type_SupportByEvidence.isFinal = false;
		type_SupportByEvidence.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.Claim";
			attr_objective.isContainment = false;
			type_SupportByEvidence.attributes.add(attr_objective);
			
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "safe";
			attr_evidence.valueTypeName = "evidence.EvidenceElement";
			attr_evidence.isContainment = false;
			type_SupportByEvidence.attributes.add(attr_evidence);
			
		}
		types.add(type_SupportByEvidence);
		
		// Type Definition: ChallengeByEvidence
		TypeBuilder type_ChallengeByEvidence = new TypeBuilder("safe", "ChallengeByEvidence");
		type_ChallengeByEvidence.isAbstract = false;
		type_ChallengeByEvidence.isFinal = false;
		type_ChallengeByEvidence.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.Claim";
			attr_objective.isContainment = false;
			type_ChallengeByEvidence.attributes.add(attr_objective);
			
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "safe";
			attr_evidence.valueTypeName = "evidence.EvidenceElement";
			attr_evidence.isContainment = false;
			type_ChallengeByEvidence.attributes.add(attr_evidence);
			
		}
		types.add(type_ChallengeByEvidence);
		
		// Type Definition: AssumedBy
		TypeBuilder type_AssumedBy = new TypeBuilder("safe", "AssumedBy");
		type_AssumedBy.isAbstract = false;
		type_AssumedBy.isFinal = false;
		type_AssumedBy.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.Assertion";
			attr_objective.isContainment = false;
			type_AssumedBy.attributes.add(attr_objective);
			
			// Attribute Definition: assumption
			AttributeBuilder attr_assumption = new AttributeBuilder("assumption");
			attr_assumption.extensionID = "safe";
			attr_assumption.valueTypeName = "safe.Assumption";
			attr_assumption.isContainment = false;
			type_AssumedBy.attributes.add(attr_assumption);
			
		}
		types.add(type_AssumedBy);
		
		// Type Definition: ContextOf
		TypeBuilder type_ContextOf = new TypeBuilder("safe", "ContextOf");
		type_ContextOf.isAbstract = false;
		type_ContextOf.isFinal = false;
		type_ContextOf.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: context
			AttributeBuilder attr_context = new AttributeBuilder("context");
			attr_context.extensionID = "safe";
			attr_context.valueTypeName = "safe.Context";
			attr_context.isContainment = false;
			type_ContextOf.attributes.add(attr_context);
			
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.Assertion";
			attr_objective.isContainment = false;
			type_ContextOf.attributes.add(attr_objective);
			
		}
		types.add(type_ContextOf);
		
		// Type Definition: JustifiedBy
		TypeBuilder type_JustifiedBy = new TypeBuilder("safe", "JustifiedBy");
		type_JustifiedBy.isAbstract = false;
		type_JustifiedBy.isFinal = false;
		type_JustifiedBy.superTypeNames.add("safe.SRelation");
		{
			// Attribute Definition: justification
			AttributeBuilder attr_justification = new AttributeBuilder("justification");
			attr_justification.extensionID = "safe";
			attr_justification.valueTypeName = "safe.Justification";
			attr_justification.isContainment = false;
			type_JustifiedBy.attributes.add(attr_justification);
			
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.Assertion";
			attr_objective.isContainment = false;
			type_JustifiedBy.attributes.add(attr_objective);
			
		}
		types.add(type_JustifiedBy);
		
		// Type Definition: EvidenceElement
		TypeBuilder type_EvidenceElement = new TypeBuilder("evidence", "EvidenceElement");
		type_EvidenceElement.isAbstract = true;
		type_EvidenceElement.isFinal = false;
		type_EvidenceElement.superTypeNames.add("core.Element");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "evidence";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_EvidenceElement.attributes.add(attr_name);
			
		}
		types.add(type_EvidenceElement);
		
		// Type Definition: Evidence
		TypeBuilder type_Evidence = new TypeBuilder("evidence", "Evidence");
		type_Evidence.isAbstract = true;
		type_Evidence.isFinal = false;
		type_Evidence.superTypeNames.add("evidence.EvidenceElement");
		{
		}
		types.add(type_Evidence);
		
		// Type Definition: EvidenceSuggestion
		TypeBuilder type_EvidenceSuggestion = new TypeBuilder("evidence", "EvidenceSuggestion");
		type_EvidenceSuggestion.isAbstract = true;
		type_EvidenceSuggestion.isFinal = false;
		type_EvidenceSuggestion.superTypeNames.add("evidence.EvidenceElement");
		{
		}
		types.add(type_EvidenceSuggestion);
		
		// Type Definition: XMLEvidence
		TypeBuilder type_XMLEvidence = new TypeBuilder("evidence", "XMLEvidence");
		type_XMLEvidence.isAbstract = false;
		type_XMLEvidence.isFinal = false;
		type_XMLEvidence.superTypeNames.add("evidence.Evidence");
		{
			// Attribute Definition: xml_url
			AttributeBuilder attr_xml_url = new AttributeBuilder("xml_url");
			attr_xml_url.extensionID = "evidence";
			attr_xml_url.valueTypeName = "primitives.<string>";
			attr_xml_url.isContainment = true;
			type_XMLEvidence.attributes.add(attr_xml_url);
			
		}
		types.add(type_XMLEvidence);
		
		// Type Definition: XMLEvidenceSuggestion
		TypeBuilder type_XMLEvidenceSuggestion = new TypeBuilder("evidence", "XMLEvidenceSuggestion");
		type_XMLEvidenceSuggestion.isAbstract = false;
		type_XMLEvidenceSuggestion.isFinal = false;
		type_XMLEvidenceSuggestion.superTypeNames.add("evidence.EvidenceSuggestion");
		{
			// Attribute Definition: schema_url
			AttributeBuilder attr_schema_url = new AttributeBuilder("schema_url");
			attr_schema_url.extensionID = "evidence";
			attr_schema_url.valueTypeName = "primitives.<string>";
			attr_schema_url.isContainment = true;
			type_XMLEvidenceSuggestion.attributes.add(attr_schema_url);
			
		}
		types.add(type_XMLEvidenceSuggestion);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("safe.Claim", cn.edu.buaa.sei.emt.safe.ClaimImpl.class);
		map.put("safe.Assumption", cn.edu.buaa.sei.emt.safe.AssumptionImpl.class);
		map.put("safe.Justification", cn.edu.buaa.sei.emt.safe.JustificationImpl.class);
		map.put("safe.Context", cn.edu.buaa.sei.emt.safe.ContextImpl.class);
		map.put("safe.SupportByClaim", cn.edu.buaa.sei.emt.safe.SupportByClaimImpl.class);
		map.put("safe.ChallengeByClaim", cn.edu.buaa.sei.emt.safe.ChallengeByClaimImpl.class);
		map.put("safe.SupportByEvidence", cn.edu.buaa.sei.emt.safe.SupportByEvidenceImpl.class);
		map.put("safe.ChallengeByEvidence", cn.edu.buaa.sei.emt.safe.ChallengeByEvidenceImpl.class);
		map.put("safe.AssumedBy", cn.edu.buaa.sei.emt.safe.AssumedByImpl.class);
		map.put("safe.ContextOf", cn.edu.buaa.sei.emt.safe.ContextOfImpl.class);
		map.put("safe.JustifiedBy", cn.edu.buaa.sei.emt.safe.JustifiedByImpl.class);
		map.put("evidence.XMLEvidence", cn.edu.buaa.sei.emt.safe.XMLEvidenceImpl.class);
		map.put("evidence.XMLEvidenceSuggestion", cn.edu.buaa.sei.emt.safe.XMLEvidenceSuggestionImpl.class);
		return map;
	}
	
}
