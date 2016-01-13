//TODO: do not zip iterators, it will blow!!
//TODO: toDouble!
//Let A be a non-empty zero-indexed
//array consisting of N integers.
//
//The abs sum of two for a pair of indices (P, Q)
//is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
//
//For example, the following array A:
//A[0] =  1
//A[1] =  4
//A[2] = -3
//
//has pairs of indices
//(0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
//The abs sum of two for the pair (0, 0) is
//A[0] + A[0] = |1 + 1| = 2.

//Write a function:
//
def solution(A: Array[Int]) = {
  val pairs = for(a <- A; b <- A) yield Math.abs(a.toDouble + b.toDouble)
  pairs.min.toInt
}
//solution(Array(1, 4, -3))
//solution(Array(0))
//
//that, given a non-empty zero-indexed array A
//consisting of N integers, returns the minimal
//abs sum of two for any pair of indices in this array.
//
//For example, given the following array A:
//A[0] =  1
//A[1] =  4
//A[2] = -3
//
//the function should return 1, as explained above.
//
// Given array A:
//A[0] = -8
//A[1] =  4
//A[2] =  5
//A[3] =-10
//A[4] =  3
solution(Array(-8,4,5,-10,3))
//the function should return |(−8) + 5| = 3.