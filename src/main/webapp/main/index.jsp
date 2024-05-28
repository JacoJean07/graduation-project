<%-- 
    Document   : sidebar
    Created on : 13 may. 2024, 16:18:26
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />

<div class="row">
    <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats bg-success">
            <div class="card-header card-header-success card-header-icon">
                <div class="card-icon">
                    <i class="fas fa-user fa-2x"></i>
                </div>
                <a href="usuarios.jsp" class="card-category text-white font-weight-bold">
                    Usuarios
                </a>
                <h3 class="card-title"># Trabajadires</h3>
            </div>
            <div class="card-footer text-white">
            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats bg-info">
            <div class="card-header card-header-info card-header-icon">
                <div class="card-icon">
                    <i class="fas fa-users fa-2x"></i>
                </div>
                <a href="clientes.jsp" class="card-category text-white font-weight-bold">
                    Clientes
                </a>
                <h3 class="card-title"># Clientes</h3>
            </div>
            <div class="card-footer text-white">
            </div>
        </div>
    </div>
    <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats bg-warning">
            <div class="card-header card-header-warning card-header-icon">
                <div class="card-icon">
                    <i class="fab fa-product-hunt fa-2x"></i>
                </div>
                <a href="productos.jsp" class="card-category text-white font-weight-bold">
                    Productos
                </a>
                <h3 class="card-title"># Productos</h3>
            </div>
            <div class="card-footer">
            </div>
        </div>
    </div>
    <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats bg-secondary">
            <div class="card-header card-header-secondary card-header-icon">
                <div class="card-icon">
                    <i class="fas fa-cash-register fa-2x"></i>
                </div>
                <a href="ventas.jsp" class="card-category text-white font-weight-bold">
                    Ventas
                </a>
                <h3 class="card-title"># Ventas</h3>
            </div>
            <div class="card-footer text-white">
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Productos Vencidos
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-danger table-bordered" id="tbl">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Código</th>
                            <th>Producto</th>
                            <th>Tipo</th>
                            <th>Presentacion</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <form action="eliminar_producto.jsp?id=" method="post" >
                                    <button class="btn btn-danger" type="submit"><i class='fas fa-trash-alt'></i> </button>
                                </form>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header card-header-info">
                <h3 class="title-2 m-b-40">Productos con stock mínimo</h3>
            </div>
            <div class="card-body">
                <canvas id="stockMinimo"></canvas>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header card-header-info">
                <h3 class="title-2 m-b-40">Productos más vendidos</h3>
            </div>
            <div class="card-body">
                <canvas id="ProductosVendidos"></canvas>
            </div>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />
