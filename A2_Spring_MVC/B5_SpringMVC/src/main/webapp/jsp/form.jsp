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
    <form action="${pageContext.request.contextPath}/web/x4/user04" method="">
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

<script src="/js/axios-0.18.0.js"></script>
<script src="/js/vue.js"></script>

<script>

    //TODO:
    /*var json1 = {username:"ganga",age:18};
    var json2 = {username:"gangale",age:18};
    var json3 = {username:"gangaddd",age:18};
    var userList()

    axios({
        method:"POST",
        url:"${pageContext.request.contextPath}/web/x4/user04",
        data:JSON.stringify(userList),
    }).then(function (resp){

    })*/

    /*new Vue({
        el:"#app",
        data(){
            return{

            }
        },
        mounted(){
            axios({
                method:"GET",
                url:"${pageContext.request.contextPath}/web/x4/user04",
                data:JSON.stringify(userList),
                context:"application/json;charset=utf-8"
            }).then(function (resp){

            })
        }
    })*/

</script>

</body>
</html>
