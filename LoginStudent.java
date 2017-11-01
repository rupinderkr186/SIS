package studentSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginStudent extends JFrame{
	static LoginStudent s;
	public static void main(String[] args) {
		//Main frame=new Main();
		//frame.setVisible(true);
		s= new LoginStudent();
		s.setVisible(true);
		
	}
	
	LoginStudent(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(250, 250, 450, 350);
	JPanel Panel = new JPanel();
	Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(Panel);
	
	JLabel lblStudentLogin = new JLabel("Student Login");
	lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
	lblStudentLogin.setForeground(Color.GRAY);
	
	JLabel lblEnterName= new JLabel("Enter Username");
	lblEnterName.setFont(new Font("Tahoma", Font.PLAIN,15));
	lblEnterName.setForeground(Color.GRAY);
	
	JLabel lblPassword= new JLabel("Enter Password");
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN,15));
	lblPassword.setForeground(Color.GRAY);
	
	final JTextField textField= new JTextField();
	
	final JPasswordField passwordField= new JPasswordField();
	
	JButton btnLogin= new JButton("Login");
	btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnLogin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String name= textField.getText();
			String pssword= String.valueOf(passwordField.getPassword());
			String Uname, Pword;
		try{
			Connection con=DB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rset = statement.executeQuery("SELECT StudentId, Password from Slogin");
			while(rset.next()) {
				 Uname= rset.getString(1);
			     Pword=rset.getString(2);
			if (name.equals(Uname) && pssword.equals(Pword)){
				studentHome h= new studentHome();
				h.setVisible(true);
			    s.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(LoginStudent.this,"Invalid login credentials");
				textField.setText("");
				passwordField.setText("");}}
		}catch(SQLException ex) {}

		
			} 
		
		
	}
	);
	
	GroupLayout groupLayout= new GroupLayout(Panel);
	Panel.setLayout(groupLayout);
	
	groupLayout.setAutoCreateGaps(true);
	groupLayout.setAutoCreateContainerGaps(true);
	
	
	
	groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
			.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
							.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStudentLogin))
							.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
											.addComponent(lblEnterName)
											.addComponent(lblPassword))
									.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
											.addComponent(textField,GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
									      //  .addContainerGap(65, Short.MAX_VALUE)
									       // addComponent(passwordField,GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
										    .addContainerGap(70, Short.MAX_VALUE))
			.addGroup(groupLayout.createSequentialGroup()
			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
			.addGap(151))
					);
			
	
	groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
			.addComponent(lblStudentLogin)
			.addGap(40)
			.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(lblEnterName)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(28)
			.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(lblPassword)
				    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(28)
			 .addComponent(btnLogin)
					
			);
	
	
	
	}
		
}
