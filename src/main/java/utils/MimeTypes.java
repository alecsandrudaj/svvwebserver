package utils;

public class MimeTypes {
    public static String HTML = "text/html";
    public static String CSS = "text/css";
    public static String JPEG = "image/jpeg";
    public static String GIF = "image/gif";
    public static String PLAIN = "text/plain";
    public static String OCTET_STREAM = "application/octet-stream";

    public static String getMimeType(String path) {
        String contentType = MimeTypes.PLAIN;
        if (path.endsWith(".html") || path.endsWith(".htm") || path.equals("/") || path.isEmpty())
            contentType = MimeTypes.HTML;
        else if (path.endsWith(".css"))
            contentType = MimeTypes.CSS;
        else if (path.endsWith(".jpg") || path.endsWith(".jpeg"))
            contentType = MimeTypes.JPEG;
        else if (path.endsWith(".gif"))
            contentType = MimeTypes.GIF;
        return contentType;
    }
}
