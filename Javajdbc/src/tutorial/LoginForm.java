package tutorial;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class LoginForm extends JFrame {

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
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to JAVADB Class");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(92, 10, 245, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserID = new JLabel("User Name");
		lblUserID.setBounds(204, 82, 76, 15);
		contentPane.add(lblUserID);
		
		JLabel lblUserPwd = new JLabel("Password");
		lblUserPwd.setBounds(204, 121, 76, 15);
		contentPane.add(lblUserPwd);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(306, 79, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPwd = new JTextField();
		txtUserPwd.setBounds(306, 118, 116, 21);
		contentPane.add(txtUserPwd);
		txtUserPwd.setColumns(10);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//현재 창 닫음
					dispose();
					//새로운 창을 생성한 후
					Joinform jform = new Joinform();
			    	//새로운 창을 보이게 한다.
					jform.setVisible(true);
			}//end of public void
		});
		btnJoin.setBounds(204, 183, 97, 23);
		contentPane.add(btnJoin);
		
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
			    	// JOptionPane.showMessageDialog - 단순한 알림창을 띄울 수 있는 함수
			    	// JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.", "SUCCEES", JOptionPane.INFORMATION_MESSAGE);
			    	// 현재 화면을 닫고....
			    	dispose();
			    	// 새로운 화면을 생성한 후
			    	MemberInfo membInfo = new MemberInfo();
			    	membInfo.setVisible(true);
			    	// 새로운 화면을 보이게 한다.
			    } else {
			    	JOptionPane.showMessageDialog(null, "Stay Back! Or You gonna Die!", "Warning!", JOptionPane.ERROR_MESSAGE);
			    }
//					System.out.println("database connected successfully...");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(325, 183, 97, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(24, 82, 128, 124);
		contentPane.add(label);
	}
}
