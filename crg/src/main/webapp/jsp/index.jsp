<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String base = request.getContextPath() + "/";
    out.println("项目根路径 : " + base);
%>
<html>
<body>
<h2>Hello World!</h2>
<style>
    .red {
        color: #f00;
    }
</style>
<div>
    <div>
        <div>get:dispatcher</div>
        <hr>

        <form action="../servlet/user/list" method="get">
            <input name="address" value="福建">
            <button type="submit">相对路径 GET 提交</button>
            <div class="red">*相对路径还需要考虑index.jsp的打开方式</div>
            <div class="red">*classes处于根目录</div>
        </form>

        <form action="<%=base%>servlet/user/list" method="get">
            <button type="submit">绝对路径 GET 提交</button>
            <div class="red">/开头表示服务器地址</div>
        </form>

        <a href="<%=base%>servlet/user/list?address=广东">带参数的 GET 请求</a>
    </div>
    <div>
        <div>post:redirect</div>
        <hr>

        <form action="../servlet/user/list" method="post">
            <button type="submit">相对路径 POST 提交</button>
        </form>

        <form action="<%=base%>servlet/user/list" method="post">
            <button type="submit">绝对路径 POST 提交</button>
        </form>
    </div>

    <iframe src="" style="height:80%;width:60%;"></iframe>
    <script>
        var btns = document.getElementsByTagName("button");
        console.log(btns);
        var iframe = document.getElementsByTagName("iframe")[0];
        for (var i = 0, len = btns.length; i < len; i++) {
            /*
             btns[i].addEventListener("click", function (event) {
             var target = event.target;
             event.preventDefault();
             iframe.src = target.action;
             });
             */
        }
    </script>
</div>
</body>
</html>
