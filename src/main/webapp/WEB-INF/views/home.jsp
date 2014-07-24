<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome to the Online Ticketing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">

    <!-- Optional theme -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css" />">

    <%-- custom styles --%>
    <link rel="stylesheet" href="<c:url value="/css/main.css" />">

    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/js/jquery-2.1.1.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>

</head>


<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Praovos</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-left">
                <li><a href="#">HOME</a></li>
                <li><a href="#">SERVICE & ROUTES</a></li>
                <li><a href="#">DEALS & DISCOUNTS</a></li>
                <li><a href="#">TICKET & TRAVEL INFO</a></li>
                <li><a href="#">CONTACT US</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div class="jumbotron">
    <div class="container">
        <h1>Fast Booking!</h1>

        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>

        <p><a class="btn btn-primary btn-lg" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-12">
            <form role="form">
                <div class="form-group">
                    <label for="searchCityFrom">From</label>
                    <select class="form-control" id="searchCityFrom"></select>
                </div>
                <div class="form-group">
                    <label for="searchCityTo">To</label>
                    <select class="form-control" id="searchCityTo"></select>
                </div>
                <div class="form-group">
                    <label for="searchDate">Date</label>
                    <input class="form-control" type="text" id="searchDate">
                </div>
                <div class="form-group">
                    <label for="searchNoOfPax">Number Of Passengers</label>
                    <input class="form-control" type="text" id="searchNoOfPax">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
        </div>
        <div class="col-md-8  col-sm-12">

        </div>
    </div>
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>


</body>
</html>