<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ADMIN PAGE</title>
        <link rel="apple-touch-icon" sizes="76x76" href="/Shop/static/admin/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="/Shop/static/admin/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <link href="/Shop/static/admin/css/bootstrap.min.css" rel="stylesheet" />
        <link href="/Shop/static/admin/css/animate.min.css" rel="stylesheet"/>
        <link href="/Shop/static/admin/css/paper-dashboard.css" rel="stylesheet"/>
        <link href="/Shop/static/admin/css/demo.css" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="/Shop/static/admin/css/themify-icons.css" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-background-color="black" data-active-color="danger">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="/Shop/admin" class="simple-text">
                            Camera Shop 
                        </a>
                    </div>

                    <ul class="nav">
                        <li>
                            <a href="/Shop/admin">
                                <i class="ti-panel"></i>
                                <p>Dashboard</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Shop/admin/user/list">
                                <i class="ti-user"></i>
                                <p>User Profile</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Shop/admin/product/list">
                                <i class="ti-view-list-alt"></i>
                                <p>Table Product</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Shop/admin/cart-item/list">
                                <i class="ti-view-list-alt"></i>
                                <p>Cart Items</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Shop/admin/order/list">
                                <i class="ti-bell"></i>
                                <p>Table Order</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Shop/admin/category/list">
                                <i class="ti-align-center"></i>
                                <p>Category</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar bar1"></span>
                                <span class="icon-bar bar2"></span>
                                <span class="icon-bar bar3"></span>
                            </button>
                            <a class="navbar-brand" href="/Shop/admin">Dashboard</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                  
                                <li>
                                    <a href="/Shop/login">
                                        <i class="ti-arrow-right"></i>
                                        <p>Log Out</p>
                                    </a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </body>
    <script src="/Shop/static/admin/js/jquery.min.js" type="text/javascript"></script>
    <script src="/Shop/static/admin/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/Shop/static/admin/js/bootstrap-checkbox-radio.js"></script>
    <script src="/Shop/static/admin/js/chartist.min.js"></script>
    <script src="/Shop/static/admin/js/bootstrap-notify.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="/Shop/static/admin/js/paper-dashboard.js"></script>
    <script src="/Shop/static/admin/js/demo.js"></script>

</html>