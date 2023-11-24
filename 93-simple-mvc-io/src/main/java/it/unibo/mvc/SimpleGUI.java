package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUI () {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea text = new JTextArea();
        JButton save = new JButton("Save");
        canvas.add(save,BorderLayout.SOUTH);
        canvas.add(text);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                try {
                    controller.writeOnFile(text.getText());
                } catch (IOException ex) {
                    System.out.println("I/o error");
                }
            }
            
        });

    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 2);
        frame.setVisible(true);
        frame.setLocationByPlatform(true);
    }



public static void main (String args[]) {
    new SimpleGUI().display();
}
}
