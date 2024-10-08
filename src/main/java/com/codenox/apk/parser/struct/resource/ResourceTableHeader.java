package com.codenox.apk.parser.struct.resource;

import com.codenox.apk.parser.struct.ChunkHeader;
import com.codenox.apk.parser.struct.ChunkType;
import com.codenox.apk.parser.utils.Unsigned;

/**
 * resource file header
 *
 * @author dongliu
 */
public class ResourceTableHeader extends ChunkHeader {
    // The number of ResTable_package structures. uint32
    private int packageCount;

    public ResourceTableHeader(int headerSize, int chunkSize) {
        super(ChunkType.TABLE, headerSize, chunkSize);
    }

    public long getPackageCount() {
        return Unsigned.toLong(packageCount);
    }

    public void setPackageCount(long packageCount) {
        this.packageCount = Unsigned.toUInt(packageCount);
    }
}
