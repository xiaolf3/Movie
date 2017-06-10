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
<title>场次</title>
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
	List<Screen> screens = (List<Screen>) request.getAttribute("screens");
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
								<a href="login.jsp">登录</a>
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
				<!-- /navbar -->
			</div>
		</div>
		
		<%=screens.isEmpty() %><br>
		<%=screens.size() %><br>
		<%=screens.get(0) %>

	</div>

	<!-- /container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-7">
					<h3 class="footer-title">Subscribe</h3>
					<p>
						Do you like this freebie? Want to get more stuff like this?<br />
						Subscribe to designmodo news and updates to stay tuned on great
						designs.<br /> Go to: <a href="http://designmodo.com/flat-free"
							target="_blank">designmodo.com/flat-free</a>
					</p>

					<p class="pvl">
						<a href="https://twitter.com/share" class="twitter-share-button"
							data-url="http://designmodo.com/flat-free/"
							data-text="Flat UI Free - PSD&amp;amp;HTML User Interface Kit"
							data-via="designmodo">Tweet</a>
						<script>
							!function(d, s, id) {
								var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
										.test(d.location) ? 'http' : 'https';
								if (!d.getElementById(id)) {
									js = d.createElement(s);
									js.id = id;
									js.src = p
											+ '://platform.twitter.com/widgets.js';
									fjs.parentNode.insertBefore(js, fjs);
								}
							}(document, 'script', 'twitter-wjs');
						</script>
						<iframe
							src="http://ghbtns.com/github-btn.html?user=designmodo&repo=Flat-UI&type=watch&count=true"
							height="20" width="107" frameborder="0" scrolling="0"
							style="width: 105px; height: 20px;" allowTransparency="true"></iframe>
						<iframe
							src="http://ghbtns.com/github-btn.html?user=designmodo&repo=Flat-UI&type=fork&count=true"
							height="20" width="107" frameborder="0" scrolling="0"
							style="width: 105px; height: 20px;" allowTransparency="true"></iframe>
						<iframe
							src="http://ghbtns.com/github-btn.html?user=designmodo&type=follow&count=true"
							height="20" width="195" frameborder="0" scrolling="0"
							style="width: 195px; height: 20px;" allowTransparency="true"></iframe>
					</p>

					<a class="footer-brand" href="http://designmodo.com"
						target="_blank"> <img src="docs/assets/img/footer/logo.png"
						alt="Designmodo.com" />
					</a>
				</div>
				<!-- /col-xs-7 -->

				<div class="col-xs-5">
					<div class="footer-banner">
						<h3 class="footer-title">Get Flat UI Pro</h3>
						<ul>
							<li>Tons of Basic and Custom UI Elements</li>
							<li>A Lot of Useful Samples</li>
							<li>More Vector Icons and Glyphs</li>
							<li>Pro Color Swatches</li>
							<li>Bootstrap Based HTML/CSS/JS Layout</li>
						</ul>
						Go to: <a href="http://designmodo.com/flat" target="_blank">designmodo.com/flat</a>
					</div>
				</div>
			</div>
		</div>
	</footer>


	<script src="../dist/js/vendor/jquery.min.js"></script>
	<script src="../dist/js/vendor/video.js"></script>
	<script src="../dist/js/flat-ui.min.js"></script>
	<script src="../docs/assets/js/application.js"></script>

	<script>
		videojs.options.flash.swf = "../dist/js/vendors/video-js.swf"
	</script>
</body>
</html>
