<%-- 
    Document   : categoria
    Created on : 14 may. 2024, 18:54:13
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/header.jsp" />

<!-- realizar la vista de gastos -->
<div class="card shadow-lg">
    <div class="card-body">
        <form action="" method="post" autocomplete="off" id="formulario">
            <!-- aqui van las alertas -->
            <div class="row">
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="detalle">detalle</label>
                        <input type="text" class="form-control" placeholder="Ingrese detalle" name="detalle" id="detalle">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="monto">monto</label>
                        <input type="number" class="form-control" placeholder="Ingrese monto" name="monto" id="monto">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label for="fecha">fecha</label>
                        <input type="date" class="form-control" placeholder="Ingrese fecha" name="fecha" id="fecha">
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
                <th>detalle</th>
                <th>monto</th>
                <th>fecha</th>
                <th></th>
            </tr>
        </thead>   
        <tbody>
            <c:forEach var="gasto" items="${sessionScope.data}">
                <tr>
                    <td>${gasto['id']}</td>
                    <td>${gasto['detalle']}</td>
                    <td>${gasto['monto']}</td>
                    <td>${gasto['fecha']}</td>
                    <td style="width: 200px;">
                        <a href="#" onclick="" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                        <form action="<!-- aqui va el id -->" method="post">
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
        <a href="GastosController?page=${i}&pageSize=10">${i}</a>
    </c:forEach>

<jsp:include page="includes/footer.jsp" />
