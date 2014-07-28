<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html data-ng-app="proavosBookingApp" id="ng-app">
<head>
    <title>Welcome to the Online Ticketing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">

    <!-- Optional theme -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css" />">

    <%-- custom styles --%>
    <link rel="stylesheet" href="<c:url value="/css/datepicker.css" />">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-touchspin.css" />">
    <link rel="stylesheet" href="<c:url value="/css/main.css" />">

    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/js/jquery/jquery-2.1.1.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-datepicker.js" />"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-touchspin.js" />"></script>

    <%-- utility libs --%>
    <script src="<c:url value="/js/util/moment.js" />"></script>
    <script src="<c:url value="/js/util/underscore.js" />"></script>
    <script src="<c:url value="/js/util/proavos.common.js" />"></script>

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
                <li><a href="#"><s:message code="menu.home"/></a></li>
                <li><a href="#"><s:message code="menu.service.route"/></a></li>
                <li><a href="#"><s:message code="menu.deal.discount"/></a></li>
                <li><a href="#"><s:message code="menu.ticket.travel"/></a></li>
                <li><a href="#"><s:message code="menu.contact.us"/></a></li>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.language != 'si'}">
                    <li><a href="<c:url value="/si/home" />"><img
                            src="<c:url value="/images/sinhala.png" />"></a></li>
                </c:if>
                <c:if test="${sessionScope.language == 'si'}">
                    <li><a href="<c:url value="/en/home" />"><img
                            src="<c:url value="/images/english.png" />"></a></li>
                </c:if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>