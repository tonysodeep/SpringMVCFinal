<%-- 
    Document   : index
    Created on : Mar 31, 2022, 2:19:46 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!-- CDN -->
        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <!-- CSS -->
        <link rel="stylesheet"  href="<c:url value="/css/style.css"/>"/>
    </head>
    <body>
        <header>
            <div id="carouselSlidesOnly" class="carousel slide" data-bs-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<c:url value="/img/img1.jpg"/>" class="d-block w-100 h-100" alt="slide 1">
                </div>
                <div class="carousel-item">
                  <img src="<c:url value="/img/img2.jpg"/>" class="d-block w-100 h-100" alt="slide 2">
                </div>
                <div class="carousel-item">
                  <img src="<c:url value="/img/img3.jpg"/>" class="d-block w-100 h-100" alt="slide 3">
                </div>
              </div>
            </div>

            <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-warning">
              <div class="container-fluid">
                <a class="navbar-brand" href="#carouselSlidesOnly">Private Clinit managment system</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>        
                  <div class="d-flex">
                    <div class="collapse navbar-collapse" id="navbarNav">
                      <ul class="navbar-nav">
                          <li class="nav-item padd-15">
                              <a class="nav-link active" aria-current="page" href="#About"><i class="fas fa-briefcase-medical"></i> About us</a>
                          </li>
                          <li class="nav-item padd-15">
                              <a class="nav-link" href="#Contact"><i class="fas fa-phone-alt"></i> Contact</a>
                          </li>
                          <li class="nav-item padd-15">
                              <a class="nav-link" href="<c:url value="/login"/>"><i class="fas fa-user"></i> Login</a>
                          </li>
                      </ul>
                    </div>
                  </div>
              </div>
            </nav>
          </header>

          <div class="content">
            <div class="container-fluid">
              <h1>Start thinking wellness not illness</h1>
              <div class="card-group">
                <div class="card text-dark bg-warning shadow-dark">
                  <img src="<c:url value="/img/doctor.jpg"/>" class="card-img-top" alt="doctor.jpg">
                  <div class="card-body">
                    <h5 class="card-title">Our Doctors</h5>
                    <p class="card-text">The job of a doctor is to diagnose and treat illness and injury</p>
                  </div>
                </div>
                <div class="card text-dark bg-warning shadow-dark">
                  <img src="<c:url value="/img/nurse.jpg"/>" class="card-img-top" alt="nurse.jpg">
                  <div class="card-body">
                    <h5 class="card-title">Our Nurses</h5>
                    <p class="card-text">The job of a doctor is to diagnose and treat illness and injury</p>
                  </div>
                </div>
                <div class="card text-dark bg-warning shadow-dark">
                  <img src="<c:url value="/img/medicine.jpg"/>" class="card-img-top" alt="medicine.jpg">
                  <div class="card-body">
                    <h5 class="card-title">Our Medicines</h5>
                    <p class="card-text">The job of a doctor is to diagnose and treat illness and injury</p>
                  </div>
                </div>
              </div>
            </div>

            <div class="about" id="About">
              <div class="container">
                <h1>ABOUT US</h1>
                <div class="d-flex align-item-center justify-content-center">
                  <div class="card mb-3 w-75 text-warning shadow-dark">
                    <div class="row g-0">
                      <div class="col-5">
                        <img src="<c:url value="/img/user1.png"/>" class="img-fluid" alt="">
                      </div>
                      <div class="col-7 padd-15">
                        <div class="card-body">
                          <h5 class="card-title">Nguyen Gia Hy</h5>
                          <p class="card-text"><b>1811063518 - 18DTHQA3</b><br>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Perferendis, vero aperiam? Modi officia, in accusamus quasi cupiditate dolorum qui suscipit, delectus error sequi, laborum voluptatem a odio assumenda beatae dolore?</p>
                          <p class="card-text"><small class="text-muted">Last updated 3 days ago</small></p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="d-flex align-item-center justify-content-center">
                  <div class="card mb-3 w-75 text-warning shadow-dark">
                    <div class="row g-0">
                      <div class="col-5">
                        <img src="<c:url value="/img/user.jpg"/>" class="img-fluid" alt="">
                      </div>
                      <div class="col-7 padd-15">
                        <div class="card-body">
                          <h5 class="card-title">Nguyen Thi Ha Xuan</h5>
                          <p class="card-text"><b>1811202936 - 18DTHQA3</b><br>Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque tenetur enim porro in ullam! Dolores totam perferendis eligendi ducimus libero. Recusandae minus aliquid atque sit modi? Temporibus aut molestiae accusantium.</p>
                          <p class="card-text"><small class="text-muted">Last updated 3 days ago</small></p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="d-flex align-item-center justify-content-center">
                  <div class="card mb-3 w-75 text-warning shadow-dark">
                    <div class="row g-0">
                      <div class="col-5">
                        <img src="<c:url value="/img/user2.jpg"/>" class="img-fluid" alt="">
                      </div>
                      <div class="col-7 padd-15">
                        <div class="card-body">
                          <h5 class="card-title">Duong Thanh Nhu</h5>
                          <p class="card-text"><b>1811061967 - 18DTHQA3</b><br>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil ducimus suscipit accusantium veniam earum minus alias dolorum, expedita iure asperiores corporis illum cum praesentium harum fuga eligendi quidem, nulla magnam!</p>
                          <p class="card-text"><small class="text-muted">Last updated 3 days ago</small></p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="contact shadow-dark" id="Contact">
              <div class="container">
                <h1>Contact With Us</h1>
                <div class="mb-3 padd-15">
                  <label for="inputFname" class="form-label">Fullname</label>
                  <input type="text" class="form-control border-warning" id="fullname" placeholder="Fullname" >
                </div>
                <div class="mb-3 padd-15">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="email" class="form-control border-warning" id="email" placeholder="Email" >
                </div>
                <div class="mb-3 padd-15">
                    <label for="inputPhone" class="form-label">Phone</label>
                    <input type="tel" class="form-control border-warning" id="telephone" placeholder="Phone number" >
                </div>
                <div class="mb-3 pb-3 padd-15">
                  <div class="row">
                    <div class="col-10">
                      <label for="inputAddress" class="form-label">Make a question for us</label>
                      <textarea class="form-control border-warning" id="address" rows="3" placeholder="Make a question ..."></textarea>
                    </div>
                    <div class="col-2">
                      <button type="button" name="Sign Up" id="btn-signup" class="btn btn-light">Send it</button>
                    </div>
                  </div>       
                </div>
              </div>
            </div>
          </div>

          <footer class="text-black bg-warning">
            <!-- Grid container -->
            <div class="container p-4 pb-0">
              <!-- Section: Social media -->
              <section class="mb-4 text-center">
                <!-- Facebook -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #3b5998;"
                  href="#!"
                  role="button">
                  <i class="fab fa-facebook-f"></i></a>

                <!-- Twitter -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #55acee;"
                  href="#!"
                  role="button">
                  <i class="fab fa-twitter"></i></a>

                <!-- Google -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #dd4b39;"
                  href="#!"
                  role="button">
                  <i class="fab fa-google"></i></a>

                <!-- Instagram -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #d52d8c;"
                  href="#!"
                  role="button">
                  <i class="fab fa-instagram"></i></a>

                <!-- Linkedin -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #0082ca;"
                  href="#!"
                  role="button">
                  <i class="fab fa-linkedin-in"></i></a>
                <!-- Github -->
                <a class="btn btn-primary btn-floating m-1"
                  style="background-color: #333333;"
                  href="#!"
                  role="button">
                  <i class="fab fa-github"></i></a>
              </section>
              <!-- Section: Social media -->

              <!--Grid row-->
              <div class="row">
                <!--Grid column-->
                <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                  <h5 class="text-uppercase">Footer text</h5>
                  <p>
                    Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste atque ea quis
                    molestias. Fugiat pariatur maxime quis culpa corporis vitae repudiandae
                    aliquam voluptatem veniam, est atque cumque eum delectus sint!
                  </p>
                </div>
                <!--Grid column-->

                <!--Grid column-->
              <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled mb-0">          
                  <li>
                    <a href="#navbarNav" class="text-dark"><i class="fas fa-home"></i> Home</a>
                  </li>
                  <li>
                    <a href="login.html" class="text-dark"><i class="far fa-user-circle"></i> Login</a>
                  </li>          
                  <li>
                    <a href="signup.html" class="text-dark"><i class="fas fa-user-circle"></i> Signup</a>
                  </li>
                  <li>
                    <a href="#!" class="text-dark">Link 4</a>
                  </li>
                </ul>
              </div>
              <!--Grid column-->

              <!--Grid column-->
              <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#About" class="text-dark"><i class="fas fa-book"></i> ABOUT US</a>
                  </li>
                  <li>
                    <a href="#Contact" class="text-dark"><i class="fas fa-comment"></i> CONTACT US</a>
                  </li>
                  <li>
                    <a href="#!" class="text-dark">Link 3</a>
                  </li>
                  <li>
                    <a href="#!" class="text-dark">Link 4</a>
                  </li>
                </ul>
              </div>
              <!--Grid column-->
              </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
              © 2022 Copyright:
              <a class="text-black" href="https://github.com/tonysodeep/SpringMVCFinal">Hy - Nhu - Xuan</a>
            </div>
            <!-- Copyright -->
          </footer>
    </body>
</html>
