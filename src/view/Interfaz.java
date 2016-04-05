package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author pablo
 */
public class Interfaz extends JFrame {

   
    
    JTextField display;
    Button zeroButton;
    Button clearButton;
    Button equalsButton;
    Button plusButton;
    Button minusButton;
    Button divButton;
    Button mulButton;
    Button parAButton;
    Button parCButton;
    ArrayList<Button> numerics = new ArrayList<>();

    public Button getParAButton() {
        return parAButton;
    }

    public Button getParCButton() {
        return parCButton;
    }

    public JTextField getDisplay() {
        return display;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Button getEqualsButton() {
        return equalsButton;
    }

    public Button getPlusButton() {
        return plusButton;
    }

    public Button getMinusButton() {
        return minusButton;
    }

    public Button getDivButton() {
        return divButton;
    }

    public Button getMulButton() {
        return mulButton;
    }

    public ArrayList<Button> getNumerics() {
        return numerics;
    }

    public Interfaz() {
        super();

        Container cnt = this.getContentPane();

        cnt.setLayout(new BorderLayout());

        cnt.add(myTextField(), BorderLayout.NORTH);
        cnt.add(calcButtons(), BorderLayout.CENTER);
        cnt.add(downButtons(), BorderLayout.SOUTH);
        this.setSize(400, 400);

        setTitle("CALCULADORA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        requestFocus();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private JPanel calcButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(numericButtons(), BorderLayout.CENTER);
        panel.add(operationButtons(), BorderLayout.EAST);

        panel.setVisible(true);

        panel.setMaximumSize(new Dimension(300, 300));

        return panel;
    }

    private JPanel numericButtons() {
        GridLayout btnGrid = new GridLayout(3, 3);
        JPanel panel = new JPanel(btnGrid);

        for (int i = 0; i < 3; i++) {
            Button bt = new NumericButton(7 + i + "");
            numerics.add(bt);
            panel.add(bt);
        }

        for (int i = 0; i < 3; i++) {
            Button bt = new NumericButton(4 + i + "");
            numerics.add(bt);
            panel.add(bt);
        }

        for (int i = 0; i < 3; i++) {
            Button bt = new NumericButton(1 + i + "");
            numerics.add(bt);
            panel.add(bt);
        }

        panel.setMaximumSize(new Dimension(150, 250));
        panel.setVisible(true);
        return panel;
    }

    private JPanel operationButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        plusButton = new operationButton("+");
        minusButton = new operationButton("-");
        divButton = new operationButton("/");
        mulButton = new operationButton("*");
        parAButton = new operationButton("(");
        parCButton = new operationButton(")");

        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(parAButton);
        panel.add(parCButton);

        panel.setPreferredSize(new Dimension(100, 100));
        panel.setVisible(true);
        return panel;
    }

    private JPanel myTextField() {

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1, 1));
        display = new JTextField(10);
        display.setPreferredSize(new Dimension(50, 50));
        display.setEditable(false);

        jp.add(display);
        return jp;
    }

    private JPanel downButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());//GridLayout : pone todo del mismo tamaño

        zeroButton = new Button("0");
        zeroButton.setPreferredSize(new Dimension(98, 80));

        numerics.add(zeroButton);

        clearButton = new Button("C");
        clearButton.setPreferredSize(new Dimension(200, 80));

        equalsButton = new Button("=");
        equalsButton.setPreferredSize(new Dimension(98, 80));

        panel.add(zeroButton);
        panel.add(clearButton);

        panel.add(equalsButton);

        panel.setVisible(true);

        return panel;

    }
}
