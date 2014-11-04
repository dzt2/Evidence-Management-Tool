package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class TemplateTreeNode extends SVITreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPopupMenu menu = new JPopupMenu();

	public TemplateTreeNode(JTree tree, String name, ImageIcon icon) {
		super(tree, name, icon);
	}
	protected void _init(){
		JMenu i00 = new JMenu("create");
		JMenuItem item1 = new JMenuItem("remove");
		JMenuItem item2 = new JMenuItem("validate");
		
		menu.add(i00); menu.add(item1); menu.add(item2);
		
		i00.add(new JMenuItem("Boolean"));
		i00.add(new JMenuItem("Integer"));
		i00.add(new JMenuItem("Long"));
		i00.add(new JMenuItem("Float"));
		i00.add(new JMenuItem("Double"));
		i00.add(new JMenuItem("Character"));
		i00.add(new JMenuItem("String"));
		i00.add(new JMenuItem("Free"));
		i00.add(new JMenuItem("Reference"));
		i00.add(new JMenuItem("List"));
		i00.add(new JMenuItem("Set"));
		i00.add(new JMenuItem("Map"));
		i00.add(new JMenuItem("Logic"));
		i00.add(new JMenuItem("Group"));
		i00.add(new JMenuItem("Natural"));
		i00.add(new JMenuItem("ZInteger"));
		i00.add(new JMenuItem("Rational"));
		i00.add(new JMenuItem("Real"));
		
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
	public boolean validate() {
		int n = this.getChildCount();
		for(int i=0;i<n;i++){
			TreeNode node = this.getChildAt(i);
			if(!(node instanceof VariableTreeNode)){
				return false;
			}
		}
		return true;
	}
	@Override
	public int requiredChildrenCount() {return -1;}
	
	@Override
	public JPopupMenu getPopupMenu() {return this.menu;}
	@Override
	public boolean isEditable() {return true;}

}
