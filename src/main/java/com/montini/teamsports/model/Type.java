package com.montini.teamsports.model;

public enum Type {

    USER("U"),
    ADMIN("A");

    private String code;

    Type(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Type fromCode(String code) {
        for (Type status : Type.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!");
    }
}

