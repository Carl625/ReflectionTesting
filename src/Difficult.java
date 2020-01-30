public class Difficult {

    private Double d;
    private String s;

    private Difficult(Double d, String s) {

        this.d = d;
        this.s = s;
    }

    public int getDouble(Double d2) {

        return (int) Math.floor(d + d2);
    }
}
