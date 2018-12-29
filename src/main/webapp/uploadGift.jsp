<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 12:23
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
        添加兑换礼品
    </div>
    <form class="layui-form" action="giftAdd" enctype="multipart/form-data" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label">礼品编号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_id" required lay-verify="required" placeholder="请输入礼品编号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品名称</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_name" required lay-verify="required" placeholder="请输入礼品名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品简介</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_descript" required lay-verify="required" placeholder="请输入礼品简介"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品积分</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_score" required lay-verify="required" placeholder="请输入礼品积分价值"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品数量</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="gift.gift_quantity" required lay-verify="required" placeholder="请输入礼品数量"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="file" name="giftFile">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="showMessage()">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
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