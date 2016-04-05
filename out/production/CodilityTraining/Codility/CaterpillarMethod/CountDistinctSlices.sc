//TODO: one more time
//An integer M and a non-empty zero-indexed array A
//consisting of N non-negative integers are given.
//All integers in array A are less than or equal to M.
//
//A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N,
//is called a slice of array A. The slice consists of the
//elements A[P], A[P + 1], ..., A[Q]. A distinct slice
//is a slice consisting of only unique numbers. That is,
//no individual number occurs more than once in the slice.
//
//For example, consider integer M = 6 and array A such that:
// 3 4 5 5 2
//There are exactly nine distinct slices:
//(0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
//
//The goal is to calculate the number of distinct slices.
//
def solution(M: Int, A: Array[Int]): Int = {
  val used = Array.ofDim[Boolean](M + 1)
  var distinctSliceNum = 0
  var backInd = 0
  def decrBack(backInd: Int) = {
    used(A(backInd)) = false
    backInd + 1
  }
  for (frontInd <- A.indices) {
    while (used(A(frontInd))) backInd = decrBack(backInd)
    used(A(frontInd)) = true
    distinctSliceNum += frontInd - backInd + 1
    if (distinctSliceNum > 1000000000) return 1000000000
  }
  distinctSliceNum
}
solution(6, Array(3, 4, 5, 5, 2))
//
//that, given an integer M and a non-empty zero-indexed array A consisting of
//N integers, returns the number of distinct slices.
//
//  expected worst-case time complexity is O(N);