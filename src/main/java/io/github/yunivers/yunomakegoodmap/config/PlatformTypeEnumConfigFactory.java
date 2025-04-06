package io.github.yunivers.yunomakegoodmap.config;

import com.google.common.collect.ImmutableMap;
import net.glasslauncher.mods.gcapi3.api.*;
import net.glasslauncher.mods.gcapi3.impl.SeptFunction;
import net.glasslauncher.mods.gcapi3.impl.object.ConfigEntryHandler;
import net.glasslauncher.mods.gcapi3.impl.object.entry.EnumConfigEntryHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.function.Function;

public class PlatformTypeEnumConfigFactory implements ConfigFactoryProvider
{
    @Override
    public void provideLoadFactories(ImmutableMap.Builder<Type, SeptFunction<String, ConfigEntry, Field, Object, Boolean, Object, Object, ConfigEntryHandler<?>>> builder) {
        builder.put(PlatformTypeEnum.class, ((id, configEntry, parentField, parentObject, isMultiplayerSynced, enumOrOrdinal, defaultEnum) ->
        {
            int enumOrdinal;
            if (enumOrOrdinal instanceof Integer ordinal) {
                enumOrdinal = ordinal;
            }
            else {
                enumOrdinal = ((PlatformTypeEnum)enumOrOrdinal).ordinal();
            }
            return new EnumConfigEntryHandler<PlatformTypeEnum>(id, configEntry, parentField, parentObject, isMultiplayerSynced, enumOrdinal, ((PlatformTypeEnum)defaultEnum).ordinal(), PlatformTypeEnum.class);
        }));
    }

    @Override
    public void provideSaveFactories(ImmutableMap.Builder<Type, Function<Object, Object>> builder) {
        builder.put(PlatformTypeEnum.class, enumEntry -> enumEntry);
    }
}
