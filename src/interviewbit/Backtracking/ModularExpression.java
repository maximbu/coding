package interviewbit.Backtracking;

/**
 * Implement pow(A, B) % C.
 *
 * In other words, given A, B and C,
 * find (AB)%C.
 *
 * Input : A = 2, B = 3, C = 3
 * Return : 2
 * 2^3 % 3 = 8 % 3 = 2
 */
public class ModularExpression {

  public int Mod(int A, int B, int C) {
    if (B == 0)
      return A == 0 ? 0 : 1;
    if (B == 1)
      return (C + A) % C;
    int tmp = (int) ((((long) A % C) * (A % C)) % C);
    if (B % 2 == 0)
      return Mod(tmp, B / 2, C);
    return (int) (((long) A * Mod(tmp, (B - 1) / 2, C)) % C);
  }
}
