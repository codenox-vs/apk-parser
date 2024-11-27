package net.dongliu.apk.parser.bean;

import jakarta.annotation.Nullable;

/**
 * The plain file apk icon.
 *
 * @author Liu Dong
 */
public class Icon implements IconFace {

	private static final long serialVersionUID = 8680309892249769701L;
	private final String path;
	private final int density;
	private final byte[] data;

	public Icon(String path, int density, byte[] data) {
		this.path = path;
		this.density = density;
		this.data = data;
	}


	/**
	 * The icon path in apk file
	 */
	@Override
	public String getPath() {
		return path;
	}


	/**
	 * Return the density this icon for. 0 means default icon.
	 * see {@link com.codenox.apk.parser.struct.resource.Densities} for more density values.
	 */
	public int getDensity() {
		return density;
	}


	@Override
	public boolean isFile() {
		return true;
	}


	/**
	 * Icon data may be null, due to some apk missing the icon file.
	 */
	@Override
	@Nullable
	public byte[] getData() {
		return data;
	}


	@Override
	public String toString() {
		return "Icon{path='"
								+ path
								+ '\''
								+ ", density="
								+ density
								+ ", size="
								+ (data == null ? 0 : data.length)
								+ '}';
	}
}
