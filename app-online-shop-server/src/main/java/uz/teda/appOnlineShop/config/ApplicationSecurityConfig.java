package uz.teda.appOnlineShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
                .antMatchers("/management/api/**").hasAnyRole(STUDENT.name())
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
                .roles(CEO.name())
        .build();
        UserDetails NizomjonUser=User.builder()
                .username("Nizomjon")
                .password(passwordEncoder.encode("123"))
                .roles(ADMIN.name())
                .build();
     UserDetails XursandUser=User.builder()
                .username("Xursand")
                .password(passwordEncoder.encode("123"))

             .roles(ADMINTRAINEE.name())
                .build();
        UserDetails ODAMBOYUser=User.builder()
                .username("ODAMBOY")
                .password(passwordEncoder.encode("1234"))
                .roles(KASSIR.name())
                .build();
        UserDetails ALISHERUser= User.builder()
                .username("ALISHER")
                .password(passwordEncoder.encode("12345"))
                .roles(BUGALTER.name())
                .build();
        UserDetails azizbek = User.builder()
                .username("AZIZBEK")
                .password(passwordEncoder.encode("2234"))
                .roles(MENAGER.name())
                .build();
        UserDetails SOBIRJONUser=User.builder()
                .username("SOBIRJON")
                .password(passwordEncoder.encode("3234"))
                .roles(MOBILE_CEO.name())
                .build();
        UserDetails SobirUser=  User.builder()
                .username("SOBIRJON S")
                .password(passwordEncoder.encode("32345"))
                .roles("MOBIL CEO ")
                .build();
    UserDetails Zafarbek=  User.builder()
                .username("Zafarbek")
                .password(passwordEncoder.encode("52345"))
                .roles(STUDENT.name())
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
