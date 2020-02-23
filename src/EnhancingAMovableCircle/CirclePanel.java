/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancingcircle;

/**
 *
 * @author Zara Veda
 */

// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y, frX, frY;
    private Color c;
    
    JButton left;
    JButton right;
    JButton up;
    JButton down;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        frX = width;
        frY = height;
        c = Color.green;
        
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
        
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        // Create buttons to move the circle
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
        
        //Tooltips of the button
        left.setToolTipText("Press alt+l to move 20 px to the left");
        right.setToolTipText("Press alt+r to move 20 px to the right");
        up.setToolTipText("Press alt+u to move 20 px up");
        down.setToolTipText("Press alt+d to move 20 px down");
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
            x += dx;
            y += dy;
            repaint();
            
            if(x < 0) {
                left.setEnabled(false);
                right.setEnabled(true);
            } else {
                if(x > 0) {
                    left.setEnabled(true);
                    
                    if(x >= frX-CIRCLE_SIZE) {
                        right.setEnabled(false);
                    } else {
                        right.setEnabled(true);
                    }
                }
            }
            
            if(y < 0) {
                down.setEnabled(true);
                up.setEnabled(false);
            } else {
                if(y > 0) {
                    up.setEnabled(true);
                    
                    if(y >= frY-(CIRCLE_SIZE*2 + CIRCLE_SIZE/2)) {
                        down.setEnabled(false);
                    } else {
                        down.setEnabled(true);
                    }
                }
            }
        }
    }
}
