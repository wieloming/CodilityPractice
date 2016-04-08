//inversion is a pair of indexes (P, Q)
//such that P < Q and A[Q] < A[P].
//
def solution(A: Array[Int]):Int = {
  var res = 0L
  for(i <- 0 until (A.length - 1); j <- i + 1 until + A.length){
    if(res > 1000000000L) return -1
    if(A(j) < A(i)) res += 1
  }
  res.toInt
}

solution(Array(-1,6,3,4,7,4))
//
//computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
//
// -1 6 3 4 7 4
//there are four inversions:
//(1,2)  (1,3)  (1,5)  (4,5)
//so the function should return 4.
//
//Complexity:
//
//  expected worst-case time complexity is O(N*log(N));