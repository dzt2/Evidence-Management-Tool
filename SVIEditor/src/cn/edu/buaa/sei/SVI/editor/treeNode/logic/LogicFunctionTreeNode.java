package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.ImageIcon;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.core.FunctionTreeNode;

public class LogicFunctionTreeNode extends FunctionTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogicFunctionTreeNode(JTree tree, String name, ImageIcon icon) {
		super(tree, name, icon);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
