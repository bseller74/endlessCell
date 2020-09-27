package dodge.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {

	Timer mainTimer;
	Player player;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	Random rand = new Random();
	int enemyCount = 5;
	int level = 1;
	private JLabel label;
	

	public Window() {
		setFocusable(true);
		
		player = new Player(250, 550);
		addKeyListener(new KeyAdapt(player));
		mainTimer = new Timer(10, this);
		mainTimer.start();
		startGame();
		
		
	

	}

	public void paint(Graphics g) {
		
		
		
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, 800, 600);
		Graphics2D g2d = (Graphics2D) g;
		player.draw(g2d);

		
		for (int i = 0; i < enemies.size();i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		for (int i = 0; i < enemies.size();i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.update();
		}
		
		endLevel();
		
		repaint();

	}
	
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	public static void removeEnemy(Enemy e) {
		enemies.remove(e);
	}
	
	public static ArrayList<Enemy> getEnemyList() {
		return enemies;	
	
	}
	
	public void startGame() {
		enemyCount = level * 5;
		
		for (int i = 0; i < enemyCount;i++) {
			addEnemy(new Enemy(rand.nextInt(500), -rand.nextInt(600)));
		}
		
	}
	
	public void endLevel() {
		if(enemies.size() == 0) {
		level++;
		enemies.clear();
		//JOptionPane.showMessageDialog(null, "message");
		startGame();
		
		}
	}

}
