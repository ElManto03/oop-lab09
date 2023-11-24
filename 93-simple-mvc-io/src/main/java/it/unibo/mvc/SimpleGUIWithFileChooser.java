package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
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
        JButton save = new JButton("Save");
        canvas.add(save,BorderLayout.SOUTH);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser fileop = new JFileChooser();
               int returnval = fileop.showSaveDialog(content);
               if(returnval == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileop.getSelectedFile());
                    search.setText(fileop.getSelectedFile().getAbsolutePath());
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
        frame.setSize(sw / 4, sh / 4);
        frame.setVisible(true);
        frame.setLocationByPlatform(true);
    }

    public static void main (String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
