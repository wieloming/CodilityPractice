//TODO: one more time
//For example, consider array A such that:
// 0 0 0 1 1 0 1 0 0 0 0
//The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
def solution(A: Array[Int]): Int = {
  if(A.isEmpty) return 1
  lazy val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
  val fibonacci = fibs.takeWhile(_ < A.length+1).tail.tail
  val minimumJumps = new Array[Int](A.length)
  var currentPositions = List[Int]()
  var nextPositions = List(-1)
  var jumpsNumber = 0
  while (nextPositions.nonEmpty) {
    jumpsNumber += 1
    currentPositions = nextPositions
    nextPositions = List[Int]()
    for (position <- currentPositions) {
      for (jump <- fibonacci; if position + jump <= A.length) {
        if (position+jump == A.length) return jumpsNumber
        if (A(position+jump) == 1 && minimumJumps(position+jump) == 0) {
          minimumJumps(position+jump) = jumpsNumber
          nextPositions ::= position+jump
        }
      }
    }
  }
  -1
}
solution(Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0))
//solution(Array(0, 0, 0))
//The frog is initially located at one bank of the river
//(position −1) and wants to get to the other bank (position N).
//The frog can jump over any distance F(K), where F(K) is the
//K-th Fibonacci number. Luckily, there are many leaves on the
//river, and the frog can jump between the leaves, but only in
//the direction of the bank at position N.
//
//0 represents a position without a leaf;
//1 represents a position containing a leaf.
//The goal is to count the minimum number of
//jumps in which the frog can get to the other
//side of the river (from position −1 to position N).
//The frog can jump between positions −1 and N (the
//banks of the river) and every position containing a leaf.
//
//that, given a zero-indexed array A consisting of N integers,
//returns the minimum number of jumps by which the frog can get
//to the other side of the river. If the frog cannot reach the
//other side of the river, the function should return −1.
//the function should return 3, as explained above.
//
//  expected worst-case time complexity is O(N*log(N));