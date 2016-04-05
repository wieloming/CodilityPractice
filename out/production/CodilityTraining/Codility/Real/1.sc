import annotation.tailrec
def solution(A: Array[Int]): Int = {
  @tailrec
  def helper(A: List[Int], headI: Int, lenght: Int): Int = {
    A match {
      case -1 :: x => 1
      case x :: xs if A(headI) == -1 => lenght + 1
      case x :: xs => helper(A, A(headI), lenght + 1)
    }
  }
  helper(A.toList, A.head, 1)
}
solution(Array(1, 4, -1, 3, 2))
solution(Array(1, 4, 3, -1, 2))
solution(Array(1, -1))
solution(Array(-1))