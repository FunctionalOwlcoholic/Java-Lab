/* A short guide on how to implement a base converter in a recursive way */

// to convert a positive integer n into a new number with base b
// you must divide the original number n by its new base b and look at the quotient and remainder

// quotient = n / b
// remainder = n % b

// the value of the remainder represents the first symbol in our new number
// in the decimal system (base 10) we only have 10 different symbols (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
// if the value of the remainder requires two symbols, like 10 for instance,
// then we can denote that value as a single symbol such as "A"
// thus, 10 = A, 11 = B, 12 = C, and so on

// now that we have taken the remainder away from the original number and stored it somewhere
// the quotient now becomes our original number n and we repeat this process until the quotient is 0
// in which case the sequence of remainders will be our new number with the base b

// Example:
// n = 753, b = 16

// r = 753 % 16 = 1  → [..., 1]
// n = 753 / 16 = 47

// r = 47 % 16 = 15  → [..., 15, 1]
// n = 47 / 16 = 2

// r = 2 % 16 = 2    → [..., 2, 15, 1]
// n = 2 / 16 = 0

// n == 0 therefore we stop here
// now convert the current sequence of remainders [2, 15, 1] so that each value is represented by a single symbol
// 2 = 2, 15 = F, 1 = 1, therefore [2, 15, 1] → "2F1" is our new number with base b

// Hints:
// quotient == 0 would be the "base case" in a recursive method because it ends the cycle
// you can store the remainders in an int[] array and have a separate toString() or print() method that looks up the symbols
// alternatively, you can store the remainders in a string and look up the symbols during each recursive call
