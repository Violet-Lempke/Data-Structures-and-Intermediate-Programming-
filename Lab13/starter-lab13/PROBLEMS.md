# Lab 13: Java Stdlib

In this lab, you will solve a series of problems making heavy use of
the classes from the Java standard library.

For this assignment the App#main method is free for experimentation.

Classes and methods you are expected to use and should be familar with
appear in teh Hints section at the bottom.

When a problem requests a specific asymtotic complexity, it's
having that be the expected, amortized complexity is sufficient.

## Problems

**Problem 1.1: Word in list?**

Complete the Words#wordExists method.

Given a list of words in sorted order and a single word, quickly
determine if the single word appears in the list.

This should take no more than O(log n) time in the size of the list.


**Problem 1.2: isPalindrome?**

Complete the Words#isPalidrome method.

Given a word, determine if it's a palindrome. A palindrome is a string
where the sequence of letters is the same if you reverse it.


**Problem 1.3: maxPalindromeLength**

Complete the Words#maxPalindromeLength method.

Given a list of words, return the length of the longest palindrome.


**Problem 2.1: Gradebook**

Complete the Gradebook#Gradebook constructor.

This should read "students.txt", "homeworks.txt", and "exams.txt"
and build data structures nessisary to efficiently calculate
final grades for the provided students.

This method should operate in O(n) time in the size of the input
files.


**Problem 2.2: finalGrade**

Complete the Gradebook#finalGrade method.

When called on a constructed Gradebook object and given a Student ID,
this should return that student's final grade.

The final grade is calculated as follows:

 - The exam is worth 50%
 - Homeworks are worth 50%
 - Each homework is worth an equal amount

This method should operate in O(1) time.


**Problem 2.3: showTotals**

Complete the Gradebook#showTotals method.

When called on a constructed Gradebook object, this should return a
string showing each student's name and their final grade.

Students should be in alphabetical order like a class roster.

This method should operate in O(n log n) time in the number of students.



## Hints

You should be familiar with the following classes / methods. The
instructor solution for this assignemnt uses all of them.

 - java.util.Collections#binarySearch
 - java.lang.String#toCharArray OR java.lang.String#codePoints
 - methods from java.util.stream.Stream
 - StringBuilder
 - String#split
 - Integer#parseInt
 - Double#parseDouble
 - String#format
 
"Be familiar" means you should go read the official documentation for
these items. Search "java17 Collections", etc.

This isn't a complete list. You should also use other classes and
methods we've covered in class.
