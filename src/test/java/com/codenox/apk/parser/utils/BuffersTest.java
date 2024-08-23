package com.codenox.apk.parser.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;

public class BuffersTest {

	@Test
	public void testGetUnsignedByte() throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[] {
				2, -10
		});
		assertEquals(2, Buffers.readUByte(byteBuffer));
		assertEquals(246, Buffers.readUByte(byteBuffer));
	}
}
