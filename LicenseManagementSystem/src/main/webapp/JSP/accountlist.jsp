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
  <title>Softech- Wybierz Typ konta</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">

</head>
<body>
  <%@ include file="header.jsp"%>
   <%@ include file="menu.jsp"%>
<div id="site-content">  

<center>
<h1 id="tytul">Wybierz Typ konta które chcesz Wyświetlić</h1>
<div id="formdiv">
<form:form modelAttribute="account" method="POST" action="/accountlist">
<label>Typ Konta</label>	
	<form:select required="required" path="role">
     	<form:option value="manager">Menedżer</form:option>
		<form:option value="sprzedawca">Sprzedawca</form:option>
		<form:option value="klient">Klient</form:option>
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

      
 				
