package painting;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;



 //메뉴이벤트구성                                                                             //마우스이벤트         //모션이벤트
class Exam_04_sub extends Frame implements ItemListener, MouseListener, MouseMotionListener
	{
	
	//화면 구성부
	private MenuBar mb = new MenuBar(); //메뉴바
	private Menu draw = new Menu("DRAW"); //메뉴 DRAW
	
	//체크박스 서브메뉴
	private CheckboxMenuItem pen = new CheckboxMenuItem("PEN", true); //기본체크
	private CheckboxMenuItem line = new CheckboxMenuItem("LINE");
	private CheckboxMenuItem oval = new CheckboxMenuItem("OVAL");
	private CheckboxMenuItem rect = new CheckboxMenuItem("RECT");
	
	private int x, y, x1, y1; //마우스를 눌렀을 때와 뗐을 때 각 좌표값
	
	private Vector vc = new Vector();
	
	//화면분할
	private Panel p = new Panel();
	private BorderLayout bl = new BorderLayout();
	private FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
	
	public Exam_04_sub(String title) {
		super(title);
	
	//로고 만드는 메소드	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img2 = tk.getImage("nex.gif");
	this.setIconImage(img2);
	
	this.init(); //화면구성용 메소드
	this.start(); //이벤트용 메소드
		
	// window의 크기 위치조정
	super.setSize(400, 400);
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frm = super.getSize();
	int xpos = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
	int ypos = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
	super.setLocation(xpos, ypos);
	super.setResizable(false);
	super.setVisible(true);
	}
	
	//레이아웃 화면구성
	public void init() {
		draw.add(pen); //pen
		draw.add(line); //line
		draw.add(oval); //oval
		draw.add(rect); //rect
		mb.add(draw); //draw
		this.setMenuBar(mb); //메뉴바
	} // end of public void init
	
	//이벤트 구성
	public void start() {
		//window 의 X버튼을 누르면 window를 종료하라
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	//선택된 메뉴만 체크되도록 하는 이벤트
	pen.addItemListener(this);
	line.addItemListener(this);
	oval.addItemListener(this);
	rect.addItemListener(this);
		
	this.addMouseListener(this);
	this.addMouseMotionListener(this); // 마우스가 움직이는 동안 그려지는 모양을 위한 이벤트
	}// end of public void start
	
	// 그림을 위한 메소드
	public void paint(Graphics g) {
		
	// 그림그리기
	for(int i = 0; i< vc.size(); ++i) {
		Draw d = (Draw)vc.elementAt(i);
		if(d.getDist() == 1) {
			g.drawLine(d.getX(), d.getY(), d.getX1(), d.getY1());
		}
		else if(d.getDist() == 2) {
			g.drawOval(d.getX(), d.getY(), d.getX1() - d.getX(), d.getY1() - d.getY());
		}
		else if(d.getDist() == 3) {
			g.drawRect(d.getX(), d.getY(), d.getX1() - d.getX(), d.getY1() - d.getY());
		}
	}// end of for
		
		
	// 마우스를 눌렀다 떼었을 때
	if(line.getState() == true) { //라인을 체크하면
		g.drawLine(x, y, x1, y1); //x,y 좌표에서 x1, y1 좌표에 라인을 그려라
	}
	else if(oval.getState() == true) { //oval을 체크하면
		g.drawOval(x, y, x1-x, y1-y); //oval을 그려라
	}
	else if(rect.getState() == true) { //rect를 체크하면
		g.drawRect(x, y, x1-x, y1-y); //rect를 그려라
	}
	}//end of public void
	
	//마우스 사용을 위한 메소드
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) { //눌렀을 때
		x = e.getX(); //x의 좌표값을 얻어내어
		y = e.getY(); //y1의 좌표값
		this.repaint(); //그림을 다시 그린다
		
		if(pen.getState() !=true) { //pen이 true가 아닐때에만 아래를 실행하라
			int dist = 0;
			
		if(line.getState() == true) dist =1; // line이 체크되면 1값을 대입
		else if(oval.getState() == true) dist = 2; // oval이 체크되면 2값을 대입
		else if(rect.getState() == true) dist = 3; // rect가 체크되면 3값을 대입
		Draw d = new Draw(); //d 객체 생성
		d.setDist(dist); //dist 값 대입
		
		//각각의 값 대입
		d.setX(x);
		d.setY(y);
		d.setX1(x1);
		d.setY1(y1);
		vc.add(d); // vc에 값을 저장하라
		}
	}// end of public void mousePressed
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	//마우스가 움직이는 동안 그려지는 모양 보이기
	public void mousDragged(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		this.repaint(); //움직이는 동안 보여지기
		
	// pen 그려지는 이벤트
	if(pen.getState()) {
		Draw d = new Draw();
		d.setDist(1);
		d.setX(x);
		d.setY(y);
		d.setX1(x1);
		d.setY1(y1);
		vc.add(d);
		x = x1;
		y = y1;
	}
	}
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
	