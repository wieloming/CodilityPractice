//TODO: one more time
//A non-empty zero-indexed array A consisting of N
//integers is given. A pair of integers (P, Q), such
//that 0 ≤ P < Q < N, is called a slice of array A
//(notice that the slice contains at least two elements).
//The average of a slice (P, Q) is the sum of
//A[P] + A[P + 1] + ... + A[Q] divided by the length
//of the slice. To be precise, the average equals
//(A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
//
//For example, array A such that:
//A[0] = 4
//A[1] = 2
//A[2] = 2
//A[3] = 5
//A[4] = 1
//A[5] = 5
//A[6] = 8
//
//contains the following example slices:
//
//slice (1, 2), whose average is (2 + 2) / 2 = 2;
//slice (3, 4), whose average is (5 + 1) / 2 = 3;
//slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
def solution(A: Array[Int]): Int = {
  var minAvg = (A(0) + A(1)) / 2.0
  var minIndex = 0

  for (i <- 1 until A.length) {
    var avg = (A(i) + A(i - 1)) / 2.0
    if (avg < minAvg) {
      minIndex = i - 1
      minAvg = avg
    }
    if (i >= 2) {
      avg = (A(i) + A(i - 1) + A(i - 2)) / 3.0
      if (avg < minAvg) {
        minIndex = i - 2
        minAvg = avg
      }
    }
  }
  minIndex
}
solution(Array(-3, -5, -8, -4, -10)) == 2
solution(Array(4, 2, 2, 5, 1, 5)) == 1
solution(Array(4, 2, 5, 1, 1, 1, 9)) == 3
solution(Array(9, 9)) == 0
solution(Array(1, 1, 9, 9, 9, 9)) == 0
solution(Array(1, 1, 9, 9, 9, 0, 0)) == 5
//
//that, given a non-empty zero-indexed array A consisting of N integers,
//returns the starting position of the slice with the minimal average.
//If there is more than one slice with a minimal average, you should return
//the smallest starting position of such a slice.
//
//For example, given array A such that:
//A[0] = 4
//A[1] = 2
//A[2] = 2
//A[3] = 5
//A[4] = 1
//A[5] = 5
//A[6] = 8
//
//the function should return 1, as explained above.
//
//  Assume that:
//
//  N is an integer within the range [2..100,000];
//each element of array A is an integer within the range [−10,000..10,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);