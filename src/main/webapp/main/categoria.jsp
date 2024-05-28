<%-- 
    Document   : categoria
    Created on : 14 may. 2024, 18:54:13
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />

<div class="card">
    <div class="card-body">
        <div class="row">
            <div class="col-md-12">
                <!-- aqui alertas -->
                <form action="" method="post" autocomplete="off" id="formulario">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="categoria" class="text-dark font-weight-bold">Categoria</label>
                                <input type="text" placeholder="Ingrese Categoria" name="categoria" id="categoria" class="form-control">
                                <input type="hidden" name="id" id="id">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="observaciones" class="text-dark font-weight-bold">Observaciones</label>
                                <input type="text" placeholder="Ingrese Observaciones" name="observaciones" id="observaciones" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-4 mt-4">
                            <input type="submit" value="Registrar" class="btn btn-info" id="btnAccion">
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
                                <th>Observaciones</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>id</td>
                                <td>categoria</td>
                                <td>direccion</td>
                                <td style="width: 200px;">
                                    <a href="#" onclick="" class="btn btn-primary"><i class='fas fa-edit'></i></a>
                                    <form action="<!-- aqui va el id -->" method="post">
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
</div>

<jsp:include page="includes/footer.jsp" />
