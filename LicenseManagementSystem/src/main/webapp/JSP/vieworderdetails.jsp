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
  <title>Softech- Sczegóły Zamówienia</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  
<table>
  <caption>Lista Produktów na zamówieniu</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Nazwa</th>
	    <th>Opis</th>
		   <th>Cena</th>
		   <th>Ilość</th>
		     <th>Suma</th>
					 
        </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="ProductListDto" items="${productlistonorder}">
    <tr >
	<c:set var="count" value="${count + 1}" scope="page"/>
      <td data-column="id">${count}</td>
      <td data-column="nazwa">${ProductListDto.name}</td>
	       <td data-column="nazwa">${ProductListDto.description}</td>
		     <td data-column="nazwa">${ProductListDto.price} PLN</td>
			  <td data-column="nazwa">${ProductListDto.quantity}</td>
			   <td data-column="nazwa">${ProductListDto.totalprice} PLN</td> 
			  	</center></li></td>	   		     
      	       </tr>  
	   </c:forEach> 
  </tbody>
</table>
<button onclick="goBack()">Wróć</button>

<script>
function goBack() {
  window.history.back();
}
</script>
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
