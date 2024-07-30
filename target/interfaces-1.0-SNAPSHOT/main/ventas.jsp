<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <jsp:include page="includes/header.jsp" />

        <div class="row">
            <div class="col-lg-12">
                <div class="form-group">
                    <h4 class="text-center">Datos del Cliente</h4>
                </div>
                <div class="card">
                    <div class="card-body">
                        <form action="../VentaController" method="post" autocomplete="off" id="formulario">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <input type="hidden" id="idcliente" value="1" name="idcliente" required>
                                        <label>Nombre</label>
                                        <select name="id_cliente" id="id_cliente" class="form-control" required>
                                            <option value="0">Seleccione un cliente</option>
                                            <c:forEach var="cliente" items="${sessionScope.data}">
                                                <option value="${cliente.id}">${cliente.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header bg-primary text-white text-center">
                        Buscar Productos
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="form-group">
                                    <label for="producto">Código o Nombre</label>
                                    <select name="id_producto" id="id_producto" class="form-control" required>
                                        <option value="0">Seleccione un producto</option>
                                        <c:forEach var="producto" items="${sessionScope.data2}">
                                            <option value="${producto.id}">${producto.codigo} - ${producto.descripcion}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="cantidad">Cantidad</label>
                                    <input id="cantidad" class="form-control" type="text" name="cantidad"
                                        placeholder="Cantidad" onkeyup="calcularPrecio(event)">
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="precio">Precio</label>
                                    <input id="precio" class="form-control" type="text" name="precio"
                                        placeholder="Precio" disabled>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="sub_total">Sub Total</label>
                                    <input id="sub_total" class="form-control" type="text" name="sub_total"
                                        placeholder="Sub Total" disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover" id="tblDetalle">
                        <thead class="thead-dark">
                            <tr>
                                <th>Id</th>
                                <th>Descripción</th>
                                <th>Cantidad</th>
                                <th>Aplicar</th>
                                <th>Desc</th>
                                <th>Precio</th>
                                <th>Precio Total</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody id="detalle_venta">
                        </tbody>
                        <tfoot>
                            <tr class="font-weight-bold">
                                <td>Total Pagar</td>
                                <td></td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div class="col-md-6">
                <a href="#" class="btn btn-success" id="btn_generar"><i class="fas fa-save"></i> Generar Venta</a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            // Convertir la variable data2 en un objeto JavaScript
            var data2 = <c:out value="${sessionScope.data2}" escapeXml="false" />;

            console.log('Data2:', data2); // Verificar la estructura de data2

            // Manejar el cambio en el select de productos
            $("#id_producto").change(function () {
                var id = $(this).val();
                var producto = data2.find(function (p) {
                    return p.id == id;
                });

                if (producto) {
                    $("#precio").val(producto.precioSalida); // Asegúrate de que el campo sea 'precioSalida'
                } else {
                    $("#precio").val('');
                }
            });

            // Calcular el subtotal
            function calcularPrecio(e) {
                e.preventDefault();
                const cantidad = parseFloat($("#cantidad").val()) || 0;
                const precio = parseFloat($("#precio").val()) || 0;
                $("#sub_total").val(cantidad * precio);
            }
        </script>

        <jsp:include page="includes/footer.jsp" />