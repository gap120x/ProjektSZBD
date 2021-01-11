<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
<ul id="menu">
    <li><a href="/">Strona Główna</a></li>
    <li><a>Konta Użytkowników</a>
    <ul>
        <li><a href="/accountlist">Lista Kont</a></li>
    <li><a href="/newaccount">Nowe konto</a></li>
    <li><a href="/manageaccount">Zarządzanie Kontami</a></li> 	 
    </ul>   
    </li>
	 <li><a>Działy</a>
    <ul>
        <li><a href="/">Lista Działów</a></li>
    <li><a href="/newaccount">Nowy Dział</a></li>
    <li><a href="/manageaccount">Zarządzanie Działami</a></li> 	 
    </ul>   
    </li>

    
   
    <li>
     <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <a onclick="document.forms['logoutForm'].submit()">Wyloguj</a>
    </li>
<div id="userlogin">Zalogowany jako: ${pageContext.request.userPrincipal.name}</div>

</ul>

</div>

