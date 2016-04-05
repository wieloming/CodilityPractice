//TODO(solved): -1 while WRONG!!
def solution(A: Array[Int], B: Array[Int], C: Array[Int]): Int = {
  val J = C.length - 1
  var planks = A zip B
  def plank(planks: Array[(Int, Int)], I: Int): Array[(Int, Int)] = {
    planks.filterNot{case (a,b) => a <= C(I) && b >= C(I)}
  }
  var num = 0
  for(i <- 0 to J){
    num += 1
    planks = plank(planks, i)
    if(planks.isEmpty) return num
  }
  -1
}
//We say that a plank (A[K], B[K]) is nailed if
//there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
//
//The goal is to find the minimum number of nails
//that must be used until all the planks are nailed.
//In other words, you should find a value J such that all
//planks will be nailed after using only the first J nails.
//More precisely, for every plank (A[K], B[K])
//such that 0 ≤ K < N, there should exist a nail C[I]
//such that I < J and A[K] ≤ C[I] ≤ B[K].
//
//For example, given arrays A, B such that:
//A[0] = 1    B[0] = 4
//A[1] = 4    B[1] = 5
//A[2] = 5    B[2] = 9
//A[3] = 8    B[3] = 10
//
//four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
//
//Given array C such that:
//C[0] = 4
//C[1] = 6
//C[2] = 7
//C[3] = 10
//C[4] = 2
//
//if we use the following nails:
//
//0, then planks [1, 4] and [4, 5] will both be nailed.
//0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
//0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
//0, 1, 2, 3, then all the planks will be nailed.
solution(Array(1,4,5,8), Array(4,5,9,10), Array(4,6,7,10,2))
