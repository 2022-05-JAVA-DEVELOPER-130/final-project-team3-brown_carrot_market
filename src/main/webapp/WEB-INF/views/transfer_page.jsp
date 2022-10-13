<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
#pop {
	position: absolute;
	z-index: 1;
	top: 0;
	width: 100%;
	height: 100%;
	display: none;
}

#pop>article {
	width: 700px;
	height: 400px;
	position: relative;
	z-index: 2;
	background: white;
	box-shadow: 3px 3px 5px black;
	margin: auto;
	cursor: pointer;
	text-align: center;
}

.black {
	background: rgba(0, 0, 0, 0.6);
}
</style>
	<script>
	$(document).ready(function() {
		$("#list>button:first-of-type").click(function() {
			$("#pop").fadeIn();
			$("#pop").addClass("black");
		});
	});
	</script>
	<script type="text/javascript">
	function moveClose() {
	  location.href="transfer_complate";
	  self.close();
	}
	</script>
</head>
<body>
 <div id="pop">
			<article>
				<h1>결제</h1>
				<input type="button" value="닫 기" onclick="moveClose();" />
			</article>
		</div>
	<section id="list">

		<button>송금</button>
	</section>
</body>
</html>