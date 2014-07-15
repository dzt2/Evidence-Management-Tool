package cn.edu.buaa.sei.emt.safe;

public class SafeFactory {
	
	
	
	public static Claim createClaim() {
		return new ClaimImpl();
	}
	
	public static UndevelopedClaim createUndevelopedClaim() {
		return new UndevelopedClaimImpl();
	}
	
	public static Assumption createAssumption() {
		return new AssumptionImpl();
	}
	
	public static Justification createJustification() {
		return new JustificationImpl();
	}
	
	public static Context createContext() {
		return new ContextImpl();
	}
	
	public static SupportByClaim createSupportByClaim() {
		return new SupportByClaimImpl();
	}
	
	public static ChallengeByClaim createChallengeByClaim() {
		return new ChallengeByClaimImpl();
	}
	
	public static SupportByEvidence createSupportByEvidence() {
		return new SupportByEvidenceImpl();
	}
	
	public static ChallengeByEvidence createChallengeByEvidence() {
		return new ChallengeByEvidenceImpl();
	}
	
	public static AssumedBy createAssumedBy() {
		return new AssumedByImpl();
	}
	
	public static ContextOf createContextOf() {
		return new ContextOfImpl();
	}
	
	public static JustifiedBy createJustifiedBy() {
		return new JustifiedByImpl();
	}
	
	public static SafetyCase createSafetyCase() {
		return new SafetyCaseImpl();
	}
	
	public static XMLEvidence createXMLEvidence() {
		return new XMLEvidenceImpl();
	}
	
}
