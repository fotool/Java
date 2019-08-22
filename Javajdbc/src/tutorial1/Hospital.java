package tutorial1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Hospital extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPWD;
	
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet result = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital frame = new Hospital();
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
	public Hospital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		  Image img = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		  lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(91, 109, 257, 262);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("환자예약 페이지");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				      dispose();
	                  // 새로운 화면을 생성한 후
	                  ReservePage reserpage = new ReservePage();
	                  // 새로운 화면을 보이게 한다.
	                  reserpage.setVisible(true);
			}
		});
		btnNewButton.setBounds(442, 109, 288, 85);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(438, 225, 288, 209);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setBounds(28, 61, 60, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호");
		lblNewLabel_3.setBounds(26, 121, 62, 18);
		panel.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setBounds(140, 67, 116, 24);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPWD = new JTextField();
		txtPWD.setBounds(140, 118, 116, 24);
		panel.add(txtPWD);
		txtPWD.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            String sql = null;
	            String user = "madang";
	            String pwd = "madang";
	            String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            
	            String id = txtID.getText();
	            String pw = txtPWD.getText();
	            

	                        if(id.equals("admin")) {
	                        	if(pw.equals("1234")) {
	                        JOptionPane.showMessageDialog(null, "관리자 계정 로그인 성공!");
	                        // 실행 결과 확인
//	                        JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.");
//	                        현재 화면을 닫고....
	                        dispose();
//	                        새로운 화면을 생성한 후 
	                        AdminPage2 adminPage2 = new AdminPage2();                  
//	                        새로운 화면을 보이게 한다.
	                        adminPage2.setVisible(true);
	                        	}
	                     }else {
	                        JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다..");
	                     }
	                                                
			} //end of actionperformed()
		});
		btnNewButton_1.setBounds(92, 170, 105, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("<관리자 로그인>");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4.setBounds(88, 12, 125, 18);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("세브란스 병원 프로그램");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		lblNewLabel.setBounds(205, 12, 370, 49);
		contentPane.add(lblNewLabel);
	}
	
	void dbConnect() {
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
	}
        
}//디비 커넥 생성자 끝
}
