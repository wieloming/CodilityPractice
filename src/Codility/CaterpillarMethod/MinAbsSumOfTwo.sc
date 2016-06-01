//TODO: one more time
//The abs sum of two for a pair of indices (P, Q)
//is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
//
//A[0] =  1
//A[1] =  4
//A[2] = -3
//has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
//The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
//The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
//The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
//The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
//The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
//The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.

def solution(A: Array[Int]): Int = {
  val array = A.sorted
  var headIndex = 0
  var lastIndex = array.length - 1
  var min = Math.abs(array(headIndex) + array(lastIndex))
  while(headIndex <= lastIndex){
    val sum = array(headIndex) + array(lastIndex)
    min = Math.min(min, Math.abs(sum))
    if(sum > 0)  lastIndex -=1
    else headIndex += 1
  }
  min
}
solution(Array(1,4,-3))
solution(Array(-8,4,5,-10,3))
//the function should return 1, as explained above.
//A[0] = -8
//A[1] =  4
//A[2] =  5
//A[3] =-10
//A[4] =  3
//the function should return |(−8) + 5| = 3.
//
//Assume that:
//
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
//Complexity:
//
//  expected worst-case time complexity is O(N*log(N));