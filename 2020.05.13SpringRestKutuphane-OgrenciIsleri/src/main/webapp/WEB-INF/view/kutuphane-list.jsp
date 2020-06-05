<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kutuphane</title>
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
<div id="wrapper">
<div id="header">
<h2>Kitaplar</h2>

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
<th>Kitap Adi</th>
<th>Yazar</th>
<th>Kitap Verilis Tarihi</th>
<th>Kitap Teslim Tarihi</th>
<th>Ogrenci Adi</th>

</tr>
</thead>
<tbody>
<c:forEach items="${kitaplar}" var="ktp">
<c:url var="oduncislemi" value="/oduncAl">
<c:param name="kitapId" value="${ktp.id}"/>
</c:url>	

<tr>
<td>${ktp.id}</td>
<td>${ktp.kitapAdi}</td>
<td>${ktp.yazar}</td>
<td>${ktp.verilisTarihi}</td>
<td>${ktp.teslimTarihi}</td>
<td>${ktp.ogrenciIsleri.ad}</td>

<td>
	<c:choose>
	 <c:when test="${ktp.ogrenciIsleri!=null}">
	   Alinmis
		 </c:when>
		<c:when test="${ktp.ogrenciIsleri==null}">
		 Rafta
		</c:when>						 
	</c:choose>


</td>
<td>
<button class="update-button" onclick="window.location.href='${oduncislemi}'">Kitap Islemi</button>
</td>
</tr>

</c:forEach>

</tbody>
</table>


</div>
</div>
</body>
</html>