import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private static JPanel panel1 = new JPanel();
    private static JPanel panel = new JPanel();
    private static String input = "";
    private static JTextField displayBar;
    private static JFrame frame = new JFrame();
    private static JButton[] digitButtons;
    private static JButton[] operatorButtons;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Calculator");
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                calculator();
                frame.setVisible(true);
            }
        });
    }

    private static void calculator(){

        // create a drop-down box to display option for standard and scientific calculator
        String[] calculatorModeList = new String[2];
        calculatorModeList[0] = "Standard";
        calculatorModeList[1] = "Scientific";
        JComboBox<String> calculatorMode = new JComboBox<>(calculatorModeList);

        // create a drop-down box to select calculator theme
        String[] calculatorColorList = new String[2];
        calculatorColorList[0] = "Light";
        calculatorColorList[1] = "Dark";
        JComboBox<String> calculatorColor = new JComboBox<>(calculatorColorList);
        calculatorColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = calculatorColor.getItemAt(calculatorColor.getSelectedIndex());
                changeColor(selectedColor);
            }
        });




        createDigitButtons();
        createOperators();

        displayBar = new JTextField(20);
        panel.add(displayBar);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel1);
        frame.repaint();



    }
    // creates JButtons for all the digits(0-9)
    private static void createDigitButtons(){
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "0";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton oneButton = new JButton("1");
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "1";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton twoButton = new JButton("2");
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "2";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton threeButton = new JButton("3");
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "3";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton fourButton = new JButton("4");
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "4";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton fiveButton = new JButton("5");
        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "5";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton sixButton = new JButton("6");
        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "6";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton sevenButton = new JButton("7");
        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "7";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton eightButton = new JButton("8");
        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "8";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton nineButton = new JButton("9");
        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "9";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        JButton pointButton = new JButton(".");
        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += ".";
                displayBar.setText(input);
                frame.repaint();
            }
        });

        panel1.setLayout(new GridLayout(0,3));
        digitButtons = new JButton[]{zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, pointButton};
        for(JButton button : digitButtons){
            panel1.add(button);
        }

    }

    // creates button for all symbols and operators( C, <-, %, +, -, /, *, =, ^, ln, √ )
    private static void createOperators(){
        JButton clrButton = new JButton("C");
        clrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = "";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(clrButton);

        JButton modButton = new JButton("%");
        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " % ";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(modButton);
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " + ";
                System.out.println(input);
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(addButton);
        JButton subButton = new JButton("-");
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " - ";
                displayBar.setText(input);
                frame.repaint();

            }
        });
        panel1.add(subButton);
        JButton divButton = new JButton("/");
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " / ";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(divButton);
        JButton mulButton = new JButton("*");
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " * ";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(mulButton);
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.contains("ln") && !input.contains(" ")){
                    input = String.valueOf(Math.log(Double.valueOf(input.substring(2, input.length()))));
                }
                else if(input.contains("√") && !input.contains(" ")){
                    input = String.valueOf(Math.sqrt(Double.valueOf(input.substring(1, input.length()))));
                } else {
                    input = String.valueOf(calculate());
                }
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(equalButton);
        JButton powButton = new JButton("^");
        powButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(containsOperator()){
                    input = String.valueOf(calculate());
                }
                input += " ^ ";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(powButton);
        JButton lnButton = new JButton("ln");
        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "ln";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(lnButton);
        JButton sqrRootButton = new JButton("√");
        sqrRootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input += "√";
                displayBar.setText(input);
                frame.repaint();
            }
        });
        panel1.add(sqrRootButton);
        operatorButtons = new JButton[]{addButton, subButton, mulButton, divButton, clrButton, modButton, equalButton};
    }
    private static boolean containsOperator(){
        String[] operators  = new String[]{"%", "+", "-", "ln", "^", "√", "*", "/", "="};
        for(int i = 0; i < operators.length; i++){
            if(input.contains(operators[i])){
                return true;
            }

        }
        return false;
    }

    private static double calculate(){
        String[] strings = input.split(" ");
        checkLogOrSquareRoot(strings);
        double operand1 = Double.valueOf(strings[0]);
        double operand2 = Double.valueOf(strings[2]);
        String operator = strings[1];
        String[] operators  = new String[]{"%", "+", "-", "ln", "^", "√", "*", "/", "="};
        if(operator.equals(operators[0])){
            return operand1 % operand2;
        } else if (operator.equals(operators[1])){
            return operand1 + operand2;
        } else if(operator.equals(operators[2])){
            return operand1 - operand2;
        } else if(operator.equals(operators[4])){
            return Math.pow(operand1, operand2);
        } else if(operator.equals(operators[6])){
            return operand1 * operand2;
        } else if (operator.equals(operators[7])){
            return operand1 / operand2;
        }
        return 0;
    }

    private static void checkLogOrSquareRoot(String[] strings){
        for(int i = 0; i < strings.length; i++){
            if (strings[i].contains("ln")){
                strings[i] = String.valueOf(Math.log(Double.valueOf(strings[i].substring(2, strings[i].length()))));
            }
            if(strings[i].contains("√")){
                strings[i] = String.valueOf(Math.sqrt(Double.valueOf(strings[i].substring(1, strings[i].length()))));
            }
        }


    }

    private static void changeColor(String selectedColor){
        if(selectedColor.equals("Light")){

        } else if(selectedColor.contains("Dark"))
    }






}

