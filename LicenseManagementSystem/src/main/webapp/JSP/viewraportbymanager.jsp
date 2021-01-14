<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
 <link href="/../css/style.css" rel="stylesheet" type="text/css">
  <link href="/../css/table.css" rel="stylesheet" type="text/css">
  <link href="/../css/form.css" rel="stylesheet" type="text/css">
<head>
  <meta charset="UTF-8">
  <title>Softech-Raport Pracowników Działu</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">
<center>
<form:form modelAttribute="data" method="POST" action="/mydepartment/viewraport">

<label>Od</label>
 <form:input type="date" required="required" path="start"/>
  <label>Do</label>
   <form:input type="date" required="required" path="end"/>
   </br>
  <button type="submit">Zatwierdź</button>
</form:form>
</center>

<table>
  <caption>Raporty</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Imie</th>
      <th>Nazwisko</th>
 <th>Kwota zamówień</th>
 <th>Ilość zamówień</th>
 <th>Ilość Produktów</th>	 
		</tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="EmployeeRaportDto" items="${raportlist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${EmployeeRaportDto.firstname}</td>       		 
	 <td data-column="nazwa">${EmployeeRaportDto.surname}</td>
     <td data-column="nazwa">${EmployeeRaportDto.orderssum}</td>
     <td data-column="nazwa">${EmployeeRaportDto.ordersquantity}</td>
     <td data-column="nazwa">${EmployeeRaportDto.productsum}</td>    	 
		    </tr>  
	   </c:forEach>
  </tbody>
</table>
  
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
