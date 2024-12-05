package RegularExpression;

public class Main {
    private static final String[] validName = {"C7893A", "P2342H", "A5671L"};
    private static final String[] inValidName = {"C78a3A", "p2342H", "A56712"};

    public static void main(String[] args) {
        ValidateNameClassroom validateName = new ValidateNameClassroom();
        for (String nameClassroom : validName) {
            System.out.println("Name \"" + nameClassroom + "\" is valid " + validateName.validate(nameClassroom));
        }
        for (String nameClassroom : inValidName) {
            System.out.println("Name \"" + nameClassroom + "\" is valid " + validateName.validate(nameClassroom));
        }

    }
}
