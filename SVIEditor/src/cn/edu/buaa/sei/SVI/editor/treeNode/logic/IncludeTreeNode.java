package cn.edu.buaa.sei.SVI.editor.treeNode.logic;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import cn.edu.buaa.sei.SVI.editor.treeNode.IconSet;
import cn.edu.buaa.sei.SVI.editor.treeNode.core.BinaryOperatorTreeNode;

public class IncludeTreeNode extends BinaryOperatorTreeNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncludeTreeNode(JTree tree, String name) {
		super(tree, name, IconSet.OP_GROUPEQUAL_ICON);
		this.op_init();
	}
	protected void op_init(){
		/**/
		JMenu item0 = (JMenu) this.menu.getComponent(0);
		
		JMenu item00 = new JMenu("element");
		JMenu item01 = new JMenu("group");
		
		item0.add(item00); item0.add(item01);
		
		item01.add(new JMenuItem("GroupVariable"));
		item01.add(new JMenuItem("GroupExpression"));
		item01.add(new JMenuItem("GroupFunction"));
		item01.add(new JMenuItem("Filter"));
		item01.add(new JMenuItem("Mapper"));
		item01.add(new JMenuItem("TableMapper"));
		
		JMenu i00 = new JMenu(); i00.setText("variable");
		JMenu i01 = new JMenu(); i01.setText("expression");
		JMenu i02 = new JMenu(); i02.setText("function");
		item00.add(i00); item01.add(i01); item00.add(i02);
		
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
		i02.add(new JMenuItem("NumericFunction"));
		/*
		i02.add(new JMenuItem("ZIntegerFunction"));
		i02.add(new JMenuItem("RationalFunction"));
		i02.add(new JMenuItem("RealFunction"));
		*/
		i02.add(new JMenuItem("Filter"));
		i02.add(new JMenuItem("Mapper"));
		i02.add(new JMenuItem("TableMapper"));
	}
}
