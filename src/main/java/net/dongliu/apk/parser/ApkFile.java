package net.dongliu.apk.parser;

import jakarta.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.dongliu.apk.parser.utils.Inputs;

/**
 * ApkFile, for parsing apk file info.
 * This class is not thread-safe.
 *
 * @author dongliu
 */
public class ApkFile extends AbstractApkFile {

	private final ZipFile zf;
	private File apkFile;
	@Nullable
	private FileChannel fileChannel;

	public ApkFile(File apkFile) throws IOException {
		this.apkFile = apkFile;
		// create zip file cost time, use one zip file for apk parser life cycle
		this.zf = new ZipFile(apkFile);
	}


	public ApkFile(String filePath) throws IOException {
		this(new File(filePath));
	}


	@Override
	protected List<CertificateFile> getAllCertificateData() throws IOException {
		Enumeration<? extends ZipEntry> enu = zf.entries();
		List<CertificateFile> list = new ArrayList<>();
		while (enu.hasMoreElements()) {
			ZipEntry ne = enu.nextElement();
			if(ne.isDirectory()) {
				continue;
			}
			String name = ne.getName().toUpperCase();
			if(name.endsWith(".RSA") || name.endsWith(".DSA")) {
				list.add(new CertificateFile(name, Inputs.readAllAndClose(zf.getInputStream(ne))));
			}
		}
		return list;
	}


	@Override
	public byte[] getFileData(String path) throws IOException {
		ZipEntry entry = zf.getEntry(path);
		if(entry == null) {
			return null;
		}

		InputStream inputStream = zf.getInputStream(entry);
		return Inputs.readAllAndClose(inputStream);
	}


	@Override
	protected ByteBuffer fileData() throws IOException {
		fileChannel = new FileInputStream(apkFile).getChannel();
		return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
	}


	@Override
	public void close() throws IOException {
		try (Closeable superClosable = new Closeable() {
			@Override
			public void close() throws IOException {
				ApkFile.super.close();
			}
		}; Closeable zipFileClosable = zf; Closeable fileChannelClosable = fileChannel) {

		}
	}

}
