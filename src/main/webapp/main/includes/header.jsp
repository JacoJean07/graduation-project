<%-- Document : footer Created on : 14 may. 2024, 13:51:02 Author : Jaco --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <title>Panel de Administración</title>
      <!-- bootstrap 5.3 -->
      <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous" />
      <link href="./assets/css/material-dashboard.css" rel="stylesheet" />
      <link href="./assets/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
      <link rel="stylesheet" href="./assets/js/jquery-ui/jquery-ui.min.css">
      <script src="./assets/js/all.min.js" crossorigin="anonymous"></script>

      <style>
        /* Estilos CSS para mejorar la apariencia */
        .card {
          margin: 0 auto;
          padding: 20px;
        }

        .form-group {
          margin-bottom: 20px;
        }

        label {
          font-weight: bold;
        }
      </style>
    </head>

    <body>
      <div class="wrapper ">F
        <div class="sidebar" data-color="purple" data-background-color="blue" data-image="../assets/img/.jpg">
          <div class="logo bg-dark"><a href="./" class="simple-text logo-normal">
              Bella Cosmetica
            </a></div>
          <div class="sidebar-wrapper">
            <form action="../VistasController" method="POST">
              <ul class="nav text-center flex-column d-flex flex-fill">
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="usuarios">
                  <i class="fas fa-user mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="config">
                  <i class="fas fa-cogs mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="categoria">
                  <i class=" fas fa-layer-group mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="productos">
                  <i class="fab fa-product-hunt mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="clientes">
                  <i class=" fas fa-users mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="ventas">
                  <i class="fas fa-cash-register mr-2 fa-2x"></i>
                  </input>
                </li>
                <li class="nav-item d-flex flex-fill">
                  <input type="submit" name="vista" class="nav-link btn" value="lista_ventas">
                  <i class="fas fa-cart-plus mr-2 fa-2x"></i>
                  </input>
                </li>
              </ul>
            </form>
          </div>
        </div>
        <div class="main-panel">
          <!-- Navbar -->
          <nav class="navbar navbar-expand-lg navbar-absolute fixed-top bg-dark">
            <div class="container-fluid">
              <div class="navbar-wrapper">
                <a class="navbar-brand" href="javascript:;"> </a>
              </div>
              <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
              </button>
              <div class="collapse navbar-collapse justify-content-end">

                <ul class="navbar-nav">
                  <li class="nav-item dropdown">
                    <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown"
                      aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-user"></i>
                      <p class="d-lg-none d-md-block">
                        Cuenta
                      </p>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                      <a class="dropdown-item" href="#">Perfil</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="/graduation-project/LogOut">Cerrar Sesión</a>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <!-- End Navbar -->
          <div class="content bg">
            <div class="container-fluid">