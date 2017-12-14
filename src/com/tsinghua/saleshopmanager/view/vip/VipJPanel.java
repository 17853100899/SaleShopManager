package com.tsinghua.saleshopmanager.view.vip;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

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

import com.tsinghua.saleshopmanager.dao.VipDAO;
import com.tsinghua.saleshopmanager.util.Constant;
import com.tsinghua.saleshopmanager.util.DateFormatUtil;
import com.tsinghua.saleshopmanager.vo.ShopVip;
import com.tsinghua.saleshopmanager.vo.VipSaveMoney;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class VipJPanel extends javax.swing.JPanel implements ActionListener,
		MouseListener {
	private JTabbedPane jTabbedPane1;

	private JPanel jPanel1;

	private JLabel jLabel4;

	private JLabel jLabel12;

	private JLabel jLabel11;

	private JLabel jLabel8;

	private JTable jTable1;

	private JScrollPane jScrollPane1;

	private JButton jButton6;

	private JButton jButton5;

	private JButton jButton4;

	private JTextField VBalance;

	private JLabel jLabel19;

	private JTextField ConsumeRate;

	private JLabel jLabel18;

	private JTextField ConsumeCount;

	private JLabel jLabel17;

	private JTextField ConsumeScore;

	private JLabel jLabel16;

	private JLabel jLabel15;

	private JTextField ConsumeSum;

	private JLabel jLabel14;

	private JTextField VBirthday;

	private JTextField VPhone;

	private JLabel jLabel13;

	private JTextField VName;

	private JTextField VId;

	private JTextField vipname;

	private JLabel jLabel10;

	private JLabel jLabel9;

	private JButton jButton3;

	private JTextField dianha;

	private JLabel jLabel7;

	private JTextField kahao;

	private JLabel jLabel6;

	private JButton jButton2;

	private JTextField tempjifen;

	private JTextField zongjifen;

	private JTextField jTextField1;

	private JLabel jLabel5;

	private JLabel jLabel3;

	private JButton jButton1;

	private JTextField VMoney;

	private JLabel jLabel2;

	private JTextField vid;

	private JLabel jLabel1;

	private JPanel jPanel3;

	private JPanel jPanel2;

	private VipDAO vipDAO = new VipDAO();

	private DefaultTableModel tableModel;
	private String cardnum="";//保存点击时的会员账号，便于修改和删除
	private int index;
	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new VipJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public VipJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(698, 389));
			this.setLayout(null);
			{
				jTabbedPane1 = new JTabbedPane();
				this.add(jTabbedPane1);
				jTabbedPane1.setBounds(12, 7, 674, 370);
				{
					jPanel3 = new JPanel();
					jTabbedPane1.addTab("会员兑奖", null, jPanel3, null);
					jPanel3.setLayout(null);
					{
						jLabel3 = new JLabel();
						jPanel3.add(jLabel3);
						jLabel3.setText("会员卡号\uff1a");
						jLabel3.setBounds(146, 86, 133, 15);
					}
					{
						jLabel4 = new JLabel();
						jPanel3.add(jLabel4);
						jLabel4.setText("积分\u603b\u989d\uff1a");
						jLabel4.setBounds(146, 139, 108, 15);
					}
					{
						jLabel5 = new JLabel();
						jPanel3.add(jLabel5);
						jLabel5.setText("\u5151\u5956积分\uff1a");
						jLabel5.setBounds(146, 200, 93, 15);
					}
					{
						jTextField1 = new JTextField();
						jPanel3.add(jTextField1);
						jTextField1.setBounds(328, 82, 251, 22);
						jTextField1.addActionListener(this);
					}
					{
						zongjifen = new JTextField();
						jPanel3.add(zongjifen);
						zongjifen.setBounds(328, 135, 253, 22);
						zongjifen.setEditable(false);
					}
					{
						tempjifen = new JTextField();
						jPanel3.add(tempjifen);
						tempjifen.setBounds(328, 196, 253, 22);
					}
					{
						jButton2 = new JButton();
						jPanel3.add(jButton2);
						jButton2.setText("\u5151\u5956");
						jButton2.setBounds(221, 254, 235, 56);
						jButton2.addActionListener(this);
					}
					jPanel3.setLayout(null);
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("会员充值", null, jPanel2, null);
					jPanel2.setLayout(null);
					{
						jLabel1 = new JLabel();
						jPanel2.add(jLabel1);
						jLabel1.setText("会员卡号\uff1a");
						jLabel1.setBounds(138, 57, 80, 21);
					}
					{
						vid = new JTextField();
						jPanel2.add(vid);
						vid.setBounds(230, 56, 287, 22);
					}
					{
						jLabel2 = new JLabel();
						jPanel2.add(jLabel2);
						jLabel2.setText("\u5145\u503c\u91d1\u989d\uff1a");
						jLabel2.setBounds(134, 148, 90, 15);
					}
					{
						VMoney = new JTextField();
						jPanel2.add(VMoney);
						VMoney.setBounds(230, 144, 287, 22);
					}
					{
						jButton1 = new JButton();
						jPanel2.add(jButton1);
						jButton1.setText("\u5145\u503c");
						jButton1.setBounds(246, 218, 236, 62);
						jButton1.addActionListener(this);
					}
					jPanel2.setLayout(null);
				}
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("会员管理", null, jPanel1, null);
					jPanel1.setLayout(null);
					{
						jLabel6 = new JLabel();
						jPanel1.add(jLabel6);
						jLabel6.setText("会员卡号");
						jLabel6.setBounds(41, 21, 65, 15);
					}
					{
						kahao = new JTextField();
						jPanel1.add(kahao);
						kahao.setBounds(152, 17, 169, 22);
					}
					{
						jLabel7 = new JLabel();
						jPanel1.add(jLabel7);
						jLabel7.setText("\u7535\u8bdd\u53f7\u7801");
						jLabel7.setBounds(354, 21, 48, 15);
					}
					{
						dianha = new JTextField();
						jPanel1.add(dianha);
						dianha.setBounds(437, 17, 181, 22);
					}
					{
						jLabel8 = new JLabel();
						jPanel1.add(jLabel8);
						jLabel8.setText("\u4f1a\u5458姓名");
						jLabel8.setBounds(41, 58, 65, 15);
					}
					{
						vipname = new JTextField();
						jPanel1.add(vipname);
						vipname.setBounds(152, 54, 169, 22);
					}
					{
						jButton3 = new JButton();
						jPanel1.add(jButton3);
						jButton3.setText("查询");
						jButton3.setBounds(387, 48, 231, 21);
						jButton3.addActionListener(this);
					}
					{
						jLabel9 = new JLabel();
						jPanel1.add(jLabel9);
						jLabel9.setText("\u5361\u53f7");
						jLabel9.setBounds(12, 261, 48, 15);
					}
					{
						jLabel10 = new JLabel();
						jPanel1.add(jLabel10);
						jLabel10.setText("\u7535\u8bdd\u53f7\u7801");
						jLabel10.setBounds(354, 21, 64, 15);
					}
					{
						jLabel12 = new JLabel();
						jPanel1.add(jLabel12);
						jLabel12.setText("\u4f1a\u5458姓名");
						jLabel12.setBounds(146, 258, 60, 15);
					}
					{
						VId = new JTextField();
						jPanel1.add(VId);
						VId.setBounds(46, 254, 94, 22);
					}
					{
						VName = new JTextField();
						jPanel1.add(VName);
						VName.setBounds(218, 254, 96, 22);
					}
					{
						jLabel13 = new JLabel();
						jPanel1.add(jLabel13);
						jLabel13.setText("\u7535\u8bdd");
						jLabel13.setBounds(12, 313, 35, 15);
					}
					{
						VPhone = new JTextField();
						jPanel1.add(VPhone);
						VPhone.setBounds(393, 254, 102, 22);
					}
					{
						VBirthday = new JTextField();
						jPanel1.add(VBirthday);
						VBirthday.setBounds(47, 281, 92, 22);
					}
					{
						jLabel14 = new JLabel();
						jPanel1.add(jLabel14);
						jLabel14.setText("\u751f\u65e5");
						jLabel14.setBounds(12, 285, 42, 15);
					}
					{
						ConsumeSum = new JTextField();
						jPanel1.add(ConsumeSum);
						ConsumeSum.setBounds(218, 281, 96, 22);
					}
					{
						jLabel15 = new JLabel();
						jPanel1.add(jLabel15);
						jLabel15.setText("\u6d88\u8d39\u603b\u989d");
						jLabel15.setBounds(145, 285, 61, 15);
					}
					{
						jLabel16 = new JLabel();
						jPanel1.add(jLabel16);
						jLabel16.setText("积分");
						jLabel16.setBounds(336, 285, 39, 15);
					}
					{
						ConsumeScore = new JTextField();
						jPanel1.add(ConsumeScore);
						ConsumeScore.setBounds(393, 281, 100, 22);
					}
					{
						jLabel17 = new JLabel();
						jPanel1.add(jLabel17);
						jLabel17.setText("\u6d88\u8d39\u6b21\u6570");
						jLabel17.setBounds(144, 313, 62, 15);
					}
					{
						ConsumeCount = new JTextField();
						jPanel1.add(ConsumeCount);
						ConsumeCount.setBounds(46, 309, 92, 22);
					}
					{
						jLabel18 = new JLabel();
						jPanel1.add(jLabel18);
						jLabel18.setText("积分\u7387");
						jLabel18.setBounds(326, 258, 49, 15);
					}
					{
						ConsumeRate = new JTextField();
						jPanel1.add(ConsumeRate);
						ConsumeRate.setBounds(218, 309, 96, 22);
					}
					{
						jLabel19 = new JLabel();
						jPanel1.add(jLabel19);
						jLabel19.setText("\u4f59\u989d");
						jLabel19.setBounds(336, 313, 39, 15);
					}
					{
						VBalance = new JTextField();
						jPanel1.add(VBalance);
						VBalance.setBounds(393, 309, 100, 22);
					}
					{
						jButton4 = new JButton();
						jPanel1.add(jButton4);
						jButton4.setText("添加");
						jButton4.setBounds(533, 254, 110, 22);
						jButton4.addActionListener(this);
					}
					{
						jButton5 = new JButton();
						jPanel1.add(jButton5);
						jButton5.setText("修改");
						jButton5.setBounds(533, 282, 110, 21);
						jButton5.setEnabled(false);
						jButton5.addActionListener(this);
					}
					{
						jButton6 = new JButton();
						jPanel1.add(jButton6);
						jButton6.setText("删除");
						jButton6.setBounds(533, 307, 110, 26);
						jButton6.setEnabled(false);
						jButton6.addActionListener(this);
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setBounds(12, 81, 631, 161);
						{
							tableModel = new DefaultTableModel();
							ShopVip v = new ShopVip();
							v.setVId("");
							v.setVPhone("");
							v.setVName("");
							tableModel.setDataVector(vipDAO.getShopVIP(v),
									vipDAO.getVipColoumn());
							jTable1 = new JTable();
							jScrollPane1.setViewportView(jTable1);
							jTable1.setModel(tableModel);
							jTable1.addMouseListener(this);

						}
					}
					jPanel1.setLayout(null);
					jPanel1.setPreferredSize(new java.awt.Dimension(674, 351));
				}
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("\u4f1a\u5458姓名");
				jLabel11.setBounds(58, 58, 48, 15);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String svid;
		String sname;
		String sphone;
		String sum;
		String sscore;
		String scount;
		String srate;
		String sbirth;
		String sbalan;
		// 会员充值
		if (e.getSource() == jButton1) {
			String vipVid = vid.getText().trim();
			String money = VMoney.getText().trim();
			if (vipVid.equals("") || money.equals("")) {
				JOptionPane.showMessageDialog(this, "会员账号或充值金额不能为空！");
				return;
			}
			float vipMoney = Float.valueOf(money);
			if (vipMoney <= 0) {
				JOptionPane.showMessageDialog(this, "充值金额不能小于0！");
				return;
			}
			VipSaveMoney vsm = new VipSaveMoney();
			vsm.setVid(vipVid);
			vsm.setVtime(DateFormatUtil.dateFormat(new Date()));
			vsm.setVMoney(vipMoney);
			vsm.setUId(Constant.uid);
			if (vipDAO.updateMoney(vsm)) {
				JOptionPane.showMessageDialog(this, "充值成功！");
				vid.setText("");
				VMoney.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "该会员账号不存在！");
				vid.setText("");
				VMoney.setText("");
			}

		}// end
		// 兑换积分
		if (e.getSource() == jTextField1) {
			String vipvid = jTextField1.getText().trim();

			if (vipvid.equals("")) {
				JOptionPane.showMessageDialog(this, "会员卡号不能为空！");
				return;
			}
			String score = vipDAO.searchIntegral(vipvid);
			if (score == null) {
				JOptionPane.showMessageDialog(this, "会员卡号不存在！");
				return;
			}
			zongjifen.setText(score);
			jTextField1.setEditable(false);

		}//
		if (e.getSource() == jButton2) {
			String num = jTextField1.getText().trim();
			String str = tempjifen.getText().trim();
			if (str.equals("")) {
				JOptionPane.showMessageDialog(this, "积分不能为空！");
				return;
			}
			// 兑奖积分
			int temp = Integer.valueOf(str);
			// 总积分
			int temp1 = Integer.valueOf(zongjifen.getText().trim());
			if (temp > temp1) {
				JOptionPane.showMessageDialog(this, "积分不足，无法兑奖！");
				return;
			}
			if (vipDAO.encashIntegral(jTextField1.getText().trim(), temp)) {
				JOptionPane.showMessageDialog(this, "兑奖成功！");
				jTextField1.setText("");
				tempjifen.setText("");
				zongjifen.setText("");
				jTextField1.setEditable(true);
				zongjifen.setEditable(true);
			}
		}//
		if (e.getSource() == jButton3) {
			String num = kahao.getText().trim();
			String name = vipname.getText().trim();
			String tel = dianha.getText().trim();
			ShopVip sv = new ShopVip();
			sv.setVId(num);
			sv.setVName(name);
			sv.setVPhone(tel);
			tableModel.setDataVector(vipDAO.getShopVIP(sv), vipDAO
					.getVipColoumn());

		}//
		// 添加
		if (e.getSource() == jButton4) {
			svid = VId.getText().trim();
			
			sname = VName.getText().trim();
			sphone = ConsumeCount.getText().trim();
			
			sum = ConsumeSum.getText().trim();

			sscore = ConsumeScore.getText().trim();
			
			scount = ConsumeRate.getText().trim();
			
			srate = VPhone.getText().trim();
			sbirth = VBirthday.getText().trim();
			sbalan = VBalance.getText().trim();
			if (svid.equals("") || sname.equals("") || sphone.equals("")
					|| sum.equals("") || sscore.equals("") || scount.equals("")
					|| srate.equals("") || sbirth.equals("") || sbalan.equals("")) {
				JOptionPane.showMessageDialog(this,"选项不能为空");
				return;
			}
			ShopVip v=new ShopVip();
			v.setVId(svid);
			v.setVName(sname);
			v.setVPhone(sphone);
			v.setConsumeSum(Float.valueOf(sum));
			v.setConsumeScore(Integer.valueOf(sscore));
			v.setConsumeRate(Float.valueOf(srate));
			v.setConsumeCount(Integer.valueOf(scount));
			v.setVBalance(Float.valueOf(sbalan));
			v.setVBirthday(sbirth);
			if (vipDAO.saveShopVip(v)) {
				JOptionPane.showMessageDialog(this, "添加成功");
				v=new ShopVip();
				v.setVId("");
				v.setVPhone("");
				v.setVName("");
				tableModel.setDataVector(vipDAO.getShopVIP(v),
						vipDAO.getVipColoumn());
			}
		}
		// 修改
		if (e.getSource() == jButton5) {
			svid = VId.getText().trim();
			
			sname = VName.getText().trim();
			sphone = ConsumeCount.getText().trim();
			
			//sum = ConsumeSum.getText().trim();

			//sscore = ConsumeScore.getText().trim();
			
			//scount = ConsumeRate.getText().trim();
			
			srate = VPhone.getText().trim();
			sbirth = VBirthday.getText().trim();
			sbalan = VBalance.getText().trim();
			if (svid.equals("") || sname.equals("") || sphone.equals("")
					|| srate.equals("") || sbirth.equals("") || sbalan.equals("")) {
				JOptionPane.showMessageDialog(this,"选项不能为空");
				return;
			}
			ShopVip v=new ShopVip();
			v.setVId(svid);
			v.setVName(sname);
			v.setVPhone(sphone);
			//v.setConsumeSum(Float.valueOf(sum));
			//v.setConsumeScore(Integer.valueOf(sscore));
			v.setConsumeRate(Float.valueOf(srate));
			//v.setConsumeCount(Integer.valueOf(scount));
			v.setVBalance(Float.valueOf(sbalan));
			v.setVBirthday(sbirth);
			if (vipDAO.updateVip(v)) {
				JOptionPane.showMessageDialog(this,"修改成功！");
				ShopVip vv=new ShopVip();
				vv.setVId("");
				vv.setVName("");
				vv.setVPhone("");
				tableModel.setDataVector(vipDAO.getShopVIP(vv),vipDAO.getVipColoumn());
				jButton6.setEnabled(false);
				jButton5.setEnabled(false);
				ConsumeRate.setEditable(true);
				ConsumeSum.setEditable(true);
				ConsumeScore.setEditable(true);
				VId.setEditable(true);
				clear();
				return;
			}
			JOptionPane.showMessageDialog(this,"修改失败！");
			
			
		}
//		 删除
		if (e.getSource() == jButton6) {
			if (vipDAO.delVip(cardnum)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				ShopVip v=new ShopVip();
				v.setVId("");
				v.setVName("");
				v.setVPhone("");
				tableModel.setDataVector(vipDAO.getShopVIP(v),vipDAO.getVipColoumn());
				jButton6.setEnabled(false);
				jButton5.setEnabled(false);
				ConsumeRate.setEditable(true);
				ConsumeSum.setEditable(true);
				ConsumeScore.setEditable(true);
				VId.setEditable(true);
				clear();
				return;
			}
			JOptionPane.showMessageDialog(this, "会员有消费关联，无法删除！");
			
		}

	}

	public void mouseClicked(MouseEvent e) {
		jButton4.setEnabled(false);
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
		ConsumeRate.setEditable(false);
		ConsumeSum.setEditable(false);
		ConsumeScore.setEditable(false);
		VId.setEditable(false);
		
		index=jTable1.getSelectedRow();
		if (index>=0&&index<jTable1.getModel().getRowCount()) {
			cardnum=jTable1.getValueAt(index, 0)+"";
			VId.setText(jTable1.getValueAt(index, 0)+"");
			VName.setText(jTable1.getValueAt(index,1)+"");
			VPhone.setText(jTable1.getValueAt(index,6)+"");
			ConsumeSum.setText(jTable1.getValueAt(index,3)+"");
			ConsumeScore.setText(jTable1.getValueAt(index,4)+"");
			ConsumeCount.setText(jTable1.getValueAt(index,2)+"");
			ConsumeRate.setText(jTable1.getValueAt(index,5)+"");
			VBirthday.setText(jTable1.getValueAt(index,7)+"");
			VBalance.setText(jTable1.getValueAt(index,8)+"");
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
		VId.setText("");
		VName.setText("");
		VPhone.setText("");
		ConsumeCount.setText("");
		ConsumeRate.setText("");
		ConsumeScore.setText("");
		ConsumeSum.setText("");
		VBalance.setText("");
		VBirthday.setText("");
		
	}

}
