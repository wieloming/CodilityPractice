//An equilibrium index of this array is any integer P such that
// 0 ≤ P < N and the sum of elements of lower indices is equal
// to the sum of elements of higher indices, i.e.
//A[0] = -1
//A[1] =  3
//A[2] = -4
//A[3] =  5
//A[4] =  1
//A[5] = -6
//A[6] =  2
//A[7] =  1

//P = 7 is also an equilibrium index, because:
//
//  A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0

//For example, given array A shown above,
// the function may return 1, 3 or 7, as explained above.

def solution(A: Array[Int]): Int = {
  def sum(a: Array[Int]): Int = if(a.isEmpty) 0 else a.sum
  if (A.isEmpty) -1
  else
    A.indices.find { i =>
      val first = A.take(i)
      val second = A.drop(i + 1)
      sum(first) == sum(second)
    }.getOrElse(-1)
}

// for example on position 4 of A = [2, -1, -2, 1, 500]
solution(Array(2, -1, -2, 1, 500))
