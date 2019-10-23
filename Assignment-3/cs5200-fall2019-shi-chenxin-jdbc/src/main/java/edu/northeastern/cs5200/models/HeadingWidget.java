package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget {
	private int size;
	private int pageId;
	
	public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, int size) {
        super(id, name, width, height, cssClass, cssStyle, text, order);
        this.size = size;
        this.setDtype("heading");
    }
	
	public HeadingWidget(int id, String name, int width, int height, String cssStyle, String cssClass, String text, int order) {
		super(id, name, width, height, cssStyle, cssClass, text, order);
		this.setDtype("heading");
	}
	
	public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, int size, int pageId) {
        super(id, name, width, height, cssClass, cssStyle, text, order);
        this.size = size;
        this.pageId = pageId;
        this.setDtype("heading");
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}
