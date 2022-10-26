import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class Code {

    JFrame frame=new JFrame();
    JLabel imageLabel=new JLabel();
    JButton button=new JButton("Insert Image");
    JFileChooser fileChooser=new JFileChooser();

    Font jetBrains=new Font("JetBrains Mono", Font.PLAIN, 20);

    Code() {
	
	// setting frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
	frame.setLayout(null);

	// setting label on which label will be shown;
        imageLabel.setBounds(100, 50, 250, 250);
	imageLabel.setBackground(Color.GRAY);
	imageLabel.setOpaque(true);
	frame.add(imageLabel);
	
	// setting button;
	button.setBounds(150, 350, 150, 30);
	button.setFont(jetBrains);
	button.setFocusable(false);
	button.addActionListener(this::buttonAction);
	frame.add(button);

        frame.setVisible(true);
    }

    public void buttonAction(ActionEvent e) {
	fileChooser.showOpenDialog(frame);
	
	if(fileChooser.getSelectedFile()==null) {
	    return;
	}
	
	String path=fileChooser.getSelectedFile().getPath();
	ImageIcon img=new ImageIcon(new ImageIcon(path)
		.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
	imageLabel.setIcon(img);
    }

    public static void main(String args[]) throws Exception {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	new Code();
    }
}