/* Create Angular module  */
var app = angular.module('todoApp', []);

/* Create Angular controller  */
app.controller('jobCtrl', function($scope, $http) {
	
/* Call the API to fetch all jobs */	
	function getAllJob(){
		$http.get("/job/all").then(
		  	 function(resp){
		  	    	  $scope.todoJobList = resp.data;
		  	 },function(err){}
		);
	}

/* Call the API to delete the job */	
$scope.deleteJob = function(jobId){
	$http.delete("/job/"+jobId).then(
		  	 function(resp){
		  		getAllJob(); 
		  	 },function(err){}
	);
	
}

/* Call the API to update the job status either complete or pending job */
$scope.revertJobStatus = function(jobId){
	$http.get("/job/status/"+jobId).then(function(response) {
		 getAllJob();    	   
      },function(err) {
	       
		}); 	   
        
	}

/* Call the API to add new job */
$scope.newJobAdd = function(){
	$http.get("/job/"+$scope.todoJob).then(function(response) {
		    getAllJob();    	   
         },function(err) {
		}); 	   
	}

// fetch all job list
getAllJob();

}); // jobCtrl end