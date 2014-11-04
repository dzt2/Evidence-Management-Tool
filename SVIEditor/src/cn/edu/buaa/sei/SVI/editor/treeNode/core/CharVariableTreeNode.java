package cn.edu.buaa.sei.SVI.editor.treeNode.core;
import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;

public class CharVariableTreeNode extends VariableTreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CharVariableTreeNode(String name) {
		super(name,IconSet.CHAR_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
	

}
