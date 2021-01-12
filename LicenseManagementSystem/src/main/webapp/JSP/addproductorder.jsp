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
  <caption>Lista Produktów na zamówieniu ID: ${newProductList.order.id}</caption>
  <thead>
    <tr>
      <th>LP.</th>
      <th>Nazwa</th>
	    <th>Opis</th>
		   <th>Cena</th>
		   <th>Ilość</th>
		     <th>Suma</th>
			<th>Usuń</th>				 
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
			  	 <td data-column="zarzadzanie"><center><a href="/neworder/create/addproduct/${newProductList.order.id}/delete/${ProductListDto.productlistid}"><img border="0" alt="Delete" src="/images/delete-icon-14.jpg" width="30" height="30"></a>
					</center></li></td>	   		     
      	       </tr>  
	   </c:forEach>
 <td colspan="5" ></td><td id="suma"  data-column="nazwa">Suma Zamówienia:</td> <td id="suma" data-column="nazwa"> ${newProductList.order.totalprice} PLN</td>	   
  </tbody>
</table>
<center>
<h1 id="tytul">Wybierz Produkt Który chcesz dodać do zamówienia</h1>
<div id="formdiv">
<form:form modelAttribute="newProductList" method="POST" action="/neworder/create/addproduct/${newProductList.order.id}/save">
		  <label>Wybierz Produkt </label>
  <form:select required="required" path="product">
        <form:options items="${productlist}" itemValue="productid" itemLabel="nameandprice" />
    </form:select>
 <label>Ilość</label>
 <form:input required="required" type="number" min="1" path="quantity"/>
   <label>ID Zamowienia</label>
 <form:input required="required" path="order" readonly="true"/>
 
	</br>
  <button type="submit">Zapisz</button>
</form:form>
</div>
 </center>   



</div>

 <%@ include file="footer.jsp"%>
</body>
</html>

      
 				
