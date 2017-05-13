/**
 *
 */
angular.module('niographADMWebApp')
	.controller('admSummaryCtrl', [ '$timeout', '$state', '$stateParams', '$scope', '$log','$window','$http', 'growlService', 'appService',
		function($timeout, $state, $stateParams, $scope, $log,$window, $http, growlService, appService) {

			$scope.$state = $state;

			//Input Slider
			function sliderRange() {
				this.nouisliderValue = 4;
				this.nouisliderFrom = 25;
				this.nouisliderTo = 80;
				this.nouisliderRed = 35;
				this.nouisliderBlue = 90;
				this.nouisliderCyan = 20;
				this.nouisliderAmber = 60;
				this.nouisliderGreen = 75;
			}

			function sliderColor() {
				//Color Picker
				this.color = '#03A9F4';
				this.color2 = '#8BC34A';
				this.color3 = '#F44336';
				this.color4 = '#FFC107';
			}

			
			

			function summaryViews() {
				this.smyGrid = false;
				this.smyList = true;
				this.smyLocation = false;
			}
			
			$scope.load = function() {
				$log.debug('@@@@@@@@@@ :::: admSummaryCtrl --- load :::: @@@@@@@@@@@----> ', $state);
				$scope.sliderRange = new sliderRange();
				$scope.sliderColor = new sliderColor();
				
				$scope.smyOpts = new summaryViews();
				if ($state.current.name == 'edukone.admSummary') {
					$scope.searchModel = {
						"establishedOn" : "2014-02-09",
						"ownership" : "private",
						"offerings" : [ {
							"id" : "2"
						} ],
						"types" : [ {
							"id" : "2"
						} ],
						"city" : {
							"id" : "1"
						},
						"zipCode" : "411013"
					}
				}
				//summaryData();
			};



			

			var startTime = new Date();
			$scope.stopwatch= 0;

			
			$scope.schools=[
			{
				"name":'DPS PUBLIC SCHOOL',
				"schoolLikes":0,
				"postTimer":0,
				"board":"CBSE",
				"state":"Himanchal",
				"city":"Hamirpur",
				"fees":20,
				"description":'DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.',
				"reviews":[{
					"comment":'Cool',
					"timer": 1,
					"author":'Akash',
					"likes": 0,
					"dislikes":0
				}]
				
				},
				{
				"name":'DAV PUBLIC SCHOOL',
				"schoolLikes":0,
				"postTimer":0,
				"board":"IB",
				"state":"uttrakhand",
				"city":"haldwani",
				"fees":30,
				"description":'DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.',
				"reviews":[{
					"comment":'Cool',
					"timer": 1,
					"author":'Akash',
					"likes": 0,
					"dislikes":0
				}]
				
				}];


			  $scope.moreEle=[{
				"name":'MODERN PUBLIC SCHOOL',
				"schoolLikes":0,
				"postTimer":0,
				"board":"CISCE",
				"state":"Punjab",
				"city":"Amritsar",
				"fees":40,
				"description":'DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.',
				"reviews":[{
					"comment":'Cool',
					"timer": 1,
					"author":'Akash',
					"likes": 0,
					"dislikes":0
				}]
				
			},
			{
				"name":'XYZ PUBLIC SCHOOL',
				"schoolLikes":0,
				"postTimer":0,
				"board":"ICSE",
				"state":"Haryana",
				"city":"Gurgaon",
				"fees":50,
				"description":'DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.',
				"reviews":[{
					"comment":'Cool',
					"timer": 1,
					"author":'Akash',
					"likes": 0,
					"dislikes":0
				}]
				
			}];
		


			


			$scope.somePlaceholder="write comment";

			$scope.model = {};
			$scope.model2 ={};
			$scope.keyValue=0;
			
				
			$scope.byFees=function(minValue,maxValue){
				return function(school) {
    					if(school.fees>=minValue && school.fees<=maxValue){
    						return true;
    					}
  					};

			};



			$scope.addReview= function(outer){
				$scope.stopwatch=Math.trunc((new Date()-startTime)/1000);
				// $scope.datenow= Date.now();
				//$scope.newDate=$scope.
				//$window.alert($scope.datenow-$scope.startTime);
				


				 $scope.addNew=$scope.model.commentInput[outer];
				 $scope.addNew2=$scope.model2.authorInput[outer];
				 if($scope.addNew.match(/\S/g)){
				 	 $scope.schools[outer].reviews.push({"comment":$scope.addNew,"timer":$scope.stopwatch,"author":$scope.addNew2,"likes":0,"dislikes":0});
				
				 }
				 else{

				 	swal("write comment!");
				 }
				
				 
				 $scope.model.commentInput[outer]=' ';
				 $scope.model2.authorInput[outer]=' ';
				 
			};
			
			$scope.likesCounter=function(outer,index){
				$scope.schools[outer].reviews[index].likes+=1;
			}

			$scope.dislikesCounter=function(outer,index){
				$scope.schools[outer].reviews[index].dislikes+=1;
			}

			$scope.testLoad=function(){
				
				$scope.arrLength=$scope.moreEle.length;
				if($scope.keyValue < $scope.arrLength){
					$scope.schools.push($scope.moreEle[$scope.keyValue]);
				}
				
				
				$scope.keyValue+=1;
			}



			
			





		/*	var summaryData = function() {
				$scope.summaryData = [
					{
						"id":1,
						"name": "Delhi Public School",
						"aboutUs": "DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.",
						"website":"www.dps.com",
						"likes":"20",
						"commentsCounts":"2",
						"comments":["comment1","comments2"]

					},
					{
						"id":2,
						"name": "Delhi Public School",
						"aboutUs": "DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.",
						"website":"www.dps.com",
						"likes":"20",
						"commentsCounts":"2",
						"comments":["comment1","comments2"]

					}
				]
				appService.POSTMethod('/testinstitutes', $scope.searchModel).then(
					function(dataResponse, status, headers, config) {
						//success
						$log.debug("********** testinstitutes ", dataResponse);

						 $scope.summaryData = dataResponse;
						 $log.debug("********** summaryData",  $scope.summaryData);
						appUtils.defaultParseResponse(dataResponse, function(dataResponse) {
							$log.debug("**********", dataResponse);

						});
					})
			}*/








			var loadMoredata= {
				"id":3,
				"name": "Delhi Public School",
				"aboutUs": "DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.",
				"website":"www.dps.com",
				"likes":"20",
				"commentsCounts":"2",
				"comments":["comment1","comments2"]
			}

			/*var moreData = {
					//"id": 1,
					name: "Delhi Public School",
					aboutUs: "DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.",
					"address": "Vill. Mohammadwadi, Nyati County, Pune - 411060",
					"contacts": 2026970412,
					"establishedOn": "2008-01-02",
					"website": "http://www.dpspune.com/",
					"ownership": "private",
					"faculties": 32,
					"offerings": [{
						"id": 2,
						"name": "Primary",
						"type": null
					},
					{
						"id": 3,
						"name": "Secondary",
						"type": null
					},
					{
						"id": 4,
						"name": "Higher Secondary",
						"type": null
					}],
					"types": [{
						"id": 1,
						"name": "Play School",
						"desc": null
					},
					{
						"id": 2,
						"name": "School",
						"desc": null
					}],
					"city": {
						"id": 1,
						"city": "Pune",
						"state": "Maharashtra",
						"country": "India"
					},
					"zipCode": "411060",
					"facility": "1,2,3"
				}

			$scope.loadMoreSchools  =function(){
				$scope.summaryData.push(loadMoredata);
				appService.POSTMethod('/testinstitutes', $scope.searchModel).then(
						function(dataResponse, status, headers, config) {
							//success
							$log.debug("********** testinstitutes ", dataResponse);
							_.each(dataResponse, function(response){
								$scope.summaryData.push(response);
							})
							 $log.debug("********** summaryData",  $scope.summaryData);
						})



			}*/

			$scope.postComment = function(comment){
				var summaryDataArr = $scope.summaryData;
				$scope.summaryData[0].comments.push();
				
				_.each(summaryDataArr, function(summaryData) {
    				if(summaryData.id==id){
							summaryData.comments.push(comment);
						}
					});

			}

		} ]);
