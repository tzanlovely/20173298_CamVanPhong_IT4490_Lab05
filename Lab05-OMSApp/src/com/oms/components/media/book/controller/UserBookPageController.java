package com.oms.components.media.book.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import com.oms.bean.Media;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSinglePane;
import com.oms.components.media.controller.UserMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;
import com.oms.factory.UserPageFactory;
import com.oms.serverapi.MediaApi;
import com.oms.serverapi.bookapi.BookApi;
import com.oms.serverapi.bookapi.IBookAPI;

import javax.swing.*;

public class UserBookPageController extends UserMediaPageController{
	static {
		UserPageFactory.register("UserBookPage", new UserBookPageController().getDataPagePane());
	}

	public UserBookPageController() {
		super();
	}
	public UserBookPageController(CartController cartController) {
		super(cartController);
	}
	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		IBookAPI api = BookApi.getInstance();
		return api.getBooks(searchParams);
	}
	@Override
	public MediaSinglePane createSinglePane() {
		return new BookSinglePane();
	}

	@Override
	public void onEdit(ADataSinglePane<Media> singlePane) {
		JSpinner spin = new JSpinner();
		spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
		singlePane.addDataHandlingComponent(spin);
		spin.setPreferredSize(new Dimension(100, 20));

		JButton button = new JButton("Add to cart");
		singlePane.addDataHandlingComponent(button);

		button.addActionListener(e -> addToCart(singlePane.getData().getId(), singlePane.getData().getTitle(), singlePane.getData().getCost(), (int)spin.getValue()));
	}

	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
}
