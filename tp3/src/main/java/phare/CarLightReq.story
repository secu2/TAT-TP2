The Car light story

Narrative:
In order to try my brand new car
As a Dacia car owner
I want to test the light system

Scenario:   REQ_001  switch ON
Given a car light system
When the switch mode is ON
Then the light should be ON

Scenario: REQ_002 switch OFF
Given a car light system
When the switch mode is OFF
Then the light should be OFF

Scenario: REQ_003.1
Given a car light system
When the light intensity is 65%
And the switch mode is AUTO
Then the light should be ON

When during 3s the switch mode is AUTO 
And the light intensity is 65%
Then the light should be ON

Scenario: REQ_003.4
Given a car light system
When the light intensity is 65%
And the switch mode is AUTO
Then the light should be ON

When during 3s the switch mode is AUTO 
And the light intensity is 72%
Then the light should be OFF

