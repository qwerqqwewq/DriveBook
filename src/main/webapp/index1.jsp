<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  //返回当前项目路径 http协议 ，主机名， 端口名， 项目名称
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <title>My JSP 'demo.jsp' starting page</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script
          src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/image/newupload" method="post" name="upload">
  <!-- 加载编辑器的容器 -->
  <script id="container" name="content" type="text/plain">
  </script>
  <input type="submit" value="编辑完成"/>
</form>
<!-- 配置文件 -->
<script
        src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script
        src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
  var ue = UE.getEditor('container');
  //实例化编辑器到id为 container 的 dom 容器上：
  var ue = UE.getEditor('container');
  //设置编辑器内容：
  ue.ready(function() {
    ue.setContent('<p>hello!</p>');
  });
  //追加编辑器内容：
  ue.ready(function() {
    ue.setContent('<p>new text</p>', true);
  });
  //获取编辑器html内容：
  ue.ready(function() {
    var html = ue.getContent();
  });
  //获取纯文本内容：
  ue.getContentTxt();
  //获取保留格式的文本内容：
  ue.getPlainTxt();
  //获取纯文本内容：
  ue.getContentTxt();
  //判断编辑器是否有内容：
  ue.hasContents();
  //让编辑器获得焦点：
  ue.focus();
  //让编辑器获得焦点
  ue.blur();
  //判断编辑器是否获得焦点：
  ue.isFocus();
  //设置当前编辑区域不可编辑：
  ue.setDisabled();
  //设置当前编辑区域可以编辑：
  ue.setEnabled();
  //隐藏编辑器：
  ue.setHide();
  //显示编辑器：
  ue.setShow();
  //获得当前选中的文本：
  ue.selection.getText();
  //常用命令：
  //在当前光标位置插入html内容
  ue.execCommand('inserthtml', '<span>hello!</span>');
  //设置当前选区文本格式：
  ue.execCommand('bold'); //加粗
  ue.execCommand('italic'); //加斜线
  ue.execCommand('subscript'); //设置上标
  ue.execCommand('supscript'); //设置下标
  ue.execCommand('forecolor', '#FF0000'); //设置字体颜色
  ue.execCommand('backcolor', '#0000FF'); //设置字体背景颜色
  //回退编辑器内容：
  ue.execCommand('undo');
  //撤销回退编辑器内容：
  ue.execCommand('redo');
  //切换源码和可视化编辑模式：
  ue.execCommand('source');
  //选中所有内容：
  ue.execCommand('selectall');
  //清空内容：
  ue.execCommand('cleardoc');
  //读取草稿箱
  ue.execCommand('drafts');
  //清空草稿箱
  ue.execCommand('clearlocaldata');
</script>
</body>
</html>
