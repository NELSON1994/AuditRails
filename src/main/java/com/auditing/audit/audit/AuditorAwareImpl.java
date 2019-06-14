package com.auditing.audit.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
//  ----  JPA can analyze createdDate and lastModifiedDate using current system
//   ---- time, but what about the createdBy and
//   ---- lastModifiedBy fields? How will JPA recognize what to store in them?
//   ---- To tell JPA about currently logged-in users, we will need to provide an
//   ---- implementation of AuditorAware and override the getCurrentAuditor() method.
//   --- And inside getCurrentAuditor(), we will need to fetch a currently logged-in user.
//   --- As of now, I have provided a hard-coded user, but if you are using Spring Security,
//   --- then use it to find the currently logged-in user.

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("Nelson");


        //  ------below commented code is used when  Spring Security is applied------
    }

}

// -----use this code if spring security is applied------

//----public User getCurrentAuditor(){
//
//Authentication a=SecurityContxtHolder.getContext().getAuthentication();
//if(authentication == null || !authentication.isAuthenticated()){
//    return null;
//        }
//        return ((MyUserDetails) a.getPrincipal()).getUser();
//        }
//}----
