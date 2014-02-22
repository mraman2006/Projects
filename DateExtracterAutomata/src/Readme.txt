How to run the program?
javac DateExtracter.java
java DateExtracter ../Input/Sampleinput.txt


Where to find the output?
output.txt file in the same folder as the java file.
Commas and dot characters are removed while parsing the input.


What does each file do?
dictionary.txt
First line: Total number of states in the automata
Second line: Input state
Third line: Space separated list of final / accepting states
Contains all the states and state transitions


RegexParser.java
Given the input file and array of regex patterns, returns the matched string from the input text.


CustomFileHelper.java
To read and write files.


DateExtracter.java
Main function that requires input file name as command line argument and writes the extracted dates to output.txt file.
