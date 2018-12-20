<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 铿然
  Date: 2018/12/19
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>签到查询管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css">

</head>
<body>

    <%@ include file="QuerySign.jsp" %>
    <%@ include file="QuerySignbyCreatetime.jsp" %>
    <%@ include file="displaySign.jsp" %>



<script src="../layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#test1' //指定元素
            });
        });
    </script>
<script >
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功



        form.render();
    });

</script>

</body>
</html>
