package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import javax.swing.ImageIcon;
import javax.swing.JTree;

public abstract class UnaryOperatorTreeNode extends OperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnaryOperatorTreeNode(JTree tree, String name, ImageIcon icon) {
		super(tree, name, icon);
	}
	protected void init(){
		
	}

	@Override
	public int requiredChildrenCount() {return 1;}
	
}
