<%@ include file="header.jsp" %>
<div class="page-main">
    <div class="jumbotron">
        <div class="container">
            <h1><s:message code="header.main.heading"/></h1>

            <p>This is a template for a simple marketing or informational website. It includes a large callout called a
                jumbotron and three supporting pieces of content. Use it as a starting point to create something more
                unique.</p>

            <p><a class="btn btn-primary btn-lg" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12">
                <form method="post" role="form" action="<c:url value="/booking/search" />">
                    <div class="form-group">
                        <label for="searchCityFrom">From</label>
                        <select name="fromCityId" class="form-control" id="searchCityFrom"></select>
                    </div>
                    <div class="form-group">
                        <label for="searchCityTo">To</label>
                        <select name="toCityId" class="form-control" id="searchCityTo"></select>
                    </div>
                    <div class="form-group">
                        <label for="searchDate">Date</label>
                        <input name="departureDateStr" class="form-control" type="text" id="searchDate">
                    </div>
                    <div class="form-group">
                        <label for="searchNoOfPax">Number Of Passengers</label>
                        <input name="noOfPassengers" class="form-control" type="text" id="searchNoOfPax">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
            </div>
            <div class="col-md-8  col-sm-12 banner">

            </div>
        </div>
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>Heading</h2>

                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>

                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>

                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris
                    condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                    euismod. Donec sed odio dui. </p>

                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>

                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                    porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                    ut
                    fermentum massa justo sit amet risus.</p>

                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>


    </div>
</div>
<script src="<c:url value="/js/homepage.js" />"></script>
</body>
</html>