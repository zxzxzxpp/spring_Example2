package com.java.spring.Example013;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.java.spring.Example011.PageRank;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rank-report")
public class PageRankReport {

	@XmlElement(name = "page-rank")
	private List<PageRank> pageRanks;

	public PageRankReport() {
	}
	
	public PageRankReport(List<PageRank> pageRanks) {
		this.pageRanks = pageRanks;
	}

	public List<PageRank> getPageRanks() {
		return pageRanks;
	}

}