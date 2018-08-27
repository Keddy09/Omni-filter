<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Product</title>
	<!--/tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!--//tags -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.css" rel="stylesheet">
	<!--pop-up-box-->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!--//pop-up-box-->
	<!-- price range -->
	<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
	<!-- flexslider -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<!-- fonts -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
</head>

<body>
<%@ page import = "java.util.*, beans.ProductBean, beans.WTBean, beans.WBBean, beans.WSBean" %>
                    <%!
                    ProductBean pr;
					ArrayList<String> sizes;
					ArrayList<WTBean> tchart;
					ArrayList<WBBean> bchart;
					ArrayList<WSBean> schart;
					ArrayList<String> recc;
					
                    %>

                    <%
                    sizes = (ArrayList)request.getAttribute("sizes");
                    pr = (ProductBean)request.getAttribute("pdet");
                    if(pr.getCategory().equals("Top"))
                       tchart = (ArrayList)request.getAttribute("schart");
                    else if(pr.getCategory().equals("Bottom"))
                        bchart = (ArrayList)request.getAttribute("schart");
                    else
                            schart = (ArrayList)request.getAttribute("schart");
                    %>

	<!-- top-header -->
	<div class="header-most-top">
		<p>Flipkart</p>
	</div>
	<!-- //top-header -->
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->
			<div class="col-md-4 logo_agile">
				<h1 style = "color : white;">
					<a href="index.html">
						<img style="max-height: 40px;"src="images/Flipkart_logo.png"  alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-8 header">
				<!-- header lists -->
				<ul>
					<!-- <li>
					<a href="#" data-toggle="modal" data-target="#myModal1">
						<span class="glyphicon glyphicon-filter" aria-hidden="true"></span> Omni Filter</a>
					</li> -->
					<li>
						<a href="#">
							<span class="fa fa-user-circle-o" aria-hidden="true"></span> Profile</a>
					</li>
					<li>
						<a href="Logout" >
							<span class="glyphicon glyphicon-off" aria-hidden="true"></span> Logout </a>
					</li>
				</ul>
				<!-- //header lists -->
				<!-- search -->
				<div class="agileits_search">
					<form action="SearchServlet" method="post">
						<input name="search" type="search" placeholder="How can we help you today?" required="">
						<button type="submit" class="btn btn-default" aria-label="Left Align">
							<span class="fa fa-search" aria-hidden="true"> </span>
						</button>
					</form>
				</div>
				<!-- //search -->
				<!-- cart details -->
				<div class="top_nav_right">
					<div class="wthreecartaits wthreecartaits2 cart cart box_1">
						<form action="showCart" method="post" class="last">
							<button class="w3view-cart" type="submit" name="submit" value="">
								<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
				<!-- //cart details -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	
	<!-- signin Model -->
	<!-- Modal1 -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="modal_body_left modal_body_left1">
					<center><br><p>SIZE CHART</p><br><table class='timetable_sub'>
						<%
						if(pr.getCategory().equals("Top")){
						out.println("<tr><th>Size</th><th>Bust</th><th>Waist</th><th>Hip</th><th>Shoulder</th></tr>");
						for (WTBean ob : tchart){
						out.println("<tr><td>" + ob.getSize() + "</td><td>" + ob.getBust() + "</td><td>" + ob.getWaist() + "</td><td>" + ob.getHip() + "</td><td>" + ob.getShoulder() + "</td></tr>");
						}						
						}
						else if(pr.getCategory().equals("Bottom")){
							out.println("<tr><th>Size</th><th>Waist</th><th>Hip</th><th>Inseem</th></tr>");
							for (WBBean ob : bchart){
							out.println("<tr><td>" + ob.getSize() + "</td><td>" + ob.getWaist() + "</td><td>" + ob.getHip() + "</td><td>" + ob.getInseem() + "</td></tr>");
							}
						}else{
								out.println("<tr><th>UK size</th><th>US Size</th><th>Foot length</th></tr>");
								for (WSBean ob : schart){
								out.println("<tr><td>" + ob.getUk() + "</td><td>" + ob.getUs() + "</td><td>" + ob.getLength() + "</td></tr>");
								
							}
						}
						
 %>
 </table></center>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal1 -->
	<!-- //signin Model -->
	<!-- signup Model -->
	<!-- Modal2 -->
	<div class="ban-top">
		<div class="container">
			<div class="top_nav_left">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
							    aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav menu__list">
								<li class="active">
									<a class="nav-stylehead" href="index.jsp">Home
										<span class="sr-only">(current)</span>
									</a>
								</li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle nav-stylehead" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Women
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="agile_inner_drop_nav_info">
											<div class="col-sm-4 multi-gd-img">
												<ul class="multi-column-dropdown">
													<li>
														<a href="/Flipkart2/DisplayProduct?pro=wtop">Top Wear</a>
													</li>
													<li>
														<a href="/Flipkart2/DisplayProduct?pro=wbop">Bottom Wear</a>
													</li>
													<li>
														<a href="/Flipkart2/DisplayProduct?pro=wfoo">Foot Wear</a>
													</li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</ul>
								</li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle nav-stylehead" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Men
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="agile_inner_drop_nav_info">
											<div class="col-sm-6 multi-gd-img">
												<ul class="multi-column-dropdown">
													<li>
														<a href="product2.html">Top Wear</a>
													</li>
													<li>
														<a href="product2.html">Bottom Wear</a>
													</li>
													<li>
														<a href="product2.html">Foot Wear</a>
													</li>
												</ul>
											</div>
											
											<div class="clearfix"></div>
										</div>
									</ul>
								</li>
								<li class="">
									<a class="nav-stylehead" href="faqs.html">Faqs</a>
								</li>
								<li class="dropdown">
									<a class="nav-stylehead dropdown-toggle" href="#" data-toggle="dropdown">mORE
										<b class="caret"></b>
									</a>
									<ul class="dropdown-menu agile_short_dropdown">
										<li>
											<a href="icons.html">My Orders</a>
										</li>
										<li>
											<a href="ShowFilters">Edit Filters</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>	<!-- //navigation -->

	<!-- //navigation -->
	<!-- banner-2 -->
	<div class="page-head_agile_info_w3l">

	</div>
	<!-- //banner-2 -->
	<!-- page -->
	<div class="services-breadcrumb">
		<div class="agile_inner_breadcrumb">
			<div class="container">
				<ul class="w3_short">
					<li>
						<a href="index.html">Home</a>
						<i>|</i>
					</li>
					<li>Single Page</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- //page -->
	<!-- Single Page -->
	<div class="banner-bootom-w3-agileits">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">Single Product
				<span class="heading-style">
					<i></i>
					<i></i>
					<i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			                    <%out.println("<div class='col-md-5 single-right-left '><div class='grid images_3_of_2'><div class='flexslider'><ul class='slides'><li data-thumb='" + pr.getImage() +"'><div class='thumb-image'><img src='" + pr.getImage() +"' data-imagezoom='true' class='img-responsive' alt=''> </div></li><li data-thumb='" + pr.getImage() +"'><div class='thumb-image'><img src='" + pr.getImage() +"' data-imagezoom='true' class='img-responsive' alt=''> </div></li><li data-thumb='" + pr.getImage() +"'><div class='thumb-image'><img src='" + pr.getImage() +"' data-imagezoom='true' class='img-responsive' alt=''> </div></li></ul>");
					out.println("<div class='clearfix'></div></div></div></div><div class='col-md-7 single-right-left simpleCart_shelfItem'><h3>" + pr.getBrand() + " " + pr.getColor() + " " + pr.getType()+ " </h3><p><span class='item_price'>"+ pr.getPrice()+"</span></p><div class='single-infoagile'><p>" + pr.getDescription() +"<br>");
					out.println("<");
					for(String s : sizes)
					    out.println("<a href='#'>" + s + "</a>");
				    out.println("<br><a href='#' data-toggle='modal' data-target='#myModal1'>Sizing Help?</a></p></div><div class='occasion-cart'><div class='snipcart-details top_brand_home_details item_add single-item hvr-outline-out'><form action='AddToCart' method='post'><fieldset><input type='hidden' name='pid' value='" + pr.getPid() + "'/><input type='submit' name='submit' value='Add to cart' class='button' /></fieldset></form></div></div></div><div class='clearfix'></div></div></div>");
	%>
	<!-- //Single Page -->
	<!-- special offers -->
	<!-- //special offers -->

	<!-- newsletter -->
	
	<!-- //newsletter -->
	<!-- footer -->
S
	<!-- //footer -->
	<!-- copyright -->
	>
	<!-- //copyright -->

	<!-- js-files -->
	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- //jquery -->

	<!-- popup modal (for signin & signup)-->
	<script src="js/jquery.magnific-popup.js"></script>
	<script>
		$(document).ready(function () {
			$('.popup-with-zoom-anim').magnificPopup({
				type: 'inline',
				fixedContentPos: false,
				fixedBgPos: true,
				overflowY: 'auto',
				closeBtnInside: true,
				preloader: false,
				midClick: true,
				removalDelay: 300,
				mainClass: 'my-mfp-zoom-in'
			});

		});
	</script>
	<!-- Large modal -->
	<!-- <script>
		$('#').modal('show');
	</script> -->
	<!-- //popup modal (for signin & signup)-->

	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<script>
		paypalm.minicartk.render(); //use only unique class names other than paypal1.minicart1.Also Replace same class name in css and minicart.min.js

		paypalm.minicartk.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});
	</script>
	<!-- //cart-js -->

	<!-- password-script -->
	<script>
		window.onload = function () {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity("Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smoothscroll -->

	<!-- start-smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function () {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->

	<!-- imagezoom -->
	<script src="js/imagezoom.js"></script>
	<!-- //imagezoom -->

	<!-- FlexSlider -->
	<script src="js/jquery.flexslider.js"></script>
	<script>
		// Can also be used with $(document).ready()
		$(window).load(function () {
			$('.flexslider').flexslider({
				animation: "slide",
				controlNav: "thumbnails"
			});
		});
	</script>
	<!-- //FlexSlider-->

	<!-- flexisel (for special offers) -->
	<script src="js/jquery.flexisel.js"></script>
	<script>
		$(window).load(function () {
			$("#flexiselDemo1").flexisel({
				visibleItems: 3,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: {
					portrait: {
						changePoint: 480,
						visibleItems: 1
					},
					landscape: {
						changePoint: 640,
						visibleItems: 2
					},
					tablet: {
						changePoint: 768,
						visibleItems: 2
					}
				}
			});

		});
	</script>
	<!-- //flexisel (for special offers) -->

	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- //js-files -->

</body>

</html>