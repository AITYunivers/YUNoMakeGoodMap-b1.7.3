package io.github.yunivers.yunomakegoodmap.config;

public enum PlatformTypeEnum
{
    GRASS("Single Grass"),
    TREE("Single Tree"),
    SKYBLOCK21("SkyBlock 2.1");

    final String stringValue;

    PlatformTypeEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
