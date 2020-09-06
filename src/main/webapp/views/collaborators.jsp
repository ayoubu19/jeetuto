<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 3/17/2020
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>collaborators</title>
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
<table class="table table-striped">
    <thead>
    <tr>

        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
        <th scope="col">Post</th>
        <th scope="col">Age</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.collaborators}" var="collaborator">
        <tr>
            <th><c:out value="${collaborator.nom}"/></th>
            <th><c:out value="${collaborator.prenom}"/></th>
            <th><c:out value="${collaborator.post}"/></th>
            <th><c:out value="${collaborator.age}"/></th>
            <th>
                <c:choose>
                    <c:when test="${sessionScope.username==collaborator.userName}">
                        <button type="button" class="btn btn-danger" disabled>
                           Delete
                        </button>
                    </c:when>
                    <c:otherwise>
                    <form action="/deleteCollaborator?username=<c:out value="${collaborator.userName}"/>" method="post">
                        <div class="form-group">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </div>
                    </form>
                    </c:otherwise>
                </c:choose>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" class="btn btn-success"
        data-toggle="modal" data-target="#addCollaborator">
    add collaborator
</button>
<div class="modal fade" id="addCollaborator" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">add collaborator</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form action="/addCollaborator" method="post">
                    <div class="form-group">
                        <label for="nom">Usename</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="username" required>
                    </div>
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" required>
                    </div>
                    <div class="form-group">
                        <label for="prenom">prenom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom" required>
                    </div>
                    <div class="form-group">
                        <label for="post">Post</label>
                        <input type="text" class="form-control" id="post" name="post" placeholder="Post" required>
                    </div>
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" class="form-control" id="age" name="age" placeholder="Age" required>
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
    document.getElementById("collaborators-tab").className = "nav-link active";
    document.getElementById("login-tab").className = "nav-link disabled";
</script>
</body>
</html>
