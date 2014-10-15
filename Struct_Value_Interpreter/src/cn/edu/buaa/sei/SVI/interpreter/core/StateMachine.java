package cn.edu.buaa.sei.SVI.interpreter.core;

/**
 * StateMachine provides to translate the StructState {computing it in a black block}.
 * */
public interface StateMachine {
	
	public static final int SUCCESS = 0;
	public static final int UNREADY = 1;
	public static final int EXCEPTION = 2;
	
	/**
	 * Translate the state into the next.
	 * */
	public int next(StructState state);
	/**
	 * Roll back the state to the previous one.
	 * */
	public int prev(StructState state);
}
