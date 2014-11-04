package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class LogicVariableTreeNode extends SVITreeNode{
	
	final static JPopupMenu menu = new JPopupMenu();
	
	static{
		JMenuItem item1 = new JMenuItem(); item1.setText("remove");
		menu.add(item1);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogicVariableTreeNode() {
		super(IconSet.LOGIC_VAR_ICON);
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
