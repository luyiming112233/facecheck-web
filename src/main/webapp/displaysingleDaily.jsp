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
        <th>打卡ID</th>
        <th>打卡时段</th>
        <th>打卡地点</th><!-- 现在简略的显示0和1，后期会换成图片的勾差或者其他-->
        <th>总人数</th>
        <th>已打卡人数</th>
    </tr>
    <s:iterator value="singleDaily">
        <tr>
            <td><s:property value="dailyID" /> </td>
            <td><s:property value="times" /></td>
            <td><s:property value="place" /></td>
            <td><s:property value="totalP" /></td>
            <td><s:property value="sucP" /> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
