<%--
lly
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="utf-8"/>
</head>
<body>
<!-- 按名称查找 -->
<s:form action="ByName" method="post" name="findByname">
    <s:hidden name="publisher.id" value="2"></s:hidden>
    <s:textfield name="result.name"/>
    <s:submit value="按名称查找"/>
</s:form>
<!-- 按时间查找 -->
<s:form action="ByTime" method="post" name="findBytime">
    <s:hidden name="publisher.id" value="2"></s:hidden>
    <sx:datetimepicker name="result.time"/>
    <s:submit value="按时间查找"/>
</s:form>
<s:form action="lookAll" method="post" name="lookAll">
    <s:hidden name="publisher.id" value="2"/>
    <s:submit value="查看所有"/>
</s:form>
<!-- 显示 -->
<table align="center" border="1">
    <tr>
        <td>签到项目</td>
        <td>发布时间</td>
        <td>应到人数</td>
        <td>签到人数</td>
    </tr>
    <s:iterator value="results">
        <tr>
            <td><s:property value="name"/></td>
            <td><s:property value="time"/></td>
            <td><s:property value="all"/></td>
            <td><s:property value="fact"/></td>
            <td>
                <s:form action="signDetails" method="post">
                    <s:hidden name="result.sign_id" value="1"/>
                    <s:submit value="查看"/>
                </s:form>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>