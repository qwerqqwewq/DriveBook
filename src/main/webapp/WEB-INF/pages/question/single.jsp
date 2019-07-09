<%@ page import="com.zte.drive.vo.QuestionVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    //返回当前项目路径 http协议 ，主机名， 端口名， 项目名称
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>正在查看题目${question.id}</title>
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
        $(function() {
            $("input:radio").each(function () {
                if($(this).val()==<c:out value="${question.subject.id}"/>) {
                    $(this).attr("checked",'checked');
                }
            });


            $("#btn1").click(function(){
                var tr = "<tr><td></td><td><input name='options' type='text'/></td><td> <input type='checkbox' name='isAnswer' /> </td><td><input type=\"button\" onclick=\"del(this);\" value=\"删除该选项\"></td></tr>";
                $("#optList").append(tr);
                flush();
            });


            //撤销按钮
            $("#flushOptList").click(function () {
                $("#optList").html("<c:forEach items='${question.optionList}' var='option' varStatus='ovs'>                        <tr>                        <td>${ovs.count}</td>                        <td><input type='text' value='${option}'></td>                        <td><input type='checkbox' name='isAnswer'                <c:forEach items='${question.answerList}' var='answers'>                <c:if test='${answers==ovs.count}'>                checked='checked'                        </c:if>                        </c:forEach>                        /></td>                        <td><button onclick='del(this)'>删除该选项</button></td>                </tr>                </c:forEach>");

            });

            //修改按钮
            $("#btn2").click(function(){
                if(!confirm("确定要修改吗？")) {
                    return;
                }
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
                if(hasNull) {
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

                var id= <c:out value="${question.id}" />;
                if(id==null||id==undefined) {
                    confirm("发生未知错误！正在回到查看页面");
                    $(location).prop('href', '/drive/question/all')
                }

                $.ajax({
                    type : 'post',
                    url : '/drive/question/update/do',
                    contentType: 'application/x-www-form-urlencoded' ,
                    dataType : 'json',
                    data : {
                        "id" : id,
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

            //删除该题目
            $("#deleteQuestion").click(function () {
                if(!confirm("确定要删除吗？")) {
                    return;
                }
                var id = <c:out value="${question.id}"></c:out>
                $.ajax({
                    type : 'post',
                    url : '/drive/question/delete/do',
                    contentType: 'application/x-www-form-urlencoded' ,
                    dataType : 'json',
                    data : {
                        "id": id

                    },
                    success : function(data) {
                        confirm(data.msg);
                        $(location).prop('href', '/drive/question/all')
                    },
                    error : function(){
                        alert("删除失败！");
                    }
                });
            });
        });

        function del(e) {
            $(e).parent().parent().remove();
        }

        function flush() {
            var i=1;
            $("tr td:first-child").each(function(){
                $(this).html(i++);
            });
            i=1;
            $("tr input[name='isAnswer']").each(
                    function () {
                        $(this).attr('value',i++);
                    }
            );
        }
    </script>
</head>
<body>
<%--TODO:带有修改功能的单个问题查看--%>
<h2>当前正在查看——题目id${question.id}</h2><button id="deleteQuestion">删除该题目</button>
<h3>题目内容</h3>
<script id="content" name="content" type="text/plain">
</script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
    //实例化编辑器到id为 container 的 dom 容器上：
    //获取编辑器html内容：
    ue.ready(function() {
        var html = "<c:out value='${question.content}'/>" ;

        ue.execCommand('insertHtml',html.replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;/g, "&").replace(/&quot;/g, '"').replace(/&#034;/g, '"').replace(/&apos;/g, "'"));
    });
</script>
<h3>所属题目类型</h3>
<p>
    <c:forEach items='${types}' var='type'>
        ${type.type}<input type='checkbox' name='tid' value='${type.id}'
                        <c:forEach items='${question.types}' var='qt'>
                            <c:if test='${qt.id==type.id}'>
                                checked='checked'
                            </c:if>
                        </c:forEach>
                    /><br>
    </c:forEach>
</p>
<h3>所属科目</h3>
<p>
    <input type="radio" name="subjectId" value="1">科目一  <br>
    <input type="radio" name="subjectId" value="4">科目四
</p>
<h3 >题目选项</h3>
<button id="flushOptList">撤销至初始状态</button>
<button id="btn1">添加一行</button>
<table  border="1">
    <th>序号</th>
    <th>选项</th>
    <th>是否是答案</th>
    <th>操作</th>
    <tbody id="optList">
        <c:forEach items='${question.optionList}' var='option' varStatus='ovs'>
            <tr>
                <td>${ovs.count}</td>
                <td><input type='text' value='${option}' name="options"></td>
                <td><input type='checkbox' name='isAnswer' value="${ovs.count}"
                        <c:forEach items='${question.answerList}' var='answers'>
                            <c:if test='${answers==ovs.count}'>
                                checked='checked'
                            </c:if>
                        </c:forEach>
                        /></td>
                <td><button onclick='del(this)'>删除该选项</button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>

<h3>题目解析</h3>
<textarea cols="40" rows="20" style="overflow: hidden" name="resolve" >${question.resolve}</textarea>
<br>
<button id="btn2" >修改</button>

</body>
</html>
