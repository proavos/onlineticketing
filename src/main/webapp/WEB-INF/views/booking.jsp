<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 form-group">
            <h2>Book!</h2>
        </div>
    </div>
    <div id="frmBooking">
        <div class="book-form" class="book-form">
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>From</label></div>
                    <div class="col-lg-3">
                        <label>${bus.fromCity}</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>To</label></div>
                    <div class="col-lg-3">
                        <label>${bus.toCity}</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Departure Date</label></div>
                    <div class="col-lg-3">
                        <label><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${bus.departureDateTime}"/></label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Arrival Date</label></div>
                    <div class="col-lg-3">
                        <label><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${bus.arrivalDateTime}"/></label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="alert alert-danger hidden" id="errorMessage" role="alert">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Contact Person Name</label></div>
                    <div class="col-lg-3">
                        <input class="form-control" type="hidden" id="txtNoOfPassengers" value="${noOfPax}"/>
                        <input class="form-control" type="hidden" id="txtBusId" value="${busId}"/>
                        <input class="form-control" type="hidden" id="txtPrice" value="${price}"/>
                        <input class="form-control" type="text" id="txtContactName" required/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Contact Person Telephone</label></div>
                    <div class="col-lg-3"><input class="form-control" type="text" id="txtContactPhone" required/></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Payment Option</label></div>
                    <div class="col-lg-3">
                        <select class="form-control" id="sltPaymentOption" required>
                            <option value="PAYNOW">Pay Now</option>
                            <option value="PAYLATER">Pay Later</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row paynow">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Card Holder Name</label></div>
                    <div class="col-lg-3">
                        <input class="form-control" type="text" id="txtCardHolderName"/>
                    </div>
                </div>
            </div>
            <div class="row paynow">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Card Number</label></div>
                    <div class="col-lg-3">
                        <input class="form-control" type="text" id="txtCardNumber"/>
                    </div>
                </div>
            </div>
            <div class="row paynow">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>Expiry Date (MM/YYYY)</label></div>
                    <div class="col-lg-3">
                        <input class="form-control" type="text" id="txtExpDate"/>
                    </div>
                </div>
            </div>
            <div class="row paynow">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3"><label>CVV</label></div>
                    <div class="col-lg-3">
                        <input class="form-control" type="text" id="txtCVV"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 form-group">
                    <div class="col-lg-3">
                        <button id="btnBook" type="submit" class="btn btn-default">Book</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="book-summary hidden">
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>PNR</label></div>
                <div class="col-lg-3">
                    <label id="lblPNR"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>From</label></div>
                <div class="col-lg-3">
                    <label id="lblFrom"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>To</label></div>
                <div class="col-lg-3">
                    <label id="lblTo"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Departure Date</label></div>
                <div class="col-lg-3">
                    <label id="lblDepartureDate"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Arrival Date</label></div>
                <div class="col-lg-3">
                    <label id="lblArrivalDate"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Booked Date</label></div>
                <div class="col-lg-3">
                    <label id="lblBookedDateTime"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>No Of Passengers</label></div>
                <div class="col-lg-3">
                    <label id="lblNoOfPax"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Total Price</label></div>
                <div class="col-lg-3">
                    <label id="lblTotalPrice"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Contact Person</label></div>
                <div class="col-lg-3">
                    <label id="lblContactPerson"></label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 form-group">
                <div class="col-lg-3"><label>Contact Number</label></div>
                <div class="col-lg-3">
                    <label id="lblContactPhone"></label>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="<c:url value="/js/booking.js" />"></script>
</body>
</html>
