def solution(A: Array[Int], M: Int) = {
  def isSubsetCorrect(A: Array[Int]): Boolean = {
    for(a <- A){
      if(A.exists(el => Math.abs(el - a) % M != 0)) return false
    }
    true
  }
  val allCombinations = A.permutations.flatMap(_.tails).flatMap(_.inits)
  allCombinations.filter(isSubsetCorrect).map(_.length).max
}
solution(Array(-3,-2,1,0,8,7,1), 3)
solution(Array(), 3)