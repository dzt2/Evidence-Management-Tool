package cn.edu.buaa.sei.SVI.editor.action.core;

import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.action.SVIEditorAction;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public abstract class SVIEditorCreateAction extends SVIEditorAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SVIEditorCreateAction(SVITreeNode node) {
		super(node);
	}
	@Override
	public void act() throws Exception {
		if(node==null)throw new Exception("Null node is invalid");
		
		SVITreeNode newOne = create(node.getTree());
		node.add(newOne);
	}
	protected abstract SVITreeNode create(JTree tree);

}
