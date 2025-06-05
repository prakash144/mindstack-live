class Account {
    private String userName;
    private String password;
    private AccountStatus status;

    public Account(String userName, String password, AccountStatus status) {
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password reset successfully for user: " + userName);
    }
}