package game;

//自機が発射するレーザー部分の設定をするプログラム
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class laser {
	
  private Ellipse2D laser;
  private int wide = 10, height = 15;
  private Rectangle r = new Rectangle(8,-15,wide,height);
  private int a = 7;
  
  public laser() {
    laser = new Ellipse2D.Double();  
    laser.setFrame(r);
  }
  
  public laser(int x, int y) {
	    this();
	    r.x += x;
	    r.y += y;
	    laser.setFrame(r);
	  }
  
  public void color(Graphics2D g2) {
    g2.setColor(Color.ORANGE);
    g2.fill(laser);
    g2.setColor(Color.BLACK);
    g2.draw(laser);
  }
  
  public void move(){
	  r.y -= a;
	  laser.setFrame(r);
  }
  
  public void setLaser(int y){
	  r.y = y;
	  laser.setFrame(r);
  }
  
  public int getLaserX(){
	  return r.x;
  }
  
  public int getLaserY(){
	  return r.y;
  }
  
  public int getLaserX_r(){
	  return r.x + this.wide;
  }
  
  public  int getLaserY_d(){
	  return r.y - this.height;
  }
  
}