package com.xql.clientmdb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetDbconnTableList {
    private String baseUrl;
    private String url;
    private String dbconn;

    public GetDbconnTableList() {
    }

    public GetDbconnTableList(String url) {
        this.url = url;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbconn() {
        return dbconn;
    }

    public void setDbconn(String dbconn) {
        this.dbconn = dbconn;
    }

    public String encodeURL(String path) {
        String encPath = "";
        if (path.length() == 0) {
            // nothing to be done
        } else if (path.equals("/")) {
            // only one character '/'; done; length 1
            encPath = "/";
        } else if (path.substring(0, 1).equals("/")) {
            // begins with '/'; length more than 1
            encPath = "/";
            String nextpath = path.substring(1);
            while (true) {
                String[] paths = nextpath.split("/");
                // System.out.println("paths[0]: " + paths[0]);
                try {
                    encPath = encPath + URLEncoder.encode(paths[0], "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    System.out.println("UnsupportedEncodingException: " + ex.getMessage());
                    System.exit(0);
                }
                int slashIndex = nextpath.indexOf("/");
                // System.out.println("slashIndex: " + slashIndex);
                if (slashIndex == -1) {
                    break;
                } else {
                    encPath = encPath + "/";
                    nextpath = nextpath.substring(slashIndex + 1);
                }
            }
        } else {
            String nextpath = path.substring(0);
            while (true) {
                String[] paths = nextpath.split("/");
                // System.out.println("paths[0]: " + paths[0]);
                try {
                    encPath = encPath + URLEncoder.encode(paths[0], "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    System.out.println("UnsupportedEncodingException: " + ex.getMessage());
                    System.exit(0);
                }
                int slashIndex = nextpath.indexOf("/");
                if (slashIndex == -1) {
                    break;
                } else {
                    encPath = encPath + "/";
                    nextpath = nextpath.substring(slashIndex + 1);
                }
            }
        }
        String spacePath = encPath.replaceAll("[+]", "%20");

        return spacePath;
    }

    public String getDbconnTableList() {
        String responseBody = "";
        String uri = "";
        if (this.dbconn != null) {
            uri = this.url + this.dbconn;
        } else {
            uri = this.url;
        }

        int len = baseUrl.length();
        String path = uri.substring(len);
        System.out.println("path: " + path);

        String encPath = encodeURL(path);
        System.out.println("encPath: " + encPath);

        uri = baseUrl + encPath + "/";

        // .uri(URI.create(this.url))
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            System.out.println("request: " + request.toString());

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            responseBody = response.body();
            System.out.println(responseBody);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: HTTP InterruptedException " + ex.getMessage());
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("ERROR: HTTP IOException " + ex.getMessage());
            System.exit(0);
        }

        return responseBody;
    }
}
