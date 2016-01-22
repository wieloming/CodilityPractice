//TODO(solved): inersection also if just next to each other!!
//TODO(solved): use LONG!
//We draw N discs on a plane. The discs are numbered from 0 to N − 1.
//A zero-indexed array A of N non-negative integers, specifying
//the radiuses of the discs, is given. The J-th disc is drawn
// with its center at (J, 0) and radius A[J].
//
//We say that the J-th disc and K-th disc intersect if J ≠ K and
//the J-th and K-th discs have at least one common point (assuming
//that the discs contain their borders).
//
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
//Write a function:
//
def solution(A: Array[Int]): Int = {
  def intersects(center1: Long, rad1: Long, center2: Long, rad2: Long): Boolean = {
    val r1 = center1 + rad1
    val l2 = center2 - rad2
    r1 >= l2
  }
  if(A.isEmpty) return 0
  var intersections = 0
  for (x <- A.indices) {
    for (y <- x+1 until A.length) {
      if (intersects(x, A(x), y, A(y))) {
        intersections += 1
      }
    }
  }
  intersections
}
solution(Array(1, 5, 2, 1, 4, 0))
solution(Array(1))
solution(Array(1, 1, 1))
solution(Array(1, 2147483647, 0))
//that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
//
//Given array A shown above, the function should return 11, as explained above.
//
//  Assume that:
//
//  N is an integer within the range [0..100,000];
//each element of array A is an integer within the range [0..2,147,483,647].
//
