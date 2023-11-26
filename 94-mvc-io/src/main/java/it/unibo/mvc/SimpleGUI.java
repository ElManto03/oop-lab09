package it.unibo.mvc;

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

    private static final int PROPORTION_X = 4;
    private static final int PROPORTION_Y = 2;

    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        //initializing frame and canvas
        final JPanel canvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creating components
        final JTextField string = new JTextField();
        final JTextArea historyText = new JTextArea();
        historyText.setEditable(false);
        final JPanel buttons = new JPanel(new BorderLayout());
        final JButton showHistory = new JButton("Show history");
        final JButton print = new JButton("Print");
        //setting UI
        buttons.add(print, BorderLayout.CENTER);
        buttons.add(showHistory, BorderLayout.EAST);
        canvas.add(string, BorderLayout.NORTH);
        canvas.add(historyText, BorderLayout.CENTER);
        canvas.add(buttons, BorderLayout.SOUTH);

        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextStringToPrint(string.getText());
                controller.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                historyText.setText("");
                for (final String t : controller.getPrintHistory()) {
                    historyText.append(t + "\n");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION_X, sh / PROPORTION_Y);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
