package com.imho.context;

import com.imho.domain.entity.user.User;

public class SecurityContextHolder {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUser(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static User getUser() {
        return USER_THREAD_LOCAL.get();
    }
}
