package com.neuedu.view.classes;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ClassesController;
import com.neuedu.controller.StudentController;
import com.neuedu.controller.TeacherController;
import com.neuedu.entity.Classes;
import com.neuedu.entity.Student;
import com.neuedu.entity.Teacher;
import com.neuedu.utils.DateUtils;
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
import java.sql.Date;
import java.text.ParseException;
import java.awt.Color;

public class CreateClassesView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ClassesController classesController=new ClassesController();
	private JTextField textField_6;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			CreateClassesView dialog = new CreateClassesView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public CreateClassesView(ManageMain manageMain) {
		CreateClassesView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateClassesView.class.getResource("/images/logo.png")));
		setTitle("添加班级");
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
					Integer id=null;
					if(StringUtils.mathStr(textField.getText())){
						
						 id=new Integer(textField.getText());
					}
					Classes c=new Classes();
					c.setId(id);
					
					if(id!=null&&id.equals(classesController.compare(c))){
						_this.setLabelAttr(label_5, "班号已被使用，请重新输入新的班号", Color.red);
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
		contentPanel.setLayout(null);
		
		//label_4.setIcon(new ImageIcon(CreateManager.class.getResource("/images/bg.jpg")));
		{
			lblNewLabel = new JLabel("班  号");
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
		
		JLabel label = new JLabel("班级名称");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(127, 111, 84, 35);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("教  室");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		label_1.setBounds(127, 168, 69, 35);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("学习方向");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		label_2.setBounds(127, 226, 84, 35);
		contentPanel.add(label_2);
		
		JLabel label_4 = new JLabel("开始日期");
		label_4.setFont(new Font("黑体", Font.BOLD, 20));
		label_4.setBounds(127, 281, 84, 35);
		contentPanel.add(label_4);
		
		JLabel lblQQ = new JLabel("结束日期");
		lblQQ.setFont(new Font("黑体", Font.BOLD, 20));
		lblQQ.setBounds(127, 335, 84, 35);
		contentPanel.add(lblQQ);
		
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
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_6.setBounds(275, 113, 300, 33);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("人  数");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(131, 408, 84, 35);
		contentPanel.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_5.setBounds(275, 408, 300, 35);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
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
						Integer id=new Integer(textField.getText());
						String name=textField_6.getText();
						String classroom=textField_1.getText();
						String study_direction =textField_2.getText();
						int count=0;
						if(StringUtils.mathStr(textField_5.getText())){
							
							 count=Integer.parseInt(textField_5.getText());
						}
						Date start_date=null;
						Date end_date=null;
						try {
							start_date = DateUtils.toDate(textField_3.getText());
							end_date = DateUtils.toDate(textField_4.getText());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//表单验证
						if(StringUtils.mathStr(id+"")&& StringUtils.mathStr(name)){
							Classes c=new Classes(id,name,start_date,end_date,study_direction,classroom,count);
							boolean flag=classesController.create(c);
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
						textField_6.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						
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
