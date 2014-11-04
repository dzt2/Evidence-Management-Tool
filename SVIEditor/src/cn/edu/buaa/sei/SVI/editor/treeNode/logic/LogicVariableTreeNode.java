package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.VariableTreeNode;

public class LogicVariableTreeNode extends VariableTreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogicVariableTreeNode(String name) {
		super(name,IconSet.LOGIC_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
}
