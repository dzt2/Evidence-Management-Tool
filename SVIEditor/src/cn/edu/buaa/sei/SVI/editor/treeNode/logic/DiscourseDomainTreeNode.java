package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.FreeVariableTreeNode;

public class DiscourseDomainTreeNode extends SVITreeNode{
	
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
	
	public DiscourseDomainTreeNode(String name) {
		super(name,IconSet.DISCOURSE_ICON);
		FreeVariableTreeNode node = new FreeVariableTreeNode(name+".iter");
		this.add(node);
	}

	@Override
	public boolean validate() {
		if(this.getChildCount()==1&&(this.getChildAt(0) instanceof FreeVariableTreeNode))
			return true;
		else return false;
	}
	@Override
	public int requiredChildrenCount() {return 0;}
	@Override
	public JPopupMenu getPopupMenu() {return menu;}
	@Override
	public boolean isEditable() {return true;}
}
