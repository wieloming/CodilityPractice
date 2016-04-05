//In second 6, a leaf falls into position 5.
//This is the earliest time when leaves appear
//in every position across the river.
import scala.collection.mutable
def solution(X: Int, A: Array[Int]): Int = {
  val road = mutable.Map[Int, Int]()
  var index = 0
  for(n <- A){
    if(!road.isDefinedAt(n)) road(n) = index
    index += 1
  }
  if(road.keys.toList.sorted == (1 to X).toList)
    road.values.max
  else -1
}
//
//that, given a non-empty zero-indexed array A

//If the frog is never able to jump to the other side
//of the river, the function should return −1.
solution(5,Array(1,3,1,4,2,3,5,4))
//For example, given X = 5 and array A such that:
//A[0] = 1
//A[1] = 3
//A[2] = 1
//A[3] = 4
//A[4] = 2
//A[5] = 3
//A[6] = 5
//A[7] = 4
//
//the function should return 6, as explained above.
//
//  Assume that:
//
//  N and X are integers within the range [1..100,000];
//each element of array A is an integer within the range [1..X].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);