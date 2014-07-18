package cn.edu.buaa.sei.emt.safe_manage;

import java.util.List;

import cn.edu.buaa.sei.emt.safe.Assertion;
import cn.edu.buaa.sei.emt.safe.AssumedBy;
import cn.edu.buaa.sei.emt.safe.Assumption;
import cn.edu.buaa.sei.emt.safe.Claim;
import cn.edu.buaa.sei.emt.safe.ClaimState;
import cn.edu.buaa.sei.emt.safe.Context;
import cn.edu.buaa.sei.emt.safe.ContextOf;
import cn.edu.buaa.sei.emt.safe.Evidence;
import cn.edu.buaa.sei.emt.safe.EvidenceFile;
import cn.edu.buaa.sei.emt.safe.EvidenceRef;
import cn.edu.buaa.sei.emt.safe.ImplClaim;
import cn.edu.buaa.sei.emt.safe.Inference;
import cn.edu.buaa.sei.emt.safe.InferenceSupportByClaim;
import cn.edu.buaa.sei.emt.safe.Justification;
import cn.edu.buaa.sei.emt.safe.JustifiedBy;
import cn.edu.buaa.sei.emt.safe.SElement;
import cn.edu.buaa.sei.emt.safe.SEvidenceElement;
import cn.edu.buaa.sei.emt.safe.SInformationElement;
import cn.edu.buaa.sei.emt.safe.SModule;
import cn.edu.buaa.sei.emt.safe.SNode;
import cn.edu.buaa.sei.emt.safe.SafetyCase;
import cn.edu.buaa.sei.emt.safe.SupportByClaim;
import cn.edu.buaa.sei.emt.safe.SupportByEvidence;
import cn.edu.buaa.sei.emt.safe.SupportByInference;
import cn.edu.buaa.sei.emt.safe.UndevClaim;

public class SCaseModifier {
	/*Update + Remove*/
	
	private static void updateImplClaimState(ImplClaim claim){
		if(claim.getSub_claims().size()==0&&claim.getEvidences().size()==0&&claim.getInferences().size()==0)
			claim.setState(ClaimState.ENUM_UNSUPPORTED);
		else
			claim.setState(ClaimState.ENUM_SUPPORTED);
	}
	private static void updateUndevClaimState(UndevClaim claim){
		if(claim.getRefcase()==null)
			claim.setState(ClaimState.ENUM_UNSUPPORTED);
		else claim.setState(ClaimState.ENUM_SUPPORTED);
	}
	private static void updateClaimState(Claim claim){
		if(claim==null)return;
		if(claim instanceof ImplClaim)updateImplClaimState((ImplClaim) claim);
		else if(claim instanceof UndevClaim) updateUndevClaimState((UndevClaim) claim);
	}
	

	
	/*	Removing the links	*/
	public static void removeSupportByClaim(SupportByClaim link){
		if(link==null)return;
		Claim premise = link.getPremise();
		ImplClaim conclusion = link.getConclusion();
		
		if(premise!=null)
			premise.getSupport_claims().remove(conclusion);
		if(conclusion!=null){
			conclusion.getSub_claims().remove(premise);
			updateClaimState(conclusion);
		}
	}
	
	public static void removeSupportByEvidence(SupportByEvidence link){
		if(link==null)return;
		EvidenceRef ref = link.getEvidence();
		ImplClaim claim = link.getObjective();
		
		if(ref!=null){
			ref.getSupport_claims().remove(claim);
		}
		if(claim!=null){
			claim.getEvidences().remove(ref);
			updateClaimState(claim);
		}
	}

	public static void removeSupportByInference(SupportByInference link){
		if(link==null)return;
		Inference inference = link.getInference();
		ImplClaim claim = link.getConclusion();
		
		if(claim!=null){
			claim.getInferences().remove(inference);
			updateClaimState(claim);
		}
		if(inference!=null)
			inference.setConclusion(null);
	}
	
	public static void removeInferenceSupportByClaim(InferenceSupportByClaim link){
		if(link==null)return;
		Inference inference = link.getInference();
		Claim claim = link.getClaim();
		
		if(inference!=null){
			inference.getPremises().remove(claim);
		}
		if(claim!=null){
			claim.getSupport_inferences().remove(inference);
			updateClaimState(claim);
		}
	}
	
	public static void removeContextOf(ContextOf link){
		if(link==null)return;
		Context context = link.getContext();
		Assertion assertion = link.getAssertion();
		
		if(assertion!=null)
			assertion.getContexts().remove(context);
		if(context!=null)
			context.getAssertions().remove(assertion);
	}
	
	public static void removeJustifiedBy(JustifiedBy link){
		if(link==null)return;
		Justification justification = link.getJustification();
		Assertion assertion = link.getAssertion();
		
		if(assertion!=null)
			assertion.getJustifications().remove(justification);
		if(justification!=null)
			justification.getAssertions().remove(assertion);
	}

	public static void removeAssumedBy(AssumedBy link){
		if(link==null)return;
		Assertion assertion = link.getAssertion();
		Assumption assumption = link.getAssumption();
		
		if(assumption!=null)
			assumption.getAssertions().remove(assertion);
		if(assertion!=null)
			assertion.getAssumptions().remove(assumption);
	}
	
	public static void unlinkEvidenceRef(EvidenceRef ref){
		if(ref==null||ref.getEvidence()==null)return;
		Evidence evidence = ref.getEvidence();
		if(evidence!=null)evidence.getSupport_refs().remove(ref);
		ref.setEvidence(null);
	}
	
	public static void unlinkUndevClaim(UndevClaim claim){
		if(claim==null||claim.getRefcase()==null)return;
		SafetyCase scase = claim.getRefcase();
		if(scase!=null)
			scase.getSupport_undev_claims().remove(claim);
		claim.setRefcase(null);
		updateClaimState(claim);
	}

	/*	Remove the Node  */
	public static void removeSElement(SElement element){
		if(element==null)return;
	}
	public static void removeSNode(SNode node){
		removeSElement(node);
		if(node==null)return;
	}
	public static void removeSInformationElement(SInformationElement element){
		removeSElement(element);
		if(element==null)return;
	}
	public static void removeAssertion(Assertion assertion){
		removeSElement(assertion);
		if(assertion==null)return;
		
		List<Context> contexts = assertion.getContexts();
		for(Context context:contexts)
			context.getAssertions().remove(assertion);
		assertion.getContexts().clear();
		
		
		List<Assumption> assumptions = assertion.getAssumptions();
		for(Assumption assumption:assumptions)
			assumption.getAssertions().remove(assertion);
		assertion.getAssumptions().clear();
		
		List<Justification> justifications = assertion.getJustifications();
		for(Justification justification:justifications)
			justification.getAssertions().remove(assertion);
		assertion.getJustifications().clear();
	}

	public static void removeClaim(Claim claim){
		removeSNode(claim);
		removeAssertion(claim);
		if(claim==null)return;
		
		List<ImplClaim> support_claims = claim.getSupport_claims();
		for(ImplClaim implclaim:support_claims)
			implclaim.getSub_claims().remove(claim);
		claim.getSupport_claims().clear();
		
		List<Inference> support_inferences = claim.getSupport_inferences();
		for(Inference inference:support_inferences)
			inference.getPremises().remove(claim);
		claim.getSupport_inferences().clear();
		
	}
	
	public static void removeImplClaim(ImplClaim claim){
		if(claim==null)return;
		removeClaim(claim);
		
		List<Inference> inferences = claim.getInferences();
		for(Inference inference:inferences)
			inference.setConclusion(null);
		claim.getInferences().clear();
		
		List<Claim> sub_claims = claim.getSub_claims();
		for(Claim subclaim:sub_claims)
			subclaim.getSupport_claims().remove(claim);
		claim.getSub_claims().clear();
		
		List<EvidenceRef> evidences = claim.getEvidences();
		for(EvidenceRef ref:evidences)
			ref.getSupport_claims().remove(claim);
		claim.getEvidences().clear();
	}

	public static void removeUndevClaim(UndevClaim claim){
		if(claim==null)return;
		removeClaim(claim);
		
		SafetyCase scase = claim.getRefcase();
		if(scase!=null)scase.getSupport_undev_claims().remove(claim);
		claim.setRefcase(null);
	}

	public static void removeInference(Inference inference){
		removeSNode(inference);
		removeAssertion(inference);
		
		if(inference==null)return;
		
		ImplClaim conclusion = inference.getConclusion();
		if(conclusion!=null)conclusion.getInferences().remove(inference);
		inference.setConclusion(null);
		
		List<Claim> premises = inference.getPremises();
		for(Claim claim:premises)
			claim.getSupport_inferences().remove(inference);
		inference.getPremises().clear();
	}
	
	public static void removeEvidenceRef(EvidenceRef ref){
		removeSNode(ref);
		removeSInformationElement(ref);
		
		if(ref==null)return;
		
		List<ImplClaim> claims = ref.getSupport_claims();
		for(ImplClaim claim:claims)
			claim.getEvidences().remove(ref);
		ref.getSupport_claims().clear();
		
		Evidence evidence = ref.getEvidence();
		evidence.getSupport_refs().remove(ref);
		ref.setEvidence(null);
	}
	
	public static void removeContext(Context context){
		if(context==null)return;
		removeSNode(context);
		removeSInformationElement(context);
		
		List<Assertion> assertions = context.getAssertions();
		for(Assertion assertion:assertions)
			assertion.getContexts().remove(context);
		context.getAssertions().clear();
	}
	
	public static void removeJustification(Justification justification){
		if(justification==null)return;
		removeSNode(justification);
		removeAssertion(justification);
		
		List<Assertion> assertions = justification.getAssertions();
		for(Assertion assertion:assertions)
			assertion.getJustifications().remove(justification);
		justification.getAssertions().clear();
	}

	public static void removeAssumption(Assumption assumption){
		if(assumption==null)return;
		removeSNode(assumption);
		removeAssertion(assumption);
		
		List<Assertion> assertions = assumption.getAssertions();
		for(Assertion assertion:assertions)
			assertion.getAssumptions().remove(assumption);
		assumption.getAssertions().clear();
	}
	
	
	/* Modify Attributes in Node */
	public static void setSElement(SElement element, String id, String gid){
		if(element==null)return;
		if(id!=null)
			element.setId(id);
		if(gid!=null)
			element.setGid(gid);
	}
	
	public static void setSNode(SNode node,String name){
		if(node!=null&&name!=null)
			node.setName(name);
	}
	
	public static void setAssertion(Assertion assertion,String stmt,boolean valid){
		if(assertion==null)return;
		if(stmt!=null)assertion.setStatement(stmt);
		assertion.setValid(valid);
	}
	
	public static void setClaim(Claim claim,boolean result,boolean assumed_result){
		if(claim==null)return;
		claim.setResult(result);claim.setAssumed_result(assumed_result);
	}

	public static void setSInformationElement(SInformationElement element,String name,String description){
		if(element==null)return;
		if(name!=null)element.setName(name);
		if(description!=null)element.setDescription(description);
	}
	
	public static void setSEvidenceElement(SEvidenceElement element,String name){
		if(element==null)return;
		if(name!=null)element.setName(name);
	}
	
	public static void setEvidenceFile(EvidenceFile evidence,String url){
		if(evidence==null)return;
		evidence.setFile_url(url);
	}
	
	public static void setSModule(SModule module,String name){
		if(module==null)return;
		module.setName(name);
	}
	
	/*	Modify the Links  */
	public static void updateSupportByClaim(SupportByClaim link, ImplClaim conclusion, Claim premise){
		if(link==null||conclusion==null||premise==null)return;
		if(conclusion.getSub_claims().contains(premise)||premise.getSupport_claims().contains(conclusion))
			return;
		
		removeSupportByClaim(link);
		
		/*reconstruct the relation*/
		premise.getSupport_claims().add(conclusion);
		conclusion.getSub_claims().add(premise);
		
		link.setSource(premise);link.setTarget(conclusion);
		link.setConclusion(conclusion);link.setPremise(premise);
		
	}

	public static void updateSupportByEvidence(SupportByEvidence link,ImplClaim claim, EvidenceRef evidence){
		if(link==null||claim==null||evidence==null)return;
		if(claim.getEvidences().contains(evidence)||evidence.getSupport_claims().contains(claim))return;
		
		removeSupportByEvidence(link);
		
		/*reconstruct the relation*/
		claim.getEvidences().add(evidence);
		evidence.getSupport_claims().add(claim);
		
		link.setSource(evidence);link.setTarget(claim);
		link.setEvidence(evidence);link.setObjective(claim);
	}

	public static void updateSupportByInference(SupportByInference link,ImplClaim claim, Inference inference){
		if(link==null||claim==null||inference==null)return;
		if(claim.getInferences().contains(inference)||inference.getConclusion()==claim)return;
		
		removeSupportByInference(link);
		
		claim.getInferences().add(inference);
		inference.setConclusion(claim);
		
		link.setSource(inference);link.setTarget(claim);
		link.setInference(inference);link.setConclusion(claim);
		
	}
	
	public static void updateInferenceSupportByClaim(InferenceSupportByClaim link,Inference inference,Claim claim){
		if(link==null||inference==null||claim==null)return;
		if(inference.getPremises().contains(claim)||claim.getSupport_inferences().contains(inference))return;
		
		removeInferenceSupportByClaim(link);
		
		claim.getSupport_inferences().add(inference);
		inference.getPremises().add(claim);
		
		link.setSource(claim);link.setTarget(inference);
		link.setInference(inference);link.setClaim(claim);
	}
	
	public static void updateContextOfClaim(ContextOf link,Context context,Claim claim){
		if(link==null||context==null||claim==null)return;
		if(context.getAssertions().contains(claim)||claim.getContexts().contains(context))return;
		
		removeContextOf(link);
		
		context.getAssertions().add(claim);
		claim.getContexts().add(context);
		
		link.setSource(context);link.setTarget(claim);
		link.setContext(context);link.setAssertion(claim);
	}
	
	public static void updateContextOfInference(ContextOf link, Context context, Inference inference){
		if(link==null||context==null||inference==null)return;
		if(context.getAssertions().contains(inference)||inference.getContexts().contains(context))return;
		
		removeContextOf(link);
		
		context.getAssertions().add(inference);
		inference.getContexts().add(context);
		
		link.setSource(context);link.setTarget(inference);
		link.setContext(context);link.setAssertion(inference);
	}
	
	public static void updateJustifiedByClaim(JustifiedBy link,Justification justification, Claim claim){
		if(link==null||justification==null||claim==null)return;
		if(justification.getAssertions().contains(claim)||claim.getJustifications().contains(justification))return;
		
		removeJustifiedBy(link);
		
		justification.getAssertions().add(claim);
		claim.getJustifications().add(justification);
		
		link.setSource(justification);link.setTarget(claim);
		link.setJustification(justification);link.setAssertion(claim);
	}
	
	public static void updateJustifiedByInference(JustifiedBy link,Justification justification, Inference inference){
		if(link==null||inference==null||justification==null)return;
		if(justification.getAssertions().contains(inference)||inference.getJustifications().contains(justification))return;
		
		removeJustifiedBy(link);
		
		justification.getAssertions().add(inference);
		inference.getJustifications().add(justification);
		
		link.setSource(justification);link.setTarget(inference);
		link.setJustification(justification);link.setAssertion(inference);
	}
	
	public static void updateAssumedByClaim(AssumedBy link,Assumption assumption,Claim claim){
		if(link==null||assumption==null||claim==null)return;
		if(assumption.getAssertions().contains(claim)||claim.getAssumptions().contains(assumption))return;
		
		removeAssumedBy(link);
		
		assumption.getAssertions().add(claim);
		claim.getAssumptions().add(assumption);
		
		link.setSource(assumption);link.setTarget(claim);
		link.setAssumption(assumption);link.setAssertion(claim);
	}
	
	public static void updateAssumedByInference(AssumedBy link,Assumption assumption,Inference inference){
		if(link==null||assumption==null||inference==null)return;
		if(assumption.getAssertions().contains(inference)||inference.getAssumptions().contains(assumption))return;
		
		removeAssumedBy(link);
		
		assumption.getAssertions().add(inference);
		inference.getAssumptions().add(assumption);
		
		link.setSource(assumption);link.setTarget(inference);
		link.setAssumption(assumption);link.setAssertion(inference);
		
	}

	public static void relinkEvidenceRef(EvidenceRef ref,Evidence evidence){
		if(ref==null||evidence==null)return;
		if(ref.getEvidence()==evidence||evidence.getSupport_refs().contains(ref))return;
		
		unlinkEvidenceRef(ref);
		
		ref.setEvidence(evidence);evidence.getSupport_refs().add(ref);
	}
	
	public static void relinkUndevClaim(UndevClaim claim,SafetyCase scase){
		if(claim==null||scase==null||scase.getSupport_undev_claims().contains(claim)||claim.getRefcase()==scase)return;
		
		unlinkUndevClaim(claim);
		
		claim.setRefcase(scase);scase.getSupport_undev_claims().add(claim);
	}
	
}
