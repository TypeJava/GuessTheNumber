
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class App extends JFrame implements ActionListener {
    JLabel Text1;
    JTextField Guess;
    JButton Submit;
    JLabel untitled_4;
    int tries = 5;
    int number = getRandomNumber(1, 100);

    public App() {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setupGUI() {

        Text1 = new JLabel();
        Text1.setLocation(52, 19);
        Text1.setSize(200, 50);
        Text1.setText("GuessTheNumber you have " + tries + " tries left!");
        getContentPane().add(Text1);

        Guess = new JTextField();
        Guess.setLocation(102, 132);
        Guess.setSize(100, 50);
        Guess.setText("0");
        Guess.setColumns(10);
        getContentPane().add(Guess);

        Submit = new JButton();
        Submit.setLocation(102, 237);
        Submit.setSize(100, 50);
        Submit.setText("Guess!");
        getContentPane().add(Submit);
        Submit.addActionListener(this);
        untitled_4 = new JLabel();
        untitled_4.setLocation(62, 317);
        untitled_4.setSize(200, 50);
        untitled_4.setText("              Made By Bio Shot");
        getContentPane().add(untitled_4);

        setTitle("Guess The Number");
        setSize(400, 400);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int guess = Integer.parseInt(Guess.getText());
        if (guess == number) {
            Text1.setText("You Win!");
        } else {
            tries--;
            if (tries == 0) {
                Text1.setText("You Lose! The answer was " + number + "!");

            }
            if (guess > number) {
                Text1.setText("Your guess is too high!");
            } else if (guess < number) {
                Text1.setText("Your guess is too low!");
            } else {
                if (tries == -1) {
                    System.exit(0);
                } else {
                    Text1.setText("You have " + tries + " tries left!");
                }

            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
