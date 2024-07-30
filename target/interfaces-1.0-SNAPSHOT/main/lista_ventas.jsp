<%-- 
    Document   : lista_ventas
    Created on : 14 may. 2024, 19:09:24
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/header.jsp" />

<div class="card">
    <div class="card-header">
        Historial ventas
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-light" id="tbl">
                <thead class="thead-dark">
                    <tr>
                        <th>#</th>
                        <th>Total</th>
                        <th>Fecha</th>
                        <th>Cliente</th>
                        <th>Vendedor</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="venta" items="${sessionScope.data}">
                        <tr>
                            <td>${venta['id']}</td>
                            <td>${venta['total']}</td> 
                            <td>${venta['fecha']}</td>
                            <td>${venta['id_cliente']}</td>
                            <td>${venta['id_usuario']}</td>
                            <td style="width: 200px;">
                                <a href="#" onclick="" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                            </td>
                            <td style="width: 200px;">
                                <form action="<!-- aqui va el id -->" method="post">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>



<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h2 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    Calcular Utilidad
                </button>
            </h2>
        </div>

        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
                <hr>

                <div class="row">
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Venta Diaria:</h4>
                                <p>Para el día </p>
                                <h4>aqui va la venta diaria</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Utilidad Diaria:</h4>
                                <h4>utilidad diaria</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Gastos Diarios:</h4>
                                <h4>gastos diarios</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Total Utilidad:</h4>
                                <h4>total</h4>
                            </div>
                        </div>
                    </div>
                </div>

                <hr>

                <div class="row">
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Venta de los últimos siete días:</h4>
                                <p>Desde dd/mm/aaaa hasta dd/mm/aaaa</p>
                                <h4>venta de los 7 ultimos dias</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Utilidad de los últimos siete días:</h4>
                                <h4>utilidad</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Gastos ultimos 7 Dias:</h4>
                                <h4>gastos</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Total Utilidad:</h4>
                                <h4>total</h4>
                            </div>
                        </div>
                    </div>
                </div>

                <hr>

                <div class="row">
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Venta del mes actual:</h4> 
                                <p>Para el mes actual</p>
                                <h4>venta de mes</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Utilidad del mes actual:</h4>
                                <h4>utilidad</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Gastos Mes:</h4>
                                <h4>gastos</h4>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card">
                            <div class="card-body">
                                <h4>Total Utilidad:</h4>
                                <h4>total</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>





<jsp:include page="includes/footer.jsp" />
