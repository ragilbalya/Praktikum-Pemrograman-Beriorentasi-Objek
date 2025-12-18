package studi_kasus;

public class MainLoginTracker {
    public static void main(String[] args) {

        LoginTracker tracker = new LoginTracker();

        tracker.loginAttempt("nabil", false);
        tracker.loginAttempt("nabil", true);
        tracker.loginAttempt("agus", true);

        System.out.println("Nabil aktif? " + tracker.isActive("nabil"));
        System.out.println("Jumlah percobaan Nabil: " + tracker.getAttempts("nabil"));

        tracker.logout("nabil");
        System.out.println("Nabil aktif setelah logout? " + tracker.isActive("nabil"));
    }
}