package responses;

import config.Config;
import org.junit.Test;
import requests.InvalidRequest;
import utils.MimeTypes;
import utils.StatusCodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ResponseTest {
    Response correctResourceResponse = new Response("/index.html", "HTTP/1.1");
    Response invalidResourceResponse = new Response("/this_file_doesn't_exits", "HTTP/1.1");
    Response invalidRequestResponse = new InvalidRequest().solve();
    @Test
    public void testHtmlMimeTypeResponseWithCorrectResource() {
        assertEquals(correctResourceResponse.getContentType(), MimeTypes.HTML);
    }

    @Test
    public void testCorrectStatusCodeResponse() {
        assertEquals(correctResourceResponse.getStatusCode(), StatusCodes.SUCCESS);
    }

    @Test
    public void testNotFoundStatusCodeResponseWithCorrectResource() {
        assertEquals(invalidResourceResponse.getStatusCode(), StatusCodes.NOT_FOUND);
    }

    @Test
    public void testInvalidRequestStatusCode() {
        assertEquals(invalidRequestResponse.getStatusCode(), StatusCodes.BAD_REQUEST);
    }

    @Test
    public void testResourceNotFound() throws IOException {
        byte[] page= Files.readAllBytes(Paths.get(Config.rootPath + "not_found.html"));
        assertArrayEquals(page, invalidResourceResponse.getContentBytes());
    }






}