package cn.edu.buaa.sei.SVI.editor.action.variable;

import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.action.core.SVIEditorCreateAction;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.BooleanVariableTreeNode;

public class CreateBooleanVariable extends SVIEditorCreateAction{
	
	@Override
	protected SVITreeNode create(JTree tree) {
		// TODO Auto-generated method stub
		return new BooleanVariableTreeNode(tree,"bool_x");
	}

}
