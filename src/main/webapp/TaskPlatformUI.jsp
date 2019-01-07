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
       插入新计划
        </div>
        <form class="layui-form" action="TaskOutCenterAction">

            <div class="layui-form-item">
                <label class="layui-form-label">教师ID</label>
                <div class="layui-input-block" style="width: 200px;">
                    <s:textfield name="sign.teaID" value="%{#session.teacher.teaID}" readonly="true" class="layui-input"/>

                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">计划名称</label>
                <div class="layui-input-block" style="width: 200px;">
                    <input type="text" name="sign.name" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">计划描述</label>
                <div class="layui-input-block" style="width: 200px;">
                    <input type="text" name="sign.description" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">确认</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <button class="layui-btn" onclick="javascrtpt:window.open('createSign.jsp','newwindow')">创建计划</button>
                </div>
            </div>
        </form>



        <table class="layui-table" lay-data="{height:500, page:true, id:'teaTable'}" lay-filter="test" >
            <thead>
            <tr>
                <th lay-data="{field:'name', width:100}">计划名称</th>
                <th lay-data="{field:'createTime', width:200}">创建时间</th>
                <th lay-data="{field:'description', width:400}">计划描述</th>
                <th lay-data="{field:'ops', width:100, sort:true}">操作</th>

            </tr>
            </thead>
            <tbody>
            <s:if test='#session.taskList.signs.size()==0'>
            <td style="background: grey">您还没有打卡计划</td>
                </s:if>

                <s:else>
                <s:iterator id="list" value="%{#session.taskList.signs}" status="check">
            <tr>
                    <td><s:property value="#list.name"></s:property></td>
                    <td><s:date format="yyyy-MM-dd HH:mm:ss" name="#list.createTime"/></td>
                    <td><s:property value="#list.description"></s:property></td>
                    <td><s:a href="templistUI.jsp?signname=%{#list.name}&signid=%{#list.signID}">选择计划</s:a></td>

                </s:iterator>
                </s:else>

        </table>



            </tbody>
        </table>




    </div>

    <script src="../layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <script>
        layui.use('table', function(){
            var table = layui.table;
            //监听表格复选框选择
            table.on('checkbox(demo)', function(obj){
                console.log(obj)
            });
            var $ = layui.$, active = {
                getCheckData: function(){ //获取选中数据
                    var checkStatus = table.checkStatus('stuTable')
                        ,data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                }
                ,getCheckLength: function(){ //获取选中数目
                    var checkStatus = table.checkStatus('stuTable')
                        ,data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                }
                ,isAll: function(){ //验证是否全选
                    var checkStatus = table.checkStatus('stuTable');
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                }
            };

            $('.demoTable .layui-btn').on('click', function(){
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
