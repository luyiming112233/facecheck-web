<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<%@ include file="UITeaOpeHead.jsp" %>
<link rel="stylesheet" href="./cssfile/kalendae.css" type="text/css">
<script type='text/javascript' src='./jsfile/kalendae.standalone.js'></script>
<script type="text/javascript">

    function  handed() {

        var rows = document.getElementById('table').rows;
        var chk = document.getElementById('table').getElementsByTagName("input");
        var str = "";
        for (var i = 0; i < chk.length; i++) {
            if (chk[i].type == "checkbox") {
                if (chk[i].checked) {
                    var row = chk[i].parentElement.parentElement.rowIndex;
                    str += rows[row].cells[0].innerHTML + ","
                }
            }
        }
        str = str.substring(0, str.length - 1);
        document.getElementById("stulist").value = str;
        console.log(str);


    }
</script>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        创建新计划
    </div>
    <form class="layui-form" action="newInsAction" method="post">
        <s:hidden name="sign.teaID" value="#session.teaID"/>
        <input type="text" value="${param.templateid}" hidden name="templateid">
        <input type="text" value="${param.chooseid}" hidden name="chooseid">
        <input type="text" value="${param.choosename}" hidden name="choosename">



        <div class="layui-form-item">
            <label class="layui-form-label">时间选择</label>
            <div class="layui-input-block" style="width: 200px;">
                <s:textfield  class="auto-kal" data-kal="mode:'multiple'" style="width: 100%;height:200%;" readonly="true" format="YYYY-MM-DD" name="datelist" />
            </div>
        </div>
        <s:textfield name="stulist" id="stulist" hidden="true"/>







        <table id="table" class="layui-table" >

            <thead>
            <br>

            <tr>
                <th lay-data="{field:'startTime', width:100, sort:true}">学号</th>
                <th lay-data="{field:'endTime', width:100, sort:true}">姓名</th>
                <th lay-data="{field:'ope',width:200}">操作</th>
            </tr>
            </thead>

            <tbody>
            <s:iterator id="list" value="#request.students" status="check">
                <td><s:property value="#list.stuID" ></s:property></td>
                <td><s:property value="#list.name"></s:property></td>
                <s:url var="urlName" action="CreateInsAction">
                    <s:param name="templateid" value="#list.stuID"/>
                </s:url>
                <td>
                    <input type="checkbox" name="box" id="#list.stuID"><label for="#list.stuID">选择</label>
                </td>
                </tr>

            </s:iterator>
            </tbody>
        </table>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="handed()">确认</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>






</div>

<script src="../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
