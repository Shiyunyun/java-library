package com.neuedu.view.teacher;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.TeacherController;
import com.neuedu.entity.Teacher;
import com.neuedu.utils.StringUtils;
import com.neuedu.utils.ViewUtils;
import com.neuedu.view.ManageMain;

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
import java.awt.Color;

public class UpdateTeacherView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private TeacherController teacherController = new TeacherController();
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UpdateTeacherView dialog = new UpdateTeacherView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UpdateTeacherView(String no) {
		UpdateTeacherView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateTeacherView.class.getResource("/images/logo.png")));
		setTitle("编辑教师");
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
			textField.setEditable(false);
			
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
						String name = textField_1.getText();
						String password = new String(passwordField.getPassword());
						String mobile = textField_2.getText();
						String email = textField_3.getText();
						String qq = textField_4.getText();
						String job = textField_5.getText();
						String gender = (String) comboBox.getSelectedItem();
						int id=Integer.parseInt(textField_6.getText());
						
						if(StringUtils.mathStr(name)){
							
							//更新数据
							Teacher t=new Teacher();
							t.setId(id);
							t.setEmail(email);
							t.setName(name);
							t.setGender(gender);
							t.setMobile(mobile);
							t.setJob(job);
							t.setPassword(password);
							t.setQq(qq);
							t.setNo(no);
							boolean result = teacherController.update(t);
							if(result) {
								JOptionPane.showMessageDialog(_this, "保存成功！");
								_this.setVisible(false);
								
							}else {
								JOptionPane.showMessageDialog(_this, "保存失败，请稍后再试！");
							}
							
						}else{
							JOptionPane.showMessageDialog(_this, "请输入名称","提示",JOptionPane.WARNING_MESSAGE);
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
						Teacher teacher=teacherController.selectOne(no);
						textField_1.setText(teacher.getName());
						textField_2.setText(teacher.getMobile());
						textField_3.setText(teacher.getEmail());
						textField_4.setText(teacher.getQq());
						textField_5.setText(teacher.getJob());
						passwordField.setText("");
						comboBox.setSelectedItem(teacher.getGender());
						
					}
				});
				cancelButton.setFont(new Font("黑体", Font.PLAIN, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setVisible(false);
		textField_6.setBounds(275, 23, 66, 21);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		//显示对应被选中的行的数据
		Teacher teacher=teacherController.selectOne(no);
		textField_6.setText(teacher.getId()+"");
		textField_1.setText(teacher.getName());
		textField_2.setText(teacher.getMobile());
		textField_3.setText(teacher.getEmail());
		textField_4.setText(teacher.getQq());
		textField_5.setText(teacher.getJob());
		comboBox.setSelectedItem(teacher.getGender());
		
		
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
