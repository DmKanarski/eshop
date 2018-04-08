package by.kanarski.eshop.validation;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class ValidationRegExps {

    public static final String COMMAS = "[,._]";
    public static final String FIRST_IN_LIST = "^[A-Яа-я\\w- ]+, ";
    public static final String LAST_IN_LIST = ", [A-Яа-я\\w- ]+$";
    public static final String N_IN_LIST = ", [A-Яа-я\\w- ]+, ";
    public static final String USERNAME_REGEXP = "^[a-z0-9_-]{8,16}$";
    public static final String EMAIL_REGEXP = "^[0-9a-zA-Zа-яА-я]*[@][a-z]*[.][a-z]{1,3}$";
    public static final String PASSWORD_REGEXP = "^[a-z0-9_-]{6,18}$";
    public static final String NAME_REGEXP = "[А-Яа-я\\w]{1,25}";
    public static final String SKYPE_REGEXP = "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}";
    public static final String PHONE_REGEXP = ".+";

}
