import scala.annotation.tailrec
import scala.collection.mutable

//You have to climb up a ladder.
//with your first step you can stand on rung 1 or 2,
//if you are on rung K, you can move to rungs K + 1 or K + 2,
//finally you have to stand on rung N.

//Given N = 5, you have eight different ways of climbing,
//ascending by:
//
//1, 1, 1, 1 and 1 rung,
//1, 1, 1 and 2 rungs,
//1, 1, 2 and 1 rung,
//1, 2, 1 and 1 rung,
//1, 2 and 2 rungs,
//2, 1, 1 and 1 rungs,
//2, 1 and 2 rungs, and
//2, 2 and 1 rung.
//
//The number of different ways can be very large,
//so it is sufficient to return the result modulo 2P,
//for a given integer P.
//
//Write a function:
//
def solution(A: Array[Int], B: Array[Int]): Array[Int] = {
  def helper(N: Int): Int = {
    val resultFor1 = 1
    val resultFor2 = 2
    if (N == 1) return resultFor1
    if (N == 2) return resultFor2
    val previous = mutable.MutableList(resultFor1, resultFor2)
    var current = 2
    while(current < N){
      val preTotal = previous.head + previous(1)
      previous(0) = previous(1)
      previous(1) = preTotal
      current += 1
    }
    previous(1)
  }
  (A zip B) map { case (a, b) => (helper(a) % Math.pow(2,b)).toInt }
}
//
//that, given two non-empty zero-indexed arrays A and B of L integers,
//returns an array consisting of L integers specifying the consecutive
//answers; position I should contain the number of different ways of
//climbing the ladder with A[I] rungs modulo 2B[I].
//
//For example, given L = 5 and:
//A[0] = 4   B[0] = 3
//A[1] = 4   B[1] = 2
//A[2] = 5   B[2] = 4
//A[3] = 5   B[3] = 3
//A[4] = 1   B[4] = 1
solution(Array(4, 4, 5, 5, 1), Array(3, 2, 4, 3, 1))
//the function should return the sequence [5, 1, 8, 0, 1], as explained above.
//
//  Assume that:
//
//L is an integer within the range [1..30,000];
//each element of array A is an integer within the range [1..L];
//each element of array B is an integer within the range [1..30].
//
//Complexity:
//
//  expected worst-case time complexity is O(L);