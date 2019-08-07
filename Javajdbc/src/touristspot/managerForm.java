package touristspot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class managerForm extends JFrame {
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtManage;
	private JTextField txtspot;
	private JTextField txtphone;
	private JTextField txtadr;
	private JTextField txtpadt;
	private JTextField txtpch;
	private JTextField txteld;
	private JTable table_1;
	private JTextField txtName;
	private JTextField txtctg;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { managerForm frame = new managerForm();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public managerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1164, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtManage = new JTextField();
		txtManage.setHorizontalAlignment(SwingConstants.CENTER);
		txtManage.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtManage.setText("Manage Tourist Information");
		txtManage.setBounds(63, 10, 589, 50);
		contentPane.add(txtManage);
		txtManage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(42, 90, 93, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Tour Site");
		lblName.setBounds(42, 121, 93, 15);
		contentPane.add(lblName);
		
		JLabel lblTourSite = new JLabel("Name");
		lblTourSite.setBounds(42, 159, 93, 15);
		contentPane.add(lblTourSite);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(42, 191, 93, 15);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(42, 222, 93, 15);
		contentPane.add(lblAddress);
		
		JLabel lblAdmissionFee = new JLabel("Admission Fee ");
		lblAdmissionFee.setBounds(42, 258, 126, 15);
		contentPane.add(lblAdmissionFee);
		
		JLabel lblNewLabel_1 = new JLabel("Adults");
		lblNewLabel_1.setBounds(43, 283, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setBounds(43, 321, 57, 15);
		contentPane.add(lblStudents);
		
		JLabel lblElderly = new JLabel("elderly ");
		lblElderly.setBounds(43, 361, 57, 15);
		contentPane.add(lblElderly);
		
		txtspot = new JTextField();
		txtspot.setBounds(144, 118, 116, 21);
		contentPane.add(txtspot);
		txtspot.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(144, 188, 116, 21);
		contentPane.add(txtphone);
		
		txtadr = new JTextField();
		txtadr.setColumns(10);
		txtadr.setBounds(144, 219, 116, 21);
		contentPane.add(txtadr);
		
		txtpadt = new JTextField();
		txtpadt.setColumns(10);
		txtpadt.setBounds(144, 280, 116, 21);
		contentPane.add(txtpadt);
		
		txtpch = new JTextField();
		txtpch.setColumns(10);
		txtpch.setBounds(144, 318, 116, 21);
		contentPane.add(txtpch);
		
		txteld = new JTextField();
		txteld.setColumns(10);
		txteld.setBounds(144, 358, 116, 21);
		contentPane.add(txteld);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(335, 90, 775, 265);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		dataLoad();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dbconnect();
						String ctg = txtctg.getText();
						sql = "SELECT * FROM Tour WHERE category = ?";
						try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, ctg);
						
						result = pstmt.executeQuery();
						
						while(result.next()){        //getString("컬럼명과 동일한 이름")
							String vctg = result.getString("category");
							String vspt = result.getString("spot");
							String vname = result.getString("name");
							String vtel = result.getString("tel");
							String vadr = result.getString("address");
							String vpadt = result.getString("pay_adult");
							String vpch = result.getString("pay_child");
							String vpel = result.getString("pay_elder");
							txtctg.setText(vctg);
							txtspot.setText(vspt);
							txtphone.setText(vtel);
							txtadr.setText(vadr);
							txtpadt.setText(vpadt);
							txtpch.setText(vpch);
							txteld.setText(vpel);
							txtName.setText(vname);
						}// end of while
						
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		btnSearch.setBounds(47, 408, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dbconnect();
						String ctg = txtctg.getText();
						String spt = txtspot.getText();
						String name = txtName.getText();
						String tel = txtphone.getText();
						String adr = txtadr.getText();
						String padt = txtpadt.getText();
						String pch = txtpch.getText();
						String pel = txteld.getText();
						if(!chkDuplicate(adr)) {
							sql = "INSERT INTO Tour VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						
						try {		
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, adr);
							pstmt.setString(2, ctg);
							pstmt.setString(3, spt);
							pstmt.setString(4, name);
							pstmt.setString(5, tel);
							pstmt.setString(6, padt);
							pstmt.setString(7, pch);
							pstmt.setString(8, pel);
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
		btnAdd.setBounds(191, 408, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbconnect();
			String ctg = txtctg.getText();
			String spt = txtspot.getText();
			String name = txtName.getText();
			String tel = txtphone.getText();
			String adr = txtadr.getText();
			String padt = txtpadt.getText();
			String pch = txtpch.getText();
			String pel = txteld.getText();
			sql = "UPDATE Tour SET spot = ?, name = ?, tel = ?, address = ?, pay_adult = ?, pay_child = ?, pay_elder = ? WHERE category=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, spt);
				pstmt.setString(2, ctg);
				pstmt.setString(3, tel);
				pstmt.setString(4, name);
				pstmt.setString(5, adr);
				pstmt.setString(6, padt);
				pstmt.setString(7, pch);
				pstmt.setString(8, pel);
				int rst = pstmt.executeUpdate();
				if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트하였습니다.", "UPDATE!", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			dataLoad();
		}
		});
		btnUpdate.setBounds(335, 408, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Delete");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbconnect();
			String ctg = txtctg.getText();
			String spt = txtspot.getText();
			String name = txtName.getText();
			String tel = txtphone.getText();
			String adr = txtadr.getText();
			String padt = txtpadt.getText();
			String pch = txtpch.getText();
			String pel = txteld.getText();
			sql = "DELETE FROM Tour WHERE spot = ? AND category=? AND name=? AND tel =? AND address=? AND pay_adult = ? AND pay_child = ? AND pay_elder =?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, spt);
				pstmt.setString(2, ctg);
				pstmt.setString(3, name);
				pstmt.setString(4, tel);
				pstmt.setString(5, adr);
				pstmt.setString(6, padt);
				pstmt.setString(7, pch);
				pstmt.setString(8, pel);
				int rst = pstmt.executeUpdate();
				if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 삭제하였습니다.", "DELETE!", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			txtctg.setText(null);
			txtspot.setText(null);
			txtphone.setText(null);
			txtadr.setText(null);
			txtpadt.setText(null);
			txtpch.setText(null);
			txteld.setText(null);
			txtName.setText(null);
		}
		});
		
		btnReset.setBounds(479, 408, 97, 23);
		contentPane.add(btnReset);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtctg.setText(null);
				txtspot.setText(null);
				txtphone.setText(null);
				txtadr.setText(null);
				txtpadt.setText(null);
				txtpch.setText(null);
				txteld.setText(null);
				txtName.setText(null);
			}
		});
		btnReset_1.setBounds(623, 408, 97, 23);
		contentPane.add(btnReset_1);
		
		txtName = new JTextField();
		txtName.setBounds(144, 156, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnMain = new JButton("Back");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								//현재 창 닫음
								dispose();
								//새로운 창을 생성한 후
								loginPjt lPjt = new loginPjt();
								//새로운 창을 보이게 한다.
								lPjt.setVisible(true);		
						}//end of public void		
				});
		btnMain.setBounds(754, 408, 97, 23);
		contentPane.add(btnMain);
		
		txtctg = new JTextField();
		txtctg.setBounds(144, 87, 116, 21);
		contentPane.add(txtctg);
		txtctg.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블을 클릭했을 때, 행을 추출하고
				// 추출된 행의 각 컬럼을 왼쪽에 있는 각각의 텍스트필드에 전달한다.
				dbconnect();
				int row = table.getSelectedRow();
				String ctg = (table.getModel().getValueAt(row, 0)).toString();
				// uid를 이용하여 db를 검색하고 검색된 결과를 텍스트 필드에 전달
				sql = "SELECT * FROM Tour WHERE category = ?";
				try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ctg);				
				result = pstmt.executeQuery();				
				while(result.next()){        //getString("컬럼명과 동일한 이름")
					String vctg = result.getString("category");
					String vspt = result.getString("spot");
					String vname = result.getString("name");
					String vtel = result.getString("tel");
					String vadr = result.getString("address");
					String vpadt = result.getString("pay_adult");
					String vpch = result.getString("pay_child");
					String vpel = result.getString("pay_elder");
					txtctg.setText(vctg);
					txtspot.setText(vspt);
					txtName.setText(vname);
					txtadr.setText(vadr);
					txtpadt.setText(vpadt);
					txtpch.setText(vpch);
					txteld.setText(vpel);
				}// end of while	
				
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		table.setBounds(335, 90, 775, 265);
		contentPane.add(table);
	}
	void dbconnect() {
		// 연결설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
		}		
	}// end of dbconnect
	void dataLoad() {
		//JTable에 테이블 데이터를 로드한다.
		dbconnect();
		sql = "SELECT * FROM Tour";
		try {
		pstmt = conn.prepareStatement(sql);
		result = pstmt.executeQuery();
		// 질의 결과를 table에 넘겨준다.
		System.out.println("*******");
		table_1.setModel(DbUtils.resultSetToTableModel(result));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}//end of dataLoad
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
}// end of public class
