package hello.hellospring.controller;

public class MemberForm {
    // resources/templates/members/createMember-Form.html의 name이랑 매칭
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
