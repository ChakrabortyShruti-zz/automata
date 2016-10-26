public class AlphabetSet {
    private String[] alphabets;

    public AlphabetSet(String[] alphabets) {
        this.alphabets = alphabets;
    }

    public boolean isValidAlphabet(String machineString) {
        boolean isValid = false;
        String[] inputString = machineString.split("");
        for (String alphabet : alphabets) {
//            for (String i : inputString) {
//                isValid = alphabet.contains(i);
//            }
            isValid = machineString.contains(alphabet);
        }
        return isValid;
    }
}
