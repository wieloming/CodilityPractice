//TODO: one more time
//increase(X) − counter X is increased by 1,
//max counter − all counters are set to the
//maximum value of any counter.
//
//A non-empty zero-indexed array A of M

//if A[K] = X, such that 1 ≤ X ≤ N,
//then operation K is increase(X),
//if A[K] = N + 1 then operation K is max counter.
//
def solution(N: Int, A: Array[Int]) = {
  val counters = Array.fill(N)(0)
  var currentMax = 0
  var settledMax = 0
  for (n <- A) {
    if (n >= 1 && n <= N) {
      var oldValue = counters(n - 1)
      oldValue = oldValue max settledMax
      val newValue = oldValue + 1
      counters(n - 1) = newValue
      currentMax = currentMax max newValue
    } else if (n == N + 1) {
      settledMax = currentMax
    }
  }
  counters.map(c => if (c < settledMax) settledMax else c)
}
solution(5, Array(3, 4, 4, 6, 1, 4, 4)).toList
//For example, given integer N = 5
//A[0] = 3
//A[1] = 4
//A[2] = 4
//A[3] = 6
//A[4] = 1
//A[5] = 4
//A[6] = 4
//
//the values of the counters after each consecutive operation will be:
//(0, 0, 1, 0, 0)
//(0, 0, 1, 1, 0)
//(0, 0, 1, 2, 0)
//(2, 2, 2, 2, 2)
//(3, 2, 2, 2, 2)
//(3, 2, 2, 3, 2)
//(3, 2, 2, 4, 2)
//the function should return [3, 2, 2, 4, 2], as explained above.
//
//Assume that:
//
//N and M are integers within the range [1..100,000];
//each element of array A is an integer within the range [1..N + 1].
//
//Complexity:
//
//expected worst-case time complexity is O(N+M);