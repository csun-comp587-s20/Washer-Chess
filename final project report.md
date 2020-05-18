# CS -587 Project Final Report 
- Asbin Dahal ( https://github.com/asbin4747 )
- Astghik Hovhannisyan ( https://github.com/AstghikHov )
## Proposed System Under Test (SUT)
- Washer-chess (Java )

`For the sake of demonstrating what we did, we have not merged our pull requests into our master branch. The latest pull request should consist of all the tests written so far. We have a separate test folder where all our tests have been included. Only one the pull request was merged into master branch.`

### Unit Testing with Sufficient Coverage
As mentioned in our proposal report we were able to write unit tests for most of the classes. We have successfully written unit tests for methods BoardArrayFactory, Bishop, BoardEntry, Board, King, Knight, MoveList, Node, Pawn, PieceListFactory, PieceList, PlyTable, Ply, Queen, Rook, Side, Tree and WasherEngine classes. We originally intended to include the jacoco and pittest for measuring our test reports. Unfortunately, our SUT did not consist of a pom.xml file so we had difficulty running the maven commands. Instead, we used the built in code coverage report that is provided by Intellij. The coverage screenshot is provided along with this report.
There were a lot of unit tests written. We have implemented unit tests for methods of all the classes mentioned below:
- BishopTest:     https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-294c3ee486e2976ca81fec7d79c39a8a 
- BoardTest:    https://github.com/csun-comp587-s20/Washer-chess/blob/master/src/washer/Test/BoardTest.java
- BoardEntryTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-23169d09f36ffe17e1ac03295f510172
- KnightTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-bb805798c88ac536c8675de8f1502685
- MoveListTest:   https://github.com/csun-comp587-s20/Washer-chess/blob/master/src/washer/Test/MoveListTest.java 
- NodeTest:   https://github.com/csun-comp587-s20/Washer-chess/blob/master/src/washer/Test/MoveListTest.java
- PawnTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-8b558c9a64f226a526b911a41c9952ba 
- PieceListTest:   https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-8b558c9a64f226a526b911a41c9952ba 
- PlyTableTest:  https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-d23741e55283c2e8a76fd7df687527f5  
- PlyTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-7e5df54e22a8738832f93f92d74a10f6
- BoardArrayFactory:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-8e9f3299e7a54a1c117a36145e5d2d3b
- PieceListFactory:   https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-1687b7d9db943b3f3af86c8581b6c866 
- QueenTest:   https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-f88844f6a4f24458fc8102ecfe1e08d0  
- RookTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-e12e9d4860c07752956aab766d5aca9f
- SideTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-b8b94672d1815df911b3cd8b372a46fb
- TreeTest:    https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-d1a3309771c744c192e25711c74f64f7
- WasherEnfineTest:  https://github.com/csun-comp587-s20/Washer-chess/pull/6/commits/04ab35d02a1361dac5352bde99b44425ce0a6fb3#diff-b37b5f441128539d7f94e0c606135d24  



### Automated Testing
As mentioned in our proposal we have also included automated testing in our SUT. We have used loops to generate inputs and test them in BoardTest, KingTest, NodeTest, and WasherEngineTest. We have successfully checked for the behaviours of each piece at different positions as mentioned in our proposal. 

- BoardTest (TestGetLocation, testGetFile, testGetFile1, testGetFile1 : from line 56) 
 https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-7ed525ca3116036429290f65caef5621 

- KingTest (checkBooleanReturnWithArray : line 75)  https://github.com/csun-comp587-s20/Washer-chess/pull/6/files#diff-63f6dc651e2e3ef21b1b11f70d6c4839 

- NodeTest(getNumberOfChildTest, getChildTest,getChildrenTest: from line 12 )  https://github.com/csun-comp587-s20/Washer-chess/blob/master/src/washer/Test/NodeTest.java 

- Washer engine (TestIndent : line 27)  https://github.com/csun-comp587-s20/Washer-chess/pull/6/commits/04ab35d02a1361dac5352bde99b44425ce0a6fb3#diff-b37b5f441128539d7f94e0c606135d24

### Bugs Found
Our test cases helped us to find 5 bugs in the SUT. The tests we wrote did not pass as it should.


### Refactoring
We did some refactoring to increase the testability. To test some of the private methods we created public methods that call the private ones and return the same output. Also,if it was possible, we created methods that return the output of void methods. 
Created findDirectionalMovesPublic which returns the seoult of private method findDirectionalMovesPublic Link
Created some public methods to test private methods, and methods to test void methods (explained in comments) link
- Refactoring of void and private methods Link
- Refactored private method Link  
- Modified private method Link

### Lessons Learned
- There were a number of things we did learn from this project. We did choose this project to focus more on unit testing, but later found out that testing for GUI applications is challenging. Therefore we decided to focus only on unit tests and automated tests. We could not cover the GUI testing and if we had done this differently we probably would have had a game plan for GUI testing.  
- We did learn about Mockito which we have included in our test suite.
- Coverage Info : We were only able to get 58% overall coverage. This happened because we were not able to test most of the methods and classes implemented in the SUT that consisted of abstract, static,void and dome of the  private methods. It was challenging to refactor those methods as there were lots of dependencies among the methods. We did refactor some of the methods but found out that it really did not increase our code coverage. Considering nearly 4500 lines of code to test for we did cover more than half of the code.
- What we could have done better: Better understanding of 0x88 representation of the Chess board could have increased the branch coverage and number of tests for several methods. Looking back we would have definitely first tried to understand a code better before writing the test, also we could have chosen SUT that had less abstract and private methods could have been a better option for us.



### Coverage Screenshots and link

- Coverage Report link :
https://github.com/csun-comp587-s20/Washer-chess/blob/master/Coverage%20Report.pdf 














Fig : Overall coverage generated through Intellij which was 56%




























Fig : Breakdown by coverage for each class. 
