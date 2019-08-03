/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.website.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 网站Entity
 * @author liwei
 * @version 2019-07-26
 */
public class WebsiteArticle extends DataEntity<WebsiteArticle> {
	
	private static final long serialVersionUID = 1L;
	private String articleTitle;		// 文章标题
	private String articleAuthor;		// 文章作者
	private String articleContent;		// 文章内容
	private String articleDept;		// 发布机构
	private String articleEdit;		// 责任编辑
	private String articleKey;		// 文章关键词
	private String articleTac;		// 文章敏感词
	private String articleTacsign;		// 是否敏感文章 0：不是敏感文章；1：是敏感文章
	private String articleActUrl;		// 文章原始URL
	private String articleActDate;		// 文章发布时间
	private String articleAbstract;		// 文章摘要
	private String articleSource;		// 文章来源
	private String articleSourceSign;		// 文章来源级别
	private String mainUrl;		// 首图URL
	private String videoUrl;		// 文章视频URL
	private String videoImageUrl;		// 文章视频截图URL
	private String vistinum;		// 访问次数
	private String dotop;		// 置顶标识
	private String itemNo;		// 所属栏目
	private String flowSign;		// 0：未选取；1：已选取
	private String source;		// 0:通过管道；1：自行添加  默认为：0
	private String netSign;		// 官网栏目标识
	private String pipeSing;		// 管网栏目标识
	
	public WebsiteArticle() {
		super();
	}

	public WebsiteArticle(String id){
		super(id);
	}

	@Length(min=1, max=500, message="文章标题长度必须介于 1 和 500 之间")
	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	@Length(min=0, max=500, message="文章作者长度必须介于 0 和 500 之间")
	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	
	@Length(min=1, max=255, message="文章内容长度必须介于 1 和 255 之间")
	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	@Length(min=0, max=200, message="发布机构长度必须介于 0 和 200 之间")
	public String getArticleDept() {
		return articleDept;
	}

	public void setArticleDept(String articleDept) {
		this.articleDept = articleDept;
	}
	
	@Length(min=0, max=200, message="责任编辑长度必须介于 0 和 200 之间")
	public String getArticleEdit() {
		return articleEdit;
	}

	public void setArticleEdit(String articleEdit) {
		this.articleEdit = articleEdit;
	}
	
	@Length(min=0, max=200, message="文章关键词长度必须介于 0 和 200 之间")
	public String getArticleKey() {
		return articleKey;
	}

	public void setArticleKey(String articleKey) {
		this.articleKey = articleKey;
	}
	
	@Length(min=0, max=200, message="文章敏感词长度必须介于 0 和 200 之间")
	public String getArticleTac() {
		return articleTac;
	}

	public void setArticleTac(String articleTac) {
		this.articleTac = articleTac;
	}
	
	public String getArticleTacsign() {
		return articleTacsign;
	}

	public void setArticleTacsign(String articleTacsign) {
		this.articleTacsign = articleTacsign;
	}
	
	@Length(min=0, max=1000, message="文章原始URL长度必须介于 0 和 1000 之间")
	public String getArticleActUrl() {
		return articleActUrl;
	}

	public void setArticleActUrl(String articleActUrl) {
		this.articleActUrl = articleActUrl;
	}
	
	@Length(min=0, max=20, message="文章发布时间长度必须介于 0 和 20 之间")
	public String getArticleActDate() {
		return articleActDate;
	}

	public void setArticleActDate(String articleActDate) {
		this.articleActDate = articleActDate;
	}
	
	@Length(min=0, max=1000, message="文章摘要长度必须介于 0 和 1000 之间")
	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	
	@Length(min=0, max=200, message="文章来源长度必须介于 0 和 200 之间")
	public String getArticleSource() {
		return articleSource;
	}

	public void setArticleSource(String articleSource) {
		this.articleSource = articleSource;
	}
	
	public String getArticleSourceSign() {
		return articleSourceSign;
	}

	public void setArticleSourceSign(String articleSourceSign) {
		this.articleSourceSign = articleSourceSign;
	}
	
	@Length(min=0, max=200, message="首图URL长度必须介于 0 和 200 之间")
	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}
	
	@Length(min=0, max=200, message="文章视频URL长度必须介于 0 和 200 之间")
	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	@Length(min=0, max=200, message="文章视频截图URL长度必须介于 0 和 200 之间")
	public String getVideoImageUrl() {
		return videoImageUrl;
	}

	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}
	
	public String getVistinum() {
		return vistinum;
	}

	public void setVistinum(String vistinum) {
		this.vistinum = vistinum;
	}
	
	public String getDotop() {
		return dotop;
	}

	public void setDotop(String dotop) {
		this.dotop = dotop;
	}
	
	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	public String getFlowSign() {
		return flowSign;
	}

	public void setFlowSign(String flowSign) {
		this.flowSign = flowSign;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=50, message="官网栏目标识长度必须介于 0 和 50 之间")
	public String getNetSign() {
		return netSign;
	}

	public void setNetSign(String netSign) {
		this.netSign = netSign;
	}
	
	@Length(min=0, max=50, message="管网栏目标识长度必须介于 0 和 50 之间")
	public String getPipeSing() {
		return pipeSing;
	}

	public void setPipeSing(String pipeSing) {
		this.pipeSing = pipeSing;
	}
	
}