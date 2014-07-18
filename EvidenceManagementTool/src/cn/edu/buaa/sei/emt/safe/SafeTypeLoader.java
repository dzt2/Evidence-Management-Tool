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
		type_SElement.superTypeNames.add("core.ModelElement");
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
		type_Assertion.superTypeNames.add("safe.SElement");
		{
			// Attribute Definition: statement
			AttributeBuilder attr_statement = new AttributeBuilder("statement");
			attr_statement.extensionID = "safe";
			attr_statement.valueTypeName = "primitives.<string>";
			attr_statement.isContainment = true;
			type_Assertion.attributes.add(attr_statement);
			
			// Attribute Definition: valid
			AttributeBuilder attr_valid = new AttributeBuilder("valid");
			attr_valid.extensionID = "safe";
			attr_valid.valueTypeName = "primitives.<bool>";
			attr_valid.isContainment = true;
			type_Assertion.attributes.add(attr_valid);
			
			// Attribute Definition: contexts
			AttributeBuilder attr_contexts = new AttributeBuilder("contexts");
			attr_contexts.extensionID = "safe";
			attr_contexts.valueTypeName = "primitives.<list>";
			attr_contexts.isContainment = false;
			attr_contexts.valueTypeParameter = "safe.Context";
			type_Assertion.attributes.add(attr_contexts);
			
			// Attribute Definition: justifications
			AttributeBuilder attr_justifications = new AttributeBuilder("justifications");
			attr_justifications.extensionID = "safe";
			attr_justifications.valueTypeName = "primitives.<list>";
			attr_justifications.isContainment = false;
			attr_justifications.valueTypeParameter = "safe.Justification";
			type_Assertion.attributes.add(attr_justifications);
			
			// Attribute Definition: assumptions
			AttributeBuilder attr_assumptions = new AttributeBuilder("assumptions");
			attr_assumptions.extensionID = "safe";
			attr_assumptions.valueTypeName = "primitives.<list>";
			attr_assumptions.isContainment = false;
			attr_assumptions.valueTypeParameter = "safe.Assumption";
			type_Assertion.attributes.add(attr_assumptions);
			
		}
		types.add(type_Assertion);
		
		// Type Definition: SInformationElement
		TypeBuilder type_SInformationElement = new TypeBuilder("safe", "SInformationElement");
		type_SInformationElement.isAbstract = true;
		type_SInformationElement.isFinal = false;
		type_SInformationElement.superTypeNames.add("safe.SElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "safe";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_SInformationElement.attributes.add(attr_name);
			
			// Attribute Definition: description
			AttributeBuilder attr_description = new AttributeBuilder("description");
			attr_description.extensionID = "safe";
			attr_description.valueTypeName = "primitives.<string>";
			attr_description.isContainment = true;
			type_SInformationElement.attributes.add(attr_description);
			
		}
		types.add(type_SInformationElement);
		
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
		
		// Type Definition: SMainNode
		TypeBuilder type_SMainNode = new TypeBuilder("safe", "SMainNode");
		type_SMainNode.isAbstract = true;
		type_SMainNode.isFinal = false;
		type_SMainNode.superTypeNames.add("safe.SNode");
		{
		}
		types.add(type_SMainNode);
		
		// Type Definition: SUtilityNode
		TypeBuilder type_SUtilityNode = new TypeBuilder("safe", "SUtilityNode");
		type_SUtilityNode.isAbstract = true;
		type_SUtilityNode.isFinal = false;
		type_SUtilityNode.superTypeNames.add("safe.SNode");
		{
		}
		types.add(type_SUtilityNode);
		
		// Type Definition: SMainRelation
		TypeBuilder type_SMainRelation = new TypeBuilder("safe", "SMainRelation");
		type_SMainRelation.isAbstract = true;
		type_SMainRelation.isFinal = false;
		type_SMainRelation.superTypeNames.add("safe.SRelation");
		{
		}
		types.add(type_SMainRelation);
		
		// Type Definition: SUtilityRelation
		TypeBuilder type_SUtilityRelation = new TypeBuilder("safe", "SUtilityRelation");
		type_SUtilityRelation.isAbstract = true;
		type_SUtilityRelation.isFinal = false;
		type_SUtilityRelation.superTypeNames.add("safe.SRelation");
		{
		}
		types.add(type_SUtilityRelation);
		
		// Type Definition: Claim
		TypeBuilder type_Claim = new TypeBuilder("safe", "Claim");
		type_Claim.isAbstract = true;
		type_Claim.isFinal = false;
		type_Claim.superTypeNames.add("safe.SMainNode");
		type_Claim.superTypeNames.add("safe.Assertion");
		{
			// Attribute Definition: result
			AttributeBuilder attr_result = new AttributeBuilder("result");
			attr_result.extensionID = "safe";
			attr_result.valueTypeName = "primitives.<bool>";
			attr_result.isContainment = true;
			type_Claim.attributes.add(attr_result);
			
			// Attribute Definition: assumed_result
			AttributeBuilder attr_assumed_result = new AttributeBuilder("assumed_result");
			attr_assumed_result.extensionID = "safe";
			attr_assumed_result.valueTypeName = "primitives.<bool>";
			attr_assumed_result.isContainment = true;
			type_Claim.attributes.add(attr_assumed_result);
			
			// Attribute Definition: state
			AttributeBuilder attr_state = new AttributeBuilder("state");
			attr_state.extensionID = "safe";
			attr_state.valueTypeName = "primitives.<enum>";
			attr_state.isContainment = true;
			attr_state.valueTypeParameter = "safe.ClaimState";
			type_Claim.attributes.add(attr_state);
			
			// Attribute Definition: support_claims
			AttributeBuilder attr_support_claims = new AttributeBuilder("support_claims");
			attr_support_claims.extensionID = "safe";
			attr_support_claims.valueTypeName = "primitives.<list>";
			attr_support_claims.isContainment = false;
			attr_support_claims.valueTypeParameter = "safe.ImplClaim";
			type_Claim.attributes.add(attr_support_claims);
			
			// Attribute Definition: support_inferences
			AttributeBuilder attr_support_inferences = new AttributeBuilder("support_inferences");
			attr_support_inferences.extensionID = "safe";
			attr_support_inferences.valueTypeName = "primitives.<list>";
			attr_support_inferences.isContainment = false;
			attr_support_inferences.valueTypeParameter = "safe.Inference";
			type_Claim.attributes.add(attr_support_inferences);
			
		}
		types.add(type_Claim);
		
		// Type Definition: ClaimState
		TypeBuilder type_ClaimState = new TypeBuilder("safe", "ClaimState");
		type_ClaimState.enumValues = new String[] { "Supported", "UnSupported", };
		types.add(type_ClaimState);
		
		// Type Definition: ImplClaim
		TypeBuilder type_ImplClaim = new TypeBuilder("safe", "ImplClaim");
		type_ImplClaim.isAbstract = false;
		type_ImplClaim.isFinal = false;
		type_ImplClaim.superTypeNames.add("safe.Claim");
		{
			// Attribute Definition: sub_claims
			AttributeBuilder attr_sub_claims = new AttributeBuilder("sub_claims");
			attr_sub_claims.extensionID = "safe";
			attr_sub_claims.valueTypeName = "primitives.<list>";
			attr_sub_claims.isContainment = false;
			attr_sub_claims.valueTypeParameter = "safe.Claim";
			type_ImplClaim.attributes.add(attr_sub_claims);
			
			// Attribute Definition: inferences
			AttributeBuilder attr_inferences = new AttributeBuilder("inferences");
			attr_inferences.extensionID = "safe";
			attr_inferences.valueTypeName = "primitives.<list>";
			attr_inferences.isContainment = false;
			attr_inferences.valueTypeParameter = "safe.Inference";
			type_ImplClaim.attributes.add(attr_inferences);
			
			// Attribute Definition: evidences
			AttributeBuilder attr_evidences = new AttributeBuilder("evidences");
			attr_evidences.extensionID = "safe";
			attr_evidences.valueTypeName = "primitives.<list>";
			attr_evidences.isContainment = false;
			attr_evidences.valueTypeParameter = "safe.EvidenceRef";
			type_ImplClaim.attributes.add(attr_evidences);
			
		}
		types.add(type_ImplClaim);
		
		// Type Definition: UndevClaim
		TypeBuilder type_UndevClaim = new TypeBuilder("safe", "UndevClaim");
		type_UndevClaim.isAbstract = false;
		type_UndevClaim.isFinal = false;
		type_UndevClaim.superTypeNames.add("safe.Claim");
		{
			// Attribute Definition: refcase
			AttributeBuilder attr_refcase = new AttributeBuilder("refcase");
			attr_refcase.extensionID = "safe";
			attr_refcase.valueTypeName = "case.SafetyCase";
			attr_refcase.isContainment = false;
			type_UndevClaim.attributes.add(attr_refcase);
			
		}
		types.add(type_UndevClaim);
		
		// Type Definition: Inference
		TypeBuilder type_Inference = new TypeBuilder("safe", "Inference");
		type_Inference.isAbstract = false;
		type_Inference.isFinal = false;
		type_Inference.superTypeNames.add("safe.Assertion");
		type_Inference.superTypeNames.add("safe.SMainNode");
		{
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.ImplClaim";
			attr_conclusion.isContainment = false;
			type_Inference.attributes.add(attr_conclusion);
			
			// Attribute Definition: premises
			AttributeBuilder attr_premises = new AttributeBuilder("premises");
			attr_premises.extensionID = "safe";
			attr_premises.valueTypeName = "primitives.<list>";
			attr_premises.isContainment = false;
			attr_premises.valueTypeParameter = "safe.Claim";
			type_Inference.attributes.add(attr_premises);
			
		}
		types.add(type_Inference);
		
		// Type Definition: EvidenceRef
		TypeBuilder type_EvidenceRef = new TypeBuilder("safe", "EvidenceRef");
		type_EvidenceRef.isAbstract = false;
		type_EvidenceRef.isFinal = false;
		type_EvidenceRef.superTypeNames.add("safe.SMainNode");
		type_EvidenceRef.superTypeNames.add("safe.SInformationElement");
		{
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "safe";
			attr_evidence.valueTypeName = "evidence.Evidence";
			attr_evidence.isContainment = false;
			type_EvidenceRef.attributes.add(attr_evidence);
			
			// Attribute Definition: state
			AttributeBuilder attr_state = new AttributeBuilder("state");
			attr_state.extensionID = "safe";
			attr_state.valueTypeName = "primitives.<enum>";
			attr_state.isContainment = true;
			attr_state.valueTypeParameter = "safe.EvidenceRefState";
			type_EvidenceRef.attributes.add(attr_state);
			
			// Attribute Definition: support_claims
			AttributeBuilder attr_support_claims = new AttributeBuilder("support_claims");
			attr_support_claims.extensionID = "safe";
			attr_support_claims.valueTypeName = "primitives.<list>";
			attr_support_claims.isContainment = false;
			attr_support_claims.valueTypeParameter = "safe.ImplClaim";
			type_EvidenceRef.attributes.add(attr_support_claims);
			
		}
		types.add(type_EvidenceRef);
		
		// Type Definition: EvidenceRefState
		TypeBuilder type_EvidenceRefState = new TypeBuilder("safe", "EvidenceRefState");
		type_EvidenceRefState.enumValues = new String[] { "Initial", "Unready", "Ready", "Disposed", };
		types.add(type_EvidenceRefState);
		
		// Type Definition: Context
		TypeBuilder type_Context = new TypeBuilder("safe", "Context");
		type_Context.isAbstract = false;
		type_Context.isFinal = false;
		type_Context.superTypeNames.add("safe.SUtilityNode");
		type_Context.superTypeNames.add("safe.SInformationElement");
		{
			// Attribute Definition: assertions
			AttributeBuilder attr_assertions = new AttributeBuilder("assertions");
			attr_assertions.extensionID = "safe";
			attr_assertions.valueTypeName = "primitives.<list>";
			attr_assertions.isContainment = false;
			attr_assertions.valueTypeParameter = "safe.Assertion";
			type_Context.attributes.add(attr_assertions);
			
		}
		types.add(type_Context);
		
		// Type Definition: Assumption
		TypeBuilder type_Assumption = new TypeBuilder("safe", "Assumption");
		type_Assumption.isAbstract = false;
		type_Assumption.isFinal = false;
		type_Assumption.superTypeNames.add("safe.SUtilityNode");
		type_Assumption.superTypeNames.add("safe.Assertion");
		{
			// Attribute Definition: assertions
			AttributeBuilder attr_assertions = new AttributeBuilder("assertions");
			attr_assertions.extensionID = "safe";
			attr_assertions.valueTypeName = "primitives.<list>";
			attr_assertions.isContainment = false;
			attr_assertions.valueTypeParameter = "safe.Assertion";
			type_Assumption.attributes.add(attr_assertions);
			
		}
		types.add(type_Assumption);
		
		// Type Definition: Justification
		TypeBuilder type_Justification = new TypeBuilder("safe", "Justification");
		type_Justification.isAbstract = false;
		type_Justification.isFinal = false;
		type_Justification.superTypeNames.add("safe.SUtilityNode");
		type_Justification.superTypeNames.add("safe.Assertion");
		{
			// Attribute Definition: assertions
			AttributeBuilder attr_assertions = new AttributeBuilder("assertions");
			attr_assertions.extensionID = "safe";
			attr_assertions.valueTypeName = "primitives.<list>";
			attr_assertions.isContainment = false;
			attr_assertions.valueTypeParameter = "safe.Assertion";
			type_Justification.attributes.add(attr_assertions);
			
		}
		types.add(type_Justification);
		
		// Type Definition: SupportByInference
		TypeBuilder type_SupportByInference = new TypeBuilder("safe", "SupportByInference");
		type_SupportByInference.isAbstract = false;
		type_SupportByInference.isFinal = false;
		type_SupportByInference.superTypeNames.add("safe.SMainRelation");
		{
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.ImplClaim";
			attr_conclusion.isContainment = false;
			type_SupportByInference.attributes.add(attr_conclusion);
			
			// Attribute Definition: inference
			AttributeBuilder attr_inference = new AttributeBuilder("inference");
			attr_inference.extensionID = "safe";
			attr_inference.valueTypeName = "safe.Inference";
			attr_inference.isContainment = false;
			type_SupportByInference.attributes.add(attr_inference);
			
		}
		types.add(type_SupportByInference);
		
		// Type Definition: SupportByEvidence
		TypeBuilder type_SupportByEvidence = new TypeBuilder("safe", "SupportByEvidence");
		type_SupportByEvidence.isAbstract = false;
		type_SupportByEvidence.isFinal = false;
		type_SupportByEvidence.superTypeNames.add("safe.SMainRelation");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "safe";
			attr_objective.valueTypeName = "safe.ImplClaim";
			attr_objective.isContainment = false;
			type_SupportByEvidence.attributes.add(attr_objective);
			
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "safe";
			attr_evidence.valueTypeName = "safe.EvidenceRef";
			attr_evidence.isContainment = false;
			type_SupportByEvidence.attributes.add(attr_evidence);
			
		}
		types.add(type_SupportByEvidence);
		
		// Type Definition: SupportByClaim
		TypeBuilder type_SupportByClaim = new TypeBuilder("safe", "SupportByClaim");
		type_SupportByClaim.isAbstract = false;
		type_SupportByClaim.isFinal = false;
		type_SupportByClaim.superTypeNames.add("safe.SMainRelation");
		{
			// Attribute Definition: conclusion
			AttributeBuilder attr_conclusion = new AttributeBuilder("conclusion");
			attr_conclusion.extensionID = "safe";
			attr_conclusion.valueTypeName = "safe.ImplClaim";
			attr_conclusion.isContainment = false;
			type_SupportByClaim.attributes.add(attr_conclusion);
			
			// Attribute Definition: premise
			AttributeBuilder attr_premise = new AttributeBuilder("premise");
			attr_premise.extensionID = "safe";
			attr_premise.valueTypeName = "safe.Claim";
			attr_premise.isContainment = false;
			type_SupportByClaim.attributes.add(attr_premise);
			
		}
		types.add(type_SupportByClaim);
		
		// Type Definition: InferenceSupportByClaim
		TypeBuilder type_InferenceSupportByClaim = new TypeBuilder("safe", "InferenceSupportByClaim");
		type_InferenceSupportByClaim.isAbstract = false;
		type_InferenceSupportByClaim.isFinal = false;
		type_InferenceSupportByClaim.superTypeNames.add("safe.SMainRelation");
		{
			// Attribute Definition: inference
			AttributeBuilder attr_inference = new AttributeBuilder("inference");
			attr_inference.extensionID = "safe";
			attr_inference.valueTypeName = "safe.Inference";
			attr_inference.isContainment = false;
			type_InferenceSupportByClaim.attributes.add(attr_inference);
			
			// Attribute Definition: claim
			AttributeBuilder attr_claim = new AttributeBuilder("claim");
			attr_claim.extensionID = "safe";
			attr_claim.valueTypeName = "safe.Claim";
			attr_claim.isContainment = false;
			type_InferenceSupportByClaim.attributes.add(attr_claim);
			
		}
		types.add(type_InferenceSupportByClaim);
		
		// Type Definition: ContextOf
		TypeBuilder type_ContextOf = new TypeBuilder("safe", "ContextOf");
		type_ContextOf.isAbstract = false;
		type_ContextOf.isFinal = false;
		type_ContextOf.superTypeNames.add("safe.SUtilityRelation");
		{
			// Attribute Definition: context
			AttributeBuilder attr_context = new AttributeBuilder("context");
			attr_context.extensionID = "safe";
			attr_context.valueTypeName = "safe.Context";
			attr_context.isContainment = false;
			type_ContextOf.attributes.add(attr_context);
			
			// Attribute Definition: assertion
			AttributeBuilder attr_assertion = new AttributeBuilder("assertion");
			attr_assertion.extensionID = "safe";
			attr_assertion.valueTypeName = "safe.Assertion";
			attr_assertion.isContainment = false;
			type_ContextOf.attributes.add(attr_assertion);
			
		}
		types.add(type_ContextOf);
		
		// Type Definition: JustifiedBy
		TypeBuilder type_JustifiedBy = new TypeBuilder("safe", "JustifiedBy");
		type_JustifiedBy.isAbstract = false;
		type_JustifiedBy.isFinal = false;
		type_JustifiedBy.superTypeNames.add("safe.SUtilityRelation");
		{
			// Attribute Definition: justification
			AttributeBuilder attr_justification = new AttributeBuilder("justification");
			attr_justification.extensionID = "safe";
			attr_justification.valueTypeName = "safe.Justification";
			attr_justification.isContainment = false;
			type_JustifiedBy.attributes.add(attr_justification);
			
			// Attribute Definition: assertion
			AttributeBuilder attr_assertion = new AttributeBuilder("assertion");
			attr_assertion.extensionID = "safe";
			attr_assertion.valueTypeName = "safe.Assertion";
			attr_assertion.isContainment = false;
			type_JustifiedBy.attributes.add(attr_assertion);
			
		}
		types.add(type_JustifiedBy);
		
		// Type Definition: AssumedBy
		TypeBuilder type_AssumedBy = new TypeBuilder("safe", "AssumedBy");
		type_AssumedBy.isAbstract = false;
		type_AssumedBy.isFinal = false;
		type_AssumedBy.superTypeNames.add("safe.SUtilityRelation");
		{
			// Attribute Definition: assumption
			AttributeBuilder attr_assumption = new AttributeBuilder("assumption");
			attr_assumption.extensionID = "safe";
			attr_assumption.valueTypeName = "safe.Assumption";
			attr_assumption.isContainment = false;
			type_AssumedBy.attributes.add(attr_assumption);
			
			// Attribute Definition: assertion
			AttributeBuilder attr_assertion = new AttributeBuilder("assertion");
			attr_assertion.extensionID = "safe";
			attr_assertion.valueTypeName = "safe.Assertion";
			attr_assertion.isContainment = false;
			type_AssumedBy.attributes.add(attr_assertion);
			
		}
		types.add(type_AssumedBy);
		
		// Type Definition: SEvidenceElement
		TypeBuilder type_SEvidenceElement = new TypeBuilder("evidence", "SEvidenceElement");
		type_SEvidenceElement.isAbstract = true;
		type_SEvidenceElement.isFinal = false;
		type_SEvidenceElement.superTypeNames.add("core.ModelElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "evidence";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_SEvidenceElement.attributes.add(attr_name);
			
		}
		types.add(type_SEvidenceElement);
		
		// Type Definition: Evidence
		TypeBuilder type_Evidence = new TypeBuilder("evidence", "Evidence");
		type_Evidence.isAbstract = true;
		type_Evidence.isFinal = false;
		type_Evidence.superTypeNames.add("evidence.SEvidenceElement");
		{
			// Attribute Definition: support_refs
			AttributeBuilder attr_support_refs = new AttributeBuilder("support_refs");
			attr_support_refs.extensionID = "evidence";
			attr_support_refs.valueTypeName = "primitives.<list>";
			attr_support_refs.isContainment = false;
			attr_support_refs.valueTypeParameter = "safe.EvidenceRef";
			type_Evidence.attributes.add(attr_support_refs);
			
		}
		types.add(type_Evidence);
		
		// Type Definition: EvidenceGroup
		TypeBuilder type_EvidenceGroup = new TypeBuilder("evidence", "EvidenceGroup");
		type_EvidenceGroup.isAbstract = false;
		type_EvidenceGroup.isFinal = false;
		type_EvidenceGroup.superTypeNames.add("evidence.Evidence");
		{
			// Attribute Definition: evidences
			AttributeBuilder attr_evidences = new AttributeBuilder("evidences");
			attr_evidences.extensionID = "evidence";
			attr_evidences.valueTypeName = "primitives.<list>";
			attr_evidences.isContainment = false;
			attr_evidences.valueTypeParameter = "evidence.Evidence";
			type_EvidenceGroup.attributes.add(attr_evidences);
			
		}
		types.add(type_EvidenceGroup);
		
		// Type Definition: EvidenceFile
		TypeBuilder type_EvidenceFile = new TypeBuilder("evidence", "EvidenceFile");
		type_EvidenceFile.isAbstract = false;
		type_EvidenceFile.isFinal = false;
		type_EvidenceFile.superTypeNames.add("evidence.Evidence");
		{
			// Attribute Definition: file_url
			AttributeBuilder attr_file_url = new AttributeBuilder("file_url");
			attr_file_url.extensionID = "evidence";
			attr_file_url.valueTypeName = "primitives.<string>";
			attr_file_url.isContainment = true;
			type_EvidenceFile.attributes.add(attr_file_url);
			
		}
		types.add(type_EvidenceFile);
		
		// Type Definition: SModule
		TypeBuilder type_SModule = new TypeBuilder("case", "SModule");
		type_SModule.isAbstract = true;
		type_SModule.isFinal = false;
		type_SModule.superTypeNames.add("safe.SElement");
		{
			// Attribute Definition: nodes
			AttributeBuilder attr_nodes = new AttributeBuilder("nodes");
			attr_nodes.extensionID = "case";
			attr_nodes.valueTypeName = "primitives.<list>";
			attr_nodes.isContainment = false;
			attr_nodes.valueTypeParameter = "safe.SNode";
			type_SModule.attributes.add(attr_nodes);
			
			// Attribute Definition: relations
			AttributeBuilder attr_relations = new AttributeBuilder("relations");
			attr_relations.extensionID = "case";
			attr_relations.valueTypeName = "primitives.<list>";
			attr_relations.isContainment = false;
			attr_relations.valueTypeParameter = "safe.SRelation";
			type_SModule.attributes.add(attr_relations);
			
			// Attribute Definition: subModules
			AttributeBuilder attr_subModules = new AttributeBuilder("subModules");
			attr_subModules.extensionID = "case";
			attr_subModules.valueTypeName = "primitives.<list>";
			attr_subModules.isContainment = false;
			attr_subModules.valueTypeParameter = "case.SModule";
			type_SModule.attributes.add(attr_subModules);
			
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "case";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_SModule.attributes.add(attr_name);
			
		}
		types.add(type_SModule);
		
		// Type Definition: SafetyCase
		TypeBuilder type_SafetyCase = new TypeBuilder("case", "SafetyCase");
		type_SafetyCase.isAbstract = false;
		type_SafetyCase.isFinal = false;
		type_SafetyCase.superTypeNames.add("case.SModule");
		{
			// Attribute Definition: implClaims
			AttributeBuilder attr_implClaims = new AttributeBuilder("implClaims");
			attr_implClaims.extensionID = "case";
			attr_implClaims.valueTypeName = "primitives.<list>";
			attr_implClaims.isContainment = false;
			attr_implClaims.valueTypeParameter = "safe.ImplClaim";
			type_SafetyCase.attributes.add(attr_implClaims);
			
			// Attribute Definition: undevClaims
			AttributeBuilder attr_undevClaims = new AttributeBuilder("undevClaims");
			attr_undevClaims.extensionID = "case";
			attr_undevClaims.valueTypeName = "primitives.<list>";
			attr_undevClaims.isContainment = false;
			attr_undevClaims.valueTypeParameter = "safe.UndevClaim";
			type_SafetyCase.attributes.add(attr_undevClaims);
			
			// Attribute Definition: evidenceRefs
			AttributeBuilder attr_evidenceRefs = new AttributeBuilder("evidenceRefs");
			attr_evidenceRefs.extensionID = "case";
			attr_evidenceRefs.valueTypeName = "primitives.<list>";
			attr_evidenceRefs.isContainment = false;
			attr_evidenceRefs.valueTypeParameter = "safe.EvidenceRef";
			type_SafetyCase.attributes.add(attr_evidenceRefs);
			
			// Attribute Definition: inferences
			AttributeBuilder attr_inferences = new AttributeBuilder("inferences");
			attr_inferences.extensionID = "case";
			attr_inferences.valueTypeName = "primitives.<list>";
			attr_inferences.isContainment = false;
			attr_inferences.valueTypeParameter = "safe.Inference";
			type_SafetyCase.attributes.add(attr_inferences);
			
			// Attribute Definition: contexts
			AttributeBuilder attr_contexts = new AttributeBuilder("contexts");
			attr_contexts.extensionID = "case";
			attr_contexts.valueTypeName = "primitives.<list>";
			attr_contexts.isContainment = false;
			attr_contexts.valueTypeParameter = "safe.Context";
			type_SafetyCase.attributes.add(attr_contexts);
			
			// Attribute Definition: assumptions
			AttributeBuilder attr_assumptions = new AttributeBuilder("assumptions");
			attr_assumptions.extensionID = "case";
			attr_assumptions.valueTypeName = "primitives.<list>";
			attr_assumptions.isContainment = false;
			attr_assumptions.valueTypeParameter = "safe.Assumption";
			type_SafetyCase.attributes.add(attr_assumptions);
			
			// Attribute Definition: justifications
			AttributeBuilder attr_justifications = new AttributeBuilder("justifications");
			attr_justifications.extensionID = "case";
			attr_justifications.valueTypeName = "primitives.<list>";
			attr_justifications.isContainment = false;
			attr_justifications.valueTypeParameter = "safe.Justification";
			type_SafetyCase.attributes.add(attr_justifications);
			
			// Attribute Definition: claim_claim_links
			AttributeBuilder attr_claim_claim_links = new AttributeBuilder("claim_claim_links");
			attr_claim_claim_links.extensionID = "case";
			attr_claim_claim_links.valueTypeName = "primitives.<list>";
			attr_claim_claim_links.isContainment = false;
			attr_claim_claim_links.valueTypeParameter = "safe.SupportByClaim";
			type_SafetyCase.attributes.add(attr_claim_claim_links);
			
			// Attribute Definition: claim_evidence_links
			AttributeBuilder attr_claim_evidence_links = new AttributeBuilder("claim_evidence_links");
			attr_claim_evidence_links.extensionID = "case";
			attr_claim_evidence_links.valueTypeName = "primitives.<list>";
			attr_claim_evidence_links.isContainment = false;
			attr_claim_evidence_links.valueTypeParameter = "safe.SupportByEvidence";
			type_SafetyCase.attributes.add(attr_claim_evidence_links);
			
			// Attribute Definition: claim_inference_links
			AttributeBuilder attr_claim_inference_links = new AttributeBuilder("claim_inference_links");
			attr_claim_inference_links.extensionID = "case";
			attr_claim_inference_links.valueTypeName = "primitives.<list>";
			attr_claim_inference_links.isContainment = false;
			attr_claim_inference_links.valueTypeParameter = "safe.SupportByInference";
			type_SafetyCase.attributes.add(attr_claim_inference_links);
			
			// Attribute Definition: inference_claim_links
			AttributeBuilder attr_inference_claim_links = new AttributeBuilder("inference_claim_links");
			attr_inference_claim_links.extensionID = "case";
			attr_inference_claim_links.valueTypeName = "primitives.<list>";
			attr_inference_claim_links.isContainment = false;
			attr_inference_claim_links.valueTypeParameter = "safe.InferenceSupportByClaim";
			type_SafetyCase.attributes.add(attr_inference_claim_links);
			
			// Attribute Definition: context_links
			AttributeBuilder attr_context_links = new AttributeBuilder("context_links");
			attr_context_links.extensionID = "case";
			attr_context_links.valueTypeName = "primitives.<list>";
			attr_context_links.isContainment = false;
			attr_context_links.valueTypeParameter = "safe.ContextOf";
			type_SafetyCase.attributes.add(attr_context_links);
			
			// Attribute Definition: assumption_links
			AttributeBuilder attr_assumption_links = new AttributeBuilder("assumption_links");
			attr_assumption_links.extensionID = "case";
			attr_assumption_links.valueTypeName = "primitives.<list>";
			attr_assumption_links.isContainment = false;
			attr_assumption_links.valueTypeParameter = "safe.AssumedBy";
			type_SafetyCase.attributes.add(attr_assumption_links);
			
			// Attribute Definition: justification_links
			AttributeBuilder attr_justification_links = new AttributeBuilder("justification_links");
			attr_justification_links.extensionID = "case";
			attr_justification_links.valueTypeName = "primitives.<list>";
			attr_justification_links.isContainment = false;
			attr_justification_links.valueTypeParameter = "safe.JustifiedBy";
			type_SafetyCase.attributes.add(attr_justification_links);
			
			// Attribute Definition: sub_cases
			AttributeBuilder attr_sub_cases = new AttributeBuilder("sub_cases");
			attr_sub_cases.extensionID = "case";
			attr_sub_cases.valueTypeName = "primitives.<list>";
			attr_sub_cases.isContainment = false;
			attr_sub_cases.valueTypeParameter = "case.SafetyCase";
			type_SafetyCase.attributes.add(attr_sub_cases);
			
			// Attribute Definition: support_undev_claims
			AttributeBuilder attr_support_undev_claims = new AttributeBuilder("support_undev_claims");
			attr_support_undev_claims.extensionID = "case";
			attr_support_undev_claims.valueTypeName = "primitives.<list>";
			attr_support_undev_claims.isContainment = false;
			attr_support_undev_claims.valueTypeParameter = "safe.UndevClaim";
			type_SafetyCase.attributes.add(attr_support_undev_claims);
			
		}
		types.add(type_SafetyCase);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("safe.ImplClaim", cn.edu.buaa.sei.emt.safe.ImplClaimImpl.class);
		map.put("safe.UndevClaim", cn.edu.buaa.sei.emt.safe.UndevClaimImpl.class);
		map.put("safe.Inference", cn.edu.buaa.sei.emt.safe.InferenceImpl.class);
		map.put("safe.EvidenceRef", cn.edu.buaa.sei.emt.safe.EvidenceRefImpl.class);
		map.put("safe.Context", cn.edu.buaa.sei.emt.safe.ContextImpl.class);
		map.put("safe.Assumption", cn.edu.buaa.sei.emt.safe.AssumptionImpl.class);
		map.put("safe.Justification", cn.edu.buaa.sei.emt.safe.JustificationImpl.class);
		map.put("safe.SupportByInference", cn.edu.buaa.sei.emt.safe.SupportByInferenceImpl.class);
		map.put("safe.SupportByEvidence", cn.edu.buaa.sei.emt.safe.SupportByEvidenceImpl.class);
		map.put("safe.SupportByClaim", cn.edu.buaa.sei.emt.safe.SupportByClaimImpl.class);
		map.put("safe.InferenceSupportByClaim", cn.edu.buaa.sei.emt.safe.InferenceSupportByClaimImpl.class);
		map.put("safe.ContextOf", cn.edu.buaa.sei.emt.safe.ContextOfImpl.class);
		map.put("safe.JustifiedBy", cn.edu.buaa.sei.emt.safe.JustifiedByImpl.class);
		map.put("safe.AssumedBy", cn.edu.buaa.sei.emt.safe.AssumedByImpl.class);
		map.put("evidence.EvidenceGroup", cn.edu.buaa.sei.emt.safe.EvidenceGroupImpl.class);
		map.put("evidence.EvidenceFile", cn.edu.buaa.sei.emt.safe.EvidenceFileImpl.class);
		map.put("case.SafetyCase", cn.edu.buaa.sei.emt.safe.SafetyCaseImpl.class);
		return map;
	}
	
}
