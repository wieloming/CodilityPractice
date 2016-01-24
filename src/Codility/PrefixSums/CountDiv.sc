//TODO: one more time
def solution(A: Int, B: Int, K: Int): Int = {
    val difference = B / K - A / K
    if (A % K == 0) difference + 1
    else difference
}
//
//that, given three integers A, B and K, returns
//the number of integers within the range [A..B]
//that are divisible by K, i.e.:
solution(6, 11, 2) ==3
solution(A = 11, B = 345, K = 17) == 20
solution(1, 10, 2)==5
solution(2, 12, 4)==3
solution(20, 30, 10)==2
//For example, for A = 6, B = 11 and K = 2,
//your function should return 3, because there
//are three numbers divisible by 2 within the
//range [6..11], namely 6, 8 and 10.
//
//Assume that:
//
//A and B are integers within the range [0..2,000,000,000];
//K is an integer within the range [1..2,000,000,000];
//A ≤ B.
//
//  Complexity:
//
////  expected worst-case time complexity is O(1);a