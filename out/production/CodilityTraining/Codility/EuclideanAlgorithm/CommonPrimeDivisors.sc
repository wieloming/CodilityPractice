//A prime is a positive integer X that has exactly two
//distinct divisors: 1 and X. The first few prime integers
//are 2, 3, 5, 7, 11 and 13.
//
//A prime D is called a prime divisor of a positive integer
//P if there exists a positive integer K such that D * K = P.
//For example, 2 and 5 are prime divisors of 20.
//
//You are given two positive integers N and M. The goal is
//to check whether the sets of prime divisors of integers
//N and M are exactly the same.

//N = 15 and M = 75, the prime divisors are the same: {3, 5};
//N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
//N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.

import annotation.tailrec

def solution(A: Array[Int], B: Array[Int]): Int = {
  def factorize(x: Int): List[Int] = {
    @tailrec
    def foo(x: Int, a: Int = 2, list: List[Int] = Nil): List[Int] = a * a > x match {
      case false if x % a == 0 => foo(x / a, a, a :: list)
      case false => foo(x, a + 1, list)
      case true => x :: list
    }
    foo(x).distinct
  }
  (A zip B).view.par.count { case (a, b) => factorize(a) == factorize(b) }
}
solution(Array(15, 10, 3), Array(75, 30, 5))
//A[0] = 15   B[0] = 75
//A[1] = 10   B[1] = 30
//A[2] = 3    B[2] = 5
//the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
//
//Assume that:
//
//  Z is an integer within the range [1..6,000];
//each element of arrays A, B is an integer within the range [1..2,147,483,647].
//Complexity:
//
//  expected worst-case time complexity is O(Z*log(max(A)+max(B))2);