package touristspot;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Guest extends JFrame {
	
	Connection conn;
	String sql;
	PreparedStatement pstmt;
	ResultSet result;
	
	private JPanel contentPane;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest frame = new Guest();
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
	public Guest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouFind = new JLabel("Do you find this?");
		lblDoYouFind.setFont(new Font("Viner Hand ITC", Font.BOLD, 38));
		lblDoYouFind.setBounds(60, 28, 363, 51);
		contentPane.add(lblDoYouFind);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(60, 123, 75, 15);
		contentPane.add(lblCategory);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 122, 449, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"당신의 선택은?", "산", "캠핑", "박물관", "기타"}));
		comboBox.setBounds(136, 122, 197, 22);
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String ctg= comboBox.getSelectedItem().toString();
				sql = "SELECT * FROM Tour WHERE category = ?";
				try {										
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctg);
					result = pstmt.executeQuery();
					// 질의 결과를 table에 넘겨준다.
					table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnSearch.setBounds(60, 325, 97, 23);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/search icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(24, 165, 159, 141);
		contentPane.add(label);
		
		
	}//end of public Guest
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
		table.setModel(DbUtils.resultSetToTableModel(result));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}//end of dataLoad
	
}//end of main
