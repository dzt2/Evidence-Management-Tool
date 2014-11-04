package cn.edu.buaa.sei.SVI.editor.treeNode.core;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.SVITreeNode;

public class StructRootTreeNode extends SVITreeNode{

	final JPopupMenu menu = new JPopupMenu();
	
	void init(){
		JMenu item0 = new JMenu(); item0.setText("create");
		JMenuItem item2 = new JMenuItem(); item2.setText("validate");
		menu.add(item0);
		menu.add(item2);
		
		final SVITreeNode node = this;
		item2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!node.validate()){
					node.setIcon(IconSet.ERROR_ICON);
				}
				else node.setIcon(node.getIcon());
			}});
		
		JMenu i00 = new JMenu(); i00.setText("variable");
		JMenu i01 = new JMenu(); i01.setText("expression");
		JMenu i02 = new JMenu(); i02.setText("function");
		
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
		
		i01.add(new JMenuItem("LogicExpression"));
		i01.add(new JMenuItem("NumericExpression"));
		i01.add(new JMenuItem("GroupExpression"));
		
		i02.add(new JMenuItem("LogicFunction"));
		i02.add(new JMenuItem("GroupFunction"));
		i02.add(new JMenuItem("NaturalFunction"));
		i02.add(new JMenuItem("ZIntegerFunction"));
		i02.add(new JMenuItem("RationalFunction"));
		i02.add(new JMenuItem("RealFunction"));
		i02.add(new JMenuItem("Filter"));
		i02.add(new JMenuItem("Mapper"));
		i02.add(new JMenuItem("TableMapper"));
		
		item0.add(i00); item0.add(i01); item0.add(i02);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StructRootTreeNode(JTree tree,String name) {
		super(tree,name, IconSet.STRUCT_GROUP_ICON);
		this.init();
	}

	@Override
	public boolean validate() {
		int n = this.getChildCount();
		for(int i=0;i<n;i++){
			if(this.getChildAt(i) instanceof SVITreeNode){
				boolean res = ((SVITreeNode)this.getChildAt(i)).validate();
				if(!res)return false;
			}
			else return false;
		}
		return true;
	}
	@Override
	public int requiredChildrenCount() {return -1;}
	@Override
	public JPopupMenu getPopupMenu() {return menu;}
	@Override
	public boolean isEditable() {return false;}

}
