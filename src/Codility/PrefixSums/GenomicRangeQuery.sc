//TODO: one more time
//A, C, G and T have impact factors of 1, 2, 3 and 4,
//What is the minimal impact factor of nucleotides
//contained in a particular part of the given DNA sequence?
//
//The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] .
//
//For example, consider string S = CAGCCTA and arrays P, Q such that:
//P[0] = 2    Q[0] = 4
//P[1] = 5    Q[1] = 5
//P[2] = 0    Q[2] = 6

//between positions 2 and 4->  G and C (twice) -> 3 and 2 so the answer is 2.
//between positions 5 and 5 T -> 4, so the answer is 4.
//psitions 0 and 6 all nucleotides A whose impact factor is 1, so the answer is 1.
//
def solution(S: String, P: Array[Int], Q: Array[Int]): Array[Int] = {
  val values = S.view.par.map{
    case 'A' => 1
    case 'C' => 2
    case 'G' => 3
    case 'T' => 4
  }
  (P zip Q) map {case (p, q) => values.slice(p, q+1).min}
  }
solution("CAGCCTA", Array(2,5,0), Array(4,5,6))
//the function should return the values [2, 4, 1], as explained above.
//N is an integer within the range [1..100,000];
//M is an integer within the range [1..50,000];
//each element of arrays P, Q is an integer within the range [0..N − 1];
//P[K] ≤ Q[K], where 0 ≤ K < M;
//  expected worst-case time complexity is O(N+M);
