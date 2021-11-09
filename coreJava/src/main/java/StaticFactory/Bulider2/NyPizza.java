package StaticFactory.Bulider2;

import java.util.Objects;

public class NyPizza extends Pizza{

    public enum Size{SMALL,MEDIUM, LARGE}
    private Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private Size size;

        public Builder(Size size){
            this.size= Objects.requireNonNull(size);
        }
        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);

    }
}
