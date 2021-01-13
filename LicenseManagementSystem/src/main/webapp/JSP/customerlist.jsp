<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
 <link href="/../css/style.css" rel="stylesheet" type="text/css">
  <link href="/../css/table.css" rel="stylesheet" type="text/css">
<head>
  <meta charset="UTF-8">
  <title>Softech- Lista kont klientów</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">

<table>
  <caption>Lista Kont Klientów</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Użytkownik</th>
      <th>Imie</th>
      <th>Nazwisko</th>
	  <th>email</th>
	    <th>Czy Aktywne</th>
		 <th>VAT</th>
		 <th>NIP</th>
		   <th>Zniżka</th>
		  <th>Firma</th>
		  <th>Adres</th>
		  
	    </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="CustomerDto" items="${customerlist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${CustomerDto.nickname}</td>
      <td data-column="imie">${CustomerDto.firstname}</td>
      <td data-column="nazwisko">${CustomerDto.surname}</td>	     
	  <td data-column="email">${CustomerDto.email}</td>
	    <td data-column="email">${CustomerDto.enabled}</td>
		    <td data-column="email">${CustomerDto.vat}</td>
			  <td data-column="email">${CustomerDto.nip}</td>
			   <td data-column="email">${CustomerDto.discount}</td>
			   	   <td data-column="email">${CustomerDto.companyName}</td>
				   <td data-column="adres"><a href="/manageaccount/customer/viewaddress/${CustomerDto.userid}">Wyświetl</td>  

	
		    </tr>  
	   </c:forEach>
  </tbody>
</table>
  
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
