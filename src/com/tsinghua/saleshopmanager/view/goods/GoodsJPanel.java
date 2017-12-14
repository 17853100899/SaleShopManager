package com.tsinghua.saleshopmanager.view.goods;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.GoodsDAO;
import com.tsinghua.saleshopmanager.vo.GoodsClass;

//商品类别管理
public class GoodsJPanel extends javax.swing.JPanel implements ActionListener, MouseListener {
	private JTabbedPane jTabbedPane1;
	// private JPanel jPanel1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private DefaultTableModel tableModel;
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	Vector<String> columnVector = new Vector<String>();
	// private JPanel jPanel3;
	// private JPanel jPanel2;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField cname;
	private JLabel jLabel1;
	private GoodsDAO goodsDAO = new GoodsDAO();
	private int index;
	private int cid;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GoodsJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public GoodsJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			// BorderLayout thisLayout = new BorderLayout();
			// this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(603, 390));
			this.setLayout(null);
			{
				// jTabbedPane1 = new JTabbedPane();
				// this.add(jTabbedPane1, BorderLayout.CENTER);
				// {
				// jPanel1 = new JPanel();
				// jTabbedPane1.addTab("商品类别管理", null, jPanel1, null);
				// jPanel1.setLayout(null);
				// {
				jScrollPane1 = new JScrollPane();
				// jPanel1.add(jScrollPane1);
				this.add(jScrollPane1);
				jScrollPane1.setBounds(95, 12, 412, 189);
				{
					tableModel = new DefaultTableModel();
					tableModel.setDataVector(goodsDAO.getGoodsClass(), goodsDAO.getColoumn());

					jTable1 = new JTable();
					jTable1.addMouseListener(this);
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(tableModel);
				}
				// }
				{
					jLabel1 = new JLabel();
					// jPanel1.add(jLabel1);
					this.add(jLabel1);
					jLabel1.setText("商品类别名称：");
					jLabel1.setBounds(128, 248, 112, 15);
				}
				{
					cname = new JTextField();
					// jPanel1.add(cname);
					this.add(cname);
					cname.setBounds(240, 244, 205, 22);
				}
				{
					jButton1 = new JButton();
					// jPanel1.add(jButton1);
					this.add(jButton1);
					jButton1.setText("添加");
					jButton1.setBounds(189, 299, 61, 22);
					jButton1.addActionListener(this);
				}
				{
					jButton2 = new JButton();
					// jPanel1.add(jButton2);
					this.add(jButton2);
					jButton2.setText("修改");
					jButton2.setBounds(277, 299, 64, 22);
					jButton2.setEnabled(false);
					jButton2.addActionListener(this);
				}
				{
					jButton3 = new JButton();
					// jPanel1.add(jButton3);
					this.add(jButton3);
					jButton3.setText("删除");
					jButton3.setBounds(364, 299, 61, 22);
					jButton3.setEnabled(false);
					jButton3.addActionListener(this);
				}
				// }
				// {
				// jPanel2 = new JPanel();
				// jTabbedPane1.addTab("商品单位管理", null, jPanel2, null);
				// jPanel2.setLayout(null);
				// }
				// {
				// jPanel3 = new JPanel();
				// jTabbedPane1.addTab("商品信息管理", null, jPanel3, null);
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {

		String goodsClassName;
		// 增加
		if (e.getSource() == jButton1) {
			goodsClassName = cname.getText().trim();
			if (goodsClassName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品类别不能为空！");
				clear();
			} else {
				GoodsClass goodsClass = new GoodsClass();
				goodsClass.setCName(goodsClassName);
				if (goodsDAO.saveGoodsClass(goodsClass)) {
					JOptionPane.showMessageDialog(this, "保存成功！");
					tableModel.setDataVector(goodsDAO.getGoodsClass(), goodsDAO.getColoumn());
					clear();

				} else {
					JOptionPane.showMessageDialog(this, "商品类别名称已经存在，插入失败！");
					clear();
				}
			}
		}
		// 修改
		if (e.getSource() == jButton2) {
			goodsClassName = cname.getText().trim();
			if (goodsClassName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品类别不能为空！");
				clear();
			} else {
				GoodsClass goodsClass = new GoodsClass();
				goodsClass.setCId(cid);
				goodsClass.setCName(goodsClassName);
				if (goodsDAO.updateGoodsClass(goodsClass)) {
					JOptionPane.showMessageDialog(this, "修改成功！");
					tableModel.setDataVector(goodsDAO.getGoodsClass(), goodsDAO.getColoumn());
					clear();
					jButton1.setEnabled(true);
					jButton2.setEnabled(false);
					jButton3.setEnabled(false);
				}
			}
		}
		// 删除
		if (e.getSource() == jButton3) {
			GoodsClass goodsClass = new GoodsClass();
			goodsClass.setCId(cid);
			if (goodsDAO.delGoodsClass(goodsClass)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				tableModel.setDataVector(goodsDAO.getGoodsClass(), goodsDAO.getColoumn());
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
			cname.setText(jTable1.getValueAt(index, 1) + "");
			cid = Integer.parseInt(jTable1.getValueAt(index, 0).toString());

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
		cname.setText("");
	}

}
