package tongatar111.shop.entity.enumeration;

public enum UserRole {

    ADMIN("Администратор"),
    MODERATOR("Модератор"),
    USER("Пользователь");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
