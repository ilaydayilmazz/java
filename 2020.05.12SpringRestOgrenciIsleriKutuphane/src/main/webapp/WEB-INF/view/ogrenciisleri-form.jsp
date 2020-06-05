<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  background-color:#FF7043;
  color: white;
}
</style>
</head>
<body>

			<br/>
			<frm:form action="${pageContext.request.contextPath}/mezunEt" modelAttribute="ogr" method="post">			
			<table>
			<tr>
			<td><label>Id:</label></td>
			<td><frm:input path="id"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Ogrenci No:</label></td>
			<td><frm:input path="ogrenciNo"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Ad:</label></td>
			<td><frm:input path="ad"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Soyad:</label></td>
			<td><frm:input path="soyad"  readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Baslangic Tarihi:</label></td>
			<td><frm:input path="baslangicTarihi" type="date" readonly="true" /></td>
			</tr>
			<tr>
			<td><label>Mezuniyet Tarihi:</label></td>
			<td><frm:input path="mezuniyetTarihi" type="date" /></td>
			</tr>			
			<tr>
			<td><label>Ogrencilik Durumu:</label></td>
			<td>
			<frm:radiobutton path="ogrencilikDurumu" value="0"/> <b>Pasif</b>
			<frm:radiobutton  path="ogrencilikDurumu" value="1"/> <b>Aktif</b>
			</td>
			</tr>			
			<tr>
			<td></td>
			<td>
			<frm:button value="save" name="save">Kaydet</frm:button></td>
			</tr>
			</table>
			</frm:form>
	
<br/>
<a href="${pageContext.request.contextPath}/ogrenciisleri">Geri</a>
</body>
</html>