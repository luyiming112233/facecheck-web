<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>打卡列表</title>
</head>
<body>
<center>打卡列表</center>
<table border=1>
    <tr>
        <th>打卡ID</th>
        <th>打卡名</th>
        <th>打卡是否有效</th><!-- 现在简略的显示0和1，后期会换成图片的勾差或者其他-->
        <th>打卡发布日期</th>
        <th>发布人</th>
    </tr>
    <s:iterator value="allDailies">
        <tr>
            <td><a href="./GetsingleDaily?singleDaily.dailyID=${dailyID}">${dailyID}</a> </td>
            <td><s:property value="dailyName" /></td>
            <td><s:if test="isValidate==true">有效</s:if>
                <s:elseif test="isValidate==false">无效</s:elseif></td>
            <td><s:property value="cal" /></td>
            <td><s:property value="arrPerson" /> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
