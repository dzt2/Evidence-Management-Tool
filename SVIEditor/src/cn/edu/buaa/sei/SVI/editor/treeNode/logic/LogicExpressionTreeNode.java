package cn.edu.buaa.sei.SVI.editor.treeNode.logic;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.ExpressionTreeNode;

public class LogicExpressionTreeNode extends ExpressionTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogicExpressionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.LOGIC_EXPR_ICON);
		this.logic_init();
	}

	protected void logic_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("Negation"));
		item0.add(new JMenuItem("Conjunction"));
		item0.add(new JMenuItem("Disjunction"));
		item0.add(new JMenuItem("Implication"));
		item0.add(new JMenuItem("Equivalence"));
		item0.add(new JMenuItem("Universal"));
		item0.add(new JMenuItem("Existential"));
		item0.add(new JMenuItem("AtLeast"));
		item0.add(new JMenuItem("AtMost"));
		item0.add(new JMenuItem("Between"));
		item0.add(new JMenuItem("Smaller"));
		item0.add(new JMenuItem("ESmaller"));
		item0.add(new JMenuItem("Equal"));
		item0.add(new JMenuItem("EBigger"));
		item0.add(new JMenuItem("Bigger"));
		item0.add(new JMenuItem("GroupEqual"));
		item0.add(new JMenuItem("Contain"));
		item0.add(new JMenuItem("Include"));
	}
	
}
