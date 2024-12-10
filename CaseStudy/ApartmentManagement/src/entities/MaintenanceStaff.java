package entities;

public class MaintenanceStaff extends User {
    private String skillSet;

    public MaintenanceStaff(String username, String password, String role, String skillSet) {
        super(username, password, role);
        this.skillSet = skillSet;
    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public void displayRoleSpecificInfo() {
        System.out.println("Maintenance Skills: " + skillSet);
    }

    @Override
    public String toString() {
        return super.toString() + ", Skill Set='" + skillSet + '\'';
    }
}
