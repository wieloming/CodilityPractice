//TODO: when adding Ints... first, .toLong
//A zero-indexed array A consisting of N integers
//is given. A triplet (P, Q, R) is triangular
//if 0 ≤ P < Q < R < N and:
//A[P] + A[Q] > A[R],
//A[Q] + A[R] > A[P],
//A[R] + A[P] > A[Q].
//
//For example, consider array A such that:
//A[0] = 10    A[1] = 2    A[2] = 5
//A[3] = 1     A[4] = 8    A[5] = 20
//
//Triplet (5, 8, 10) is triangular.

def solution(A: Array[Int]):Int = {
  val L = A.length
  if(L < 3) 0
  else{
    val sorted = A.sorted
    for(i <- 0 until L - 2){
      val P = sorted(i).toLong
      val Q = sorted(i+1).toLong
      val R = sorted(i+2).toLong
      if((P+Q>R)&&(R+Q>P)&&(P+R>Q)) return 1
    }
    0
  }
}
solution(Array(10,2,5,1,8,20))
//returns 1 if there exists a triangular triplet
//for this array and returns 0 otherwise.
//expected worst-case time complexity is O(N*log(N));