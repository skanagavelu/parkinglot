# parkinglot


Register or allocate a parking lot with

curl -X POST \
  http://localhost:8080/v0/parking/10/register/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 126d325d-41ce-63b5-5c62-6d4c8c4377c0' \
  -d '{
"id" : "event_id",
"cardId" : "card_id",
"slotId" : "slot_id",
"from" : "2021-05-12T10:00:00.000",
"vehicleNo" : "TN33 BB 4444"
}'


DeRegister a parking lot with

curl -X POST \
  http://localhost:8080/v0/parking/10/deregister/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 16a37131-48fa-bf13-44f0-d34b49ccbb7e' \
  -d '{
"id" : "event_id",
"cardId" : "card_id",
"slotId" : "slot_id",
"from" : "2021-05-12T10:00:00.000",
"vehicleNo" : "TN33 BB 4444"
}'