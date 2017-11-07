import java.util.Objects;

public class Environment {
    private final String k;
    private final int v;
    private final Environment parentEnv;

    public Environment(String k, int v, Environment parentEnv) {
        this.k = k;
        this.v = v;
        this.parentEnv = parentEnv;
    }

    public int getValue(String name) {
        Integer value = null;
        if(Objects.equals(name, k)) { return v; }
        if(parentEnv != null) { value = parentEnv.getValue(name); }
        if(value == null) { throw new RuntimeException("value==null in Environment.getValue()"); }
        return value;
    }
}
