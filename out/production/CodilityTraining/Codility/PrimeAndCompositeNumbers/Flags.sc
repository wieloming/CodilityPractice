//TODO: one more time
//A peak is an array element which is larger
//than its neighbours.
//
//For example, the following array A:
//A[0] = 1 A[1] = 5 A[2] = 3 A[3] = 4
//A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2
//A[8] = 3 A[9] = 4 A[10] = 6 A[11] = 2
//
//has exactly four peaks: elements 1, 3, 5 and 10.
//
//Flags can only be set on peaks. What's more, if you take
//K flags, then the distance between any two flags should be
//greater than or equal to K. The distance between indices
//P and Q is the absolute value |P − Q|.

//two flags, you can set them on peaks 1 and 5;
//three flags, you can set them on peaks 1, 5 and 10;
//four flags, you can set only three flags, on peaks 1, 5 and 10.
//
//You can therefore set a maximum of three flags in this case.

def solution(A: Array[Int]) = {
  def isPeakArray: Array[Boolean] = {
    val peaks = Array.fill(A.length)(false)
    for (i <- 1 until A.length - 1) {
      val prev = A(i - 1)
      val curr = A(i)
      val next = A(i + 1)
      if (curr > prev && curr > next) peaks(i) = true
    }
    peaks
  }
  val isPeak = isPeakArray
  def canSetFlags(n: Int): Boolean = {
    var i = 0
    var flags = n
    while (flags > 0 && i < A.length) {
      if (isPeak(i)) {
        flags -= 1
        i += n
      } else i += 1
    }
    flags == 0
  }
  Iterator.from(1).find(!canSetFlags(_)).get - 1
}
solution(Array(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2))
//that, given a non-empty zero-indexed array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.
//the function should return 3, as explained above.
//  expected worst-case time complexity is O(N);