# SustainableEnergyConsumption

Instructions to run:
Application.java: Run As Java Application 
(It contains main method.)
Once the Server is ready, send the json request to URL:http://localhost:8080/sustainableLiving
Postman can be used for this.


Example of requests:
1.http://localhost:8080/sustainableLiving/getGoals?homeId=1

2.http://localhost:8080/sustainableLiving/saveGoals?homeId=1
JSON:
[{
"consumptionLimit": "300",
"resourceType" : "GAS"
},
{
"consumptionLimit": "400",
"resourceType" : "POWER"
}]

3.http://localhost:8080/sustainableLiving/updateGoal?goalId=1&resourceType=POWER&consumptionLimit=250

4.http://localhost:8080/sustainableLiving/saveHomeResources?homeId=1
JSON:
[{
"consumptionAmount": "200",
"type" : "POWER",
"asOfDate" : "2018-03-13"
},
{
"consumptionAmount": "300",
"type" : "POWER",
"asOfDate" : "2018-03-13"
},
{
"consumptionAmount": "10",
"type" : "GAS",
"asOfDate" : "2018-03-13"
}]
