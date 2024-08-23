package com.codenox.apk.parser.parser;

import com.codenox.apk.parser.utils.Inputs;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import org.junit.jupiter.api.Test;

public class ApkSignBlockParserTest {

	@Test
	public void parse() throws IOException, CertificateException {
		byte[] bytes = Inputs.readAllAndClose(getClass().getResourceAsStream("/sign/gmail_sign_block"));
		ApkSignBlockParser parser = new ApkSignBlockParser(ByteBuffer.wrap(bytes));
		parser.parse();
	}
}
