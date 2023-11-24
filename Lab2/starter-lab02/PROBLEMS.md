
# Instructions for Lab 02

For this assignment, you will complete several problems. The code for
each problem X lives in a file called ProbX.java under the src/main
directory, while associated tests are in a ProbXShould.java file under
src/test.

The tests for each method you design should go together in one test
method.

In order to do trial runs of your code, each ProbX.java file has its
own main function. You can run the main function for (e.x.) Prob3 as
follows:

```bash
mvn compile exec:java -q -Dproblem=Prob3
```

Remember that the word "design" means that you should follow [the
design recipe](
https://homework.quest/classes/2023-09/cs2381/design-recipe/).


# Problems

## Problem #0: String Doubling

Design a method that takes a string and produces a string where that
text appears twice in a row.

Show your template as a comment below the method body.

Example: doubleString("frog") => "frogfrog"

**checkstyle**

The automated tests include style checking. To run the style checker
and see the output, use the following commands:

```bash
mvn clean checkstyle:checkstyle
cat target/checkstyle-result.xml
```

This shows an XML file. You're looking for errors like this:

```xml
<file name=".../starter-lab02/src/main/java/lab02/Prob0.java">
<error line="3" column="1" severity="error" message="Missing a Javadoc comment." source="com.puppycrawl.tools.checkstyle.checks.javadoc.MissingJavadocTypeCheck"/>
```

That means that in Prob0.java, on line 3, the style checker thinks I missed a
Javadoc comment.

When you pass the style checker, there will be no errors in the result
XML file.

## Problem #1: Form Overflow

The registration form for a boating license includes a "Last Name"
field, which is limited to 10 characters.

**1.1**

Design a static method called nameOverflows that takes a last name as
a string and returns a boolean value indicating whether the supplied
name will overflow the field.

Show your template as a comment below the method body.

Hint: String objects have a method that gives their length in characters.

**1.2**

Design a static method called truncate that takes a string and a
number of characters and returns that string truncated to no more than
that many characers.

Show your template as a comment below the method body.

Hint: Look at the "substring(int, int)" method in the [String class](
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
from the Java standard library.

## Problem #2: Pet Inventory

A pet store is building a software system to keep track of animals
they have in stock.

**2.1**

Design a Pet record type that stores the name, species, age in years,
and weight in ounces.

**2.2**

Design a method getOlder() for Pet that produces an updated object
with age increased by one year.

Show your template as a comment below the method body.

**2.3**

Design a method, isOld(), for Pet that determines if a pet is old for
its species. Implement the following rules:

 - A mouse is old if it's at least a year old.
 - A dog or cat is old if it's at least 10 years old.
 - A turtle is old if it's at least 20 years old.
 - Any other pet is old if it's more than 5 years old.

Show your template as a comment below the method body.


## Problem #3: Flying Bird

Animation frames for a flying bird are provided in the starter code at
the path "src/main/resources/bird". As a project resource, that
directory is "/bird".

You are going to build an animation that results in this bird flying
back and forth. The bird will live in an 800x600 window and will
travel 200 (logical) pixels per second.

**3.1**

Design a record, Bird, that holds the instantaneous state of the bird.
This should include the x and y coordinates, the current frame, and
whether or not the bird is flipped horizontally.

**3.2**

Design a method of Bird, framePath, that takes returns the path to
the current frame.

Example: 

```java
    var bird = new Bird(... frame is 3 ...);
    bird.framePath() => "/bird/frame-3.png"
```

Show your template as a comment below the method body.

**3.3**

Design a static method of Bird, pixelsMoved, which calculates the
total number of pixels the bird should have traversed since the
program started.

e.g. pixelsMoved(4.5) => 900

**3.4**

Design a static method of Bird, goingBackwards, which determines
if the bird should be flying backwards given the time.

This will be made easier by calling pixelsMoved.

e.g. goingBackwards(4.5) => true

**3.5**

Design a static method of Bird, timeToX, that gives the bird's
x coordinate at the supplied time.

This will be made easier by calling pixelsMoved.

e.g. TimeToX(4.5) => 700
   
**3.6**

Design a static method of Bird, timeToFrameNum that gives the
current animation frame based on the supplied time.

All 8 frames of animation should be cycled through once per second.

**3.7**

Design a static method of Bird, timeToBird(), that takes the current
execution time and returns the Bird for that time.

Vocab: This is an example of a "factory method".

The result should be that the bird flies across the window left to
right, flips, flies right to left, and repeats forever (or at least
until you get an integer overflow).

Use the above helper methods to implement this method.

When coming up with tests for this method, you don't need to re-test
every helper. If the tests for a helper cover all its code, then it's
frequently sufficient to call it once in tests.



