package sy.common.model;

public class ZtreeNode {

	private String id;
	private String name;
	private boolean checked = false;
	private String isParent = "false";
	private boolean open = false;
	private String pageURL;
	private String pid;
	private String isExpand;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public String getPid() {
		return pid;
	}

	public String getIsExpand() {
		return isExpand;
	}

	public void setIsExpand(String isExpand) {
		this.isExpand = isExpand;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
