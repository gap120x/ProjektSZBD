<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
<ul id="menu">
    <li><a href="/">Strona Główna</a></li>
    <li><a>Konta Użytkowników</a>
    <ul>    
    <li><a href="/newaccount">Nowe konto</a></li>
    <li><a href="/newaccount">Zarządzanie Kontami</a></li>  	

	 
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

