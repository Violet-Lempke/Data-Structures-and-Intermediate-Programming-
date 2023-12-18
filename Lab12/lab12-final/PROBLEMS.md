# Lab 12: Parallel Speedup

In this lab, you will:

 - Use threads and other optimizations to speed up a 
   computationally expensive program.

Note for next time:

 - Labs 13 & 14 will be our last teams of the semester.
 - If you'd like to request a specific partner for the last two labs,
   send me an email by this Friday.

## Problems

**Problem 1. List Prime Numbers**

Write a static method, ```Primes#findPrimes(nn, tt)``` that generates
a list of all prime numbers from 2 to nn using tt threads.

Your method should

 - Really find all the primes in range and return them as a list.
 - Create tt threads that do work.
 - Execute at least twice as fast with 4 threads as with one thread on
   a machine with at least 4 processor cores and a large enough nn.
 - Find the requested primes as fast as is reasonably possible.
 - Be so fast that it passes all the tests even in the sandboxed
   container on the Inkfish server - this will probably require
   finding the primes to a billion in about a second on your machine.

Put some effort into making a solution that performs well on a laptop
or desktop machine with many cores. A small portion of your grade will
depend on how the performance of your solution ranks in manual testing
compared to reasonable solutions from other teams. Manual testing may
be done using a 24-core workstation.

**Measuring Performance**

A good general performance metric is this: What is the maximum nn you
can generate the list of primes up to in under 10 seconds?

There's a quick table for correct prime counts of powers of 10
here: https://t5k.org/howmany.html`

If you want more granular values, correct counts for 
https://sweet.ua.pt/tos/primes.html
