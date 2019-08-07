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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTable table;
	private JTable table_1;

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
		setBounds(100, 100, 844, 422);
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
				dataLoad();
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
			dataLoad();
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
		btnReset.setBounds(284, 335, 97, 38);
		contentPane.add(btnReset);
		

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블을 클릭했을 때, 행을 추출하고
				// 추출된 행의 각 컬럼을 왼쪽에 있는 각각의 텍스트필드에 전달한다.
				dbconnect();
				int row = table.getSelectedRow();
				String uid = (table.getModel().getValueAt(row, 0)).toString();
				// uid를 이용하여 db를 검색하고 검색된 결과를 텍스트 필드에 전달
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
				
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		table.setBounds(772, 81, -434, 170);
		contentPane.add(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(374, 64, 407, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 17, 395, 170);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 395, 170);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	
		
		JButton btnDataLoad = new JButton("Data Load");
		btnDataLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//테이블 데이터를 로드하는 메서드 호출
				System.out.println("데이터로드 호출전");
				dataLoad();
				System.out.println("데이터로드 후");
			}// end of actionPerformed
		});
		btnDataLoad.setBounds(680, 294, 97, 23);
		contentPane.add(btnDataLoad);
		
		//테이블 데이터를 로드하는 메서드 호출
		dataLoad();
					
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
	
	void dataLoad() {
		//JTable에 테이블 데이터를 로드한다.
		dbconnect();
		sql = "SELECT * FROM members";
		try {
		pstmt = conn.prepareStatement(sql);
		result = pstmt.executeQuery();
		// 질의 결과를 table에 넘겨준다.
		System.out.println("*******");
		table_1.setModel(DbUtils.resultSetToTableModel(result));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
