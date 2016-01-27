//TODO: FASTAH!!!
//The figure below shows discs drawn for N = 6 and A as follows:
//A[0] = 1
//A[1] = 5
//A[2] = 2
//A[3] = 1
//A[4] = 4
//A[5] = 0
//
//There are eleven (unordered) pairs of discs that intersect, namely:
//
//discs 1 and 4 intersect, and both intersect with all the other discs;
//disc 2 also intersects with discs 0 and 3.
//
def solution(A: Array[Int]): Int = {
  def intersects(x1: Double, r1: Double, x2: Double, r2: Double): Boolean = {
    x1 + r1 >= x2 - r2
  }
  val L = A.length
  var intersections = 0
  for (i <- 0 until L - 1) {
    val x1 = i
    val r1 = A(i)
    for (j <- i + 1 until L) {
      val x2 = j
      val r2 = A(j)
      if (intersects(x1, r1, x2, r2)) intersections += 1
    }
  }
  intersections
}
//solution(Array(1,5,2,1,4,0))
//solution(Array(1))
//solution(Array(0))
solution(Array(1, 2147483647, 0))
//
//Given array A shown above, the function should return 11, as explained above.
//
//  expected worst-case time complexity is O(N*log(N));