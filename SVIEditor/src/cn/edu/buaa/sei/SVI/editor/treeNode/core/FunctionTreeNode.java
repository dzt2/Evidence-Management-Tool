package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public abstract class FunctionTreeNode extends SVITreeNode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPopupMenu menu = new JPopupMenu();

	public FunctionTreeNode(JTree tree,String name, ImageIcon icon) {
		super(tree,name, icon);
		this._init();
	}
	
	protected void _init(){
		JMenu item0 = new JMenu("create");
		JMenuItem item1 = new JMenuItem("remove");
		JMenuItem item2 = new JMenuItem("validate");
		
		menu.add(item0); menu.add(item1); menu.add(item2);
		
		final SVITreeNode node = this;
		item2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(node.validate()){
					node.setIcon(node.getIcon());
				}
				else{
					node.setIcon(IconSet.ERROR_ICON);
				}
			}});
		
		
		final DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
		item1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeNodeFromParent(node);
			}
		});
	}

	@Override
	public int requiredChildrenCount() {return 1;}
	@Override
	public JPopupMenu getPopupMenu() {return menu;}
	@Override
	public boolean isEditable() {return false;}

}
