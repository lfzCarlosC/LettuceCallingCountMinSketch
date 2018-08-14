package com.brandwatch.signals.detector;

import io.lettuce.core.protocol.LettuceCharsets;
import io.lettuce.core.protocol.ProtocolKeyword;

public enum  myclass implements ProtocolKeyword {
    CMS_INCRBY,
    CMS_QUERY,
    CMS_MERGE,
    CMS_INITBYDIM,
    CMS_INITBYERR,
    CMS_DEBUG;
    public final byte[] bytes;

    private myclass() {
        String a = this.name().replace('_', '.');
        this.bytes = a.getBytes(LettuceCharsets.ASCII);
    }

    public byte[] getBytes() {
        return this.bytes;
    }
}
