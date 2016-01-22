//TODO: performance: 20%
//You are given N counters, initially set to 0,
//and you have two possible operations on them:
//
//increase(X) − counter X is increased by 1,
//max counter − all counters are set to the maximum value of any counter.
//
//A non-empty zero-indexed array A of M integers is given.
//This array represents consecutive operations:
//
//if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
//if A[K] = N + 1 then operation K is max counter.
//
//For example, given integer N = 5 and array A such that:
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
//
//The goal is to calculate the value of every counter after all operations.
//
//  Write a function:
//
def solution(N: Int, A: Array[Int]): Array[Int] = {
  val counters = new Array[Int](N)
  var maxInCounter = 0
  var minCounterVal = 0
  A.foreach { value =>
    if (value != N + 1) {
      if (counters(value - 1) < minCounterVal) {
        counters(value - 1) = minCounterVal
      }
      counters(value - 1) += 1
      maxInCounter = math.max(maxInCounter, counters(value - 1))
    } else {
      minCounterVal = maxInCounter
    }
  }
  val counters2 = counters.map { c =>
    if (c < minCounterVal) minCounterVal
    else c
  }
  counters2
}
solution(5, Array(3, 4, 4, 6, 1, 4, 4))
//the function should return [3, 2, 2, 4, 2], as explained above.
//
//  Assume that:
//
//  N and M are integers within the range [1..100,000];
//each element of array A is an integer within the range [1..N + 1].
//
//Complexity:
//
//  expected worst-case time complexity is O(N+M);