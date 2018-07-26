package com.neuedu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.TeacherController;
import com.neuedu.entity.Teacher;
import com.neuedu.utils.JDBCUtils;
import com.neuedu.utils.JLabel2Image;
import com.neuedu.utils.StringUtils;
import com.neuedu.utils.ViewUtils;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private TeacherController teacherController=new TeacherController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		Login _this = this;
		setTitle("Neuedu教务管理系统");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(285, 177, 195, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 237, 195, 32);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登   陆");
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取用户输入的账号和密码
				String no=textField.getText();

				String password=new String(passwordField.getPassword());
				//表单验证
				if(StringUtils.mathStr(no) && StringUtils.mathStr(password)){
					Teacher t=new Teacher(no,password);
					t=teacherController.login(t);
					if(t !=null){
						//隐藏当前界面
						_this.setVisible(false);
						//打开管理界面
						ManageMain frame = new ManageMain(no);
						frame.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(_this, "请输入正确输入工号或密码！","警告",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		button.setBackground(Color.WHITE);
		button.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		button.setForeground(new Color(0, 102, 255));
		button.setBounds(515, 177, 95, 92);
		contentPane.add(button);
		
		JLabel2Image label_3 = new JLabel2Image(new ImageIcon(Login.class.getResource("/images/user.jpg")).getImage());
		label_3.setBounds(14, 91, 258, 265);
		contentPane.add(label_3);
		
		JLabel2Image label = new JLabel2Image(new ImageIcon(Login.class.getResource("/images/login.png")).getImage());
		label.setBounds(0, 0, 638, 453);
		contentPane.add(label);
		
		// 设置窗体出现在屏幕中央
		ViewUtils.setWindowCenter(this);
	}
}
