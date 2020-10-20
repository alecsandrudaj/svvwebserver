package requests;

import exceptions.MethodParseError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler {
    public RequestHandler() {

    }

    public boolean handleRequest(Socket connect) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String input = in.lines().toString();

        //check input and serve incorrect request

        RequestParser parser = new RequestParser();
        try {
            Request request = parser.parseRequest(input);
        } catch (MethodParseError methodParseError) {
            methodParseError.printStackTrace();
            // serve incorrect request
        }

        return false;
    }
}
