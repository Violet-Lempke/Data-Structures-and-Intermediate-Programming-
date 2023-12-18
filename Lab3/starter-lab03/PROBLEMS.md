
# Instructions for Lab 03

For this assignment, you will complete several problems. The code for
each problem X lives in a file called ProbX.java under the src/main
directory, while associated tests are in a ProbXShould.java file under
src/test.

In order to do trial runs of your code, each ProbX.java file has its
own main function. You can run the main function for (e.x.) Prob3 as
follows:

```bash
mvn compile exec:java -q -Dproblem=Prob3
```

Remember that the word "design" means that you should follow [the
design recipe](
https://homework.quest/classes/2023-09/cs2381/design-recipe/).

If you start with code with an @author annotation and modify it, the
best practice is generally to add an additional @author annotation.

# Problems

## Problem 1: Fast Food

McBurger is trying to automate their ordering system, and needs a data
model for their menu. They've created a MenuItem interface and
implemented it for Burgers, but they need your help adding two more
kinds of item: Nachos and Ice Cream.

Nachos have the following options:

 - Small, medium, or large
 - Guacamole or not
 - Spicy or mild
 - Example names: "Medium Spicy Nachos with Guac", "Large Nachos"

Ice Cream has the following options:

 - Zero or more scoops of Vanilla
 - Zero or more scoops of Chocolate
 - Cone or bowl
 - Example names: "Ice Cream Cone, 2 Vanilla", 
   "Ice Cream Bowl, 1 Vanilla and 1 Chocolate"

Build each of Nachos and Icecream as new records in Prob1.java
that implement the MenuItem interface.

Add six new test methods, one for each method you've implemented. You should
have enough asserts to test every line of code you've written.

## Problem 2: Snowman Too Big

The snowman in Prob2.java grows too fast.

Fix it so that a Snowman.build(5) fits in the provided window.

The hat should stay the same size, lower snowballs should still be
bigger than higher snowballs, and the snowballs and hat should remain
in contact. Rather than doubling in size each time use a smaller
factor. Try having each snowball be 1.5x the size of the previous one.

Update the test method to test your new behavior.

## Problem 3: Class Schedule

**3.1**

Design a record called Course that stores the name, instructor's name,
and program (e.g. "CS", "MA") for a course.

**3.2**

Design a data representation for a list of courses. This should involve
three components:

 - An interface, CourseList
   - methods: first, rest, empty
 - A record for an empty list, CourseEmpty
 - A record for a linked list cell, CourseCell

I expect that you will base this code on the int list from lecture 06.
Not citing that isn't cheating or a grade penalty, but cite it anyway.

This will produce 6 test methods, three for each implementing record.

## Problem 4: Print CS Courses

Design a static method of Prob4 that takes a CourseList and prints
the name and instructor of each CS course in the list.

Those records and interfaces will be visible in Prob4.java if they are
defined in Prob3.java because they are all in the same package.

