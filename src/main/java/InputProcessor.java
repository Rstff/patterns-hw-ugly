import person.Person;

public class InputProcessor {

    public final String processInput(final String input) {

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);
            Person person = new Person.PersonBuilder(input)
                    .setFio(intCode)
                    .setPhysical(intCode)
                    .setAppearance(intCode)
                    .setPhone(input, intCode)
                    .personBuild();
            return person.toString();
        }
        return "Неверный ввод.";
    }
}
