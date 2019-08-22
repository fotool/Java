package painting;

import java.io.Serializable;

class Draw implements Serializable {
	private int x, y, x1, y1;
	private int dist;
	public int getDist() {return dist;}
	public void setDist(int dist) {this.dist = dist;}
	public int getX() {return y;}
	public void setX(int x) {this.x=x;}
	public int getY() {return y;}
	public void setY(int y) {this.y=y;}
	public int getX1() {return x1;}
	public void setX1(int x1) {this.x1 = x1;}
	public int getY1() {return y1;}
	public void setY1(int y1) {this.y1 = y1;}
}