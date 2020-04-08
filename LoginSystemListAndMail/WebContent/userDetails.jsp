<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Login.Registration.Model.*"%>
<%@ page import="Login.Registration.ListAndMail.*"%>
<%@ page import="LoginListAndMail.Registration.Hibernate.RetunrnResponse"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="CSS/tabs.css">
<body>
	<jsp:include page="adminPage.jsp" />
	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">User</button>
		<button class="tablinks" onclick="openCity(event, 'Paris')">User Details</button>
	</div>
	<%
		Long userId = 0l;
		if (request.getAttribute("userId") != null) {
			userId = (Long) request.getAttribute("userId");
		} else if (request.getParameter("userId") != null) {
			userId = Long.parseLong(request.getParameter("userId"));
		}
		RegistrationDAO registrationDAO = new RegistrationDAOImpl();
		RetunrnResponse returnResponse = registrationDAO.getUsersById(userId == null ? 0l : userId);
		System.out.println("grid jsp class 2:");
		Users user = (Users) returnResponse.getObjectResponse();

		request.setAttribute("user", user);
		Users user1 = new Users();
		user1 = (Users) request.getAttribute("user");
	%>

	<div id="London" class="tabcontent">
		<jsp:include page="user.jsp" />
	</div>

	<div id="Paris" class="tabcontent">
		<h3>Details</h3>
		<p>Not Done yet</p>
	</div>

	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		document.getElementById("defaultOpen").click();
	</script>

</body>
</html>
