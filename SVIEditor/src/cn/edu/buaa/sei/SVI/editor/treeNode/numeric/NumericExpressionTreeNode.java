package cn.edu.buaa.sei.SVI.editor.treeNode.numeric;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.ExpressionTreeNode;

public class NumericExpressionTreeNode extends ExpressionTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumericExpressionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.NUM_EXPR_ICON);
		this.num_init();
	}
	
	protected void num_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("Add"));
		item0.add(new JMenuItem("Sub"));
		item0.add(new JMenuItem("Mul"));
		item0.add(new JMenuItem("Div"));
		item0.add(new JMenuItem("Mod"));
		item0.add(new JMenuItem("Cardinality"));
	}
}
