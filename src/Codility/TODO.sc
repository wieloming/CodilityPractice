import Utils.Performance._

def solution(A: Array[Int]): Int = {
  val set = scala.collection.mutable.Set[Int]()
  for (i <- A) {
    set.add(Math.abs(i))
  }
  set.size
}
def solution2(A: Array[Int]): Int = {
  A.map(Math.abs).distinct.length
}

time(solution(Array(-5, -3, -1, 0, 3, 6)), 100000)
time(solution2(Array(-5, -3, -1, 0, 3, 6)), 100000)
