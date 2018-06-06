---insert a new participant ---
http://localhost:8080/HCLDemoMedicalResearchCRUD/testWS/insertNewParticipantInfo/
{
	"fname": "Mark",
	"lname": "Zuck",
	"email":"mzucks@hotmail.com",
	"address":"231 rockefeller rd",
	"contact_no":" 202-231-2341",
	"age": 27,
	"participant_id":"ZE2018001",
	"medicalResearchProgram":{
		"program_Type": "Allergy",
		"state":"DC",
		"start_date":"2010-01-01",
		"end_date":"2010-12-31",
		"cost":103330,
		"funding_status":"Yes",
		"supervisor_Id":"1001",
		"attachment": null
	}
}

--------------------------------------------------------

Get a program

http://localhost:8080/HCLDemoMedicalResearchCRUD/testWS/getProgram/6

----------------------------------------------------------
Insert a new Participant with Program ID

http://localhost:8080/HCLDemoMedicalResearchCRUD/testWS/insertNewParticipantInfoWithProgID/

{
	"fname":"Bill",
	"lname":"Avalante",
	"email":"bavalante@gmail.com",
	"address":"231 grant rd",
	"contact_no":" 201-233-1241",
	"age": 30,
	"participant_id":"ZE2018099",
	"medicalResearchProgram":{
		"program_Id":6
	}
}
-------------------------------------------------

Delete a program

http://localhost:8080/HCLDemoMedicalResearchCRUD/testWS/deleteProgram/5


	
