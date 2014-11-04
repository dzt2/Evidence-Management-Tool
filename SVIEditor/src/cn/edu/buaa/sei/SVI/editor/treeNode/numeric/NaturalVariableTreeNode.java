package cn.edu.buaa.sei.SVI.editor.treeNode.numeric;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.VariableTreeNode;

public class NaturalVariableTreeNode extends VariableTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NaturalVariableTreeNode(String name) {
		super(name,IconSet.NATURAL_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
}
