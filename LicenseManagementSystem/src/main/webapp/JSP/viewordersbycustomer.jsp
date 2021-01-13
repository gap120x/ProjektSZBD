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
    <link href="/../css/table.css" rel="stylesheet" type="text/css">
<head>
  <meta charset="UTF-8">
  <title>Softech- Lista zamówień</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  

<table>
  <caption>Lista Zamówień</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Data zamówienia</th>
      <th>Suma</th>
	<th>Status</th>
	<th>Imię Klienta</th>
		<th>Nazwisko</th>
		<th>Szczegóły</th>
		  
	    </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="OrderDto" items="${orderlist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${OrderDto.orderdate}</td>
      <td data-column="imie">${OrderDto.totalprice}</td>
      <td data-column="imie">${OrderDto.status}</td>
	<td data-column="imie">${OrderDto.customername}</td> 
	<td data-column="imie">${OrderDto.customersurname}</td>
 	<td data-column="adres"><a href="/order/view/details/${OrderDto.orderird}">Wyświetl</td>  
	
		    </tr>  
	   </c:forEach>
  </tbody>
</table>


</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
