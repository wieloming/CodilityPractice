def solution(A: Int, B: Int) = {
  def isWholeSquare(n: Int): Boolean = {
    val sqrtN = Math.sqrt(n).toLong
    sqrtN*sqrtN == n
  }
  if(A == B) if(isWholeSquare(A)) 1 else 0
  else (A to B).par.count(isWholeSquare)
}
solution(4, 17)
solution(4, 4)
solution(-1000, -1)