def solution(A: Array[Int], B: Array[Int]): Int = {
  type Interval = (Int, Int)
  def merge(array: Array[(Int, Int)]) = {
    array
      .sortBy(_._1)
      .foldLeft(Array[Interval]()) { (merged, el) =>
        if (merged.isEmpty) merged :+ el
        else {
          val lower = merged.last
          if (el._1 <= lower._2) merged.init :+(lower._1, Math.max(lower._2, el._2))
          else merged :+ el
        }
      }
  }
  merge(A zip B).length
}
solution(Array(1, 12, 42, 70, 36, -4, 43, 15), Array(5, 15, 44, 72, 36, 2, 69, 24))