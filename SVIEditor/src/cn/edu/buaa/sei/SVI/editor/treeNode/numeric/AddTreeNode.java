package cn.edu.buaa.sei.SVI.editor.treeNode.numeric;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.BinaryOperatorTreeNode;

public class AddTreeNode extends BinaryOperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_ADD_ICON);
		this.op_init();
	}
	protected void op_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new JMenuItem("NaturalVariable"));
		item0.add(new JMenuItem("ZIntVariable"));
		item0.add(new JMenuItem("RationalVariable"));
		item0.add(new JMenuItem("RealVariable"));
		item0.add(new JMenuItem("NumericExpression"));
		item0.add(new JMenuItem("NumericFunction"));
	}
	
}
