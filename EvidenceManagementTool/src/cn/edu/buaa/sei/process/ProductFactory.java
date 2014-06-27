package cn.edu.buaa.sei.process;

public class ProductFactory {
	
	
	
	public static Process createProcess() {
		return new ProcessImpl();
	}
	
	public static Role createRole() {
		return new RoleImpl();
	}
	
	public static Artifact createArtifact() {
		return new ArtifactImpl();
	}
	
	public static Performer createPerformer() {
		return new PerformerImpl();
	}
	
	public static ProcessParameter createProcessParameter() {
		return new ProcessParameterImpl();
	}
	
	public static ResponsibleAssign createResponsibleAssign() {
		return new ResponsibleAssignImpl();
	}
	
	public static ProcessSequence createProcessSequence() {
		return new ProcessSequenceImpl();
	}
	
	public static RoleRelation createRoleRelation() {
		return new RoleRelationImpl();
	}
	
	public static ArtifactRelation createArtifactRelation() {
		return new ArtifactRelationImpl();
	}
	
	public static Person createPerson() {
		return new PersonImpl();
	}
	
	public static Organization createOrganization() {
		return new OrganizationImpl();
	}
	
	public static ProcessRecord createProcessRecord() {
		return new ProcessRecordImpl();
	}
	
	public static ProcessGroup createProcessGroup() {
		return new ProcessGroupImpl();
	}
	
	public static Project createProject() {
		return new ProjectImpl();
	}
	
}
