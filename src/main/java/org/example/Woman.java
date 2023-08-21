package org.example;

public class Woman extends Person {

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void registerPartnership(Man partner) {
        if (getPartner() == null && partner.getPartner() == null) {
            setPartner(partner);
            partner.setPartner(this);
            if (this.getLastName().equals(partner.getLastName())) {
                partner.setLastName(partner.revertLastName());
            }
        }
    }
}
