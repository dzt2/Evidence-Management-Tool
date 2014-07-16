package cn.edu.buaa.sei.emt.safe;

public class SafeFactory {
	
	
	
	public static ImplClaim createImplClaim() {
		return new ImplClaimImpl();
	}
	
	public static UndevClaim createUndevClaim() {
		return new UndevClaimImpl();
	}
	
	public static Inference createInference() {
		return new InferenceImpl();
	}
	
	public static EvidenceRef createEvidenceRef() {
		return new EvidenceRefImpl();
	}
	
	public static Context createContext() {
		return new ContextImpl();
	}
	
	public static Assumption createAssumption() {
		return new AssumptionImpl();
	}
	
	public static Justification createJustification() {
		return new JustificationImpl();
	}
	
	public static SupportByInference createSupportByInference() {
		return new SupportByInferenceImpl();
	}
	
	public static SupportByEvidence createSupportByEvidence() {
		return new SupportByEvidenceImpl();
	}
	
	public static SupportByClaim createSupportByClaim() {
		return new SupportByClaimImpl();
	}
	
	public static ContextOf createContextOf() {
		return new ContextOfImpl();
	}
	
	public static JustifiedBy createJustifiedBy() {
		return new JustifiedByImpl();
	}
	
	public static AssumedBy createAssumedBy() {
		return new AssumedByImpl();
	}
	
	public static EvidenceGroup createEvidenceGroup() {
		return new EvidenceGroupImpl();
	}
	
	public static SModule createSModule() {
		return new SModuleImpl();
	}
	
	public static SafetyCase createSafetyCase() {
		return new SafetyCaseImpl();
	}
	
}
