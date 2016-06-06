
def solution(A: Array[Int]): Int = {
  if(A.length < 3) 0
  else {
    val peaks = Array.fill[Boolean](A.length)(false)
    for(i <- 1 until A.length - 1){
      val prev = A(i-1)
      val curr = A(i)
      val next = A(i+1)
      if(prev < curr && next < curr) peaks(i) = true
    }
    def canDivide(a: Array[Boolean], n: Int) = {
      if(a.length % n != 0) false
      else a.grouped(n).forall(_.contains(true))
    }
    var i = 1
    while(!canDivide(peaks, i)){
      i += 1
      if(i >= peaks.length) return 0
    }
    A.length / i
  }
}

solution(Array(1,2,3,4,3,4,1,2,3,4,6,2))
solution(Array())
solution(Array(0))