package StaticFactory.Bulider2;

public class Calzone extends Pizza {
    private Boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private Boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside=builder.sauceInside;
    }
}
