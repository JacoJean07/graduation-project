<%-- Document : productos Created on : 3 jun. 2024, 15:57:19 Author : Jaco --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <jsp:include page="includes/header.jsp" />

            <div class="card shadow-lg">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card shadow-lg">
                                <div class="card-header bg-primary text-white">
                                    Productos
                                </div>
                                <div class="card-body">
                                    <form action="../ProductoController" method="post" autocomplete="off"
                                        id="formulario">
                                        <!-- aqui van las alertas -->
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label for="codigo" class=" text-dark font-weight-bold"><i
                                                            class="fas fa-barcode"></i>Código</label>
                                                    <input type="text" placeholder="Ingrese código de barras"
                                                        name="codigo" id="codigo" class="form-control"
                                                        value="${row != null ? row.codigo : ''}">
                                                    <input type="hidden" id="id" name="id"
                                                        value="${row != null ? row.id : ''}">
                                                </div>
                                            </div>
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label for="producto"
                                                        class=" text-dark font-weight-bold">Producto</label>
                                                    <input type="text" placeholder="Ingrese nombre del producto"
                                                        name="producto" id="producto" class="form-control"
                                                        value="${row != null ? row.descripcion : ''}">
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    <label for="precioEntrada"
                                                        class="text-dark font-weight-bold">PrecioEntrada</label>
                                                    <input type="text" placeholder="Ingrese precio" class="form-control"
                                                        name="precioEntrada" id="precioEntrada"
                                                        value="${row != null ? row.precioEntrada : ''}">
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    <label for="precio"
                                                        class="text-dark font-weight-bold">Precio</label>
                                                    <input type="text" placeholder="Ingrese precio" class="form-control"
                                                        name="precioSalida" id="precioSalida"
                                                        value="${row != null ? row.precioSalida : ''}">
                                                </div>
                                            </div>

                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    <label for="cantidad"
                                                        class=" text-dark font-weight-bold">Cantidad</label>
                                                    <input type="number" placeholder="Ingrese cantidad"
                                                        class="form-control" name="existencia" id="existencia"
                                                        value="${row != null ? row.existencia : ''}">
                                                </div>
                                            </div>
                                             
                                            <div class="col-md-6">
                                                <input type="submit" class="btn btn-info" id="btnAccion"
                                                    value="${row != null ? 'Modificar' : 'Registrar'}">
                                                <input type="button" value="Nuevo" onclick="limpiar()"
                                                    class="btn btn-success" id="btnNuevo">
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" id="tbl">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Código</th>
                                        <th>Producto</th>
                                        <th>Precio entrada</th>
                                        <th>Precio salida</th>
                                        <th>Stock</th>
                                        <th>Categoria</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- recibir datos de la tabla -->
                                    <c:forEach var="producto" items="${sessionScope.data}">
                                        <tr>
                                            <td>${producto['id']}</td>
                                            <td>${producto['codigo']}</td>
                                            <td>${producto['descripcion']}</td>
                                            <td>${producto['precioEntrada']}</td>
                                            <td>${producto['precioSalida']}</td>
                                            <td>${producto['existencia']}</td>
                                            <td>${producto['id_categoria']}</td>

                                            <td>
                                                <a href="../VistasController?vista=producto&id=${producto['id']}"
                                                    onclick="" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                                <form action="../ProductoController" method="post">
                                                    <input type="hidden" name="id" id="id" value="${producto['id']}">
                                                    <input type="hidden" name="action" id="action" value="delete">
                                                    <button class="btn btn-danger" type="submit"
                                                        onclick="return confirm('¿Seguro que desea eliminar este producto?');"><i
                                                            class='fas fa-trash-alt'></i> </button>
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

            <jsp:include page="includes/footer.jsp" />