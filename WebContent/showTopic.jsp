<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>韩美娜专区</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>
<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<form action="" class="simpleSearchForm" onsubmit="alert('暂不支持此功能！');return false;">
			<font class="logoLabel">韩美娜贴吧</font>
			<input type="text" name="queryString" class="queryString"/>
			<input type="submit" value="搜 索" />
		</form>
	</div>
	<!-- 菜单 -->
	<div class="menubar">
		<s:a action="TopicAction_list" namespace="/">主题列表</s:a>
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red"><s:property  value="#findTopic.replySet.size+1" /></font>篇帖子
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num"><s:property  value="#findTopic.tid" /> </td>
	        <td><s:property value="#findTopic.title"/></td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre><s:property value="#findTopic.topicContent"/></pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者：<font color="blue"><s:property value="#findTopic.ipAddr"/></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999">发帖时间：<s:date name="#findTopic.createDate" format="yyyy-MM-dd hh:mm:ss" /></font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->
	<s:iterator value="#findTopic.replySet" var="replySet">
	<table class="postList" cellspacing="0">
        <tr class="title">
            <td width="20" class="num"><s:property  value="rid+1"/></td>
            <td></td>
        </tr>
        <tr class="content">
            <td></td>
            <td><pre><s:property value="replyContent"/></pre></td>
        </tr>
        <tr class="info">
            <td></td>
            <td>
				作者：<font color="blue"><s:property value="ipAddr"/></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="#999999">回帖时间：<s:date name="createDate"  format="yyyy-MM-dd hh:mm:ss" /></font>
            </td>
        </tr>
    </table>
    </s:iterator>
	
    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<s:form action="TopicAction_addReply" namespace="/" theme="simple" cssClass="addNewTopicForm">
	       <s:hidden name="topic.tid" value="%{#findTopic.tid}"></s:hidden>
	
		<table class="publishArticleForm">
	        <tr>
	            <td class="label">内　容:</td>  
	            <td> <s:textarea name="reply.replyContent" cssClass="content"></s:textarea></td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><input type="submit" value="回　贴"/></td>
	        </tr>
	    </table>
</s:form>
</body>
</html>