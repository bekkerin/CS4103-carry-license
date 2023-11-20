@ECHO OFF
ECHO Compiling and running GradesTest
REM By default, javac compiles each source file to a class file in the same directory as the source file. 
REM However, it is recommended to specify a separate destination directory with the -d option 
ECHO
javac -d bin -cp libraries\testng.jar ..\eost\Grades.java GradesTest.java


ECHO compiled now runnung
REM --class-path path, -classpath path, or -cp path
REM where java will look for the files it needs
REM compiled files are in bin\eost 
REM both java files specify "package eost;" at the top
java -cp libraries/testng.jar;libraries/jcommander.jar;libraries/guice.jar;bin;bin org.testng.TestNG -testclass eost.GradesTest -log 2 

@ECHO OFF
ECHO Running SC tests for assignment with statement coverage measurement
del jacoco.exec >nul 2>&1
java -ea -javaagent:libraries/jacocoagent.jar=append=false -cp libraries/testng.jar;libraries/jcommander.jar;libraries/guice.jar;libraries/jacocoagent.jar;bin org.testng.TestNG -testclass eost.GradesTest
REM needed to make the report
java -jar libraries/jacococli.jar report jacoco.exec --html report-assignment --classfiles ./bin --sourcefiles ..
del jacoco.exec >nul 2>&1
ECHO.
ECHO ***
ECHO *** View the full coverage report in report-assignment\index.html
ECHO ***

REM pull up the Chrome browser
START "" "report-assignment\index.html""