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
  <title>Softech- Nowe Konto Sprzedawcy</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Dodaj nowe konto Sprzedawcy W dziale ${department}</h1>
<div id="formdiv">
<form:form modelAttribute="newUser" method="POST" action="/mydepartment/newaccountcustomerserviceuser/save">
<label>Nazwa Użytkownika </label>
 <form:input required="required" path="nickname"/>
  <div id="wrongusername"><c:if test="${not empty wrongusername}">${wrongusername}</c:if></div>
  <label>Hasło </label>
   <form:input required="required" type="password" path="password"/>
   <label>Imie </label>
    <form:input required="required" path="firstname"/>
	 <label>Nazwisko</label>
   <form:input required="required" type="text" path="surname"/>
    <label>Email </label>
      <form:input required="required" type="email" path="email"/>	      
<form:input type="hidden" required="required" path="role" value="ROLE_CUSTOMERSERVICEUSER"/>
<label>Czy Aktywne</label>
	    <form:select required="required" path="enabled">
		<form:option value="true">Aktywne</form:option>
		<form:option value="false"> Zablokowane</form:option>
		</form:select>
		<form:form modelAttribute="newEmployee" method="POST">		
		
 <label>Data Zatrudnienia</label>
 <form:input type="date" required="required" path="employmentdate"/>

 <label>Pozycja</label>
 <form:input required="required" path="position"/>
 <label>Pensja Podstawowa</label>
 <form:input required="required" path="basicsalary"/>
  <label>Godziny Pracy</label>
 <form:input path="workinghours"/>
	<label>Dział</label>
	 <form:input required="required" readonly="true" path="department"/>
	<form:form modelAttribute="newCustomerServiceUser" method="POST">	
	<label>Target Sprzedażowy</label>
 <form:input required="required" path="salestargetvalue"/>
 	<label>Target ilości Licencji</label>
 <form:input required="required" path="salestargetlicenses"/>
 
	</br>
  <button type="submit">Zapisz</button>
    </form:form>
  </form:form>
</form:form>

</div>
 </center>   



</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
