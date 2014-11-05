package cn.edu.buaa.sei.SVI.editor.action.variable;

import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.action.core.SVIEditorCreateAction;
import cn.edu.buaa.sei.SVI.editor.treeNode.DefaultNodeNames;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.RationalVariableTreeNode;

public class CreateRationalVariable extends SVIEditorCreateAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateRationalVariable(SVITreeNode node) {
		super(node);
	}

	@Override
	protected SVITreeNode create(JTree tree) {
		return new RationalVariableTreeNode(tree,DefaultNodeNames.RATIONAL_VAR);
	}
}
