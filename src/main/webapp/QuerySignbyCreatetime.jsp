<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layDate快速使用</title>
    <link rel="stylesheet" href="/static/build/layui.css" media="all">
</head>
<body>
<form class="layui-form" action="getAllSignByCreatetime">

    <div class="layui-form-item">
        <label class="layui-form-label" >日期选择</label>
        <div class="layui-input-block">

                <input type="text" class="layui-input" id="test1" name="input">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo1" >查询</button>

        </div>
    </div>
</form>
<script src="../layui/layui.js"></script>
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

        form.on('submit(formDemo1)', function(data){
        });


        form.render();
    });

</script>
</body>
</html>