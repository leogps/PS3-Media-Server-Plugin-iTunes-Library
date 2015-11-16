package com.gps.ps3.media.server.plugin.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * PMS - Itunes Library Parser Plugin UI.
 * @author leogps
 *
 */
public class PluginUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8223306790029194820L;
	
	//private JFrame frame;
	private JTextField libraryFilePathTextField;
	private JLabel statusMessageLabel;
	private JButton browseButton;
	JPanel rootPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PluginUI window = new PluginUI();
					window.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PluginUI() {
		initialize();
		//this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.getContentPane().add(rootPanel, BorderLayout.CENTER);
		rootPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel leftMarginPanel = new JPanel();
		rootPanel.add(leftMarginPanel, BorderLayout.WEST);
		
		JPanel rightMarginPanel = new JPanel();
		rootPanel.add(rightMarginPanel, BorderLayout.EAST);
		
		JPanel topMarginPanel = new JPanel();
		rootPanel.add(topMarginPanel, BorderLayout.NORTH);
		
		JPanel bottomMarginPanel = new JPanel();
		rootPanel.add(bottomMarginPanel, BorderLayout.SOUTH);
		
		JPanel mainPanel = new JPanel();
		rootPanel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		
		JLabel titleLabel = new JLabel("Itunes Library Parser Plugin v1.0");
		titlePanel.add(titleLabel);
		
		JPanel authorPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) authorPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		titlePanel.add(authorPanel);
		
		JLabel authorLabel = new JLabel("by leogps");
		authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorPanel.add(authorLabel);
		
		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel bodyPanel = new JPanel();
		panel_3.add(bodyPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel seperatorPanel = new JPanel();
		bodyPanel.add(seperatorPanel, BorderLayout.NORTH);
		seperatorPanel.setLayout(new BoxLayout(seperatorPanel, BoxLayout.X_AXIS));
		
		JSeparator separator = new JSeparator();
		seperatorPanel.add(separator);
		
		JPanel secondBodyWrapperPanel = new JPanel();
		bodyPanel.add(secondBodyWrapperPanel);
		secondBodyWrapperPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel browsePanel = new JPanel();
		secondBodyWrapperPanel.add(browsePanel, BorderLayout.NORTH);
		browsePanel.setLayout(new BorderLayout(0, 0));
		
		browseButton = new JButton("Browse for library file");
		browsePanel.add(browseButton, BorderLayout.WEST);
		
		libraryFilePathTextField = new JTextField();
		libraryFilePathTextField.setEditable(false);
		libraryFilePathTextField.setText("...");
		browsePanel.add(libraryFilePathTextField, BorderLayout.CENTER);
		libraryFilePathTextField.setColumns(10);
		
		Component browseBottomStrut = Box.createVerticalStrut(20);
		browsePanel.add(browseBottomStrut, BorderLayout.SOUTH);
		
		Component browseTopStrut = Box.createVerticalStrut(20);
		browsePanel.add(browseTopStrut, BorderLayout.NORTH);
		
		JPanel thirdBodyWrapperPanel = new JPanel();
		secondBodyWrapperPanel.add(thirdBodyWrapperPanel, BorderLayout.CENTER);
		thirdBodyWrapperPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel statusPanel = new JPanel();
		thirdBodyWrapperPanel.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel statusLabel = new JLabel("Status:");
		statusPanel.add(statusLabel, BorderLayout.WEST);
		
		statusMessageLabel = new JLabel("OK");
		statusPanel.add(statusMessageLabel, BorderLayout.CENTER);
	}

	public JLabel getStatusMessageLabel() {
		return statusMessageLabel;
	}
	public JButton getBrowseButton() {
		return browseButton;
	}
	public JTextField getLibraryFilePathTextField() {
		return libraryFilePathTextField;
	}
	
	public JPanel getRootPanel() {
		return rootPanel;
	}

}
