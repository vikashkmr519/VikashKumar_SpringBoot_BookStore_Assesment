<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.servletContext.contextPath}/">Home</a></li>
					<%
					String id = (String) session.getAttribute("email");

					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
					}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/logout">Logout</a>
					</li>
					<form class="form-inline my-2 my-lg-0">

						<h3 class="my-2 my-sm-0">
							<%
							String name = (String) session.getAttribute("username");
							out.print(name);
							%>
						</h3>
					</form>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/admin">Admin</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div>

		<form action="/book" method="POST">
			<c:if test="${book.bookid!= null}">
				<div class="form-outline mb-4">

										<input type="text"  name="bookid" placeholder="Book Id" class="form-control" value="${book.bookid}" />
										<label class="form-label" for="form3Example1q">Book Id</label>
									</div>
			</c:if>
			<div class="form-outline mb-4">

										<input type="text"  name="bookname" placeholder="Book Name" class="form-control" value="${book.bookname}" />
										<label class="form-label" for="form3Example1q">Book Name</label>
									</div>
									<div class="form-outline mb-4">
										<input type="text" id="AuthorName" name="authorname" placeholder="Author Name" class="form-control" value="${book.authorname}" />
										<label class="form-label" for="form3Example1q">Author Name</label>
									</div>
									
									<div class="form-outline mb-4">
										<input type="text" id="Price" name="price" placeholder="Price" class="form-control" value="${book.price}"/>
										<label class="form-label" for="form3Example1q">Price</label>
									</div>
									<div class="form-outline mb-4">
										<input type="text" id="publication" name="publication" placeholder="Publication" class="form-control" value="${book.publication}" />
										<label class="form-label" for="form3Example1q">Publication</label>
									</div>
									<button type="submit" class="btn btn-success btn-lg mb-1">Register</button>
		</form>
	</div>

</body>
</html>