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
  <title>Softech- Edytuj Licencje</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  


<center>
<h1 id="tytul">Edytuj licencje</h1>
<div id="formdiv">
<form:form modelAttribute="editLicense" method="POST" action="/license/manage/edit/${editLicense.id}/save">
<label>ID</label>
 <form:input required="required" readonly="true" path="id"/>  
<label>Wprowadź Klucz Licencyjny</label>
 <form:input required="required" path="licensekey"/>  
  <label>Data Wydania</label>
 <form:input type="date" required="required" path="releasedate"/>
   <label>Data Wygaśnięcia</label>
 <form:input type="date" required="required" path="expirationdate"/>
   <label>Wybierz Klienta</label>
<form:select required="required" path="customer">
        <form:options items="${clientlist}" itemValue="userid" itemLabel="firstnameandsurname" />
    </form:select>
   <label>Wybierz Produkt</label>
<form:select required="required" path="product">
        <form:options items="${productlist}" itemValue="productid" itemLabel="nameandprice" />
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

      
 				
