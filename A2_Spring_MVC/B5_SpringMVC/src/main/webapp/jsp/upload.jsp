<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body style="background: bisque">
<br><br><br>
<div align="center">
    <h1>文件上传 - 单文件上传</h1>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/web/x4/upload01">
        文件名称:<input type="text" name="filename"><br>
        上传文件:<input type="file" name="upload"><br>
        <input type="submit" value="提交上传">
    </form>
</div>


<br><br><br>
<div align="center">
    <h1>文件上传 - 多文件上传 - 02</h1>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/web/x4/upload02-1">
        文件名称:<input type="text" name="filename"><br>
        上传文件:<input type="file" name="upload1"><br>
        上传文件:<input type="file" name="upload2"><br>
        上传文件:<input type="file" name="upload3"><br>
        <input type="submit" value="提交上传">
    </form>
</div>


<br><br><br>
<div align="center">
    <h1>文件上传 - 多文件上传 - 01</h1>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/web/x4/upload02-2">
        文件名称:<input type="text" name="filename"><br>
        上传文件:<input type="file" name="upload"><br>
        上传文件:<input type="file" name="upload"><br>
        上传文件:<input type="file" name="upload"><br>
        <input type="submit" value="提交上传">
    </form>
</div>


</body>
</html>
