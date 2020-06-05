<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kutuphane</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

			<h2>Ogrenci Bilgileri</h2>
			<br/>
			<table>
			<tr>
			<td><label>Id:</label>&nbsp;${ogr.id}</td>
			</tr>
			<tr>
			<td><label>Ogrenci No:</label>&nbsp;${ogr.ogrenciNo}</td>
			</tr>
			<tr>
			<td><label>Ad:</label>&nbsp;${ogr.ad}</td>
			</tr>
			<tr>
			<td><label>Soyad:</label>&nbsp;${ogr.soyad}</td>
			</tr>			
			</table>			
	
<br/>
<a href="${pageContext.request.contextPath}/kutuphaneisleri">Listeye Don</a>
			
</body>
</html>