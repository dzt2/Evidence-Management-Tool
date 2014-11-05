package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.FlexibleOperatorTreeNode;

public class DisjunctionTreeNode extends FlexibleOperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisjunctionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_DISJUNCTION_ICON);
	}
	
	protected void op_init(){
		JMenu op_item = (JMenu) this.menu.getComponent(0);
		
		op_item.add(new JMenuItem("LogicVariable"));
		op_item.add(new JMenuItem("LogicExpression"));
		op_item.add(new JMenuItem("LogicFunction"));
		
	}
}
