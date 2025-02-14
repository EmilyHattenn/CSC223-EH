public class FUber {

    public static float euclidean(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
        
    }

    // Test
    public static void main(String[] args) {
        // Test the methods
        float x1 = 1.0f, y1 = 2.0f, x2 = 4.0f, y2 = 6.0f;

        System.out.println("Euclidean Distance: " + euclidean(x1, y1, x2, y2));
        System.out.println("Manhattan Distance: " + manhattan(x1, y1, x2, y2));
    }
}


