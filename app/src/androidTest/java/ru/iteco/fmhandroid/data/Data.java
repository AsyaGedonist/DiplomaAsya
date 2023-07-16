package ru.iteco.fmhandroid.data;

public class Data {
    public static class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static User correctUser() {
        return new User("login2", "password2");
    }
}
