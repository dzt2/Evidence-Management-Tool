package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;


public class IntVariableTreeNode extends VariableTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IntVariableTreeNode(String name) {
		super(name,IconSet.INT_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
	

}