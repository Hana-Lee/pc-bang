package kr.co.leehana.Utils;

import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-48
 */
public class ResourceUtils {

	public static Image getImage(String name) {
		return Toolkit.getDefaultToolkit().createImage(ResourceUtils.class.getResource("/img/" + name));
	}
}
