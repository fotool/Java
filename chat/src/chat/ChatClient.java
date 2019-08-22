package chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private JLabel jLabel1 = new JLabel();
	private JTextField txtname = new JTextField();
	private JButton btnconn = new JButton();
	private JTextArea txtarea = new JTextArea();
	private JScrollPane jScrollPane1 = new JScrollPane();
	private JTextField txtsend = new JTextField();
	private JButton btnok = new JButton();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel lblinwon = new JLabel();
	private JRadioButton radio1 = new JRadioButton();
	private JRadioButton radio2 = new JRadioButton();
	private JButton btnclose = new JButton();
	private List list = new List();
	private JButton btnchange = new JButton();
	
	private BufferedReader in;
	private OutputStream out;
	private Socket soc;
	int count = 0; // 접속 인원수
	
	public ChatClient() {
		try {
			jbInit();
			addListener();
		}catch(Exception e) {
			e.printStackTrace();
		}// end of catch
	}// end of public ChatClient
	
	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(652, 264));
		this.setTitle("채팅 프로그램");
		this.setBackground(new Color(198, 214, 255));
		jLabel1.setText("대화명:");
		jLabel1.setBounds(new Rectangle(15, 10, 45, 25));
		txtname.setBounds(new Rectangle(60, 10, 105, 25));
		btnconn.setText("접속");
		btnconn.setBounds(new Rectangle(165, 10, 60, 25));
		jScrollPane1.setBounds(new Rectangle(15, 40, 495, 155));
		txtsend.setBounds(new Rectangle(15, 200, 435, 25));
		btnok.setText("확인");
		btnok.setBounds(new Rectangle(450, 200, 60, 25));
		jLabel2.setText("접속자 목록");
		jLabel2.setBounds(new Rectangle(520, 10, 75, 20));
		jLabel3.setText("인원:");
		jLabel3.setBounds(new Rectangle(530, 170, 35, 25));
		lblinwon.setText("");
		lblinwon.setBounds(new Rectangle(565, 170, 50, 25));
		lblinwon.setBackground(new Color(198, 198, 200));
		lblinwon.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		lblinwon.setHorizontalAlignment(SwingConstants.CENTER);
		radio1.setText("귓속말");
		radio1.setBounds(new Rectangle(345, 10, 70, 25));
		radio2.setText("귓속말해제");
		radio2.setBounds(new Rectangle(420, 10, 90, 25));
		btnclose.setBounds(new Rectangle(530, 200, 90, 25));
		list.setBounds(new Rectangle(525, 40, 110, 120));
		btnchange.setText("대화명 변경");
		btnchange.setBounds(new Rectangle(230, 10, 110, 25));
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		this.getContentPane().add(btnchange, null);
		this.getContentPane().add(list, null);
		this.getContentPane().add(btnclose, null);
		this.getContentPane().add(radio1, null);
		this.getContentPane().add(radio2, null);
		this.getContentPane().add(lblinwon, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(btnok, null);
		this.getContentPane().add(txtsend, null);
		jScrollPane1.getViewport().add(txtarea, null);
		this.getContentPane().add(jScrollPane1, null);
		this.getContentPane().add(btnconn, null);
		this.getContentPane().add(txtname, null);
		this.getContentPane().add(jLabel1, null);
	}// end of private void
	
	public void addListener() {
		txtname.addActionListener(this);
		txtsend.addActionListener(this);
		btnok.addActionListener(this);
		btnconn.addActionListener(this);
		btnclose.addActionListener(this);
		btnchange.addActionListener(this);
	}// end of public void addListener
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==txtname || e.getSource() == btnconn) {//대화명 입력 후 접속
			if(txtname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "대화명 입력");
				txtname.requestFocus();
				return;
			}// end of if
			try {
				soc=new Socket("192,168.0.15", 7777);
				in = new BufferedReader(
						new InputStreamReader(soc.getInputStream(), "utf-8"));
					out = soc.getOutputStream();
					out.write((txtname.getText() + "\n").getBytes("utf-8"));
					new Thread(this).start(); //run()을 호출
			}catch (Exception e2) {
				System.out.println("접속 오류: " + e2);
			}//end of catch
		}else if(e.getSource()==txtsend||e.getSource() == btnok) { //메시지 전송
			try {
				if(radio1.isSelected()) { //귓속말 메시지
					String name = list.getSelectedItem();
					out.write(("/s" + name + "-" + txtsend.getText() + "\n").getBytes("utf-8"));
					txtarea.append(name + "님에게 귓속말이 전달되었습니다. \n");
				}else {//일반 메시지
					out.write((txtsend.getText()+"\n").getBytes("utf-8"));
				}// end of else
				txtsend.setText("");
				txtsend.requestFocus();
			}catch(Exception e2) {
				System.out.println("메시지 전송 오류 :"+e2);
			}//end of catch
		}else if(e.getSource() == btnchange) {
			// 대화명 변경
			if(btnchange.getText().equals("대화명 변경")) {
				btnchange.setText("변경확인");
				txtname.setEditable(true);
				txtname.requestFocus();
			}else {
				btnchange.setText("대화명 변경");
				txtname.setEditable(false);
				try {
					out.write(("/r" + txtname.getText() + "\n").getBytes("utf-8"));
				}catch(Exception e2) {
					System.out.println("대화명 변경 오류: " + e2);
				}// end of catch
			}// end of else
		}else if(e.getSource() ==btnclose) {
			//나가기
			try {
				out.write(("/q\n").getBytes());
				in.close();
				out.close();
				soc.close();
			}catch(Exception e2) {
				System.out.println("나가기 오류: "+ e2);
			}finally {
				System.exit(0);
			}//end of finally
		}// end of else if
	}//end of public void ActionPerformed
	
	@Override
	public void run() {
		while (true) {
			try {
				String msg = in.readLine(); //서버로부터 메시지 수신
				if(msg ==null || msg.equals("")) return;
				if(msg.charAt(0)== '/') {
					if(msg.charAt(1)=='c') {//대화명 (입장)
						// /c홍길동
						list.add(msg.substring(2), count);
						count++;
						lblinwon.setText(String.valueOf(count));
						txtarea.append("**" + msg.substring(2) + "님이 입장했습니다.\n");
						txtname.setEditable(false);
						//대화명 입력 불가
						btnconn.setEnabled(false);
					}else if(msg.charAt(1) == 'q') { // 퇴장
						txtarea.append("^^" + msg.substring(2) + "님이 퇴장했습니다.\n");
						String cname = msg.substring(2);
						for(int i = 0; i<count; i++) {
							if(cname.equals(list.getItem(i))) {
								list.remove(i);
								count--;
								lblinwon.setText(String.valueOf(count));
								break;
							}// end of if
						}// end of for
					}else if(msg.charAt(1) == 'r') { //대화명 변경
						// /roldName-newName
						String oldName = msg.substring(2, msg.indexOf('-'));
						String newName = msg.substring(msg.indexOf('-') + 1);
						txtarea.append("*" + oldName + "님의 대화명이 "+ newName +"으로 변경됐습니다\n");
						for(int i= 0; i<count; i++) {
							if(oldName.equals(list.getItem(i))) {
								list.replaceItem(newName, i);
								break;
							}
						}
					}
				}else {//일반 메시지
					txtarea.append(msg + "\n");
				}
			}catch(Exception e) {
				System.out.println("run err : " + e);
			}
		}//end of while
	}// end of public void run
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient fr = new ChatClient();
		
		fr.getPreferredSize();
		fr.setLocation(200, 200);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
