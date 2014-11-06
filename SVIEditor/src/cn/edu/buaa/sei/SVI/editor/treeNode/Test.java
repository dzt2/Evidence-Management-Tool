package cn.edu.buaa.sei.SVI.editor.treeNode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import cn.edu.buaa.sei.SVI.editor.translator.TreeNode2Struct;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.StructRootTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.AddTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.NaturalVariableTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.NumericExpressionTreeNode;
import cn.edu.buaa.sei.SVI.editor.treeNode.numeric.ZIntVariableTreeNode;
import cn.edu.buaa.sei.SVI.manage.IStructPrinter;
import cn.edu.buaa.sei.SVI.manage.StructManager;
import cn.edu.buaa.sei.SVI.manage.impl.SVIStream;
import cn.edu.buaa.sei.SVI.manage.impl.xml_struct.XMLStructPrinter;

public class Test {

	public static void main(String[] args) {
		
		testWindow();
		/*JPanel cp = new JPanel();
		cp.add(new JButton("LOW1"));
		cp.add(new JButton("LOW2"));
		
		JPanel sp = new JPanel();
		sp.add(new JButton("UP1"));
		sp.add(new JButton("UP2"));
		sp.add(new JButton("UP3"));
		sp.add(new JScrollBar());*/
		
		
		/*JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(BorderLayout.CENTER,sp);
		pan.add(BorderLayout.SOUTH,cp);*/
		
		/*JFrame f = new JFrame();
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.add(BorderLayout.CENTER,sp);
		f.add(BorderLayout.SOUTH,cp);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
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
	public static void testWindow(){
		MH();
		/***/
		final StructRootTreeNode root = new StructRootTreeNode(null,"root");
		final JTree tree = new JTree(root);root.setTree(tree);
		System.out.println(tree.getComponent(0).hashCode()+":"+root.hashCode());
		
		/*NumericExpressionTreeNode item1 = new NumericExpressionTreeNode(tree,"expression");
		AddTreeNode item11 = new AddTreeNode(tree,"addition");
		NaturalVariableTreeNode item111 = new NaturalVariableTreeNode(tree,"x");
		ZIntVariableTreeNode item112 = new ZIntVariableTreeNode(tree,"y");
		item1.add(item11);
		item11.add(item111); item11.add(item112);
		root.add(item1);*/
		
		//final DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		tree.setCellRenderer(new SVICellRenderer());
		
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
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(BorderLayout.CENTER,tree);
		pan.add(BorderLayout.EAST,new JScrollBar());
		pan.add(BorderLayout.SOUTH,new JScrollBar(JScrollBar.HORIZONTAL));
		
		JButton save = new JButton("save");
		JButton load = new JButton("load");
		JPanel cp = new JPanel();
		cp.add(save); cp.add(load);
		
		save.addActionListener(new ActionListener(){
			TreeNode2Struct translator = new TreeNode2Struct();
			IStructPrinter printer = new XMLStructPrinter();
			SVIStream resource = new SVIStream();
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					StructManager manager = translator.getFromRoot(root);
					File file = new File("test.xml");
					resource.setOutputStream(new FileOutputStream(file));
					printer.setOutputStream(resource);
					printer.write(manager);
					System.out.println("Writting file: "+file.getAbsolutePath());
				} catch (Exception e1) {
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE); 
				}
			}});
		
		
		/***/
		JFrame f = new JFrame();
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.add(BorderLayout.CENTER,pan);
		f.add(BorderLayout.SOUTH,cp);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*static class MyCellRenderer extends DefaultTreeCellRenderer{
		*//**
		 * 
		 *//*
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
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			
			if(node.isLeaf()){this.setIcon(new ImageIcon("icons/variable.gif"));}
			else if(node.isRoot()){this.setIcon(new ImageIcon("icons/expression.gif"));}
			else{this.setIcon(new ImageIcon("icons/add.gif"));}
	        return this;  
	    }
		
	}*/

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
		tree.setCellRenderer(new SVICellRenderer());
		
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
