package org.naraberri.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadFileUtil {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtil.class);

	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();

		String uName = uid.toString() + "_" + originalName;

		return "";

	}

}
