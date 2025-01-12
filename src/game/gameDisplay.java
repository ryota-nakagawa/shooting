package game;

//プレイ画面を表示するプログラム
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JApplet;

public class gameDisplay extends JApplet implements KeyListener {
	
	public ownMachine own = new ownMachine(87, 175);
	public laser laser;
	public enemyMachine enemy;
	public static Thread t;
	public int score = 0;
	BufferedImage buff;
	Graphics2D succ;
	int wide, height;
	int Lx, Lx_r, Ly, Ly_d, Ex, Ex_r, Ey, Ey_d;
	
	public void init(){
		addKeyListener(this);
		wide = getWidth();
		height = getHeight();
		buff = new BufferedImage(wide, height, BufferedImage.TYPE_INT_ARGB);
		succ = (Graphics2D)buff.getGraphics();
		succ.setBackground(Color.white);
	}
	
	public void start(){
	    t = new Thread(){
	      public void run(){
	        Thread ct = Thread.currentThread();
	        while( t == ct ){
	          try {
	            Thread.sleep(10);
	            repaint();
	          } catch(Exception e) {
	            e.printStackTrace();
	          }
	        }
	      }
	    };
	    t.start();
	  }
	
	public void paint(Graphics g){
		succ.clearRect(0, 0, wide, height);
		own.color(succ);
		own.move();
		if(enemy != null){
			if(enemy.getEnemyMachineX() > -30){
				enemy.color(succ);
				enemy.move();
				Ex = enemy.getEnemyMachineX();
				Ex_r = enemy.getEnemyMachineX_r();
				Ey = enemy.getEnemyMachineY();
				Ey_d = enemy.getEnemyMachineY_d();
			}else{
				enemy = null;
			}
		}else{
			enemy = new enemyMachine(200, 30);
		}
		if(laser != null){
			if (laser.getLaserY() > -10){
				laser.color(succ);
				laser.move();
				Ly = laser.getLaserY();
				Ly_d = laser.getLaserY_d();
				this.hit();
			 }else{
				 laser = null;
			}
		}
		g.drawImage(buff, 0, 0, null);
		g.drawString("点数 : " + score, 20, 20);
        requestFocusInWindow();
	}
	
	public void hit(){
		if(Lx_r >= Ex && Lx <= Ex_r){
			if(Ly >= Ey_d && Ly <= Ey){
				if(enemy.get_n() == 6){
					score += 2;
				}else{
					score += 1;
				}
				enemy = null;
				laser = null;
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			own.setDirection(own.left);
			System.out.println("左に移動!\n");
			
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			own.setDirection(own.right);
			System.out.println("右に移動!\n");
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			laser = laser == null ? new laser(own.getOwnMachine().x, own.getOwnMachine().y):laser;
			Lx = laser.getLaserX();
			Lx_r = laser.getLaserX_r();
			System.out.println("レーザー発射!\n");
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
			own.setDirection(own.stay);
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
}