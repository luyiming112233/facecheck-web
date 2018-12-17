<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>开始</title>
    <sx:head  extraLocales="en"/> </head>
</head>

<body>

   <a href="./getAllSign">显示所有打卡记录</a>
   <s:form action="getAllSignByName" method="POST">
       <s:textfield name="sign.name" label="请输入打卡名" />
       <s:submit value="查询"/>
   </s:form>

   <s:form action="getAllSignByCreatetime" method="POST">
       <sx:datetimepicker name="sign.createTime" displayFormat="yyyy-MM-dd " label="请选择打卡创建日期" language="en"/>

       <s:submit value="查询"/>
   </s:form>
   <s:form action="getAllSignByTeaid" method="POST">
       <s:textfield name="sign.teaID" label="请输入教师id" />
       <s:submit value="查询"/>
   </s:form>


</body>
</html>