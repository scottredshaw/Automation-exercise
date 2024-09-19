Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Scenario:
    	Given user wants to change their password
    	Then the user enters correct username
    	And correct password
    	When the username
    	And password is accepted
    	Then the user can enter the new password
    	And confirms the new password by retyping it in
    	And the new passwords match
    	
# do a scenairo for when the user doesn't put in a correct username 
		Scenario:
    	Given user wants to change their password
    	Then the user enters an incorrect username
    	And a correct password
    	But the username
    	And password is not accepted

# do a scenairo for when the user doesn't put in a correct password 
		Scenario:
    	Given user wants to change their password
    	Then the user enters correct username
    	And incorrect password
    	But the username
    	And password is not accepted

# do a scenairo for when the users new passwords doesn't match
		Scenario:
    	Given user wants to change their password
    	Then the user enters correct username
    	And correct password
    	When the username
    	And password is accepted
    	Then the user can enter the new password
    	And confirms the new password by retyping it in
    	But passwords do not match

# do a scenairo for when the new password is not over 3 characters
		Scenario:
    	Given user wants to change their password
    	Then the user enters correct username
    	And correct password
    	When the username
    	And password is accepted
    	Then the user can enter the new password
    	And confirms the new password by retyping it in
    	But the password not accepted as it is not over 3 characters

# do a scenairo for when the new password doesn't have at least one digit
		Scenario:
    	Given user wants to change their password
    	Then the user enters correct username
    	And correct password
    	When the username
    	And password is accepted
    	Then the user can enter the new password
    	And confirms the new password by retyping it in
    	But the password not accepted as the password does not have at least 1 digit
    	