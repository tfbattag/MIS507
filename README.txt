This application simulates a Score Service Bus application, a Score-Provider (to get scores from) and also some client interaction
via Subscribers that connect to the service to receive Score-Updates via their preferred method.

The Subscribers utilize Proxied Deliverers that protect the Subscriber from the details of message translation and connections, etc.
In this example application, the Proxied Deliverers do not do anything special.

1.) The <ROOT> of this project must be:  edu.arizona.eller.mis.fiveoseven

2.) The class used to execute the application is:

    edu.arizona.eller.mis.fiveoseven.MainHarness   .

3.) The package structure of this application is very important. Please make sure that it is recreated on your filesystem as follows:

    edu.arizona.eller.mis.fiveoseven.
                                     dto
                                     esb
                                     exceptions
                                     mocks
                                     providers
                                     stubs
                                     subscribers
                                     tests

4.) Also note that the following file must live at the <ROOT> of this project.

    files.properties

    Its location MUST be <ROOT>.files.properties

5.) There are three files that MUST be made available to the application. Their locations MUST be declared in the files.properties file.

6.) The format of weeklyGames.txt MUST be: team1|team2 \n, where \n indicates a new line.
    Example: team1|team2
             team3|team4
             team5|team6

7.) The format for score files (scores1.txt, scores2.txt) is int score1|int score2. Both scores must be positive integers.
    Example: 17|10
             23|7
             35|17
             12|28

8.) This application requires JDK 1.7.x

9.) Support questions for this application should be directed to: battagliat@email.arizona.edu or 406.493.9730

#



