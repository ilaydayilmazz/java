<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ogrenci Isleri</title>
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
  background-color:#FF7043;
  color: white;
}
</style>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Ogrenci Listeleme</h2>

</div>
</div>

<div id="container">
<div id="content">
<br/><br/>

	<p style="color:blue;text-align:center;font-size:18px;font-style:italic;">${mesaj}</p>
		<br/>

<table>
<thead>
<tr>
<th>Id</th>
<th>Ad</th>
<th>Soyad</th>
<th>Ogrenci No</th>
<th>Baslangic Tarihi</th>
<th>Mezuniyet Tarihi</th>
<th>Ogrencilik Durumu</th>
</tr>
</thead>
<tbody>
 <c:forEach items="${ogrenciler}" var="ogr">
<c:url var="mezuniyetLink" value="/mezuniyet">
			<c:param name="ogrenciId" value="${ogr.id}"/>
			</c:url>	


<tr>
<td>${ogr.id}</td>
<td>${ogr.ad}</td>
<td>${ogr.soyad}</td>
<td>${ogr.ogrenciNo}</td>
<td>${ogr.baslangicTarihi}</td>
<td>${ogr.mezuniyetTarihi}</td>

<td>
<c:choose>
<c:when test="${ogr.ogrencilikDurumu==0}">
  Mezun
 </c:when>
 <c:when test="${ogr.ogrencilikDurumu==1}">
  Aktif
 </c:when>
 <c:otherwise>
 ${ogr.ogrencilikDurumu}
 </c:otherwise>
</c:choose>
</td>	
<td>
<button class="update-button" onclick="window.location.href='${mezuniyetLink}'">Mezun Et</button>
</td>
	
</tr>

</c:forEach>

</tbody>
</table>

</div>
</div>
</body>
</html>