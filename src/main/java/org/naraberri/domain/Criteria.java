package org.naraberri.domain;

public class Criteria {

	private int page;
	private String sType;
	private String keyword;

	public Criteria() {
		this(0, null, null);
	}

	public Criteria(int page, String stype, String keyword) {
		super();
		this.page = page;
		this.sType = stype;
		this.keyword = keyword;
	}
	
	

	public int getNum() {
		int num = (page-1)*10;
		
		return num;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {

//		if (page <= 0) {
//			page = 1;
//		}
//		page = (page - 1) * 10;

		this.page = page;
	}

	public String getStype() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = "%" + keyword + "%";
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", sType=" + sType + ", keyword=" + keyword + "]";
	}

}
