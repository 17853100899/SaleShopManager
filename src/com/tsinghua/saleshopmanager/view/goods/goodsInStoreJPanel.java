package com.tsinghua.saleshopmanager.view.goods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.GoodsDAO;
import com.tsinghua.saleshopmanager.dao.GoodsPrivoderDAO;
import com.tsinghua.saleshopmanager.dao.GoodsUnitDAO;
import com.tsinghua.saleshopmanager.vo.Goods;
import com.tsinghua.saleshopmanager.vo.InStore;

public class goodsInStoreJPanel extends javax.swing.JPanel implements ActionListener {
	private JLabel jLabel1;

	private JLabel jLabel2;

	private JLabel jLabel4;
	private JTextField PurchasePrice;
	private JLabel jLabel13;
	private JTextField InStoreAmount;
	private JLabel jLabel12;
	private JTextField jTextField1;

	private JButton jButton2;

	private JButton jButton1;

	private JTextField GMinNumber;

	private JTextField VipPrice;

	private JTextField SalePrice;

	private JTextField GAmount;

	private JComboBox gpname;

	private JComboBox guname;

	private JTextField GSpec;

	private JComboBox CName;

	private JTextField GName;

	private JLabel jLabel8;

	private JTextField GId;

	private JTextField InStoreId;

	private JLabel jLabel11;

	private JLabel jLabel10;

	private JLabel jLabel9;

	private JLabel jLabel7;

	private JLabel jLabel6;

	private JLabel jLabel5;

	private JLabel jLabel3;

	private Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	private Hashtable<Integer, String> goodsClassHt = new Hashtable<Integer, String>();

	private Hashtable<Integer, String> goodsPrivoderHt = new Hashtable<Integer, String>();

	private GoodsDAO goodsdao;

	int state = 0;// 标志（如果无该商品：0 有该商品：1）

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new goodsInStoreJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public goodsInStoreJPanel() {
		super();
		if (goodsdao == null) {
			goodsdao = new GoodsDAO();
		}
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(599, 393));
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("流水号：");
				jLabel1.setBounds(57, 254, 84, 15);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("条形码：");
				jLabel2.setBounds(68, 33, 78, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("商品名称：");
				jLabel3.setBounds(284, 33, 87, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("商品规格：");
				jLabel4.setBounds(55, 117, 108, 15);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("商品类别：");
				jLabel5.setBounds(62, 75, 97, 15);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("供货商名称：");
				jLabel6.setBounds(283, 254, 99, 15);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("商品单位：");
				jLabel7.setBounds(284, 75, 106, 15);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("销售价：");
				jLabel8.setBounds(68, 159, 102, 15);
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("会员价：");
				jLabel9.setBounds(61, 193, 96, 15);
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("库存数量：");
				jLabel10.setBounds(283, 120, 107, 15);
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("报警数：");
				jLabel11.setBounds(283, 162, 62, 15);
			}
			{
				InStoreId = new JTextField();
				this.add(InStoreId);
				InStoreId.setText(new GoodsDAO().createInStoreId());
				InStoreId.setBounds(135, 250, 128, 22);
				InStoreId.setEditable(false);

			}
			{
				GId = new JTextField();
				this.add(GId);
				GId.setBounds(132, 29, 131, 22);
				GId.addActionListener(this);
			}
			{
				GName = new JTextField();
				this.add(GName);
				GName.setBounds(362, 26, 141, 22);
			}
			{
				Vector<String> v = getGoodsClass();
				CName = new JComboBox(v);
				this.add(CName);

				CName.setBounds(133, 71, 128, 22);
				CName.setEditable(true);
			}
			{
				GSpec = new JTextField();
				this.add(GSpec);
				GSpec.setBounds(134, 116, 128, 22);
			}
			{
				Vector<String> v = getGoodsUnit();
				guname = new JComboBox(v);
				this.add(guname);
				guname.setBounds(362, 68, 139, 22);
				guname.setEditable(true);
			}
			{
				Vector<String> v = getGoodsPrivoder();
				gpname = new JComboBox(v);
				this.add(gpname);
				gpname.setBounds(369, 247, 126, 22);
			}
			{
				GAmount = new JTextField();
				this.add(GAmount);
				GAmount.setBounds(364, 113, 58, 22);
			}
			{
				SalePrice = new JTextField();
				this.add(SalePrice);
				SalePrice.setBounds(135, 155, 63, 22);
			}
			{
				VipPrice = new JTextField();
				this.add(VipPrice);
				VipPrice.setBounds(133, 193, 65, 22);
			}
			{
				GMinNumber = new JTextField();
				this.add(GMinNumber);
				GMinNumber.setBounds(364, 158, 58, 22);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("入库");
				jButton1.setBounds(157, 335, 92, 36);
				jButton1.setEnabled(false);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("重置");
				jButton2.setBounds(328, 335, 83, 36);
				jButton2.addActionListener(this);
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setBounds(23, 227, 557, 3);
				jTextField1.setEditable(false);
				jTextField1.setBackground(new java.awt.Color(0, 0, 255));
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setText("进货数量：");
				jLabel12.setBounds(45, 298, 71, 15);
			}
			{
				InStoreAmount = new JTextField();
				this.add(InStoreAmount);
				InStoreAmount.setBounds(135, 294, 69, 22);
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setText("进货价格：");
				jLabel13.setBounds(296, 294, 73, 15);
			}
			{
				PurchasePrice = new JTextField();
				this.add(PurchasePrice);
				PurchasePrice.setBounds(375, 290, 58, 22);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取商品单位
	public Vector<String> getGoodsUnit() {
		Vector<String> vector = new Vector<String>();
		ht = new GoodsUnitDAO().getGoodsUnitForCombox();
		Enumeration<Integer> eu = ht.keys();
		while (eu.hasMoreElements()) {
			int index = eu.nextElement();
			vector.add(ht.get(index));
		}
		return vector;
	}

	// 获取商品类别
	public Vector<String> getGoodsClass() {
		Vector<String> vector = new Vector<String>();
		goodsClassHt = new GoodsDAO().getGoodsClassForCombox();
		Enumeration<Integer> eu = goodsClassHt.keys();
		while (eu.hasMoreElements()) {
			int index = eu.nextElement();
			vector.add(goodsClassHt.get(index));
		}
		return vector;
	}

	// 获取商品供应商信息
	public Vector<String> getGoodsPrivoder() {
		Vector<String> vector = new Vector<String>();
		goodsPrivoderHt = new GoodsPrivoderDAO().getGoodsPrivoderForCombox();
		Enumeration<Integer> eu = goodsPrivoderHt.keys();
		while (eu.hasMoreElements()) {
			int index = eu.nextElement();
			vector.add(goodsPrivoderHt.get(index));
		}
		return vector;
	}

	public void actionPerformed(ActionEvent e) {
		// 输入条形码回车事件
		if (e.getSource() == GId) {
			String gid = GId.getText().trim();
			if (gid.equals("")) {
				JOptionPane.showMessageDialog(this, "条形码不能为空！");
			} else {
				jButton1.setEnabled(true);
				// 说明商品表中存在该商品
				if (goodsdao.checkGid(gid)) {
					// 处理修改库存的逻辑,其他控件不允许编辑
					state = 1;// 用作入库时的操作判断
					Goods g = goodsdao.searchGoods(gid);
					// 将商品信息填充到控件中
					GName.setText(g.getGName());
					GSpec.setText(g.getGSpec());
					SalePrice.setText(String.valueOf(g.getSalePrice()));
					GAmount.setText(String.valueOf(g.getGAmount()));
					VipPrice.setText(String.valueOf(g.getVipPrice()));
					GMinNumber.setText(String.valueOf(g.getGMinNumber()));
					// 根据ID在hashtable中查找对应的值
					guname.setSelectedItem(ht.get(g.getGUId()));
					CName.setSelectedItem(goodsClassHt.get(g.getCid()));

					// 屏蔽控件，不允许修改
					GId.setEnabled(false);
					CName.setEnabled(false);
					GSpec.setEnabled(false);
					guname.setEnabled(false);
					SalePrice.setEnabled(false);
					VipPrice.setEnabled(false);
					GMinNumber.setEnabled(false);
					GName.setEnabled(false);
					GAmount.setEnabled(false);

				}

			}
		}
		// 入库操作
		if (e.getSource() == jButton1) {
			JOptionPane.showMessageDialog(this, "+++++++++++++");

			/************** 进货单 ***********************/
			String goodsInStoreId = InStoreId.getText().trim();
			float inSPurchaseprice = Float.valueOf(PurchasePrice.getText().trim());
			int inStoreAmount = Integer.valueOf(InStoreAmount.getText().trim());
			System.out.println(inStoreAmount + "--------------");
			JOptionPane.showMessageDialog(this, inStoreAmount + "");
			// 拿到商品供应商的ID
			int goodPrivoerIndex = 0;// 商品供应商ID
			String bbb = gpname.getSelectedItem().toString();
			System.out.println(bbb + "*********");
			if (goodsPrivoderHt.contains(bbb)) {
				Enumeration<Integer> en = goodsPrivoderHt.keys();
				while (en.hasMoreElements()) {
					goodPrivoerIndex = (int) en.nextElement();
					if (goodsPrivoderHt.get(goodPrivoerIndex).equals(bbb)) {
						break;
					}
				}
			}
			/************** 商品信息 ********** *********/

			String goodsGId = GId.getText().trim();
			String goodsGpname = GName.getText().trim();
			String goodsGSpec = GSpec.getText().trim();
			int goodamout = Integer.valueOf(GAmount.getText().trim());

			float goodsSale = Float.valueOf(SalePrice.getText().trim());
			float goodsVipPrice = Float.valueOf(VipPrice.getText().trim());
			int goodsMin = Integer.valueOf(GMinNumber.getText().trim());

			// 拿到商品类别ID
			String aaa = CName.getSelectedItem().toString();
			int goodsClassindex = 0;// 商品类别ID
			if (goodsClassHt.contains(aaa)) {
				Enumeration<Integer> en = goodsClassHt.keys();
				while (en.hasMoreElements()) {
					goodsClassindex = (int) en.nextElement();
					if (goodsClassHt.get(goodsClassindex).equals(aaa)) {
						break;
					}
				}
			}
			// 拿到商品单位的ID
			int goodUnitIndex = 0;// 商品单位的ID
			String ccc = guname.getSelectedItem().toString();
			System.out.println(ccc + "*********");
			if (ht.contains(ccc)) {
				Enumeration<Integer> en = ht.keys();
				while (en.hasMoreElements()) {
					goodUnitIndex = (int) en.nextElement();
					if (ht.get(goodUnitIndex).equals(ccc)) {
						break;
					}
				}
			}
			/***************** 数据准备完毕 ********************/

			if (state == 1) {
				// 条形码对应的商品存在，1。修改商品库存 2。添加进货单信息
				if (goodsdao.updateGAmount(goodsGId, inStoreAmount)) {
					InStore iStore = new InStore();
					iStore.setInStoreId(goodsInStoreId);
					iStore.setGid(goodsGId);
					iStore.setGpid(goodPrivoerIndex);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ss = sdf.format(new Date());
					iStore.setInStoreTime(ss);
					iStore.setPurchasePrice(inSPurchaseprice);
					iStore.setInStoreAmount(inStoreAmount);
					if (goodsdao.saveInStore(iStore)) {
						JOptionPane.showMessageDialog(this, "入库单添加成功");
					}
				}

			} else {// 先添加商品，后添加入库记录
				/*** 开始添加商品 ****/
				if (goodsGpname.equals("")) {
					JOptionPane.showMessageDialog(this, "商品名称不能为空");
					return;
				}
				Goods goods = new Goods();
				goods.setGid(goodsGId);
				goods.setGName(goodsGpname);
				goods.setGAmount(goodamout);
				goods.setGSpec(goodsGSpec);
				goods.setGMinNumber(goodsMin);
				goods.setSalePrice(goodsSale);
				goods.setVipPrice(goodsVipPrice);
				goods.setGUId(goodUnitIndex);
				goods.setCid(goodsClassindex);
				if (goodsdao.saveGoods(goods)) {
					JOptionPane.showMessageDialog(this, "添加成功！");
					clear();

				} else {
					JOptionPane.showMessageDialog(this, "该商品已存在，添加失败");
					clear();

				}
				/**** end ************/
				/*** 开始添加入库记录 ***/
				InStore iStore = new InStore();
				iStore.setInStoreId(goodsInStoreId);
				iStore.setGid(goodsGId);
				iStore.setGpid(goodPrivoerIndex);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ss = sdf.format(new Date());
				iStore.setInStoreTime(ss);
				iStore.setPurchasePrice(inSPurchaseprice);
				iStore.setInStoreAmount(inStoreAmount);
				if (goodsdao.saveInStore(iStore)) {
					JOptionPane.showMessageDialog(this, "入库单添加成功");
				}
				/**** end *************/
			}
		}
		// 重置
		if (e.getSource() == jButton2) {

			clear();

		}

	}

	// 启用控件和清空
	public void clear() {
		CName.setEnabled(true);
		GSpec.setEnabled(true);
		guname.setEnabled(true);
		gpname.setEnabled(true);
		SalePrice.setEnabled(true);
		VipPrice.setEnabled(true);
		GMinNumber.setEnabled(true);
		GId.setEnabled(true);
		GAmount.setEnabled(true);
		GName.setEnabled(true);

		GMinNumber.setText("");
		GSpec.setText("");
		SalePrice.setText("");
		GAmount.setText("");
		VipPrice.setText("");
		GId.setText("");
		GName.setText("");
		CName.setSelectedIndex(0);
		guname.setSelectedIndex(0);
		gpname.setSelectedIndex(0);
		InStoreAmount.setText("");
		PurchasePrice.setText("");
	}

}
