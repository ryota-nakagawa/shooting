package game;

//敵機の設定を行うプログラム
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class enemyMachine {
	
	Random rnd = new Random();
	private int x = 0;
	private int y = 0;
	private int n = rnd.nextInt(4) + 3;
	private int wide = 30, height = 21;
	private Rectangle body_r;
	private Ellipse2D body;
	private Rectangle pit_r;
	private Ellipse2D pit;
	private Rectangle rleg_r;
	private Ellipse2D rleg;
	private Rectangle mleg_r;
	private Ellipse2D mleg;
	private Rectangle lleg_r;
	private Ellipse2D lleg;
	
	public enemyMachine(){
        body_r = new Rectangle(0,5,30,12);  
		body = new Ellipse2D.Double();
		body.setFrame(body_r);
		pit_r = new Rectangle(10,0,10,10);  
		pit = new Ellipse2D.Double();
		pit.setFrame(pit_r);
		rleg_r = new Rectangle(20,13,6,6);  
	    rleg = new Ellipse2D.Double();
		rleg.setFrame(rleg_r);
        mleg_r = new Rectangle(12,15,6,6);  
        mleg = new Ellipse2D.Double();
		mleg.setFrame(mleg_r);
        lleg_r = new Rectangle(4,13,6,6);  
	    lleg = new Ellipse2D.Double();
	    lleg.setFrame(lleg_r);
	}
	
	public enemyMachine(int x, int y){
		this();
		this.x = x;
	    this.y = y;
	    body_r.x += x;
	    body_r.y += y;
	    body.setFrame(body_r);
	    pit_r.x += x;
	    pit_r.y += y;
	    pit.setFrame(pit_r);
	    rleg_r.x += x;
	    rleg_r.y += y;
	    rleg.setFrame(rleg_r);
	    mleg_r.x += x;
	    mleg_r.y += y;
	    mleg.setFrame(mleg_r);
	    lleg_r.x += x;
	    lleg_r.y += y;
	    lleg.setFrame(lleg_r);
	}
	
	public void color(Graphics2D g2){
		g2.setColor(Color.CYAN);
	    g2.fill(pit);
	    g2.setColor(Color.BLUE);
	    g2.fill(rleg);
	    g2.fill(mleg);
	    g2.fill(lleg);
	    g2.setColor(Color.BLACK);
	    g2.draw(pit);
	    g2.draw(rleg);
	    g2.draw(mleg);
	    g2.draw(lleg);
	    if(n == 6){
			g2.setColor(Color.YELLOW);
		}else{
			g2.setColor(Color.GRAY);
		}
	    g2.fill(body);
	    g2.setColor(Color.BLACK);
	    g2.draw(body);
	}
	
	public void setEnemy(int x){
		body_r.x = x;
	    pit_r.x = x;
	    body.setFrame(body_r);
	    pit.setFrame(pit_r);
	}
   	
	public void move(){
		this.x -= n;
	    body_r.x -= n;
	    body.setFrame(body_r);
	    pit_r.x -= n;
	    pit.setFrame(pit_r);
	    rleg_r.x -= n;
	    rleg.setFrame(rleg_r);
	    mleg_r.x -= n;
	    mleg.setFrame(mleg_r);
	    lleg_r.x -= n;
	    lleg.setFrame(lleg_r);
	}
	
	public int getEnemyMachineX(){
		return this.x;
	}
	
	public int getEnemyMachineY(){
		return this.y;
	}
	
	public int getEnemyMachineX_r(){
		return this.x + this.wide;
	}
	
	public int getEnemyMachineY_d(){
		return this.y - this.height;
	}
	
	public int get_n(){
		return this.n;
	}
}