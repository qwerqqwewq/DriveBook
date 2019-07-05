<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入试题</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn1").click(function(){
                var tr = "<tr><td></td><td><input name='options' type='text'/></td><td> <input type='checkbox' name='isAnswer' /> </td><td><input type=\"button\" onclick=\"del(this);\" value=\"删除\"></td></tr>";
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

                var content = $("textarea[name='content']").val();
                if(content=="") {
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
            i=1;
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

        function del(e) {
            $(e).parent().parent().remove();
            flush();
        }




    </script>
</head>
<body>



科目类别<input type="radio" name="subjectId" value="1">科目一   <input type="radio" name="subjectId" value="4">科目四<br>
题目内容<br>
<textarea cols="40" rows="5" style="overflow: hidden" name="content" ></textarea>

<br>
所属题目类型<br>
<span><p>
    <c:forEach items="${types}" var="type">

        ${type.type}<input type="checkbox" name="tid" value="${type.id}">

    </c:forEach>
</span></p><br>

题目选项    <button id="btn1" >添加一行</button>
<table id="tab">
        <th>序号</th>
        <th>选项内容</th>
        <th>是否是答案</th>
        <th>操作</th>
</table>
题目解析<br>
<textarea cols="40" rows="20" style="overflow: hidden" name="resolve" ></textarea>
<br>
<button id="btn2" >提交</button>

</body>
</html>
