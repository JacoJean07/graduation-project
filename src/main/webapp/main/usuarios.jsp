<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/header.jsp" />

<div class="card">
    <div class="card-body">
        <form action="../UserController" method="post" autocomplete="off" id="formulario">
            <div class="row">
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre" id="nombre" 
                            value="${row != null ? row.nombre : ''}">
                        <input type="hidden" id="id" name="id" value="${row != null ? row.id : ''}">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" placeholder="Ingrese Correo Electrónico" name="correo" id="correo" 
                            value="${row != null ? row.correo : ''}">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" placeholder="Ingrese Usuario" name="usuario" id="usuario" 
                            value="${row != null ? row.user : ''}">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="clave">Contraseña</label>
                        <input type="password" class="form-control" placeholder="Ingrese Contraseña" name="clave" id="clave">
                    </div>
                </div>
            </div>
            <input type="submit" value="${row != null ? 'Actualizar' : 'Registrar'}" class="btn btn-info" id="btnAccion">
            <input type="button" value="Nuevo" class="btn btn-success" id="btnNuevo" onclick="limpiar()">
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-hover table-striped table-bordered mt-2" id="tbl">
        <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Usuario</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${sessionScope.data}">
                <tr>
                    <td>${user['id']}</td>
                    <td>${user['nombre']}</td>
                    <td>${user['correo']}</td>
                    <td>${user['user']}</td>
                    <td>
                        <a href="../VistasController?vista=usuarios&id=${user['id']}" class="btn btn-success"><i class='fas fa-edit'></i></a>
                        <form action="../UserController" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${user['id']}">
                            <input type="hidden" name="action" value="delete">
                            <button class="btn btn-danger" type="submit" onclick="return confirm('¿Seguro que desea eliminar este usuario?');"><i class='fas fa-trash-alt'></i></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- sistemoutprint de row y de data -->
<c:out value="${row}" />

<div class="pagination">
    <c:forEach var="i" begin="1" end="${totalPages}">
        <a href="ShowController?page=${i}&pageSize=10">${i}</a>
    </c:forEach>
</div>

<jsp:include page="includes/footer.jsp" />
