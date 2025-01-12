package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

//自機の設定をするプログラム
public class ownMachine{
	
	private Polygon p;
	private int direction;
	public int stay = 0;
	public int right = 1;
	public int left = 2;
	
	public ownMachine(int x, int y){
		int[] x_list = {0,16,16,20,20,36,34,20,19,24,24,19,18,17,12,12,17,16,2};
		int[] y_list = {6,4,0,0,4,6,10,12,18,20,22,23,22,23,22,20,18,12,10};
		p = new Polygon(x_list, y_list, x_list.length);
		direction = stay;
		for(int i=0; i<p.xpoints.length; i++){
			p.xpoints[i] += x;
			p.ypoints[i] += y;
		}
	}
	public void color(Graphics2D g2){
		g2.setColor(Color.green);
		g2.fill(p);
		g2.setColor(Color.black);
		g2.draw(p);
	}
	private void moveLeft(){
		if(p.xpoints[0] > 2){
		    for(int i=0; i<p.xpoints.length; i++){
			   p.xpoints[i] -= 3;
		    }
		}
	}
	private void moveRight(){
		if(p.xpoints[0] < 160){
			for(int i=0; i<p.xpoints.length; i++){
				p.xpoints[i] += 3;
		    }
		}
	}
	public void move(){
		if(direction == left){
			moveLeft();
		}else if(direction == right){
			moveRight();
		}
	}
	public void setDirection(int direction){
		this.direction = direction;
	}
	public void set(){
		
	}
	public Point getOwnMachine(){
		return new Point(p.xpoints[0], p.ypoints[0]);
	}
}