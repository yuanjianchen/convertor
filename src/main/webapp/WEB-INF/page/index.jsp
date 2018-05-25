<%--
  Created by IntelliJ IDEA.
  User: chenjianyuan
  Date: 2018/5/24
  Time: 下午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>JSON转换JavaBean</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/layui/css/layui.css">
    <style>
    </style>
</head>
<body>
<div class="layui-fluid" style="margin-top: 10px;">
    <div class="layui-row layui-col-space5">
        <div class="layui-col-md6">
            <fieldset class="layui-elem-field">
                <legend>JSON字符串</legend>
                <div class="layui-field-box">
                    <textarea class="layui-textarea" id="jsonStr" title="" style="height: 600px;"></textarea>
                </div>
            </fieldset>
            <div class="layui-inline">
                <input class="layui-input" type="text" id="className" placeholder="请输入类名"/>
            </div>
            <div class="layui-inline">
                <button class="layui-btn" id="genCode">生成JavaBean</button>
            </div>
        </div>
        <div class="layui-col-md6">
            <fieldset class="layui-elem-field" id="javaCode"s>
                <legend>生成代码</legend>
                <%--<div class="layui-field-box" id="result">--%>
                <%--</div>--%>
                <div class="layui-field-box">
                    <textarea class="layui-textarea" id="result" title=" " style="height: 600px;"></textarea>
                </div>
            </fieldset>
        </div>
    </div>
</div>

<%--<script type="text/javascript" src="http://static.41ulove.com/jquery-2.1.4/jquery.js"></script>--%>
<script type="text/javascript" src="${ctx}/static/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['layer', 'jquery'], function () {
        var layer = layui.layer, $ = layui.jquery;
        $('#genCode').click(function (e) {
            $.post("${ctx}/convert/javaBean", {
                jsonStr: $('#jsonStr').val(),
                className: $("#className").val()
            }, function (res) {
                $('#result').val(res);
            });
        });
    });
</script>
</body>
</html>
