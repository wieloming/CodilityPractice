//TODO: how the fuck does it work?
//TODO: one more time
//A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N,
//is called a double slice.
//
//The sum of double slice (X, Y, Z) is the total of
//A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1]
//+ A[Y + 2] + ... + A[Z − 1].
//
//For example, array A such that:
//A[0] = 3
//A[1] = 2
//A[2] = 6
//A[3] = -1
//A[4] = 4
//A[5] = 5
//A[6] = -1
//A[7] = 2
//
//double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//double slice (3, 4, 5), sum is 0.
//
def solution(A: Array[Int]): Int = {
  val kadanes = (acc: Int, n: Int) => Math.max(0, acc + n)
  val middle = A.init.tail
  var max = 0

  val fromLeft = 0 +: middle.scanLeft(0)(kadanes)
  val fromRight = middle.scanRight(0)(kadanes) :+ 0

  for (i <- 1 until A.length - 1) {
    max = Math.max(max, fromLeft(i) + fromRight(i))
  }
  max
}
solution(Array(3, 2, 6, -1, 4, 5, -1, 2))
//the function should return 17, because no double slice
//of array A has a sum of greater than 17.
//
//  expected worst-case time complexity is O(N);
