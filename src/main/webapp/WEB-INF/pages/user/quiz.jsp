<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正在回答题目</title>
    <style>
        .content{

        }

        .type{
            font-size : 14pt;
            font-weight : bold;
            font-style : normal;
        }

        .sub{
            font-size : 10pt;
            font-weight: normal;
        }

        .bold{
            font-weight : bold;
        }

        .selected{
            border: 1px solid red;
        }
        .unselected{

        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {
            <c:if test="${sessionScope.user==null}">
                alert("用户没有登录!");
                <c:redirect url="${pageContext.request.contextPath}" />

            </c:if>
            $("#btn").click(function () {
                var qid = <c:out value="${question.id}" />;
                var uid = <c:out value="${sessionScope.user.id}" />;
                var answers = [];
                var hasAnswer = false;
                $("input[name='answer']:checked").each(function () {
                    answers.push($(this).val());
                    hasAnswer = true;
                });
                if (!hasAnswer) {
                    alert("你没有选择任何答案！");
                    return;
                }
                $.ajax({
                    type : 'get',
                    url : '/drive/userAnswer/answer',
                    dataType : 'json',
                    data : {
                        "qid":qid,
                        "uid":uid,
                        "answers[]": answers
                    },
                    success : function(data) {
                        if(data.correct) {
                            whenCorrect();
                            alert("回答正确");
                        }else {
                            alert("回答错误");

                        }
                    },
                    error : function(){
                        alert("插入失败！");
                    }
                });


            });

            $("#commentIt").click(function() {
                var val = $("#CContent").val();
                comment(null,val);
            });


        });

        function comment(pid,val) {
            var qid = <c:out value="${question.id}" />;
            var uid = <c:out value="${sessionScope.user.id}" />;
            $.ajax({
                url:'/drive/questionComment/insert/do',
                type:'post',
                datatype:'json',
                data:
                    {
                    'qid':qid,
                    'uid':uid,
                    'pid':pid,
                    'content':val
                    },
                success:function(data) {
                    if(data.status>0) {
                        alert("评论成功");
                    }else {
                        alert("评论失败");
                    }
                },
                error: function () {
                    alert("评论失败！请检查网络设置！");
                }
            });


        }

        function makeComment(pid,self) {
            var val = $(self).siblings("textarea").val();
            //alert("发送给pid:" + pid + ",内容:" + val);
            comment(pid, val);
        }

        function show(self) {
            console.log($(self));
            $(self).siblings(".commentArea").show();
            $(self).hide();
        }

        function whenCorrect() {
            //可以发出评论
            $("#myComment").attr("style", "visibility: visible");

            //请求题目评论
            var qid = <c:out value="${question.id}" />;


            $.ajax({
                url : '/drive/questionComment/all/' + qid,
                dataType : 'json',
                success : function(data) {
                    if(data.status>0) {
                        //如果评论个数不为0
                        var comments = data.comments;
                        //添加回复ta按钮模板，commentButtonTemplate cbtnt
                        var cbtnt = $("<button>回复ta</button>");
                        //点击时创建文本框，同时添加到某个对象下，评论的question的id为pid
                        //通过cbtnt.click(data,createTextArea);

                        for(var i = 0;i<comments.length;i++) {
                            console.log(comments[i]);
                            //根评论pp,当前根评论comment
                            var comment = comments[i];
                            //添加内容
                            var pp = $("<div></div>");
                            var user = $("<span></span>").html(comment.user.name+"在"
                                                                +comment.commentDate+
                                                                "时候，评论了<br>");
                            var cc = $("<span></span>").html(comment.content);
                            //添加元素
                            pp.append(user);
                            pp.append(cc);
                            pp.addClass("type");

                            //创建它的评论选框
                            var commentArea = $("<div id='"+i+"ca'></div>").addClass("commentArea");

                            var tt = $("<textarea name='"+i+"subContent'>输入评论内容</textarea>");

                            //提交评论按钮
                            var ttsubmit = $("<button>提交评论</button>");
                            ttsubmit.attr("onclick","makeComment("+comment.id+",this)");



                            //append
                            commentArea.append(tt);
                            commentArea.append(ttsubmit);
                            commentArea.hide();
                            pp.append(commentArea);

                            //创建按钮
                            var cbtn = cbtnt.clone();
                            cbtn.attr("onclick", "show(this)");
                            pp.append(cbtn);


                            var subComments = comment.comments;
                            //子评论贴在sub下
                            var sub;
                            if(subComments.length>0) {
                                sub = $("<div></div>").html("ta的评论：").addClass("sub");
                                pp.append(sub);
                            }
                            for(var j=0;j<subComments.length;j++) {
                                //显示子评论
                                var subComment = subComments[j];
                                var subUser = $("<span></span>").html(subComment.user.name+"在"
                                        +comment.commentDate+
                                        "时候，评论了<br>");
                                var scc = $("<span></span>").html(subComment.content);
                                var sc = $("<div></div>");
                                sc.append(subUser);
                                sc.append(scc);
                                sub.append(sc);
                            }
                            $("#comments").append(pp);
                        }
                    }
                },
                error : function(){
                    alert("评论模块失败！");
                }
            });
        }

    </script>
</head>
<body>
<div style="width: 100%;height: 50px;font-size:15px;color: #000;line-height: 50px;padding-left: 20px;">
    <div style="color:#FFF;background: red;width: 22px;height: 22px;border-radius:11px;line-height:22px;font-size:13px; text-align: center;">
        <img src="${pageContext.request.contextPath}/css/t.jpg" style="color:#FFF;background: red;width: 22px;height: 22px;border-radius:11px;line-height:22px;font-size:13px; text-align: center;" />
    </div>
    <c:forEach items="${question.types}" var="type">
        <span class="type">${type.type}</span>
    </c:forEach>

</div>
<p class="content">第${num}题、${question.content}</p>
<c:forEach items="${question.optionList}" var="option" varStatus="vs">
    <div>
        <input <c:if test="${!isSingle}">type="checkbox" </c:if>
               <c:if test="${isSingle}">type="radio" </c:if>
               name="answer"
               value="${vs.count}">${option}
        </input>
    </div>
</c:forEach>
<button id="btn">确定</button>

<div id = "myComment" style="visibility: hidden">
    我的评论
    <textarea id="CContent"></textarea>
    <button id="commentIt">发出评论</button>
</div>
<div id="comments"></div>

</body>
</html>
