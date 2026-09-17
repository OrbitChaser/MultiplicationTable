package SecondProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplicationTable extends JFrame {

    protected Container c;
    protected JLabel imgLabel, textLabel;
    protected JTextArea a;
    protected JTextField tf;
    protected JButton clearButton;
    protected ImageIcon img;
    protected Font f;
    private Cursor cursor;

    MultiplicationTable() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        f = new Font("Arial", Font.BOLD, 20);


        img = new ImageIcon(getClass().getResource("m.png"));

        imgLabel = new JLabel(img);
        imgLabel.setBounds(1, 3, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);


        textLabel = new JLabel("Enter any number :");
        textLabel.setBounds(20, 380, 250, 50);
        textLabel.setForeground(Color.BLUE);
        textLabel.setFont(f);
        c.add(textLabel);


        tf = new JTextField();
        tf.setBounds(260, 380, 100, 50);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBackground(Color.WHITE);
        tf.setFont(f);
        c.add(tf);


        cursor = new Cursor(Cursor.HAND_CURSOR);


        clearButton = new JButton("Clear");
        clearButton.setBounds(260, 450, 100, 50);
        clearButton.setBackground(Color.WHITE);
        clearButton.setCursor(cursor);
        clearButton.setFont(f);
        c.add(clearButton);


        a = new JTextArea();
        a.setBounds(20, 530, 440, 400);
        a.setFont(f);
        a.setBackground(Color.WHITE);
        a.setFont(f);
        c.add(a);

        tf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = tf.getText();

                if(value.isEmpty()){

                   JOptionPane.showMessageDialog(null,"You didn't put any number");

                }
                else {

                a.setText("");
                int num = Integer.parseInt(tf.getText());

                for(int i=1;i<=10;i++){
                    int result = num*i;

                    String r = String.valueOf(result);
                    String n = String.valueOf(num);
                    String incr = String.valueOf(i);

                    a.append(n+" X "+incr + " = "+r+"\n");
                }

            }}
        });

        clearButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                a.setText("");

            }
        });
    }

    public static void main(String[] args) {

        MultiplicationTable frame = new MultiplicationTable();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 50, 500, 1000);
        frame.setTitle("Multiplication Table");
    }
}