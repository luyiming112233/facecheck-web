<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <title>�û���¼ҳ��</title>

</head>

<form action="Teacherlogin" method="post">

    �������û�����<input name="teacher.teacherId" type="text"><BR>
    ���������룺<input name="teacher.password" type="password">
    <input type="submit" value="��ʦ��¼">

</form>
<form action="Adminlogin" method="post">
    �������û�����<input name="admin.adminId" type="text"><BR>
    ���������룺<input name="admin.password" type="password">
    <input type="submit" value="����Ա��¼">
</form>
</form>
<form action="AdminRegister" method="post">
    �������û�����<input name="admin.adminId" type="text"><BR>
    ���������룺<input name="admin.password" type="password">
    <input type="submit" value="����Աע��">
</form>
</html>


