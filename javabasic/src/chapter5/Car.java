package chapter5;

public class Car {
	// member 변수, field, 속성
	private String color = "흰색";
	private String engine = "가솔린";
	private String inner = "가죽";
	private int speed = 0;
	
	// 다형성 -
	public Car() {
		// 기본생성자
		this("검정색", "디젤", "패브릭"); // 자기 자신을 생성(parameter를 가지고)
	}
	
	public Car(String color, String engine, String inner) {
		// 컬러값을 받는 생성자
		this.color = color;
		this.engine = engine;
		this.inner = inner;
	}//end of public void Car(String pcolor)
	
	Car returnItself() {
		return this;    // 이 클래스로부터 생성된 객체의 시작 주소값을 리턴한다.
	}
	
	public void setSpeed(int value ) {
		speed = value;
	}// end of public
	
	// member method, 메서드, 함수
	// 가속 메서드
	public void upSpeed(int value){
		if(speed + value > 300) speed = 300;
		else speed = speed + value;
	} // end of upSpeed()
	
	// 감속 메서드
	public void downSpeed(int value) {
		if(speed - value <= 0 ) speed = 0;
		else speed = speed - value;
	}// end of downSpeed()
	
	public void showInfo() {
		System.out.println("컬러 : " + color + ", 현재 속도는" + speed);
	}// showSpeed()

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * @return the inner
	 */
	public String getInner() {
		return inner;
	}

	/**
	 * @param inner the inner to set
	 */
	public void setInner(String inner) {
		this.inner = inner;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
}// end of class Car

// 생성자는 리턴값이 없어야 한다.
// void 는 리턴값이 없을 때 사용.


// this 필드명
// this 생성자
// this 주소



