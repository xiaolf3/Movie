<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 | Movie</title>
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
<body>
	<div class="container">
		<div class="row demo-row">
			<div class="col-xs-12"></div>
		</div>
		<div class="login">
        <div class="login-screen">
          <div class="login-icon">
            <img src="../img/login/icon.png" alt="Welcome to Mail App" />
            <h4>欢迎使用  <small>Movie</small></h4>
          </div>
			<form action="../customer/login.do" method="post">
          <div class="login-form">
            <div class="form-group">
              <input type="text" class="form-control login-field" value="" placeholder="邮箱" name="id"/>
              <label class="login-field-icon fui-user" for="login-name"></label>
            </div>

            <div class="form-group">
              <input type="password" class="form-control login-field" value="" placeholder="密码" name="password" />
              <label class="login-field-icon fui-lock" for="login-pass"></label>
            </div>
			<input type="submit" value="登录" class="btn btn-primary btn-lg btn-block">
            <br>
          </div>
          </form>
        </div>
      </div>
	</div>


	<script src="../dist/js/vendor/jquery.min.js"></script>
	<script src="../dist/js/vendor/video.js"></script>
	<script src="../dist/js/flat-ui.min.js"></script>
	<script src="../docs/assets/js/application.js"></script>

	<script>
      videojs.options.flash.swf = "dist/js/vendors/video-js.swf"
    </script>
</body>
</html>
