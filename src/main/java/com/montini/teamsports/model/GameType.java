package com.montini.teamsports.model;

public enum GameType {
    SINGLES_OPEN("SO"),
    SINGLES_CLOSE("SC"),
    DOUBLES_OPEN("DO"),
    DOUBLES_CLOSE("DC");
    private String code;

    GameType(String code) {
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
