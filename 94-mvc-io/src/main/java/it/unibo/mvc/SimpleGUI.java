package it.unibo.mvc;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private Controller controller = new SimpleController();

    public SimpleGUI() {
        JPanel canvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField string = new JTextField();
        JTextArea historyText = new JTextArea();
        historyText.setEditable(false);
        JPanel buttons = new JPanel(new BorderLayout());
        canvas.add(string, BorderLayout.NORTH);
        canvas.add(historyText, BorderLayout.CENTER);
        canvas.add(buttons, BorderLayout.SOUTH);
        JButton print = new JButton("Print");
        JButton showHistory = new JButton("Show history");
        buttons.add(print, BorderLayout.CENTER);
        buttons.add(showHistory, BorderLayout.EAST);

        /*
         * listeners
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextStringPrint(string.getText());
                controller.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                historyText.setText("");
                for (String t : controller.getPrintHistory()) {
                    historyText.append(t + "\n");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 2);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
