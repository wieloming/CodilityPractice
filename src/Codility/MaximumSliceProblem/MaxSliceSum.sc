//A non-empty zero-indexed array A consisting of N
//integers is given. A pair of integers (P, Q), such
//that 0 ≤ P ≤ Q < N, is called a slice of array A.
//The sum of a slice (P, Q) is the total of
//A[P] + A[P+1] + ... + A[Q].
//
def solution(A: Array[Int]) = {
  if (A.length == 1) A.head
  else {
    var maxTillNow = A.head
    var max = A.head
    for (n <- A.tail) {
      maxTillNow = Math.max(n, maxTillNow + n)
      max = Math.max(max, maxTillNow)
    }
    max
  }
}
solution(Array(3, 2, -6, 4, 0)) == 5
solution(Array(3, 10, -1, 100, 0)) == 112
solution(Array(100, -10)) == 100
solution(Array(-2, 3)) == 3
solution(Array(-2, 3, 3, -2)) == 6
solution(Array(-2, 3, -2)) == 3
//that, given an array A consisting of N integers,
//returns the maximum sum of any slice of A.
//
//For example, given array A such that:
//A[0] = 3  A[1] = 2  A[2] = -6
//A[3] = 4  A[4] = 0
//
//the function should return 5 because:
//
//(3, 4) is a slice of A that has sum 4,
//(2, 2) is a slice of A that has sum −6,
//(0, 1) is a slice of A that has sum 5,
//no other slice of A has sum greater than (0, 1).
//expected worst-case time complexity is O(N);