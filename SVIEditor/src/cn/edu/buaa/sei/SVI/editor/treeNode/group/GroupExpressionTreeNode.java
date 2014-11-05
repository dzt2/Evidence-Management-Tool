package cn.edu.buaa.sei.SVI.editor.treeNode.group;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.ExpressionTreeNode;

public class GroupExpressionTreeNode extends ExpressionTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroupExpressionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.GROUP_EXPR_ICON);
		this.group_init();
	}
	
	protected void group_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("Intersection"));
		item0.add(new JMenuItem("Union"));
		item0.add(new JMenuItem("Difference"));
		item0.add(new JMenuItem("Complement"));
	}

}
