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
		
		// Type Definition: UndevelopedClaim
		TypeBuilder type_UndevelopedClaim = new TypeBuilder("safe", "UndevelopedClaim");
		type_UndevelopedClaim.isAbstract = false;
		type_UndevelopedClaim.isFinal = false;
		type_UndevelopedClaim.superTypeNames.add("safe.Claim");
		{
			// Attribute Definition: case
			AttributeBuilder attr_case = new AttributeBuilder("case");
			attr_case.extensionID = "safe";
			attr_case.valueTypeName = "safe.SafetyCase";
			attr_case.isContainment = false;
			type_UndevelopedClaim.attributes.add(attr_case);
			
		}
		types.add(type_UndevelopedClaim);
		
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
		
		// Type Definition: SafetyCase
		TypeBuilder type_SafetyCase = new TypeBuilder("safe", "SafetyCase");
		type_SafetyCase.isAbstract = false;
		type_SafetyCase.isFinal = false;
		{
			// Attribute Definition: top_goal
			AttributeBuilder attr_top_goal = new AttributeBuilder("top_goal");
			attr_top_goal.extensionID = "safe";
			attr_top_goal.valueTypeName = "safe.Claim";
			attr_top_goal.isContainment = false;
			type_SafetyCase.attributes.add(attr_top_goal);
			
			// Attribute Definition: claims
			AttributeBuilder attr_claims = new AttributeBuilder("claims");
			attr_claims.extensionID = "safe";
			attr_claims.valueTypeName = "primitives.<list>";
			attr_claims.isContainment = false;
			attr_claims.valueTypeParameter = "safe.Claim";
			type_SafetyCase.attributes.add(attr_claims);
			
			// Attribute Definition: assumptions
			AttributeBuilder attr_assumptions = new AttributeBuilder("assumptions");
			attr_assumptions.extensionID = "safe";
			attr_assumptions.valueTypeName = "primitives.<list>";
			attr_assumptions.isContainment = false;
			attr_assumptions.valueTypeParameter = "safe.Assumption";
			type_SafetyCase.attributes.add(attr_assumptions);
			
			// Attribute Definition: justifications
			AttributeBuilder attr_justifications = new AttributeBuilder("justifications");
			attr_justifications.extensionID = "safe";
			attr_justifications.valueTypeName = "primitives.<list>";
			attr_justifications.isContainment = false;
			attr_justifications.valueTypeParameter = "safe.Justification";
			type_SafetyCase.attributes.add(attr_justifications);
			
			// Attribute Definition: contexts
			AttributeBuilder attr_contexts = new AttributeBuilder("contexts");
			attr_contexts.extensionID = "safe";
			attr_contexts.valueTypeName = "primitives.<list>";
			attr_contexts.isContainment = false;
			attr_contexts.valueTypeParameter = "safe.Context";
			type_SafetyCase.attributes.add(attr_contexts);
			
			// Attribute Definition: evidences
			AttributeBuilder attr_evidences = new AttributeBuilder("evidences");
			attr_evidences.extensionID = "safe";
			attr_evidences.valueTypeName = "primitives.<list>";
			attr_evidences.isContainment = false;
			attr_evidences.valueTypeParameter = "safe.EvidenceReference";
			type_SafetyCase.attributes.add(attr_evidences);
			
			// Attribute Definition: extandable_claims
			AttributeBuilder attr_extandable_claims = new AttributeBuilder("extandable_claims");
			attr_extandable_claims.extensionID = "safe";
			attr_extandable_claims.valueTypeName = "primitives.<list>";
			attr_extandable_claims.isContainment = false;
			attr_extandable_claims.valueTypeParameter = "safe.Claim";
			type_SafetyCase.attributes.add(attr_extandable_claims);
			
			// Attribute Definition: claim_supports
			AttributeBuilder attr_claim_supports = new AttributeBuilder("claim_supports");
			attr_claim_supports.extensionID = "safe";
			attr_claim_supports.valueTypeName = "primitives.<list>";
			attr_claim_supports.isContainment = false;
			attr_claim_supports.valueTypeParameter = "safe.SupportByClaim";
			type_SafetyCase.attributes.add(attr_claim_supports);
			
			// Attribute Definition: claim_challenges
			AttributeBuilder attr_claim_challenges = new AttributeBuilder("claim_challenges");
			attr_claim_challenges.extensionID = "safe";
			attr_claim_challenges.valueTypeName = "primitives.<list>";
			attr_claim_challenges.isContainment = false;
			attr_claim_challenges.valueTypeParameter = "safe.ChallengeByClaim";
			type_SafetyCase.attributes.add(attr_claim_challenges);
			
			// Attribute Definition: evidence_supports
			AttributeBuilder attr_evidence_supports = new AttributeBuilder("evidence_supports");
			attr_evidence_supports.extensionID = "safe";
			attr_evidence_supports.valueTypeName = "primitives.<list>";
			attr_evidence_supports.isContainment = false;
			attr_evidence_supports.valueTypeParameter = "safe.SupportByEvidence";
			type_SafetyCase.attributes.add(attr_evidence_supports);
			
			// Attribute Definition: evidence_challenges
			AttributeBuilder attr_evidence_challenges = new AttributeBuilder("evidence_challenges");
			attr_evidence_challenges.extensionID = "safe";
			attr_evidence_challenges.valueTypeName = "primitives.<list>";
			attr_evidence_challenges.isContainment = false;
			attr_evidence_challenges.valueTypeParameter = "safe.ChallengeByEvidence";
			type_SafetyCase.attributes.add(attr_evidence_challenges);
			
			// Attribute Definition: context_links
			AttributeBuilder attr_context_links = new AttributeBuilder("context_links");
			attr_context_links.extensionID = "safe";
			attr_context_links.valueTypeName = "primitives.<list>";
			attr_context_links.isContainment = false;
			attr_context_links.valueTypeParameter = "safe.ContextOf";
			type_SafetyCase.attributes.add(attr_context_links);
			
			// Attribute Definition: assumption_links
			AttributeBuilder attr_assumption_links = new AttributeBuilder("assumption_links");
			attr_assumption_links.extensionID = "safe";
			attr_assumption_links.valueTypeName = "primitives.<list>";
			attr_assumption_links.isContainment = false;
			attr_assumption_links.valueTypeParameter = "safe.AssumedBy";
			type_SafetyCase.attributes.add(attr_assumption_links);
			
			// Attribute Definition: justification_links
			AttributeBuilder attr_justification_links = new AttributeBuilder("justification_links");
			attr_justification_links.extensionID = "safe";
			attr_justification_links.valueTypeName = "primitives.<list>";
			attr_justification_links.isContainment = false;
			attr_justification_links.valueTypeParameter = "safe.JustifiedBy";
			type_SafetyCase.attributes.add(attr_justification_links);
			
			// Attribute Definition: safetycaseReferences
			AttributeBuilder attr_safetycaseReferences = new AttributeBuilder("safetycaseReferences");
			attr_safetycaseReferences.extensionID = "safe";
			attr_safetycaseReferences.valueTypeName = "primitives.<list>";
			attr_safetycaseReferences.isContainment = false;
			attr_safetycaseReferences.valueTypeParameter = "safe.SafetyCase";
			type_SafetyCase.attributes.add(attr_safetycaseReferences);
			
		}
		types.add(type_SafetyCase);
		
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
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("safe.Claim", cn.edu.buaa.sei.emt.safe.ClaimImpl.class);
		map.put("safe.UndevelopedClaim", cn.edu.buaa.sei.emt.safe.UndevelopedClaimImpl.class);
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
		map.put("safe.SafetyCase", cn.edu.buaa.sei.emt.safe.SafetyCaseImpl.class);
		map.put("evidence.XMLEvidence", cn.edu.buaa.sei.emt.safe.XMLEvidenceImpl.class);
		return map;
	}
	
}
