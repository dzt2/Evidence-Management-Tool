package cn.edu.buaa.sei.emt.safe_manage;

import java.util.Collection;

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

public interface SafetyCaseManager {
	/* add new nodes: 
	 * ImplClaim, UndevClaim
	 * EvidenceRef
	 * Inference
	 * Context, Justification, Assumption 
	 * */
	public void addNewImplClaim(String name,String stmt,boolean assumed);
	public void addNewUndevClaim(String name,String stmt,boolean assumed);
	public void addNewEvidenceRef(String name,String description);
	public void addNewInference(String name,String stmt);
	public void addNewContext(String name,String description);
	public void addNewJustification(String name,String stmt);
	public void addNewAssumption(String name,String stmt);
	
	/* add new links:
	 * SupportByClaim, SupportByEvidence, SupportByInference
	 * ContextOf, AssumedBy, JustifiedBy (Claim + Inference)
	 * InferenceSupportByClaim
	 * EvidenceRef --> Evidence
	 * UndevClaim --> SafetyCase
	 * */
	public void ClaimLinkClaim(Claim premise, ImplClaim conclusion);
	public void ClaimLinkInference(ImplClaim claim, Inference inference);
	public void ClaimLinkEvidenceRef(ImplClaim claim, EvidenceRef ref);
	public void ContextLinkClaim(Context context,Claim claim);
	public void ContextLinkInference(Context context,Inference inference);
	public void JustificationLinkClaim(Justification justification,Claim claim);
	public void JustificationLinkInference(Justification justification,Inference inference);
	public void AssumptionLinkClaim(Assumption assumption,Claim claim);
	public void AssumptionLinkInference(Assumption assumption, Inference inference);
	public void InferenceLinkClaim(Inference inference, Claim claim);
	public void EvidenceRefLinkEvidence(EvidenceRef ref,Evidence evidence);
	public void UndevClaimLinkSafetyCase(UndevClaim claim,SafetyCase scase);
	
	/* Search nodes & relations (sets):
	 * ---------------------------------------------------
	 * SNode, SInformationElement, SRelation, Assertion
	 * ---------------------------------------------------
	 * Claim, ImplClaim, UndevClaim
	 * Context, Justification, Assumption
	 * Inference
	 * EvidenceRef, Evidence
	 * Sub Safety Case
	 * --------------------------------------------------
	 * SupportByClaim, SupportByEvidence, SupportByInference
	 * InferenceSupportByClaim
	 * ContextOf, *ContextOfClaim, *ContextOfInference
	 * AssumedBy, *AssumedByClaim, *AssumedByInference
	 * JustifiedBy, *JustifiedByClaim, *JustifiedByInference
	 * */
	public Collection<SNode> getSNodes();
	public Collection<SInformationElement> getSInformationElements();
	public Collection<SRelation> getSRelations();
	public Collection<Assertion> getAssertions();
	
	public Collection<Claim> getClaims();
	public Collection<ImplClaim> getImplClaims();
	public Collection<UndevClaim> getUndevClaims();
	
	public Collection<Context> getContexts();
	public Collection<Justification> getJustifications();
	public Collection<Assumption> getAssumptions();
	
	public Collection<Inference> getInferences();
	
	public Collection<EvidenceRef> getEvidenceRefs();
	public Collection<Evidence> getEvidence();
	
	public Collection<SafetyCase> getSubSafetyCases();
	
	public Collection<SupportByClaim> getSupportByClaims();
	public Collection<SupportByInference> getSupportByInferences();
	public Collection<SupportByEvidence> getSupportByEvidences();
	
	public Collection<InferenceSupportByClaim> getInferenceSupportByClaims();
	
	public Collection<ContextOf> getContextOfs();
	public Collection<JustifiedBy> getJustifiedBys();
	public Collection<AssumedBy> getAssumedBys();
	
	/* Search the node by Name & Objects:
	 * -----------------------------------------
	 * SNode, SInformationElement, SRelation
	 * -----------------------------------------
	 * Claim, ImplClaim, UndevClaim : name
	 * Context, Justification, Assumption : name
	 * Inference : name
	 * EvidenceRef, *Evidence: name
	 * *SafetyCase: name
	 * -----------------------------------------
	 * SupportByClaim: <Claim,ImplClaim>
	 * SupportByInference: <Inference,ImplClaim>
	 * SupportByEvidence: <EvidenceRef,ImplClaim>
	 * InferenceSupportByClaim: <Claim, Inference>
	 * ContextOf: <Context,Assertion>
	 * AssumedBy: <Assumption, Assertion>
	 * JustifiedBy: <Justification, Assertion>
	 * -----------------------------------------
	 * */
	public SNode getSNode(String name);
	public SInformationElement getSInformationElement(String name);
	public SRelation getSRelation(SNode source,SNode target);
	
	public Claim getClaim(String name);
	public ImplClaim getImplClaim(String name);
	public UndevClaim getUndevClaim(String name);
	public Context getContext(String name);
	public Justification getJustification(String name);
	public Assumption getAssumption(String name);
	public Inference getInference(String name);
	public EvidenceRef getEvidenceRef(String name);
	
	public SupportByClaim getSupportByClaim(Claim premise, ImplClaim conclusion);
	public SupportByEvidence getSupportByEvidence(ImplClaim claim, EvidenceRef ref);
	public SupportByInference getSupportByInderence(ImplClaim claim,Inference inference);
	public InferenceSupportByClaim getInferenceSupportByClaim(Inference inference, Claim claim);
	
	public ContextOf getContextOf(Context context,Assertion assertion);
	public JustifiedBy getJustifiedBy(Justification justification, Assertion assertion);
	public AssumedBy getAssumedBy(Assumption assumption,Assertion assertion);
	
	/* Remove the Nodes & Relations
	 * -----------------------------------------
	 * SNode, SRelation, SInformationElement, Assertion
	 * -----------------------------------------
	 * Claim, ImplClaim, UndevClaim
	 * Inference
	 * EvidenceRef, Evidence
	 * Context, Justification, Assumption
	 * -----------------------------------------
	 * SupportByClaim, SupportByInference, SupportByEvidence
	 * InferenceSupportByClaim
	 * ContextOf, JustifiedBy, AssumedBy
	 * -----------------------------------------
	 * */
	public void removeSNode(SNode node);
	public void removeSRelation(SRelation relation);
	public void removeSInformationElement(SInformationElement element);
	public void removeAssertion(Assertion assertion);
	
	public void removeClaim(Claim claim);
	public void removeImplClaim(ImplClaim claim);
	public void removeUndevClaim(UndevClaim claim);
	public void removeInference(Inference inference);
	public void removeContext(Context context);
	public void removeJustification(Justification justification);
	public void removeAssumption(Assumption assumption);
	public void removeEvidenceRef(EvidenceRef ref);
	
	public void removeSupportByClaim(SupportByClaim link);
	public void removeSupportByInference(SupportByInference link);
	public void removeSupportByEvidence(SupportByEvidence link);
	public void removeInferenceSupportByClaim(InferenceSupportByClaim link);
	public void removeContextOf(ContextOf link);
	public void removeAssumedBy(AssumedBy link);
	public void removeJustifiedBy(JustifiedBy link);
	
	/* Modify attributes in Nodes & Relations
	 * -----------------------------------------
	 * SNode,SRelation,SInformationElement,Assertion
	 * -----------------------------------------
	 * Claim,ImplClaim,UndevClaim
	 * Inference
	 * EvidenceRef
	 * Context,Justification,Assumption
	 * SafetyCase: this
	 * -----------------------------------------
	 * SupportByClaim,SupportByEvidence,SupportByInference
	 * InferenceSupportByClaim
	 * ContextOf,JustifiedBy,AssumedBy
	 * EvidenceRef --> Evidence
	 * UndevClaim --> SafetyCase
	 * -----------------------------------------
	 * */
	public void setName(String name); //this.safetycase
	public void setSNode(SNode node,String name);
	public void setSRelation(SRelation relation,SNode source,SNode target);
	public void setSInformationElement(SInformationElement element,String name,String description);
	public void setAssertion(Assertion assertion,String stmt,boolean valid);
	
	public void setClaim(boolean result,boolean assumed_result);
	
	
	
}
