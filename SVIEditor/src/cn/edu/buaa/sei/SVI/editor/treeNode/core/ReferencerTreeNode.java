package cn.edu.buaa.sei.SVI.editor.treeNode.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JMenuItem;
import javax.swing.tree.TreeNode;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;

public class ReferencerTreeNode extends VariableTreeNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	VariableTreeNode ref_node;
	
	public ReferencerTreeNode(String name) {
		super(name,IconSet.REF_VAR_ICON);
		this.regist();
	}
	
	public void regist(){
		JMenuItem item = new JMenuItem("refer");
		this.menu.add(item);
		
		final VariableTreeNode node = this;
		item.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TreeNode root = node.getRoot();
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				
				queue.add(root); 
				List<TreeNode> nodes = new ArrayList<TreeNode>();
				while(!queue.isEmpty()){
					TreeNode p = queue.poll();
					if(nodes.contains(p))continue;
					nodes.add(p);
					
					if(p instanceof VariableTreeNode){
						nodes.add(p);
					}
					
					int n = p.getChildCount();
					for(int i=0;i<n;i++){
						queue.add(p.getChildAt(i));
					}
				}
				System.out.println("Extracting all related "+nodes.size()+" variables...");
				
				/**
				 * Showing the options of Dialog...
				 * */
				
			}});
	}

	public void setRefer(VariableTreeNode ref_node){
		this.ref_node = ref_node;
	}
	@Override
	public boolean validate() {
		return ref_node!=null;
	}
	@Override
	public int requiredChildrenCount() {return 0;}
}
