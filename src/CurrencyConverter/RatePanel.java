/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

/**
 *
 * @author Zara Veda
 */

// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    private JComboBox comboBox;
    private JTextField cost;
    
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel (Container pane)
    {
        GridBagConstraints c = new GridBagConstraints();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.VERTICAL;
        
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica Neue", Font.BOLD, 16));
        
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.2;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(title, c);
        
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..", "European Euro",
            "Canadian Dollar", "Japanese Yen", "Australian Dollar",
            "Indian Rupee", "Mexican Peso"};
        rate = new double [] {0.0, 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880};
        
        JLabel costItemText = new JLabel ("Cost of item : ");
        costItemText.setFont (new Font ("Helvetica Neue", Font.ITALIC, 12));
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(costItemText, c);
        
        cost = new JTextField(16);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(cost, c);
        
        comboBox = new JComboBox(currencyName);
        comboBox.addActionListener(new ComboListener());
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(comboBox, c);
        
        result = new JLabel ("=== Result ===");
        
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(result, c);
        
//        add(title);
//        add(costItemText);
//        add(cost);
//        add(comboBox);
//        add(result);
    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener
    {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        
        @Override
        public void actionPerformed (ActionEvent event)
        {
            int index = comboBox.getSelectedIndex();
            result.setText (cost.getText() + " " + currencyName[index] +
            " = " + rate[index]*Integer.parseInt(cost.getText()) + " U.S. Dollars");
        }
    }
}
