<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 3/17/2020
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>holidays</title>
    <link rel="stylesheet" href="<c:url value="${pageContext.request.contextPath}/resources/css/style.css"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<c:import url="header.jsp"/>
<h1>Congés de : <c:out value="${requestScope.user.userName}"/></h1>
<p class="card-text">votre compteur de congés est :
    <c:choose>
        <c:when test="${requestScope.user.holidayCounter < 0}">
            <span class="text-danger"><c:out value="${requestScope.user.holidayCounter}"/></span>
        </c:when>
        <c:when test="${requestScope.user.holidayCounter < 5}">
            <span class="text-warning"><c:out value="${requestScope.user.holidayCounter}"/></span>
        </c:when>
        <c:otherwise>
            <span class="text-success"><c:out value="${requestScope.user.holidayCounter}"/></span>
        </c:otherwise>
    </c:choose>
</p>
<button type="button" class="btn btn-success"
        data-toggle="modal" data-target="#holidays">
    Demander un conge
</button>
<div class="modal fade" id="holidays" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">ask for holidays</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form action="/askForHoliday" method="post">
                    <div class="form-group">
                        <label for="holiday">how much you want to rest huh</label>
                        <input type="number" class="form-control" id="holiday" name="holidays" placeholder="holidays" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success">submit</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>


<script>
    document.getElementById("holidays-tab").className = "nav-link active";
    document.getElementById("login-tab").className = "nav-link disabled";
</script>
</body>
</html>
