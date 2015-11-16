package com.gps.ps3.media.server.plugin.ui.test;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gps.ps3.media.server.plugin.ui.PluginUI;

/**
 * Created with IntelliJ IDEA.
 * User: leogps
 * Date: 9/22/13
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestPluginUI {

    public static void main(String[] args) {
        PluginUI pluginUI = new PluginUI();
        /*frame.setContentPane(pluginUI.getFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        //pluginUI.getFrame().pack();
       // pluginUI.getFrame().setVisible(true);
        //new PluginUIController(pluginUI).delegateControl();
        
        JOptionPane.showOptionDialog(
				new JFrame(), 
				pluginUI.getRootPanel(),
				"Hello",
				JOptionPane.CLOSED_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, null, null);
        
        
    }
}
