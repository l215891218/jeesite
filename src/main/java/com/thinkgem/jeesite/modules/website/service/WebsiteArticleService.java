/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.website.service;

import java.util.List;

import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.act.utils.ActUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.website.entity.WebsiteArticle;
import com.thinkgem.jeesite.modules.website.dao.WebsiteArticleDao;

/**
 * 网站Service
 * @author liwei
 * @version 2019-07-26
 */
@Service
@Transactional(readOnly = true)
public class WebsiteArticleService extends CrudService<WebsiteArticleDao, WebsiteArticle> {


	@Autowired
	private ActTaskService actTaskService;


	public WebsiteArticle get(String id) {
		return super.get(id);
	}
	
	public List<WebsiteArticle> findList(WebsiteArticle websiteArticle) {
		return super.findList(websiteArticle);
	}
	
	public Page<WebsiteArticle> findPage(Page<WebsiteArticle> page, WebsiteArticle websiteArticle) {
		return super.findPage(page, websiteArticle);
	}
	
	@Transactional(readOnly = false)
	public void save(WebsiteArticle websiteArticle) {
		super.save(websiteArticle);


		// 启动流程
		actTaskService.startProcess("process", "website_tb_article", websiteArticle.getId(),websiteArticle.getArticleTitle());
	}
	
	@Transactional(readOnly = false)
	public void delete(WebsiteArticle websiteArticle) {
		super.delete(websiteArticle);
	}
	
}