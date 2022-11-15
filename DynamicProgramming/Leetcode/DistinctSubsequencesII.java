/*
Leetcode Link: https://leetcode.com/problems/distinct-subsequences-ii/
 */

/*
The code is not passing just one test-case now.
I will check and update the code.
 */

package DynamicProgramming.Leetcode;

public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int mod = (int)(1e9 + 7);
        int lastOccurrence[] = new int[26];
        int length = s.length();
        int distinctSubsequenceCount[] = new int[length + 1];

        distinctSubsequenceCount[0] = 1;

        /*
        Mistake 1:
        Instead of 'i < 26', I wrote 'i < length'
         */
        for(int i = 0; i < 26; i++) {
            lastOccurrence[i] = -1;
        }

        for(int i  = 1; i <= length; i++) {
            int currentCount = ((distinctSubsequenceCount[i - 1] % mod) * 2) % mod;

            char ch = s.charAt(i - 1);
            int index = ch - 'a';

            if(lastOccurrence[index] != -1) {
                int lastOccurrenceIndex = lastOccurrence[index];
                int duplicateCount = distinctSubsequenceCount[lastOccurrenceIndex];
                /*
                Mistake 2:
                This statement:
                distinctSubsequenceCount[i] = (currentCount % mod) - (duplicateCount % mod);

                should be:
                distinctSubsequenceCount[i] = (currentCount - duplicateCount + mod) % mod;

                because there can be a case where:
                'currentCount' is a big positive number, but going for 'mod' will make
                it small, whereas 'duplicateCount' may be a small positive number and hence,
                'mod' won't affect the value
                This will make '(currentCount % mod) - (duplicateCount % mod)' a negative number

                There's another problem here.
                The above statement:
                distinctSubsequenceCount[i] = (currentCount - duplicateCount + mod) % mod;

                will cause problem in the last test-case, where the input is:
                yezruvnatuipjeohsymapyxgfeczkevoxipckunlqjauvllfpwezhlzpbkfqazhexabomnlxkmoufneninbxxguuktvupmpfspwxiouwlfalexmluwcsbeqrzkivrphtpcoxqsueuxsalopbsgkzaibkpfmsztkwommkvgjjdvvggnvtlwrllcafhfocprnrzfoyehqhrvhpbbpxpsvomdpmksojckgkgkycoynbldkbnrlujegxotgmeyknpmpgajbgwmfftuphfzrywarqkpkfnwtzgdkdcyvwkqawwyjuskpvqomfchnlojmeltlwvqomucipcwxkgsktjxpwhujaexhejeflpctmjpuguslmzvpykbldcbxqnwgycpfccgeychkxfopixijeypzyryglutxweffyrqtkfrqlhtjweodttchnugybsmacpgperznunffrdavyqgilqlplebbkdopyyxcoamfxhpmdyrtutfxsejkwiyvdwggyhgsdpfxpznrccwdupfzlubkhppmasdbqfzttbhfismeamenyukzqoupbzxashwuvfkmkosgevcjnlpfgxgzumktsexvwhylhiupwfwyxotwnxodttsrifgzkkedurayjgxlhxjzlxikcgerptpufocymfrkyayvklsalgmtifpiczwnozmgowzchjiop

                That's because for the last iteration, the value of currentCount - duplicateCount + mod
                will become a multiple of 10^9 + 7.
                Hence, we will avoid adding mod here and change the statement to:
                distinctSubsequenceCount[i] = (currentCount - duplicateCount) % mod;
                 */
                distinctSubsequenceCount[i] = (currentCount - duplicateCount) % mod;
            }
            else {
                distinctSubsequenceCount[i] = currentCount % mod;
            }

            /*
            Mistake 3:
            This statement:
            lastOccurrence[index] = i;

            should be this:
            lastOccurrence[index] = i - 1;

            because when the value of 'i' is '1', we are referring to the 0th character,
            when the value of 'i' is '2', we are referring to the 1st character,
            when the value of 'i' is '3', we are referring to the 2nd character and so on
            */
            lastOccurrence[index] = i - 1;
        }

        /*
        Mistake 4 (due to which the last test case won't pass):
        If the value at 'distinctSubsequenceCount[length]' is a multiple of 'mod',
        then going for a '%' operation and subtracting will result in -1. That's because:
        distinctSubsequenceCount[length] % mod = 0
        and then, distinctSubsequenceCount[length] - 1 = -1

        Hence, we first go for a -1 first (to avoid empty string), then adding mod if and only if
        the answer is negative
         */

        distinctSubsequenceCount[length]--;

        if (distinctSubsequenceCount[length] < 0) {
            distinctSubsequenceCount[length] += mod;
        }

        return distinctSubsequenceCount[length];
    }
}
