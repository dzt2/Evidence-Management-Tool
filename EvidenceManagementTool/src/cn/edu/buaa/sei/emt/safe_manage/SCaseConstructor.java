package cn.edu.buaa.sei.emt.safe_manage;

import cn.edu.buaa.sei.emt.safe.AssumedBy;
import cn.edu.buaa.sei.emt.safe.Assumption;
import cn.edu.buaa.sei.emt.safe.Claim;
import cn.edu.buaa.sei.emt.safe.ClaimState;
import cn.edu.buaa.sei.emt.safe.Context;
import cn.edu.buaa.sei.emt.safe.ContextOf;
import cn.edu.buaa.sei.emt.safe.EvidenceRef;
import cn.edu.buaa.sei.emt.safe.EvidenceRefState;
import cn.edu.buaa.sei.emt.safe.ImplClaim;
import cn.edu.buaa.sei.emt.safe.Inference;
import cn.edu.buaa.sei.emt.safe.Justification;
import cn.edu.buaa.sei.emt.safe.JustifiedBy;
import cn.edu.buaa.sei.emt.safe.SafeFactory;
import cn.edu.buaa.sei.emt.safe.SafetyCase;
import cn.edu.buaa.sei.emt.safe.SupportByClaim;
import cn.edu.buaa.sei.emt.safe.SupportByEvidence;
import cn.edu.buaa.sei.emt.safe.SupportByInference;
import cn.edu.buaa.sei.emt.safe.UndevClaim;

public class SCaseConstructor {
	/*Create Safety Case and its attributes*/
	
	public static SafetyCase createSafetyCase(String name){
		SafetyCase sc = SafeFactory.createSafetyCase();
		// SModule Attribute
		sc.setName(name);
		return sc;
	}
	
	public static ImplClaim createImplClaim(String name,String stmt,boolean assumed){
		ImplClaim claim = SafeFactory.createImplClaim();
		// SNode
		claim.setName(name);
		// Assertion
		claim.setStatement(stmt);claim.setValid(false);
		// Claim
		claim.setAssumed_result(assumed);
		claim.setState(ClaimState.ENUM_UNSUPPORTED);
		claim.setResult(false);
		return claim;
	}
	
	public static UndevClaim createUndeveClaim(String name,String stmt,boolean assumed){
		UndevClaim claim = SafeFactory.createUndevClaim();
		// SNode
		claim.setName(name);
		// Assertion
		claim.setStatement(name);claim.setValid(false);
		// Claim
		claim.setResult(false);
		claim.setAssumed_result(assumed);
		claim.setState(ClaimState.ENUM_UNSUPPORTED);
		return claim;
	}
	
	public static EvidenceRef createEvidenceRefer(String name,String description){
		EvidenceRef e = SafeFactory.createEvidenceRef();
		//SNode
		e.setName(name);
		// SInformationElement
		e.setDescription(description);
		// EvidenceRef
		e.setState(EvidenceRefState.ENUM_INITIAL);
		
		return e;
	}
	
	public static Inference createInference(String name,String stmt,boolean assumed){
		Inference i = SafeFactory.createInference();
		// SNode
		i.setName(name);
		// Assertion
		i.setStatement(stmt);i.setValid(true);
		
		return i;
	}
	
	public static Context createContext(String name,String description){
		Context c = SafeFactory.createContext();
		//SNode
		c.setName(name);
		// SInformationElement
		c.setDescription(description);
		
		return c;
	}
	
	public static Assumption createAssumption(String name,String stmt){
		Assumption a = SafeFactory.createAssumption();
		// SNode
		a.setName(name);
		// Assertion
		a.setStatement(stmt);a.setValid(true);
		return a;
	}
	
	public static Justification createJustification(String name,String stmt){
		Justification j = SafeFactory.createJustification();
		// SNode
		j.setName(name);
		// Assertion
		j.setStatement(stmt);j.setValid(true);
		return j;
	}
	
	/*	Relation  */
	public static SupportByClaim ClaimLinkClaim(ImplClaim conclusion,Claim premise){
		if(conclusion.getSub_claims().contains(premise)||premise.getSupport_claims().contains(conclusion))
			return null;
		/*	Modify the Node  */
		conclusion.getSub_claims().add(premise);
		premise.getSupport_claims().add(conclusion);
		
		/* Constructing Relations */
		SupportByClaim cc = SafeFactory.createSupportByClaim();
		// SRelation
		cc.setSource(premise);cc.setTarget(conclusion);
		// SupportByClaim
		cc.setPremise(premise);cc.setConclusion(conclusion);
		
		return cc;
	}
	
	public static SupportByEvidence ClaimLinkEvidence(ImplClaim objective, EvidenceRef evidence){
		if(objective.getEvidences().contains(evidence)||evidence.getSupport_claims().contains(objective))
			return null;
		/*	Modify the Nodes  */
		objective.getEvidences().add(evidence);
		evidence.getSupport_claims().add(objective);
		
		/*	Constructing Relations  */
		SupportByEvidence ce = SafeFactory.createSupportByEvidence();
		// SRelation
		ce.setSource(evidence);ce.setTarget(objective);
		// SupportByEvidence
		ce.setEvidence(evidence);ce.setObjective(objective);
		return ce;
	}
	
	public static SupportByInference ClaimLinkInference(ImplClaim conclusion, Inference inference){
		if(conclusion.getInferences().contains(inference)||inference.getConclusion()!=null)return null;
		/*	Node	*/
		conclusion.getInferences().add(inference);inference.setConclusion(conclusion);
		
		/*	Relations	*/
		SupportByInference ci = SafeFactory.createSupportByInference();
		// SRelation
		ci.setSource(inference);ci.setTarget(conclusion);
		// SupportByInference
		ci.setInference(inference);ci.setConclusion(conclusion);
		return ci;
	}

	public static ContextOf ContextLinkClaim(Context context,Claim claim){
		if(context.getAssertions().contains(claim)||claim.getContexts().contains(context))return null;
		// Node
		context.getAssertions().add(claim); claim.getContexts().add(context);
		
		/*Constructing Relations*/
		ContextOf ca = SafeFactory.createContextOf();
		// SRelation
		ca.setSource(context);ca.setTarget(claim);
		// ContextOf
		ca.setContext(context);ca.setAssertion(claim);
		return ca;
	}

	public static ContextOf ContextLinkInference(Context context,Inference inference){
		if(context.getAssertions().contains(inference)||inference.getContexts().contains(context))return null;
		// Node
		context.getAssertions().add(inference); inference.getContexts().add(context);
		
		// Relation Construction
		ContextOf ci = SafeFactory.createContextOf();
		// Relation
		ci.setSource(context);ci.setTarget(inference);
		// ContextOf
		ci.setContext(context);ci.setAssertion(inference);
		return ci;
	}

	public static JustifiedBy JustLinkClaim(Justification justification, Claim claim){
		if(justification.getAssertions().contains(claim)||claim.getJustifications().contains(justification))
			return null;
		// Node
		justification.getAssertions().add(claim); claim.getJustifications().add(justification);
		
		// Relation Construction
		JustifiedBy jc = SafeFactory.createJustifiedBy();
		// SRelation
		jc.setSource(justification);jc.setTarget(claim);
		// JustifiedBy
		jc.setJustification(justification);jc.setAssertion(claim);
		return jc;
	}

	public static JustifiedBy JustLinkInference(Justification justification, Inference inference){
		if(justification.getAssertions().contains(inference)||inference.getJustifications().contains(justification))
			return null;
		// Node
		justification.getAssertions().add(inference); inference.getJustifications().add(justification);
		
		// Relation Construction
		JustifiedBy ji = SafeFactory.createJustifiedBy();
		// SRelation
		ji.setSource(justification);ji.setTarget(inference);
		// JustifiedBy
		ji.setJustification(justification);ji.setAssertion(inference);
		
		return ji;
	}

	public static AssumedBy AssumLinkClaim(Assumption assumption,Claim claim){
		if(assumption.getAssertions().contains(claim)||claim.getAssumptions().contains(assumption))
			return null;
		//Node
		assumption.getAssertions().add(claim); claim.getAssumptions().add(assumption);
		
		// Constructing Relation
		AssumedBy ac = SafeFactory.createAssumedBy();
		// SRelation
		ac.setSource(assumption);ac.setTarget(claim);
		// AssumedBy
		ac.setAssumption(assumption);ac.setAssertion(claim);
		
		return ac;
	}

	public static AssumedBy AssumLinkInference(Assumption assumption, Inference inference){
		if(assumption.getAssertions().contains(inference)||inference.getAssumptions().contains(assumption))
			return null;
		//Node
		assumption.getAssertions().add(inference); inference.getAssumptions().add(assumption);
		
		// Constructing Relation
		AssumedBy ac = SafeFactory.createAssumedBy();
		// SRelation
		ac.setSource(assumption);ac.setTarget(inference);
		// AssumedBy
		ac.setAssumption(assumption);ac.setAssertion(inference);
		
		return ac;
	}

}
