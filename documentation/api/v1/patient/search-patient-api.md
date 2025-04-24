# Search Patient API Documentation

## 1. Search Patient Request

### Request Format

```json
{
    "status": null,
    "message": null,
    "data": {
        "patientDTO": {
            "searchByOption": "caseNo",
            "searchByOptionValue": "UNQ00056"
        },
        "patientsList": null
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

## 2. Search Patient Response

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
        },
        "patientsList": [
            {
                "patientAddress": "kjbkj",
                "patientAge": 879,
                "patientChiefComplaint": "kjbk",
                "patientGender": "Male",
                "patientId": "UNQ00057",
                "patientIntraOralExamination": "bkb",
                "patientMedicalHistory": "bkjb",
                "patientMobileNumber": "2312908390",
                "patientName": "rahul",
                "patientOccupation": "hkjbkj",
                "patientRegistrationDate": "2023-12-30T18:30:00.000+00:00"
            }
        ]
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