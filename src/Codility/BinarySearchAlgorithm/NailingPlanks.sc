//TODO: slower with .par why?
//You are given two non-empty
//A[K] is the start and B[K] the end of the K−th plank.
//
//non-empty array C consisting of M integers.
//This array represents M nails. More precisely, C[I]
//is the position where you can hammer in the I−th nail.
//
//We say that a plank (A[K], B[K]) is nailed if
//there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
//
//you should find a value J such that all planks will be
//nailed after using only the first J nails. More precisely,
//for every plank (A[K], B[K]) such that 0 ≤ K < N, there should
//exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
def solution(A: Array[Int], B: Array[Int], C: Array[Int]): Int = {
  var fence = A zip B
  def removePlanks(fence: Array[(Int, Int)], nail: Int): Array[(Int, Int)] = {
    fence.filterNot{case (a, b) => a <= nail && b >= nail}
  }
  var n = 0
  while(fence.nonEmpty){
    if(n > C.length-1) return -1
    fence = removePlanks(fence, C(n))
    n += 1
  }
  n
}
solution(Array(1,4,5,8), Array(4,5,9,10), Array(4,6,7,10,2))
solution(Array(2), Array(2), Array(1))
//four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
//
//C[0] = 4 C[1] = 6
//C[2] = 7 C[3] = 10
//C[4] = 2
//0, then planks [1, 4] and [4, 5] will both be nailed.
//0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
//0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
//0, 1, 2, 3, then all the planks will be nailed.

//  expected worst-case time complexity is O((N+M)*log(M));