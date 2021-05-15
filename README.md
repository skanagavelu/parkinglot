# parkinglot

Sample Parking lot application without any validation or DB access.
<BR>
<BR>
Run this application like blow:

  1. mvn clean install
  2. java -jar ../.m2/repository/com/example/parking/0.0.1-SNAPSHOT/parking-0.0.1-SNAPSHOT.jar src/main/java/com/example/parking/ParkingApplication

<BR>
<BR>


Register a parking lot with capacities

curl -X POST \
  http://localhost:8080/v0/parkingStations/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"name" : "XYZ_Parking_station",
"address" : "Bangalore",
"parkingSlots" : {
		"CAR" : 100,
		"BIKE" : 50 
	}
}'


<BR>
<BR>

Get a parking token while enter

curl -X POST \
  http://localhost:8080/v0/parkingTokens/park/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"parkingStationId" : "c34995d3-f3cc-4543-b633-db9348498e17",  <--- Update from previous request
"vehicleNo" : "TN33 BB4444",
"type" : "CAR"
}'

<BR>
<BR>
  
Get updated parking token while depart to see the cost

curl -X DELETE \
  http://localhost:8080/v0/parkingTokens/depart/b8431ef0-be17-4e9f-b6ba-f7b1a5c95967 \ <--- Update from previous request
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
