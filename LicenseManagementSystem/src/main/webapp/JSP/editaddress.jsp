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
  <title>Softech- Dodaj Adres Klienta</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Dodaj Adres Klienta</h1>
<div id="formdiv">
<form:form modelAttribute="address" method="POST" action="/manageaccount/customer/editaddress/${customerid}/save">
 <form:input type="hidden" path="id"/>
<label>Ulica</label>
 <form:input required="required" path="street"/>
<label>Miasto</label>
<form:input required="required" path="city"/>
<label>Kod Pocztowy</label>
<form:input required="required" type="kodp" pattern="[0-9]{2}-[0-9]{3}" path="postalCode"/>
<label>Kraj</label>
<form:input required="required" path="country"/>
 </br>
  <button type="submit">Zapisz</button>
</form:form>
	

</div>
 </center>   



</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
