//A zero-indexed array A consisting of N integers is given.
//A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
//
//A[P] + A[Q] > A[R],
//A[Q] + A[R] > A[P],
//A[R] + A[P] > A[Q].
//  For example, consider array A such that:
//
//A[0] = 10    A[1] = 2    A[2] = 5
//A[3] = 1     A[4] = 8    A[5] = 12
//There are four triangular triplets that can be
//constructed from elements of this array, namely
//(0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
//
//10 2 5 1 8 12

def solution(A: Array[Int]) = {
  def isTraiangular(A: Int, B: Int, C: Int): Boolean = {
    (A + B > C) && (B + C > A) && (C + A > B)
  }
  var counter = 0
  for (p <- 0 until A.length - 2;
       q <- p + 1 until A.length - 1;
       r <- q + 1 until A.length) {
    if (isTraiangular(A(p), A(q), A(r))) counter += 1
  }
  counter
}
//solution(Array(3, 3, 5, 6))
solution(Array(10, 2, 5, 1, 8, 12))
//assert(solution(Array(1)) == 0)
//assert(solution(Array(5, 3, 2)) == 0)

//
//that, given a zero-indexed array A consisting of N integers,
// returns the number of triangular triplets in this array.
//
//the function should return 4, as explained above.
//  expected worst-case time complexity is O(N2);
