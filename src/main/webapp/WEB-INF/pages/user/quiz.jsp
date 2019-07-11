<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正在回答题目</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg7.jpg');
            background-size:cover;
        }
        .button{
            background-color: #2D64B3;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 5px;
            margin:10px 5px 15px 20px;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }
        .quiz{
            text-align: left;
            margin: 50px 50px 50px 50px;
        }
        .content{
            font-size: 14pt;
        }

        .type{
            font-size : 14pt;
            font-style : normal;
        }

        .sub{
            font-size : 10pt;
            font-weight: normal;
        }

        .text{
            border:0;
            border-radius:5px;
            background-color:white;
            width: 355px;
            height: 50px;
            padding: 10px;
            resize: none;
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
            $(":not(.commentArea,.commentArea *,button:visible)").click(function (event) {
                event.stopPropagation();
                console.log($(this));
                $(".commentArea").hide();
                $("button:hidden:not(#btn)").show();
            });
            $("#comments").on("click","button,textArea",function(e){
                console.log($(this));
                e.stopPropagation();
            });

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
                            alert("回答正确");

                        }else {
                            alert("回答错误");
                        }
                        whenCorrect();

                        afterSumbmit();
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

            $("#addCollection").click(function () {
                var qid = <c:out value="${question.id}" />;
                var uid = <c:out value="${sessionScope.user.id}" />;
                $.ajax({
                    url:'/drive/fav/add',
                    type:'post',
                    datatype:'json',
                    data:
                    {
                        'questionId':qid,
                        'uid':uid
                    },
                    success:function(data) {
                        if(data.status>0) {
                            alert("收藏成功");
                        }else {
                            alert("已经在收藏夹里啦~");
                        }
                    },
                    error: function () {
                        alert("收藏失败！请检查网络设置！");
                    }
                });
            });


        });

        function afterSumbmit() {
            $("#btn").hide();
            $("#answersAndResolve").show();

        }

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
                        $("#comments").children().remove();
                    }else {
                        alert("评论失败");
                    }
                    whenCorrect();


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
            $(".commentArea").hide();
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
                        var cbtnt = $("<button class='button'>回复ta</button>");
                        //点击时创建文本框，同时添加到某个对象下，评论的question的id为pid
                        //通过cbtnt.click(data,createTextArea);

                        console.log(comments);

                        for(var i = 0;i<comments.length;i++) {
                            console.log(comments[i]);
                            //根评论pp,当前根评论comment
                            var comment = comments[i];
                            //添加内容
                            var pp = $("<div></div>");
                            var user = $("<span></span>").html(comment.user.name+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                                                +comment.commentDate+
                                                                "<br>");
                            var cc = $("<span></span>").html(comment.content+"<br>");
                            //添加元素
                            pp.append(cc);
                            pp.append(user);
                            pp.addClass("type");

                            //创建它的评论选框
                            var commentArea = $("<div id='"+i+"ca'></div>").addClass("commentArea");

                            var tt = $("<textarea name='"+i+"subContent'>输入评论内容</textarea>");

                            //提交评论按钮
                            var ttsubmit = $("<button class='button'>提交评论</button>");
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
                                sub = $("<div></div>").html("ta的楼下：").addClass("sub");
                                pp.append(sub);
                            }
                            for(var j=0;j<subComments.length;j++) {
                                //显示子评论
                                var subComment = subComments[j];
                                var subUser = $("<span></span>").html(subComment.user.name
                                        +"  "
                                        +subComment.commentDate
                                        +"  "
                                        +subComment.questionComment.user.name
                                        +"<br>");
                                var scc = $("<span></span>").html(subComment.content+"<br>");
                                var sc = $("<div></div>");
                                sc.append(scc);
                                sc.append(subUser);
                                //创建它的评论选框
                                var scommentArea = $("<div id='"+i+"ca'></div>").addClass("commentArea");

                                var stt = $("<textarea name='"+i+"subContent'>输入评论内容</textarea>");

                                //提交评论按钮
                                var sttsubmit = $("<button>提交评论</button>");
                                sttsubmit.attr("onclick","makeComment("+subComment.id+",this)");



                                //append
                                scommentArea.append(stt);
                                scommentArea.append(sttsubmit);
                                scommentArea.hide();
                                //创建按钮
                                var scbtn = cbtnt.clone();
                                scbtn.attr("onclick", "show(this)");
                                sc.append(scbtn);
                                sc.append(scommentArea);
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
<body class="c">
<div class="quiz">
    <div style="width: 100%;height: 50px;font-size:15px;color: #000;line-height: 50px; text-align: center;padding-left: 20px;">
        <c:forEach items="${question.types}" var="type">
            <span class="type">${type.type}</span>
        </c:forEach>
        <div style="color:#FFF;background: red;width: 22px;height: 22px;border-radius:11px;line-height:22px;font-size:13px; text-align: center;">
            <img src="${pageContext.request.contextPath}/css/t.jpg" style="color:#FFF;background: red;width: 22px;height: 22px;border-radius:11px;line-height:22px;font-size:13px; text-align: center;" />
        </div>
    </div><br>
    <p class="content"><b>第${num}题</b>${question.content}</p>
    <c:forEach items="${question.optionList}" var="option" varStatus="vs">
        <div>
            <input <c:if test="${!isSingle}">type="checkbox" </c:if>
                   <c:if test="${isSingle}">type="radio" </c:if>
                   name="answer"
                   value="${vs.count}"><span>${option}<br><br></span>
            </input>
        </div>
    </c:forEach>
    <button id="btn" class="button">确定</button>

    <div id="answersAndResolve" style="display:none">
        题目答案<br>
        <c:forEach items="${question.answerList}" var="answer">
            <span style="color:#dd0000">${question.optionList[answer-1]}</span><br>
        </c:forEach><br><br>
        <b style="font-size: 20px">题目解析</b><br>
        <div>
            ${question.resolve}
        </div>
    </div><br><br>

    <div>
        <button class="button" id="addCollection">添加到收藏夹</button>
    </div>

    <div id = "myComment" style="display:none">
        <b>我的评论</b><br>
        <textarea id="CContent" class="text"></textarea><br>
        <button id="commentIt" class="button">发出评论</button>
    </div>
    <div id="comments"></div>
</div>
</body>
</html>
