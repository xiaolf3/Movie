<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<!-- Loading Flat UI -->
<link href="../dist/css/flat-ui.css" rel="stylesheet">
<link href="../docs/assets/css/demo.css" rel="stylesheet">

<link rel="shortcut icon" href="img/favicon.ico">
</head>
<%
	String nickname = session.getAttribute("nickname").toString();
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
								<a href="redirect.do?pagename=login"><%=nickname %></a>
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
				<!-- /navbar -->
			</div>
		</div>
		<!-- /row -->
		<div class="row demo-tiles">
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/Intersteller.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=1">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/TheMartian.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=2">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/NationalTreasure.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=3">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/BridgetJones'sBaby.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=4">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/Zootopia.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=5">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/ColdWar2.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=6">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/BillyLynn'sLongHalftimeWalk.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=7">购票</a>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="tile">
					<img src="../img/icons/svg/CrouchingTigerHiddenDragon.jpg" alt="Compas"
						class="tile-image"> <a
						class="btn btn-primary btn-large btn-block"
						href="../screen/getAllScreens.do?movie_id=8">购票</a>
				</div>
			</div>
		</div>
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
