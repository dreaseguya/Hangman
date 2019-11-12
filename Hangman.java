//an Application Window : Hangman
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Hangman {
    private JFrame frmHangman;
    private JButton btnStart;
    private JMenuBar menuBar;
    private JMenu mnFile;
    private JMenu mnNewMenu;
    private JMenuItem mntmExit;
    private JMenuItem mntmInstruction;
    private JTextField guessLetter;
    private JLabel lblTypeYourGuess;
    private JLabel lblYouGuessed;
    private JTextField listOfGuessedWords;
    private JTextField blankSpaces;
    private JButton btnGuess;
    private String letterUsed = "";
    private JPanel panel;
    private int wrongGuess = 0;
    private JPanel KPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hangman window = new Hangman();
                    window.frmHangman.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Hangman() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmHangman = new JFrame();
        frmHangman.setTitle("Hangman");
        frmHangman.setBounds(100, 100, 643, 537);
        frmHangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHangman.getContentPane().setLayout(null);
        
        btnStart = new JButton("START");
        btnStart.addActionListener(new BtnStartActionListener());
        btnStart.setBounds(216, 16, 185, 53);
        frmHangman.getContentPane().add(btnStart);
        
        guessLetter = new JTextField();
        guessLetter.setBounds(15, 111, 192, 29);
        guessLetter.setVisible(false);
        frmHangman.getContentPane().add(guessLetter);
        guessLetter.setColumns(10);
        
        lblTypeYourGuess = new JLabel("Type your guess:");
        lblTypeYourGuess.setBounds(15, 78, 192, 29);
        frmHangman.getContentPane().add(lblTypeYourGuess);
        lblTypeYourGuess.setVisible(false);

        lblYouGuessed = new JLabel("You guessed:");
        lblYouGuessed.setBounds(15, 202, 192, 29);
        lblYouGuessed.setVisible(false);
        frmHangman.getContentPane().add(lblYouGuessed);
        
        listOfGuessedWords = new JTextField();
        listOfGuessedWords.setEditable(false);
        listOfGuessedWords.setBounds(15, 236, 192, 29);
        listOfGuessedWords.setVisible(false);
        frmHangman.getContentPane().add(listOfGuessedWords);
        listOfGuessedWords.setColumns(10);
        
        blankSpaces = new JTextField();
        blankSpaces.setFont(new Font("Tahoma", Font.BOLD, 27));
        blankSpaces.setEditable(false);
        blankSpaces.setVisible(false);
        blankSpaces.setBounds(182, 313, 245, 42);
        frmHangman.getContentPane().add(blankSpaces);
        blankSpaces.setColumns(10);
        
        btnGuess = new JButton("Guess");
        btnGuess.addActionListener(new BtnGuessActionListener());
        btnGuess.setBounds(54, 157, 115, 29);
        btnGuess.setVisible(false);
        frmHangman.getContentPane().add(btnGuess);
        
        panel = new GPanel();
        panel.setBounds(367, 85, 239, 222);
        frmHangman.getContentPane().add(panel);
        panel.setVisible(false);
        
        KPanel = new JPanel();
        KPanel.setBounds(403, 63, 185, 249);
        frmHangman.getContentPane().add(KPanel);
        KPanel.setVisible(true);
        
        menuBar = new JMenuBar();
        frmHangman.setJMenuBar(menuBar);
        
        mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new MntmExitActionListener());
        mnFile.add(mntmExit);
        
        mnNewMenu = new JMenu("Help");
        menuBar.add(mnNewMenu);
        
        mntmInstruction = new JMenuItem("Instruction");
        mntmInstruction.addActionListener(new MntmInstructionActionListener());
        mnNewMenu.add(mntmInstruction);

    }
    
    class GPanel extends JPanel {
        public void paint (Graphics g) {
            g.clearRect(0, 0, getWidth(), getHeight());
            g.fillRect(45, 20, 4, 200);
            g.fillRect(45, 20, 100,4);
            g.fillRect(20, 220, 160,4);
            if (wrongGuess == 1) {
            g.drawOval(94, 25, 50, 50);//face
            }
            if (wrongGuess == 2) {
                  g.drawOval(94, 25, 50, 50);
                g.fillRect(120, 75, 2, 70);//body
            }
            if(wrongGuess==3) {
                  g.drawOval(94, 25, 50, 50);
                  g.fillRect(120, 75, 2, 70);
                  g.drawLine(120, 110, 150, 75);//left hand
            }
            if (wrongGuess == 4) {
                g.drawOval(94, 25, 50, 50);
              g.fillRect(120, 75, 2, 70);
              g.drawLine(120, 110, 150, 75);//left hand
             g.drawLine(120, 110, 90, 75);//right hand
            }
            if(wrongGuess==5) {
                g.drawOval(94, 25, 50, 50);
              g.fillRect(120, 75, 2, 70);
              g.drawLine(120, 110, 150, 75);//left hand
             g.drawLine(120, 110, 90, 75);//right hand
             g.drawLine(120, 145, 145, 195);//left leg
                
            }
            if(wrongGuess==6) {
                g.drawOval(94, 25, 50, 50);
              g.fillRect(120, 75, 2, 70);
              g.drawLine(120, 110, 150, 75);//left hand
             g.drawLine(120, 110, 90, 75);//right hand
             g.drawLine(120, 145, 145, 195);//left leg
            g.drawLine(120, 145, 95, 195);//right leg
            }
        }
        
    
    }
    private class BtnStartActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frmHangman, "Welcome to Hangman. Are you ready?");
            JOptionPane.showMessageDialog(frmHangman, "Instruction:\n1. Guess the words by guessing the letter. \n2.If the letter "
                    + "exists in the word, it will show.\n3. If not, your chara"
                    + "cter will be getting closer to be hanged.\n4. It will be hanged after you used up your trials"
                    + "\nAre you ready?");
            btnStart.setVisible(false);
            btnGuess.setVisible(true);
            lblTypeYourGuess.setVisible(true);
            listOfGuessedWords.setVisible(false);
            guessLetter.setVisible(true);
            blankSpaces.setVisible(true);
            wrongGuess =0;
            panel.repaint();
            panel.setVisible(true);
            HangmanMethods.setUpWord();
            HangmanMethods.howManyGuesses =0;
            HangmanMethods.currentWord = new StringBuilder (HangmanMethods.emptySpaces(HangmanMethods.toBeGuessed));
            blankSpaces.setText(HangmanMethods.currentWord.toString());
            
            
        }
    }
    private class MntmInstructionActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frmHangman, "Instruction:\n1. Guess the words by guessing the letter. \n2.If the letter "
                    + "exists in the word, it will show.\n3. If not, your chara"
                    + "cter will be getting closer to be hanged.\n4. It will be hanged after you used up your trials"
                    + "\nAre you ready?");
            
            
        }
    }
    private class MntmExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class BtnGuessActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String current = "";
            char letterGuessed = guessLetter.getText().charAt(0);
            HangmanMethods.guessedLetter = letterGuessed;
            lblYouGuessed.setVisible(true);
            listOfGuessedWords.setVisible(true);
            boolean isThere = HangmanMethods.isThere(HangmanMethods.toBeGuessed,HangmanMethods.guessedLetter);
           
            if (isThere == true) {
                for (int u =0; u<HangmanMethods.toBeGuessed.length(); u++) {
                    char toCheck = (char) HangmanMethods.toBeGuessed.charAt(u);
                    if (HangmanMethods.charEquals(toCheck)==true) {
                        System.out.println("it's there! at position: "+ u);
                        HangmanMethods.currentWord.setCharAt(u,HangmanMethods.guessedLetter);
                        current = HangmanMethods.currentWord.toString(); 
                        if (current.equals(HangmanMethods.toBeGuessed)==true) {
                        	blankSpaces.setText(current);
			                JOptionPane.showMessageDialog(frmHangman,"You Win :) \nIf you want to play again, hit Start!");
			                btnStart.setVisible(true);
			                letterUsed = " ";
            }
                    }}} 
                
                    else if (isThere == false) {
                            wrongGuess ++;
                            System.out.println("wrongGuess: " + wrongGuess);
                            current = HangmanMethods.currentWord.toString();
                            panel.repaint();
                            panel.setVisible(true);
                        }
            blankSpaces.setText(current);
            letterUsed += letterGuessed + " ";
            listOfGuessedWords.setText(letterUsed);
            if(wrongGuess>=6) {
                JOptionPane.showMessageDialog(frmHangman,"I've been hanged :( \nThe word was '" 
            + HangmanMethods.toBeGuessed + "' \nIf you want to try again, hit Start!");
                btnStart.setVisible(true);
                letterUsed = " ";
            }
           
                }
            }
    
     
    
    
}