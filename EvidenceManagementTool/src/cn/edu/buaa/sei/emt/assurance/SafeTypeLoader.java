package cn.edu.buaa.sei.emt.assurance;
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
		
		// Type Definition: SafeModelElement
		TypeBuilder type_SafeModelElement = new TypeBuilder("argument", "SafeModelElement");
		type_SafeModelElement.isAbstract = true;
		type_SafeModelElement.isFinal = false;
		type_SafeModelElement.superTypeNames.add("core.ModelElement");
		{
		}
		types.add(type_SafeModelElement);
		
		// Type Definition: ArgumentElement
		TypeBuilder type_ArgumentElement = new TypeBuilder("argument", "ArgumentElement");
		type_ArgumentElement.isAbstract = true;
		type_ArgumentElement.isFinal = false;
		type_ArgumentElement.superTypeNames.add("argument.SafeModelElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "argument";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_ArgumentElement.attributes.add(attr_name);
			
		}
		types.add(type_ArgumentElement);
		
		// Type Definition: Assertion
		TypeBuilder type_Assertion = new TypeBuilder("argument", "Assertion");
		type_Assertion.isAbstract = true;
		type_Assertion.isFinal = false;
		type_Assertion.superTypeNames.add("argument.ArgumentElement");
		{
			// Attribute Definition: description
			AttributeBuilder attr_description = new AttributeBuilder("description");
			attr_description.extensionID = "argument";
			attr_description.valueTypeName = "primitives.<string>";
			attr_description.isContainment = true;
			type_Assertion.attributes.add(attr_description);
			
		}
		types.add(type_Assertion);
		
		// Type Definition: Context
		TypeBuilder type_Context = new TypeBuilder("argument", "Context");
		type_Context.isAbstract = false;
		type_Context.isFinal = false;
		type_Context.superTypeNames.add("argument.ArgumentElement");
		{
			// Attribute Definition: description
			AttributeBuilder attr_description = new AttributeBuilder("description");
			attr_description.extensionID = "argument";
			attr_description.valueTypeName = "primitives.<string>";
			attr_description.isContainment = true;
			type_Context.attributes.add(attr_description);
			
		}
		types.add(type_Context);
		
		// Type Definition: InformationElement
		TypeBuilder type_InformationElement = new TypeBuilder("argument", "InformationElement");
		type_InformationElement.isAbstract = false;
		type_InformationElement.isFinal = false;
		type_InformationElement.superTypeNames.add("argument.ArgumentElement");
		{
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "argument";
			attr_evidence.valueTypeName = "evidence.Evidence";
			attr_evidence.isContainment = false;
			type_InformationElement.attributes.add(attr_evidence);
			
		}
		types.add(type_InformationElement);
		
		// Type Definition: Claim
		TypeBuilder type_Claim = new TypeBuilder("argument", "Claim");
		type_Claim.isAbstract = false;
		type_Claim.isFinal = false;
		type_Claim.superTypeNames.add("argument.Assertion");
		{
			// Attribute Definition: assured
			AttributeBuilder attr_assured = new AttributeBuilder("assured");
			attr_assured.extensionID = "argument";
			attr_assured.valueTypeName = "primitives.<bool>";
			attr_assured.isContainment = true;
			type_Claim.attributes.add(attr_assured);
			
			// Attribute Definition: supported
			AttributeBuilder attr_supported = new AttributeBuilder("supported");
			attr_supported.extensionID = "argument";
			attr_supported.valueTypeName = "primitives.<bool>";
			attr_supported.isContainment = true;
			type_Claim.attributes.add(attr_supported);
			
		}
		types.add(type_Claim);
		
		// Type Definition: AssertionRelation
		TypeBuilder type_AssertionRelation = new TypeBuilder("argument", "AssertionRelation");
		type_AssertionRelation.isAbstract = true;
		type_AssertionRelation.isFinal = false;
		type_AssertionRelation.superTypeNames.add("argument.Assertion");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "argument";
			attr_objective.valueTypeName = "argument.Claim";
			attr_objective.isContainment = false;
			type_AssertionRelation.attributes.add(attr_objective);
			
		}
		types.add(type_AssertionRelation);
		
		// Type Definition: ClaimsRelation
		TypeBuilder type_ClaimsRelation = new TypeBuilder("argument", "ClaimsRelation");
		type_ClaimsRelation.isAbstract = false;
		type_ClaimsRelation.isFinal = false;
		type_ClaimsRelation.superTypeNames.add("argument.AssertionRelation");
		{
			// Attribute Definition: sub_claims
			AttributeBuilder attr_sub_claims = new AttributeBuilder("sub_claims");
			attr_sub_claims.extensionID = "argument";
			attr_sub_claims.valueTypeName = "primitives.<list>";
			attr_sub_claims.isContainment = false;
			attr_sub_claims.valueTypeParameter = "argument.Claim";
			type_ClaimsRelation.attributes.add(attr_sub_claims);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "argument";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "argument.ClaimRelationType";
			type_ClaimsRelation.attributes.add(attr_type);
			
		}
		types.add(type_ClaimsRelation);
		
		// Type Definition: ClaimRelationType
		TypeBuilder type_ClaimRelationType = new TypeBuilder("argument", "ClaimRelationType");
		type_ClaimRelationType.enumValues = new String[] { "Support", "Challenge", };
		types.add(type_ClaimRelationType);
		
		// Type Definition: ClaimEvidenceRelation
		TypeBuilder type_ClaimEvidenceRelation = new TypeBuilder("argument", "ClaimEvidenceRelation");
		type_ClaimEvidenceRelation.isAbstract = false;
		type_ClaimEvidenceRelation.isFinal = false;
		type_ClaimEvidenceRelation.superTypeNames.add("argument.AssertionRelation");
		{
			// Attribute Definition: evidences
			AttributeBuilder attr_evidences = new AttributeBuilder("evidences");
			attr_evidences.extensionID = "argument";
			attr_evidences.valueTypeName = "primitives.<list>";
			attr_evidences.isContainment = false;
			attr_evidences.valueTypeParameter = "argument.InformationElement";
			type_ClaimEvidenceRelation.attributes.add(attr_evidences);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "argument";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "argument.ClaimEvidenceRelationType";
			type_ClaimEvidenceRelation.attributes.add(attr_type);
			
		}
		types.add(type_ClaimEvidenceRelation);
		
		// Type Definition: ClaimEvidenceRelationType
		TypeBuilder type_ClaimEvidenceRelationType = new TypeBuilder("argument", "ClaimEvidenceRelationType");
		type_ClaimEvidenceRelationType.enumValues = new String[] { "Support", "Challenge", };
		types.add(type_ClaimEvidenceRelationType);
		
		// Type Definition: ContextRelation
		TypeBuilder type_ContextRelation = new TypeBuilder("argument", "ContextRelation");
		type_ContextRelation.isAbstract = false;
		type_ContextRelation.isFinal = false;
		type_ContextRelation.superTypeNames.add("argument.AssertionRelation");
		{
			// Attribute Definition: contexts
			AttributeBuilder attr_contexts = new AttributeBuilder("contexts");
			attr_contexts.extensionID = "argument";
			attr_contexts.valueTypeName = "primitives.<list>";
			attr_contexts.isContainment = false;
			attr_contexts.valueTypeParameter = "argument.Context";
			type_ContextRelation.attributes.add(attr_contexts);
			
		}
		types.add(type_ContextRelation);
		
		// Type Definition: ArgumentReason
		TypeBuilder type_ArgumentReason = new TypeBuilder("argument", "ArgumentReason");
		type_ArgumentReason.isAbstract = false;
		type_ArgumentReason.isFinal = false;
		type_ArgumentReason.superTypeNames.add("argument.ArgumentElement");
		{
			// Attribute Definition: relation
			AttributeBuilder attr_relation = new AttributeBuilder("relation");
			attr_relation.extensionID = "argument";
			attr_relation.valueTypeName = "argument.AssertionRelation";
			attr_relation.isContainment = false;
			type_ArgumentReason.attributes.add(attr_relation);
			
			// Attribute Definition: reason
			AttributeBuilder attr_reason = new AttributeBuilder("reason");
			attr_reason.extensionID = "argument";
			attr_reason.valueTypeName = "primitives.<string>";
			attr_reason.isContainment = true;
			type_ArgumentReason.attributes.add(attr_reason);
			
		}
		types.add(type_ArgumentReason);
		
		// Type Definition: ArgumentCitation
		TypeBuilder type_ArgumentCitation = new TypeBuilder("argument", "ArgumentCitation");
		type_ArgumentCitation.isAbstract = false;
		type_ArgumentCitation.isFinal = false;
		type_ArgumentCitation.superTypeNames.add("argument.ArgumentElement");
		{
			// Attribute Definition: argumentation
			AttributeBuilder attr_argumentation = new AttributeBuilder("argumentation");
			attr_argumentation.extensionID = "argument";
			attr_argumentation.valueTypeName = "argument.Argumentation";
			attr_argumentation.isContainment = false;
			type_ArgumentCitation.attributes.add(attr_argumentation);
			
		}
		types.add(type_ArgumentCitation);
		
		// Type Definition: Argumentation
		TypeBuilder type_Argumentation = new TypeBuilder("argument", "Argumentation");
		type_Argumentation.isAbstract = false;
		type_Argumentation.isFinal = false;
		type_Argumentation.superTypeNames.add("argument.SafeModelElement");
		{
			// Attribute Definition: elements
			AttributeBuilder attr_elements = new AttributeBuilder("elements");
			attr_elements.extensionID = "argument";
			attr_elements.valueTypeName = "primitives.<list>";
			attr_elements.isContainment = false;
			attr_elements.valueTypeParameter = "argument.ArgumentElement";
			type_Argumentation.attributes.add(attr_elements);
			
			// Attribute Definition: top_objective
			AttributeBuilder attr_top_objective = new AttributeBuilder("top_objective");
			attr_top_objective.extensionID = "argument";
			attr_top_objective.valueTypeName = "argument.Claim";
			attr_top_objective.isContainment = false;
			type_Argumentation.attributes.add(attr_top_objective);
			
		}
		types.add(type_Argumentation);
		
		// Type Definition: Assurance
		TypeBuilder type_Assurance = new TypeBuilder("argument", "Assurance");
		type_Assurance.isAbstract = false;
		type_Assurance.isFinal = false;
		type_Assurance.superTypeNames.add("argument.SafeModelElement");
		{
			// Attribute Definition: objective
			AttributeBuilder attr_objective = new AttributeBuilder("objective");
			attr_objective.extensionID = "argument";
			attr_objective.valueTypeName = "argument.Claim";
			attr_objective.isContainment = false;
			type_Assurance.attributes.add(attr_objective);
			
			// Attribute Definition: argumentation
			AttributeBuilder attr_argumentation = new AttributeBuilder("argumentation");
			attr_argumentation.extensionID = "argument";
			attr_argumentation.valueTypeName = "argument.Argumentation";
			attr_argumentation.isContainment = false;
			type_Assurance.attributes.add(attr_argumentation);
			
			// Attribute Definition: evidence_container
			AttributeBuilder attr_evidence_container = new AttributeBuilder("evidence_container");
			attr_evidence_container.extensionID = "argument";
			attr_evidence_container.valueTypeName = "evidence.EvidenceContainer";
			attr_evidence_container.isContainment = false;
			type_Assurance.attributes.add(attr_evidence_container);
			
		}
		types.add(type_Assurance);
		
		// Type Definition: EvidenceContainer
		TypeBuilder type_EvidenceContainer = new TypeBuilder("evidence", "EvidenceContainer");
		type_EvidenceContainer.isAbstract = false;
		type_EvidenceContainer.isFinal = false;
		type_EvidenceContainer.superTypeNames.add("evidence.EvidenceElement");
		{
			// Attribute Definition: evidenceList
			AttributeBuilder attr_evidenceList = new AttributeBuilder("evidenceList");
			attr_evidenceList.extensionID = "evidence";
			attr_evidenceList.valueTypeName = "primitives.<list>";
			attr_evidenceList.isContainment = false;
			attr_evidenceList.valueTypeParameter = "evidence.Evidence";
			type_EvidenceContainer.attributes.add(attr_evidenceList);
			
			// Attribute Definition: evidenceRelations
			AttributeBuilder attr_evidenceRelations = new AttributeBuilder("evidenceRelations");
			attr_evidenceRelations.extensionID = "evidence";
			attr_evidenceRelations.valueTypeName = "primitives.<list>";
			attr_evidenceRelations.isContainment = false;
			attr_evidenceRelations.valueTypeParameter = "evidence.EvidenceRelation";
			type_EvidenceContainer.attributes.add(attr_evidenceRelations);
			
			// Attribute Definition: evidenceEvents
			AttributeBuilder attr_evidenceEvents = new AttributeBuilder("evidenceEvents");
			attr_evidenceEvents.extensionID = "evidence";
			attr_evidenceEvents.valueTypeName = "primitives.<list>";
			attr_evidenceEvents.isContainment = false;
			attr_evidenceEvents.valueTypeParameter = "evidence.EvidenceEvent";
			type_EvidenceContainer.attributes.add(attr_evidenceEvents);
			
		}
		types.add(type_EvidenceContainer);
		
		// Type Definition: EvidenceElement
		TypeBuilder type_EvidenceElement = new TypeBuilder("evidence", "EvidenceElement");
		type_EvidenceElement.isAbstract = true;
		type_EvidenceElement.isFinal = false;
		type_EvidenceElement.superTypeNames.add("argument.SafeModelElement");
		{
		}
		types.add(type_EvidenceElement);
		
		// Type Definition: Evidence
		TypeBuilder type_Evidence = new TypeBuilder("evidence", "Evidence");
		type_Evidence.isAbstract = false;
		type_Evidence.isFinal = false;
		type_Evidence.superTypeNames.add("evidence.EvidenceElement");
		{
			// Attribute Definition: properties
			AttributeBuilder attr_properties = new AttributeBuilder("properties");
			attr_properties.extensionID = "evidence";
			attr_properties.valueTypeName = "primitives.<list>";
			attr_properties.isContainment = false;
			attr_properties.valueTypeParameter = "evidence.EvidenceProperty";
			type_Evidence.attributes.add(attr_properties);
			
		}
		types.add(type_Evidence);
		
		// Type Definition: EvidenceProperty
		TypeBuilder type_EvidenceProperty = new TypeBuilder("evidence", "EvidenceProperty");
		type_EvidenceProperty.isAbstract = false;
		type_EvidenceProperty.isFinal = false;
		type_EvidenceProperty.superTypeNames.add("evidence.EvidenceElement");
		{
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "evidence";
			attr_evidence.valueTypeName = "evidence.Evidence";
			attr_evidence.isContainment = false;
			type_EvidenceProperty.attributes.add(attr_evidence);
			
		}
		types.add(type_EvidenceProperty);
		
		// Type Definition: EvidenceGroup
		TypeBuilder type_EvidenceGroup = new TypeBuilder("evidence", "EvidenceGroup");
		type_EvidenceGroup.isAbstract = false;
		type_EvidenceGroup.isFinal = false;
		type_EvidenceGroup.superTypeNames.add("evidence.Evidence");
		{
			// Attribute Definition: sub_evidences
			AttributeBuilder attr_sub_evidences = new AttributeBuilder("sub_evidences");
			attr_sub_evidences.extensionID = "evidence";
			attr_sub_evidences.valueTypeName = "primitives.<list>";
			attr_sub_evidences.isContainment = false;
			attr_sub_evidences.valueTypeParameter = "evidence.Evidence";
			type_EvidenceGroup.attributes.add(attr_sub_evidences);
			
		}
		types.add(type_EvidenceGroup);
		
		// Type Definition: Custody
		TypeBuilder type_Custody = new TypeBuilder("evidence", "Custody");
		type_Custody.isAbstract = false;
		type_Custody.isFinal = false;
		type_Custody.superTypeNames.add("evidence.EvidenceProperty");
		{
			// Attribute Definition: role
			AttributeBuilder attr_role = new AttributeBuilder("role");
			attr_role.extensionID = "evidence";
			attr_role.valueTypeName = "saferole.SafeRole";
			attr_role.isContainment = false;
			type_Custody.attributes.add(attr_role);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.CustodyType";
			type_Custody.attributes.add(attr_type);
			
		}
		types.add(type_Custody);
		
		// Type Definition: CustodyType
		TypeBuilder type_CustodyType = new TypeBuilder("evidence", "CustodyType");
		type_CustodyType.enumValues = new String[] { "own", };
		types.add(type_CustodyType);
		
		// Type Definition: Time
		TypeBuilder type_Time = new TypeBuilder("evidence", "Time");
		type_Time.isAbstract = false;
		type_Time.isFinal = false;
		type_Time.superTypeNames.add("evidence.EvidenceProperty");
		{
			// Attribute Definition: start
			AttributeBuilder attr_start = new AttributeBuilder("start");
			attr_start.extensionID = "evidence";
			attr_start.valueTypeName = "primitives.<string>";
			attr_start.isContainment = true;
			type_Time.attributes.add(attr_start);
			
			// Attribute Definition: end
			AttributeBuilder attr_end = new AttributeBuilder("end");
			attr_end.extensionID = "evidence";
			attr_end.valueTypeName = "primitives.<string>";
			attr_end.isContainment = true;
			type_Time.attributes.add(attr_end);
			
		}
		types.add(type_Time);
		
		// Type Definition: Provenance
		TypeBuilder type_Provenance = new TypeBuilder("evidence", "Provenance");
		type_Provenance.isAbstract = false;
		type_Provenance.isFinal = false;
		type_Provenance.superTypeNames.add("evidence.EvidenceProperty");
		{
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.ProvenanceType";
			type_Provenance.attributes.add(attr_type);
			
		}
		types.add(type_Provenance);
		
		// Type Definition: ProvenanceType
		TypeBuilder type_ProvenanceType = new TypeBuilder("evidence", "ProvenanceType");
		type_ProvenanceType.enumValues = new String[] { "attribute", "parent", "element", "set", "derivedSource", "derievedTarget", };
		types.add(type_ProvenanceType);
		
		// Type Definition: EvidenceStatus
		TypeBuilder type_EvidenceStatus = new TypeBuilder("evidence", "EvidenceStatus");
		type_EvidenceStatus.isAbstract = false;
		type_EvidenceStatus.isFinal = false;
		type_EvidenceStatus.superTypeNames.add("evidence.EvidenceProperty");
		{
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.EvidenceStatusType";
			type_EvidenceStatus.attributes.add(attr_type);
			
		}
		types.add(type_EvidenceStatus);
		
		// Type Definition: EvidenceStatusType
		TypeBuilder type_EvidenceStatusType = new TypeBuilder("evidence", "EvidenceStatusType");
		type_EvidenceStatusType.enumValues = new String[] { "Initial", "UnReady", "Ready", "Revoked", };
		types.add(type_EvidenceStatusType);
		
		// Type Definition: EvidenceRelation
		TypeBuilder type_EvidenceRelation = new TypeBuilder("evidence", "EvidenceRelation");
		type_EvidenceRelation.isAbstract = false;
		type_EvidenceRelation.isFinal = false;
		type_EvidenceRelation.superTypeNames.add("evidence.EvidenceElement");
		{
			// Attribute Definition: source
			AttributeBuilder attr_source = new AttributeBuilder("source");
			attr_source.extensionID = "evidence";
			attr_source.valueTypeName = "evidence.Evidence";
			attr_source.isContainment = false;
			type_EvidenceRelation.attributes.add(attr_source);
			
			// Attribute Definition: target
			AttributeBuilder attr_target = new AttributeBuilder("target");
			attr_target.extensionID = "evidence";
			attr_target.valueTypeName = "evidence.Evidence";
			attr_target.isContainment = false;
			type_EvidenceRelation.attributes.add(attr_target);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.EvidenceRelationType";
			type_EvidenceRelation.attributes.add(attr_type);
			
		}
		types.add(type_EvidenceRelation);
		
		// Type Definition: EvidenceRelationType
		TypeBuilder type_EvidenceRelationType = new TypeBuilder("evidence", "EvidenceRelationType");
		type_EvidenceRelationType.enumValues = new String[] { "includedBy", "include", "attributeOf", "parentOf", "derivedFrom", "basedOn", };
		types.add(type_EvidenceRelationType);
		
		// Type Definition: EvidenceEvent
		TypeBuilder type_EvidenceEvent = new TypeBuilder("evidence", "EvidenceEvent");
		type_EvidenceEvent.isAbstract = false;
		type_EvidenceEvent.isFinal = false;
		type_EvidenceEvent.superTypeNames.add("evidence.EvidenceElement");
		{
			// Attribute Definition: evidence
			AttributeBuilder attr_evidence = new AttributeBuilder("evidence");
			attr_evidence.extensionID = "evidence";
			attr_evidence.valueTypeName = "evidence.Evidence";
			attr_evidence.isContainment = false;
			type_EvidenceEvent.attributes.add(attr_evidence);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.EvidenceEventType";
			type_EvidenceEvent.attributes.add(attr_type);
			
			// Attribute Definition: executor
			AttributeBuilder attr_executor = new AttributeBuilder("executor");
			attr_executor.extensionID = "evidence";
			attr_executor.valueTypeName = "saferole.SafeRole";
			attr_executor.isContainment = false;
			type_EvidenceEvent.attributes.add(attr_executor);
			
		}
		types.add(type_EvidenceEvent);
		
		// Type Definition: EvidenceEventType
		TypeBuilder type_EvidenceEventType = new TypeBuilder("evidence", "EvidenceEventType");
		type_EvidenceEventType.enumValues = new String[] { "create", "acquire", "derive", "modify", "revoke", "evaluate", "transfer", };
		types.add(type_EvidenceEventType);
		
		// Type Definition: BasicEvidence
		TypeBuilder type_BasicEvidence = new TypeBuilder("evidence", "BasicEvidence");
		type_BasicEvidence.isAbstract = false;
		type_BasicEvidence.isFinal = false;
		type_BasicEvidence.superTypeNames.add("evidence.Evidence");
		{
		}
		types.add(type_BasicEvidence);
		
		// Type Definition: EvidenceRecord
		TypeBuilder type_EvidenceRecord = new TypeBuilder("evidence", "EvidenceRecord");
		type_EvidenceRecord.isAbstract = false;
		type_EvidenceRecord.isFinal = false;
		type_EvidenceRecord.superTypeNames.add("evidence.BasicEvidence");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "evidence";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_name);
			
			// Attribute Definition: boolValue
			AttributeBuilder attr_boolValue = new AttributeBuilder("boolValue");
			attr_boolValue.extensionID = "evidence";
			attr_boolValue.valueTypeName = "primitives.<bool>";
			attr_boolValue.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_boolValue);
			
			// Attribute Definition: intValue
			AttributeBuilder attr_intValue = new AttributeBuilder("intValue");
			attr_intValue.extensionID = "evidence";
			attr_intValue.valueTypeName = "primitives.<int>";
			attr_intValue.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_intValue);
			
			// Attribute Definition: floatValue
			AttributeBuilder attr_floatValue = new AttributeBuilder("floatValue");
			attr_floatValue.extensionID = "evidence";
			attr_floatValue.valueTypeName = "primitives.<float>";
			attr_floatValue.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_floatValue);
			
			// Attribute Definition: doubleValue
			AttributeBuilder attr_doubleValue = new AttributeBuilder("doubleValue");
			attr_doubleValue.extensionID = "evidence";
			attr_doubleValue.valueTypeName = "primitives.<double>";
			attr_doubleValue.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_doubleValue);
			
			// Attribute Definition: stringValue
			AttributeBuilder attr_stringValue = new AttributeBuilder("stringValue");
			attr_stringValue.extensionID = "evidence";
			attr_stringValue.valueTypeName = "primitives.<string>";
			attr_stringValue.isContainment = true;
			type_EvidenceRecord.attributes.add(attr_stringValue);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "evidence";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "evidence.EvidenceRecordType";
			type_EvidenceRecord.attributes.add(attr_type);
			
		}
		types.add(type_EvidenceRecord);
		
		// Type Definition: EvidenceRecordType
		TypeBuilder type_EvidenceRecordType = new TypeBuilder("evidence", "EvidenceRecordType");
		type_EvidenceRecordType.enumValues = new String[] { "Boolean", "Integer", "Float", "Double", "String", };
		types.add(type_EvidenceRecordType);
		
		// Type Definition: EvidenceReference
		TypeBuilder type_EvidenceReference = new TypeBuilder("evidence", "EvidenceReference");
		type_EvidenceReference.isAbstract = false;
		type_EvidenceReference.isFinal = false;
		type_EvidenceReference.superTypeNames.add("evidence.BasicEvidence");
		{
		}
		types.add(type_EvidenceReference);
		
		// Type Definition: SafeRole
		TypeBuilder type_SafeRole = new TypeBuilder("saferole", "SafeRole");
		type_SafeRole.isAbstract = false;
		type_SafeRole.isFinal = false;
		type_SafeRole.superTypeNames.add("argument.SafeModelElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "saferole";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_SafeRole.attributes.add(attr_name);
			
		}
		types.add(type_SafeRole);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("argument.Context", cn.edu.buaa.sei.emt.assurance.ContextImpl.class);
		map.put("argument.InformationElement", cn.edu.buaa.sei.emt.assurance.InformationElementImpl.class);
		map.put("argument.Claim", cn.edu.buaa.sei.emt.assurance.ClaimImpl.class);
		map.put("argument.ClaimsRelation", cn.edu.buaa.sei.emt.assurance.ClaimsRelationImpl.class);
		map.put("argument.ClaimEvidenceRelation", cn.edu.buaa.sei.emt.assurance.ClaimEvidenceRelationImpl.class);
		map.put("argument.ContextRelation", cn.edu.buaa.sei.emt.assurance.ContextRelationImpl.class);
		map.put("argument.ArgumentReason", cn.edu.buaa.sei.emt.assurance.ArgumentReasonImpl.class);
		map.put("argument.ArgumentCitation", cn.edu.buaa.sei.emt.assurance.ArgumentCitationImpl.class);
		map.put("argument.Argumentation", cn.edu.buaa.sei.emt.assurance.ArgumentationImpl.class);
		map.put("argument.Assurance", cn.edu.buaa.sei.emt.assurance.AssuranceImpl.class);
		map.put("evidence.EvidenceContainer", cn.edu.buaa.sei.emt.assurance.EvidenceContainerImpl.class);
		map.put("evidence.Evidence", cn.edu.buaa.sei.emt.assurance.EvidenceImpl.class);
		map.put("evidence.EvidenceProperty", cn.edu.buaa.sei.emt.assurance.EvidencePropertyImpl.class);
		map.put("evidence.EvidenceGroup", cn.edu.buaa.sei.emt.assurance.EvidenceGroupImpl.class);
		map.put("evidence.Custody", cn.edu.buaa.sei.emt.assurance.CustodyImpl.class);
		map.put("evidence.Time", cn.edu.buaa.sei.emt.assurance.TimeImpl.class);
		map.put("evidence.Provenance", cn.edu.buaa.sei.emt.assurance.ProvenanceImpl.class);
		map.put("evidence.EvidenceStatus", cn.edu.buaa.sei.emt.assurance.EvidenceStatusImpl.class);
		map.put("evidence.EvidenceRelation", cn.edu.buaa.sei.emt.assurance.EvidenceRelationImpl.class);
		map.put("evidence.EvidenceEvent", cn.edu.buaa.sei.emt.assurance.EvidenceEventImpl.class);
		map.put("evidence.BasicEvidence", cn.edu.buaa.sei.emt.assurance.BasicEvidenceImpl.class);
		map.put("evidence.EvidenceRecord", cn.edu.buaa.sei.emt.assurance.EvidenceRecordImpl.class);
		map.put("evidence.EvidenceReference", cn.edu.buaa.sei.emt.assurance.EvidenceReferenceImpl.class);
		map.put("saferole.SafeRole", cn.edu.buaa.sei.emt.assurance.SafeRoleImpl.class);
		return map;
	}
	
}
