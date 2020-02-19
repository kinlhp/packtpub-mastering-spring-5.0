<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@page isErrorPage="true"%>
<h1>Common error page</h1>
URL: ${method} ${url}
<br />
Exception: ${exception.message}
<br />
Stack trace:
<br />
<core:forEach items="${exception.stackTrace}" var="st">
    ${st}
</core:forEach>