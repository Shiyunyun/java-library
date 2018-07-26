package com.neuedu.view.student;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ClassesController;
import com.neuedu.controller.StudentController;
import com.neuedu.entity.Student;
import com.neuedu.utils.DateUtils;
import com.neuedu.utils.StringUtils;
import com.neuedu.utils.ViewUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class UpdateStudentView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private StudentController studentController=new StudentController();
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UpdateStudentView dialog = new UpdateStudentView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UpdateStudentView(String no) {
		UpdateStudentView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateStudentView.class.getResource("/images/logo.png")));
		setTitle("编辑学生");
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
		contentPanel.setLayout(null);
		
		//label_4.setIcon(new ImageIcon(CreateManager.class.getResource("/images/bg.jpg")));
		{
			lblNewLabel = new JLabel("学  号");
			lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));
			lblNewLabel.setBounds(127, 54, 69, 35);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setBounds(275, 168, 300, 35);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("姓  名");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(127, 111, 69, 35);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("学  校");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		label_1.setBounds(127, 168, 69, 35);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("专  业");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		label_2.setBounds(127, 226, 69, 35);
		contentPanel.add(label_2);
		
		JLabel label_4 = new JLabel("手机号");
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
		
		JLabel lblQQ = new JLabel("邮  箱");
		lblQQ.setFont(new Font("黑体", Font.BOLD, 20));
		lblQQ.setBounds(127, 335, 69, 35);
		contentPanel.add(lblQQ);
		
		JLabel label_6 = new JLabel("毕业时间");
		label_6.setFont(new Font("黑体", Font.BOLD, 20));
		label_6.setBounds(129, 449, 89, 35);
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
						String name = textField_7.getText();
						String mobile = textField_3.getText();
						String email = textField_4.getText();
						String school = textField_1.getText();
						String profession = textField_2.getText();
						
						String gender = (String) comboBox.getSelectedItem();
						int id=Integer.parseInt(textField_6.getText());
						
						Date graduation_date = null;
						try {
							graduation_date = DateUtils.toDate(textField_5.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						if(StringUtils.mathStr(name)){
							
							//更新数据
							Student t=new Student();
							t.setId(id);
							t.setEmail(email);
							t.setName(name);
							t.setGender(gender);
							t.setMobile(mobile);
							t.setSchool(school);
							t.setProfession(profession);
							t.setGraduation_date(graduation_date);
							boolean result = studentController.update(t);
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
						Student student=studentController.selectOne(no);
						textField_7.setText(student.getName());
						textField_3.setText(student.getMobile());
						textField_4.setText(student.getEmail());
						textField_1.setText(student.getSchool());
						textField_2.setText(student.getProfession());
						textField_5.setText(DateUtils.changerString(student.getGraduation_date()));
						comboBox.setSelectedItem(student.getGender());
						
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
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_7.setBounds(275, 113, 300, 38);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		//显示对应被选中的行的数据
		Student student=studentController.selectOne(no);
		textField.setText(no);
		textField_6.setText(student.getId()+"");
		textField_7.setText(student.getName());
		textField_1.setText(student.getSchool());
		textField_2.setText(student.getProfession());
		textField_3.setText(student.getMobile());
		textField_4.setText(student.getEmail());
		textField_5.setText(DateUtils.changerString(student.getGraduation_date()));
		comboBox.setSelectedItem(student.getGender());
		
		
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
