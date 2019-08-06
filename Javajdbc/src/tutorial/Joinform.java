package tutorial;

import java.awt.EventQueue;
import java.awt.Font;
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

public class Joinform extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtPNum;
	private JTextField txtAdr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Joinform frame = new Joinform();
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
	public Joinform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Membership Page");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1.setBounds(142, 30, 339, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(97, 115, 57, 15);
		contentPane.add(lblName);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(208, 112, 208, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(97, 167, 86, 15);
		contentPane.add(lblPassword);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(208, 164, 208, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(97, 224, 101, 15);
		contentPane.add(lblPhoneNumber);
		
		txtPNum = new JTextField();
		txtPNum.setBounds(208, 221, 208, 21);
		contentPane.add(txtPNum);
		txtPNum.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(97, 279, 57, 15);
		contentPane.add(lblAddress);
		
		txtAdr = new JTextField();
		txtAdr.setBounds(208, 279, 208, 21);
		contentPane.add(txtAdr);
		txtAdr.setColumns(10);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
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
			    String upwd = txtUserPWD.getText();
			    String pnum = txtPNum.getText();
				String adr = txtAdr.getText();
			    pstmt.setString(1, uid);
			    pstmt.setString(2, upwd);
			    pstmt.setString(3, pnum);
			    pstmt.setString(4, adr);
			    
			    result = pstmt.executeQuery();
			    
			    	// 현재 화면을 닫고....
			    	dispose();
			    	// 새로운 화면을 생성한 후
			    	MemberInfo membInfo = new MemberInfo();
			    	// 새로운 화면을 보이게 한다.
			    	membInfo.setVisible(true);
			    	
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJoin.setBounds(208, 342, 97, 23);
		contentPane.add(btnJoin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(317, 342, 97, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/join.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(458, 92, 134, 202);
		contentPane.add(label);
	}
}
