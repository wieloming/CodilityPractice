//TODO: one more time
//contains daily prices of a stock share
//for a period of N consecutive days. If
//a single share was bought on day P and
//sold on day Q, where 0 ≤ P ≤ Q < N, then
//the profit of such transaction is equal
//to A[Q] − A[P], provided that A[Q] ≥ A[P].
//Otherwise, the transaction brings loss
//of A[P] − A[Q].
//
//For example, consider the following array A consisting of six elements such that:
//A[0] = 23171
//A[1] = 21011
//A[2] = 21123
//A[3] = 21366
//A[4] = 21013
//A[5] = 21367
//
//If a share was bought on day 0 and sold on day 2,
//a loss of 2048 would occur because
//A[2] − A[0] = 21123 − 23171 = −2048.
//If a share was bought on day 4 and sold on day 5,
//a profit of 354 would occur because
//A[5] − A[4] = 21367 − 21013 = 354. Maximum possible
//profit was 356. It would occur if a share was bought
//on day 1 and sold on day 5.
def solution(A: Array[Int]) = {
  if (A == null || A.length == 0) 0
  else {
    def removePreviousFromEach(A: Array[Int]): Array[Int] = {
      var prev = A(0)
      for (ind <- 1 until A.length) {
        val current = A(ind)
        A(ind) = current - prev
        prev = current
      }
      A
    }
    val differences = removePreviousFromEach(A)
    var maxProfit = 0
    var maxSlice = 0
    for (ind <- 1 until differences.length) {
      maxSlice = math.max(0, maxSlice + differences(ind))
      maxProfit = math.max(maxProfit, maxSlice)
    }
    maxProfit
  }
}
solution(Array(23171, 21011, 21123, 21366, 21013, 21367))
//
//maximum possible profit from one transaction during this period.
//The function should return 0 if it was impossible to gain any profit.
//
//the function should return 356, as explained above.
//expected worst-case time complexity is O(N);