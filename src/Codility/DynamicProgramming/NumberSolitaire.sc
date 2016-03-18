//A non-empty zero-indexed array
//A of N integers contains the numbers written on the squares.
//Moreover, some squares can be marked during the game.
//
//square number 0 is the only square on the board which is marked. The
//goal of the game is to move the pebble to square number N − 1.
//
//During each turn we throw a six-sided die and consider the number K
//move the pebble standing on square number I to square number I + K,
//providing that square number I + K exists. If square number I + K
//does not exist, we throw the die again
//Finally, we mark square number I + K.
//
//After the game finishes (when the pebble is standing on square number N − 1),
//we calculate the result. The result of the game is the sum of the numbers
//written on all marked squares.
//
//For example, given the following array:
// 1 -2 0 9 -1 -2
//
//the pebble is on square number 0, which is marked;
//we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
//we throw 5; the pebble does not move, since there is no square number 8 on the board;
//we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
//The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8.
//This is the maximal possible result that can be achieved on this board.
//
def solution(A: Array[Int]): Int = {
  val first = Array.fill(6)(A(0))
  for (i <- 1 until A.length) {
    first(i % 6) = first.max + A(i)
  }
  first((A.length - 1) % 6)
}
solution(Array(1, -2, 0, 9, -1, -2)) == 8
solution(Array(1)) == 1
solution(Array(0, -4, -5, -2, -7, -9, -3, -10)) == -12
solution(Array(1, -2, 4, 3, -1, -3, -7, 4, -9)) == 3
solution(Array(0, -4, -5, -2, -7, -9, -3, -10)) == -12
//
//that, given a non-empty zero-indexed array A of N integers, returns the maximal
//result that can be achieved on the board represented by array A.
//the function should return 8, as explained above.
//  expected worst-case time complexity is O(N);