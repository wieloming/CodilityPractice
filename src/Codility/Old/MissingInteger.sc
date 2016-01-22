//TODO: running time
//TODO: understand and refactor second solution
//Write a function:
//
def solution(A: Array[Int]): Int = {
  val positive = A.filter(_ > 0)
  positive match {
    case Array() => 1
    case _ if positive.min > 1 => 1
    case _ =>
      var next = positive.min + 1
      while (A.contains(next)) next += 1
      next
  }
}
def solution2(A: Array[Int]): Int = {
  val length = A.length
  val numbers = new Array[Boolean](length)
  for (num <- A) {
    if (num > 0 && num <= length) {
      numbers(num - 1) = true
    }
  }
  for (ind <- numbers.indices) {
    if (!numbers(ind)) {
      return ind + 1
    }
  }
  length + 1
}
//
//that, given a non-empty zero-indexed array A of N integers,
//returns the minimal positive integer
//(greater than 0) that does not occur in A.
//
//  For example, given:
//  A[0] = 1
//A[1] = 3
//A[2] = 6
//A[3] = 4
//A[4] = 1
//A[5] = 2
solution(Array(1, 3, 6, 4, 1, 2))
solution(Array())
solution(Array(1))
solution(Array(1, -2))
solution((102 to 200).toArray)
//the function should return 5.
//
//Assume that:
//
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//
