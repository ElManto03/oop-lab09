package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION_X = 3;
    private static final int PROPORTION_Y = 2;
    private static final String TITLE = "My second Java Graphical interface";

    private final JFrame frame = new JFrame(TITLE);
    private Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        JPanel canvas = new JPanel(new BorderLayout());
        JPanel content = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField search = new JTextField();
        search.setEditable(false);
        JButton browse = new JButton("Browse...");
        canvas.add(content, BorderLayout.NORTH);
        content.add(search, BorderLayout.CENTER);
        content.add(browse, BorderLayout.LINE_END);
        JTextArea text = new JTextArea();
        canvas.add(text, BorderLayout.CENTER);
        JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);

        /*
         * Handlers
         */
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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileop = new JFileChooser();
                int returnval = fileop.showSaveDialog(content);
                if (returnval == JFileChooser.APPROVE_OPTION) {
                    final File newFile = fileop.getSelectedFile();
                    controller.setFile(newFile);
                    search.setText(newFile.getAbsolutePath());
                } else if (returnval == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
