package TicTacToe;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel title = new JPanel();
    JPanel button_pane1 = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.getContentPane().setBackground(new Color(50, 50, 50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setText("TicTacToe");
        textfield.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 1000);

        button_pane1.setLayout(new GridLayout(3, 3));
        button_pane1.setBackground(new Color(208, 33, 33));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_pane1.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textfield);
        jFrame.add(title, BorderLayout.NORTH);
        jFrame.add(button_pane1);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0xE3E120));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0x0721E3));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }

        }

    }

    public void firstTurn() {
        enableButtons(false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        enableButtons(true);
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //IF xWins
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")) {
                         xWins(0, 1, 2);

        }
        if (
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")) {
                         xWins(3, 4, 5);

        }
        if (
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")) {
                         xWins(6, 7, 8);

        }
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")) {
                         xWins(0, 3, 6);

        }
        if (
                        (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")) {
                         xWins(1, 4, 7);

        }
        if (
                        (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")) {
                         xWins(2, 5, 8);

        }
        if (
                        (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")) {
                         xWins(0, 4, 8);

        }
        if (
                        (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")) {
                         xWins(2, 4, 6);

        }
        //IF O Wins
        if (
                        (buttons[0].getText() == "0") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")) {
                         oWins(0, 1, 2);

        }
        if (
                        (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")) {
                         oWins(3, 4, 5);

        }
        if (
                        (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")) {
                         oWins(6, 7, 8);

        }
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")) {
                         oWins(0, 3, 6);

        }
        if (
                        (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")) {
                         oWins(1, 4, 7);

        }
        if (
                        (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")) {
                         oWins(2, 5, 8);

        }
        if (
                        (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")) {
                         oWins(0, 4, 8);

        }
        if (
                        (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")) {
                         oWins(2, 4, 6);

        }

        //IF match Draw
        for (int i=0;i<9;i++)
        {
            if (buttons[i].getText().isBlank()){
                break;
            }else if(i==8){
                enableButtons(false);
                textfield.setText("Game Draw");
            }
        }



    }

    public void xWins(int a, int b, int c) {
        win(a, b, c);
        textfield.setText("X wins");
        draw(a,b,c);
    }

    private void draw(int a, int b, int c) {

    }

    public void oWins(int a, int b, int c) {
        win(a, b, c);
        textfield.setText("O wins");
        draw(a,b,c);
    }

    private void win(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9;i++)
        {
            buttons[i].setEnabled(false);
        }

    }
    public void enableButtons(boolean a)
    {
        for (int i=0;i<9;i++)
        {
            if (a){
                buttons[i].setEnabled(true);
            }else {
                buttons[i].setEnabled(false);
            }

        }
    }
}
