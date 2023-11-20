# CS4103-grades-project
Practice project for the final exam in CS4103 Software Testing

## Description
The project is a self-contained package using Java and the TestNG framework based on the textbook used for the class:
Essentials of Software Testing by Ralf Bierig, Stephen Brown, Edgar Galván, and  Joe Timoney.
[ISBN-13 978-1108833349 available on Amazon](https://www.amazon.com/Essentials-Software-Testing-Ralf-Bierig-ebook-dp-B09B3WXPBL/dp/B09B3WXPBL/ref=mt_other?_encoding=UTF8&me=&qid=1644349168)

## Installation
Before you try to run the project, I recommend installing the software and running the execution scripts to make sure that the project can run without problems. You can find the execution scripts [at this site](https://www.cambridge.org/highereducation/books/essentials-of-software-testing/5BEA8B9CB2E001E014CE0FDD7F41F3E9/resources/student-resources/B88F1744511576B05C5891F27743CC3B/code/FC2BD453D6A44CA120983885DCBEDB8D) . The library files in the Libraries folder run on my machine. For the book project, you can try to copy them to the book files Libraries folder. For Java, I used  JDK 18. The [direct link is here](https://download.oracle.com/java/18/archive/jdk-18.0.2_windows-x64_bin.msi) and you can find other versions [at this site](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html).
I got an error message in the comple process that the parent directory could not be created. It appears to be related to using a different drive than the C drive. Once I placed the Code folder in C:\Users\<user>\Desktop (directly on the local desktop) it worked just fine.
Finally, make sure to run the book files and the project from the terminal. 
The grading.bat file contains all the java commands to  run the project.

## Running the project
I run the project in Visual Studio Code. In the terminal, make sure to change to the directory where the grading.bat file is located. Use cd (change directory) as needed. To go to a subdirectory: cs (subdirectory). To go up one level: cd ..
![alt text](/images/vscode.png "Running in Visual Studio Code")

## Explanation
The testing program consists of the following parts:
* Equivalence partitions. Error conditions are tested last, are indicated with a *, and use the label TEPx (Test Equivalence Partitions x). In the test cases table, repetitive TCIs are listed in red rather than in square brackets [ ] like in the book. Not all outcome partitions have coverage with EP tests, since we want to limit test cases and they can be checked once all tests are completed.
* Boundary values. Error cases are listed last. Tests use the label TBVx (Test Boundary Value x). Some values generate failed tests due to deliberate faults in the code. For teaching  purposes these failed tests are not fixed in the code, which of course in real life they would be.
* Decision tables. Test items are the combination rules. Tests use the label TDTx (Test Decision Table x). No error conditions are used, and all rules point in one direction so the top range (in this case >= 90) is simply the False condition for the next to highest range (< 90).
*  Statement coverage. Test coverage items are the code lines that did not execute with EP, BV, and DT. Tests use the label TSCx (Test Statements Coverage x).
*  Branch Coverage. Test Coverage items are the branches that have not been followed. Tests use the TBCx label (Test Branch Coverage x).
