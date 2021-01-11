<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
<head>
  <meta charset="UTF-8">
  <title>Softech- Zmień Hasło Użytkownika ${editUser.nickname}</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
   <link href="/../css/style.css" rel="stylesheet" type="text/css">
  <link href="/../css/form.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">
<center>
<h1 id="tytul">Edytuj Hasło Użytkownika ${editUser.nickname}</h1>
<div id="formdiv">
<form:form modelAttribute="editUser" method="POST" action="/manageaccount/editpassword/${editUser.id}/save">
<label>ID Użytkownika </label>
 <form:input path="id" readonly="true"/>
<label>Nazwa Użytkownika </label>
 <form:input path="nickname" readonly="true"/>
   <label>Hasło</label>
   <form:input required="required" type="password" path="password"/>    
	<form:input type="hidden" path="email"/>
   <form:input type="hidden" path="firstname"/>
   <form:input type="hidden" path="surname"/>	  
	<form:input type="hidden" path="role"/>
	<form:input type="hidden" path="enabled"/>
		 </br>
  <button type="submit">Zapisz</button>
</form:form>

</div>
 </center>   
  </div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
