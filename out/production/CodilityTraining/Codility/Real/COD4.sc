def solution(A: Array[Int]) = {
  var res = -1
  for (i <- 1 until A.length) {
    val (a, b) = A.splitAt(i)
    val difference = Math.abs(a.max - b.max)
    res = Math.max(difference, res)
  }
  res
}
solution(Array(1, 3, -3))
solution(Array(4,3,2,5,1,1))
solution(Array(1))
solution(Array(1))