//TODO: one more time
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 4
//A[4] = 3
//
//We can split this tape in four places:
//
//P = 1, difference = |3 − 10| = 7
//P = 2, difference = |4 − 9| = 5
//P = 3, difference = |6 − 7| = 1
//P = 4, difference = |10 − 3| = 7
//
//Write a function:
//
def solution(A: Array[Int]): Int ={
  if(A.length == 1) -1
  else{
    var first = A.head
    var second = A.sum - first
    var result = Math.abs(first - second)
    for(n <- A.tail.init){
      first += n
      second -= n
      if(Math.abs(first - second) < result) result = Math.abs(first - second)
    }
    result
  }
}
solution(Array(3,1,2,4,3))
solution(Array(3))
solution(Array(3,1))
solution(Array(-1000, 1000))
solution(Array(-10, -20, -30, -40, 100))
//that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
//
//For example, given:
//A[0] = 3
//A[1] = 1
//A[2] = 2
//A[3] = 4
//A[4] = 3
//
//the function should return 1, as explained above.
//
//  Assume that:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range
//[−1,000..1,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);