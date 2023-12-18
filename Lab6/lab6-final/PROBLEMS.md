
# Lab 06: Stacks

In this lab, you will complete three stack implementations.

You only need to change the code in the three stack implementation
files (ConsStack.java, ArrayStack.java, and BitStack.java). You can
also change the code in App.java for testing.

The code in Stack.java, ArrayList.java, ConsList.java, and the test
files should not change.

## Problems

**Problem 1. Implement a stack using a ConsList.**

Complete the code in ConsStack.java so that it implements a stack by
storing data in a ConsList.

You should pass the provided tests.

All of your stack operations (push, pop, peek, and empty) should be O(1).

**Problem 2. Implement a stack using an ArrayList.**

Complete the code in ArrayStack.java so that it implements a stack by
storing data in a ArrayList.

You should pass the provided tests.

All of your stack operations (push, pop, peek, and empty) should be
amortized O(1). That means that a series of *n* of these operations
should complete in O(*n*) time.

**Problem 3. Implement a space-efficient stack of booleans.**

Complete the code in ArrayStack.java so that it implements a stack by
storing data in an array of bytes.

You should pass the provided tests.

All of your stack operations (push, pop, peek, and empty) should be
amortized O(1). That means that a series of *n* of these operations
should complete in O(*n*) time.

Storing *n* boolean values should take no more than 2 + (*n*/4) bytes,
even when using the strategy of doubling the capacity each time it needs
to increase.


