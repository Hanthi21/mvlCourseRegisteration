package view;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

import constants.Constant.MainFrame;
import main.Main;

public class VLoginDialog extends JDialog {
	private static final long serialVERSIONUID = MainFrame.VersionID;
	
	
	private JTextField textid;
	private JPasswordField passwordField;
	private JButton buttonOK;
	private JButton buttonCancel;
	private JPanel contentPane;
	private Main mainInstance;
	private JLabel createAccount;
	
	public int pId;
	public String pname;
	
	public VLoginDialog(Main mainInstance) {
		this.mainInstance = mainInstance;
		setBounds(450,190,500,300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setResizable(false);
        setTitle("Login");
		
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JLabel lable = new JLabel("Login");
		lable.setForeground(Color.BLACK);
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		lable.setFont(new Font("Times New Roman",Font.PLAIN,30));
		lable.setBounds(180,13,120,30);
		contentPane.add(lable);
		
		textid = new JTextField();
		textid.setFont(new Font("Tahoma",Font.PLAIN,14));
		textid.setBounds(180,60,160,30);
		contentPane.add(textid);
		textid.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma",Font.PLAIN,14));
		passwordField.setBounds(180,100,160,30);
		contentPane.add(passwordField);
		
		JLabel userName = new JLabel("Username");
		userName.setBackground(Color.BLACK);
		userName.setFont(new Font("Tahoma",Font.PLAIN,14));
		userName.setBounds(80,60,80,30);
		contentPane.add(userName);
		
		JLabel password = new JLabel("Password");
		password.setBackground(Color.BLACK);
		password.setFont(new Font("Tahoma",Font.PLAIN,14));
		password.setBounds(80,100,80,30);
		contentPane.add(password);
		
		ActionListener actionHandler = new ActionHandler();
		
		buttonOK = new JButton("Login");
		buttonOK.setFont(new Font("Tahoma", Font.PLAIN,14));
		buttonOK.setBounds(150,150,100,30);
		contentPane.add(buttonOK);
		this.buttonOK.addActionListener(actionHandler);
	
		buttonCancel = new JButton("Cancel");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN,14));
		buttonCancel.setBounds(260,150,100,30);
		contentPane.add(buttonCancel);
		buttonCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});	
		
		createAccount = new JLabel("Create a new account!");
		createAccount.setFont(new Font("Tahoma",Font.PLAIN,12));
		createAccount.setForeground(Color.blue);
		createAccount.setBounds(180,200,120,20);
		createAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(createAccount);
		
		MouseHandler clickMe = new MouseHandler();
		createAccount.addMouseListener(clickMe);
		
	}
	
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		String name = textid.getText();
		String passWord = new String(passwordField.getPassword());
		try {
			//build a connection to the sql database which is lms_user
			Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_user","hanthi","12345678");
			
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT name,password FROM student WHERE name=? AND password=?");
			
			
			st.setString(1, name);
			st.setString(2, passWord);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				dispose();
				mainInstance.showMainFrame();//show main frame if login was successful
			}else {
				JOptionPane.showMessageDialog(null, "Invalid user name or password.Try Again.");
			}
			
		}catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
			
		}
		
	}
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();//closing login dialog when create account dialog is opened
			VCreateAccount accountCreation = new VCreateAccount(VLoginDialog.this);
			accountCreation.setVisible(true);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
