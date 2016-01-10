//The leader of this array is the value that occurs
// in more than half of the elements of A.
//
//An equi leader is an index S such that
// 0 ≤ S < N − 1 and two sequences
// A[0], A[1], ..., A[S] and A[S + 1], A[S + 2],
// ..., A[N − 1] have leaders of the same value.
//
//For example, given array A such that:

// 4 3 4 4 4 2
// 4 : 4 4 : 4
// 4 : 4 4 : 2
//we can find two equi leaders:
//
//0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
//2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
//
//The goal is to count the number of equi leaders.
def solution(A: Array[Int]) = {
  def returnMaxIfEx(a: Array[Int]):(Boolean, Int) = {
    val d= a.groupBy(identity).mapValues(_.length)
    val max = d.maxBy(_._2)
    (max._2 > a.length/2, max._1)
  }
  if (A.isEmpty) 0
  else {
    var res = 0
    for(x <- 1 to A.length - 1){
      val (a,b) = A.splitAt(x)
      val r1 = returnMaxIfEx(a)
      val r2 = returnMaxIfEx(b)
      if((r1._1 && r2._1) && r1._2 == r2._2){
        res += 1
      }
    }
    res
  }
}
//solution(Array(4, 3, 4, 4, 4, 2))
solution(Array(4, 4, 2, 5, 3, 4, 4, 4))
//that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);