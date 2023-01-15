package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;
    private String operator;
    private double firstNumber;
    private boolean start;

    public Calculator() {
        setLayout(new BorderLayout());
        setTitle("Calculator");
        setSize(250, 250);

        display = new JTextField();
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        switch (button) {
            case "+":
                operator = "+";
                firstNumber = Double.parseDouble(display.getText());
                display.setText("");
                break;
            case "-":
                operator = "-";
                firstNumber = Double.parseDouble(display.getText());
                display.setText("");
                break;
            case "*":
                operator = "*";
                firstNumber = Double.parseDouble(display.getText());
                display.setText("");
                break;
            case "/":
                operator = "/";
                firstNumber = Double.parseDouble(display.getText());
                display.setText("");
                break;
            case "=":
                double secondNumber = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": {
                        double result = firstNumber + secondNumber;
                        display.setText(String.valueOf(result));
                        break;
                    }
                    case "-": {
                        double result = firstNumber - secondNumber;
                        display.setText(String.valueOf(result));
                        break;
                    }
                    case "*": {
                        double result = firstNumber * secondNumber;
                        display.setText(String.valueOf(result));
                        break;
                    }
                    case "/": {
                        double result = firstNumber / secondNumber;
                        display.setText(String.valueOf(result));
                        break;
                    }
                    default:
                        display.setText("Unexpected Error");
                        break;
                }
                break;
            default:
                if (start) {
                    display.setText("");
                    start = false;
                }
                display.setText(display.getText() + button);
                break;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}