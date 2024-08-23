package com.codenox.apk.parser.struct.resource;

import com.codenox.apk.parser.struct.ChunkHeader;
import com.codenox.apk.parser.struct.ChunkType;

public class NullHeader extends ChunkHeader {
    public NullHeader(int headerSize, int chunkSize) {
        super(ChunkType.NULL, headerSize, chunkSize);
    }
}
