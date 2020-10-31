package com.bridgelabz.employeepayrollservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPath_WhenCheckedThenConfirm() throws IOException {
		// Check file exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		// Delete file and check file not exist
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		// Create Directory
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {

			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		// List Files , directories as well as files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}
}
