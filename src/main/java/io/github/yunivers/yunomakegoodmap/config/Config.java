package io.github.yunivers.yunomakegoodmap.config;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config
{
    @ConfigRoot(value = "config", visibleName = "YUNoMakeGoodMap Config")
    public static final ConfigFields config = new ConfigFields();

    public static class ConfigFields
    {
        @ConfigEntry(
            name = "Platform Type",
            description = "The type of platform to create in the overworld")
        public PlatformTypeEnum platformType = PlatformTypeEnum.TREE;
    }
}
