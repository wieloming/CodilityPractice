//TODO: one more time
def solution(A: Array[Int]): Int = {
  val sorted = A.sorted
  val smallestIndex = sorted.indexWhere(_ > 0)
  if(smallestIndex < 0) return 1
  if(sorted(smallestIndex) > 1) return 1
  for(n <- smallestIndex until A.length-1){
    if(sorted(n+1) > sorted(n) + 1) return sorted(n) + 1
  }
  sorted.last + 1
}
//
//that, given a non-empty zero-indexed array
//A of N integers, returns the minimal positive
//integer (greater than 0) that does not occur in A.
//
//For example, given:
//A[0] = 1
//A[1] = 3
//A[2] = 6
//A[3] = 4
//A[4] = 1
//A[5] = 2
solution(Array(0))
solution(Array(-2,-3,-5,1,3,6,4,1,2))
solution(Array(-2,-3,-5))
solution(Array(1,1,1,1,1,1,1,1,1,1,1,1,1))
solution(Array(2,3,4,5,6))
solution(Array(3,3,4,5,6))
//the function should return 5.
//
//Assume that:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);