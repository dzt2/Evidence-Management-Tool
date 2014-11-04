package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;

public class LongVariableTreeNode extends VariableTreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LongVariableTreeNode(String name) {
		super(name,IconSet.LONG_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
	

}
