package com.jet.hexagonale.domain;

public class DomainException extends RuntimeException {
    DomainException(final String message) {
        super(message);
    }
}
