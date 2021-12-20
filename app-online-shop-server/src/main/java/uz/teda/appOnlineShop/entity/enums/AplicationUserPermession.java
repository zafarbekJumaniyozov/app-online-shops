package uz.teda.appOnlineShop.entity.enums;

public enum AplicationUserPermession {
STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write"),
    INPUT_READ("input:read"),
    INPUT_WRITE("input:write"),
OUTPUT_READ("output:read"),
OUTPUT_WRITE("output:write");


    private final String permission;

    AplicationUserPermession(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
