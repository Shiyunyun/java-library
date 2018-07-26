package com.neuedu.view.classes;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neuedu.controller.ClassesController;
import com.neuedu.controller.StudentController;
import com.neuedu.entity.Classes;
import com.neuedu.entity.Student;
import com.neuedu.utils.DateUtils;
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
import java.sql.Date;
import java.text.ParseException;
import java.awt.Color;

public class UpdateClassestView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ClassesController classesController=new ClassesController();
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UpdateClassestView dialog = new UpdateClassestView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UpdateClassestView(Integer id) {
		UpdateClassestView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateClassestView.class.getResource("/images/logo.png")));
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
		label.setBounds(127, 111, 91, 35);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("教  室");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		label_1.setBounds(127, 168, 69, 35);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("学习方向");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		label_2.setBounds(127, 226, 91, 35);
		contentPanel.add(label_2);
		
		JLabel label_4 = new JLabel("开始日期");
		label_4.setFont(new Font("黑体", Font.BOLD, 20));
		label_4.setBounds(127, 281, 91, 35);
		contentPanel.add(label_4);
		
		JLabel lblQQ = new JLabel("结束日期");
		lblQQ.setFont(new Font("黑体", Font.BOLD, 20));
		lblQQ.setBounds(127, 335, 91, 35);
		contentPanel.add(lblQQ);
		
		JLabel label_6 = new JLabel("人  数 ");
		label_6.setFont(new Font("黑体", Font.BOLD, 20));
		label_6.setBounds(129, 400, 89, 35);
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
		textField_5.setBounds(275, 400, 300, 35);
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
						String classroom = textField_1.getText();
						String study_direction = textField_2.getText();
						Date start_date=null;
						Date end_date=null;
						try {
							start_date = DateUtils.toDate(textField_3.getText());
							end_date = DateUtils.toDate( textField_4.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						int count =0;
						if(StringUtils.mathStr(textField_5.getText())){
							count=Integer.parseInt(textField_5.getText());
						}
						int id=Integer.parseInt(textField.getText());
						
						
						if(StringUtils.mathStr(name)){
							
							//更新数据
							Classes t=new Classes();
							t.setId(id);
							t.setName(name);
							t.setStudy_direction(study_direction);
							t.setClassroom(classroom);
							t.setStart_date(start_date);
							t.setEnd_date(end_date);
							t.setCount(count);
							boolean result = classesController.update(t);
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
						Classes classes=classesController.selectId(id);
						textField_7.setText(classes.getName());
						textField_3.setText(DateUtils.changerString(classes.getStart_date()));
						textField_4.setText(DateUtils.changerString(classes.getEnd_date()));
						textField_1.setText(classes.getClassroom());
						textField_2.setText(classes.getStudy_direction());
						textField_5.setText(classes.getCount()+"");
						
					}
				});
				cancelButton.setFont(new Font("黑体", Font.PLAIN, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_7.setBounds(275, 113, 300, 38);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		//显示对应被选中的行的数据
		Classes classes=classesController.selectId(id);
		
		textField.setText(id+"");
		textField_7.setText(classes.getName());
		textField_1.setText(classes.getClassroom());
		textField_2.setText(classes.getStudy_direction());
		textField_3.setText(DateUtils.changerString(classes.getStart_date()));
		textField_4.setText(DateUtils.changerString(classes.getEnd_date()));
		textField_5.setText(classes.getCount()+"");
		
		
		
		
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
