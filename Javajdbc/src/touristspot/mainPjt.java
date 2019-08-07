package touristspot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tutorial.Joinform;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class mainPjt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPjt frame = new mainPjt();
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
	public mainPjt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						//현재 창 닫음
						dispose();
						//새로운 창을 생성한 후
						loginPjt lPjt = new loginPjt();
						//새로운 창을 보이게 한다.
						lPjt.setVisible(true);		
				}//end of public void		
		});
		btnNewButton.setBounds(32, 57, 158, 166);
		contentPane.add(btnNewButton);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//현재 창 닫음
				dispose();
				//새로운 창을 생성한 후
				Guest gst = new Guest();
				//새로운 창을 보이게 한다.
				gst.setVisible(true);	
			}
		});
		btnUser.setBounds(240, 57, 158, 166);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("Tourist Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 10, 295, 37);
		contentPane.add(lblNewLabel);
	}

}
