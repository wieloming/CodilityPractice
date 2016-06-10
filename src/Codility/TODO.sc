
//You are given a non-empty zero-indexed array A consisting of N integers.
//
//For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array
//that are not the divisors of A[i]. We say that these elements are non-divisors.
//
//  For example, consider integer N = 5 and array A such that:
//
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 3
//A[4] = 6
//For the following elements:
//
//  A[0] = 3, the non-divisors are: 2, 6,
//A[1] = 1, the non-divisors are: 3, 2, 3, 6,
//A[2] = 2, the non-divisors are: 3, 3, 6,
//A[3] = 3, the non-divisors are: 2, 6,
//A[4] = 6, there aren't any non-divisors.
//  Write a function:
//
def solution(A: Array[Int]): Array[Int] = {
  val sorted = A.sorted(Ordering[Int].reverse)
  val res = collection.mutable.Map[Int, Int]().withDefaultValue(0)
  for {
    i <- 0 until A.length - 1
    previous = if(i > 0) sorted(i-1) else Int.MinValue
    if sorted(i) != previous
  } {
      val value = sorted(i)
      res(value) = sorted.drop(i + 1).count(value % _ == 0)
  }
  A.map(i => A.length - 1 - res(i))
}
solution(Array(3, 1, 2, 3, 6))
solution(Array())
solution(Array(2,2,1,1))
//
//that, given a non-empty zero-indexed array A consisting of N integers, returns a
// sequence of integers representing the amount of non-divisors.
//
//  The sequence should be returned as:
//  For example, given:
//
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 3
//A[4] = 6
//the function should return [2, 4, 3, 2, 0], as explained above.