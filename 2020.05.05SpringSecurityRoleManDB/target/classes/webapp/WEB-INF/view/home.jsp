<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Kullanici : <sec:authentication property="principal.username" var="user"/>
Role: <sec:authentication property="principal.authorities" var="authorities"/>

Kullanici: ${user}
Role(s): ${authorities}
<hr>
Home
<br/>

<c:if test="${fn:contains(authorities,'ROLE_ADMIN')}">
<a href="http://google.com">Link</a>
</c:if>


<f:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</f:form>
	<hr>
	<sec:authorize access="hasRole('ADMIN')">
	<a href="admin/home">Admin Anasayfa</a></sec:authorize>
	
	<sec:authorize access="hasAnyRole('PERSONEL','ADMIN')">
		<a href="personel/home">Personel Anasayfa</a></sec:authorize>
	
	
</body>
</html>