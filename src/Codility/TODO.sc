def solution(N: Int, M: Int): Int = {
  val array = Array.fill[Int](N)(1)
  var i = 0
  var eaten = 0
  while(array(i % N) != 0){
    array(i % N) = 0
    i += M
    eaten += 1
  }
  eaten
}

solution(10, 4)
