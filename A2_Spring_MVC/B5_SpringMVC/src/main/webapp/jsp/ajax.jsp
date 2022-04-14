<%--
  Created by IntelliJ IDEA.
  User: Saber
  Date: 2022/4/14
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    var userList = new Array();
    userList.push({username:"zhangsan",age:18});
    userList.push({username:"lisi",age:28});

    $.ajax({
        type:"POST",
        url:"${pageContext.request.contextPath}/web/x4/dame05",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf-8"
    }).then(function (resp){
        alert(resp.data)
    });

</script>

</body>
</html>
