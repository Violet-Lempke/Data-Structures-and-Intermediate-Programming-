
# Commands

Try the following commands:

```
mvn verify
mvn test
mvn checkstyle:checkstyle
mvn exec:java
mvn clean
```

## Some Facts

There are 1229 primes under 10,000.
There are 78,498 primes under a million.
There are 664,579 primes under 10 million.
There are 5,761,455 primes under 100 million.
There are 50,847,534 primes under a billion.

ref: https://t5k.org/howmany.html

## Notes on Finding Primes

To find the prime numbers up to an integer xx:

**Plan A: Brute Force**

 - For each integer cc in (2..xx), attempt trial division by each integer
   in (2..cc-1).
 - If it has another factor it's not a prime.
 - If it has no factor, it is a prime.

**Plan B: Limit search range to ceil(sqrt(xx))**

 - Only attempt trial division by integers in range (2..ceil(sqrt(cc))).
 - If there's a factor more than sqrt(cc), then there must be a matching factor
   less than sqrt(cc).

**Plan C: Only check odd numbers > 2**

 - Even numbers over two aren't prime, and this cuts our work in half.
 
**Plan D: Add multiple threads**

 - Should speed us up by a factor equal to the number of threads we have.

**Plan E: Only attempt trial divisions by prime numbers.**
