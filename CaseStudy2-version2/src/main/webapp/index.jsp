<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 6/30/22
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Yeucau1</title>
    <style>
        * {
            box-sizing: border-box;
        }

        .col-1 {
            width: 8.33%;
        }

        .col-2 {
            width: 16.66%;
        }

        .col-3 {
            width: 25%;
        }

        .col-4 {
            width: 33.33%;
        }

        .col-5 {
            width: 41.66%;
        }

        .col-6 {
            width: 50%;
        }

        .col-7 {
            width: 58.33%;
        }

        .col-8 {
            width: 66.66%;
        }

        .col-9 {
            width: 75%;
        }

        .col-10 {
            width: 83.33%;
        }

        .col-11 {
            width: 91.66%;
        }

        .col-12 {
            width: 100%;
        }
    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row border border-dark">
        <div class="col-12 ">
            <div class="col-12">
                <%--          <img src="anh/123.png" width="100%" height="300px" alt="">--%>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <div class="col-12 ">
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <%--            <a class="nav-item" href="/customer" style="text-decoration: none">Customer</a>--%>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <%--                        <a class="nav-link active" aria-current="page" href="/employee">Employee</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="#">Contract</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="/facility">Facility</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="/test">Test</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="/car">Car</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="/product">Product Management</a>--%>
                            </li>
                            <li class="nav-item">
                                <%--                        <a class="nav-link" href="/phongtro">Rent Management</a>--%>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/"> Management</a>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="row" style="margin-top: 20px">
        <div class="col-3 border border-dark " style="height: 600px">
            <div class="col-12">
                <img width="100%" height="300px"
                     src="data:image/jpeg;base64,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">
                <img width="100%" height="300px"
                     src="data:image/jpeg;base64,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">
                          <iframe width="100%" height="200" src="https://www.youtube.com/embed/mPM5VsVQ3hw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                          <iframe width="100%" height="200" src="https://www.youtube.com/embed/Vvhpm899Eb4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                          <iframe width="100%" height="200" src="https://www.youtube.com/embed/L5B05GaZsy4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
        <div class="col-9 border border-dark " style="height: 600px">
            <%--        <img src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg" width="100%" height="600px" alt="">--%>
            <img src="https://static.ybox.vn/2019/3/2/1552358411894-CodeGym.png" width="100%" height="600px">
        </div>
    </div>

    <div class="row">
        <div class="col-12 border border-dark ">
            <!-- Footer -->
            <footer class="text-center text-lg-start bg-light text-muted">
                <!-- Section: Social media -->
                <section
                        class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom"
                >
                    <!-- Left -->
                    <div class="me-5 d-none d-lg-block">
                        <span>Get connected with us on social networks:</span>
                    </div>
                    <!-- Left -->

                    <!-- Right -->
                    <div>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-linkedin"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-github"></i>
                        </a>
                    </div>
                    <!-- Right -->
                </section>
                <!-- Section: Social media -->

                <!-- Section: Links  -->
                <section class="">
                    <div class="container text-center text-md-start mt-5">
                        <!-- Grid row -->
                        <div class="row mt-3">
                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                                <!-- Content -->
                                <h6 class="text-uppercase fw-bold mb-4">
                                    <i class="fas fa-gem me-3"></i>CodeGym Da Nang
                                </h6>
                                <p>
                                    295 Nguyen Tat Thanh Street, Thanh Binh Ward, Hai Chau District, Danang City,
                                    Vietnam
                                    Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666
                                    Email: reservation@codegym.com * www.codegym.com
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold mb-4">
                                    Products
                                </h6>
                                <p>
                                    <a href="#!" class="text-reset">Angular</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">React</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Vue</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Laravel</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold mb-4">
                                    Useful links
                                </h6>
                                <p>
                                    <a href="#!" class="text-reset">Pricing</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Settings</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Orders</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Help</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold mb-4">
                                    Contact
                                </h6>
                                <p><i class="fas fa-home me-3"></i> 295 Nguyen Tat Thanh , Hai Chau, Da Nang</p>
                                <p>
                                    <i class="fas fa-envelope me-3"></i>
                                    info@example.com
                                </p>
                                <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                                <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                            </div>
                            <!-- Grid column -->
                        </div>
                        <!-- Grid row -->
                    </div>
                </section>
                <!-- Section: Links  -->

                <!-- Copyright -->
                <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
                    © 2021 Copyright:
                    <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
                </div>
                <!-- Copyright -->
            </footer>
            <!-- Footer -->
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
