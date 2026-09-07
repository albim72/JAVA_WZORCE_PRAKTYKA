public class AppConfig {
    //jedna instancja
    private static AppConfig instance;
    
    //prywatmy konstruktor uniemozliwia new AppConfig()
    private AppConfig() {
        System.out.println("Tworzę konfigurację aplikacji");
    }
    
    //globalny punkt dotępu do obiektu
    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    public void showConfig() {
        System.out.println("Konfiguracja aplikacji");
    }
}
