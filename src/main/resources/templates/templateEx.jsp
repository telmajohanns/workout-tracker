<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Template EX</title>
</head>
<body>

<h1>Create new workout template</h1>
<%--@elvariable id="templateAddEx" type=""--%>
<sf:form method="post" commandName="templateAddEx" action="/templateAddEx">

</sf:form>

<input type="button" onclick="window.location.href='/homepage'" value="Back to homepage">

</body>
</html>