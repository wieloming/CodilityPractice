//TODO(done): znowu polecenie! slice obejmuje też cały array ≤
//TODO(done): [-2, -2] - to powinno dać -2 a nie 0 :/
//A non-empty zero-indexed array A consisting of N integers is given.
//A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N,
//is called a slice of array A. The sum of a slice (P, Q)
//is the total of A[P] + A[P+1] + ... + A[Q].
//
//  Write a function:
//
def solution(A: Array[Int]): Int = {
  var max = Int.MinValue
  if(A.length == 1) return A.head
  for(x <- 0 to A.length; y <- x to A.length){
    val localMax = A.slice(x, x + y) match {
      case Array() => Int.MinValue
      case a => a.sum
    }
    if(localMax > max) max = localMax
  }
  max
}
//
//that, given an array A consisting of N integers,
//returns the maximum sum of any slice of A.
//
//For example, given array A such that:
//A[0] = 3  A[1] = 2  A[2] = -6
//A[3] = 4  A[4] = 0
solution(Array(3,2,-6,4,0)) == 5
//solution(Array()) == 0
solution(Array(-221, 3)) == 3
solution(Array(1, 1)) == 2
solution(Array(-2, -2)) == -2
solution(Array(-2, 1, -2)) == 1
//the function should return 5 because:
//
//(3, 4) is a slice of A that has sum 4,
//(2, 2) is a slice of A that has sum −6,
//(0, 1) is a slice of A that has sum 5,
//no other slice of A has sum greater than (0, 1).
//
// Assume that:
//
//N is an integer within the range [1..1,000,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000];
//the result will be an integer within the range [−2,147,483,648..2,147,483,647].
//
//Complexity:
//
//expected worst-case time complexity is O(N);
//expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//
