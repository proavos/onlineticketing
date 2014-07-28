<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <h2>Available Bus</h2>
    </div>
    <c:if test="${fn:length(result.availableBusList) gt 0}">
        <div class="row">
            <div class="col-xs-12">
                <table class="table table-responsive table-striped">
                    <tr>
                        <th>From</th>
                        <th>To</th>
                        <th>Route Code</th>
                        <th>Departure Date</th>
                        <th>Arrival Date</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${result.availableBusList}" var="row">
                        <tr>
                            <th><c:out value="${row.fromCity}"/> <br/></th>
                            <th><c:out value="${row.toCity}"/> <br/></th>
                            <th><c:out value="${row.routeCode}"/> <br/></th>
                            <th>
                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${row.departureDateTime}"/>
                            </th>
                            <th>
                                <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${row.arrivalDateTime}"/>
                            </th>
                            <th><c:out value="${row.perPassengerPrice}"/> <br/></th>
                            <th>

                                <c:if test="${row.available == true}">
                                    <form method="post" role="form" action="<c:url value="/booking/load" />">
                                        <input class="form-control" type="hidden" name="busId" value="${row.busId}"/>
                                        <input class="form-control" type="hidden" name="price" value="${row.perPassengerPrice}"/>
                                        <input class="form-control" type="hidden" name="noOfPax"
                                               value="${result.noOfPassengers}"/>

                                        <button type="submit" class="btn btn-default">Book Now!</button>
                                    </form>
                                </c:if>
                                <c:if test="${row.available == false}">
                                    <p>No seats available</p>
                                </c:if>

                            </th>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </c:if>
    <c:if test="${fn:length(result.availableBusList) eq 0}">
        <div class="row">
            <div class="alert alert-warning" role="alert">
                <strong>No Results found!</strong> Please check for another date.
            </div>
        </div>
    </c:if>

</div>