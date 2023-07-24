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
    public static class Login {
        private String rusSymbols;
        private String specSymbols;
        private String spaceSymbol;
        public Login (String rusSymbols, String specSymbols, String spaceSymbol) {
            this.rusSymbols = rusSymbols;
            this.specSymbols = specSymbols;
            this.spaceSymbol = spaceSymbol;
        }
        public String getRusSymbols(){
            return rusSymbols;
        }
        public String getSpecSymbols(){
            return specSymbols;
        }
        public String getSpaceSymbol(){
            return spaceSymbol;
        }
    }

    public static User correctUser() {
        return new User("login2", "password2");
    }
    public static User inCorrectUser() {
        return new User("login3", "password3");
    }
    public static User bottomLineUser(){
        return new User("12", "12");
    }
    public static User upperLineUser(){
        return new User("123456789012345678901234567890123",
                "123456789012345678901234567890123");
    }
    public static Login badLogin(){
        return new Login("Ая", ";#*()^/", " ");
    }
}
