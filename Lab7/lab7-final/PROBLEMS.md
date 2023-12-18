
# Lab 07: Queues and Deques

In this lab, you will implement two queues and two deques.

You will need to write full class definitions for four
classes: ConsQueue, ArrayQueue, ConsDeque, and ArrayDeque.

You should not change the code in ConsList.java

Feel free to put whatever you want in App#main for experimentation.

## Problems

**Problem 1. Implement a Queue using ConsList.**

In ConsQueue.java, write a Queue implementation starting with
the following class defintion:

```java
public class ConsQueue<T> implements Queue<T> {
```

Your queue should store all its items in two fields of type
```ConsList<T>```. Follow the strategy discussed in class:

 - Push adds items to a "back" ConsList.
 - Shift takes items from a "front" ConsList.
 - If you're trying to shift or get the front item but the front list
   is empty, move the items from the back list to the front list in
   reverse order.

All of your queue operations should be amortized O(1).

In ConsQueueShould.java, in each test method, remove the
```assertTrue(false)``` line and uncomment the test code. Your
implementation should pass the provided tests.

**Problem 2. Implement a Deque using ConsList.**

In ConsDeque.java, write a Deque implementation starting with
the following class defintion:

```java
public class ConsDeque<T> implements Deque<T> {
```

This should use the same strategy as for your ConsQueue, plus:

 - Unshift adds items to the "front" list.
 - Pop takes items from the back list.
 - If you're trying to pop or get the back item but the back list is
   empty, move the items from the front list to the back in reverse
   order.

If you use an instance of your deque as either a stack from one end or
a queue in one direction, all operations should be amortized O(1).

In the test file for this class, in each test method, remove the
```assertTrue(false)``` line and uncomment the test code. Your
implementation should pass the provided tests.

**Problem 3. Implement a Queue using an array as a ring buffer.**

In ArrayQueue.java, write a Queue implementation starting with
the following class defintion:

```java
public class ArrayQueue<T> implements Queue<T> {
```

Your queue should store its items in a field of type ```T[]```, plus
some additional int fields. You should use the strategy described in
class:

 - Items go in the data array.
 - Size and capacity are separate, like for an ArrayList.
 - If you need to add an item but there isn't space, allocate an array
   of twice the size and copy the existing items in.
 - Track the indexes of the front and back items in fields.
 - Push items at the back, based on the back index.
 - Shift items from the front, based on the front index.
 - Both indexes are allowed to wrap around.

All of your queue operations should be O(1), except that adding items
can be amortized O(1).

In the test file for this class, in each test method, remove the
```assertTrue(false)``` line and uncomment the test code. Your
implementation should pass the provided tests.

**Problem 4. Implement a Deque using an array as a ring buffer.**

In ArrayDeque.java, write a Deque implementation starting with
the following class defintion:

```java
public class ConsDeque<T> implements Deque<T> {
```

Your Deque should use the same strategy as the ArrayQueue, plus:

 - Unshift adds item at the front.
 - Pop removes items at the back.

All of your deque operations should be O(1), except that adding items
can be amortized O(1).

In the test file for this class, in each test method, remove the
```assertTrue(false)``` line and uncomment the test code. Your
implementation should pass the provided tests.


 
 
