package eliasstar.config;

public final class SimpleConfigLambda extends SimpleConfig {

    private final Function setup;

    public SimpleConfigLambda(Function setup) {
        this.setup = setup;
    }

    @Override
    public void setup() {
        setup.call();
    }

    @FunctionalInterface
    public interface Function {
        public void call();
    }

}