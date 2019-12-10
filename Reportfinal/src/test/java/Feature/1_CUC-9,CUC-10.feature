@CUC-11
Feature: demotest

	@TEST_CUC-9
	Scenario: Test 1 Pass
		When Solera is opened by the user
		    Then Officer role as "MotorOfficer" to login 
		    Then agency is chosen by me as "QBE Intermediary" to test
		    Then I verify the case status as the following "Claim Created"
		    Then thr browser is Closed by me  
	@TEST_CUC-10
	Scenario: Test 2 Fail
		When Solera is opened by the user
		    Then Officer role as "MotorOfficer" to login 
		    Then agency is chosen by me as "QBE Intermediary" to test
		    Then I verify the case status as the following "Claim Finalized"
		    Then thr browser is Closed by me  
