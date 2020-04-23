# Location EndPoints

### Definition
There is a huge json file that should be filtered by some specific fields
 
* "city"
* "zip"
* "streetAndNumber"
* "openingHours"
* "keywords"
* "lat"
* "lng"

There should be one endpoints but with different output type.
* /storeInfo  Headers Accept application/json
* /storeInfo  Headers Accept text/csv

### Spec
1. It's a Spring boot application.
1. Lombok used for elimination of Getter/Setter.
1. The WriteCsv class is Generic and it could create csv file from any given entity.





