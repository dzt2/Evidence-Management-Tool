package cn.edu.buaa.sei.SVI.editor.treeNode;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public abstract class SVITreeNode extends DefaultMutableTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon icon;
	
	public SVITreeNode(ImageIcon icon){this.icon = icon;}
	
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public abstract boolean validate();
	public abstract int requiredChildrenCount();
	public abstract JPopupMenu getPopupMenu();
	public abstract boolean isEditable();
}
