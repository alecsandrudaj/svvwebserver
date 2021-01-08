package utils;

import config.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ContentProviderTest {
    private ContentProvider cp = new ContentProvider();

    @org.junit.Test
    public void getByteContentFileExists() throws IOException {
        byte[] mockedBytes = "Hello TXT works".getBytes();

    }

    @org.junit.Test(expected = FileNotFoundException.class)
    public void getByteContentFileNotExists() throws IOException {
        byte[] content  = cp.getByteContent("this_is_not_a_file_that_exists.txt");
    }

    @org.junit.Test
    public void getPlainContentFound() throws IOException {
        String mockedString = "Hello TXT works";
        assertEquals(mockedString, cp.getPlainContent("a.txt"));
    }

    @org.junit.Test(expected = FileNotFoundException.class)
    public void getPlainContentNotFound() throws IOException {
        String content = cp.getPlainContent("this_is_not_a_file_that_exists.txt");
    }

    @org.junit.Test
    public void getDefaultPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(Config.rootPath + "index.html"));
        assertArrayEquals(homePage, cp.getDefaultPage());
    }

    @org.junit.Test
    public void getErrorPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(Config.rootPath + "not_found.html"));
        assertArrayEquals(homePage, cp.getErrorPage());
    }
}