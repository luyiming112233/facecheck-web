<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/28 0028
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        修改兑换礼品
    </div>
    <form class="layui-form" action="updateGift" enctype="multipart/form-data" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label">礼品编号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_id" readonly="true" value=
                <s:property value="gift.gift_id"/> class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品名称</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_name" value=
                <s:property value="gift.gift_name"/> class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品简介</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_descript" value=
                <s:property value="gift.gift_descript"/> class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品积分</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_score" value=
                <s:property value="gift.gift_score"/> class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品数量</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_quantity" value=
                <s:property value="gift.gift_quantity"/> class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <img src=<s:property value="gift.gift_id"/>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="file" name="giftFile">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="showMessage()">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <a href="lookAllGift">查看兑换礼品</a>
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

        function showMessage() {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg('添加成功');
            });
        }
    </script>
</div>


<%@ include file="UIbottom.jsp" %>
</body>
</html>
