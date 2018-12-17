<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/9
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息页面</title>
</head>
<body>
<s:form action="teaMessageUpdate" method="POST">
    <s:textfield name="teacher.teaID" key="工号"/>
    <s:textfield name="teacher.name" key="姓名"/>
    <s:textfield name="teacher.password" key="密码"/>
    <s:textfield name="teacher.sex" key="性别"/>
    <s:textfield name="teacher.phone" key="电话"/>
    <s:submit value="修改"/>
</s:form>
<s:form action="teaMessageDelete" method="POST">
    <s:hidden name="teaID" value="%{teacher.teaID}"/>
    <s:submit value="删除"/>
</s:form>
</body>
</html>