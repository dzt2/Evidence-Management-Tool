package cn.edu.buaa.sei.SVI.editor.action.expr;

import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.action.core.SVIEditorCreateAction;
import cn.edu.buaa.sei.SVI.editor.treeNode.DefaultNodeNames;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.group.GroupExpressionTreeNode;

public class CreateGroupExpression extends SVIEditorCreateAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateGroupExpression(SVITreeNode node) {
		super(node);
	}

	@Override
	protected SVITreeNode create(JTree tree) {
		return new GroupExpressionTreeNode(tree,DefaultNodeNames.GROUP_EXPR);
	}
}
