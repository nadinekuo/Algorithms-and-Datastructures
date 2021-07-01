import java.util.ArrayList;

public class Bucket {

    private ArrayList<Float> bucket;

    public Bucket() {
        this.bucket = new ArrayList<>();
    }

    public void add(float f) {
        bucket.add(f);
    }

    public boolean contains(float f) {
        return bucket.contains(f);
    }
}
