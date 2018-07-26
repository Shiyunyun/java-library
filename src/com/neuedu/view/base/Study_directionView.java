package com.neuedu.view.base;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Rectangle;

public class Study_directionView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ClassesController classesController=new ClassesController();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	/*	try {
			Study_directionView dialog = new Study_directionView(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * Create the dialog.
	 */
	public Study_directionView(ManageMain manageMain) {
		Study_directionView _this = this;
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Study_directionView.class.getResource("/images/logo.png")));
		setTitle("学习方向");
		setBounds(100, 100, 724, 631);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 720, 543);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane= new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		table.setFillsViewportHeight(true);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));
		table.setRowHeight(25);
		
		scrollPane.setViewportView(table);
		
		// 设置窗体出现在屏幕中央
		ViewUtils.setWindowCenter(this);
		
		//刷新表格
		this.flushTable();
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
	
	public  void flushTable(){
		List<Classes> list=classesController.selectAll();
		Set<String> study_direction=new HashSet<String>();
		for(int i=0;i<list.size();i++){
				study_direction.add(list.get(i).getStudy_direction());
		}
		Object[] clas=study_direction.toArray();
		Object[][] obj=new Object[study_direction.size()][1];

		for(int i=0;i<obj.length;i++){
				
			obj[i][0]=clas[i];
		}
		
		table.setModel(new DefaultTableModel(
		obj,
		new String[] {
			"\u5B66\u4E60\u65B9\u5411"
		}
	));
	}
}
