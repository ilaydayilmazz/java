<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ogrenci Isleri Formu</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

<style>

table {
  border-collapse: collapse;
  width: 100%;
}
th{
  text-align: center;
  padding: 8px;
}
td {
  text-align: center;
  padding: 8px;
  color:#4A148C;
}
tr:nth-child(odd){background-color: white;}
tr:nth-child(even){background-color: white;}
th {
  background-color:#E57373;
  color: white;
}
</style>

</head>
<body>

			<h2>Kitap Formu</h2>
			<br/>
			<frm:form action="${pageContext.request.contextPath}/kitapteslim" modelAttribute="kitap" method="post">			
			
		 	<c:url var="ogrblg" value="/ogrencibilgileri">
			<c:param name="ogrNo" value="${kitap.ogrenciIsleri.ogrenciNo}"/>
			</c:url>
			
			<table>
			<tr>
			<td><label>Id:</label></td>
			<td><frm:input path="id"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Kitap Adi:</label></td>
			<td><frm:input path="kitapAdi"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Yazar:</label></td>
			<td><frm:input path="yazar"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Verilis Tarihi:</label></td>
			<td><frm:input path="verilisTarihi" type="date"  /></td>
			</tr>
			<tr>
			<td><label>Iade Tarihi:</label></td>
			<td><frm:input path="teslimTarihi" type="date"  /></td>
			</tr>
			<tr>
			<td><label>Odunc Alan Ogrenci No:</label></td>
			<td><frm:input path="ogrenciIsleri.ogrenciNo"  /></td>
			</tr>							
			<tr>
			<td></td>
			<td>
			<frm:button value="save" name="save">Kaydet</frm:button></td>
			</tr>
			</table>
			</frm:form>
	
<br/>
<a href="${pageContext.request.contextPath}/kutuphaneisleri">Geri</a><br>
 				
<c:choose>

	<c:when test="${kitap.ogrenciIsleri.ogrenciNo!=null}">
	<td><label>Kitabi alan ogrenci bilgileri:</label></td>
	<br>
	<td>${kitap.ogrenciIsleri.ad}</td><br>
	<td>${kitap.ogrenciIsleri.soyad}</td><br>
	<td>${kitap.ogrenciIsleri.ogrenciNo}</td><br>
	
		<!-- <button class="update-button" onclick="window.location.href='${ogrblg}'">Ogrenci Bilgileri</button> -->
  </c:when>						 					 
</c:choose>
</body>
</html>