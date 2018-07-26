package com.neuedu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.neuedu.controller.ClassesController;
import com.neuedu.controller.StudentController;
import com.neuedu.controller.TeacherController;
import com.neuedu.entity.Classes;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;
import com.neuedu.entity.Teacher;
import com.neuedu.utils.JLabel2Image;
import com.neuedu.utils.ManageMainUtils;
import com.neuedu.utils.StringUtils;
import com.neuedu.utils.ViewUtils;
import com.neuedu.view.base.CLassroomView;
import com.neuedu.view.base.JobView;
import com.neuedu.view.base.Study_directionView;
import com.neuedu.view.classes.CreateClassesView;
import com.neuedu.view.classes.UpdateClassestView;
import com.neuedu.view.student.CreateStudentView;
import com.neuedu.view.student.UpdateStudentView;
import com.neuedu.view.teacher.CreateTeacherView;
import com.neuedu.view.teacher.UpdateTeacherView;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Panel;
import javax.swing.BoxLayout;

public class ManageMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private TeacherController teacherController = new TeacherController();
	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private StudentController studentController = new StudentController();
	private ClassesController classesController=new ClassesController();
	private int page=1;
	private int pageSize=5;
	private int total;
	private int allpage;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_2;
	private JButton btnNewButton;
	private JButton button_5;
	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMain frame = new ManageMain(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * 新建当前界面，并显示
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMain frame = new ManageMain(null);
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
	public ManageMain(String no) {
		ManageMain _this = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManageMain.class.getResource("/images/logo.png")));
		
		setTitle("Neuedu教务管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 569);
		CardLayout cardLayout = new CardLayout(0, 0);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 0, 10, 10));
		menuBar.setFont(new Font("隶书", Font.PLAIN, 18));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("教务管理");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("黑体", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("教师管理");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, ManageMainUtils.cardlayout_name_teacher);
				
				
				//查询数据
				flushTeacher(no);
				
			}
		});
		
		JMenuItem menuItem = new JMenuItem("学生管理");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, ManageMainUtils.cardlayout_name_student);
				
				flushStudent();
				
			}
		});
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(menuItem);
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("班级管理");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO班级管理
				cardLayout.show(contentPane, ManageMainUtils.cardlayout_name_classes);
				
				flushClasses();
			}
		});
		menuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(menuItem_2);
		
		JMenu menu = new JMenu("基础信息");
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("黑体", Font.PLAIN, 16));
		menuBar.add(menu);
		
		JMenuItem menuItem_5 = new JMenuItem("机构教室");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CLassroomView dialog = new CLassroomView(_this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menu.add(menuItem_5);
		
		JMenuItem menuItem_4 = new JMenuItem("教室岗位");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JobView dialog = new JobView(_this);
		 	
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menu.add(menuItem_4);
		
		JMenuItem menuItem_3 = new JMenuItem("学习方向");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Study_directionView dialog = new Study_directionView(_this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("设置");
		menu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menu_1.setFont(new Font("黑体", Font.PLAIN, 16));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("个人资料");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Teacher> teaList=teacherController.selectAll();
				
				for(int i=0;i<teaList.size();i++){
					if(teaList.get(i).getNo().equals(no)){
						
						UpdateTeacherView dialog = new UpdateTeacherView(no);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						
					}
					
				}
				
			}
		});
		menuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_6 = new JMenuItem("修改密码");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Teacher> teaList=teacherController.selectAll();
				String password=null;
				Integer id=null;
				for(int i=0;i<teaList.size();i++){
					if(teaList.get(i).getNo().equals(no)){
						id=teaList.get(i).getId();
						password=JOptionPane.showInputDialog(_this,"请输入密码");
						System.out.println(password);
					}
				}
				
				Teacher t=new Teacher();
				t.setId(id);
				t.setPassword(password);
				boolean result=teacherController.update(t);
				if(result && password!=null){
					JOptionPane.showMessageDialog(_this, "修改成功！！");
				}else if(password==null){
					
				}else {
					JOptionPane.showMessageDialog(_this, "保存失败，请稍后再试！");
				}
				
			}
		});
		
		
		
		menuItem_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menu_1.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(cardLayout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, "name_420232211233185");
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_363152522411851");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		
		//给卡片布局管理器注册卡片
		cardLayout.addLayoutComponent(panel_2, ManageMainUtils.cardlayout_name_main);//主界面
		
		JLabel lblneuedu = new JLabel("欢迎使用Neuedu教务管理系统！");
		lblneuedu.setVerticalAlignment(SwingConstants.TOP);
		lblneuedu.setHorizontalAlignment(SwingConstants.CENTER);
		lblneuedu.setForeground(new Color(0, 0, 153));
		lblneuedu.setFont(new Font("叶根友毛笔行书2.0版", Font.PLAIN, 30));
		lblneuedu.setBounds(0, 0, 514, 99);
		ViewUtils.setWindowCenter(lblneuedu);
		panel_2.add(lblneuedu);
		cardLayout.addLayoutComponent(panel, ManageMainUtils.cardlayout_name_teacher);//管理员管理
		
		
		btnNewButton = new JButton("添加");
		btnNewButton.setEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(ManageMain.class.getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//显示添加页面
				CreateTeacherView dialog = new CreateTeacherView(null);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				//刷新表格
				flushTeacher(no);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(70, 130, 180));
		
		JButton button = new JButton("编辑");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获得选中的那行记录的数据（关键数据）
				int row = table.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(_this, "请选中数据再编辑！", "提示",JOptionPane.WARNING_MESSAGE);
				}else {
					String selectedNo = (String) table.getValueAt(row, 1);
					
					//打开编辑界面
					if(selectedNo.equals(no) || no.equals("admin")){
						UpdateTeacherView dialog = new UpdateTeacherView(selectedNo);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(_this, "对不起，您没有修改其他老师的信息","提示",JOptionPane.WARNING_MESSAGE);
					}
					
					flushTeacher(no);
				}
				
			}
		});
		button.setFocusPainted(false);
		button.setIcon(new ImageIcon(ManageMain.class.getResource("/images/edit.png")));
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.setBackground(new Color(70, 130, 180));
		panel_1.add(button);
		
		button_5 = new JButton("删除");
		button_5.setEnabled(false);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获得选中的工号
				int row = table.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(_this, "请选中数据再操作！", "提示",JOptionPane.WARNING_MESSAGE);
				}else {
					//提醒：确认删除
					int op = JOptionPane.showConfirmDialog(_this, "确定删除？", "提示", JOptionPane.WARNING_MESSAGE);
					String no = (String) table.getValueAt(row, 1);
					if(op==0) {
						//进行删除
						boolean result = teacherController.delete(no);
						if(result) {
							//查询数据
							flushTeacher(no);
						}
					}
				}
				
			}
		});
		button_5.setIcon(new ImageIcon(ManageMain.class.getResource("/images/delete.png")));
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_5.setFocusPainted(false);
		button_5.setBackground(new Color(70, 130, 180));
		panel_1.add(button_5);
		
		//显示登录系统人的名称
		List<Teacher> list=teacherController.selectAll();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNo().equals(no)){
				String name=list.get(i).getName();
				JOptionPane.showMessageDialog(_this, "欢迎"+name+"登录系统","提示",JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
		
		
		//设置权限：只有管理人才能增加和删除教师表的信息
		if(no.equals("admin")){
			btnNewButton.setEnabled(true);
			button_5.setEnabled(true);
		}
		
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setRollover(true);
		toolBar_1.setBackground(Color.LIGHT_GRAY);
		toolBar_1.setBorder(null);
		toolBar_1.setFloatable(false);
		toolBar_1.setToolTipText("");
		panel_1.add(toolBar_1);
		
		JLabel label = new JLabel("工号：");
		label.setBackground(Color.LIGHT_GRAY);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_1.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		toolBar_1.add(textField);
		textField.setColumns(15);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setBorder(null);
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setToolTipText("");
		toolBar.setFloatable(false);
		panel_1.add(toolBar);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		toolBar.add(textField_1);
		textField_1.setColumns(15);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setBorder(null);
		toolBar_2.setBackground(Color.LIGHT_GRAY);
		toolBar_2.setFloatable(false);
		panel_1.add(toolBar_2);
		
		JLabel lblNewLabel = new JLabel("手机号：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_2.add(lblNewLabel);
		
		textField_2 = new JTextField();
		toolBar_2.add(textField_2);
		textField_2.setColumns(15);
		
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setBorder(null);
		toolBar_3.setBackground(Color.LIGHT_GRAY);
		toolBar_3.setFloatable(false);
		panel_1.add(toolBar_3);
		
		JLabel label_2 = new JLabel("性别：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_3.add(label_2);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "男", "女"}));
		comboBox.setSelectedIndex(0);
		toolBar_3.add(comboBox);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page=1;
				
				flushTeacher(no);
				
			}
		});
		
		button_1.setFocusPainted(false);
		button_1.setBackground(new Color(70, 130, 180));
		button_1.setForeground(Color.WHITE);
		button_1.setIcon(new ImageIcon(ManageMain.class.getResource("/images/search.png")));
		panel_1.add(button_1);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		//panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1}));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_4 = new JToolBar();
		toolBar_4.setRollover(true);
		panel_3.add(toolBar_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("首    页");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=1;
				flushTeacher(no);
			}
		});
		toolBar_4.add(btnNewButton_1);
		
		javax.swing.JButton button_2 = new javax.swing.JButton("New button");
		JButton btnNewButton_2 = new JButton("上一页");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page--;
				if(page<1){
					page=1;
				}
				flushTeacher(no);
			}
		});
		toolBar_4.add(btnNewButton_2);
		
		JButton button_3 = new JButton("下一页");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page++;
				if(page>allpage){
					page=allpage;
				}
				flushTeacher(no);
			}
		});
		toolBar_4.add(button_3);
		
		JButton button_4 = new JButton("尾    页");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=allpage;
				flushTeacher(no);
			}
		});
		toolBar_4.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "name_159489014464418");
		panel_4.setLayout(new BorderLayout(0, 0));
		//把第三个卡片注册到卡片式布局管理器
		cardLayout.addLayoutComponent(panel_4, ManageMainUtils.cardlayout_name_student);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		
		JButton button_6 = new JButton("添加");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateStudentView dialog = new CreateStudentView(_this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				//刷新表格
				flushStudent();
			}
		});
		button_6.setIcon(new ImageIcon(ManageMain.class.getResource("/images/add.png")));
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_6.setFocusPainted(false);
		button_6.setBackground(new Color(70, 130, 180));
		panel_5.add(button_6);
		
		JButton button_7 = new JButton("编辑");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table_1.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(_this, "请选中一行数据编辑！", "提示",JOptionPane.WARNING_MESSAGE);
				}else {
					String no = (String) table_1.getValueAt(row, 1);
					
					//打开编辑界面
					UpdateStudentView dialog = new UpdateStudentView(no);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
					flushStudent();
				}
			}
		});
		button_7.setIcon(new ImageIcon(ManageMain.class.getResource("/images/edit.png")));
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_7.setFocusPainted(false);
		button_7.setBackground(new Color(70, 130, 180));
		panel_5.add(button_7);
		
		JButton button_8 = new JButton("删除");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int row = table_1.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(_this, "请选中数据再操作！", "提示",JOptionPane.WARNING_MESSAGE);
				}else {
					
					int op = JOptionPane.showConfirmDialog(_this, "确定删除？", "提示", JOptionPane.WARNING_MESSAGE);
					String no = (String) table_1.getValueAt(row, 1);
					if(op==0) {
						boolean result = studentController.delete(no);
						if(result) {
							
							flushStudent();
						}
					}
				}
			}
		});
		button_8.setIcon(new ImageIcon(ManageMain.class.getResource("/images/delete.png")));
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_8.setFocusPainted(false);
		button_8.setBackground(new Color(70, 130, 180));
		panel_5.add(button_8);
		
		JToolBar toolBar_5 = new JToolBar();
		toolBar_5.setToolTipText("");
		toolBar_5.setRollover(true);
		toolBar_5.setFloatable(false);
		toolBar_5.setBorder(null);
		toolBar_5.setBackground(Color.LIGHT_GRAY);
		panel_5.add(toolBar_5);
		
		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_5.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		toolBar_5.add(textField_3);
		textField_3.setColumns(15);
		
		JToolBar toolBar_6 = new JToolBar();
		toolBar_6.setToolTipText("");
		toolBar_6.setRollover(true);
		toolBar_6.setFloatable(false);
		toolBar_6.setBorder(null);
		toolBar_6.setBackground(Color.LIGHT_GRAY);
		panel_5.add(toolBar_6);
		
		JLabel lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_6.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 18));
		toolBar_6.add(textField_4);
		textField_4.setColumns(15);
		
		JToolBar toolBar_7 = new JToolBar();
		toolBar_7.setFloatable(false);
		toolBar_7.setBorder(null);
		toolBar_7.setBackground(Color.LIGHT_GRAY);
		panel_5.add(toolBar_7);
		
		JLabel lblNewLabel_3 = new JLabel("学校：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_7.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 18));
		toolBar_7.add(textField_5);
		textField_5.setColumns(15);
		
		JToolBar toolBar_8 = new JToolBar();
		toolBar_8.setFloatable(false);
		toolBar_8.setBorder(null);
		toolBar_8.setBackground(Color.LIGHT_GRAY);
		panel_5.add(toolBar_8);
		
		JLabel lblNewLabel_4 = new JLabel("性别：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_8.add(lblNewLabel_4);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "男", "女"}));
		toolBar_8.add(comboBox_1);
		
		JButton button_9 = new JButton("查询");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=1;
				
				flushStudent();
				
				
			}
		});
		button_9.setIcon(new ImageIcon(ManageMain.class.getResource("/images/search.png")));
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_9.setFocusPainted(false);
		button_9.setBackground(new Color(70, 130, 180));
		panel_5.add(button_9);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		table_1.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));
		table_1.setRowHeight(25);
		
		scrollPane_1.setViewportView(table_1);
		
		JToolBar toolBar_9 = new JToolBar();
		toolBar_9.setRollover(true);
		panel_6.add(toolBar_9, BorderLayout.SOUTH);
		
		JButton button_10 = new JButton("首    页");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=1;
				flushStudent();
			}
		});
		toolBar_9.add(button_10);
		
		JButton button_11 = new JButton("上一页");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page--;
				if(page<1){
					page=1;
				}
				flushStudent();
			}
		});
		toolBar_9.add(button_11);
		
		JButton button_12 = new JButton("下一页");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page++;
				if(page>allpage){
					page=allpage;
				}
				flushStudent();
			}
		});
		toolBar_9.add(button_12);
		
		JButton button_13 = new JButton("尾    页");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=allpage;
				
				flushStudent();
			}
		});
		toolBar_9.add(button_13);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, "name_4884841766633");
		panel_7.setLayout(new BorderLayout(0, 0));
		
		
		cardLayout.addLayoutComponent(panel_7, ManageMainUtils.cardlayout_name_classes);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		
		JButton button_14 = new JButton("添加");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateClassesView dialog = new CreateClassesView(_this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				flushClasses();
			}
		});
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_14.setFocusPainted(false);
		button_14.setBackground(new Color(70, 130, 180));
		panel_8.add(button_14);
		
		JButton button_15 = new JButton("编辑");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row =table_2.getSelectedRow();
				
				if(row<0){
					JOptionPane.showMessageDialog(_this, "请选中一行数据编辑！", "提示",JOptionPane.WARNING_MESSAGE);
				}else{
					Integer id=new Integer(table_2.getValueAt(row, 0).toString());
					
					UpdateClassestView dialog = new UpdateClassestView(id);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
					flushClasses();
				}
			}
		});
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_15.setFocusPainted(false);
		button_15.setBackground(new Color(70, 130, 180));
		panel_8.add(button_15);
		
		JButton button_16 = new JButton("删除");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table_2.getSelectedRow();
				if(row<0){
					JOptionPane.showMessageDialog(_this, "请选择一行数据删除","提示",JOptionPane.WARNING_MESSAGE);
				}else{
					
					Integer	id=new Integer(table_2.getValueAt(row, 0).toString());
					int op=JOptionPane.showConfirmDialog(_this, "确定删除？","提示",JOptionPane.WARNING_MESSAGE);
					if(op==0){
						boolean result=classesController.delete(id);
						
						if(result){
							
							flushClasses();
						}else{
							
								JOptionPane.showConfirmDialog(_this, "正在被使用中，无法被删除!!","警告",JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
			}
		});
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_16.setFocusPainted(false);
		button_16.setBackground(new Color(70, 130, 180));
		panel_8.add(button_16);
		
		JToolBar toolBar_10 = new JToolBar();
		toolBar_10.setToolTipText("");
		toolBar_10.setRollover(true);
		toolBar_10.setFloatable(false);
		toolBar_10.setBorder(null);
		toolBar_10.setBackground(Color.LIGHT_GRAY);
		panel_8.add(toolBar_10);
		
		JLabel label_3 = new JLabel("教室：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_10.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_6.setColumns(15);
		toolBar_10.add(textField_6);
		
		JToolBar toolBar_11 = new JToolBar();
		toolBar_11.setToolTipText("");
		toolBar_11.setRollover(true);
		toolBar_11.setFloatable(false);
		toolBar_11.setBorder(null);
		toolBar_11.setBackground(Color.LIGHT_GRAY);
		panel_8.add(toolBar_11);
		
		JLabel label_4 = new JLabel("班级名：");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_11.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_7.setColumns(15);
		toolBar_11.add(textField_7);
		
		JToolBar toolBar_12 = new JToolBar();
		toolBar_12.setFloatable(false);
		toolBar_12.setBorder(null);
		toolBar_12.setBackground(Color.LIGHT_GRAY);
		panel_8.add(toolBar_12);
		
		JLabel label_5 = new JLabel("学习方向：");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_12.add(label_5);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_8.setColumns(15);
		toolBar_12.add(textField_8);
		
		JToolBar toolBar_13 = new JToolBar();
		toolBar_13.setFloatable(false);
		toolBar_13.setBorder(null);
		toolBar_13.setBackground(Color.LIGHT_GRAY);
		panel_8.add(toolBar_13);
		
		JLabel label_6 = new JLabel("班级号：");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		toolBar_13.add(label_6);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox_2.setBackground(Color.WHITE);

		toolBar_13.add(comboBox_2);
		
		JButton button_17 = new JButton("查询");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=1;
				
				flushClasses();
				
				
			}
		});
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button_17.setFocusPainted(false);
		button_17.setBackground(new Color(70, 130, 180));
		panel_8.add(button_17);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		/*table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u73ED\u53F7", "\u540D\u5B57", "\u6559\u5BA4", "\u5B66\u4E60\u65B9\u5411", "\u5F00\u59CB\u65E5\u671F", "\u7ED3\u675F\u65E5", "\u4EBA\u6570"
			}
		));*/


		JScrollPane scrollPane_2= new JScrollPane();
		panel_9.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		table_2.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));
		table_2.setRowHeight(25);
		
		scrollPane_2.setViewportView(table_2);
		
		JToolBar toolBar_14 = new JToolBar();
		toolBar_14.setRollover(true);
		panel_9.add(toolBar_14, BorderLayout.SOUTH);
		
		JButton button_18 = new JButton("首    页");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=1;
				flushClasses();
			}
		});
		toolBar_14.add(button_18);
		
		JButton button_19 = new JButton("上一页");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page--;
				if(page<1){
					page=1;
				}
				flushClasses();
			}
		});
		toolBar_14.add(button_19);
		
		JButton button_20 = new JButton("下一页");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page++;
				if(page>allpage){
					page=allpage;
				}
				flushClasses();
			}
		});
		toolBar_14.add(button_20);
		
		JButton button_21 = new JButton("尾    页");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page=allpage;
				
				flushClasses();
			}
		});
		toolBar_14.add(button_21);
		Dimension screenSize = Toolkit.getDefaultToolkit()
                .getScreenSize();
        Rectangle bounds = new Rectangle(screenSize);
        Insets insets = Toolkit.getDefaultToolkit()
                .getScreenInsets(this.getGraphicsConfiguration());
        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= insets.left + insets.right;
        bounds.height -= insets.top + insets.bottom;
        
        this.setBounds(bounds);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	//查询老师表（分页）
	public void flushTeacher(String no){
		//获取查询条件
		String textno = textField.getText().trim();
		String name = textField_1.getText().trim();
		String phone = textField_2.getText().trim();
		String disabledStr = (String) comboBox.getSelectedItem();
		
			Teacher t=new Teacher();
			t.setNo(textno);
			t.setName(name);
			t.setMobile(phone);
			t.setGender(disabledStr);
			
			PageModel<Teacher> pageModel=new PageModel<Teacher>();
			pageModel.setT(t);
			pageModel.setPage(page);
			pageModel.setPageSize(pageSize);
			pageModel=teacherController.select(pageModel);
			
			
			total=pageModel.getTotal();
			
			List<Teacher> teacherList=teacherController.selectAll();
			int num=teacherList.size()-1;
			if(!no.equals("admin")){
				
				teacherList.remove(num);
					total=total-1;
			}
			allpage=(int) Math.ceil(total/Double.valueOf(pageSize));
			
			Object[][] data=new Object[pageModel.getDate().size()][];
			for(int i=0;i<data.length;i++){
				data[i]=pageModel.getDate().get(i).toArray();
			}
			
			table.setModel(new DefaultTableModel(
					data,
					new String[] {
						"\u5E8F\u53F7", "\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u624B\u673A\u53F7", "\u90AE\u7BB1", "QQ", "\u5DE5\u4F5C\u5C97\u4F4D"
					}
			));
		}
	
	//查询学生表（分页）
	public void flushStudent(){
		Student.setI(1);
		
		//获取文本框的输入的内容
		String no=textField_3.getText().trim();//学号
		String name=textField_4.getText().trim();//姓名
		String school=textField_5.getText().trim();//学校
		String gender=(String) comboBox_1.getSelectedItem();
		
		//设置查询的条件
		Student s=new Student();
		s.setNo(no);
		s.setName(name);
		s.setSchool(school);
		s.setGender(gender);
		
		//查询
		PageModel<Student> pageModel=new PageModel<>();
		pageModel.setT(s);
		pageModel.setPage(page);
		pageModel.setPageSize(pageSize);
		pageModel=studentController.select(pageModel);
		total=pageModel.getTotal();
		allpage=(int) Math.ceil(total/Double.valueOf(pageSize));
		Object[][] data=new Object[pageModel.getDate().size()][];
		for(int i=0;i<data.length;i++){
			data[i]=pageModel.getDate().get(i).toArray();
		}
		table_1.setModel(new DefaultTableModel(
				data,
				new String[] {
						"\u5E8F\u53F7", "\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5B66\u6821", "\u4E13\u4E1A", "\u6BD5\u4E1A\u65F6\u95F4", "\u624B\u673A\u53F7", "\u90AE\u7BB1"
				}
		));
		
		
	}
	
	public void flushClasses(){
		
		String classroom=textField_6.getText().trim();
		String name=textField_7.getText().trim();
		String study_direction=textField_8.getText().trim();
//		Integer id=new Integer(comboBox_2.getSelectedItem().toString());
		Integer id=null;
		if(comboBox_2.getSelectedItem()!=null){
			if(StringUtils.mathStr(comboBox_2.getSelectedItem().toString())){
				 id=new Integer(comboBox_2.getSelectedItem().toString());
			}
		}
		
		Classes classes=new Classes();
		
		classes.setClassroom(classroom);
		classes.setName(name);
		classes.setStudy_direction(study_direction);
		classes.setId(id);
		
		PageModel<Classes> pageModel=new PageModel<Classes>();
		pageModel.setPage(page);
		pageModel.setPageSize(pageSize);
		pageModel.setT(classes);
		
		pageModel=classesController.select(pageModel);
		total=pageModel.getTotal();
		allpage=(int) Math.ceil(total/(double)pageSize);
		Object[][] data=new Object[pageModel.getDate().size()][];
		for(int i=0;i<data.length;i++){
			data[i]=pageModel.getDate().get(i).toArray();
		}
		
		
		table_2.setModel(new DefaultTableModel(
				data,
				new String[] {
			          "\u73ED\u53F7", "\u73ED\u7EA7\u540D", "\u6559\u5BA4", "\u5B66\u4E60\u65B9\u5411", "\u5F00\u59CB\u65E5\u671F", "\u7ED3\u675F\u65E5", "\u4EBA\u6570"
				}
		));
		
		List<Classes> list=classesController.selectAll();
		List<String> ids=new ArrayList<String>();
		ids.add("");
		for(int i=0;i<list.size();i++){
			ids.add(list.get(i).getId()+"");
		}
		Object[] obj=ids.toArray();
		comboBox_2.setModel(new DefaultComboBoxModel(obj));
		
	}
}
