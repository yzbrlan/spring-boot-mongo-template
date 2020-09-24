package xywu.top.edu.common.constant;

/**
 * @author xiya.wu
 * @date 2019/11/4
 */

public enum SystemModules {
    SYSTEM(Origin.INTERNAL, "00"),
    EXTERNAL(Origin.EXTERNAL, "01"),
    SELF(Origin.INTERNAL, "02"),

    STUDENTS(Origin.INTERNAL,"03");

    private final Origin origin;
    private final String module;

    public Origin getOrigin() {
        return origin;
    }

    public String getModule() {
        return module;
    }

    SystemModules(Origin origin, String module) {
        this.origin = origin;
        this.module = module;
    }

    @Override
    public String toString() {
        return origin.getValue() + getModule();
    }

    public enum Origin {
        INTERNAL("1"),
        EXTERNAL("2"),
        ;

        private final String value;

        public String getValue() {
            return value;
        }

        Origin(String value) {
            this.value = value;
        }
    }
}
