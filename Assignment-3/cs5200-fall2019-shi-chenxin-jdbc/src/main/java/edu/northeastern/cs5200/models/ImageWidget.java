package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget  {
	private String src;
	private String url;
	private int pageId;

    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String src) {
    	super(id, name, width, height, cssClass, cssStyle, text, order);
        this.src = src;
        this.setDtype("image");
    }
    
    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order) {
    	super(id, name, width, height, cssClass, cssStyle, text, order);
    	this.setDtype("image");
    }
    
    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String src, int pageId) {
    	super(id, name, width, height, cssClass, cssStyle, text, order);
        this.src = src;
        this.pageId = pageId;
        this.setDtype("image");
    }
    
    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String src, String url) {
    	super(id, name, width, height, cssClass, cssStyle, text, order);
        this.src = src;
        this.url = url;
        this.setDtype("image");
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
    
    public String getUrl() {
		return url;
	}
    
	public void setUrl(String url) {
		this.url = url;
	}
    
    public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}
