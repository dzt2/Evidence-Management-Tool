package cn.edu.buaa.sei.emt.assurance;

public class SafeFactory {
	
	
	
	public static Context createContext() {
		return new ContextImpl();
	}
	
	public static InformationElement createInformationElement() {
		return new InformationElementImpl();
	}
	
	public static Claim createClaim() {
		return new ClaimImpl();
	}
	
	public static ClaimsRelation createClaimsRelation() {
		return new ClaimsRelationImpl();
	}
	
	public static ClaimEvidenceRelation createClaimEvidenceRelation() {
		return new ClaimEvidenceRelationImpl();
	}
	
	public static ContextRelation createContextRelation() {
		return new ContextRelationImpl();
	}
	
	public static ArgumentReason createArgumentReason() {
		return new ArgumentReasonImpl();
	}
	
	public static ArgumentCitation createArgumentCitation() {
		return new ArgumentCitationImpl();
	}
	
	public static Argumentation createArgumentation() {
		return new ArgumentationImpl();
	}
	
	public static Assurance createAssurance() {
		return new AssuranceImpl();
	}
	
	public static EvidenceContainer createEvidenceContainer() {
		return new EvidenceContainerImpl();
	}
	
	public static Evidence createEvidence() {
		return new EvidenceImpl();
	}
	
	public static EvidenceProperty createEvidenceProperty() {
		return new EvidencePropertyImpl();
	}
	
	public static EvidenceGroup createEvidenceGroup() {
		return new EvidenceGroupImpl();
	}
	
	public static Custody createCustody() {
		return new CustodyImpl();
	}
	
	public static Time createTime() {
		return new TimeImpl();
	}
	
	public static Provenance createProvenance() {
		return new ProvenanceImpl();
	}
	
	public static EvidenceStatus createEvidenceStatus() {
		return new EvidenceStatusImpl();
	}
	
	public static EvidenceRelation createEvidenceRelation() {
		return new EvidenceRelationImpl();
	}
	
	public static EvidenceEvent createEvidenceEvent() {
		return new EvidenceEventImpl();
	}
	
	public static BasicEvidence createBasicEvidence() {
		return new BasicEvidenceImpl();
	}
	
	public static EvidenceRecord createEvidenceRecord() {
		return new EvidenceRecordImpl();
	}
	
	public static EvidenceReference createEvidenceReference() {
		return new EvidenceReferenceImpl();
	}
	
	public static SafeRole createSafeRole() {
		return new SafeRoleImpl();
	}
	
}
