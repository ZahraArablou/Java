

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Form-Contact Application</title>
        <!-- <s:url var="url_css" value="static/css/style.css" /> -->
        <link href="static/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body>
        <table border="l" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%--Header--%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px" ">
                    <%--Menu--%>
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top" >
                    <%--Page Content Area--%>
                    <h3>Contact Form</h3>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>

                    <s:url var="url_csave" value="/user/save_contact"/>
                    <f:form action="${url_csave}" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>Name</td>
                                <td><f:input path="name"/></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="phone"/></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="email"/></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><f:textarea path="address"/></td>
                            </tr>

                            <tr>
                                <td>remark</td>
                                <td><f:textarea path="remark"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <button>Save</button><br>
                                </td>

                            </tr>
                        </table>
                    </f:form>

                </td>
            </tr>
            <tr>
                <td height="25px" >
                    <%--Footer--%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>

    </body>
</html>
