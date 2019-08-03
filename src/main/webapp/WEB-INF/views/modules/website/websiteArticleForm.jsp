<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/website/websiteArticle/">管理列表</a></li>
		<li class="active"><a href="${ctx}/website/websiteArticle/form?id=${websiteArticle.id}">管理<shiro:hasPermission name="website:websiteArticle:edit">${not empty websiteArticle.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="website:websiteArticle:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="websiteArticle" action="${ctx}/website/websiteArticle/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">文章标题：</label>
			<div class="controls">
				<form:input path="articleTitle" htmlEscape="false" maxlength="500" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章作者：</label>
			<div class="controls">
				<sys:treeselect id="articleAuthor" name="articleAuthor" value="${websiteArticle.articleAuthor}" labelName="" labelValue="${websiteArticle.articleAuthor}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章内容：</label>
			<div class="controls">
				<form:textarea path="articleContent" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布机构：</label>
			<div class="controls">
				<form:input path="articleDept" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">责任编辑：</label>
			<div class="controls">
				<form:input path="articleEdit" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章关键词：</label>
			<div class="controls">
				<form:input path="articleKey" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章敏感词：</label>
			<div class="controls">
				<form:input path="articleTac" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否敏感文章 0：不是敏感文章；1：是敏感文章：</label>
			<div class="controls">
				<form:input path="articleTacsign" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章原始URL：</label>
			<div class="controls">
				<form:input path="articleActUrl" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章摘要：</label>
			<div class="controls">
				<form:input path="articleAbstract" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章来源：</label>
			<div class="controls">
				<form:input path="articleSource" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章来源级别：</label>
			<div class="controls">
				<form:input path="articleSourceSign" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">首图URL：</label>
			<div class="controls">
				<form:input path="mainUrl" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章视频URL：</label>
			<div class="controls">
				<form:input path="videoUrl" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文章视频截图URL：</label>
			<div class="controls">
				<form:input path="videoImageUrl" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">访问次数：</label>
			<div class="controls">
				<form:input path="vistinum" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">置顶标识：</label>
			<div class="controls">
				<form:input path="dotop" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属栏目：</label>
			<div class="controls">
				<form:input path="itemNo" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">0：未选取；1：已选取：</label>
			<div class="controls">
				<form:input path="flowSign" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">0:通过管道；1：自行添加  默认为：0：</label>
			<div class="controls">
				<form:input path="source" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">官网栏目标识：</label>
			<div class="controls">
				<form:input path="netSign" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">管网栏目标识：</label>
			<div class="controls">
				<form:input path="pipeSing" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="website:websiteArticle:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>