package edu.northeastern.cs5200.models;

public class YouTubeWidget extends Widget {
	private String url;
    private Boolean shareble = false;
    private Boolean expandable = false;
    private int pageId;
    
    public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String url) {
        super(id, name, width, height, cssClass, cssStyle, text, order);
        this.url = url;
        this.setDtype("youtube");
    }

    public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String url, Boolean shareble, Boolean expandable) {
        super(id, name, width, height, cssClass, cssStyle, text, order);
        this.url = url;
        this.shareble = shareble;
        this.expandable = expandable;
        this.setDtype("youtube");
    }
    
    public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, String url, Boolean shareble, Boolean expandable, int pageId) {
        super(id, name, width, height, cssClass, cssStyle, text, order);
        this.url = url;
        this.shareble = shareble;
        this.expandable = expandable;
        this.pageId = pageId;
        this.setDtype("youtube");
    }
    
    public String getUrl() {
		return url;
	}
    
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Boolean getShareble() {
		return shareble;
	}
	
	public void setShareble(Boolean shareble) {
		this.shareble = shareble;
	}
	
	public Boolean getExpandable() {
		return expandable;
	}
	
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}
