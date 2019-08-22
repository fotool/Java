package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer implements Runnable{
	ServerSocket ss;
	Service service;
	ArrayList<Service> list = new ArrayList();
	
	public ChatServer() {
		try {
			ss = new ServerSocket(7777);
			System.out.println("채팅 서버 서비스 중...");
			
			new Thread(this).start();
		}catch(Exception e) {
			System.out.println("ChaServer err : " + e);
		}// end of catch
	}// end of public ChatServer
	
	@Override
	public void run() { //ChatServer 의 run
		while(true) {
			try {
				Socket socket = ss.accept();
				service = new Service(socket);
				service.start();
				service.chat_name = service.in.readLine(); //접속자의 이름 읽기
				//System.out.println(service.chat_name);
				service.messageSend("/c" + service.chat_name);
				for(Service ser : list) {
					ser.messageSend("/c" + service.chat_name);
					service.messageSend("/c" + service.chat_name);
				}// end of for
				list.add(service);
			}catch(Exception e) {
				System.out.println("ChatServer run err :" +e);
			}//end of catch
		}//end of while
	}// end of public void
	
	//client 별 처리를 위한 내부 클래스
	class Service extends Thread {
		String chat_name;
		BufferedReader in;
		OutputStream out;
		Socket socket;
		
		public Service(Socket socket) {
			try {
				this.socket = socket;
				
				in = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), "utf-8"));
			}catch(Exception e) {
				System.out.println("Service err : " + e);
			}//end of catch
		}// end of public Service
		
		@Override
		public void run() {
			while(true) {
				try {
					String msg = in.readLine();
					if(msg == null || msg.equals(""))continue;
					
					if(msg.charAt(0) == '/') {
						if(msg.charAt(1)=='r') { //대화명 변경
							messageAll("/r" + chat_name + "-" +msg.substring(2));
							chat_name = msg.substring(2);
						}else if(msg.charAt(1)=='q') { //퇴장
							try {
								messageAll("/q" + chat_name);
								list.remove(this);
								in.close();
								out.close();
								socket.close();
							}catch(Exception e) {
								// TODO:handle exception
							}
							break;
						}else if(msg.charAt(1)=='s') { //귓속말 /s 이름-메시지
							String name = msg.substring(2, msg.indexOf('-')).trim();
							for(Service ser : list) {
								if(name.equals(ser.chat_name)) {
									ser.messageSend((chat_name + ">(secret)" + msg.substring(msg.indexOf('-') + 1)));
								}// end of if
							}// end of for
						}// end of else if
					}else { //일반 메시지
						messageAll(chat_name + ">" + msg);
					}
				}catch(Exception e) {
					break;
				}//end of catch
			}//end of while
		}//end of public void run
		
		public void messageAll(String msg) {
			try {
				for (int i = 0; i<list.size(); i++) {
					Service ser = list.get(i);
					ser.messageSend(msg);
				}
			}catch(Exception e) {
				System.out.println("messageAll err : " + e);
			}// end of catch
		}// end of public void messageAll 
		
		public void messageSend(String msg) {
			try {
				out.write((msg +"\n").getBytes("utf-8"));
			}catch (Exception e) {
				System.out.println("messageSend err : " + e);
			}// end of catch
		}// end of public void messageSend
	}// end of class extends thread
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer();
	}

}
