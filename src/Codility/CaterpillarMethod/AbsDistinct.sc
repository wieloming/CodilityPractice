//A non-empty zero-indexed array A consisting of N
//numbers is given. The array is sorted in
//non-decreasing order. The absolute distinct
//count of this array is the number of distinct
//absolute values among the elements of the array.
//A[0] = -5 A[1] = -3
//A[2] = -1 A[3] =  0
//A[4] =  3 A[5] =  6
//The absolute distinct count of this array is 5,
//because there are 5 distinct absolute values
//among the elements of this array, namely 0, 1, 3, 5 and 6.
def solution(A: Array[Int]): Int = {
  A.map(Math.abs).distinct.length
}
def solution2(A: Array[Int]): Int = {
  val set = scala.collection.mutable.Set[Int]()
  for (i <- A) {
    set.add(Math.abs(i))
  }
  set.size
}
solution(Array(-5,-3,-1,0,3,6))
//the function should return 5, as explained above.

//  expected worst-case time complexity is O(N);