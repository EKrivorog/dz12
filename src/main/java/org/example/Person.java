package org.example;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean isRetired() {
        if (this instanceof Woman) {
            return age >= 65;
        } else {
            return age >= 60;
        }
    }

    public void registerPartnership(Person partner) {
        if (this.partner == null && partner.partner == null) {
            this.partner = partner;
            partner.partner = this;

            if (this instanceof Woman) {
                this.lastName = partner.lastName;
            } else if (partner instanceof Woman) {
                partner.lastName = this.lastName;
            }
        }
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null) {
            Person partner = this.partner;
            this.partner = null;
            partner.partner = null;

            if (revertLastName && this instanceof Woman && partner instanceof Man) {
                this.lastName = revertLastName();
            } else if (revertLastName && this instanceof Man && partner instanceof Woman) {
                partner.lastName = partner.revertLastName();
            }
        }
    }

    protected String revertLastName() {
        return lastName;
    }

    public abstract String getFullName();
}
