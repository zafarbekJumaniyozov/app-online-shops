package uz.teda.appOnlineShop.entity.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static uz.teda.appOnlineShop.entity.enums.AplicationUserPermession.*;

public enum ApplicationUserRole {
    CEO(Sets.newHashSet(INPUT_READ,INPUT_WRITE,OUTPUT_READ,OUTPUT_WRITE)),
        KASSIR(Sets.newHashSet()),
    MOBILE_CEO(Sets.newHashSet()),
      BUGALTER(Sets.newHashSet()),
       MENAGER(Sets.newHashSet()),
         ADMIN(Sets.newHashSet(COURSE_WRITE,COURSE_READ,STUDENT_READ,STUDENT_WRITE)),
       STUDENT(Sets.newHashSet(COURSE_READ,STUDENT_READ,STUDENT_WRITE));


    private final Set<AplicationUserPermession>permessions;

    ApplicationUserRole(Set<AplicationUserPermession> permessions) {
        this.permessions = permessions;
    }
}
