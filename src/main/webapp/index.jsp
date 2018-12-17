<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>开始</title>
</head>
<body>

   <a href="./GetallDaily">显示所有打卡记录</a>
<s:form action="GetAllDailyByArrp" method="POST">
    <s:textfield name="allDaily.arrPerson" label="请输入打卡发布人" />
    <s:submit value="查询"/>
</s:form>
   <s:form action="GetAllDailyByCal" method="POST">
       <s:textfield name="allDaily.cal" label="请输入日期（格斯y.m.d）" />
       <s:submit value="查询"/>
   </s:form>
   <s:form action="GetallDailyByDName" method="POST">
       <s:textfield name="allDaily.dailyName" label="请输入打卡名" />
       <s:submit value="查询"/>
   </s:form>
   <s:form action="GetallDailyByDID" method="POST">
       <s:textfield name="allDaily.dailyID" label="请输入打卡id" />
       <s:submit value="查询"/>
   </s:form>
   <s:form action="GetallDailyByVal" method="POST">
       <s:textfield name="allDaily.isValidate" label="请输入是否有效（true或者false）" />
       <s:submit value="查询"/>
   </s:form>
   <s:form action="GetallDailyByfuzzyArrp" method="POST">
       <s:textfield name="allDaily.arrPerson" label="请输入模糊的发布人姓名信息" />
       <s:submit value="查询"/>
   </s:form>
   <s:form action="GetallDailyByfuzzyCal" method="POST">
       <s:textfield name="cal" label="请输入模糊的日历信息" />
       <s:submit value="查询"/>
   </s:form>

</body>
</html>