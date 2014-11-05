package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.BinaryOperatorTreeNode;

public class ImplicationTreeNode extends BinaryOperatorTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImplicationTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_IMPLICATION_ICON);
		this.op_init();
	}
	
	protected void op_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("LogicVariable"));
		item0.add(new JMenuItem("LogicExpression"));
		item0.add(new JMenuItem("LogicFunction"));
		
	}

}
