<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
<ul id="menu">
    <li><a href="/">Strona Główna</a></li>
     <sec:authorize access="hasRole('ROLE_ADMIN')">
	<li><a>Konta Użytkowników</a>
    <ul>
        <li><a href="/accountlist">Lista Kont</a></li>
    <li><a href="/newaccount">Nowe konto</a></li>
    <li><a href="/manageaccount">Zarządzanie Kontami</a></li> 	 
    </ul>   
    </li>
	 <li><a>Działy</a>
    <ul>
        <li><a href="/departmentlist">Lista Działów</a></li>
    <li><a href="/newdepartment">Nowy Dział</a></li>
    <li><a href="/manage/department/">Zarządzanie Działami</a></li> 	 
    </ul>   
    </li>
	 <li><a href="/viewraport">Raporty Działów</a></li> 
</sec:authorize>
   <sec:authorize access="hasRole('ROLE_MANAGER')">
<li><a>Pracownicy</a>
    <ul>
        <li><a href="/mydepartment/customerservicelist">Wyświetl listę</a></li>
    <li><a href="/mydepartment/newcustomerserviceuser">Nowy Pracownik</a></li>
    <li><a href="/mydepartment/manageaccount/customerservice">Zarządzanie Pracownikami</a></li>
    <li><a href="/mydepartment/viewraport">Raport</a></li> 	
    </ul>   
    </li>
    </sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Klienci</a>
    <ul>
        <li><a href="/accountlist/customer">Wyświetl listę</a></li>
    <li><a href="/newaccount/customer">Nowy Klient</a></li>
    <li><a href="/manageaccount/customer">Zarządzanie Klientami</a></li> 	 
    </ul>   
    </li>
      </sec:authorize>
	  	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Produkty</a>
    <ul>
        <li><a href="/productlist">Wyświetl listę Produktów</a></li>
    <li><a href="/softwarelist">Wyświetl listę Software</a></li>
    <li><a href="/newsoftware">Nowy Software</a></li>
 <li><a href="/newproduct">Nowy Produkt</a></li>
  <li><a href="/managesoftware">Zarządzanie Software</a></li>
  <li><a href="/manageproduct">Zarządzanie Produktem</a></li>

    </ul>   
    </li>
      </sec:authorize>
	   	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Licencje</a>
    <ul>
        <li><a href="/license/view">Wyświetl listę</a></li>
    <li><a href="/newlicense">Stwórz nową licencje</a></li>
    <li><a href="/license/manage">Zarządzanie Licencjami</a></li> 	 
    </ul>   
    </li>
      </sec:authorize>
	   	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Zamówienia</a>
    <ul>
        <li><a href="/order/view">Wyświetl listę</a></li>
    <li><a href="/neworder/create">Nowe Zamówienie</a></li>
    <li><a href="/order/manage">Zarządzanie Zamówieniami</a></li> 	 
    </ul>   
    </li>
      </sec:authorize>
	    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
	  <li><a href="/viewmyorders">Wyświetl Moje Zamówienia</a></li></sec:authorize>
	   <sec:authorize access="hasRole('ROLE_CUSTOMER')">
	  <li><a href="/viewmylicense">Wyświetl Moje Licencje</a></li></sec:authorize>
	  	   <sec:authorize access="hasRole('ROLE_CUSTOMER')">
	   <li><a href="/viemyoffers">Wyświetl Moje Oferty</a></li></sec:authorize>
	   	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Oferty</a>
    <ul>
        <li><a href="/customerserviceuser/viewoffers">Wyświetl listę</a></li>
    <li><a href="/newoffer">Nowa Oferta</a></li>
    <li><a href="/customerserviceuser/manageoffers">Edytuj Oferty</a></li> 	 
    </ul>   
    </li>
      </sec:authorize>
	    	<sec:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMERSERVICEUSER')">
	<li><a>Baza Wiedzy</a>
    <ul>
        <li><a href="/viewarticles">Wyświetl listę</a></li>
    <li><a href="/newarticle">Nowy Artykuł</a></li>
    <li><a href="/editarticles">Edytuj Artykuły</a></li> 	 
    </ul>   
    </li>
      </sec:authorize>	  
    <li>
     <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <a onclick="document.forms['logoutForm'].submit()">Wyloguj</a>
    </li>
<div id="userlogin">Zalogowany jako: ${pageContext.request.userPrincipal.name}</div>

</ul>

</div>

