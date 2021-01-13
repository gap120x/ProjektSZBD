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
  <title>Softech- Nowy Produkt</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Dodaj nowy Produkt</h1>
<div id="formdiv">
<form:form modelAttribute="newProduct" method="POST" action="/newproduct/save">
<label>Cena</label>
 <form:input required="required" path="price"/>
  <label>Waluta</label>
 <form:select required="required" path="currency">
		<form:option value="PLN">PLN</form:option>
		<form:option value="USD">USD</form:option>
		<form:option value="EUR">EUR</form:option>
		</form:select>
   <label>Software</label>
<form:select required="required" path="software">
        <form:options items="${softwarelist}" itemValue="id" itemLabel="name" />
    </form:select> 
  </br>
  <button type="submit">Zapisz</button>
  </form:form>
  </div>
 </center>   
</div>
 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
