<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/4
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchNotice</title>

</head>
<body>

<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">

    </div>
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        查询所有通知
    </div>
    <table class="layui-table" lay-data="{height:500, page:true, id:'stuTable'}" lay-filter="test" >
        <thead>
        <tr>
            <th lay-data="{field:'title', width:100}">标题</th>
            <th lay-data="{field:'content', width:600, sort:true}">内容</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#session.noticeList">
            <tr>
                <td><s:property value="title"/></td>
                <td><s:property value="content"/></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <form action="searchNotice" method="post" >
        <s:hidden value="%{#session.teacher.teaID}" name="notice.teaID"></s:hidden>
    <button class="layui-btn" type="submit">查询</button>
    </form>


</div>
</body>
</html>
