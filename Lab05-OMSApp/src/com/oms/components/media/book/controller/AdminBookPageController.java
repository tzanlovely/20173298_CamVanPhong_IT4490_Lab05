package com.oms.components.media.book.controller;

import java.util.List;
import java.util.Map;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSinglePane;
import com.oms.components.media.controller.AdminMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;
import com.oms.factory.AdminPageFactory;
import com.oms.serverapi.IMediaAPI;
import com.oms.serverapi.MediaApi;
import com.oms.serverapi.bookapi.BookApi;
import com.oms.serverapi.bookapi.IBookAPI;

public class AdminBookPageController extends AdminMediaPageController{
	static {
		AdminPageFactory.register("AdminBookPage", new AdminBookPageController().getDataPagePane());
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
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
	
	@Override
	public Media updateMedia(Media media) {
		IBookAPI api = BookApi.getInstance();

		return api.updateBook((Book) media);
	}
}
