package com.tsinghua.saleshopmanager.view.goods;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.GoodsDAO;
import com.tsinghua.saleshopmanager.dao.GoodsPrivoderDAO;
import com.tsinghua.saleshopmanager.vo.GoodsClass;
import com.tsinghua.saleshopmanager.vo.GoodsPrivoder;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GoodsPrivoderJPanel extends javax.swing.JPanel implements ActionListener,MouseListener{
	private JScrollPane jScrollPane1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JTextField GPPhone;
	private JTextField GPAddress;
	private JTextField GPLinkman;
	private JTextField GPName;
	private JLabel jLabel3;
	private JLabel jLabel1;
	private JTable jTable1;
	private DefaultTableModel tableModel;
	Vector<Vector<String>> vector=new Vector<Vector<String>>();
	Vector<String> columnVector=new Vector<String>();
	private GoodsPrivoderDAO goodsPrivoderDAO=new GoodsPrivoderDAO();
	private int index;
	private int gpid;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GoodsPrivoderJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GoodsPrivoderJPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(548, 365));
			this.setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(20, 27, 495, 211);
				{
					tableModel=new DefaultTableModel();
					tableModel.setDataVector(goodsPrivoderDAO.getGoodsPrivoder(), goodsPrivoderDAO.getColoumn());
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(tableModel);
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u8054\u7cfb\u4eba\uff1a");
				jLabel1.setBounds(320, 255, 69, 15);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u7535 \u8bdd\uff1a");
				jLabel2.setBounds(318, 291, 49, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u5730    \u5740\uff1a");
				jLabel3.setBounds(38, 291, 82, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("供货商名称：");
				jLabel4.setBounds(36, 255, 101, 15);
			}
			{
				GPName = new JTextField();
				this.add(GPName);
				GPName.setBounds(122, 251, 181, 22);
				
			}
			{
				GPLinkman = new JTextField();
				this.add(GPLinkman);
				GPLinkman.setBounds(375, 251, 97, 22);
			}
			{
				GPAddress = new JTextField();
				this.add(GPAddress);
				GPAddress.setBounds(120, 287, 186, 22);
			}
			{
				GPPhone = new JTextField();
				this.add(GPPhone);
				GPPhone.setBounds(373, 287, 102, 22);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("添加");
				jButton1.setBounds(94, 321, 63, 22);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("修改");
				jButton2.setBounds(188, 321, 62, 22);
				jButton2.setEnabled(false);
				jButton2.addActionListener(this);
				
			}
			{
				jButton3 = new JButton();
				this.add(jButton3);
				jButton3.setText("删除");
				jButton3.setEnabled(false);
				jButton3.setBounds(280, 321, 62, 22);
				jButton3.addActionListener(this);
			}
			{
				jButton4 = new JButton();
				this.add(jButton4);
				jButton4.setText("查询");
				jButton4.setBounds(379, 321, 75, 22);
				jButton4.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String goodsPrivoderName;
		String goodsPrivoderPhone;
		String goodsPrivoderAddress;
		String goodsPrivoderLinkman;
		
//		增加
		if (e.getSource()==jButton1) {
			goodsPrivoderName=GPName.getText().trim();
			goodsPrivoderPhone=GPPhone.getText().trim();
			goodsPrivoderAddress=GPAddress.getText().trim();
			goodsPrivoderLinkman=GPLinkman.getText().trim();
			if (goodsPrivoderName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品供应商名称不能为空！");
				clear();
			}else {
				GoodsPrivoder goodsPrivoder=new GoodsPrivoder();
				goodsPrivoder.setGpaddress(goodsPrivoderAddress);
				goodsPrivoder.setGplinkman(goodsPrivoderLinkman);
				goodsPrivoder.setGpphone(goodsPrivoderPhone);
				goodsPrivoder.setGpname(goodsPrivoderName);
				if (goodsPrivoderDAO.saveGoodsPrivoder(goodsPrivoder)) {
					JOptionPane.showMessageDialog(this, "保存成功！");
					tableModel.setDataVector(goodsPrivoderDAO.getGoodsPrivoder(), goodsPrivoderDAO.getColoumn());
					clear();
					
				}else {
					JOptionPane.showMessageDialog(this, "商品供应商名称已经存在，插入失败！");
					clear();
				}
			}
		}
//		修改
		if (e.getSource()==jButton2) {
			goodsPrivoderName=GPName.getText().trim();
			goodsPrivoderPhone=GPPhone.getText().trim();
			goodsPrivoderAddress=GPAddress.getText().trim();
			goodsPrivoderLinkman=GPLinkman.getText().trim();
			if (goodsPrivoderName.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，商品类别不能为空！");
				clear();
			}else {
				GoodsPrivoder goodsPrivoder=new GoodsPrivoder();
				goodsPrivoder.setGpaddress(goodsPrivoderAddress);
				goodsPrivoder.setGplinkman(goodsPrivoderLinkman);
				goodsPrivoder.setGpphone(goodsPrivoderPhone);
				goodsPrivoder.setGpname(goodsPrivoderName);
				goodsPrivoder.setGpid(gpid);
				if (goodsPrivoderDAO.updateGoodsPrivoder(goodsPrivoder)) {
					JOptionPane.showMessageDialog(this, "修改成功！");
					tableModel.setDataVector(goodsPrivoderDAO.getGoodsPrivoder(), goodsPrivoderDAO.getColoumn());
					clear();
					jButton1.setEnabled(true);
					jButton2.setEnabled(false);
					jButton3.setEnabled(false);
				}
			}
		}
//		删除
		if (e.getSource()==jButton3) {
			GoodsPrivoder goodsPrivoder=new GoodsPrivoder();
			goodsPrivoder.setGpid(gpid);
			if (goodsPrivoderDAO.delGoodsPrivoder(goodsPrivoder)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				tableModel.setDataVector(goodsPrivoderDAO.getGoodsPrivoder(), goodsPrivoderDAO.getColoumn());
				clear();
				jButton1.setEnabled(true);
				jButton2.setEnabled(false);
				jButton3.setEnabled(false);
				
			}
		}
		//模糊搜索
		if (e.getSource()==jButton4) {
			goodsPrivoderName=GPName.getText().trim();
			goodsPrivoderPhone=GPPhone.getText().trim();
			GoodsPrivoder goodsPrivoder=new GoodsPrivoder();
			goodsPrivoder.setGpphone(goodsPrivoderPhone);
			goodsPrivoder.setGpname(goodsPrivoderName);
			tableModel.setDataVector(goodsPrivoderDAO.searchGoodsPrivoder(goodsPrivoder), goodsPrivoderDAO.getColoumn());
			clear();
			
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		jButton1.setEnabled(false);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		index=jTable1.getSelectedRow();
		if (index>=0&&index<jTable1.getModel().getRowCount()) {
			GPName.setText(jTable1.getValueAt(index, 1)+"");
			gpid=Integer.parseInt(jTable1.getValueAt(index, 0).toString());
			GPAddress.setText(jTable1.getValueAt(index, 4)+"");
			GPLinkman.setText(jTable1.getValueAt(index, 2)+"");
			GPPhone.setText(jTable1.getValueAt(index, 3)+"");
			
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
	public void clear(){
		GPAddress.setText("");
		GPLinkman.setText("");
		GPName.setText("");
		GPPhone.setText("");
	}

}
