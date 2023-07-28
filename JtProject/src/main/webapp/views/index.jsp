<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BestFood</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <style>

        body {
            font-family: 'Roboto', sans-serif;
            background-color: #F8F9FA;
        }

        .bg-image-wrapper {
            background-image: url('https://img.freepik.com/free-photo/healthy-vegetables-wooden-table_1150-38014.jpg?w=1800&t=st=1690523378~exp=1690523978~hmac=c624907a88be9174dc918887e3d497ad40bd6a9a7f202ab738a9a9c34c0d73e3'); /* Set the background image */
            background-size: cover; /* Adjust the background size to cover the entire container */
            background-repeat: no-repeat; /* Prevent the background from repeating */
            background-position: center top; /* Center the background image at the top */
        }

        .navbar {
            background-color: transparent;
            font-weight: 500;
            font-size: 17px;
        }

        .navbar-brand {
            font-family: 'Pacifico', cursive;
            font-size: 28px;
            color: #fff;
        }

        .navbar-brand:hover {
            font-family: 'Pacifico', cursive;
            font-size: 28px;
            color: #e74c3c;
        }

        .navbar-nav .nav-link {
            color: #fff;
            transition: 0.5s ease;
        }

        .navbar-nav .nav-link:hover {
            color: #e74c3c;
            font-weight: bold;
        }

        .hero-section {
            text-align: center;
            padding: 120px 0;
        }

        .hero-text {
            font-size: 36px;
            font-weight: bold;
            margin-bottom: 20px;
            color: white;
        }

        .hero-subtext {
            font-size: 20px;
            margin-bottom: 30px;
            color: white;
        }


        .search-section {
            background-color: #fff;
            padding: 40px 0;
        }

        .search-box {
            max-width: 500px;
            margin: 0 auto;
            text-align: center;
        }

        .search-input {
            width: 100%;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 30px;
            font-size: 16px;
            outline: none;
        }

        .search-btn {
            background-color: #e74c3c;
            color: #fff;
            border: none;
            border-radius: 30px;
            padding: 15px 30px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        .search-btn:hover {
            color: white;
            text-decoration: none;
            background-color: #D91E18;
        }

        .restaurant-section {
            padding: 40px 0;
        }

        .restaurant-item {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 30px;
            text-align: center;
        }

        .restaurant-item img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
        }

        .restaurant-item h4 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .restaurant-item p {
            font-size: 16px;
            color: #555;
        }

        .footer {
            background-color: #292929;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-family: 'Segoe UI', sans-serif;
            font-size: 14px;
        }

        .footer a {
            color: #fff;
            font-weight: bold;
            text-decoration: none;
            margin: 5px;
        }

        .footer a:hover {
            color: #e74c3c;
        }

    </style>
</head>
<body>
<div class="bg-image-wrapper">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="/index">
                BestFood
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/shop">Shop</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profileDisplay">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <section class="hero-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="hero-text">Food Ecommerce Simplified</h1>
                    <p class="hero-subtext">Discover a bounty of fresh fruits and vegetables, premium meats, flavorful seasonings, and more.</p>
                    <div class="search-box">
                        <input type="text" class="search-input" placeholder="Search products..." id="searchInput">
                        <div class="search-results" id="searchResults"></div> <br> <br>
                        <a class="search-btn" href="#" id="findProductBtn">Find product</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<section class="search-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">

            </div>
        </div>
    </div>
</section>

<section class="restaurant-section">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="restaurant-item">
                    <img src="" alt="Restaurant 1">
                    <h4>Restaurant 1</h4>
                    <p>Address of Restaurant 1</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="restaurant-item">
                    <img src="" alt="Restaurant 2">
                    <h4>Restaurant 2</h4>
                    <p>Address of Restaurant 2</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="restaurant-item">
                    <img src="" alt="Restaurant 3">
                    <h4>Restaurant 3</h4>
                    <p>Address of Restaurant 3</p>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="footer">
    <p>&copy; 2023 BestFood</p>
    <div>
        <a href="/contact">Contact Us</a>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>
