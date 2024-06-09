package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import constants.Constant.MainFrame;

public class VCreateAccount extends JDialog {
	private static final long serialVERSIONUID = MainFrame.VersionID;
	
	private JTextField Id;
	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel contentPane;
	private VLoginDialog loginDialog;
	
	
	public VCreateAccount(final VLoginDialog loginDialog) {
			this.loginDialog = loginDialog;
			loginDialog.setModal(true);
	  
			setBounds(450, 190, 500, 300);
	        setResizable(false);
	        setTitle("Create Account");

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        Id = new JTextField();
	        Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        Id.setBounds(180, 60, 200, 30);
	        contentPane.add(Id);
	        Id.setColumns(10);

	        username = new JTextField();
	        username.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        username.setBounds(180, 100, 200, 30);
	        contentPane.add(username);
	        username.setColumns(10);

	        password = new JPasswordField();
	        password.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        password.setBounds(180, 140, 200, 30);
	        contentPane.add(password);

	        JLabel idLabel = new JLabel("ID");
	        idLabel.setForeground(Color.BLACK);
	        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        idLabel.setBounds(80, 60, 80, 30);
	        contentPane.add(idLabel);

	        JLabel userNameLabel = new JLabel("Username");
	        userNameLabel.setForeground(Color.BLACK);
	        userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        userNameLabel.setBounds(80, 100, 80, 30);
	        contentPane.add(userNameLabel);

	        JLabel passwordLabel = new JLabel("Password");
	        passwordLabel.setForeground(Color.BLACK);
	        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        passwordLabel.setBounds(80, 140, 80, 30);
	        contentPane.add(passwordLabel);

	        okButton = new JButton("Create");
	        okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        okButton.setBounds(150, 200, 100, 30);
	        contentPane.add(okButton);
	        okButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					createAccount();
					dispose();
					
				}
	        	
	        });
	        cancelButton = new JButton("Cancel");
	        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        cancelButton.setBounds(280, 200, 100, 30);
	        contentPane.add(cancelButton);
	        cancelButton.addActionListener(new ActionListener(){
	           

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 dispose();
					   loginDialog.setVisible(true);
				}
	         
	        });

	   
	        setLocationRelativeTo(null); // Center the dialog on the screen
	    }
	public void createAccount() {
	//connect to mysql database and store the user input data in the lms_user database
		String uid = Id.getText();
		String uName = username.getText();
		String uPassword = new String(password.getPassword());
		try {
			//establish mysql db connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_user", "hanthi", "12345678");
			
			//prepare sql statement for adding new user data to the db
			String sql = "INSERT INTO student(id,name,password) VALUES(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//set parameters for the SQL statement
			statement.setString(1, uid);
			statement.setString(2, uName);
			statement.setString(3, uPassword);
			
			
			//Execute the SQL Statement
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted >0) {
				//successful account creating , show message
				JOptionPane.showMessageDialog(contentPane, "Account created successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();//close this account creation dialog
			}
			
		}catch(SQLException ex ) {
			JOptionPane.showMessageDialog(contentPane,"Error Creating account: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
