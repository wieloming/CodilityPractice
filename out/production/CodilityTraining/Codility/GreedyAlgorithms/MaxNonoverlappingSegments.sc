//TODO: one more time
//Located on a line are N segments, numbered from 0 to N − 1,
//whose positions are given in zero-indexed arrays A and B.
//For each I (0 ≤ I < N) the position of segment I is from
//A[I] to B[I] (inclusive). The segments are sorted by their
//ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.
//
//We say that the set of segments is non-overlapping if it
//contains no two overlapping segments. The goal is to find
//the size of a non-overlapping set containing the maximal number of segments.
//
//A[0] = 1    B[0] = 5
//A[1] = 3    B[1] = 6
//A[2] = 7    B[2] = 8
//A[3] = 9    B[3] = 9
//A[4] = 9    B[4] = 10
//
//The size of a non-overlapping set containing a
//maximal number of segments is 3. For example,
//possible sets are
//{0, 2, 3}, {0, 2, 4}, {1, 2, 3}, {1, 2, 4}.
//There is no non-overlapping set with four segments.
def solution(A: Array[Int], B: Array[Int]): Int = {
  if(A.length < 2) return A.length
  val pairs = A zip B
  var nonOverlapping = 1
  var previousEnd = B.head
  for ((a,b) <- pairs.tail) {
    if (a > previousEnd) {
      nonOverlapping += 1
      previousEnd = b
    }
  }
  nonOverlapping
}
solution(Array(1,3,7,9,9), Array(5,6,8,9,10))
solution(Array(), Array())
//returns the size of a non-overlapping set containing a maximal number of segments.
//should return 3
//  expected worst-case time complexity is O(N);