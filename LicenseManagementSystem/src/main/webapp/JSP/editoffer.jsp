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
  <title>Softech- Edycja Oferty</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Nowa Oferta</h1>
<div id="formdiv">
<form:form modelAttribute="offer" method="POST" action="/editoffer/save">
  <label>ID</label>
 <form:input required="required" path="id" readonly="true"/>
 <label>Data stworzenia</label>
 <form:input required="required" path="date" readonly="true"/>
<label>Data wygaśnięcia</label>
 <form:input required="required" type="date" path="expirationdate"/>
 <label>Status</label>
 <form:input required="required" path="status"/>
 <label>Klient</label>
 <form:input required="required" path="customer" readonly="true"/>
  <form:input required="required" path="customerserviceuser" type="hidden" />
  <label>Opis Oferty</label>
<form:textarea path="description" rows="5" cols="30" />
</br>
  <button type="submit">Zapisz</button>
</form:form>

</div>
 </center>   



</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
