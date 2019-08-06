package tutorial;

import java.awt.Font;
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

public class MemberInfo extends JFrame {
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtPNum;
	private JTextField txtAdr;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MemberInfo frame = new MemberInfo();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public MemberInfo() {
		setTitle("Member Information Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberInformationForm = new JLabel("Member Information Form");
		lblMemberInformationForm.setFont(new Font("Brush Script MT", Font.BOLD, 20));
		lblMemberInformationForm.setBounds(230, 23, 205, 34);
		contentPane.add(lblMemberInformationForm);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(139, 78, 134, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(22, 81, 57, 15);
		contentPane.add(lblNewLabel);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(139, 109, 134, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Password");
		lblNewLabel_1.setBounds(22, 112, 88, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				sql = "SELECT * FROM members WHERE userid = ?";
				try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				
				result = pstmt.executeQuery();
				
				while(result.next()){        //getString("컬럼명과 동일한 이름")
					String vuserid = result.getString("userid");
					String vuserpwd = result.getString("userpwd");
					String vpnum = result.getString("phone_number");
					String vadr = result.getString("address");
					txtUserID.setText(vuserid);
					txtUserPWD.setText(vuserpwd);
					txtPNum.setText(vpnum);
					txtAdr.setText(vadr);
				}// end of while
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(22, 294, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String pnum = txtPNum.getText();
				String adr = txtAdr.getText();
				if(!chkDuplicate(uid)) {
					sql = "INSERT INTO members VALUES (?, ?, ?, ?)";
				
				try {		
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					pstmt.setString(2, upwd);
					pstmt.setString(3, pnum);
					pstmt.setString(4, adr);
					int insert = pstmt.executeUpdate();
					if(insert==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 삽입하였습니다.", "ADD!", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}else {
				JOptionPane.showMessageDialog(null, "동일한 ID의 레코드가 존재합니다.");
			}//end of else
			}//end of public void
			});
		btnAdd.setBounds(158, 294, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbconnect();
			String uid = txtUserID.getText();
			String upwd = txtUserPWD.getText();
			String pnum = txtPNum.getText();
			String adr = txtAdr.getText();
			sql = "UPDATE members SET userpwd = ?, phone_number = ?, address = ?  WHERE userid=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, upwd);
				pstmt.setString(2, pnum);
				pstmt.setString(3, adr);
				pstmt.setString(4, uid);
				int rst = pstmt.executeUpdate();
				if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트하였습니다.", "UPDATE!", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		});
		btnUpdate.setBounds(284, 294, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbconnect();
			String uid = txtUserID.getText();
			String upwd = txtUserPWD.getText();
			sql = "DELETE FROM members WHERE userpwd = ? AND userid=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, upwd);
				pstmt.setString(2, uid);
				int rst = pstmt.executeUpdate();
				if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 삭제하였습니다.", "DELETE!", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			txtUserID.setText(null);
			txtUserPWD.setText(null);
			txtPNum.setText(null);
			txtAdr.setText(null);
		}
		});
			
		btnDelete.setBounds(421, 294, 97, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(557, 294, 97, 23);
		contentPane.add(btnExit);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(22, 145, 88, 15);
		contentPane.add(lblPhoneNumber);
		
		txtPNum = new JTextField();
		txtPNum.setBounds(139, 142, 134, 21);
		contentPane.add(txtPNum);
		txtPNum.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 179, 57, 15);
		contentPane.add(lblAddress);
		
		txtAdr = new JTextField();
		txtAdr.setBounds(139, 176, 134, 21);
		contentPane.add(txtAdr);
		txtAdr.setColumns(10);
		
		JButton btnReset = new JButton("Reset!");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText(null);
				txtUserPWD.setText(null);
				txtPNum.setText(null);
				txtAdr.setText(null);
			}
		});
		btnReset.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnReset.setBounds(441, 112, 113, 48);
		contentPane.add(btnReset);
	}// end of MemberInfo()

	void dbconnect() {
		// 연결설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
		}		
	}// end of dbconnect
	
	boolean chkDuplicate(String newid) {
		boolean exist = false;
		dbconnect();
		
		sql = "SELECT * FROM members WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newid);
			result = pstmt.executeQuery();
			if(result.next()) {
				exist = true;
			}else exist = false;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return exist;
	}//end of chkDuplicate()
	
	void closeAll() {
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(conn !=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}//end of closeAll()
}
