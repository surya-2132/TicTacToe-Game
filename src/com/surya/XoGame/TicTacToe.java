package com.surya.XoGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();   //to select random player
    JFrame frame = new JFrame();    //for the window frame
    JPanel title_panel = new JPanel();    //for the panel(some selected part of the JFrame)
    JPanel button_panel = new JPanel(); // to hold buttons;
    JLabel textField = new JLabel();    //to display the names in textField
    JButton[] buttons = new JButton[9]; //place to play XO(9 boxes basically)
    boolean player1_turn;

    public TicTacToe() {
        //for window panel
        frame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true); // then, frame.setResizable(false);

        //to show some text in panel
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Franklin Gothic", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        //To show TIC TAC TOE
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //To show Buttons
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9; i++){    //for 9 buttons
            buttons[i] = new JButton(); //creating each buttons through loop
            button_panel.add(buttons[i]);   //adding that button to buttonPanel(working condition button)
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); //to perform, if we click it will listen to our command
        }

        //putting up together
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         for(int i = 0; i < 9; i++){
             if (e.getSource()==buttons[i]){
                 if (player1_turn){
                     if (buttons[i].getText()==""){      //don't what it is, in video =="";
                         buttons[i].setForeground(new Color(255,0,0));
                         buttons[i].setText("X");        //if player 1 is player put X where he was clicked
                         player1_turn = false;       //player1 turn finished move on to player2
                         textField.setText("Now O Turn");     //player 2 turn
                         check();
                     }
                 }else {    //if player 2 is happening now then do the change accordingly
                     if (buttons[i].getText()=="") {//don't what it is, in video =="";
                         buttons[i].setForeground(new Color(0, 0, 255));
                         buttons[i].setText("O");   //if player 1 is player put X where he was clicked
                         player1_turn = true;  //player1 turn finished move on to player2
                         textField.setText("Now X Turn");//player 2 turn
                         check();   //why this check method here??
                     }
                 }
             }
         }
    }

    public void firstTurn(){
        try {
            Thread.sleep(4000);    //to display titleCard for 4 sec
        } catch (InterruptedException e) {  //otherwise x/o turn wil come suddenly
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            player1_turn = true;
            textField.setText("X Turn");
        }else{
            player1_turn = false;
            textField.setText("O Turn");
        }
    }
    public void check() {

        //check X win conditions
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);
        }

        else if(
                        (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }

        else if(
                        (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }

        else if(
                        (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }

        else if(
                        (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }

        else if(
                        (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }

        else if(
                        (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }

        else if(
                        (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }

        //check O win conditions
        else if(
                        (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }

        else if(
                        (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }

        else if(
                        (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }

        else if(
                        (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }

        else if(
                        (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }

        else if(
                        (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }

        else if(
                        (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }

        else if(
                        (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }
        else {
            int checkTie = 0;
            for(JButton i : buttons) {
                if(i.getText()=="O" || i.getText()=="X") {
                    checkTie++;
                }
                if(checkTie==9) {
                    tie();
                    System.out.println("tie");
                }
            }
        }
    }

    public void tie() {
        textField.setText("Match Tied, Restart!!!");
    }

    public void xWins(int a,int b,int c) {

        buttons[a].setBackground(Color.GREEN);  //to check those rows and columns
        buttons[b].setBackground(Color.GREEN);  //like 0, 1, 2 is wins or not
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("X wins");

    }

    public void oWins(int a,int b,int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("O wins");

    }
}