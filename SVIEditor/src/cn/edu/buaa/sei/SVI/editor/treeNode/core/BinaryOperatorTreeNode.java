package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import javax.swing.ImageIcon;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public abstract class BinaryOperatorTreeNode extends OperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BinaryOperatorTreeNode(JTree tree, String name, ImageIcon icon) {
		super(tree, name, icon);
		this.init();
	}
	public void init(){
		/*JMenu item0 = (JMenu) this.menu.getComponent(0);
		item0.add(new JMenu("left"));
		item0.add(new JMenu("right"));*/
	}
	
	@Override
	public boolean validate() {
		if(this.getChildCount()==this.getChildCount()){
			SVITreeNode left = (SVITreeNode) this.getChildAt(0);
			SVITreeNode right = (SVITreeNode) this.getChildAt(1);
			return left.validate()&&right.validate();
		}
		return false;
	}
	@Override
	public int requiredChildrenCount() {return 2;}

}
