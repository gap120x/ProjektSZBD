<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
 <link href="/../css/style.css" rel="stylesheet" type="text/css">
<head>
  <meta charset="UTF-8">
  <title>Softech-Oferta</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">
<div id="offerview">
Data Stworzenia: ${offer.date} </br>
Data Wygaśnięcia: ${offer.expirationdate}</br>
Status: ${offer.status}</br>
 Opis: ${offer.description}</br>
</div>
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

      
 				
