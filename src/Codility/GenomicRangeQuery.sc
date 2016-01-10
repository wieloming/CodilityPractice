def solution(S: String, P: Array[Int], Q: Array[Int]):Array[Int] = {
  val values = S.map{
    case 'A' => 1
    case 'C' => 2
    case 'G' => 3
    case 'T' => 4
  }
  P.zip(Q).map{case (start, end) =>
    values.slice(start, end+1).min
  }
}
solution("CAGCCTA", Array(2,5,0), Array(4,5,6))
solution("CAG", Array(2,5,0), Array(4,5,6))
solution("AC", Array(0,0,1), Array(0,1,1))
//For example, consider string S = CAGCCTA and arrays P, Q such that:
//P[0] = 2    Q[0] = 4
//P[1] = 5    Q[1] = 5
//P[2] = 0    Q[2] = 6
//
//The answers to these M = 3 queries are as follows:
//
//  The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
//The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
//The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
//
//
//  N is an integer within the range [1..100,000];
//M is an integer within the range [1..50,000];
//each element of arrays P, Q is an integer within the range [0..N − 1];
//P[K] ≤ Q[K], where 0 ≤ K < M;
//string S consists only of upper-case English letters A, C, G, T.
//
//  Complexity:
//
//  expected worst-case time complexity is O(N+M);
//expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//
