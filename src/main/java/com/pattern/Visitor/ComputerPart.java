package com.pattern.Visitor;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}