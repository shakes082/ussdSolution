# This is an ideation of a solution presented to Mama Money for solving a rest ussd problem.

### What You Need:

About 15 minutes

A favorite text editor or IDE

JDK 1.8 or later

Gradle 4+ or Maven 3.2+

You can also import the code straight into your IDE: Spring Tool Suite (STS)

GIT

### Clone The Repository

```git clone https://github.com/shakes082/ussdSolution.git```

```cd ussdSolution ```

### Run the Application

To run the application, run the following command in a terminal window (in the complete) directory:

```./gradlew bootRun```

If you use Maven, run the following command in a terminal window (in the complete) directory:<br />

```./mvnw spring-boot:run```

### Access The Application</strong><br />
Open up your favourite browser and go to the following address:<br />

Single Rest Endpoint:
(http://127.0.0.1:8080/mamamoney/ussd)

### Get List Of Country Codes:

Sample USSDRequest:

```
{
  "msisdn": "27829611111",
  "requestOptions": {
  },
  "userEntry": 1
}
```

Expected USSDResponse:

```
{
  "responseData": {
    "01": "Kenya",
    "02": "Malawi"
  }
}
````

### Convert To Country Currency:

Sample USSDRequest:

```
{
  "msisdn": "27829611111",
  "requestOptions": {
    "countryCode": "01",
    "amount": "200.00"
  },
  "userEntry": 2
}
```

Sample USSDResponse:

```
{
  "responseData": {
    "convertedAmount": "32.786884"
  }
}
````

### Remit Amount To User

Sample USSDRequest:

```
{
  "msisdn": "27829611111",
  "requestOptions": {
    "countryCode": "01",
    "amount": "32.786884",
    "recipientMSISDN": "27829622222"
  },
  "userEntry": 3
}
```

Sample USSDResponse:

```
{
  "responseData": {
    "trackingRef": "70d61ad7-a959-427a-b098-3db7854aeee0"
  }
}
````

### Track Remittance Status

Sample USSDRequest:

```
{
  "msisdn": "27829611111",
  "requestOptions": {
    "trackingRef": "70d61ad7-a959-427a-b098-3db7854aeee0"
  },
  "userEntry": 4
}
```

Sample USSDResponse:

```
{
  "responseData": {
    "remittanceStatus": "Processing Request"
  }
}
````

Swagger:
(http://127.0.0.1:8080/mamamoney/swagger-ui/)




