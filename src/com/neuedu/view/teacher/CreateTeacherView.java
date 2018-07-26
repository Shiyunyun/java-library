package com.neuedu.view.teacher;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ClassesController;
import com.neuedu.controller.TeacherController;
import com.neuedu.entity.Teacher;
import com.neuedu.utils.StringUtils;
import com.neuedu.utils.ViewUtils;
import com.neuedu.view.ManageMain;

import junit.framework.TestFailure;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class CreateTeacherView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private TeacherController teacherController=new TeacherController();
	private ClassesController classesController=new ClassesController();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			CreateTeacherView dialog = new CreateTeacherView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public CreateTeacherView(ManageMain manageMain) {
		CreateTeacherView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateTeacherView.class.getResource("/images/logo.png")));
		setTitle("添加教师");
		setBounds(100, 100, 724, 631);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 720, 543);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel);
		JLabel label_5 = new JLabel("");
		label_5.setVisible(false);
		label_5.setFont(new Font("楷体", Font.PLAIN, 14));
		label_5.setBounds(275, 88, 300, 15);
		contentPanel.add(label_5);
		{
			textField = new JTextField();
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
				
					label_5.setVisible(false);
					String no=textField.getText();
					Teacher t=new Teacher();
					t.setNo(no);
					if(no.equals(teacherController.compare(t))){
						_this.setLabelAttr(label_5, "工号已被使用，请重新输入新的工号", Color.red);
						textField.setText("");
					}
				}
				@Override
				public void focusGained(FocusEvent e) {
					_this.setLabelAttr(label_5, "由英文字母、数字、@或_组成，长度4-16位", Color.GRAY);
				}
			});
			textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			textField.setBounds(275, 54, 300, 35);
			textField.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			passwordField.setBounds(275, 111, 300, 35);
		}
		contentPanel.setLayout(null);
		
		//label_4.setIcon(new ImageIcon(CreateManager.class.getResource("/images/bg.jpg")));
		{
			lblNewLabel = new JLabel("工  号");
			lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));
			lblNewLabel.setBounds(127, 54, 69, 35);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(textField);
		contentPanel.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setBounds(275, 168, 300, 35);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("密  码");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(127, 111, 69, 35);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("姓  名");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		label_1.setBounds(127, 168, 69, 35);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("手机号");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		label_2.setBounds(127, 226, 69, 35);
		contentPanel.add(label_2);
		
		JLabel label_4 = new JLabel("邮  箱");
		label_4.setFont(new Font("黑体", Font.BOLD, 20));
		label_4.setBounds(127, 281, 69, 35);
		contentPanel.add(label_4);
		
		JLabel label_3 = new JLabel("性  别");
		label_3.setFont(new Font("黑体", Font.BOLD, 20));
		label_3.setBounds(127, 390, 69, 35);
		contentPanel.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(275, 390, 200, 35);
		contentPanel.add(comboBox);
		
		JLabel lblQQ = new JLabel("Q    Q");
		lblQQ.setFont(new Font("黑体", Font.BOLD, 20));
		lblQQ.setBounds(127, 335, 69, 35);
		contentPanel.add(lblQQ);
		
		JLabel label_6 = new JLabel("职  位");
		label_6.setFont(new Font("黑体", Font.BOLD, 20));
		label_6.setBounds(129, 449, 69, 35);
		contentPanel.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(275, 226, 300, 35);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(275, 277, 300, 35);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(275, 335, 300, 35);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(275, 449, 300, 35);
		contentPanel.add(textField_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setBounds(0, 553, 720, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("保存");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//获取数据
						String no=textField.getText();
						String name=textField_1.getText();
						String password=new String(passwordField.getPassword());
						String mobile=textField_2.getText();
						String email=textField_3.getText();
						String qq=textField_4.getText();
						String job=textField_5.getText();
						String gender=(String) comboBox.getSelectedItem();
						
						//表单验证
						if(StringUtils.mathStr(no)&& StringUtils.mathStr(name)&&StringUtils.mathStr(password)){
							Teacher t=new Teacher(null,no,password,name,gender,mobile,qq,email,job);
							boolean flag=teacherController.create(t);
							if(flag){
								JOptionPane.showMessageDialog(_this, "保存成功！");
								_this.setVisible(false);
							}else{
								JOptionPane.showMessageDialog(_this, "保存失败，请稍后再试！");
							}
						}else{
							
							JOptionPane.showMessageDialog(_this, "请完善信息");
						}
					}
				});
				okButton.setFont(new Font("黑体", Font.PLAIN, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("重置");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
						passwordField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						comboBox.setSelectedItem("女");
					}
				});
				cancelButton.setFont(new Font("黑体", Font.PLAIN, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		// 设置窗体出现在屏幕中央
		ViewUtils.setWindowCenter(this);
	}
	
	/**
	 * 设置Label的属性
	 */
	public void setLabelAttr(JLabel label,String text,Color fontColor) {
		label.setVisible(true);
		label.setText(text);
		label.setForeground(fontColor);
		label.setBackground(fontColor);
	}
}
