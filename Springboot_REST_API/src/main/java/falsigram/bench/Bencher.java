package falsigram.bench;

public abstract class Bencher {

    private float tmpText_gen;
    private float tmpToString;

    public void setTmpText_gen(float tmpText_gen) {
        this.tmpText_gen = tmpText_gen;
    }

    public void setTmpToString(float tmpToString) {
        this.tmpToString = tmpToString;
    }
}
