package com.example.CapstoneBackend.HelperClasses;

public class NotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFoundException(String objectName) {
		super(objectName.concat(" was not found."));
	}
}
