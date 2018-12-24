<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        签到详细信息
    </div>
    <table class="layui-table" lay-data="{height:500, page:true}" lay-filter="test">
        <thead>
        <tr>
            <th lay-data="{field:'name'}">签到项目</th>
            <th lay-data="{field:'date',sort:true}">发布日期</th>
            <th lay-data="{field:'startTime', sort:true}">开始时间</th>
            <th lay-data="{field:'endTime',  sort:true}">截止时间</th>
            <th lay-data="{field:'placeName', sort:true}">签到地点</th>
            <th lay-data="{field:'ope'}">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="signinstances">
            <tr>
                <td><s:property value="result.name"/>
                <td><s:property value="date"/></td>
                <td><s:property value="startTime"/></td>
                <td><s:property value="endTime"/></td>
                <td><s:property value="placeName"/></td>
                <td><a href="getDetail?dailyresult.signinstance.signInstID=<s:property value="signInstID"/>">查看</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>


</div>

<script src="../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('stuTable')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('stuTable')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('stuTable');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>


</div>
<%@ include file="UIbottom.jsp" %>
</body>
</html>
