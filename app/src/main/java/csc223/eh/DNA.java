package csc223.eh;

public class DNA {

    // Methods
    public static String countNucleotides(String dna) {
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
    
        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A' -> countA++;
                case 'C' -> countC++;
                case 'G' -> countG++;
                case 'T' -> countT++;
                default -> {
                }
            }
            // Handle unexpected characters if necessary
                    }
    
        return countA + " " + countC + " " + countG + " " + countT;
    }

    public static String transcribe(String dna){
            return dna.replace('T', 'U');
    }

    public static String reverseComplement(String dna) {
        String nDNA = " ";
        for (int i=dna.length() - 1; i >= 0; i--) {
            switch (dna.charAt(i)) {
                case 'T' -> nDNA += 'A';
                case 'A' -> nDNA += 'T';
                case 'C' -> nDNA += 'G';
                case 'G' -> nDNA += 'C';
                default -> {
                }
            }
        }
            return nDNA;
    }

    // Test
    public static void main(String[] args) {
        // Test the methods
        String sample_dna = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";


        System.out.println("Amount of each Nucleotide: " + countNucleotides(sample_dna));
        System.out.println("After Transcribing: " + transcribe(sample_dna));
        System.out.println("The Reverse Complement:" + reverseComplement(sample_dna));
    }
}

