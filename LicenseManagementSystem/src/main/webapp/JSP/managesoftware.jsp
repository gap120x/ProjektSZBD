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
  <title>Softech-Zarządzanie Software</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">

<table>
  <caption>Lista Software</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Nazwa</th>
	   <th>Data Wydania</th>
      <th>Opis</th>
      <th>Zarządzanie</th>  	  
		  
	    </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="Software" items="${softwarelist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${Software.name}</td>
      <td data-column="imie">${Software.releasedate}</td>
	<td data-column="imie">${Software.description}</td>   
	<td data-column="zarzadzanie"><center><a href="/managesoftware/delete/${Software.id}"><img border="0" alt="Delete" src="/images/delete-icon-14.jpg" width="30" height="30"></a>
	  <a href="/managesoftware/edit/${Software.id}"><img border="0" alt="Edit" src="/images/editicon.png" width="30" height="30"></a>
	   
	   
	  </center></li></td>
		    </tr>  
	   </c:forEach>
  </tbody>
</table>
  
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
