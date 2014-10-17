package cn.edu.buaa.sei.SVI.struct.group;

/**
 * <i>Group</i> is a value to present a group of elements {for any types}<br>
 * 1. EnumerateGroup: Group that contains numbers of elements stored in it and could be listed
 * out, as called "Enumerated".<br>
 * 2. ConditionGroup: Group that contains elements which satisfy a specified Logic Function, like
 * "{x|P(x)}". ConditionGroup could be very likely a Unbounded-Group with infinite elements in it.
 * */
public interface Group {
	/**
	 * The number to present number of elements in infinite group
	 * */
	public static final int INFINITE = -1;
	/**
	 * Return the cardinality of the set
	 * */
	public int size();
	/**
	 * Checking whether a given val is in the set.
	 * */
	public boolean contains(Object val);
}
