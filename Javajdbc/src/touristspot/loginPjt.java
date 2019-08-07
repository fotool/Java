package touristspot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tutorial.Joinform;
import tutorial.MemberInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class loginPjt extends JFrame {
	
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPjt frame = new loginPjt();
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
	public loginPjt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Login ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(93, 23, 225, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblManagerid = new JLabel("ManagerID");
		lblManagerid.setBounds(67, 91, 118, 15);
		contentPane.add(lblManagerid);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(202, 88, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(67, 144, 118, 15);
		contentPane.add(lblPassword);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(202, 141, 116, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB Connection
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				String sql = null;
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pwd = "hr";
				
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pwd);
				sql = "SELECT * FROM Manager WHERE userid = ? AND password= ?";
				pstmt = conn.prepareStatement(sql);
				String uid = txtUserID.getText();
			    String upwd = txtUserPWD.getText();
			    pstmt.setString(1, uid);
			    pstmt.setString(2, upwd);
			    
			    result = pstmt.executeQuery();
			    
			    if(result.next()) {
			    	// JOptionPane.showMessageDialog - 단순한 알림창을 띄울 수 있는 함수
			    	// JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.", "SUCCEES", JOptionPane.INFORMATION_MESSAGE);
			    	// 현재 화면을 닫고....
			    	dispose();
			    	// 새로운 화면을 생성한 후
	
			    	
			    	managerForm mform = new managerForm();
			    	mform.setVisible(true);
			    	
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
		btnLogin.setBounds(88, 192, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						//현재 창 닫음
						dispose();
						//새로운 창을 생성한 후
						mainPjt mPjt = new mainPjt();
						//새로운 창을 보이게 한다.
						mPjt.setVisible(true);		
			}//end of public void
		});
		btnCancel.setBounds(217, 192, 97, 23);
		contentPane.add(btnCancel);
	}
}
