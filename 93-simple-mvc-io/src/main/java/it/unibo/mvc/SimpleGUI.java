package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION_X = 3;
    private static final int PROPORTION_Y = 2;
    private static final String TITLE = "My first Java Graphical interface";
    
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(text, BorderLayout.CENTER);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent ev) {
                try {
                    controller.writeOnFile(text.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(frame, ex, "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void main(final String args[]) {
        new SimpleGUI().display();
    }
}
