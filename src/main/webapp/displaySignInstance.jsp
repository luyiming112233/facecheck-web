<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <title>打卡详情</title>
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
        <th lay-data="{field:'stuID', width:100}">签到实例id</th>
        <th lay-data="{field:'stuID', width:100}">打卡ID</th>
        <th lay-data="{field:'name', width:100, sort:true}">开始时间</th>
        <th lay-data="{field:'sex', width:100, sort:true}">结束时间</th>
        <th lay-data="{field:'clazz', width:120, sort:true}">经度</th>
        <th lay-data="{field:'depart', width:120, sort:true}">纬度</th>
        <th lay-data="{field:'depart', width:120, sort:true}">地点</th>
        <th lay-data="{field:'depart', width:120, sort:true}">打卡半径</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="signInstances">
        <tr>
            <td><s:property value="signInstID" /> </td>
            <td><s:property value="signID" /></td>
            <td><s:date name="startTime" format="HH:mm:ss" /></td>
            <td><s:date name="endTime" format="HH:mm:ss" /></td>
            <td><s:property value="longitude" /> </td>
            <td><s:property value="latitude" /></td>
            <td><s:property value="placeName" /></td>
            <td><s:property value="radius" /> </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
<script >
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        form.on('submit(formDemo)', function(data){
            console.log('!!!!!!!!');
        });


        form.render();
    });

</script>
</body>
</html>
