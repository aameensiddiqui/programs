package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, infoPanel;
	JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	
	Font titleFont = new Font("\"Atari800\"",Font.BOLD, 90);
	Font startButtonFont = new Font("Px IBM MDA",Font.PLAIN, 30);
	Font normalText = new Font("Px IBM MDA",Font.PLAIN, 25);
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	int playerHP;
	String weapon;
	String position;

	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		window = new JFrame(); 
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 100);
		titleNamePanel.setBackground(Color.black);
		
		titleNameLabel = new JLabel("Adventure");
		titleNameLabel.setForeground(Color.green);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 350, 210, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START GAME");
		startButton.setForeground(Color.green);
		startButton.setBackground(Color.black);
		startButton.setFont(startButtonFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		infoPanel = new JPanel();
		infoPanel.setBounds(100, 15, 600, 50);
		infoPanel.setBackground(Color.black);
		infoPanel.setLayout(new GridLayout(1, 4));
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalText);
		hpLabel.setForeground(Color.green);
		infoPanel.add(hpLabel);
		
		hpNumberLabel = new JLabel();
		hpNumberLabel.setFont(normalText);
		hpNumberLabel.setForeground(Color.green);
		infoPanel.add(hpNumberLabel);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalText);
		weaponLabel.setForeground(Color.green);
		infoPanel.add(weaponLabel);
		
		weaponNameLabel = new JLabel();
		weaponNameLabel.setFont(normalText);
		weaponNameLabel.setForeground(Color.green);
		infoPanel.add(weaponNameLabel);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		mainTextPanel.setForeground(Color.green);
		
		mainTextArea = new JTextArea("Main text AreaMain text AreaMain text AreaMain text AreaMain text AreaMain text Area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.green);
		mainTextArea.setFont(normalText);
		mainTextArea.setLineWrap(true);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(250, 350, 300, 150);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4, 1));
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.green);
		choice1.setFont(normalText);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choicePanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.green);
		choice2.setFont(normalText);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choicePanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.green);
		choice3.setFont(normalText);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choicePanel.add(choice3);
		
		mainTextPanel.add(mainTextArea);
		
		con.add(infoPanel);
		con.add(mainTextPanel);
		con.add(choicePanel);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 15;
		hpNumberLabel.setText(""+playerHP);
		weapon = "Knife";
		weaponNameLabel.setText(weapon);
		
		townGate();
	}
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of a town."+
	" \nThere is a guard standing before you."+
				"\n\nWhat do you do?");
		choice1.setText("Talk to guard");
		choice2.setText("Fight the guard");
		choice3.setText("Leave");		
	}
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Hello, there!"+
		" \nI have never seen you before."+
				"\nI'm sorry but I can not let a stranger \nenter the town.");
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
	}
	public void fightTheGuard() {
		mainTextArea.setText("You got defeated.");
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
	}
	
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String ch = event.getActionCommand();
			switch(position) {
			case "townGate":
				switch(ch) {
				case "c1": talkGuard(); break;
				case "c2": fightTheGuard(); break;
				case "c3": break;
				}
			case "talkGuard":
				switch(ch) {
				case "c1": townGate(); break;
				case "c2": break;
				case "c3": break;
				}
			}
		}
	}

}