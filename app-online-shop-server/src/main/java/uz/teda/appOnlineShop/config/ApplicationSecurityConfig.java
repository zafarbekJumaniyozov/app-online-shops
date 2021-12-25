package uz.teda.appOnlineShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static uz.teda.appOnlineShop.entity.enums.AplicationUserPermession.COURSE_WRITE;
import static uz.teda.appOnlineShop.entity.enums.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable() //todo: I will teach this in detail in the next section
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasAnyRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();


    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails jumaniyozovUser=User.builder()
                .username("Jumaniyozov")
                .password(passwordEncoder.encode("Password"))
//                .roles(CEO.name())
                .authorities(CEO.getGrantedAuthority())
        .build();
        UserDetails NizomjonUser=User.builder()
                .username("Nizomjon")
                .password(passwordEncoder.encode("123"))
         //       .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthority())
                .build();
     UserDetails XursandUser=User.builder()
                .username("Xursand")
                .password(passwordEncoder.encode("123"))

      //       .roles(ADMINTRAINEE.name())
             .authorities(ADMINTRAINEE.getGrantedAuthority())
                .build();
        UserDetails ODAMBOYUser=User.builder()
                .username("ODAMBOY")
                .password(passwordEncoder.encode("1234"))
      //          .roles(KASSIR.name())
                .authorities(KASSIR.getGrantedAuthority())
                .build();
        UserDetails ALISHERUser= User.builder()
                .username("ALISHER")
                .password(passwordEncoder.encode("12345"))
      //          .roles(BUGALTER.name())
                .authorities(BUGALTER.getGrantedAuthority())
                .build();
        UserDetails azizbek = User.builder()
                .username("AZIZBEK")
                .password(passwordEncoder.encode("2234"))
        //        .roles(MENAGER.name())
                .authorities(MENAGER.getGrantedAuthority())
                .build();
        UserDetails SOBIRJONUser=User.builder()
                .username("SOBIRJON")
                .password(passwordEncoder.encode("3234"))
        //        .roles(MOBILE_CEO.name())
                .authorities(MOBILE_CEO.getGrantedAuthority())
                .build();
        UserDetails SobirUser=  User.builder()
                .username("SOBIRJON S")
                .password(passwordEncoder.encode("32345"))
       //         .roles("MOBIL CEO ")
                .authorities(MOBILE_CEO.getGrantedAuthority())
                .build();
    UserDetails Zafarbek=  User.builder()
                .username("Zafarbek")
                .password(passwordEncoder.encode("52345"))
       //         .roles(STUDENT.name())
            .authorities(STUDENT.getGrantedAuthority())
                .build();
        return new
                InMemoryUserDetailsManager(
                        jumaniyozovUser,
                NizomjonUser,
                SOBIRJONUser,
                SobirUser,
                ALISHERUser,
                ODAMBOYUser,
                azizbek,
                Zafarbek,XursandUser





        );



    }
}
