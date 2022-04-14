<%--
  Created by IntelliJ IDEA.
  User: Saber
  Date: 2022/4/12
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body style="background: bisque">


<br>
<h2 align="center">普通数据类型 表单</h2>
<div align="center">
    <form action="${pageContext.request.contextPath}/web/x4/user01" method="post">
        <input type="text" name="username"><br>
        <input type="text" name="age"><br>
        <input type="submit" value=提交按钮>
    </form>
</div>


<br>
<h2 align="center">POJO数据类型参数 表单</h2>
<div align="center">
    <form action="${pageContext.request.contextPath}/web/x4/user02" method="post">
        <input type="text" name="username"><br>
        <input type="text" name="age"><br>
        <input type="submit" value=提交按钮>
    </form>
</div>


<br>
<h2 align="center">数组类型参数 表单</h2>
<div align="center">
    <form action="${pageContext.request.contextPath}/web/x4/user03" method="post">
        <h3>参数名都是pramName</h3>
        <input type="text" name="pramName"><br>
        <input type="text" name="pramName"><br>
        <input type="submit" value=提交按钮>
    </form>
</div>


<br>
<h2 align="center">集合类型参数 表单 01</h2>
<div align="center" >
    <form action="${pageContext.request.contextPath}/web/x4/user04" method="post">
        <h3>第一个对象</h3>
        <input type="text" name="userList[0].username"><br>
        <input type="text" name="userList[0].age"><br>
        <h3>第二个对象</h3>
        <input type="text" name="userList[1].username"><br>
        <input type="text" name="userList[1].age"><br>
        <h3>第三个对象</h3>
        <input type="text" name="userList[2].username" value=""><br>
        <input type="text" name="userList[2].age"><br>
        <input type="submit" value=提交按钮>
    </form>
</div>


<br>
<h2 align="center">集合类型参数 表单 02</h2>
<div align="center" id="app">
    <input type="button" value="XXXXX" id="butt">
</div>


<br><br>
<h2 align="center">解决中文乱码问题</h2>
<div align="center">
    <form action="${pageContext.request.contextPath}/web/x4/setEncoding" method="post">
        <h3>参数名有中文</h3>
        <input type="text" name="username"><br>
        <input type="text" name="age"><br>
        <input type="submit" value=提交按钮>
    </form>
</div>



<%-- 阿贾克斯 请求 --%>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    var userList = new Array();
    userList.push({username:"zhangsan",age:18});
    userList.push({username:"lisi",age:28});

    document.getElementById("butt").onclick = function (){
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/web/x4/dame05",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        })
    }


</script>

</script>

</body>
</html>
