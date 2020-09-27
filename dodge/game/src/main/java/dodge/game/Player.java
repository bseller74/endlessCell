package dodge.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Entity {
	
	int velocityX;
	int velocityY;
	int speed = 1;
	private int startY;
	private int startX;

	public Player(int x, int y) {
		super(x, y);
		startY = y;
		startX = x;
	}

	public void update() {
		y += velocityY;
		x += velocityX;
		checkOffScreen();
		Collisions();
		
	}

	public void draw(Graphics2D g2d) {
	
		g2d.drawImage(getPlayerImg(), x, y, null);
		
	}

	public Image getPlayerImg() {
		ImageIcon p1 = new ImageIcon("C:/Users/Student/Desktop/dodge/hero.png");
		return p1.getImage();

	}
	
	public void keyPressed(KeyEvent e) {

		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			velocityY = -speed;
		}if (e.getKeyCode() == KeyEvent.VK_S) {
			velocityY = speed;
		}if (e.getKeyCode() == KeyEvent.VK_A) {
			velocityX = -speed;
		}if (e.getKeyCode() == KeyEvent.VK_D) {
			velocityX = speed;
		}
	}
	
	public void keyReleased(KeyEvent e) {

	}
	
	
	public void checkOffScreen() {
		if (y <= -5) {
			y = 595;	
		}
		if (y >= 596d) {
			y = -5;	
		}
		if (x >=495) {
			x = 0;	
		}
		if (x <= -5) {
			x = 490;	
		}
		
	}
	
	
	


public Rectangle getBounds() {
	
	return new Rectangle(x,y,getPlayerImg().getWidth(null),
			getPlayerImg().getHeight(null));
	
}

public void Collisions(){
	
	ArrayList<Enemy> enemies = Window.getEnemyList();
	
	for (int i = 0; i < enemies.size();i++) {
		
		Enemy temp = enemies.get(i);
		
		
		if(getBounds().intersects(temp.getBounds())) {
	
			Window.removeEnemy(temp);
		}
	}
	
}




}
