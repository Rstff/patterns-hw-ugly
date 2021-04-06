package person;

import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.appearance.Appearance;

public class Person {

    private String id;
    private Fio fio;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;


    public static class PersonBuilder {
        private final String id;
        private Fio fio;
        private Physical phys;
        private Appearance appearance;
        private Phone phone;

        public PersonBuilder(final String id) {
            this.id = id;
        }

        public final PersonBuilder setFio(final int intCode) {
            final FioGenerator fioGenerator = new FioGenerator();
            this.fio = fioGenerator.generate(intCode);
            return this;
        }

        public final PersonBuilder setPhysical(final int intCode) {
            final PhysGenerator physGenerator = new PhysGenerator();
            this.phys = physGenerator.generate(intCode);
            return this;
        }

        public final PersonBuilder setAppearance(final int intCode) {
            final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
            this.appearance = appearanceGenerator.generate(intCode);
            return this;
        }

        public final PersonBuilder setPhone(final String input, final int intCode) {
            this.phone = null;
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final PhoneGenerator phoneGenerator = new PhoneGenerator();
                this.phone = phoneGenerator.generate(intCode);
                return this;
            }
            return this;
        }

        public final Person personBuild() {
            final Person person = new Person();
            person.id = this.id;
            person.fio = this.fio;
            person.phys = this.phys;
            person.appearance = this.appearance;
            person.phone = this.phone;
            return person;
        }

    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(String.format(fio.toString())).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}