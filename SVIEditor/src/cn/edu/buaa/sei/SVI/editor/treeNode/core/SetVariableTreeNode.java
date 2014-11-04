package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class SetVariableTreeNode extends SVITreeNode{
	
	final static JPopupMenu menu = new JPopupMenu();
	
	static{
		JMenuItem item1 = new JMenuItem(); item1.setText("remove");
		menu.add(item1);
		JMenuItem item2 = new JMenuItem(); item2.setText("validate");
		menu.add(item2);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SetVariableTreeNode(String name) {
		super(name,IconSet.SET_VAR_ICON);
	}

	@Override
	public boolean validate() {return true;}
	@Override
	public int requiredChildrenCount() {return 0;}
	@Override
	public JPopupMenu getPopupMenu() {return menu;}
	@Override
	public boolean isEditable() {return true;}
}
