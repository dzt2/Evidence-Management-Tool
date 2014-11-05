package cn.edu.buaa.sei.SVI.editor.action.core;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import cn.edu.buaa.sei.SVI.editor.action.SVIEditorAction;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class SVIEditorRemoveAction implements SVIEditorAction{

	@Override
	public void run(SVITreeNode node) throws Exception {
		if(node==null)throw new Exception("Null node is invalid");
		JTree tree = node.getTree();
		final DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		model.removeNodeFromParent(node);
	}

}
