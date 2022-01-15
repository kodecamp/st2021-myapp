package in.kodecamp.optionals;

import java.util.function.Supplier;

/**
 * Rule
 */
public final class Rule<T> {


    private final Supplier<Boolean> condition;
    private final Supplier<T> block;

    /**
     * @param condition
     * @param exec
     */
    private Rule(Supplier<Boolean> condition, Supplier<T> block) {
        this.condition = condition;
        this.block = block;
    }

    private Rule(Builder<T> builder) {
        this.condition = builder.condition;
        this.block = builder.block;
    }

    /**
     * @return the condition
     */
    public Supplier<Boolean> condition() { return condition; }

    /**
     * @return the exec
     */
    public Supplier<T> block() { return block; }

    static class Builder<T> {

        private Supplier<Boolean> condition;
        private Supplier<T> block;


        Builder<T> condition(Supplier<Boolean> cond) {
            this.condition = cond;
            return this;
        }

        Builder<T> block(Supplier<T> block) {
            this.block = block;
            return this;
        }

        public Rule<T> build() {
            return new Rule<T>(this);
        }

    }

    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

}
