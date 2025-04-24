# Select Patient API Documentation

## 1. Select Patient Request (from frontend - to Backend)

### Request Format

```json
{
    "status": null,
    "message": null,
    "data": {
        "patientDTO": {
            "patientId": "UNQ00051",
        }
    },
    "userName": null,
    "userCode": null,
    "userId": 0,
    "statusCode": null,
    "action": null,
    "accessToken": null,
    "email": null,
    "userMobileNumber": null,
    "fileName": null
}

```

## 2. Search Patient Response (from Backend - to frontend)

### Response Format  

```json
{
    "accessToken": null,
    "action": "",
    "data": {
        "patientDTO": {
            "gender": null,
            "patientAddress": null,
            "patientAge": 0,
            "patientChiefComplaint": null,
            "patientId": null,
            "patientIntraOralExamination": null,
            "patientMedicalHistory": null,
            "patientMobileNumber": null,
            "patientName": null,
            "patientOccupation": null,
            "patientRegistrationDate": null,
            "searchByDate": null,
            "searchByOption": "caseNo",
            "searchByOptionValue": "UNQ00057"
        }
    },
    "email": null,
    "fileName": null,
    "message": "Patient Found successfully",
    "status": "success",
    "statusCode": "200",
    "userCode": null,
    "userId": 0,
    "userMobileNumber": null,
    "userName": null
}