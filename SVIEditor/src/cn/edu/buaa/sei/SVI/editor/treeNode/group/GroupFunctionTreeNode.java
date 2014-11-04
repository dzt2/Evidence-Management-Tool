package cn.edu.buaa.sei.SVI.editor.treeNode.group;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.FunctionTreeNode;

public class GroupFunctionTreeNode extends FunctionTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroupFunctionTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.GROUP_FUNC_ICON);
		this.regist();
	}
	protected void regist(){
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		JMenuItem item01 = new JMenuItem("GroupTemplate");
		
		item0.add(item01);
	}

	@Override
	public boolean validate() {
		return this.getChildCount()==1&&(this.getChildAt(0) instanceof GoupTemplateTreeNode);
	}

}
