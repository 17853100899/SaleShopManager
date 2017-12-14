package com.tsinghua.saleshopmanager.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tsinghua.saleshopmanager.dao.UserDAO;
import com.tsinghua.saleshopmanager.vo.SuperMarketUser;

public class SystemUserJPanel extends javax.swing.JPanel implements ActionListener, MouseListener {
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JTable jTable1;
	private DefaultTableModel tableModel;
	private SuperMarketUser user;
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	Vector<String> columnVector = new Vector<String>();
	private JButton jButton4;
	private JButton jButton3;
	private JPasswordField upassword;
	private JTextField uid;
	private JTextField uname;
	private JLabel jLabel4;
	private JComboBox jComboBox1;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private UserDAO userDAO = new UserDAO();
	private int index;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SystemUserJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public SystemUserJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(640, 404));
			this.setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(32, 12, 578, 227);
				{
					tableModel = new DefaultTableModel();
					columnVector = userDAO.getColoumn();
					vector = new UserDAO().getUsers();
					tableModel.setDataVector(vector, columnVector);

					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(tableModel);
					jTable1.addMouseListener(this);
				}
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("添加");
				jButton1.setBounds(170, 359, 63, 24);
				jButton1.addActionListener(this);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("真实姓名：");
				jLabel1.setBounds(108, 275, 67, 15);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("账号：");
				jLabel2.setBounds(343, 275, 52, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("密   码：");
				jLabel3.setBounds(108, 315, 62, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("角色：");
				jLabel4.setBounds(343, 315, 46, 15);
			}
			{
				ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(new String[] { "管理员", "收银员" });
				jComboBox1 = new JComboBox();
				this.add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(395, 311, 95, 22);
			}
			{
				uname = new JTextField();
				this.add(uname);
				uname.setBounds(187, 271, 125, 22);
			}
			{
				uid = new JTextField();
				this.add(uid);
				uid.setBounds(395, 271, 126, 22);
			}
			{
				upassword = new JPasswordField();
				this.add(upassword);
				upassword.setBounds(187, 311, 125, 22);
			}
			{
				jButton3 = new JButton();
				this.add(jButton3);
				jButton3.setText("修改");
				jButton3.setBounds(276, 360, 67, 22);
				jButton3.setEnabled(false);
				jButton3.addActionListener(this);
			}
			{
				jButton4 = new JButton();
				this.add(jButton4);
				jButton4.setText("删除");
				jButton4.setBounds(384, 360, 70, 22);
				jButton4.setEnabled(false);
				jButton4.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// 添加
		if (e.getSource() == jButton1) {
			String id = uid.getText().trim();
			String name = uname.getText().trim();
			String password = upassword.getText().trim();
			String role = ((String) jComboBox1.getSelectedItem()).trim();
			if (id.equals("") || name.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起，选项不能为空！");
				clear();
				return;
			}
			SuperMarketUser user = new SuperMarketUser();
			user.setUId(id);
			user.setUName(name);
			user.setUPassword(password);
			user.setURole(role);
			if (userDAO.saveUser(user)) {
				tableModel.setDataVector(userDAO.getUsers(), userDAO.getColoumn());
				clear();
			}
		}
		// 修改
		if (e.getSource() == jButton3) {
			String id = uid.getText().trim();
			String name = uname.getText().trim();
			String password = upassword.getText().trim();
			String role = ((String) jComboBox1.getSelectedItem()).trim();
			SuperMarketUser user = new SuperMarketUser();
			user.setUId(id);
			user.setUName(name);
			user.setUPassword(password);
			user.setURole(role);
			if (userDAO.updateUser(user)) {
				JOptionPane.showMessageDialog(this, "修改成功！");
				tableModel.setDataVector(userDAO.getUsers(), userDAO.getColoumn());
				clear();
			}

		}
		// 删除
		if (e.getSource() == jButton4) {
			String id = (String) tableModel.getValueAt(index, 1);
			SuperMarketUser user = new SuperMarketUser();
			user.setUId(id);
			if (userDAO.delUser(user)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				tableModel.setDataVector(userDAO.getUsers(), userDAO.getColoumn());
				uid.setEnabled(true);
				clear();
			}
		}

	}

	// 鼠标点击事件
	public void mouseClicked(MouseEvent e) {
		index = jTable1.getSelectedRow();// 获取当前点击行的索引
		// 判断鼠标是否点击在表格中
		if (index >= 0 && index < jTable1.getModel().getRowCount()) {

			jButton1.setEnabled(false);
			jButton3.setEnabled(true);
			jButton4.setEnabled(true);
			uid.setEnabled(false);

			uname.setText(jTable1.getValueAt(index, 0) + "");
			upassword.setText(jTable1.getValueAt(index, 2) + "");
			uid.setText(jTable1.getValueAt(index, 1) + "");
			jComboBox1.setSelectedItem(jTable1.getValueAt(index, 3) + "");

		} else {

			jButton1.setEnabled(true);
			jButton3.setEnabled(false);
			jButton4.setEnabled(false);
			uid.setEnabled(true);

			uname.setText("");
			upassword.setText("");
			uid.setText("");

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
		uid.setText("");
		uname.setText("");
		upassword.setText("");
		jComboBox1.setSelectedIndex(0);
	}

}
