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
  <title>Softech- Edycja Konta Klienta</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Edytuj konto Klienta</h1>
<div id="formdiv">
<form:form modelAttribute="editUser" method="POST" action="/manageaccount/customer/edit/${editUser.id}/save">
<label>ID</label>
 <form:input required="required" path="id" readonly="true"/>
<label>Nazwa Użytkownika </label>
 <form:input readonly="true" required="required" path="nickname"/>
   <form:input required="required" type="hidden" path="password"/>
   <label>Imie </label>
    <form:input required="required" path="firstname"/>
	 <label>Nazwisko</label>
   <form:input required="required" type="text" path="surname"/>
    <label>Email </label>
      <form:input required="required" type="email" path="email"/>	      
<form:input type="hidden" required="required" path="role" value="ROLE_CUSTOMER"/>
<label>Czy Aktywne</label>
	    <form:select required="required" path="enabled">
		<form:option value="true">Aktywne</form:option>
		<form:option value="false"> Zablokowane</form:option>
		</form:select>
		<form:form modelAttribute="editCustomer" method="POST">	
 <form:input type="hidden" path="id"/>
 <label>VAT</label>
 <form:input path="vat"/>
 <label>NIP</label>
 <form:input path="nip"/>
 <label>Zniżka</label>
 <form:input path="discount"/>
  <label>Nazwa Firmy</label>
 <form:input path="companyname"/>		
	</br>
  <button type="submit">Zapisz</button>
  </form:form>
</form:form>

</div>
 </center>   



</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
