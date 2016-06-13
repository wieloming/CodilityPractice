def solution(A: Array[Int]): Int = {
  def rec(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x::Nil => List(-x,x)
    case x :: xs => rec(xs).map(_ + -x) ++ rec(xs).map(_ + x)
  }
  rec(A.toList).map(Math.abs) match {
    case Nil => 0
    case x => x.min
  }
}
solution(Array(1, 5, 2, -2))
solution(Array())