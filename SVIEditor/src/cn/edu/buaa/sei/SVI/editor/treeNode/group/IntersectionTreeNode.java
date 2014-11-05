package cn.edu.buaa.sei.SVI.editor.treeNode.group;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.BinaryOperatorTreeNode;

public class IntersectionTreeNode extends BinaryOperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntersectionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_INTERSECTION_ICON);
		this.op_init();
	}
	protected void op_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("GroupVariable"));
		item0.add(new JMenuItem("GroupExpression"));
		item0.add(new JMenuItem("GroupFunction"));
		item0.add(new JMenuItem("Filter"));
		item0.add(new JMenuItem("Mapper"));
		item0.add(new JMenuItem("TableMapper"));
	}
}
