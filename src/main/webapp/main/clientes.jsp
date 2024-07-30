<%-- Document : clientes Created on : 3 jun. 2024, 16:01:51 Author : Jaco --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <jsp:include page="includes/header.jsp" />

            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- alertas aqui -->
                            <form action="../ClienteController" method="post" autocomplete="off" id="formulario">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="nombre" class="text-dark font-weight-bold">Nombre</label>
                                            <input type="text" placeholder="Ingrese Nombre" name="nombre" id="nombre"
                                                class="form-control" value="${row != null ? row.nombre : ''}">
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label for="telefono" class="text-dark font-weight-bold">Teléfono</label>
                                            <input type="number" placeholder="Ingrese Teléfono" name="telefono"
                                                id="telefono" class="form-control"
                                                value="${row != null ? row.telefono : ''}">
                                            <input type="hidden" name="id" id="id" value="${row != null ? row.id : ''}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="direccion" class="text-dark font-weight-bold">Dirección</label>
                                            <input type="text" placeholder="Ingrese Direccion" name="direccion"
                                                id="direccion" class="form-control"
                                                value="${row != null ? row.direccion : ''}">
                                        </div>
                                    </div>
                                    <div class="col-md-4 mt-3">
                                        <input type="submit" value="${row != null ? 'Actualizar' : 'Registrar'}"
                                            class="btn btn-info" id="btnAccion">
                                        <input type="button" value="Nuevo" class="btn btn-success" id="btnNuevo"
                                            onclick="limpiar()">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered" id="tbl">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>Teléfono</th>
                                            <th>Dirección</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cliente" items="${sessionScope.data}">
                                            <tr>
                                                <td>${cliente['id']}</td>
                                                <td>${cliente['nombre']}</td>
                                                <td>${cliente['telefono']}</td>
                                                <td>${cliente['direccion']}</td>
                                                <td style="width: 200px;">
                                                    <a href="../VistasController?vista=clientes&id=${cliente['id']}"
                                                        class="btn btn-success"><i class='fas fa-edit'></i></a>
                                                    <form action="../ClienteController" method="post"
                                                        style="display:inline;">
                                                        <input type="hidden" name="id" value="${cliente['id']}">
                                                        <input type="hidden" name="action" value="delete">
                                                        <button class="btn btn-danger" type="submit"
                                                            onclick="return confirm('¿Seguro que desea eliminar este cliente?');"><i
                                                                class='fas fa-trash-alt'></i></button>
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <jsp:include page="includes/footer.jsp" />