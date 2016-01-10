//TODO(solved): single element
//A non-empty zero-indexed array A consisting of N integers is given.
//A permutation is a sequence containing each element from 1 to N
//once, and only once.
//
//For example, array A such that:
//A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2
//is a permutation, but array A such that:
//A[0] = 4 A[1] = 1 A[2] = 3
//is not a permutation, because value 2 is missing.
// The goal is to check whether array A is a permutation.
def solution(A: Array[Int]): Int ={
  if(A.isEmpty) 0
  else if(A.length == 1 && A.head == 1) 1
  else if(A.length == 1) 0
  else if(A.view.sorted == (1 to A.length).view) 1
  else 0
}
//
//that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
//
//  For example, given array A such that:
//  A[0] = 4
//A[1] = 1
//A[2] = 3
//A[3] = 2
solution(Array(4,1,3,2))
//the function should return 1.
//
//Given array A such that:
//  A[0] = 4
//A[1] = 1
//A[2] = 3
solution(Array(4,3,1))
//the function should return 0.
//
//Assume that:
//
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [1..1,000,000,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);