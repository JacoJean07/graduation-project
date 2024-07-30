<%-- 
    Document   : categoria
    Created on : 14 may. 2024, 18:54:13
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/header.jsp" />

<div class="card">
    <div class="card-body">
        <div class="row">
            <div class="col-md-12">
                <!-- aqui alertas -->
                <form action="../CategoriaController" method="post" autocomplete="off" id="formulario">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="categoria" class="text-dark font-weight-bold">Categoria</label>
                                <input type="text" placeholder="Ingrese Categoria" name="detalle" id="detalle" class="form-control" value="${row != null ? row.detalle : ''}">
                                <input type="hidden" name="id" id="id" value="${row != null ? row.id : ''}">
                            </div>
                        </div>
                        <div class="col-md-4 mt-4">
                            <input type="submit" value="${row != null ? 'Modificar' : 'Registrar'}" class="btn btn-info" id="btnAccion">
                            <input type="button" value="Nuevo" class="btn btn-success" id="btnNuevo" onclick="limpiar()">
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
                                <th>Categoria</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="categoria" items="${sessionScope.data}">
                                <tr>
                                    <td>${categoria['id']}</td>
                                    <td>${categoria['detalle']}</td>
                                    <td style="width: 200px;">
                                        <a href="../VistasController?vista=categoria&id=${categoria['id']}" onclick="" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                        <form action="../CategoriaController" method="post">
                                            <input type="hidden" name="id" id="id" value="${categoria['id']}">
                                            <input type="hidden" name="action" id="action" value="delete">
                                            <button class="btn btn-danger" type="submit" onclick="return confirm('¿Seguro que desea eliminar esta categoria?');"><i class='fas fa-trash-alt'></i> </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <c:out value="${sessionScope.row}" />
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />
