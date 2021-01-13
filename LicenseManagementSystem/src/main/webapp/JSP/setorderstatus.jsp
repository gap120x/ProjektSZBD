<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
 <link href="/../css/style.css" rel="stylesheet" type="text/css">
  <link href="/../css/form.css" rel="stylesheet" type="text/css">
<head>
  <meta charset="UTF-8">
  <title>Softech- Edycja Statusu zamówienia</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Zmień Status dla Zamówienia</h1>
<div id="formdiv">
<form:form modelAttribute="orderstatus" method="POST" action="/order/manage/setstatus/${orderstatus.id}/save">

<label>ID Zamówienia</label>
 <form:input path="id" readonly="true"/>
    <label>Status Zamówienia </label>   
	   <form:select required="required" path="status">
		<form:option value="W trakcie Tworzenia">W trakcie Tworzenia</form:option>
		<form:option value="Oczekiwanie na Płatność">Oczekiwanie na Płatność</form:option>
		<form:option value="Opłacone">Opłacone</form:option>
		<form:option value="Licencje Wygenerowane">Licencje Wygenerowane</form:option>
		</form:select>
		<label>Data Zamówienia</label>
   <form:input path="orderdate" readonly="true"/>
    <label>Kwota Zamówienia</label>
	    <form:input path="totalprice" readonly="true"/>	
	    <form:input path="customer" type="hidden"/>			
	    <form:input path="customerserviceuser" type="hidden"/>		 
  </br>
  <button type="submit">Zapisz</button>
</form:form>

</div>
 </center>     
</div>
 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
