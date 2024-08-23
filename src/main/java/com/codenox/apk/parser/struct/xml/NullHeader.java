package com.codenox.apk.parser.struct.xml;

import com.codenox.apk.parser.struct.ChunkHeader;

/**
 * Null header.
 *
 * @author dongliu
 */
public class NullHeader extends ChunkHeader {
    public NullHeader(int chunkType, int headerSize, long chunkSize) {
        super(chunkType, headerSize, chunkSize);
    }
}
