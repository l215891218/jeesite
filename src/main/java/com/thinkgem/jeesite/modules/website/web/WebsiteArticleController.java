/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.website.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.website.entity.WebsiteArticle;
import com.thinkgem.jeesite.modules.website.service.WebsiteArticleService;

/**
 * 网站Controller
 * @author liwei
 * @version 2019-07-26
 */
@Controller
@RequestMapping(value = "${adminPath}/website/websiteArticle")
public class WebsiteArticleController extends BaseController {

	@Autowired
	private WebsiteArticleService websiteArticleService;
	
	@ModelAttribute
	public WebsiteArticle get(@RequestParam(required=false) String id) {
		WebsiteArticle entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = websiteArticleService.get(id);
		}
		if (entity == null){
			entity = new WebsiteArticle();
		}
		return entity;
	}
	
	@RequiresPermissions("website:websiteArticle:view")
	@RequestMapping(value = {"list", ""})
	public String list(WebsiteArticle websiteArticle, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WebsiteArticle> page = websiteArticleService.findPage(new Page<WebsiteArticle>(request, response), websiteArticle); 
		model.addAttribute("page", page);
		return "modules/website/websiteArticleList";
	}

	@RequiresPermissions("website:websiteArticle:view")
	@RequestMapping(value = "form")
	public String form(WebsiteArticle websiteArticle, Model model) {
		model.addAttribute("websiteArticle", websiteArticle);
		return "modules/website/websiteArticleForm";
	}

	@RequiresPermissions("website:websiteArticle:edit")
	@RequestMapping(value = "save")
	public String save(WebsiteArticle websiteArticle, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, websiteArticle)){
			return form(websiteArticle, model);
		}
		websiteArticleService.save(websiteArticle);
		addMessage(redirectAttributes, "保存管理成功");
		return "redirect:"+Global.getAdminPath()+"/website/websiteArticle/?repage";
	}
	
	@RequiresPermissions("website:websiteArticle:edit")
	@RequestMapping(value = "delete")
	public String delete(WebsiteArticle websiteArticle, RedirectAttributes redirectAttributes) {
		websiteArticleService.delete(websiteArticle);
		addMessage(redirectAttributes, "删除管理成功");
		return "redirect:"+Global.getAdminPath()+"/website/websiteArticle/?repage";
	}

}