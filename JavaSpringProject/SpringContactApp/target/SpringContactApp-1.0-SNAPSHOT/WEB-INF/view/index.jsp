<%-- 
    Document   : index
    Created on : Jan 2, 2021, 11:48:22 PM
    Author     : Zahra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login-Contact Application</title>
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
                     <h3>User Login</h3>
                     <c:if test="${err!=null}">
                         <p class="error">${err}</p>
                     </c:if>
                         <c:if test="${param.act eq 'lo'}"><!-- bind in a quey is a parameter, Here parameter is "act=lo"  -->
                         <p class="success">Logout Successfully! Thanks for using contact application.</p>
                     </c:if>
                         <c:if test="${param.act eq 'reg'}"><!-- bind in a quey is a parameter, Here parameter is "act=lo"  -->
                         <p class="success">User Registered Successfully.Please login</p>
                     </c:if>
                     <s:url var="url_login" value="/login"/>
                     <f:form action="${url_login}" modelAttribute="command">
                         <table border="1">
                             <tr>
                                 <td>Username</td>
                                 <td><f:input path="loginName"/></td>
                             </tr>
                              <tr>
                                 <td>Password</td>
                                 <td><f:password path="password"/></td>
                             </tr>
                              <tr>
                                  <td colspan="2">
                                      <button>Login</button><br>
                                       <a href="<s:url value="/reg_form"/>"> New User Registration </a>
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
