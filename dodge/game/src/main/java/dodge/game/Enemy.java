package dodge.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity {
	
	private int startY;
	
	
	public Enemy(int x, int y) {
		super(x, y);
		startY = y;
		// TODO Auto-generated constructor stub
	}

	public void update() {
		y += 1;
		checkOffScreen();
	}

	public void draw(Graphics2D g2d) {
	
		g2d.drawImage(getEnemyImg(), x, y, null);
		//g2d.draw(getBounds());
	}

	
	public Image getEnemyImg() {
		ImageIcon p1 = new ImageIcon("C:/Users/Student/Desktop/dodge/enemy.png");
		return p1.getImage();

	}
	
	public void checkOffScreen() {
		if (y >=680) {
			y = startY;
			
		}
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,getEnemyImg().getWidth(null),
				getEnemyImg().getHeight(null));
		
	}
}
