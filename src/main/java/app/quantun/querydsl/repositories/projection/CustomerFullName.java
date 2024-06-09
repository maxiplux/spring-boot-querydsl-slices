package app.quantun.querydsl.repositories.projection;

public record CustomerFullName(String firstName, String lastName) {

    public String getFullName() {
        return lastName + " " + firstName;
    }
}
