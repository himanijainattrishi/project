var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'index.html',
		controller:'UserController'
	})
	.when('/register',{
		templateUrl:'user/register.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'user/login.html',
		controller:'UserController',
		
	})
	.when('/index',{
		templateUrl:'index.html',
		
		
	})
	
})
app.run(function($rootScope,$cookieStore,UserService,$location){
	console.log('entering run method ')
	console.log($rootScope.currentUser)
	if($rootScope.currentUser==undefined){
		$rootScope.currentUser=$cookieStore.get("currentUser")
		console.log($rootScope.currentUser)
	}
	
	$rootScope.logout=function(){
		console.log('logout function')
		delete $rootScope.currentUser;
		$cookieStore.remove('currentUser')
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$rootScope.message="Loggedout Successfully"
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
	}
})