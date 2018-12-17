<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>学生信息管理页面</title>
</head>
<body>
<h2><s:property value="#request.tip"/></h2>
<h3>添加学生</h3>
<s:form action="studentAdd" method="post">
    <s:textfield name="student.stuID" key="学号"/>
    <s:textfield name="student.name" key="姓名"/>
    <s:textfield name="student.clazz" key="班级"/>
    <s:textfield name="student.depart" key="专业"/>
    <s:textfield name="student.email" key="邮箱"/>
    <s:submit value="添加"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="stuSearch" method="post" >
    <s:textfield name="student.stuID" key="学号"/>
    <s:submit value="按学号查询"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="stuSearch" method="post">
    <s:textfield name="student.clazz" key="班级"/>
    <s:submit value="按班级查询"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<s:form action="stuSearch" method="post">
    <s:textfield name="student.depart" key="专业"/>
    <s:submit value="按专业查询"/>
    <s:reset value="清除"/>
</s:form>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#987cb9 SIZE=3>
<table border=1>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>班级</th>
        <th>专业</th>
    </tr>
    <s:iterator value="#request['studentList']" >
        <tr>
            <td><a href="stuMessage?stuID=<s:property value="stuID"/>"><s:property value="stuID"/></a> </td>
            <td><s:property value="name"/></td>
            <td><s:property value="clazz"/></td>
            <td><s:property value="depart"/></td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
