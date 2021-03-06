public class Permutation {

    private String[] mPermutation;
    private String mWord;
    private int mFactorialResult;
    private boolean mValid;

    public Permutation(String word) {
        mWord = word;
        mValid = validate();
        if (mValid) {
            mFactorialResult = factorial(word.length());
            mPermutation = new String[mFactorialResult];
        }
    }

    private boolean validate() {
        for (int i = 0; i < mWord.length(); i++) {
            for (int j = 0; j < mWord.length(); j++) {
                if (i == j) {
                    continue;
                }

                if (mWord.charAt(i) == mWord.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void run() {
        if (!mValid) {
            System.err.println("Error: word cannot have repeated characters!");
            return;
        }

        mPermutation = new String[mFactorialResult];

        for (int i = 0; i < mPermutation.length; i++) {
            mPermutation[i] = "";
        }

        int length = mWord.length();
        int factor = mFactorialResult;
        for (int i = 0; i < length; i++) {
            if (length - i <= 0) {
                factor = 0;
            } else {
                factor /= (length - i);
            }

            for (int j = 0, k = i; j < mFactorialResult; j++) {
                if (factor == 0 || (j != 0 && j % factor == 0) || mPermutation[j].contains(mWord.charAt(k) + "")) {
                    k++;
                    if (k >= length) {
                        k = 0;
                    }

                    while (mPermutation[j].contains(mWord.charAt(k) + "")) {
                        k++;
                        if (k >= length) {
                            k = 0;
                        }
                    }
                }

                mPermutation[j] = mPermutation[j] + mWord.charAt(k);
                System.out.println(mPermutation[j]);
            }
        }
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public void print() {
        if (!mValid) {
            System.err.println("Error: invalid data!");
            return;
        }

        int maxLoops = mFactorialResult;
        int digitCount = 0;
        while (maxLoops != 0) {
            maxLoops /= 10;
            digitCount++;
        }
        String format = "%" + digitCount + "d";
        for (int i = 0; i < mPermutation.length; i++) {
            System.out.printf(format + ": %s\n", i + 1, mPermutation[i]);
        }
    }

    public boolean isResultValid() {
        if (!mValid) {
            return false;
        }

        for (int i = 0; i < mPermutation.length; i++) {
            for (int j = 0; j < mPermutation.length; j++) {
                if (i == j) {
                    continue;
                }

                if (mPermutation[i].equals(mPermutation[j])) {
                    return false;
                }
            }
        }
        return true;
    }

}
