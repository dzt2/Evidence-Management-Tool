package cn.edu.buaa.sei.emt.safe_manage;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import cn.edu.buaa.sei.emt.safe.Assertion;
import cn.edu.buaa.sei.emt.safe.AssumedBy;
import cn.edu.buaa.sei.emt.safe.Assumption;
import cn.edu.buaa.sei.emt.safe.Claim;
import cn.edu.buaa.sei.emt.safe.Context;
import cn.edu.buaa.sei.emt.safe.ContextOf;
import cn.edu.buaa.sei.emt.safe.Evidence;
import cn.edu.buaa.sei.emt.safe.EvidenceRef;
import cn.edu.buaa.sei.emt.safe.ImplClaim;
import cn.edu.buaa.sei.emt.safe.Inference;
import cn.edu.buaa.sei.emt.safe.InferenceSupportByClaim;
import cn.edu.buaa.sei.emt.safe.Justification;
import cn.edu.buaa.sei.emt.safe.JustifiedBy;
import cn.edu.buaa.sei.emt.safe.SInformationElement;
import cn.edu.buaa.sei.emt.safe.SNode;
import cn.edu.buaa.sei.emt.safe.SRelation;
import cn.edu.buaa.sei.emt.safe.SafetyCase;
import cn.edu.buaa.sei.emt.safe.SupportByClaim;
import cn.edu.buaa.sei.emt.safe.SupportByEvidence;
import cn.edu.buaa.sei.emt.safe.SupportByInference;
import cn.edu.buaa.sei.emt.safe.UndevClaim;

public class SafetyCaseManagerImpl implements SafetyCaseManager{
	SafetyCase scase;
	Map<String,ImplClaim> impl_claim_map = new HashMap<String,ImplClaim>();
	Map<String,UndevClaim> undev_claim_map = new HashMap<String,UndevClaim>();
	Map<String,EvidenceRef> evidenceref_map = new HashMap<String, EvidenceRef>();
	Map<String,Context> context_map = new HashMap<String,Context>();
	Map<String,Assumption> assumption_map = new HashMap<String,Assumption>();
	Map<String,Justification> justification_map = new HashMap<String,Justification>();
	Map<String,Inference> inference_map = new HashMap<String,Inference>();
	
	Map<String,SupportByClaim> supportbyclaim_map = new HashMap<String,SupportByClaim>();
	Map<String,SupportByInference> supportbyinference_map = new HashMap<String,SupportByInference>();
	Map<String,SupportByEvidence> supportbyevidence_map = new HashMap<String,SupportByEvidence>();
	Map<String,InferenceSupportByClaim> inferencesupportbyclaim_map = new HashMap<String,InferenceSupportByClaim>();
	Map<String,ContextOf> contextof_map = new HashMap<String,ContextOf>();
	Map<String,AssumedBy> assumedby_map = new HashMap<String,AssumedBy>();
	Map<String,JustifiedBy> justifiedby_map = new HashMap<String,JustifiedBy>();

	public SafetyCaseManagerImpl(SafetyCase scase) throws Exception{
		if(scase==null)throw new Exception("Safety Case could not be null.");
		this.scase=scase;
	}
	
	public static SafetyCase createSafetyCase(String name){
		return SCaseConstructor.createSafetyCase(name);
	}
	
	@Override
	public void addNewImplClaim(String name, String stmt, boolean assumed) {
		// TODO Auto-generated method stub
		ImplClaim claim = SCaseConstructor.createImplClaim(name, stmt, assumed);
		if(claim==null||this.impl_claim_map.containsKey(name))
			try {
				throw new Exception("Creating ImplClaim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getImplClaims().add(claim);
		
		this.impl_claim_map.put(claim.getName(), claim);
	}

	@Override
	public void addNewUndevClaim(String name, String stmt, boolean assumed) {
		// TODO Auto-generated method stub
		UndevClaim claim = SCaseConstructor.createUndeveClaim(name, stmt, assumed);
		if(claim==null||this.undev_claim_map.containsKey(name))
			try {
				throw new Exception("Creating UndevClaim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return;
			}
		scase.getUndevClaims().add(claim);
		
		this.undev_claim_map.put(claim.getName(), claim);
	}

	@Override
	public void addNewEvidenceRef(String name, String description) {
		// TODO Auto-generated method stub
		EvidenceRef ref = SCaseConstructor.createEvidenceRefer(name, description);
		if(ref==null||this.evidenceref_map.containsKey(name))
			try {
				throw new Exception("Creating EvidenceRef: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getEvidenceRefs().add(ref);
		
		this.evidenceref_map.put(ref.getName(), ref);
	}

	@Override
	public void addNewInference(String name, String stmt) {
		// TODO Auto-generated method stub
		Inference inference = SCaseConstructor.createInference(name, stmt);
		if(inference==null||this.inference_map.containsKey(name))
			try {
				throw new Exception("Creating Inference: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getInferences().add(inference);
		
		this.inference_map.put(name, inference);
	}

	@Override
	public void addNewContext(String name, String description) {
		// TODO Auto-generated method stub
		Context context = SCaseConstructor.createContext(name, description);
		if(context==null||this.context_map.containsKey(name))
			try {
				throw new Exception("Creating Context: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getContexts().add(context);
		
		this.context_map.put(context.getName(), context);
	}

	@Override
	public void addNewJustification(String name, String stmt) {
		// TODO Auto-generated method stub
		Justification justification = SCaseConstructor.createJustification(name, stmt);
		
		if(justification==null||this.justification_map.containsKey(name))
			try {
				throw new Exception("Creating Justification: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getJustifications().add(justification);
		
		this.justification_map.put(justification.getName(), justification);
	}

	@Override
	public void addNewAssumption(String name, String stmt) {
		// TODO Auto-generated method stub
		Assumption assumption = SCaseConstructor.createAssumption(name, stmt);
		
		if(assumption==null||this.assumption_map.containsKey(name))
			try {
				throw new Exception("Creating Assumption: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getAssumptions().add(assumption);
		
		this.assumption_map.put(name, assumption);
	}

	private String getID_Relation(SNode source,SNode target){
		if(source==null||target==null)return null;
		return source.getName()+"-"+target.getName();
	}
	
	@Override
	public void ClaimLinkClaim(Claim premise, ImplClaim conclusion) {
		// TODO Auto-generated method stub
		SupportByClaim link = SCaseConstructor.ClaimLinkClaim(conclusion, premise);
		String id = this.getID_Relation(premise, conclusion);
		if(link==null||this.supportbyclaim_map.containsKey(id))
			try {
				throw new Exception("Linking Claim-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getClaim_claim_links().add(link);
		this.supportbyclaim_map.put(id, link);
	}

	@Override
	public void ClaimLinkInference(ImplClaim claim, Inference inference) {
		// TODO Auto-generated method stub
		SupportByInference link = SCaseConstructor.ClaimLinkInference(claim, inference);
		String id = this.getID_Relation(inference, claim);
		if(link==null||this.supportbyinference_map.containsKey(id))
			try {
				throw new Exception("Linking Inference-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getClaim_inference_links().add(link);
		this.supportbyinference_map.put(id, link);
	}

	@Override
	public void ClaimLinkEvidenceRef(ImplClaim claim, EvidenceRef ref) {
		// TODO Auto-generated method stub
		SupportByEvidence link = SCaseConstructor.ClaimLinkEvidence(claim, ref);
		String id = this.getID_Relation(claim, ref);
		if(link==null||this.supportbyevidence_map.containsKey(id))
			try {
				throw new Exception("Linking Claim-Evidence: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		scase.getClaim_evidence_links().add(link);
		this.supportbyevidence_map.put(id, link);
	}

	@Override
	public void ContextLinkClaim(Context context, Claim claim) {
		// TODO Auto-generated method stub
		ContextOf link = SCaseConstructor.ContextLinkClaim(context, claim);
		String id = this.getID_Relation(context, claim);
		if(link==null||this.contextof_map.containsKey(id))
			try {
				throw new Exception("Linking Context-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getContext_links().add(link);
		this.contextof_map.put(id, link);
	}

	@Override
	public void ContextLinkInference(Context context, Inference inference) {
		// TODO Auto-generated method stub
		ContextOf link = SCaseConstructor.ContextLinkInference(context, inference);
		String id = this.getID_Relation(context, inference);
		if(link==null||this.contextof_map.containsKey(id))
			try {
				throw new Exception("Linking Context-Inference: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getContext_links().add(link);
		this.contextof_map.put(id, link);
	}

	@Override
	public void JustificationLinkClaim(Justification justification, Claim claim) {
		// TODO Auto-generated method stub
		JustifiedBy link = SCaseConstructor.JustLinkClaim(justification, claim);
		String id = this.getID_Relation(justification, claim);
		if(link==null||this.justifiedby_map.containsKey(id))
			try {
				throw new Exception("Linking Justification-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getJustification_links().add(link);
		this.justifiedby_map.put(id, link);
	}

	@Override
	public void JustificationLinkInference(Justification justification,
			Inference inference) {
		// TODO Auto-generated method stub
		JustifiedBy link = SCaseConstructor.JustLinkInference(justification, inference);
		String id = this.getID_Relation(justification, inference);
		
		if(link==null||this.justifiedby_map.containsKey(id))
			try {
				throw new Exception("Linking Justification-Inference: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getJustification_links().add(link);
		this.justifiedby_map.put(id, link);
	}

	@Override
	public void AssumptionLinkClaim(Assumption assumption, Claim claim) {
		// TODO Auto-generated method stub
		AssumedBy link = SCaseConstructor.AssumLinkClaim(assumption, claim);
		String id = this.getID_Relation(assumption, claim);
		if(link==null||this.assumedby_map.containsKey(id))
			try {
				throw new Exception("Linking Assumption-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
			
		scase.getAssumption_links().add(link);
		this.assumedby_map.put(id, link);
	}

	@Override
	public void AssumptionLinkInference(Assumption assumption,
			Inference inference) {
		// TODO Auto-generated method stub
		AssumedBy link = SCaseConstructor.AssumLinkInference(assumption, inference);
		String id = this.getID_Relation(assumption, inference);
		
		if(link==null||this.assumedby_map.containsKey(id))
			try {
				throw new Exception("Linking Assumption-Inference: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
			
		scase.getAssumption_links().add(link);
		this.assumedby_map.put(id, link);
	}

	@Override
	public void InferenceLinkClaim(Inference inference, Claim claim) {
		// TODO Auto-generated method stub
		InferenceSupportByClaim link = SCaseConstructor.InferenceLinkClaim(inference, claim);
		String id = this.getID_Relation(inference, claim);
		
		if(link==null||this.inferencesupportbyclaim_map.containsKey(id))
			try {
				throw new Exception("Linking Inference-Claim: failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return;
			}
		
		scase.getInference_claim_links().add(link);
		this.inferencesupportbyclaim_map.put(id, link);
	}

	@Override
	public void EvidenceRefLinkEvidence(EvidenceRef ref, Evidence evidence) {
		// TODO Auto-generated method stub
		SCaseConstructor.RefLinkEvidence(ref, evidence);
	}

	@Override
	public void UndevClaimLinkSafetyCase(UndevClaim claim, SafetyCase scase) {
		// TODO Auto-generated method stub
		SCaseConstructor.ClaimLinkSafetyCase(claim, scase);
	}

	@Override
	public Collection<SNode> getSNodes() {
		// TODO Auto-generated method stub
		Collection<SNode> nodes = new HashSet<SNode>();
		nodes.addAll(this.impl_claim_map.values());
		nodes.addAll(this.undev_claim_map.values());
		nodes.addAll(this.evidenceref_map.values());
		nodes.addAll(this.inference_map.values());
		nodes.addAll(this.context_map.values());
		nodes.addAll(this.assumption_map.values());
		nodes.addAll(this.justification_map.values());
		return nodes;
	}

	@Override
	public Collection<SInformationElement> getSInformationElements() {
		// TODO Auto-generated method stub
		Collection<SInformationElement> elements = new HashSet<SInformationElement>();
		elements.addAll(this.evidenceref_map.values());
		elements.addAll(this.context_map.values());
		return elements;
	}

	@Override
	public Collection<SRelation> getSRelations() {
		// TODO Auto-generated method stub
		Collection<SRelation> relations = new HashSet<SRelation>();
		relations.addAll(this.supportbyclaim_map.values());
		relations.addAll(this.supportbyevidence_map.values());
		relations.addAll(this.supportbyinference_map.values());
		relations.addAll(this.inferencesupportbyclaim_map.values());
		relations.addAll(this.contextof_map.values());
		relations.addAll(this.justifiedby_map.values());
		relations.addAll(this.assumedby_map.values());
		
		return relations;
	}

	@Override
	public Collection<Assertion> getAssertions() {
		// TODO Auto-generated method stub
		Collection<Assertion> assertions = new HashSet<Assertion>();
		assertions.addAll(this.impl_claim_map.values());
		assertions.addAll(this.undev_claim_map.values());
		assertions.addAll(this.inference_map.values());
		assertions.addAll(this.assumption_map.values());
		assertions.addAll(this.justification_map.values());
		return assertions;
	}

	@Override
	public Collection<Claim> getClaims() {
		// TODO Auto-generated method stub
		Collection<Claim> claims = new HashSet<Claim>();
		claims.addAll(this.impl_claim_map.values());
		claims.addAll(this.undev_claim_map.values());
		return claims;
	}

	@Override
	public Collection<ImplClaim> getImplClaims() {
		// TODO Auto-generated method stub
		return this.impl_claim_map.values();
	}

	@Override
	public Collection<UndevClaim> getUndevClaims() {
		// TODO Auto-generated method stub
		return this.undev_claim_map.values();
	}

	@Override
	public Collection<Context> getContexts() {
		// TODO Auto-generated method stub
		return this.context_map.values();
	}

	@Override
	public Collection<Justification> getJustifications() {
		// TODO Auto-generated method stub
		return this.justification_map.values();
	}

	@Override
	public Collection<Assumption> getAssumptions() {
		// TODO Auto-generated method stub
		return this.assumption_map.values();
	}

	@Override
	public Collection<Inference> getInferences() {
		// TODO Auto-generated method stub
		return this.inference_map.values();
	}

	@Override
	public Collection<EvidenceRef> getEvidenceRefs() {
		// TODO Auto-generated method stub
		return this.evidenceref_map.values();
	}

	@Override
	public Collection<Evidence> getEvidence() {
		// TODO Auto-generated method stub
		Collection<Evidence> evidences = new HashSet<Evidence>();
		for(EvidenceRef ref:this.evidenceref_map.values())
			if(ref.getEvidence()!=null)
				evidences.add(ref.getEvidence());
		return evidences;
	}

	@Override
	public Collection<SafetyCase> getSubSafetyCases() {
		// TODO Auto-generated method stub
		Collection<SafetyCase> scases = new HashSet<SafetyCase>();
		for(UndevClaim claim:this.undev_claim_map.values())
			if(claim.getRefcase()!=null)
				scases.add(claim.getRefcase());
		return scases;
	}

	@Override
	public Collection<SupportByClaim> getSupportByClaims() {
		// TODO Auto-generated method stub
		return this.supportbyclaim_map.values();
	}

	@Override
	public Collection<SupportByInference> getSupportByInferences() {
		// TODO Auto-generated method stub
		return this.supportbyinference_map.values();
	}

	@Override
	public Collection<SupportByEvidence> getSupportByEvidences() {
		// TODO Auto-generated method stub
		return this.supportbyevidence_map.values();
	}

	@Override
	public Collection<InferenceSupportByClaim> getInferenceSupportByClaims() {
		// TODO Auto-generated method stub
		return this.inferencesupportbyclaim_map.values();
	}

	@Override
	public Collection<ContextOf> getContextOfs() {
		// TODO Auto-generated method stub
		return this.contextof_map.values();
	}

	@Override
	public Collection<JustifiedBy> getJustifiedBys() {
		// TODO Auto-generated method stub
		return this.justifiedby_map.values();
	}

	@Override
	public Collection<AssumedBy> getAssumedBys() {
		// TODO Auto-generated method stub
		return this.assumedby_map.values();
	}

	@Override
	public SNode getSNode(String name) {
		// TODO Auto-generated method stub
		SNode node = null;
		
		node = this.impl_claim_map.get(name);
		if(node!=null)return node;
		
		node = this.undev_claim_map.get(name);
		if(node!=null)return node;
		
		node = this.inference_map.get(name);
		if(node!=null)return node;
		
		node = this.evidenceref_map.get(name);
		if(node!=null)return node;
		
		node = this.context_map.get(name);
		if(node!=null)return node;
		
		node = this.justification_map.get(name);
		if(node!=null)return node;
		
		node = this.assumption_map.get(name);
		if(node!=null)return node;
		else return null;
	}

	@Override
	public SInformationElement getSInformationElement(String name) {
		// TODO Auto-generated method stub
		SInformationElement element = null;
		if(this.evidenceref_map.containsKey(name))
			element = this.evidenceref_map.get(name);
		else if(this.context_map.containsKey(name))
			element = this.context_map.get(name);
		return element;
	}

	@Override
	public SRelation getSRelation(SNode source, SNode target) {
		// TODO Auto-generated method stub
		String id = this.getID_Relation(source, target);
		
		if(this.supportbyclaim_map.containsKey(id))return this.supportbyclaim_map.get(id);
		if(this.supportbyevidence_map.containsKey(id))return this.supportbyevidence_map.get(id);
		if(this.supportbyinference_map.containsKey(id))return this.supportbyinference_map.get(id);
		if(this.inferencesupportbyclaim_map.containsKey(id))return this.inferencesupportbyclaim_map.get(id);
		if(this.contextof_map.containsKey(id))return this.contextof_map.get(id);
		if(this.justifiedby_map.containsKey(id))return this.justifiedby_map.get(id);
		if(this.assumedby_map.containsKey(id))return this.assumedby_map.get(id);
		
		return null;
	}

	@Override
	public Claim getClaim(String name) {
		// TODO Auto-generated method stub
		Claim claim = null;
		if(this.impl_claim_map.containsKey(name))
			claim = this.impl_claim_map.get(name);
		else if(this.undev_claim_map.containsKey(name))
			claim = this.undev_claim_map.get(name);
		return claim;
	}

	@Override
	public ImplClaim getImplClaim(String name) {
		// TODO Auto-generated method stub
		return this.impl_claim_map.get(name);
	}

	@Override
	public UndevClaim getUndevClaim(String name) {
		// TODO Auto-generated method stub
		return this.undev_claim_map.get(name);
	}

	@Override
	public Context getContext(String name) {
		// TODO Auto-generated method stub
		return this.context_map.get(name);
	}

	@Override
	public Justification getJustification(String name) {
		// TODO Auto-generated method stub
		return this.justification_map.get(name);
	}

	@Override
	public Assumption getAssumption(String name) {
		// TODO Auto-generated method stub
		return this.assumption_map.get(name);
	}

	@Override
	public Inference getInference(String name) {
		// TODO Auto-generated method stub
		return this.inference_map.get(name);
	}

	@Override
	public EvidenceRef getEvidenceRef(String name) {
		// TODO Auto-generated method stub
		return this.evidenceref_map.get(name);
	}

	@Override
	public SupportByClaim getSupportByClaim(Claim premise, ImplClaim conclusion) {
		// TODO Auto-generated method stub
		String id = this.getID_Relation(premise, conclusion);
		return this.supportbyclaim_map.get(id);
	}

	@Override
	public SupportByEvidence getSupportByEvidence(ImplClaim claim,
			EvidenceRef ref) {
		// TODO Auto-generated method stub
		String id = this.getID_Relation(ref, claim);
		return this.supportbyevidence_map.get(id);
	}

	@Override
	public SupportByInference getSupportByInderence(ImplClaim claim,
			Inference inference) {
		// TODO Auto-generated method stub
		String id = this.getID_Relation(inference, claim);
		return this.supportbyinference_map.get(id);
	}

	@Override
	public InferenceSupportByClaim getInferenceSupportByClaim(
			Inference inference, Claim claim) {
		// TODO Auto-generated method stub
		String id = this.getID_Relation(claim, inference);
		return this.inferencesupportbyclaim_map.get(id);
	}
	
	@Override
	public ContextOf getContextOf(Context context, Assertion assertion) {
		// TODO Auto-generated method stub
		String id = null;
		if(assertion instanceof Claim)
			id = this.getID_Relation(context, (Claim)assertion);
		else if(assertion instanceof Inference)
			id = this.getID_Relation(context, (Inference)assertion);
		if(id==null)return null;
		return this.contextof_map.get(id);
	}

	@Override
	public JustifiedBy getJustifiedBy(Justification justification,
			Assertion assertion) {
		// TODO Auto-generated method stub
		String id = null;
		if(assertion instanceof Claim)
			id = this.getID_Relation(justification, (Claim)assertion);
		else if(assertion instanceof Inference)
			id = this.getID_Relation(justification, (Inference)assertion);
		if(id==null)return null;
		return this.justifiedby_map.get(id);
	}

	@Override
	public AssumedBy getAssumedBy(Assumption assumption, Assertion assertion) {
		// TODO Auto-generated method stub
		String id = null;
		if(assertion instanceof Claim)
			id = this.getID_Relation(assumption, (Claim)assertion);
		else if(assertion instanceof Inference)
			id = this.getID_Relation(assumption, (Inference)assertion);
		if(id==null)return null;
		return this.assumedby_map.get(id);
	}

	@Override
	public void removeSNode(SNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSRelation(SRelation relation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSInformationElement(SInformationElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAssertion(Assertion assertion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeClaim(Claim claim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeImplClaim(ImplClaim claim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUndevClaim(UndevClaim claim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeInference(Inference inference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContext(Context context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeJustification(Justification justification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAssumption(Assumption assumption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSupportByClaim(SupportByClaim link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSupportByInference(SupportByInference link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSupportByEvidence(SupportByEvidence link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeInferenceSupportByClaim(InferenceSupportByClaim link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContextOf(ContextOf link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAssumedBy(AssumedBy link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeJustifiedBy(JustifiedBy link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEvidenceRef(EvidenceRef ref) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSNode(SNode node, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSRelation(SRelation relation, SNode source, SNode target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSInformationElement(SInformationElement element,
			String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAssertion(Assertion assertion, String stmt, boolean valid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClaim(boolean result, boolean assumed_result) {
		// TODO Auto-generated method stub
		
	}
	
}
