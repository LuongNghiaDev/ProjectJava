<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/layouts/taglib.jsp" %>
<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<c:url var="billAPI" value="/api/addBill"/>
<c:url var="checkoutURL" value="/gio-hang"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
</head>
<body>

<div id="sidebar" class="span3">
    <div class="well well-small">
        <ul class="nav nav-list">

            <nav class="category">
                <h3 class="category__heading">
                    <i class="category__heading-icon fas fa-list-ul"></i>
                    Danh mục
                </h3>

                <ul class="category-list">
                    <li class="category-item category-item--active">
                        <a href="#" class="category-item__link">Đánh giá</a>
                    </li>

                    <li class="category-item category-item--active">
                        <a href="#" class="category-item__link">Liên hệ</a>
                    </li>

                    <li class="category-item category-item--active">
                        <a href="#" class="category-item__link">Trợ giúp</a>
                    </li>

                    <li class="category-item">
                        <a href="#" class="category-item__link">Tổng tiền
                            <span class="badge badge-warning pull-right" tyle="line-height: 18px;">
                                <fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart }"/>₫</span></a>
                    </li>
                </ul>
            </nav>
        </ul>
    </div>

    <div class="well well-small alert alert-warning cntr">
        <h2>50% Discount</h2>
        <p>
            only valid for online order. <br> <br> <a
                class="defaultBtn" href="#">Click here </a>
        </p>
    </div>
    <div class="well well-small">
        <a href="#"><img src="<c:url value="/assets/user/img/paypal.jpg" />"
                         alt="payment method paypal"></a>
    </div>

    <a class="shopBtn btn-block" href="#">Upcoming products <br>
        <small>Click to view</small>
    </a> <br> <br>

</div>

<div class="span9">
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
                ${message}
        </div>
    </c:if>
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
        <li class="active">Thanh toán</li>
    </ul>

    <div class="well">
        <security:authorize access = "isAuthenticated()">
        <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="bill">
            <h1>Thanh toán</h1>
            <div class="col-sm-9">
                <form:input path="userName" cssClass="col-xs-10 col-sm-5" placeholder="UserName"/>
            </div>
            <br>
            <div class="col-sm-9">
                <form:input path="fullName" cssClass="col-xs-10 col-sm-5" placeholder="FullName"/>
            </div>
            <br>
            <div class="col-sm-9">
                <form:input path="phone" cssClass="col-xs-10 col-sm-5" placeholder="Phone"/>
            </div>
            <br>
            <div class="col-sm-9">
                <form:input path="address" cssClass="col-xs-10 col-sm-5" placeholder="Address"/>
            </div>
            <br>
            <div class="col-sm-9">
                <form:textarea path="note" rows="5" cols="10" cssClass="form-control" id="note"/>
            </div>
            <br>
            <button class="btn btn-info" type="button" id="btnAddBill">
                <i class="ace-icon fa fa-check bigger-110"></i>
                Thanh toán
            </button>
        </form:form>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <p>
                Đăng nhập trước khi thanh toán <br> <br> <a
                    class="defaultBtn" href="<c:url value="/dang-nhap" /> ">Đăng nhập </a>
            </p>
        </security:authorize>
    </div>
</div>
<script>
    $('#btnAddBill').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        addBill(data);
    });

    function addBill(data) {
        $.ajax({
            url: '${billAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${checkoutURL}?message=insert_success";
            },
            error: function (error) {
                window.location.href = "${checkoutURL}?message=error_system";
            }
        });
    }
</script>
</body>
</html>
