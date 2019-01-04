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
    <form class="layui-form"  id="gift" enctype="multipart/form-data">

        <div class="layui-form-item">
            <label class="layui-form-label">礼品编号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="giftId" required lay-verify="required" placeholder="请输入礼品编号"
                       autocomplete="off" class="layui-input" id="giftId">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品名称</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="giftName" required lay-verify="required" placeholder="请输入礼品名称"
                       autocomplete="off" class="layui-input" id="giftName">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品简介</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="giftDescript" required lay-verify="required" placeholder="请输入礼品简介"
                       autocomplete="off" class="layui-input" id="giftDescript">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品积分</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="giftScore" required lay-verify="required" placeholder="请输入礼品积分价值"
                       autocomplete="off" class="layui-input" id="giftScore">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品数量</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="giftQuantity" required lay-verify="required" placeholder="请输入礼品数量"
                       autocomplete="off" class="layui-input" id="giftQuantity">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">礼品图片</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="file" name="file" id="file">
            </div>
        </div>
    </form>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" onclick="savegift()">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>


</div>
<script type="text/javascript" src="jsfile/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="jsfile/main.js" ></script>

<%@ include file="UIbottom.jsp" %>
</body>
</html>