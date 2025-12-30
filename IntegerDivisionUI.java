import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntegerDivisionUI extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton divideBtn;

    IntegerDivisionUI() {
        setTitle("Integer Division");

        JLabel l1 = new JLabel("Num1:");
        JLabel l2 = new JLabel("Num2:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);

        divideBtn = new JButton("Divide");
        divideBtn.addActionListener(this);

        setLayout(new GridLayout(4, 2, 10, 10));
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(new JLabel());
        add(divideBtn);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int result = num1 / num2;
            t3.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid integers",
                    "Number Format Exception",
                    JOptionPane.ERROR_MESSAGE);

        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this,
                    "Division by zero is not allowed",
                    "Arithmetic Exception",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new IntegerDivisionUI();
    }
}
