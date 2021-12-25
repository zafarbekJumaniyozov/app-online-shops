package uz.teda.appOnlineShop.entity.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static uz.teda.appOnlineShop.entity.enums.AplicationUserPermession.*;

public enum ApplicationUserRole {
    CEO(Sets.newHashSet(INPUT_READ, INPUT_WRITE, OUTPUT_READ, OUTPUT_WRITE)),
    KASSIR(Sets.newHashSet()),
    MOBILE_CEO(Sets.newHashSet()),
    BUGALTER(Sets.newHashSet()),
    MENAGER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_WRITE, COURSE_READ, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ)),
    STUDENT(Sets.newHashSet(COURSE_READ, STUDENT_READ, STUDENT_WRITE));


    private final Set<AplicationUserPermession> permissions;

    ApplicationUserRole(Set<AplicationUserPermession> permessions) {
        this.permissions = permessions;
    }

    public Set<AplicationUserPermession> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
