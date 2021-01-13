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
  <title>Softech-Zarządzanie Pracownikami</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">

<table>
  <caption>Lista Kont Sprzedawców</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Użytkownik</th>
      <th>Imie</th>
      <th>Nazwisko</th>

	    <th>Czy Aktywne</th>
		 <th>Data Zatrudnienia</th>
		 <th>Stanowisko</th>
		   <th>Dział</th>
		  <th>Pensja</th>
		  <th>Godziny Pracy</th>
		   <th>Target Sprzedaży</th>
		     <th>Target Licencji</th>
			   <th>Zarządzanie</th>
		  
	    </tr>
  </thead>
  <tbody>
    <c:set var="count" value="0" scope="page" />
  <c:forEach var="CustomerServiceUserDto" items="${customerserviceuserlist}">
    <tr>
<c:set var="count" value="${count + 1}" scope="page"/>		
      <td data-column="LP">${count}</td>
      <td data-column="nazwa">${CustomerServiceUserDto.nickname}</td>
      <td data-column="imie">${CustomerServiceUserDto.firstname}</td>
      <td data-column="nazwisko">${CustomerServiceUserDto.surname}</td> 
	    <td data-column="email">${CustomerServiceUserDto.enabled}</td>
		<td data-column="email">${CustomerServiceUserDto.employmentdate}</td>
		<td data-column="email">${CustomerServiceUserDto.position}</td>
		<td data-column="email">${CustomerServiceUserDto.departmentname}</td>
		<td data-column="email">${CustomerServiceUserDto.basicsalary}</td>
		<td data-column="email">${CustomerServiceUserDto.workinghours}</td>
		<td data-column="email">${CustomerServiceUserDto.salestargetvalue}</td>
		<td data-column="email">${CustomerServiceUserDto.salestargetlicenses}</td>
		  <td data-column="zarzadzanie"><center><a href="/manageaccount/customerservice/delete/${CustomerServiceUserDto.userid}"><img border="0" alt="Delete" src="/images/delete-icon-14.jpg" width="30" height="30"></a>
	  <a href="/manageaccount/customerservice/edit/${CustomerServiceUserDto.userid}"><img border="0" alt="Edit" src="/images/editicon.png" width="30" height="30"></a>
	   <a href="/manageaccount/editpassword/${CustomerServiceUserDto.userid}"><img border="0" alt="Delete" src="/images/editpassword.png" width="30" height="30"></a>	   
	   
	  </center></li></td>	

	
		    </tr>  
	   </c:forEach>
  </tbody>
</table>
  
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
