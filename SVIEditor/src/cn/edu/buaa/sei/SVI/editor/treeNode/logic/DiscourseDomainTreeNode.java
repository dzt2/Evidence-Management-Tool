package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.FreeVariableTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.VariableTreeNode;

public class DiscourseDomainTreeNode extends VariableTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DiscourseDomainTreeNode(String name) {
		super(name,IconSet.DISCOURSE_ICON);
		FreeVariableTreeNode node = new FreeVariableTreeNode(name+".iter");
		this.add(node);
	}

	@Override
	public boolean validate() {
		if(this.getChildCount()==1&&(this.getChildAt(0) instanceof FreeVariableTreeNode))
			return true;
		else return false;
	}
	@Override
	public int requiredChildrenCount() {return 0;}
}
