<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    //返回当前项目路径 http协议 ，主机名， 端口名， 项目名称
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-size:cover;
        }
        .insert{
            margin:100px
        }
        .subject{
            font-size:16px;
            text-align:left;
        }
        .content{
            font-size:16px;
            text-align:left;
        }
        .button{
            background-color: #2D64B3;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin:10px 5px 15px 20px;
        }
        .type{
            text-align: left;
        }
        .input{
            padding: 12px 20px;
            margin: 8px 0;
            border: none;
            border-bottom: 2px solid black;
        }
        .options{
            font-size: 16px;
            text-align: left;
        }
        .resolve{
            text-align: left;
        }
        .submit{
            text-align: left;
        }

    </style>
    <title>插入试题</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script
            src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <!-- 配置文件 -->
    <script
            src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script
            src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn1").click(function(){
                var tr = "<tr><td></td><td><input name='options' class='input' type='text'/></td><td> <input type='checkbox' name='isAnswer' /> </td><td><input type=\"button\" class='button' onclick=\"del(this);\" value=\"删除\"></td></tr>";
                $("#tab").append(tr);
                flush();
            });

            $("#btn2").click(function(){
                var subjectId = $("input:radio:checked").val();
                if(subjectId==null||subjectId==undefined) {
                    alert("你没有选择任何科目！");
                    return;
                }
                //tid存储选择的type
                var tid = [];
                var hasTid =false;
                $("input[name='tid']:checked").each(
                        function() {
                            tid.push($(this).val());
                            hasTid = true;
                        }
                );
                if(!hasTid){
                    alert("你没有选择任何题目类型！");
                    return;
                }
                //options存储储存的选项
                var options = [];
                var hasOption = false;
                var hasNull = false;
                $("input[name='options']").each(
                        function() {
                            if($(this).val()==""){
                                hasNull = true;
                                return;
                            }
                            options.push($(this).val());
                            hasOption = true;
                        }
                );
                if (hasNull) {
                    alert("有选项的内容没有填写！");
                    return;
                }
                if(!hasOption) {
                    alert("你没有添加任何选项！");
                    return;
                }
                //answers存储选择的答案的标号
                var answers = [];
                var hasAnswer = false;
                $("input[name='isAnswer']:checked").each(
                        function () {
                            answers.push($(this).val());
                            hasAnswer = true;
                        }
                );
                if(!hasAnswer){
                    alert("你没有选择任何选项作为正确答案！");
                    return;
                }

                var content = ue.getContent();
                if(ue.getPlainTxt()=="") {
                    alert("缺少题目正文！");
                    return;
                }

                var resolve = $("textarea[name='resolve']").val();
                if(resolve=="") {
                    alert("缺少题目解析！");
                    return;
                }

                $.ajax({
                    type : 'post',
                    url : '/drive/question/insert/do',
                    contentType: 'application/x-www-form-urlencoded' ,
                    dataType : 'json',
                    data : {
                        "subjectId" : subjectId,
                        "tid[]" : tid,
                        "options[]": options,
                        "answers[]": answers,
                        "content" : content,
                        "resolve" : resolve

                    },
                    success : function(data) {
                        alert(data.msg);
                        window.location.reload();
                    },
                    error : function(){
                        alert("插入失败！");
                    }
                });
            });

        });



        function flush() {
            var i=1;
            $("#tab tr td:first-child").each(function(){
                $(this).html(i++);
            });
            i=1;
            $("#tab tr input[name='isAnswer']").each(
                    function () {
                        $(this).attr('value',i++);
                    }
            );
        }

        function del(e) {
            $(e).parent().parent().remove();
            flush();
        }




    </script>


</head>
<body   class="c">

<div class="insert">
    <div class="subject">
        <b>科目类别</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="subjectId" value="1">科目一   <input type="radio" name="subjectId" value="4">科目四
    </div><br><br>

    <div class="type">
        <b>所属题目类型</b>
        <span><p>
            <c:forEach items="${types}" var="type">

                ${type.type}<input type="checkbox" name="tid" value="${type.id}">

            </c:forEach>
        </span></p>
    </div><br><br>

    <div class="content">
        <b>题目内容</b><br>
        <script id="content" name="content" type="text/plain">
        </script>
        <script type="text/javascript">
            var ue = UE.getEditor('content');
            var ue = UE.getEditor('content');
            //实例化编辑器到id为 container 的 dom 容器上：
            //设置编辑器内容：
            ue.ready(function() {
                ue.setContent('<p>在此输入题目正文</p>');
            });
            //获取编辑器html内容：
            ue.ready(function() {
                var html = ue.getContent();
            });

        </script>
    </div><br><br>



    <div class="options">
        <b>题目选项</b>    <button id="btn1" class="button" >添加一行</button>
        <table  id="tab" style="text-align: center;">
                <th>序号</th>
                <th>选项内容</th>
                <th>是否是答案</th>
                <th>操作</th>
        </table>
    </div><br><br>

    <div class="resolve">
    <b>题目解析</b><br>
    <textarea cols="40" rows="10" style="overflow: hidden" name="resolve" ></textarea>
    </div><br>

    <div class="submit">
        <button id="btn2" class="button">提交</button>
    </div>
</div>
</body>
</html>
