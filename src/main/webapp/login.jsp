<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>�������л���ע���¼��ģ��</title>
    <link href='layui/css/BiaoKuang.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="layui/css/normalize.min.css">
    <link rel="stylesheet" href="layui/css/style.css">
</head>

<body>

<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="login.jsp">��ʦ��½</a></li>
        <li class="tab"><a href="admin.jsp">����Ա��½</a></li>
    </ul>

    <div class="tab-content">
        <div id="teacher">
            <h1>��ʦ��½</h1>

            <form action="Teacherlogin" method="post">

                <div class="field-wrap">
                    <label>
                       �������˺�<span class="req">*</span>
                    </label>
                    <input type="text" name="teacher.teaID"required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                       ����������<span class="req">*</span>
                    </label>
                    <input type="password" name="teacher.password" required autocomplete="off"/>
                </div>

                <button type="submit" class="button button-block"/>��½</button>

            </form>

        </div>


    <div id="admin">
        <h1>����Ա��½</h1>

        <form action="/" method="post">

            <div class="field-wrap">
                <label>
                    �������˺�<span class="req">*</span>
                </label>
                <input type="text" name="teacher.teaID"required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    ����������<span class="req">*</span>
                </label>
                <input type="password" name="teacher.password" required autocomplete="off"/>
            </div>

            <button type="submit" class="button button-block"/>��½</button>

        </form>

    </div>
</div>
</div>


<script src='js/jquery.min.js'></script>

<script  src="js/index.js"></script>
</body>
</html>
