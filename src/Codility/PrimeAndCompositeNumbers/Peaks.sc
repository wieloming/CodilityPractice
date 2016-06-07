def solution(A: Array[Int]): Int = {
  if(A.length < 3) 0
  else {
    val peaks = Array.fill[Boolean](A.length)(false)
    for(i <- 1 until A.length - 1){
      val prev = A(i-1)
      val curr = A(i)
      val next = A(i+1)
      if(prev < curr && next < curr) peaks(i) = true
    }
    def canDivide(a: Array[Boolean], n: Int) = {
      if(a.length % n != 0) false
      else a.grouped(n).forall(_.contains(true))
    }
    var i = 1
    while(!canDivide(peaks, i)){
      i += 1
      if(i > peaks.length) return 0
    }
    A.length / i
  }
}

solution(Array(1,2,3,4,3,4,1,2,3,4,6,2))
solution(Array(1,2,1))
solution(Array())
solution(Array(0))
//A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].
//
//For example, the following array A:
//
//A[0] = 1
//A[1] = 2
//A[2] = 3
//A[3] = 4
//A[4] = 3
//A[5] = 4
//A[6] = 1
//A[7] = 2
//A[8] = 3
//A[9] = 4
//A[10] = 6
//A[11] = 2
//has exactly three peaks: 3, 5, 10.
//
//We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:
//
//A[0], A[1], ..., A[K − 1],
//A[K], A[K + 1], ..., A[2K − 1],
//...
//A[N − K], A[N − K + 1], ..., A[N − 1].
//What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).
//
//  The goal is to find the maximum number of blocks into which the array A can be divided.
//
//Array A can be divided into blocks as follows:
//
//  one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
//  two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
//  three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
//  However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
//
//The maximum number of blocks that array A can be divided into is three.

