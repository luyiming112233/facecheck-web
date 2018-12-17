<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/9
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>教师信息管理页面</title>
</head>
<body>
<h2><s:property value="#request.tip"/></h2>
<h3>添加教师</h3>
<s:form action="teacherAdd" method="post">
    <s:textfield name="teacher.teaID" key="工号"/>
    <s:textfield name="teacher.name" key="姓名"/>
    <s:textfield name="teacher.sex" key="性别"/>
    <s:textfield name="teacher.phone" key="电话"/>
    <s:submit value="添加"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="teacherSearch" method="post" >
    <s:textfield name="teacher.teaID" key="工号"/>
    <s:submit value="按工号查询"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="teacherSearch" method="post">
    <s:textfield name="teacher.name" key="姓名"/>
    <s:submit value="按姓名查询"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="getAllTeachers" method="post">
    <s:submit value="查询所有教师"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<table border=1>
    <tr>
        <th>工号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话</th>
    </tr>
    <s:iterator value="#request['teacherList']" >
        <tr>
            <td><a href="teaMessage?teaID=<s:property value="teaID"/>"><s:property value="teaID"/></a> </td>
            <td><s:property value="name"/></td>
            <td><s:property value="sex"/></td>
            <td><s:property value="phone"/></td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
