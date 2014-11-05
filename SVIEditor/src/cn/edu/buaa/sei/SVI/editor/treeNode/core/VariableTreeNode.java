package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public abstract class VariableTreeNode extends SVITreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPopupMenu menu = new JPopupMenu();
	
	void var_init(){
		JMenuItem item1 = new JMenuItem(); item1.setText("remove");
		menu.add(item1);
		JMenuItem item2 = new JMenuItem(); item2.setText("validate");
		menu.add(item2);
		
		final SVITreeNode node = this;
		item2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(node.validate()){
					SVITreeNode p = node;
					SVITreeNode root = (SVITreeNode) node.getRoot();
					while(p!=null){
						p.recover();
						if(p==root)break;
						p = (SVITreeNode) p.getParent();
					}
					JOptionPane.showMessageDialog(null, "Validation Passed at: #"+node.getUserObject().toString(),
							"Validation", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					SVITreeNode p = node;
					SVITreeNode root = (SVITreeNode) node.getRoot();
					while(p!=null){
						p.back();
						p.setIcon(IconSet.ERROR_ICON);
						if(p==root)break;
						p = (SVITreeNode) p.getParent();
					}
					JOptionPane.showMessageDialog(null, "Validation Failed at: #"+node.getUserObject().toString(),
							"Validation", JOptionPane.ERROR_MESSAGE); 
				}
				node.getTree().repaint();
			}});
		
		final DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
		item1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeNodeFromParent(node);
			}
		});
	}
	
	public VariableTreeNode(JTree tree,String name,ImageIcon icon) {
		super(tree,name,icon);
		this.var_init();
	}
	
	@Override
	public JPopupMenu getPopupMenu() {return menu;}
	@Override
	public boolean isEditable() {return true;}
}
