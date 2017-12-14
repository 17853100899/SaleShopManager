package com.tsinghua.saleshopmanager.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.tsinghua.saleshopmanager.dao.UserDAO;
import com.tsinghua.saleshopmanager.util.Constant;
import com.tsinghua.saleshopmanager.vo.SuperMarketUser;

/**
 * ��¼����
 */
public class Login extends javax.swing.JFrame implements ActionListener {

	private JLabel jLabel1;

	private JLabel jLabel2;
	// ����
	private JButton reset;
	// ��¼
	private JButton submit;
	// ���������
	private JPasswordField UPassword;
	// �ı����û��������
	private JTextField UId;

	private JLabel jLabel3;

	private SystemMain systemMain;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Login() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			// ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣����������Ӧ�ó����ͷ��˴�����ռ�õ���Դ��
			getContentPane().setLayout(null);
			this.setTitle("������������ϵͳ");
			this.setResizable(false);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("�û���¼");
				jLabel1.setBounds(164, 56, 224, 32);
				jLabel1.setBackground(new java.awt.Color(128, 128, 192));
				jLabel1.setFont(new java.awt.Font("����_GB2312", 0, 22));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("�˺ţ�");
				jLabel2.setBounds(122, 133, 42, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("���룺");
				jLabel3.setBounds(122, 187, 42, 15);
			}
			{
				UId = new JTextField();
				getContentPane().add(UId);
				UId.setBounds(192, 129, 174, 22);
				UId.setText("admin");

			}
			{
				UPassword = new JPasswordField();
				getContentPane().add(UPassword);
				UPassword.setBounds(192, 174, 174, 22);
				UPassword.setText("123");
			}
			{
				submit = new JButton();
				getContentPane().add(submit);
				submit.setText("��¼");
				submit.setBounds(159, 248, 74, 22);
				submit.addActionListener(this);
			}
			{
				reset = new JButton();
				getContentPane().add(reset);
				reset.setText("����");
				reset.setBounds(259, 248, 77, 22);
				reset.addActionListener(this);
			}
			pack();
			setSize(500, 400);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			String uid = UId.getText().trim();
			String upassword = UPassword.getText().trim();

			if (uid.equals("") || upassword.equals("")) {
				JOptionPane.showMessageDialog(this, "�û��������벻��Ϊ�գ�");
			} else {
				SuperMarketUser user = new UserDAO().checkUser(uid, upassword);
				if (user != null) {
					String urole = user.getURole();
					// ���û���Ϣ�����ڳ����з������ں�̨ҳ�����
					Constant.uid = uid;
					Constant.uname = user.getUName();
					Constant.upassword = upassword;
					Constant.urole = user.getURole();

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							systemMain = new SystemMain();
							systemMain.setLocationRelativeTo(null);
							systemMain.setVisible(true);
						}
					});
					this.dispose();

				} else {
					JOptionPane.showMessageDialog(this, "�û����������������������");
					UId.setText("");
					UPassword.setText("");
				}
			}

		}
		if (e.getSource() == reset) {
			UId.setText("");
			UPassword.setText("");
		}

	}

}
