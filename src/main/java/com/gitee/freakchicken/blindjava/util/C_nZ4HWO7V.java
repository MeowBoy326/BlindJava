package com.gitee.freakchicken.blindjava.util;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class C_nZ4HWO7V {

    private static final Logger gf_zMcba07K = LoggerFactory.getLogger(C_nZ4HWO7V.class);

    public static Map<String, String> m_ABgEbiUl(File p_G8fDJrTP) {
        try {
            gf_zMcba07K.info(p_G8fDJrTP.getPath());
            JavaParser lf_SPT7R0mQ = new JavaParser();
            ParseResult<CompilationUnit> lf_1Qwb9iFk = lf_SPT7R0mQ.parse(p_G8fDJrTP);
            if (lf_1Qwb9iFk.isSuccessful()) {
                Optional<CompilationUnit> lf_5olTbn1d = lf_1Qwb9iFk.getResult();
                CompilationUnit lf_d5OT8hRQ = lf_5olTbn1d.get();
                PackageDeclaration lf_n4iVNcFZ = lf_d5OT8hRQ.getPackageDeclaration().get();
                String lf_vqdnZFaU = lf_n4iVNcFZ.getNameAsString();
                NodeList<TypeDeclaration<?>> lf_omCGJJc9 = lf_d5OT8hRQ.getTypes();
                String lf_VHRGeuy7 = lf_omCGJJc9.get(0).getNameAsString();
                Map<String, String> lf_Q3aQPAra = new HashMap<>();
                lf_Q3aQPAra.put("className", lf_vqdnZFaU + "." + lf_VHRGeuy7);
                lf_Q3aQPAra.put("packageName", lf_vqdnZFaU);
                return lf_Q3aQPAra;
            } else {
                throw new RuntimeException("Parse Error");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] p_77myHTxQ) {
        File lf_IdpHAhmR = new File("D:\\git\\super-api\\dbapi-cluster-apiServer\\src\\main\\java\\com\\gitee\\freakchicken\\dbapi\\apiserver\\conf\\FilterConfig.java");
        Map<String, String> lf_TeCY89p6 = C_nZ4HWO7V.m_ABgEbiUl(lf_IdpHAhmR);
    }
}
