package cn.edu.buaa.sei.SVI.editor.treeNode;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import cn.edu.buaa.sei.SVI.editor.treeNode.core.StructRootTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.AddTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.NaturalVariableTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.NumericExpressionTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.ZIntVariableTreeNode;

public class Test {

	public static void main(String[] args) {
		MH();
		/***/
		StructRootTreeNode root = new StructRootTreeNode(null,"root");
		final JTree tree = new JTree(root);root.setTree(tree);
		
		NumericExpressionTreeNode item1 = new NumericExpressionTreeNode(tree,"expression");
		AddTreeNode item11 = new AddTreeNode(tree,"addition");
		NaturalVariableTreeNode item111 = new NaturalVariableTreeNode(tree,"x");
		ZIntVariableTreeNode item112 = new ZIntVariableTreeNode(tree,"y");
		item1.add(item11);
		item11.add(item111); item11.add(item112);
		root.add(item1);
		
		//final DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		tree.setCellRenderer(new MyCellRenderer());
		
		tree.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node==null)return;
				if(!(node instanceof SVITreeNode))return;
				
				SVITreeNode snode = (SVITreeNode) node;
				if(e.getButton()==MouseEvent.BUTTON3){
					/*System.out.println("Try to add new node at: #"+node.getUserObject().toString());
					model.insertNodeInto(new DefaultMutableTreeNode("NewOne"), node, node.getChildCount());*/
					JPopupMenu menu = snode.getPopupMenu();
					menu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		tree.setEditable(true);
		
		/***/
		JFrame f = new JFrame();
		f.setSize(300, 300);
		f.add(new JScrollPane(tree));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/***/
		/*JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		JScrollPane up = new JScrollPane();
		up.add(tree); 
		pan.add(BorderLayout.CENTER,up);
		
		JButton ok = new JButton("Select");
		JPanel down = new JPanel();
		down.setLayout(new FlowLayout());
		down.add(ok);down.add(new JButton("cancel"));
		pan.add(BorderLayout.SOUTH,down);
		
		final JFrame f = new JFrame();
		f.setSize(300, 300);
		f.add(pan);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan.repaint();
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
			}});*/
	}
	
	@SuppressWarnings("static-access")
	public static void MH(){
		try {
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.translucencyAppleLike;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class MyCellRenderer extends DefaultTreeCellRenderer{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override  
	    public Component getTreeCellRendererComponent(JTree tree, Object value,  
	            boolean sel, boolean expanded, boolean leaf, int row,  
	            boolean hasFocus)
	    {
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,  
	                row, hasFocus);
			setText(value.toString()); 
			if(sel)setForeground(getTextSelectionColor());
	        else setForeground(getTextNonSelectionColor());
			
			
			Font f = new Font(Font.SANS_SERIF, Font.BOLD, 12);
			this.setFont(f);
			
			if(value instanceof SVITreeNode){
				SVITreeNode node = (SVITreeNode) value;
				this.setIcon(node.getIcon());
			}
			/*DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			
			if(node.isLeaf()){this.setIcon(new ImageIcon("icons/variable.gif"));}
			else if(node.isRoot()){this.setIcon(new ImageIcon("icons/expression.gif"));}
			else{this.setIcon(new ImageIcon("icons/add.gif"));}*/
	        return this;  
	    }
		
	}

	public static JTree test1(){
		StructRootTreeNode root = new StructRootTreeNode(null,"root");
		final JTree tree = new JTree(root);root.setTree(tree);
		
		NumericExpressionTreeNode item1 = new NumericExpressionTreeNode(tree,"expression");
		AddTreeNode item11 = new AddTreeNode(tree,"addition");
		NaturalVariableTreeNode item111 = new NaturalVariableTreeNode(tree,"x");
		ZIntVariableTreeNode item112 = new ZIntVariableTreeNode(tree,"y");
		item1.add(item11);
		item11.add(item111); item11.add(item112);
		root.add(item1);
		
		//final DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		tree.setCellRenderer(new MyCellRenderer());
		
		tree.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node==null)return;
				if(!(node instanceof SVITreeNode))return;
				
				SVITreeNode snode = (SVITreeNode) node;
				if(e.getButton()==MouseEvent.BUTTON3){
					/*System.out.println("Try to add new node at: #"+node.getUserObject().toString());
					model.insertNodeInto(new DefaultMutableTreeNode("NewOne"), node, node.getChildCount());*/
					JPopupMenu menu = snode.getPopupMenu();
					menu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		tree.setEditable(true);
		
		return tree;
	}
	
	
}
