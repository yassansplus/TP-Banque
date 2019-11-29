<%@ page import="modele.Compte, modele.ClientInexistantException" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	ClientInexistantException err = (ClientInexistantException) request.getAttribute("ErreurCreationCompte");
	Compte compte = (Compte) request.getAttribute("CompteCree");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Résultat de création de compte </h1>

<%	if (err == null) { %>
		<h2 style="color: green;">Le compte a bien été créé sous le numéro : <%= compte.getNumCompte() %> </h2>
<%	} else { %>
		<h2 style="color: red;">Le compte n'a pas pu être enregistré (l'identifiant ne correspond à aucun client) </h2>
<%	} %>
</body>
</html>