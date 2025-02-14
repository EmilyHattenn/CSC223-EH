
public class DNA {

    // Methods
    public static String countNucleotides(String dna) {
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;

        for (int i=0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A'){
                countA++;
            } else if (dna.charAt(i) == 'C') {
                countC++;
            } else if (dna.charAt(i) == 'G') {
                countG++;
            } else if (dna.charAt(i) == 'T') {
                countT++;
            }
            
        }

        return countA + " " + countC + " " + countG + " " + countT;
    }

    public static String transcribe(String dna){
            return dna.replace('T', 'U');
    }

    public static String reverseComplement(String dna) {
        String nDNA = " ";
        for (int i=dna.length() - 1; i >= 0; i--) {
                if (dna.charAt(i) == 'T') {
                    nDNA += 'A';
                } else if (dna.charAt(i) == 'A') {
                    nDNA += 'T';
                } else if (dna.charAt(i) == 'C') {
                    nDNA += 'G';
                } else if (dna.charAt(i) == 'G') {
                    nDNA += 'C';
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

