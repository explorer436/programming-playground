package com.my.company.visitorpattern.withthepattern;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);

    void visit(SquirrelMailClient mailClient);

    void visit(ZimbraMailClient mailClient);
}
