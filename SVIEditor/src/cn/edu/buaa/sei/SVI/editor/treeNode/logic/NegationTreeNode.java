package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenu;
import javax.swing.JTree;
import cn.edu.buaa.sei.SVI.editor.action.expr.CreateLogicExpression;
import cn.edu.buaa.sei.SVI.editor.action.function.CreateLogicFunction;
import cn.edu.buaa.sei.SVI.editor.action.variable.CreateLogicVariable;
import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.UnaryOperatorTreeNode;

public class NegationTreeNode extends UnaryOperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegationTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_NEGATION_ICON);
		this.op_init();
	}

	protected void op_init(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		item0.add(new CreateLogicVariable(this));
		item0.add(new CreateLogicExpression(this));
		item0.add(new CreateLogicFunction(this));
	}
}
