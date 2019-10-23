package edu.northeastern.cs5200.models;

public class Widget {
	private int id;
    private String name;
    private int width;
    private int height;
    private String cssClass;
    private String cssStyle;
    private String text;
    private int order;
    private int size;
    private String html;
    private String src;
    private String url;
    private Boolean shareable = false;
    private Boolean expandable = false;
    private String dtype;
    private int pageId;
    private Page page;
    
    public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.cssStyle = cssStyle;
        this.text = text;
        this.order = order;
      }
    
    public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, 
    		int size, String html, String src, String url, Boolean shareable, Boolean expandable, String dtype) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.cssStyle = cssStyle;
        this.text = text;
        this.order = order;
        this.size = size;
        this.html = html;
        this.src = src;
        this.url = url;
        this.shareable = shareable;
        this.expandable = expandable;
        this.dtype = dtype;
      }
    
    public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, 
    		int size, String html, String src, String url, Boolean shareable, Boolean expandable, String dtype, int pageId) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.cssStyle = cssStyle;
        this.text = text;
        this.order = order;
        this.size = size;
        this.html = html;
        this.src = src;
        this.url = url;
        this.shareable = shareable;
        this.expandable = expandable;
        this.dtype = dtype;
        this.pageId = pageId;
      }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
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
    
    public Boolean getShareble() {
        return shareable;
    }

    public void setShareble(Boolean shareble) {
        this.shareable = shareble;
    }

    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }
    
    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
    
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
    
    
}
