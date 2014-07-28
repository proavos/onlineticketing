<%@ include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 form-group">
            <h2>Book!</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Contact Person Name</label></div>
            <div class="col-lg-3">
                <input class="form-control" type="hidden" id="txtNoOfPassengers" value="${noOfPax}"/>
                <input class="form-control" type="hidden" id="txtBusId" value="${noOfPax}"/>
                <input class="form-control" type="hidden" id="txtPrice" value="${price}"/>
                <input class="form-control" type="text" id="txtContactName"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Contact Person Telephone</label></div>
            <div class="col-lg-3"><input class="form-control" type="text" id="txtContactPhone"/></div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Payment Option</label></div>
            <div class="col-lg-3">
                <select class="form-control" id="sltPaymentOption">
                    <option value="PAYNOW">Pay Now</option>
                    <option value="PAYLATER">Pay Later</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Card Holder Name</label></div>
            <div class="col-lg-3">
                <input class="form-control" type="text" id="txtCardHolderName"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Card Number</label></div>
            <div class="col-lg-3">
                <input class="form-control" type="text" id="txtCardNumber"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 form-group">
            <div class="col-lg-3"><label>Expiry Date (MM/YYYY)</label></div>
            <div class="col-lg-3">
                <input class="form-control" type="text" id="txtExpDate"/>
            </div>
        </div>
    </div>
    <div class="row">
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

<script src="<c:url value="/js/booking.js" />"></script>
</body>
</html>
