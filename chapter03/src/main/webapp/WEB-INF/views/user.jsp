<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Create User</h1>
<form:form method="post" modelAttribute="user">
    <form:errors path="" cssClass="text-warning" />
    <form:hidden path="guid" />
    <fieldset>
        <form:label path="name">Name:</form:label>
        <form:input path="name" type="text" required="required" />
        <form:errors path="name" cssClass="text-warning" />
    </fieldset>
    <fieldset>
        <form:label path="userId">User ID:</form:label>
        <form:input path="userId" type="text" required="required" />
        <form:errors path="userId" cssClass="text-warning" />
    </fieldset>
    <fieldset>
        <form:label path="country">Country:</form:label>
        <form:select path="country">
            <form:option value="" label="Select" />
            <form:options items="${countries}" />
        </form:select>
        <form:errors path="country" cssClass="text-warning" />
    </fieldset>
    <fieldset>
        <form:label path="password">Password:</form:label>
        <form:input path="password" type="password" required="required" />
        <form:errors path="password" cssClass="text-warning" />
    </fieldset>
    <fieldset>
        <form:label path="password2">Reenter Password:</form:label>
        <form:input path="password2" type="password" required="required" />
        <form:errors path="password2" cssClass="text-warning" />
    </fieldset>
    <input class="btn btn-success" type="submit" value="Submit" />
</form:form>