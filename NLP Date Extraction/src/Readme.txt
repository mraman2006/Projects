How to run the program?
javac DateExtracter.java
java DateExtracter ../Input/Sampleinput.txt

Where to find the output?
output.txt file in the same folder as the java file.


What does each file do?
dictionary.txt
Contains all the regular expression patterns to be matched.
If a new holiday or date pattern needs to be added, it should be added in a new line with escape sequences if required.


RegexParser.java
Given the input file and array of regex patterns, returns the matched string from the input text.

CustomFileHelper.java
To read and write files.

DateExtracter.java
Main function that requires input file name as command line argument and writes the extracted dates to output.txt file.
