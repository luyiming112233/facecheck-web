<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28 0028
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        兑换礼品信息
    </div>
    <table class="layui-table" lay-data="{height:500, page:true}" lay-filter="test">
        <thead>
        <tr>
            <th lay-data="{field:'id'}">礼品编号</th>
            <th lay-data="{field:'name',sort:true}">名称</th>
            <th lay-data="{field:'description', sort:true}">简介</th>
            <th lay-data="{field:'score',  sort:true}">积分</th>
            <th lay-data="{field:'number', sort:true}">数量</th>
            <th lay-data="{field:'ope'}">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="gifts">
            <tr>
                <td><s:property value="gift_id"/>
                <td><s:property value="gift_name"/></td>
                <td><s:property value="gift_descript"/></td>
                <td><s:property value="gift_score"/></td>
                <td><s:property value="gift_quantity"/></td>
                <td>
                    <a href="changeGift?gift.gift_id=<s:property value="gift_id"/>">修改</a>
                    <a href="deleteGift?gift.gift_id=<s:property value="gift_id"/>">删除</a>
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

