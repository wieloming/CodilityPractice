//TODO: one more time
//For each number A[i] such that 0 ≤ i < N,
//we want to count the number of elements of
//the array that are not the divisors of A[i].
//We say that these elements are non-divisors.
//
//For example, consider integer N = 5 and array A such that:
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 3
//A[4] = 6
//
//A[6] = 6, there aren't any non-divisors.
//A[3] = 3, the non-divisors are: 2, 6,
//A[0] = 3, the non-divisors are: 2, 6,
//A[2] = 2, the non-divisors are: 3, 3, 6,
//A[1] = 1, the non-divisors are: 3, 2, 3, 6,

//
import scala.collection.mutable

def solution(A: Array[Int]): Array[Int] = {
  if (A.length == 1) return Array(0)
  val sorted = A.sorted(Ordering[Int].reverse).view
  val map = mutable.Map[Int, Int]()
  var previous = (Int.MinValue, Int.MinValue)
  for (n <- sorted.indices) {
    val el = sorted(n)
    if (el == previous._1) map(previous._1) = previous._2
    else {
      val rest = sorted.drop(n + 1)
      val deviders = rest.count(el % _ == 0)
      val res = A.length - 1 - deviders
      map(el) = res
      previous = (sorted(n), res)
    }
  }
  A.map(map)
}
solution(Array(3, 1, 2, 3, 6))
//2, 4, 3, 2, 0
//  expected worst-case time complexity is O(N*log(N))