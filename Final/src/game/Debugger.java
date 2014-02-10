package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Debugger implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFrame debugger = new JFrame();
	
	static Graphics g;

	public Debugger(Graphics g) {
		
		this.g = g;
		debugger.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				debugger.setVisible(false);
				Mechanics.gfxApp = true;
				debugger.dispose();
			}
		});
		final JButton mob = new JButton("Mob");
		final JButton character = new JButton("Character");
		final JButton game = new JButton("Game");
		debugger.setSize(100, 120);
		debugger.setLocationRelativeTo(null);
		debugger.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		debugger.setFocusable(true);
		debugger.setResizable(true);
		addComponentsToFrame(debugger);
		debugger.add(mob);
		debugger.add(character);
		debugger.add(game);
				ActionListener Button1Listener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		    	  mobButton();
		    	  
		      }
		};
		ActionListener Button2Listener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		           characterButton();   
		    	  
		      }
		};
		ActionListener Button3Listener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {


		      }
		};
		mob.addActionListener(Button1Listener);
        mob.setAlignmentX(Component.CENTER_ALIGNMENT);
        character.addActionListener(Button2Listener);
        character.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        game.addActionListener(Button3Listener);
        game.setAlignmentX(Component.CENTER_ALIGNMENT);
        game.setEnabled(false);

	}
	boolean display = false;
	public void displayMenu() {
		


	}
	 public void actionPerformed(ActionEvent e) {
         System.out.println("press");
 }
	
	public void show(boolean a)
	{
		if(!a)
		debugger.dispose();
		else
		debugger.setVisible(a);
	}
    public static void addComponentsToFrame(Container pane) {
    	pane.setLayout(new BoxLayout(((JFrame) pane).getContentPane(), BoxLayout.Y_AXIS)); 
		
    }

    public static void mobButton()
    {
    	final JFrame mobButton = new JFrame();
    	mobButton.setSize(100, 120);
    	mobButton.setLocationRelativeTo(null);
    	mobButton.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mobButton.setLayout(new BoxLayout(((JFrame) mobButton).getContentPane(), BoxLayout.Y_AXIS)); 
    	mobButton.setFocusable(true);
    	mobButton.setResizable(true);
    	mobButton.setVisible(true);
    	JButton addMobs = new JButton("Add Mobs");
    	JButton removeMobs = new JButton("Remove Mobs");
		ActionListener addMobsListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		    	  	String m1 = "10000";
					String m2 = "10000";
					String m3 = "10000";
					String m4 = "10000";
					boolean work = true;
					try{
					m1 = JOptionPane.showInputDialog("X?");
					m2 = JOptionPane.showInputDialog("Y?");
					m3 = JOptionPane.showInputDialog("Left Limit?");
					m4 = JOptionPane.showInputDialog("Right Limit?");
					work = true;
					} catch(NullPointerException e)
					{
						work = false;
					}
					if(work)
					{
						gameFrame.frame.mobs.add(new mob(g,Integer.parseInt(m1),Integer.parseInt(m2),Integer.parseInt(m3),Integer.parseInt(m4),true));
					}
					else{
					
					}
		      }
		};
		ActionListener removeMobListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
					for(int j = 0; j<gameFrame.frame.mobs.size(); j++)
					{
						gameFrame.frame.mobs.get(j).setInactive();
					}
					mobButton.dispose();
		      }
		};
		removeMobs.addActionListener(removeMobListener);
		removeMobs.setAlignmentX(Component.CENTER_ALIGNMENT);
		addMobs.addActionListener(addMobsListener);
		addMobs.setAlignmentX(Component.CENTER_ALIGNMENT);
		mobButton.add(addMobs);
		mobButton.add(removeMobs);
    	
    	
    	
    }

    public static void characterButton()
    {
    	final JFrame characterButton = new JFrame();
    	characterButton.setSize(100, 145);
    	characterButton.setLocationRelativeTo(null);
    	characterButton.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	characterButton.setLayout(new BoxLayout(((JFrame) characterButton).getContentPane(), BoxLayout.Y_AXIS)); 
    	characterButton.setFocusable(true);
    	characterButton.setResizable(true);
    	characterButton.setVisible(true);
    	
    	JButton addHealthButton = new JButton("Add Health");
    	JButton subtractHealthButton = new JButton("Subtract Health");
    	JButton setHealthButton = new JButton("Set Health");
    	JButton reviveCharacterButton = new JButton("Revive Character");
    	
		ActionListener addHealthButtonListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
					String c1 = JOptionPane.showInputDialog("Amount?");
					character.addHP(Integer.parseInt(c1));
		      }
		};
		
		ActionListener subHealthButtonListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
					String c2 = JOptionPane.showInputDialog("Amount?");
					character.subHP(Integer.parseInt(c2));
		      }
		};
		
		ActionListener setHealthButtonListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
					String c3 = JOptionPane.showInputDialog("Set to?");
					character.setHP(Integer.parseInt(c3));
		      }
		};
		
		ActionListener reviveCharButtonListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
					character.setAlive(true);
		      }
		};
    	addHealthButton.addActionListener(addHealthButtonListener);
    	addHealthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	subtractHealthButton.addActionListener(subHealthButtonListener);
    	subtractHealthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	setHealthButton.addActionListener(setHealthButtonListener);
    	setHealthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	reviveCharacterButton.addActionListener(reviveCharButtonListener);
    	reviveCharacterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	characterButton.add(addHealthButton);
    	characterButton.add(subtractHealthButton);
    	characterButton.add(setHealthButton);
    	characterButton.add(reviveCharacterButton);
    	
    }
    
    
    
    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
}
