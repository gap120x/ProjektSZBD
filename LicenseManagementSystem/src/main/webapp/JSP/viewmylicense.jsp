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
  <title>Softech- Wybierz Typ konta</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  

   
<table>
  <caption>Lista Licencji</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Klucz Licencyjny</th>
      <th>Data Wydania</th>
	<th>Data Wygaśniecia</th>
	<th>Nazwa Software'u</th>
		  
	    </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="LicenseDto" items="${licenselist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${LicenseDto.licensekey}</td>
      <td data-column="imie">${LicenseDto.releasedate}</td>
      <td data-column="imie">${LicenseDto.expirationdate}</td>
	<td data-column="imie">${LicenseDto.softwarename}</td> 	  	  
	
		    </tr>  
	   </c:forEach>
  </tbody>
</table>


</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
