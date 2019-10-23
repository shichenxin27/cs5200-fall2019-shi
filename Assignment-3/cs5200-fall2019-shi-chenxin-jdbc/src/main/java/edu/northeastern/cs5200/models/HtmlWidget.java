package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget {
	private String html;
	private int pageId;
	
	public HtmlWidget(int id, String name, Integer width, Integer height, String cssClass, String cssStyle, String text, int order, String html) {
	    super(id, name, width, height, cssClass, cssStyle, text, order);
	    this.html = html;
	    this.setDtype("html");
	  }
	
	public HtmlWidget(int id, String name, Integer width, Integer height, String cssClass, String cssStyle, String text, int order) {
	    super(id, name, width, height, cssClass, cssStyle, text, order);
	    this.setDtype("html");
	  }
	
	public HtmlWidget(int id, String name, Integer width, Integer height, String cssClass, String cssStyle, String text, int order, String html, int pageId) {
	    super(id, name, width, height, cssClass, cssStyle, text, order);
	    this.html = html;
	    this.pageId = pageId;
	    this.setDtype("html");
	  }
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}
