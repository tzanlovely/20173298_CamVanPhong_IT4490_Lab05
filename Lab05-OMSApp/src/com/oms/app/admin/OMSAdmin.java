package com.oms.app.admin;

import com.oms.bean.Media;
import com.oms.bean.PhysicalMedia;
import com.oms.factory.AdminPageFactory;

import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin(OMSAdminController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		
		JTabbedPane tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		
		
		JPanel bookPage = AdminPageFactory.createPane("AdminBookPage");
		tabbedPane.addTab("Books", null, bookPage, "Books");
		
		
		tabbedPane.addTab("Compact Discs", null, new JPanel(), "Compact Discs");
		tabbedPane.addTab("Digital Video Discs", null, new JPanel(), "Digital Video Discs");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Online Media System for Administrator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Class.forName("com.oms.components.media.book.controller.AdminBookPageController");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OMSAdmin(new OMSAdminController());
			}
		});
	}
}