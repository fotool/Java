package tutorial;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest frame = new LoginTest();
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
	public LoginTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(68, 34, 57, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserPwd = new JLabel("User PWD");
		lblUserPwd.setBounds(68, 89, 74, 24);
		contentPane.add(lblUserPwd);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(165, 31, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPwd = new JTextField();
		txtUserPwd.setBounds(165, 91, 116, 21);
		contentPane.add(txtUserPwd);
		txtUserPwd.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB Connection
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				String sql = null;
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "madang";
				String pwd = "madang";
				
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pwd);
				sql = "SELECT * FROM members WHERE userid = ? AND userpwd = ?";
				pstmt = conn.prepareStatement(sql);
				String uid = txtUserID.getText();
			    String upwd = txtUserPwd.getText();
			    pstmt.setString(1, uid);
			    pstmt.setString(2, upwd);
			    
			    result = pstmt.executeQuery();
			    
			    if(result.next()) {
			    	
			    	JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.");
			    } else {
			    	JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
			    }
//					System.out.println("database connected successfully...");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(101, 148, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(230, 148, 97, 23);
		contentPane.add(btnCancel);
		
		JLabel lblLoginTest = new JLabel("Login Test");
		lblLoginTest.setBounds(68, 9, 174, 15);
		contentPane.add(lblLoginTest);
	} // end of Login Test
}// end of class
