/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.website.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.website.entity.WebsiteArticle;

/**
 * 网站DAO接口
 * @author liwei
 * @version 2019-07-26
 */
@MyBatisDao
public interface WebsiteArticleDao extends CrudDao<WebsiteArticle> {
	
}