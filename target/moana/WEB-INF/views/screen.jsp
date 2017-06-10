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
	List<Screen> screens = (List<Screen>) request.getAttribute("screens");
	Movie movie = (Movie) request.getAttribute("movie");
	String nickname = session.getAttribute("nickname").toString();
	String email = session.getAttribute("id").toString();
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
								<a href="redirect.do?pagename=login"><%=nickname%></a>
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
				<!-- /navbar -->
			</div>
		</div>
		<h3><%=movie.getTitle()%></h3>
		导演：<%=movie.getDirectors()%><br> 主演：<%=movie.getCasts()%><br>
		类型：<%=movie.getGenres()%><br> 地区：<%=movie.getCountries()%><br>
		版本：<%=movie.getVersion()%><br> 上映日期：<%=movie.getPubdates()%><br>
		<br>
		<br>
		<table class="table">
			<%
				for (int i = 0; i < screens.size(); i++) {
					Screen screen = screens.get(i);
					Date date = screen.getDate();
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat sdf_date = new SimpleDateFormat("MM-dd");
					String date_str = sdf_date.format(date);

					Date start_time = screen.getStart_time();
					SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");
					String start_time_str = sdf_time.format(start_time);
					Date end_time = screen.getEnd_time();
					String end_time_str = sdf_time.format(end_time);
			%>
			<form action="../order/order.do" method="post">
				<tr>
					<input type="hidden" name="movie_id"
						value="<%=movie.getMovie_id()%>">
					<input type="hidden" name="customer_id" value="<%=email%>">
					<input type="hidden" name="screen_id"
						value="<%=screen.getScreen_id()%>">
					<td>日期：<%=date_str%></td>
					<td>开始：<%=start_time_str%></td>
					<td>结束：<%=end_time_str%></td>
					<td>版本：<%=screen.getVersion()%></td>
					<td>价格：<%=screen.getPrice()%></td>
					<td><%=screen.getHall()%>号厅</td>
					<td>余票：<%=screen.getSeat()%></td>
					<td><input type="number" min="1" max="2" step="1" value="1"
						name="unit"></td>
					<td><input class="btn btn-primary btn-large btn-block"
						type="submit" value="购票"></td>
				</tr>
			</form>
			<%
				}
			%>

		</table>



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
