Teamtool (Spring MVC)
================

The "Teamtool" is an emerging open source and web-based tool. On the one hand it helps teams adopting new agile processes and on the other hand it helps to recruit and train team members by means of on-the-job training units, the so-called "Agile Moves".

Agile Moves are
* clearly defined routines
* with a specific goal
* that can be done iteratively on the job
* to train certain aspects of teamwork at a time
* to improve team play and the overall productivity

“Agile”, because the moves enable teams to think and develop in an agile way.

“Moves”, because single elements are taken from different methods like Scrum, similar to defined steps in dancing. These moves are then trained specifically and, much like in dancing, can be connected to increasingly complex sequences to live agile values on the job.

For more information about "agile moves" take a look at: http://blog.agile-moves.com/2014/06/05/what-are-agile-moves/


Getting Started
-------------

Technology Stack
* Java 8
* Backend framework: Spring MVC (spring boot, security, etc), MongoDB
* Frontend framwework: AngularJS
* Test framework: Robot framework (BDD)


Testing the teamtool
-------------
Test scenarios are available for all features in gherkin style (Behaviour driven development). For this we are using the robot framework (http://robotframework.org). 

How to run the tests:
* Install the robot framework: https://github.com/robotframework/robotframework/blob/master/INSTALL.rst
* Configure the global variables at "robot/resource.robot"
* For running all tests enter "pybot robot/*"
* For running a specific test enter "pybot --test "Test Scenario Name here" file_name_here.robot"

Documentation and Support
-------------------------
Documentation is available in our confluence wiki: https://teamtool.atlassian.net/wiki/

License
-------
MIT License. For details please see the LICENSE file
