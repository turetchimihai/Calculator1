import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class CalcWindow extends JFrame implements ActionListener {
    private JButton button0,
                    button1,
                    button2,
                    button3,
                    button4,
                    button5,
                    button6,
                    button7,
                    button8,
                    button9,
                    buttonV,
                    buttonP,
                    buttonAdd,
                    buttonDivide,
                    buttonMultiply,
                    buttonDifference,
                    buttonClear,
                    buttonCalc;
    private JTextField textField;
    private JPanel     panel;
    private JPanel     buttons;
    private JPanel     subpanel;
    private Border     padding;
    private String     buffer       = "";
    private String     bufferMemory = "";
    private String     operation    = "";
    private int count = 0;
    private Add sum;
    private Difference dif;
    private Divide div;
    private Multiply multiply;

    public CalcWindow() {
        super("Calculator");
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonV = new JButton(",");
        buttonP = new JButton("%");
        buttonAdd        = new JButton("+");
        buttonDivide     = new JButton("/");
        buttonMultiply   = new JButton("x");
        buttonDifference = new JButton("-");
        buttonCalc       = new JButton("=");
        buttonClear      = new JButton("Clear");
        textField   = new JTextField(15);
        panel       = new JPanel();
        buttons     = new JPanel();
        subpanel    = new JPanel();
        sum         = new Add();
        dif         = new Difference();
        div         = new Divide();
        multiply    = new Multiply();

        padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(padding);
        setContentPane(panel);

        panel.setLayout(new BorderLayout());
        buttons.setLayout(new GridLayout(4, 4));

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(buttonAdd);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(buttonDifference);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(buttonMultiply);
        buttons.add(buttonV);
        buttons.add(button0);
        buttons.add(buttonP);
        buttons.add(buttonDivide);

        panel.add(buttons,   BorderLayout.CENTER);

        subpanel.setLayout(new GridLayout(2,1));
        subpanel.add(buttonCalc);
        subpanel.add(buttonClear);

        panel.add(textField, BorderLayout.NORTH);
        panel.add(subpanel, BorderLayout.SOUTH);

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonDifference.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonV.addActionListener(this);
        buttonP.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonCalc.addActionListener(this);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setText() {
        textField.setText(buffer);
    }

    public void clearBuffer() {
        count  = 0;
    }

    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "0" :
                buffer += "0";
                setText();
            break;

            case "1" :
                buffer += "1";
                setText();
            break;

            case "2" :
                buffer += "2";
                setText();
            break;

            case "3" :
                buffer += "3";
                setText();
            break;

            case "4" :
                buffer += "4";
                setText();
            break;

            case "5" :
                buffer += "5";
                setText();
            break;

            case "6" :
                buffer += "6";
                setText();
            break;

            case "7" :
                buffer += "7";
                setText();
            break;

            case "8" :
                buffer += "8";
                setText();
            break;

            case "9" :
                buffer += "9";
                setText();
            break;

            case "+" :
                bufferMemory = buffer;
                buffer = "";
                setOperation("+");
            break;

            case "-" :
                bufferMemory = buffer;
                buffer = "";
                setOperation("-");
            break;

            case "/" :
                bufferMemory = buffer;
                buffer = "";
                setOperation("/");
            break;

            case "x" :
                bufferMemory = buffer;
                buffer = "";
                setOperation("x");
            break;

            case "," :
                if (count == 0) {
                    buffer += ".";
                    count++;
                    setText();
                }
                break;

            case "Clear" :
                buffer = "";
                count = 0;
                setText();
            break;

            case "=" :
                if (buffer.isEmpty() != true && bufferMemory.isEmpty() != true) {
                    if (operation.equals("+") == true) {
                        buffer = Double.toString(sum.add(Double.parseDouble(buffer), Double.parseDouble(bufferMemory)));
                        setText();
                        clearBuffer();
                    }

                    if (operation.equals("-") == true) {
                        buffer = Double.toString(dif.difference(Double.parseDouble(buffer), Double.parseDouble(bufferMemory)));
                        setText();
                        clearBuffer();
                    }

                    if (operation.equals("/") == true) {
                        buffer = Double.toString(div.divide(Double.parseDouble(buffer), Double.parseDouble(bufferMemory)));
                        setText();
                        clearBuffer();
                    }

                    if (operation.equals("x") == true) {
                        buffer = Double.toString(multiply.multiply(Double.parseDouble(buffer), Double.parseDouble(bufferMemory)));
                        setText();
                        clearBuffer();
                        System.out.println();
                    }
                }
            break;
        }

    }
}

class Cmp implements Comparable <CalcWindow> {

    @Override
    public String toString() {
        return "Cmp{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public List list;

    @Override
    public int compareTo(CalcWindow calcWindow) {
        return 0;
    }
}