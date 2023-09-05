package com.gitee.freakchicken.blindjava;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class C_ROjc6H9U {

    public static void main(String[] p_As6VJO8i) throws FileNotFoundException {
        File lf_VFSLEHmO = new File("D:\\git\\blindjava-vip\\src\\test\\java\\com\\gitee\\freakchicken\\blindjava\\Test2.java");
        JavaParser lf_Hh6yvdgE = new JavaParser();
        ParseResult<CompilationUnit> lf_9lQjM6s4 = lf_Hh6yvdgE.parse(lf_VFSLEHmO);
        if (lf_9lQjM6s4.isSuccessful()) {
            Optional<CompilationUnit> lf_r1AAQQeh = lf_9lQjM6s4.getResult();
            CompilationUnit lf_oUf7Uh7S = lf_r1AAQQeh.get();
            List<Node> lf_p0aPvqOi = lf_oUf7Uh7S.getChildNodes();
            System.out.println(lf_p0aPvqOi);
        }
    }
}
