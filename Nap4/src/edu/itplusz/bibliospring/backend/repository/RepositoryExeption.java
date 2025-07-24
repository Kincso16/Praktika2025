package edu.itplusz.bibliospring.backend.repository;

public class RepositoryExeption extends RuntimeException {
    public RepositoryExeption(String message) {
        super(message);
    }

    public RepositoryExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
