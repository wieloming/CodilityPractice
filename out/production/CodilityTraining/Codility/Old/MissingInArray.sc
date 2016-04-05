// The array contains integers in the range [1..(N + 1)],
// which means that exactly one element is missing.
//
//Your goal is to find that missing element.
//
//Write a function
//that, given a zero-indexed array A, returns the value of the missing element.
//
//For example, given array A such that:
//
//  A[0] = 2
//  A[1] = 3
//  A[2] = 1
//  A[3] = 5
//the function should return 4, as it is the missing element.

def solution(array: Array[Int]): Int = {
  if (array.isEmpty) 1
  else if(array.min != 1) 1
  else if (array.max != array.length + 1) array.length + 1
  else (1 to array.length + 1).sum - array.sum
}

solution(Array(2,3,1,5))























