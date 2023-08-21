package org.example;

public class Man extends Person {

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void registerPartnership(Woman partner) {
        if (getPartner() == null && partner.getPartner() == null) {
            setPartner(partner);
            partner.setPartner(this);
            if (this.getLastName().equals(partner.getLastName())) {
                partner.setLastName(partner.revertLastName());
            }
        }
    }
}
