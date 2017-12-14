package com.tsinghua.saleshopmanager.view.collect;

import com.tsinghua.saleshopmanager.dao.ToTalDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BusinessTotalJPanel extends javax.swing.JPanel implements ActionListener{
	private JButton jButton1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JTextField sale;
	private JTextField stock;
	private JLabel jLabel3;
	private JLabel jLabel1;
	private JTextField startTime;
	private JTextField endTime;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new BusinessTotalJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public BusinessTotalJPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(607, 300));
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("查询");
				jButton1.setBounds(468, 39, 83, 81);
				jButton1.addActionListener(this);
			}
			{
				endTime = new JTextField();
				this.add(endTime);
				endTime.setBounds(203, 103, 226, 22);
			}
			{
				startTime = new JTextField();
				this.add(startTime);
				startTime.setBounds(203, 47, 226, 22);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("结束时间：");
				jLabel2.setBounds(103, 110, 66, 15);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("开始时间：");
				jLabel1.setBounds(103, 51, 94, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("进货总金额");
				jLabel3.setBounds(134, 167, 80, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("销售总金额");
				jLabel4.setBounds(134, 206, 103, 15);
			}
			{
				stock = new JTextField();
				this.add(stock);
				stock.setBounds(245, 163, 155, 22);
				stock.setEditable(false);
			}
			{
				sale = new JTextField();
				this.add(sale);
				sale.setBounds(243, 202, 157, 22);
				sale.setEditable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jButton1) {
			String start=startTime.getText().trim();
			String end=endTime.getText().trim();
			if (start.equals("")||end.equals("")) {
				JOptionPane.showMessageDialog(this, "查询时间不能为空！");
				return;
			}
			if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}",start)||!Pattern.matches("\\d{4}-\\d{2}-\\d{2}",end)) {
				JOptionPane.showMessageDialog(this, "日期格式不正确！");
				return;
			}
			ArrayList<String> list=new ToTalDAO().getSaleTotal(start, end);
			stock.setText(list.get(0));
			sale.setText(list.get(1));
		}
		
	}

}
