# ParkingLot (Parking lot Problem)

Restful Parking lot spring boot application without need of DB access.
Multiple geolocated ParkingLot can be added into the system, and can start getting parking token and cost in the specific parking lot.

<BR>
<BR>
	
<B>Project Requirements</B>
<ul>
<li>JDK 11
<li>Maven
<li>Spring Boot
</ul>

<BR>
<BR>

<B>Build Instructions</B>	
Run this application like blow:

  1. mvn clean install
  2. java -jar ../.m2/repository/com/example/parking/0.0.1-SNAPSHOT/parking-0.0.1-SNAPSHOT.jar src/main/java/com/example/parking/ParkingApplication

<BR>
<BR>


<B>Register a parking lot with capacities</B>

curl -X POST \
  http://localhost:8080/v0/parkingStations/ \
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

<B>Get a parking token while enter</B>

curl -X POST \
  http://localhost:8080/v0/parkingTokens/park/ \
  -H 'content-type: application/json' \
  -d '{
"parkingStationId" : "c34995d3-f3cc-4543-b633-db9348498e17",  <--- Update from previous request
"vehicleNo" : "TN33 BB4444",
"type" : "CAR"
}'

<BR>
<BR>
  
<B>Get updated parking token while depart to see the cost</B>

curl -X DELETE \
  http://localhost:8080/v0/parkingTokens/depart/b8431ef0-be17-4e9f-b6ba-f7b1a5c95967 \ <BR>
	-H 'content-type: application/json' \
