//TODO: toooo slow
//You have to climb up a ladder. The ladder has exactly N rungs,
//numbered from 1 to N. With each step, you can ascend by one
//or two rungs. More precisely:
//
//with your first step you can stand on rung 1 or 2,
//if you are on rung K, you can move to rungs K + 1 or K + 2,
//finally you have to stand on rung N.
//Your task is to count the number of different ways of
//climbing to the top of the ladder.
//
//For example, given N = 4, you have five different ways of climbing, ascending by:
//
//1, 1, 1 and 1 rung,
//1, 1 and 2 rungs,
//1, 2 and 1 rung,
//2, 1 and 1 rungs, and
//2 and 2 rungs.
//Given N = 5, you have eight different ways of climbing

//The number of different ways can be very large, so it
//is sufficient to return the result modulo 2P, for a given integer P.

def solution(A: Array[Int], B: Array[Int]): Array[Int] = {
  def combinations(money: Int): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else combinations(money -1) + combinations(money - 2)
  }
  val ways = Stream.from(1).map(combinations)
  (A zip B) map {case(a, b) => ways(a-1) % Math.pow(2, b).toInt}
}

solution(Array(4,4,5,5,1), Array(3,2,4,3,1))
//
//that, given two non-empty zero-indexed arrays A and B of L integers,
//returns an array consisting of L integers specifying the consecutive
//answers; position I should contain the number of different ways of
//climbing the ladder with A[I] rungs modulo 2B[I].
//
//For example, given L = 5 and:
//A[0] = 4   B[0] = 3
//A[1] = 4   B[1] = 2
//A[2] = 5   B[2] = 4
//A[3] = 5   B[3] = 3
//A[4] = 1   B[4] = 1
//the function should return the sequence [5, 1, 8, 0, 1], as explained above.

//  expected worst-case time complexity is O(L);