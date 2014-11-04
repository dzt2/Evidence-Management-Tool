package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;

public class LongVariableTreeNode extends VariableTreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LongVariableTreeNode(JTree tree,String name) {
		super(tree,name,IconSet.LONG_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
	

}
