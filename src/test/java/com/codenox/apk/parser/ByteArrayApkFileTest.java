package com.codenox.apk.parser;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codenox.apk.parser.bean.ApkMeta;
import com.codenox.apk.parser.bean.ApkSigner;
import com.codenox.apk.parser.bean.CertificateMeta;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class ByteArrayApkFileTest {

    @Test
    public void testParserMeta() throws IOException {
        String path = getClass().getClassLoader().getResource("apks/Twitter_v7.93.2.apk").getPath();
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        try (ByteArrayApkFile apkFile = new ByteArrayApkFile(bytes)) {
            apkFile.setPreferredLocale(Locale.ENGLISH);
            ApkMeta apkMeta = apkFile.getApkMeta();
            assertEquals("Twitter", apkMeta.getLabel());
        }
    }

    @Test
    public void testGetSignature() throws IOException, CertificateException {
        String path = getClass().getClassLoader().getResource("apks/Twitter_v7.93.2.apk").getPath();
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        try (ByteArrayApkFile apkFile = new ByteArrayApkFile(bytes)) {
            List<ApkSigner> apkSingers = apkFile.getApkSingers();
            assertEquals(1, apkSingers.size());
            ApkSigner apkSigner = apkSingers.get(0);
            assertEquals("META-INF/CERT.RSA", apkSigner.getPath());
            List<CertificateMeta> certificateMetas = apkSigner.getCertificateMetas();
            assertEquals(1, certificateMetas.size());
            CertificateMeta certificateMeta = certificateMetas.get(0);
            assertEquals("69ee076cc84f4d94802d61907b07525f", certificateMeta.getCertMd5());
        }
    }
}
