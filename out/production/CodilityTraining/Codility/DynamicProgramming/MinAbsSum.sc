//TODO: refactor and one more time
//For a given array A of N integers and a sequence
//S of N integers from the set {−1, 1}, we define
//val(A, S) as follows:
//
//val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
//
//(Assume that the sum of zero elements equals zero.)
//
//For a given array A, we are looking for such a sequence
//S that minimizes val(A,S).
//
def solution(A: Array[Int]) = {
  val absA = A.map(Math.abs)
  val sum = absA.sum
  //table(i) = 1 if possible to achieve sum = i using elements of A, 0 otherwise
  val table = Array.fill(sum+1)(0)
  table(0) = 1
  absA.foreach { a =>
    for (i <- sum to 0 by -1) {
      val newSumInDpBounds = i + a < table.length && (i + a > 0)
      if (table(i) == 1 && newSumInDpBounds) table(i + a) = 1
    }
  }
  var result = sum
  for (i <- 0 until sum / 2 + 1) {
    if (table(i) == 1) result = Math.min(result, sum - 2 * i)
  }
  result
}
solution(Array(1, 5, 2, -2))
solution(Array(-100, 3, 2, 4))
//
//that, given an array A of N integers, computes the minimum
//value of val(A,S) from all possible values of val(A,S) for
//all possible sequences S of N integers from the set {−1, 1}.
//
//A[0] =  1
//A[1] =  5
//A[2] =  2
//A[3] = -2
//your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0,
// which is the minimum possible value.
//expected worst-case time complexity is O(N*max(abs(A))2);