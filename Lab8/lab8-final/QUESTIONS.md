

## Questions


**What is the asymptotic complexity of BinTreeIterator#next as you've written it?**
The asymptotic complexity of BinTreeIterator#next is o(n).

**Could BinTreeIterator#next be more efficient than that?**
I don't think there is a more efficient way to do this as the iterator has to pass through every item.

**What is the asymptotic complexity of each set method you implemented in ConsSet?**
isEmpty() O(1)
size() O(1)
add() O(n) 
remove() O(n)
contains() O(n)
union() O(n)
intersection() O(n)
isSubset() O(n)
isSuperset()  O(n)


**Could your ConsSet methods be more efficient than that?**
I think my ConsSet could be more efficient. To be specific if I had implemented my is SubSet to utilize contains() I believe it could have been amortized O(1). I think the other O(n) methods are generally as efficient as they could be due to the restrictions of ConsSets.

**What is the asymptotic complexity of each set method you implemented in TreeSet?**
add() O(1)
remove O(1)
contains O(n)
union() O(1)
intersection O(n)
isSubset O(n)
isSuperSet O(n) (Would this be O(1) since it does the same amount of things everytime, or O(n) because the method it calls is O(n)?)

size() O(1)


**Could your TreeSet methods be more efficient than that?**
I think there is always a way to make my work more efficient, however I can not think of any ways to make it more efficient. I'm hoping to improve my skills in recognizing complexity and making things more efficient. 