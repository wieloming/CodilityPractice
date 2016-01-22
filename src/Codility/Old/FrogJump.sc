//TODO: performance: 60%
//TODO: understand and refactor second solution
//For example, you are given integer X = 5 and array A such that:
//A[0] = 1 A[1] = 3 A[2] = 1 A[3] = 4
//A[4] = 2 A[5] = 3 A[6] = 5 A[7] = 4
//
//In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
//
//  Write a function:
//
def solution(X: Int, A: Array[Int]): Int = {
  if (A.length < X) return -1
  var correct = (1 to X).toList
  var second = -1
  while (correct.nonEmpty) {
    second += 1
    if (second > A.length - 1) return -1
    correct = correct.filterNot(_ == A(second))
  }
  second
}
def solution2(X: Int, A: Array[Int]): Int = {
  val leaves = Array.fill(X)(-1)
  A.indices.foreach { ind =>
    if (leaves(A(ind) - 1) == -1)
      leaves(A(ind) - 1) = ind
  }
  var min = -1
  for (t <- leaves) {
    if (t == -1) {
      return -1
    }
    min = math.max(min, t)
  }
  min
}
//For example, given X = 5 and array A such that:
//A[0] = 1
//A[1] = 3
//A[2] = 1
//A[3] = 4
//A[4] = 2
//A[5] = 3
//A[6] = 5
//A[7] = 4
solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)) == 6
solution(1, Array(1, 3, 4, 2, 3, 5, 4)) == 0
solution(5, Array()) == -1
solution(1, Array(1)) == 0
solution(1, Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
solution(17, Array(32, 32, 32, 32, 32, 32, 32, 32))
solution(5, Array(1, 3, 4, 2, 3, 4)) == 0
//the function should return 6, as explained above.
