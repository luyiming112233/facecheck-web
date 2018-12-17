<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>打卡详情</title>
</head>
<body>
<center>打卡详情</center>
<table border=1>
    <tr>
        <th>签到实例id</th>
        <th>打卡id</th>
        <th>开始时间</th><!-- 现在简略的显示0和1，后期会换成图片的勾差或者其他-->
        <th>结束时间</th>
        <th>经度</th>
        <th>纬度</th>
        <th>地点</th>
        <th>日期</th><!-- 现在简略的显示0和1，后期会换成图片的勾差或者其他-->
        <th>打卡半径</th>
    </tr>
    <s:iterator value="signInstances">
        <tr>
            <td><s:property value="signInstID" /> </td>
            <td><s:property value="signID" /></td>
            <td><s:date name="startTime" format="HH:mm:ss" /></td>
            <td><s:date name="endTime" format="HH:mm:ss" /></td>
            <td><s:property value="longitude" /> </td>
            <td><s:property value="latitude" /></td>
            <td><s:property value="placeName" /></td>
            <td><s:date format="YYYY-MM-dd"  name="date" /></td>
            <td><s:property value="radius" /> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
