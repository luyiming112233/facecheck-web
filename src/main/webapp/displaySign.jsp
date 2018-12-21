<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="../layui/css/layui.css">
    <title>打卡列表</title>
</head>
<body>
<table class="layui-table" >
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>

        <th lay-data="{field:'stuID', width:100}">打卡ID</th>
        <th lay-data="{field:'name', width:100, sort:true}">打卡名</th>
        <th lay-data="{field:'sex', width:100, sort:true}">打卡描述</th>
        <th lay-data="{field:'clazz', width:120, sort:true}">打卡发布日期</th>
        <th lay-data="{field:'depart', width:120, sort:true}">教师ID</th>
        <th lay-data="{field:'depart', width:120, sort:true}"></th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="signs">
        <tr>
            <td><s:property value="signID" /></td>
            <td><s:property value="name" /></td>
            <td><s:property value="description" /></td>
            <td><s:date format="YYYY-MM-dd"  name="createTime" /> </td>
            <td><s:property value="teaID" /> </td>
            <td>
                <a href="./getSignInstance?signID=${signID}" style="color: #4476A7">查看</a></td>
        </tr>
    </s:iterator>
    </tbody>
</table>
<script src="../layui/layui.js" charset="utf-8"></script>
<script >
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        form.on('submit(formDemo)', function(data){

        });


        form.render();
    });

</script>
</body>
</html>
