<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="lab.io.rush.moana.entity.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie</title>
<meta name="viewport"
	content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<!-- Loading Bootstrap -->
<link href="../dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../dist/css/flat-ui.css" rel="stylesheet">
<link href="../docs/assets/css/demo.css" rel="stylesheet">
<link href="../dist/css/vendor/movie.css" rel="stylesheet">

<link rel="shortcut icon" href="../img/favicon.ico">

</head>

<%
	String email = (String) request.getAttribute("email");
	String nickname = (String) request.getAttribute("nickname");
	
%>
<body>
	<div class="container">
		<div class="row demo-row">
			<div class="col-xs-12">
				<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navbar-collapse-01">
							<span class="sr-only">Toggle navigation</span>
						</button>
						<a class="navbar-brand" href="#">Movie</a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-collapse-01">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="redirect.do?pagename=index">主页</a></li>
							<li><a href="#fakelink">电影</a></li>
							<li><a href="#fakelink">关于我们</a></li>
						</ul>
						<form class="navbar-form navbar-right" action="#" role="search">
							<div class="form-group">
								<a href="redirect.do?pagename=login">登录</a>
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
				<!-- /navbar -->
			</div>
		</div>
		尊敬的<%=nickname %>,恭喜您，您已经注册成功，需要邮箱激活才能使用。您的邮箱地址为<%=email %>
		


	</div>

	<!-- /container -->

	


	<script src="../dist/js/vendor/jquery.min.js"></script>
	<script src="../dist/js/vendor/video.js"></script>
	<script src="../dist/js/flat-ui.min.js"></script>
	<script src="../docs/assets/js/application.js"></script>

	<script>
		videojs.options.flash.swf = "../dist/js/vendors/video-js.swf"
	</script>
</body>
</html>
