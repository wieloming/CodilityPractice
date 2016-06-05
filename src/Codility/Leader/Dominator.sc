//TODO: good, but one more time
//A zero-indexed array A consisting of N
//integers is given. The dominator of array
//A is the value that occurs in more than half
//of the elements of A.
//
//A[0] = 3    A[1] = 4    A[2] =  3
//A[3] = 2    A[4] = 3    A[5] = -1
//A[6] = 3    A[7] = 3
//
//The dominator of A is 3 because it occurs in 5
//out of 8 elements of A (namely in those with
//indices 0, 2, 4, 6 and 7) and 5 is more than
//a half of 8.
//

import collection._

def solution(A: Array[Int]): Int = {
  if(A.isEmpty) return -1
  val freqs = A.foldLeft(mutable.Map[Int, Int]().withDefaultValue(0)) { (acc, el) =>
    acc(el) += 1
    acc
  }
  val dominator = freqs.maxBy(_._2)
  if (dominator._2 > A.length / 2) A.indexOf(dominator._1)
  else -1
}
solution(Array(3, 4, 3, 2, 3, -1, 3, 3))
solution(Array(3))
//For example, given array A such that
//A[0] = 3    A[1] = 4    A[2] =  3
//A[3] = 2    A[4] = 3    A[5] = -1
//A[6] = 3    A[7] = 3
//
//the function may return 0, 2, 4, 6 or 7, as explained above.
//
//  Complexity:
//
//  expected worst-case time complexity is O(N);