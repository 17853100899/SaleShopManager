package com.tsinghua.saleshopmanager.view.goods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.GoodsUnitDAO;
import com.tsinghua.saleshopmanager.vo.GoodsUnit;

public class GoodsUnitJPanel extends javax.swing.JPanel implements
		ActionListener, MouseListener {
	private JScrollPane jScrollPane1;

	private JTable jTable1;

	private DefaultTableModel tableModel;

	Vector<Vector<String>> vector = new Vector<Vector<String>>();

	Vector<String> columnVector = new Vector<String>();

	private GoodsUnitDAO goodsUnitDAO = new GoodsUnitDAO();

	private int index;

	private JButton jButton3;

	private JButton jButton2;

	private JButton jButton1;

	private JTextField guname;

	private JLabel jLabel1;

	private int guid;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GoodsUnitJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public GoodsUnitJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(510, 326));
			this.setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(38, 27, 422, 192);
				{
					tableModel = new DefaultTableModel();
					tableModel.setDataVector(goodsUnitDAO.getGoodsUnit(),
							goodsUnitDAO.getColoumn());
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(tableModel);
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("商品单位名称：");
				jLabel1.setBounds(84, 245, 104, 15);
			}
			{
				guname = new JTextField();
				this.add(guname);
				guname.setBounds(194, 241, 207, 22);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("添加");
				jButton1.setBounds(126, 286, 62, 22);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("修改");
				jButton2.setBounds(206, 286, 63, 22);
				jButton2.setEnabled(false);
				jButton2.addActionListener(this);
			}
			{
				jButton3 = new JButton();
				this.add(jButton3);
				jButton3.setText("删除");
				jButton3.setBounds(296, 286, 74, 22);
				jButton3.setEnabled(false);
				jButton3.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String goodsUnitName;
		// 增加
		if (e.getSource() == jButton1) {
			goodsUnitName = guname.getText().trim();
			if (goodsUnitName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品单位不能为空！");
				clear();
			} else {
				GoodsUnit goodsUnit = new GoodsUnit();
				goodsUnit.setGuname(goodsUnitName);
				if (goodsUnitDAO.saveGoodsClass(goodsUnit)) {
					JOptionPane.showMessageDialog(this, "保存成功！");
					tableModel.setDataVector(goodsUnitDAO.getGoodsUnit(),
							goodsUnitDAO.getColoumn());
					clear();

				} else {
					JOptionPane.showMessageDialog(this, "商品类别名称已经存在，插入失败！");
					clear();
				}
			}
		}
//		修改
		if (e.getSource()==jButton2) {
			goodsUnitName=guname.getText().trim();
			if (goodsUnitName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品单位不能为空！");
				clear();
			}else {
				GoodsUnit goodsUnit=new GoodsUnit();
				goodsUnit.setGuid(guid);
				goodsUnit.setGuname(goodsUnitName);
				if (goodsUnitDAO.updateGoodsClass(goodsUnit)) {
					JOptionPane.showMessageDialog(this, "修改成功！");
					tableModel.setDataVector(goodsUnitDAO.getGoodsUnit(),
							goodsUnitDAO.getColoumn());
					clear();
					jButton1.setEnabled(true);
					jButton2.setEnabled(false);
					jButton3.setEnabled(false);
				}
			}
		}
//		删除
		if (e.getSource()==jButton3) {
			GoodsUnit goodsUnit=new GoodsUnit();
			goodsUnit.setGuid(guid);
			if (goodsUnitDAO.delGoodsUnit(goodsUnit)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				tableModel.setDataVector(goodsUnitDAO.getGoodsUnit(),
						goodsUnitDAO.getColoumn());
				clear();
				jButton1.setEnabled(true);
				jButton2.setEnabled(false);
				jButton3.setEnabled(false);
				
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		jButton1.setEnabled(false);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		index = jTable1.getSelectedRow();
		if (index >= 0 && index < jTable1.getModel().getRowCount()) {
			guname.setText(jTable1.getValueAt(index, 1) + "");
			guid = Integer.parseInt(jTable1.getValueAt(index, 0).toString());			

		}

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void clear() {
		guname.setText("");
	}

}
