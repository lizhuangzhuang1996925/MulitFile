<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
</head>
<body>
<form><a href="/downLoad?filename=QQ视频20190819195922.mp4">下载</a>
	<input type="file" name="file">
	<input type="button" value="上传" onclick="sc()">
	<img alt="" src="" width="80px" height="80px">
</form>
</body>
<script type="text/javascript">
	function sc() {
		var fd=new FormData($("form")[0]);
		$.ajax({
			url:"toMulitFile",
			data:fd,
			dataType:"json",
			type:"post",
			processData:false,
			contentType:false,
			success:function(abj){
				alert(abj.name)
				$("img").attr("src","/pi/"+abj.name)
				$("a").attr("href","/downLoad?filename="+abj.name)
			}
		})
	}
</script>
</html>