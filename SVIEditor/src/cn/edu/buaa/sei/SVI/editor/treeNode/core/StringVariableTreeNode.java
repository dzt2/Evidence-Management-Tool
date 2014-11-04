package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;


public class StringVariableTreeNode extends VariableTreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StringVariableTreeNode(String name) {
		super(name,IconSet.STRING_VAR_ICON);
	}

	@Override
	public boolean validate() {
		return true;
	}
	@Override
	public int requiredChildrenCount() {return 0;}
	

}
