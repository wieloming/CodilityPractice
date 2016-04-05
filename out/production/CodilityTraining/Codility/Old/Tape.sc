//TODO: running time
//TODO: understand and refactor second solution

//  Any integer P, such that 0 < P < N, splits this tape

// It is the absolute difference between
// the sum of the first part and the sum of the second part.
//  A[0] = 3
//  A[1] = 1
//  A[2] = 2
//  A[3] = 4
//  A[4] = 3

//We can split this tape in four places:
//P = 1, difference = |3 − 10| = 7
//P = 2, difference = |4 − 9| = 5
//P = 3, difference = |6 − 7| = 1
//P = 4, difference = |10 − 3| = 7

def solution(A: Array[Int]): Int = {
  def splitSums(array: Array[Int]) = {
    array
      .indices
      .map(i => array.splitAt(i + 1))
      .map { case (a1, a2) => List(a1.sum, a2.sum) }
      .init
  }
  if (A.isEmpty || A.length == 1) -1
  else
    splitSums(A)
    .map(s => Math.abs(s.reduce(_ - _)))
    .min
}
def solution2(A: Array[Int]): Int = {
  val N = A.length
  val sum = A.sum
  var left = sum - A(N - 1)
  var right = A(N - 1)
  var min = math.abs(left - right)
  for (ind <- N - 2 to 1 by -1) {
    left -= A(ind)
    right += A(ind)
    min = math.min(min, math.abs(left - right))
  }
  min
}
solution(Array(3))
solution(Array(3, 1))























