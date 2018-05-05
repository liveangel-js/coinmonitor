package org.liveangel.A.domain;

/**
 * Created by liveangel on 2018-5-5.
 */
public class Subscriber {

    public Subscriber(String email){
        this.email = email;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
