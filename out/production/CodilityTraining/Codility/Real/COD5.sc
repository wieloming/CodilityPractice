def solution(A: Array[Int]) = {
  A.inits.flatMap(_.tails).count(a => a.nonEmpty && a.sum == 0)
}
def solution2(A: Array[Int]) = {
  var num = 0
  for(i <- 0 to A.length; j <- i+1 to A.length){
    if(A.slice(i, j).sum == 0) num += 1
  }
  num
}
solution2(Array(2,-2,3,0,4,-7))
solution2(Array(2))
solution2(Array(0))
solution2(Array())