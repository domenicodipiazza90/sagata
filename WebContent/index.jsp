<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sant'Agata</title>

<script src="js/jquery.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/script.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id='cssmenu'>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div id="body">
		<div id="cont">
		<jsp:directive.include file="home.jsp" />
		</div>
	</div>
</body>
</html>