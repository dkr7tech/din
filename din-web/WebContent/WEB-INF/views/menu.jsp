<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>#sidebar ul {
    margin: 0;
    padding: 0;
    list-style-type: none;
}
 
#sidebar ul ul {
    margin-left: 10px; 
}
 
#sidebar li {
    display: block;
    margin: 0;
    padding: 1px 0 0 2px; 
}
</style>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<ul>
<c:forEach var="menuItem" items="${verticalMenu}">
    <c:set var="verticalMenu" value="${menuItem.menuItems}" scope="request"/>
    <li>
        <c:choose>
            <c:when test="${menuItem.selected}">
                <a href="#" class="selected"><span><c:out value="${menuItem.key}" escapeXml="true"/></span></a>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${ ! empty menuItem.url }">
                        <a href="<spring:url value="${menuItem.url}"/>"><span><c:out value="${menuItem.key}" escapeXml="true"/></span></a>
                    </c:when>
                    <c:otherwise>
                       <span><c:out value="${menuItem.key}" escapeXml="true"/></span>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        <c:if test="${fn:length(menuItem.menuItems) > 0}">
            <jsp:include page="/WEB-INF/jsp/verticalMenu.jsp"/>
        </c:if>
    </li>
</c:forEach>
</ul> --%>