package com.wjd.pattern.behavioral.command;

import javax.swing.*;
import java.awt.event.*;

/**
 * @since 2021/12/14
 */
public class MainTest extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton("clear");

    public MainTest(String title) {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();;
        show();
    }


    public static void main(String[] args) {
        new MainTest("Command Pattern Sample");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
