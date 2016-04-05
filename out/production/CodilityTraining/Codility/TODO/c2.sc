//A[0] = 1
//A[1] = 4
//A[2] = 7
//A[3] = 3
//A[4] = 3
//A[5] = 5

val A = Array(1, 4, 7, 3, 3, 5)

def areAdjacent(index1: Int, index2: Int, list: List[Int]): Boolean = {
  val first = list(index1)
  val second = list(index2)
  def checkInOrder: Boolean = {
    val firstUntilSecond = (first until second).toList
    if (firstUntilSecond.length > 1) !firstUntilSecond.tail.exists(list.contains(_))
    else true
  }
  def checkReversed: Boolean = {
    val firstUntilSecond = first until second by -1
    if (firstUntilSecond.length > 1) !firstUntilSecond.init.exists(list.contains(_))
    else true
  }
  if (first == second || index1 > index2) false
  else {
    if(first <= second){
      checkInOrder
    } else{
      checkReversed
    }
  }
}
val list = A.toList
val indecesPairs = for {
  index1 <- list.indices
  index2 <- list.indices if index1 != index2
} yield (index1, index2)
indecesPairs
  .filter { case (i1, i2) => areAdjacent(i1, i2, list) }
  .map { case (i1, i2) => Math.abs(list(i1) - list(i2))}
  .max
