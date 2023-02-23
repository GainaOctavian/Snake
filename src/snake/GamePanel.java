package snake;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	static final int LATIME_ECRAN = 600;
	static final int INALTIME_ECRAN = 600;
	static final int MARIME_UNITATE = 25;
	static final int UNITATI_JOC = (LATIME_ECRAN*INALTIME_ECRAN)/MARIME_UNITATE;
	static final int DELAY = 100;
	final int x[] = new int[UNITATI_JOC];
	final int y[] = new int[UNITATI_JOC];
	int partiCorp = 6;
	int mereMancate;
	int marX;
	int marY;
	char directie = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(LATIME_ECRAN, INALTIME_ECRAN));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame(){
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g){
		
		if(running){
		for(int i=0; i<INALTIME_ECRAN/MARIME_UNITATE;i++){
			g.drawLine(i*MARIME_UNITATE, 0, i*MARIME_UNITATE, INALTIME_ECRAN);
			g.drawLine(0, i*MARIME_UNITATE, LATIME_ECRAN, i*MARIME_UNITATE);
		}
		g.setColor(Color.red);
		g.fillOval(marX, marY, MARIME_UNITATE, MARIME_UNITATE);
		
		for(int i = 0; i<partiCorp; i ++){
			if(i == 0){
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], MARIME_UNITATE, MARIME_UNITATE);
			}
			else{
				g.setColor(new Color(45, 180, 0));
				g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
				g.fillRect(x[i], y[i], MARIME_UNITATE, MARIME_UNITATE);
			}
		}
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Scor: "+mereMancate, (LATIME_ECRAN - metrics.stringWidth("Scor: "+mereMancate))/2, g.getFont().getSize());

	 }
		else{
			gameOver(g);
		}
	}
	public void newApple(){
		marX = random.nextInt((int)(LATIME_ECRAN/MARIME_UNITATE))*MARIME_UNITATE;
		marY = random.nextInt((int)(INALTIME_ECRAN/MARIME_UNITATE))*MARIME_UNITATE;

	}
	public void move(){
		for(int i = partiCorp; i>0; i--){
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(directie){
		case 'U':
			y[0] = y[0] - MARIME_UNITATE;
			break;
		case 'D':
			y[0] = y[0] + MARIME_UNITATE;
			break;
		case 'L':
			x[0] = x[0] - MARIME_UNITATE;
			break;
		case 'R':
			x[0] = x[0] + MARIME_UNITATE;
			break;
		}
		
	}
	public void checkApple(){
		if((x[0] == marX) && (y[0] == marY)){
			partiCorp++;
			mereMancate++;
			newApple();
		}
	}
	public void checkCollisions(){
		//verficare coliziune cap-corp
		for(int i = partiCorp; i>0; i--){
			if((x[0] == x[i]) && (y[0] == y[i])){
				running = false;
			}
		}
		//margine stanga
		if(x[0] < 0){
			running = false;
		}
		//margine sus
		if(y[0] < 0){
			running = false;
		}
		//margine dreapta
		if(x[0] > LATIME_ECRAN){
			running = false;
		}
		//margine jos
		if(y[0] > INALTIME_ECRAN){
			running = false;
		}
		if(!running){
			timer.stop();
		}
	}
	public void gameOver(Graphics g){
		//Scor
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Scor: "+mereMancate, (LATIME_ECRAN - metrics1.stringWidth("Scor: "+mereMancate))/2, g.getFont().getSize());

		//text Final Joc
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Final joc", (LATIME_ECRAN - metrics2.stringWidth("Game Over"))/2, INALTIME_ECRAN/2);
		
		//Text restartare joc
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 45));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString("SPACE pentru a Reincepe", (LATIME_ECRAN - metrics3.stringWidth("SPACE pentru a Reincepe"))/2, INALTIME_ECRAN - 60);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(running){
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				if(directie != 'R'){
					directie = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(directie != 'L'){
					directie = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(directie != 'D'){
					directie = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(directie != 'U'){
					directie = 'D';
				}
				break;

			}
		}
	}

}
