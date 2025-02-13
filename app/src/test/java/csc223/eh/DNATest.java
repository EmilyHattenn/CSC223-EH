import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DNA_Test {
    @Test
    void testCountNucleotides() {
        assertEquals("20 12 17 21", DNA.countNucleotides("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));
        assertEquals("1 1 1 1", DNA.countNucleotides("ACGT"));
    }
}


    public void testcountNucleotides() {

    }

    public void testreverseComplement() {

    }

   

}