package com.oms.components.media.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.media.controller.UserMediaPageController;

@SuppressWarnings("serial")
public class UserMediaListPane extends ADataListPane<Media>{
	
	public UserMediaListPane(ADataPageController<Media> controller) {
		this.controller = controller;
	}
}
