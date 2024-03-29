<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EDIT USER</title>
        <link rel="apple-touch-icon" sizes="76x76"
              href="/Shop/static/admin/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96"
              href="/Shop/static/admin/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta
            content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
            name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <link href="/Shop/static/admin/css/bootstrap.min.css" rel="stylesheet" />
        <link href="/Shop/static/admin/css/animate.min.css" rel="stylesheet" />
        <link href="/Shop/static/admin/css/paper-dashboard.css" rel="stylesheet" />
        <link href="/Shop/static/admin/css/demo.css" rel="stylesheet" />
        <link
            href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
            rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300'
              rel='stylesheet' type='text/css'>
        <link href="/Shop/static/admin/css/themify-icons.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../menuAdmin.jsp" />

        <div class="main-panel">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle">
                            <span class="sr-only">Toggle navigation</span> <span
                                class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
                            <span class="icon-bar bar3"></span>
                        </button>
                        <a class="navbar-brand" href="#">Edit User</a>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">						
                                <div class="content table-responsive table-full-width">
                                    <div>
                                        <div class="wrapper">
                                            <c:url value="/admin/user/edit" var="url"/>
                                            <form class="form-signin" action="${url}" method="post" enctype="multipart/form-data">
                                                <div>${msg}</div>						       
                                                <h4 class="form-signin-heading" style="text-align: center;">EDIT USER</h4>
                                                <input type="hidden" name="id" value="${person.id }"/>
                                                <label>User Name:</label>
                                                <input type="text" class="form-control" name="username" value="${person.username}" style="background-color:#edd7e7"/>			
                                                <label>Password:</label>
                                                <input class="form-control" name="password" type="password" value="${person.password}" style="background-color:#edd7e7"/>  				       
                                                <label>Name:</label>
                                                <input type="text" class="form-control" name="name" value="${person.name}" style="background-color:#edd7e7"/>  
                                                <label>Age:</label>
                                                <input type="text" class="form-control" name="age" value="${person.age}" style="background-color:#edd7e7"/>  
                                                <label>Address:</label>
                                                <input type="text" class="form-control" name="address" value="${person.add}" style="background-color:#edd7e7"/>  
                                                <div class="form-group">
                                                    <div class="row">
                                                        <div class="col-sm-1">
                                                            <label>Role:</label>
                                                        </div>				
                                                        <div class="col-sm-3">
                                                            <select class="form-control" name="role" value="${person.role }" style="background-color:#edd7e7">
                                                                <option selected ="selected">admin</option>
                                                                <option >member</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>	
                                                <label>Avatar:</label>
                                                <input type="file" class="form-control" name="avatarFile" value="${person.avatarFileName }" style="background-color:#edd7e7" />	
                                                <hr>    
                                                <button class="btn btn-lg btn-primary btn-block" type="submit">Edit User</button>   
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li><a href="#"> Do Trong Dung </a></li>
                            <li><a href="#"> Blog </a></li>
                            <li><a href="#"> Licenses </a></li>
                        </ul>
                    </nav>
                    <div class="copyright pull-right">
                        &copy;
                        <script>document.write(new Date().getFullYear())</script>
                        , made with <i class="fa fa-heart heart"></i> by <a href="#">Do
                            Trong Dung</a>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</body>
<script src="/Shop/static/admin/js/jquery.min.js" type="text/javascript"></script>
<script src="/Shop/static/admin/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/Shop/static/admin/js/bootstrap-checkbox-radio.js"></script>
<script src="/Shop/static/admin/js/chartist.min.js"></script>
<script src="/Shop/static/admin/js/bootstrap-notify.js"></script>
<script type="text/javascript"
src="https://maps.googleapis.com/maps/api/js"></script>
<script src="/Shop/static/admin/js/paper-dashboard.js"></script>
<script src="/Shop/static/admin/js/demo.js"></script>
</html>