<%-- 
    Document   : usuarios
    Created on : 14 may. 2024, 14:27:12
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />

<div class="card">
    <div class="card-body">
        <form action="../usuarios/RegisterController" method="post" autocomplete="off" id="formulario">
            <!-- alertas aqui -->
            <div class="row">
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre" id="nombre">
                        <input type="hidden" id="id" name="id">
                    </div>

                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" placeholder="Ingrese Correo Electrónico" name="correo" id="correo">
                    </div>

                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" placeholder="Ingrese Usuario" name="usuario" id="usuario">
                    </div>

                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="clave">Contraseña</label>
                        <input type="password" class="form-control" placeholder="Ingrese Contraseña" name="clave" id="clave">
                    </div>
                </div>
            </div>
            <input type="submit" value="Registrar" class="btn btn-info" id="btnAccion">
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
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user['id']}</td>
                    <td>${user['name']}</td>
                    <td>${user['email']}</td>
                    <td>${user['username']}</td>
                    <td>
                        <a href="#" class="btn btn-warning"><i class='fas fa-key'></i></a>
                        <a href="#" onclick="editarUsuario()" class="btn btn-success"><i class='fas fa-edit'></i></a>
                        <form action="#" method="post">
                            <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="pagination">
    <c:forEach var="i" begin="1" end="${totalPages}">
        <a href="ShowController?page=${i}&pageSize=10">${i}</a>
    </c:forEach>
</div>

<jsp:include page="includes/footer.jsp" />
