package com.tsinghua.saleshopmanager.view.sale;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.GoodsDAO;
import com.tsinghua.saleshopmanager.dao.SaleDAO;
import com.tsinghua.saleshopmanager.util.Constant;
import com.tsinghua.saleshopmanager.util.DateFormatUtil;
import com.tsinghua.saleshopmanager.util.NumberFormatUtil;
import com.tsinghua.saleshopmanager.vo.Goods;
import com.tsinghua.saleshopmanager.vo.Sell;
import com.tsinghua.saleshopmanager.vo.SellDetail;
import com.tsinghua.saleshopmanager.vo.ShopVip;
import com.tsinghua.saleshopmanager.vo.saleGoodBean;

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
public class SaleJPanel extends javax.swing.JPanel implements ActionListener,
		MouseListener {
	private JLabel jLabel1;

	private JLabel jLabel2;

	private JTextField CardNumber;

	private JLabel jLabel4;

	private JTable jTable1;

	private JScrollPane jScrollPane1;

	private JLabel jLabel16;

	private JButton jButton2;

	private JButton jButton1;

	private JLabel jLabel15;

	private JLabel jLabel14;

	private JTextField shishou;

	private JLabel jLabel13;

	private JLabel jLabel12;

	private JLabel jLabel11;

	private JLabel jLabel10;

	private JLabel jLabel9;

	private JLabel jLabel8;

	private JLabel jLabel7;

	private JLabel jLabel6;

	private JTextField yue;

	private JLabel jLabel5;

	private JTextField jf;

	private JTextField name;

	private JLabel jLabel3;

	private JTextField vid;

	Vector<Vector<String>> vector = new Vector<Vector<String>>();

	Vector<Object[]> v = new Vector<Object[]>();

	private DefaultTableModel tableModel;

	private int index;

	private SaleDAO saleDAO = new SaleDAO();

	private JLabel jLabel18;

	private JTextField count;

	private JLabel jLabel17;

	JPopupMenu jPopupMenu1 = new JPopupMenu();

	JMenuItem jMenuItem1 = new JMenuItem();

	int number = 0;// 保存选择商品的总个数

	// 保存会员登录后信息，为交易成功更新数据做准备

	double ConsumeSumI; // 消费总金额

	double ConsumeRateI; // 积分率

	int ConsumeCountI; // 消费次数

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SaleJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public SaleJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(640, 384));
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("商品条形码");
				jLabel1.setBounds(70, 35, 111, 15);
			}
			{
				vid = new JTextField();
				this.add(vid);
				vid.setBounds(154, 31, 200, 22);
				vid.addActionListener(this);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("会员卡号");
				jLabel2.setBounds(28, 279, 63, 15);
			}
			{
				CardNumber = new JTextField();
				this.add(CardNumber);
				CardNumber.setBounds(82, 275, 103, 22);
				CardNumber.addActionListener(this);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("姓名");
				jLabel3.setBounds(197, 279, 45, 15);
			}
			{
				name = new JTextField();
				this.add(name);
				name.setBounds(229, 275, 70, 22);
				name.setEditable(false);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("积分");
				jLabel4.setBounds(311, 279, 39, 15);
			}
			{
				jf = new JTextField();
				this.add(jf);
				jf.setBounds(341, 275, 81, 22);
				jf.setEditable(false);

			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u4f59\u989d");
				jLabel5.setBounds(428, 279, 50, 15);
			}
			{
				yue = new JTextField();
				this.add(yue);
				yue.setBounds(461, 275, 65, 22);
				yue.setEditable(false);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u5171\u8ba1\uff1a");
				jLabel6.setBounds(28, 315, 79, 23);
				jLabel6.setFont(new java.awt.Font("楷体_GB2312", 1, 20));
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\uffe5");
				jLabel7.setBounds(90, 311, 55, 30);
				jLabel7.setFont(new java.awt.Font("楷体_GB2312", 1, 28));
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("0.00");
				jLabel8.setBounds(127, 311, 184, 30);
				jLabel8.setFont(new java.awt.Font("楷体_GB2312", 1, 28));
				jLabel8.setForeground(new java.awt.Color(255, 128, 0));
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("\u5171\u8ba1\uff1a");
				jLabel9.setFont(new java.awt.Font("楷体_GB2312", 1, 20));
				jLabel9.setBounds(28, 347, 79, 23);
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("\u79cd\u5546\u54c1");
				jLabel10.setBounds(127, 344, 149, 29);
				jLabel10.setFont(new java.awt.Font("楷体_GB2312", 1, 20));
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("0");
				jLabel11.setBounds(97, 348, 32, 21);
				jLabel11.setFont(new java.awt.Font("楷体_GB2312", 1, 24));
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setText("\u5b9e\u6536\uff1a");
				jLabel12.setBounds(276, 314, 65, 25);
				jLabel12.setFont(new java.awt.Font("楷体_GB2312", 1, 20));
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setText("\uffe5");
				jLabel13.setFont(new java.awt.Font("楷体_GB2312", 1, 28));
				jLabel13.setBounds(330, 311, 55, 30);
			}
			{
				shishou = new JTextField();
				this.add(shishou);
				shishou.setBounds(381, 311, 78, 26);
			}
			{
				jLabel14 = new JLabel();
				this.add(jLabel14);
				jLabel14.setText("\u5e94\u627e\u91d1\u989d\uff1a");
				jLabel14.setFont(new java.awt.Font("楷体_GB2312", 1, 20));
				jLabel14.setBounds(231, 346, 117, 25);
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setText("\uffe5");
				jLabel15.setFont(new java.awt.Font("楷体_GB2312", 1, 28));
				jLabel15.setBounds(330, 343, 55, 30);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u73b0\u91d1\u7ed3\u8d26");
				jButton1.setBounds(533, 310, 95, 59);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("\u4f1a\u5458\u7ed3\u8d26");
				jButton2.setBounds(538, 272, 90, 29);
				jButton2.setEnabled(false);
				jButton2.addActionListener(this);
			}
			{
				jLabel16 = new JLabel();
				this.add(jLabel16);
				jLabel16.setText("0.00");
				jLabel16.setBounds(382, 347, 148, 22);
				jLabel16.setFont(new java.awt.Font("楷体_GB2312", 1, 28));
				jLabel16.setForeground(new java.awt.Color(255, 0, 0));
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(18, 71, 610, 195);
				{
					tableModel = new DefaultTableModel();
					saleGoodBean g = saleDAO.SearchSaleGood(null);
					getColumn();

					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);

					jTable1.setModel(tableModel);

					hideColumn(jTable1, 6);
					jTable1.addMouseListener(this);
					// 在table上添加右键对象
					jPopupMenu1.setInvoker(jTable1);
					jMenuItem1.setText("删除");
					jPopupMenu1.add(jMenuItem1);
					jMenuItem1.addActionListener(this);

				}
			}
			{
				jLabel17 = new JLabel();
				this.add(jLabel17);
				jLabel17.setText("\u8d2d\u4e70\u6570\u91cf");
				jLabel17.setBounds(413, 35, 61, 15);
			}
			{
				count = new JTextField();
				this.add(count);
				count.setBounds(486, 31, 46, 22);
				count.addActionListener(this);
			}
			{
				jLabel18 = new JLabel();
				this.add(jLabel18);
				jLabel18.setText("0.00");
				jLabel18.setBounds(373, 8, 93, 15);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getColumn() {

		tableModel.addColumn("条形码");
		tableModel.addColumn("名称");
		tableModel.addColumn("规格");
		tableModel.addColumn("单位");
		tableModel.addColumn("销售价");
		tableModel.addColumn("数量");
		tableModel.addColumn("会员价");

	}

	public void actionPerformed(ActionEvent e) {
		// 右键删除事件
		if (e.getSource() == jMenuItem1) {
			JOptionPane.showMessageDialog(this, "当前行索引为--->" + index);
			number--;
			jLabel11.setText(number + "");
			int count = Integer.parseInt(tableModel.getValueAt(index, 5)
					.toString());
			double money = Double.parseDouble(tableModel.getValueAt(index, 4)
					.toString());

			double zongjine = Double.parseDouble(jLabel8.getText().trim());
			jLabel8
					.setText(NumberFormatUtil
							.format(zongjine - (count * money)));
			System.out.println("------>" + (count * money));
			// ----- 会员总价减去删除的商品价格
			double vipMoney = Double.parseDouble(tableModel
					.getValueAt(index, 6).toString());
			double vipZongjine = Double.parseDouble(jLabel18.getText().trim());
			jLabel18.setText(NumberFormatUtil.format(vipZongjine
					- (count * vipMoney)));
			tableModel.removeRow(index);

		}
		// 条形码检测
		if (e.getSource() == vid) {
			String tiaoxinma = vid.getText().trim();
			if (tiaoxinma.equals("")) {
				JOptionPane.showMessageDialog(this, "条形码不能为空！");
				return;
			}
			// 验证条形码是否存在
			if (!new GoodsDAO().checkGid(tiaoxinma)) {
				JOptionPane.showMessageDialog(this, "条形码不存在，请重新输入！");
				return;
			}
			// 向table中添加数据
			Object[] o = new Object[7];
			saleGoodBean g = new SaleDAO().SearchSaleGood(tiaoxinma);
			// 在插入table之前判断table中是否有该条数据
			int flag = 0;
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				if (g.getGid().equals(tableModel.getValueAt(i, 0))) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				JOptionPane.showMessageDialog(this, "该商品已经选择！");
				return;
			}
			o[0] = g.getGid();
			o[1] = g.getGName();
			o[2] = g.getGSpec();
			o[3] = g.getGuname();
			o[4] = g.getSalePrice();
			o[5] = g.getGAmount();
			o[6] = g.getVipPrice();
			tableModel.addRow(o);
			// 商品总数统计
			number++;
			jLabel11.setText(number + "");
			// 以前的金额+现在的金额
			jLabel8.setText(NumberFormatUtil.format(Double.parseDouble(jLabel8
					.getText().trim())
					+ g.getSalePrice()));
			jLabel18.setText(NumberFormatUtil.format(Double
					.parseDouble(jLabel18.getText().trim())
					+ g.getVipPrice()));

		}
		// 购买数量
		if (e.getSource() == count) {
			// 数量文本框的值
			int countNum = Integer.parseInt(count.getText().trim());
			int a = countNum
					+ Integer.parseInt(tableModel.getValueAt(index, 5)
							.toString());
			// 修改商品数量
			tableModel.setValueAt(a, index, 5);
			// 获取选择行的商品单价
			double temp = Double.parseDouble(tableModel.getValueAt(index, 4)
					.toString());
			// 获取目前的商品总价格
			double tempTotal = Double.parseDouble(jLabel8.getText().trim());
			jLabel8.setText(NumberFormatUtil.format((temp * countNum)
					+ tempTotal));

			// 计算相应的会员的商品总价格
			double viptemp = Double.parseDouble(tableModel.getValueAt(index, 6)
					.toString());
			double viptempTotal = Double.parseDouble(jLabel18.getText().trim());
			jLabel18.setText(NumberFormatUtil.format((viptemp * countNum)
					+ viptempTotal));
		}
		// 输入会员卡号显示会员信息
		if (e.getSource() == CardNumber) {
			String num = CardNumber.getText().trim();
			if (num.equals("")) {
				JOptionPane.showMessageDialog(this, "会员账号不能为空！！！");
				jButton2.setEnabled(false);
				return;
			}
			ShopVip v = new SaleDAO().SearchShopVip(num);
			if (v == null) {
				JOptionPane.showMessageDialog(this, "会员账号不存在！！！");
				CardNumber.setText("");
				jf.setText("");
				name.setText("");
				yue.setText("");
				jButton2.setEnabled(false);
				return;
			}
			jf.setText(v.getConsumeScore() + "");
			name.setText(v.getVName());
			yue.setText(NumberFormatUtil.format(v.getVBalance()));

			/** ********* 为交易成功更新数据库做准备 ******** */
			ConsumeSumI = v.getConsumeSum();
			ConsumeRateI = v.getConsumeRate();
			ConsumeCountI = v.getConsumeCount();

			shishou.setEditable(false);
			jButton2.setEnabled(true);
			JOptionPane.showMessageDialog(this, "会员享受优惠，金额为"
					+ jLabel18.getText().trim());
			jLabel8.setText(jLabel18.getText().trim());

		}
		// 会员结账
		if (e.getSource() == jButton2) {
			JOptionPane.showMessageDialog(this, "会员结账");
			String vipname = CardNumber.getText().trim();
			double onlymoney = Double.parseDouble(yue.getText().trim());
			// 商品的会员销售总价格
			double money = Double.parseDouble(jLabel18.getText().trim());
			// 如果会员余额少于购买的商品的总价，提醒交易失败
			if (onlymoney < money) {
				JOptionPane.showMessageDialog(this, "卡内余额不足，请联系管理员充值！或使用现金结账");
				shishou.setEditable(true);
				return;
			}
			double temp = onlymoney - money;
			// jLabel16.setText(temp+"");
			// 操作成功，修改数据库相关数据
			ConsumeCountI++;// 更新消费总次数
			money += ConsumeSumI;// 更新消费总金额
			int vipJiFen = Integer.parseInt(jf.getText().trim());
			System.out.println("积分--->" + vipJiFen);
			System.out.println("money--->" + money + "----ConsumeRateI"
					+ ConsumeRateI);
			System.out.println("2积分--->" + (money * ConsumeRateI));

			// 更新积分
			double ji = Double.parseDouble(jLabel18.getText().trim());
			vipJiFen = vipJiFen + (int) (ji * ConsumeRateI);

			ShopVip s = new ShopVip();
			s.setVId(CardNumber.getText().trim());
			s.setConsumeCount(ConsumeCountI);
			s.setConsumeSum((float) money);
			s.setConsumeScore(vipJiFen);
			s.setVBalance((float) temp);
			// 数据包装完毕，访问数据库更新数据

			if (saleDAO.updateSaleInfo(s)) {// 更新会员信息
				JOptionPane.showMessageDialog(this, "更新成功");
				// 会员流水号
				String vipVid = CardNumber.getText().trim();
				String STime = DateFormatUtil.dateFormat(new Date());
				int SCount = Integer.parseInt(jLabel11.getText().trim());
				String UID = Constant.uid;
				Sell sll = new Sell();
				sll.setVId(vipVid);
				sll.setSTime(STime);
				sll.setSCountPrice(Float.parseFloat(jLabel8.getText().trim()));
				sll.setUId(UID);
				sll.setSCount(SCount);
				if (saleDAO.saveSale(sll)) {
					JOptionPane.showMessageDialog(this, "销售记录添加成功");
					// 添加销售详单

					for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
						String gid = jTable1.getValueAt(i, 0).toString();
						int oneCount = Integer.parseInt(jTable1
								.getValueAt(i, 5).toString());
						float oneSaleMoney = Float.parseFloat(jTable1
								.getValueAt(i, 6).toString());
						SellDetail d = new SellDetail();
						d.setGId(gid);
						d.setSQuantity(oneCount);
						d.setSSalePrice(oneSaleMoney);
						if (saleDAO.saveSellDetail(d)) {
							JOptionPane.showMessageDialog(this, "OK");
						} else {
							JOptionPane.showMessageDialog(this, "error");
						}

					}
					return;
				}
				JOptionPane.showMessageDialog(this, "error");
			} else {
				JOptionPane.showMessageDialog(this, "更新失败");
				return;
			}

			JOptionPane.showMessageDialog(this, "交易操作成功！");

		}
		// 现金结账
		if (e.getSource() == jButton1) {
			JOptionPane.showMessageDialog(this, "现金结账");
			if (shishou.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "实收金额不能为空！");
				return;
			}
			float shishouMoney = Float.parseFloat(shishou.getText().trim());
			float yinshouMoney = Float.parseFloat(jLabel8.getText().trim());
			if (shishouMoney < yinshouMoney) {
				JOptionPane.showMessageDialog(this, "实收金额不能比商品价格小！");
				return;
			}
			jLabel16.setText(String.valueOf((shishouMoney - yinshouMoney)));
			/**
			 * 添加销售记录
			 */
			String vipVid ="";
			String STime = DateFormatUtil.dateFormat(new Date());
			int SCount = Integer.parseInt(jLabel11.getText().trim());
			String UID = Constant.uid;
			Sell sll = new Sell();
			sll.setVId(vipVid);
			sll.setSTime(STime);
			sll.setSCountPrice(Float.parseFloat(jLabel8.getText().trim()));
			sll.setUId(UID);
			sll.setSCount(SCount);
			if (saleDAO.saveSale(sll)) {
//				 添加销售清单记录
				for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
					String gid = jTable1.getValueAt(i, 0).toString();
					int oneCount = Integer.parseInt(jTable1.getValueAt(i, 5)
							.toString());
					float oneSaleMoney = Float.parseFloat(jTable1.getValueAt(i,4)
							.toString());
					SellDetail d = new SellDetail();
					d.setGId(gid);
					d.setSQuantity(oneCount);
					d.setSSalePrice(oneSaleMoney);
					if (saleDAO.saveSellDetail(d)) {
						JOptionPane.showMessageDialog(this, "OK");
					} else {
						JOptionPane.showMessageDialog(this, "error");
					}

				}
			}
			

			JOptionPane.showMessageDialog(this, "交易操作成功！");
		}

	}

	public void mouseClicked(MouseEvent e) {
		index = jTable1.getSelectedRow();// 获取当前行索引

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		triggerEvent(e);

	}

	public void mouseReleased(MouseEvent e) {
		triggerEvent(e);

	}

	public void triggerEvent(MouseEvent e) {
		if (e.isPopupTrigger()) {
			jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	// 会员结账
	public void vipAccount(double money) {

	}

	// 普通用户结账
	public void userAccount(double money) {

	}

	/**
	 * 隐藏表格中的某一列
	 * 
	 * @param table
	 *            表格
	 * @param index
	 *            要隐藏的列 的索引
	 */
	public void hideColumn(JTable table, int index) {

		TableColumn tc = table.getColumnModel().getColumn(index);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setMinWidth(0);
		tc.setWidth(0);

		table.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0);
	}
}
