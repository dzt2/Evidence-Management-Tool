package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class UpperTreeNode extends SVITreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JPopupMenu menu = new JPopupMenu();

	public UpperTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_UPPER_ICON);
		this.init();
	}
	protected void init(){
		JMenuItem item = new JMenuItem("validate");
		this.menu.add(item);
		
		final SVITreeNode node = this;
		item.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(node.validate()){
					node.setIcon(node.getIcon());
				}
				else{
					node.setIcon(IconSet.ERROR_ICON);
				}
			}});
	}

	@Override
	public boolean validate() {
		try{
			Integer i = Integer.parseInt(this.getUserObject().toString());
			return i>=-1;
		}catch(Exception e){return false;}
	}
	@Override
	public int requiredChildrenCount() {return 0;}

	@Override
	public JPopupMenu getPopupMenu() {return this.menu;}
	@Override
	public boolean isEditable() {return true;}
}
