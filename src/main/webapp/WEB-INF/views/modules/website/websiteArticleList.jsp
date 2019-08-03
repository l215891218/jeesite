<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/website/websiteArticle/">管理列表</a></li>
		<shiro:hasPermission name="website:websiteArticle:edit"><li><a href="${ctx}/website/websiteArticle/form">管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="websiteArticle" action="${ctx}/website/websiteArticle/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>文章标题：</label>
				<form:input path="articleTitle" htmlEscape="false" maxlength="500" class="input-medium"/>
			</li>
			<li><label>文章内容：</label>
				<form:input path="articleContent" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>发布机构：</label>
				<form:input path="articleDept" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>文章标题</th>
				<th>系统时间。</th>
				<th>责任编辑</th>
				<th>文章摘要</th>
				<shiro:hasPermission name="website:websiteArticle:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="websiteArticle">
			<tr>
				<td><a href="${ctx}/website/websiteArticle/form?id=${websiteArticle.id}">
					${websiteArticle.articleTitle}
				</a></td>
				<td>
					<fmt:formatDate value="${websiteArticle.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${websiteArticle.articleEdit}
				</td>
				<td>
					${websiteArticle.articleAbstract}
				</td>
				<shiro:hasPermission name="website:websiteArticle:edit"><td>
    				<a href="${ctx}/website/websiteArticle/form?id=${websiteArticle.id}">修改</a>
					<a href="${ctx}/website/websiteArticle/delete?id=${websiteArticle.id}" onclick="return confirmx('确认要删除该管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>