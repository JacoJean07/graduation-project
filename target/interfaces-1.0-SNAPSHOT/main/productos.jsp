<%-- 
    Document   : productos
    Created on : 3 jun. 2024, 15:57:19
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <form action="" method="post" autocomplete="off" id="formulario">
                            <!-- aqui van las alertas -->
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="codigo" class=" text-dark font-weight-bold"><i class="fas fa-barcode"></i> Código de Barras</label>
                                        <input type="text" placeholder="Ingrese código de barras" name="codigo" id="codigo" class="form-control">
                                        <input type="hidden" id="id" name="id">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label for="producto" class=" text-dark font-weight-bold">Producto</label>
                                        <input type="text" placeholder="Ingrese nombre del producto" name="producto" id="producto" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label for="precioEntrada" class="text-dark font-weight-bold">PrecioEntrada</label>
                                        <input type="text" placeholder="Ingrese precio" class="form-control" name="precioEntrada" id="precioEntrada">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label for="precio" class="text-dark font-weight-bold">Precio</label>
                                        <input type="text" placeholder="Ingrese precio" class="form-control" name="precio" id="precio">
                                    </div>
                                </div>

                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label for="cantidad" class=" text-dark font-weight-bold">Cantidad</label>
                                        <input type="number" placeholder="Ingrese cantidad" class="form-control" name="cantidad" id="cantidad">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="laboratorio">Categoria</label>
                                        <select id="laboratorio" class="form-control" name="laboratorio" required>
                                            <!-- <?php
                                            $query_lab = mysqli_query($conexion, "SELECT * FROM laboratorios");
                                            while ($datos = mysqli_fetch_assoc($query_lab)) { ?>
                                                <option value="<?php echo $datos['id'] ?>"><?php echo $datos['laboratorio'] ?></option>
                                            <?php } ?> -->
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input id="accion" class="form-check-input" type="checkbox" name="accion" value="si">
                                        <label for="vencimiento">Vencimiento</label>
                                        <input id="vencimiento" class="form-control" type="date" name="vencimiento">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <input type="submit" value="Registrar" class="btn btn-info" id="btnAccion">
                                    <input type="button" value="Nuevo" onclick="limpiar()" class="btn btn-success" id="btnNuevo">
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
                            <th>Tipo</th>
                            <th>Presentacion</th>
                            <th>Precio entrada</th>
                            <th>Precio salida</th>
                            <th>Stock</th>
                            <th>Vendidos</th>
                            <th>Utilidad</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>123456789</td>
                            <td>Producto 1</td>
                            <td>Tipo 1</td>
                            <td>Presentacion 1</td>
                            <td>10.00</td>
                            <td>15.00</td>
                            <td>50</td>
                            <td>100</td>
                            <td>500.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(1)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=1" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>987654321</td>
                            <td>Producto 2</td>
                            <td>Tipo 2</td>
                            <td>Presentacion 2</td>
                            <td>20.00</td>
                            <td>25.00</td>
                            <td>30</td>
                            <td>50</td>
                            <td>250.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(2)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=2" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>123456789</td>
                            <td>Producto 3</td>
                            <td>Tipo 3</td>
                            <td>Presentacion 3</td>
                            <td>30.00</td>
                            <td>35.00</td>
                            <td>20</td>
                            <td>40</td>
                            <td>200.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(3)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=3" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>987654321</td>
                            <td>Producto 4</td>
                            <td>Tipo 4</td>
                            <td>Presentacion 4</td>
                            <td>40.00</td>
                            <td>45.00</td>
                            <td>10</td>
                            <td>30</td>
                            <td>150.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(4)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=4" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>123456789</td>
                            <td>Producto 5</td>
                            <td>Tipo 5</td>
                            <td>Presentacion 5</td>
                            <td>50.00</td>
                            <td>55.00</td>
                            <td>5</td>
                            <td>20</td>
                            <td>100.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(5)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=5" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>987654321</td>
                            <td>Producto 6</td>
                            <td>Tipo 6</td>
                            <td>Presentacion 6</td>
                            <td>60.00</td>
                            <td>65.00</td>
                            <td>0</td>
                            <td>10</td>
                            <td>50.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(6)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=6" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>123456789</td>
                            <td>Producto 7</td>
                            <td>Tipo 7</td>
                            <td>Presentacion 7</td>
                            <td>70.00</td>
                            <td>75.00</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(7)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=7" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>987654321</td>
                            <td>Producto 8</td>
                            <td>Tipo 8</td>
                            <td>Presentacion 8</td>
                            <td>80.00</td>
                            <td>85.00</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(8)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=8" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>123456789</td>
                            <td>Producto 9</td>
                            <td>Tipo 9</td>
                            <td>Presentacion 9</td>
                            <td>90.00</td>
                            <td>95.00</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(9)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=9" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>987654321</td>
                            <td>Producto 10</td>
                            <td>Tipo 10</td>
                            <td>Presentacion 10</td>
                            <td>100.00</td>
                            <td>105.00</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0.00</td>
                            <td>
                                <a href="#" onclick="editarProducto(10)" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                <form action="eliminar_producto.php?id=10" method="post" class="confirmar d-inline">
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />
