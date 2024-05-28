<%-- 
    Document   : config
    Created on : 14 may. 2024, 18:43:03
    Author     : Jaco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />

<div class="row">
    <div class="col-md-6 mx-auto">
        <div class="card">
            <div class="card-header card-header-info">
                <h4 class="card-title">Datos de la Empresa</h4>
            </div>
            <div class="card-body">
                <!-- alertas aqui -->
                <form action="" method="post" class="p-3">
                    <div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" name="nombre" class="form-control" value="Bella Cosmetica" id="txtNombre" placeholder="Nombre de la Empresa" required class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Teléfono:</label>
                        <input type="number" name="telefono" class="form-control" value="09999999999" id="txtTelEmpresa" placeholder="teléfono de la Empresa" required>
                    </div>
                    <div class="form-group">
                        <label>Correo Electrónico:</label>
                        <input type="email" name="email" class="form-control" value="bella@gmail.com" id="txtEmailEmpresa" placeholder="Correo de la Empresa" required>
                    </div>
                    <div class="form-group">
                        <label>Dirección:</label>
                        <input type="text" name="direccion" class="form-control" value="I just Dont know" id="txtDirEmpresa" placeholder="Dirreción de la Empresa" required>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-info"><i class="fas fa-save"></i> Modificar Datos</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp" />