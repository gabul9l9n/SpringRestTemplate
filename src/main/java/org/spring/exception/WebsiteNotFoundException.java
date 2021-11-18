package org.spring.exception;

public class WebsiteNotFoundException extends RuntimeException {
    public WebsiteNotFoundException(String name) {
        super("Could not find " + name);
    }
}
