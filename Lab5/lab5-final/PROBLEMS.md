
# Instructions for Lab 04

For this problem you will complete the code for a bouncing ball
simulation, a little bit different from last time.

Remember that the word "design" means that you should follow [the
design recipe](
https://homework.quest/classes/2023-09/cs2381/design-recipe/).

If you start with code with an @author annotation and modify it, the
best practice is generally to add an additional @author annotation.

Note: ```assertTrue(false)``` is used to force tests to fail in the
starter code. You'll want to remove that once you have real test
logic that tests your code.

**Pair Programming**

For this lab - at least for the lab period - we will be doing pair programming.

 - Your team will work using one computer.
 - One team member - the pilot - will be at the keyboard.
 - The other team member(s) - the copilot(s) - will be assisting.
 - The pilot should verbally explain what they are doing before doing it.
 - The copilot(s) should provide suggestions and feedback.
 - If the pilot isn't sure what to do, they should explain where they are
   and ask for next steps.
 - After each step, a new pilot should take the keyboard.

**Autograding**

Remember that your score on the autograder is part of your final grade.

Double check the output on Inkfish to confirm that all of the expected
tests are "ok".

# Problems

**1. Implement ArrayList#map**

The map method should produce a new ArrayList with elements
created by applying the provided function to each element in
this ArrayList.

You should pass the provided tests.

**2. Use ArrayList#map to complete BallWorld#onTick**

You should pass the provided tests.

**3. Implement ArrayList#filter**

The filter method should produce a new ArrayList with elements
from this ArrayList for which the provided predicate returns true.

You should pass the provided tests.

**4. Use ArrayList#filter to complete BallWorld#onKey**

You should pass the provided tests.

**5. Write Ball#tick to match the test**

You should pass the provided tests.

**6. Complete the test in BallShould for maybeBounce**

Your test code should run every line of the maybeBounce method.

You don't have to handle the functionality added in part 7 where balls
bounce off each other unless that functionality causes this test to
fail.

**7. Make balls bounce off each other.**

You should pass the provided test and manually testing the simulation
should show it working in a reasonable manner.
