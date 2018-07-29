package data;

public enum VersionEnum {
    VERSION_1_9_0("1.9.0", true),
    VERSION_2_0_0("2.0.0", false),
    VERSION_2_0_1("2.0.1", false),
    VERSION_2_1_0("2.1.0", true);
    String version;
    boolean isSupported;

    VersionEnum(String version, boolean isSupported) {
        this.version = version;
        this.isSupported = isSupported;
    }

    public String getVersion() {
        return version;
    }

    public boolean isSupported() {
        return isSupported;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setSupported(boolean supported) {
        isSupported = supported;
    }
}
