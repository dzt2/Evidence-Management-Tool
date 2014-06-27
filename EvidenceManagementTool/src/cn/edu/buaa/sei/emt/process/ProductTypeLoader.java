package cn.edu.buaa.sei.emt.process;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import cn.edu.buaa.sei.lmf.AttributeBuilder;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.TypeBuilder;
import cn.edu.buaa.sei.lmf.TypeLoader;

public class ProductTypeLoader implements TypeLoader {
	
	
	
	@Override
	public Set<TypeBuilder> loadTypes(Map<String, TypeBuilder> existingTypes) {
		Set<TypeBuilder> types = new HashSet<TypeBuilder>();
		
		// Type Definition: PMElement
		TypeBuilder type_PMElement = new TypeBuilder("process", "PMElement");
		type_PMElement.isAbstract = false;
		type_PMElement.isFinal = false;
		type_PMElement.superTypeNames.add("core.ModelElement");
		{
		}
		types.add(type_PMElement);
		
		// Type Definition: Process
		TypeBuilder type_Process = new TypeBuilder("process", "Process");
		type_Process.isAbstract = false;
		type_Process.isFinal = false;
		type_Process.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "process";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Process.attributes.add(attr_name);
			
			// Attribute Definition: subordinate
			AttributeBuilder attr_subordinate = new AttributeBuilder("subordinate");
			attr_subordinate.extensionID = "process";
			attr_subordinate.valueTypeName = "primitives.<list>";
			attr_subordinate.isContainment = false;
			attr_subordinate.valueTypeParameter = "process.Process";
			type_Process.attributes.add(attr_subordinate);
			
		}
		types.add(type_Process);
		
		// Type Definition: Role
		TypeBuilder type_Role = new TypeBuilder("process", "Role");
		type_Role.isAbstract = false;
		type_Role.isFinal = false;
		type_Role.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: person
			AttributeBuilder attr_person = new AttributeBuilder("person");
			attr_person.extensionID = "process";
			attr_person.valueTypeName = "process.Person";
			attr_person.isContainment = false;
			type_Role.attributes.add(attr_person);
			
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "process";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Role.attributes.add(attr_name);
			
		}
		types.add(type_Role);
		
		// Type Definition: Artifact
		TypeBuilder type_Artifact = new TypeBuilder("process", "Artifact");
		type_Artifact.isAbstract = false;
		type_Artifact.isFinal = false;
		type_Artifact.superTypeNames.add("process.PMElement");
		{
		}
		types.add(type_Artifact);
		
		// Type Definition: Performer
		TypeBuilder type_Performer = new TypeBuilder("process", "Performer");
		type_Performer.isAbstract = false;
		type_Performer.isFinal = false;
		type_Performer.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: role
			AttributeBuilder attr_role = new AttributeBuilder("role");
			attr_role.extensionID = "process";
			attr_role.valueTypeName = "process.Role";
			attr_role.isContainment = false;
			type_Performer.attributes.add(attr_role);
			
			// Attribute Definition: process
			AttributeBuilder attr_process = new AttributeBuilder("process");
			attr_process.extensionID = "process";
			attr_process.valueTypeName = "process.Process";
			attr_process.isContainment = false;
			type_Performer.attributes.add(attr_process);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.PerformerType";
			type_Performer.attributes.add(attr_type);
			
		}
		types.add(type_Performer);
		
		// Type Definition: ProcessParameter
		TypeBuilder type_ProcessParameter = new TypeBuilder("process", "ProcessParameter");
		type_ProcessParameter.isAbstract = false;
		type_ProcessParameter.isFinal = false;
		type_ProcessParameter.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: artifact
			AttributeBuilder attr_artifact = new AttributeBuilder("artifact");
			attr_artifact.extensionID = "process";
			attr_artifact.valueTypeName = "process.Artifact";
			attr_artifact.isContainment = false;
			type_ProcessParameter.attributes.add(attr_artifact);
			
			// Attribute Definition: process
			AttributeBuilder attr_process = new AttributeBuilder("process");
			attr_process.extensionID = "process";
			attr_process.valueTypeName = "process.Process";
			attr_process.isContainment = false;
			type_ProcessParameter.attributes.add(attr_process);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.ProcessParameterType";
			type_ProcessParameter.attributes.add(attr_type);
			
		}
		types.add(type_ProcessParameter);
		
		// Type Definition: ResponsibleAssign
		TypeBuilder type_ResponsibleAssign = new TypeBuilder("process", "ResponsibleAssign");
		type_ResponsibleAssign.isAbstract = false;
		type_ResponsibleAssign.isFinal = false;
		type_ResponsibleAssign.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: role
			AttributeBuilder attr_role = new AttributeBuilder("role");
			attr_role.extensionID = "process";
			attr_role.valueTypeName = "process.Role";
			attr_role.isContainment = false;
			type_ResponsibleAssign.attributes.add(attr_role);
			
			// Attribute Definition: artifact
			AttributeBuilder attr_artifact = new AttributeBuilder("artifact");
			attr_artifact.extensionID = "process";
			attr_artifact.valueTypeName = "process.Artifact";
			attr_artifact.isContainment = false;
			type_ResponsibleAssign.attributes.add(attr_artifact);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.ResponsibleAssignType";
			type_ResponsibleAssign.attributes.add(attr_type);
			
		}
		types.add(type_ResponsibleAssign);
		
		// Type Definition: ProcessSequence
		TypeBuilder type_ProcessSequence = new TypeBuilder("process", "ProcessSequence");
		type_ProcessSequence.isAbstract = false;
		type_ProcessSequence.isFinal = false;
		type_ProcessSequence.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: source
			AttributeBuilder attr_source = new AttributeBuilder("source");
			attr_source.extensionID = "process";
			attr_source.valueTypeName = "process.Process";
			attr_source.isContainment = false;
			type_ProcessSequence.attributes.add(attr_source);
			
			// Attribute Definition: target
			AttributeBuilder attr_target = new AttributeBuilder("target");
			attr_target.extensionID = "process";
			attr_target.valueTypeName = "process.Process";
			attr_target.isContainment = false;
			type_ProcessSequence.attributes.add(attr_target);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.ProcessSequenceType";
			type_ProcessSequence.attributes.add(attr_type);
			
		}
		types.add(type_ProcessSequence);
		
		// Type Definition: RoleRelation
		TypeBuilder type_RoleRelation = new TypeBuilder("process", "RoleRelation");
		type_RoleRelation.isAbstract = false;
		type_RoleRelation.isFinal = false;
		type_RoleRelation.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: source
			AttributeBuilder attr_source = new AttributeBuilder("source");
			attr_source.extensionID = "process";
			attr_source.valueTypeName = "process.Role";
			attr_source.isContainment = false;
			type_RoleRelation.attributes.add(attr_source);
			
			// Attribute Definition: target
			AttributeBuilder attr_target = new AttributeBuilder("target");
			attr_target.extensionID = "process";
			attr_target.valueTypeName = "process.Role";
			attr_target.isContainment = false;
			type_RoleRelation.attributes.add(attr_target);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.RoleRelationType";
			type_RoleRelation.attributes.add(attr_type);
			
		}
		types.add(type_RoleRelation);
		
		// Type Definition: ArtifactRelation
		TypeBuilder type_ArtifactRelation = new TypeBuilder("process", "ArtifactRelation");
		type_ArtifactRelation.isAbstract = false;
		type_ArtifactRelation.isFinal = false;
		type_ArtifactRelation.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: source
			AttributeBuilder attr_source = new AttributeBuilder("source");
			attr_source.extensionID = "process";
			attr_source.valueTypeName = "process.Artifact";
			attr_source.isContainment = false;
			type_ArtifactRelation.attributes.add(attr_source);
			
			// Attribute Definition: type
			AttributeBuilder attr_type = new AttributeBuilder("type");
			attr_type.extensionID = "process";
			attr_type.valueTypeName = "primitives.<enum>";
			attr_type.isContainment = true;
			attr_type.valueTypeParameter = "process.ArtifactRelationType";
			type_ArtifactRelation.attributes.add(attr_type);
			
			// Attribute Definition: target
			AttributeBuilder attr_target = new AttributeBuilder("target");
			attr_target.extensionID = "process";
			attr_target.valueTypeName = "process.Artifact";
			attr_target.isContainment = false;
			type_ArtifactRelation.attributes.add(attr_target);
			
		}
		types.add(type_ArtifactRelation);
		
		// Type Definition: ProcessParameterType
		TypeBuilder type_ProcessParameterType = new TypeBuilder("process", "ProcessParameterType");
		type_ProcessParameterType.enumValues = new String[] { "In", "Out", "InOut", };
		types.add(type_ProcessParameterType);
		
		// Type Definition: ProcessSequenceType
		TypeBuilder type_ProcessSequenceType = new TypeBuilder("process", "ProcessSequenceType");
		type_ProcessSequenceType.enumValues = new String[] { "StartToStart", "StartToEnd", "EndToStart", "EndToEnd", };
		types.add(type_ProcessSequenceType);
		
		// Type Definition: PerformerType
		TypeBuilder type_PerformerType = new TypeBuilder("process", "PerformerType");
		type_PerformerType.enumValues = new String[] { "execute", "review", "plan", };
		types.add(type_PerformerType);
		
		// Type Definition: ArtifactRelationType
		TypeBuilder type_ArtifactRelationType = new TypeBuilder("process", "ArtifactRelationType");
		type_ArtifactRelationType.enumValues = new String[] { "include", };
		types.add(type_ArtifactRelationType);
		
		// Type Definition: ResponsibleAssignType
		TypeBuilder type_ResponsibleAssignType = new TypeBuilder("process", "ResponsibleAssignType");
		type_ResponsibleAssignType.enumValues = new String[] { "create", "remove", "modify", "evaluate", "own", "approve", };
		types.add(type_ResponsibleAssignType);
		
		// Type Definition: RoleRelationType
		TypeBuilder type_RoleRelationType = new TypeBuilder("process", "RoleRelationType");
		type_RoleRelationType.enumValues = new String[] { "guide", };
		types.add(type_RoleRelationType);
		
		// Type Definition: ProcessRecord
		TypeBuilder type_ProcessRecord = new TypeBuilder("process", "ProcessRecord");
		type_ProcessRecord.isAbstract = false;
		type_ProcessRecord.isFinal = false;
		type_ProcessRecord.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: startTime
			AttributeBuilder attr_startTime = new AttributeBuilder("startTime");
			attr_startTime.extensionID = "process";
			attr_startTime.valueTypeName = "primitives.<string>";
			attr_startTime.isContainment = true;
			type_ProcessRecord.attributes.add(attr_startTime);
			
			// Attribute Definition: endTime
			AttributeBuilder attr_endTime = new AttributeBuilder("endTime");
			attr_endTime.extensionID = "process";
			attr_endTime.valueTypeName = "primitives.<string>";
			attr_endTime.isContainment = true;
			type_ProcessRecord.attributes.add(attr_endTime);
			
		}
		types.add(type_ProcessRecord);
		
		// Type Definition: ProcessGroup
		TypeBuilder type_ProcessGroup = new TypeBuilder("process", "ProcessGroup");
		type_ProcessGroup.isAbstract = false;
		type_ProcessGroup.isFinal = false;
		type_ProcessGroup.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "process";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_ProcessGroup.attributes.add(attr_name);
			
			// Attribute Definition: processes
			AttributeBuilder attr_processes = new AttributeBuilder("processes");
			attr_processes.extensionID = "process";
			attr_processes.valueTypeName = "primitives.<list>";
			attr_processes.isContainment = false;
			attr_processes.valueTypeParameter = "process.Process";
			type_ProcessGroup.attributes.add(attr_processes);
			
		}
		types.add(type_ProcessGroup);
		
		// Type Definition: PMProject
		TypeBuilder type_PMProject = new TypeBuilder("process", "PMProject");
		type_PMProject.isAbstract = false;
		type_PMProject.isFinal = false;
		type_PMProject.superTypeNames.add("process.PMElement");
		{
			// Attribute Definition: processList
			AttributeBuilder attr_processList = new AttributeBuilder("processList");
			attr_processList.extensionID = "process";
			attr_processList.valueTypeName = "primitives.<list>";
			attr_processList.isContainment = false;
			attr_processList.valueTypeParameter = "process.Process";
			type_PMProject.attributes.add(attr_processList);
			
			// Attribute Definition: processSequenceList
			AttributeBuilder attr_processSequenceList = new AttributeBuilder("processSequenceList");
			attr_processSequenceList.extensionID = "process";
			attr_processSequenceList.valueTypeName = "primitives.<list>";
			attr_processSequenceList.isContainment = false;
			attr_processSequenceList.valueTypeParameter = "process.ProcessSequence";
			type_PMProject.attributes.add(attr_processSequenceList);
			
			// Attribute Definition: processGroupList
			AttributeBuilder attr_processGroupList = new AttributeBuilder("processGroupList");
			attr_processGroupList.extensionID = "process";
			attr_processGroupList.valueTypeName = "primitives.<list>";
			attr_processGroupList.isContainment = false;
			attr_processGroupList.valueTypeParameter = "process.ProcessGroup";
			type_PMProject.attributes.add(attr_processGroupList);
			
			// Attribute Definition: organizationList
			AttributeBuilder attr_organizationList = new AttributeBuilder("organizationList");
			attr_organizationList.extensionID = "process";
			attr_organizationList.valueTypeName = "primitives.<list>";
			attr_organizationList.isContainment = false;
			attr_organizationList.valueTypeParameter = "process.Organization";
			type_PMProject.attributes.add(attr_organizationList);
			
			// Attribute Definition: roleList
			AttributeBuilder attr_roleList = new AttributeBuilder("roleList");
			attr_roleList.extensionID = "process";
			attr_roleList.valueTypeName = "primitives.<list>";
			attr_roleList.isContainment = false;
			attr_roleList.valueTypeParameter = "process.Role";
			type_PMProject.attributes.add(attr_roleList);
			
			// Attribute Definition: roleRelationList
			AttributeBuilder attr_roleRelationList = new AttributeBuilder("roleRelationList");
			attr_roleRelationList.extensionID = "process";
			attr_roleRelationList.valueTypeName = "primitives.<list>";
			attr_roleRelationList.isContainment = false;
			attr_roleRelationList.valueTypeParameter = "process.RoleRelation";
			type_PMProject.attributes.add(attr_roleRelationList);
			
			// Attribute Definition: artifactList
			AttributeBuilder attr_artifactList = new AttributeBuilder("artifactList");
			attr_artifactList.extensionID = "process";
			attr_artifactList.valueTypeName = "primitives.<list>";
			attr_artifactList.isContainment = false;
			attr_artifactList.valueTypeParameter = "process.Artifact";
			type_PMProject.attributes.add(attr_artifactList);
			
			// Attribute Definition: artifactRelationList
			AttributeBuilder attr_artifactRelationList = new AttributeBuilder("artifactRelationList");
			attr_artifactRelationList.extensionID = "process";
			attr_artifactRelationList.valueTypeName = "primitives.<list>";
			attr_artifactRelationList.isContainment = false;
			attr_artifactRelationList.valueTypeParameter = "process.ArtifactRelation";
			type_PMProject.attributes.add(attr_artifactRelationList);
			
		}
		types.add(type_PMProject);
		
		// Type Definition: Person
		TypeBuilder type_Person = new TypeBuilder("process", "Person");
		type_Person.isAbstract = false;
		type_Person.isFinal = false;
		type_Person.superTypeNames.add("core.ModelElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "process";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Person.attributes.add(attr_name);
			
			// Attribute Definition: mail
			AttributeBuilder attr_mail = new AttributeBuilder("mail");
			attr_mail.extensionID = "process";
			attr_mail.valueTypeName = "primitives.<string>";
			attr_mail.isContainment = true;
			type_Person.attributes.add(attr_mail);
			
			// Attribute Definition: sex
			AttributeBuilder attr_sex = new AttributeBuilder("sex");
			attr_sex.extensionID = "process";
			attr_sex.valueTypeName = "primitives.<string>";
			attr_sex.isContainment = true;
			type_Person.attributes.add(attr_sex);
			
		}
		types.add(type_Person);
		
		// Type Definition: Organization
		TypeBuilder type_Organization = new TypeBuilder("process", "Organization");
		type_Organization.isAbstract = false;
		type_Organization.isFinal = false;
		type_Organization.superTypeNames.add("core.ModelElement");
		{
			// Attribute Definition: name
			AttributeBuilder attr_name = new AttributeBuilder("name");
			attr_name.extensionID = "process";
			attr_name.valueTypeName = "primitives.<string>";
			attr_name.isContainment = true;
			type_Organization.attributes.add(attr_name);
			
			// Attribute Definition: roles
			AttributeBuilder attr_roles = new AttributeBuilder("roles");
			attr_roles.extensionID = "process";
			attr_roles.valueTypeName = "primitives.<list>";
			attr_roles.isContainment = false;
			attr_roles.valueTypeParameter = "process.Role";
			type_Organization.attributes.add(attr_roles);
			
		}
		types.add(type_Organization);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("process.PMElement", cn.edu.buaa.sei.emt.process.PMElementImpl.class);
		map.put("process.Process", cn.edu.buaa.sei.emt.process.ProcessImpl.class);
		map.put("process.Role", cn.edu.buaa.sei.emt.process.RoleImpl.class);
		map.put("process.Artifact", cn.edu.buaa.sei.emt.process.ArtifactImpl.class);
		map.put("process.Performer", cn.edu.buaa.sei.emt.process.PerformerImpl.class);
		map.put("process.ProcessParameter", cn.edu.buaa.sei.emt.process.ProcessParameterImpl.class);
		map.put("process.ResponsibleAssign", cn.edu.buaa.sei.emt.process.ResponsibleAssignImpl.class);
		map.put("process.ProcessSequence", cn.edu.buaa.sei.emt.process.ProcessSequenceImpl.class);
		map.put("process.RoleRelation", cn.edu.buaa.sei.emt.process.RoleRelationImpl.class);
		map.put("process.ArtifactRelation", cn.edu.buaa.sei.emt.process.ArtifactRelationImpl.class);
		map.put("process.ProcessRecord", cn.edu.buaa.sei.emt.process.ProcessRecordImpl.class);
		map.put("process.ProcessGroup", cn.edu.buaa.sei.emt.process.ProcessGroupImpl.class);
		map.put("process.PMProject", cn.edu.buaa.sei.emt.process.PMProjectImpl.class);
		map.put("process.Person", cn.edu.buaa.sei.emt.process.PersonImpl.class);
		map.put("process.Organization", cn.edu.buaa.sei.emt.process.OrganizationImpl.class);
		return map;
	}
	
}
