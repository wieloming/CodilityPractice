// many bic to one rack
//chosen between first and last used (inclusive)

def solution(A: Array[Int]) = {
  val racks = (A.min to A.max).par.map(A.contains)
  val toRight = racks.scanLeft(0)((acc, el) => if(el) 0 else acc + 1)
  val toLeft = racks.scanRight(0)((el, acc) => if(el) 0 else acc + 1)
  (toRight zip toLeft).map{case (a, b) => Math.min(a, b)}.max
}

solution(Array(10,0,8,2, -1, 12, 11, 3))
solution(Array(5,5))