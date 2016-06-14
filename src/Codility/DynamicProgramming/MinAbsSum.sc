def solution(A: Array[Int]): Int = {
  def rec(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x::Nil => List(-x,x)
    case x :: xs => rec(xs).map(_ + -x) ++ rec(xs).map(_ + x)
  }
  rec(A.toList) match {
    case Nil => 0
    case x => Math.abs(x.minBy(Math.abs))
  }
}
solution(Array(1, 5, 2, -2))
solution(Array())