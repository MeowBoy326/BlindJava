package com.gitee.freakchicken.blindjava.handler;

import com.gitee.freakchicken.blindjava.util.C_0wyqfnek;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class C_NZyJv9pS {

    private static final Logger gf_Rs87mg7O = LoggerFactory.getLogger(C_NZyJv9pS.class);

    private static final String gf_WCDp90KI = C_0wyqfnek.gf_K8wuLk24 + "step3" + File.separator;

    private static final String gf_Q1vHXqL1 = C_0wyqfnek.gf_K8wuLk24 + "step4" + File.separator;

    private static boolean m_rKBQU6V2(String p_tJJrJ4Lj) {
        for (String lf_ngUqDPn9 : C_0wyqfnek.gf_b7ItIRzD) {
            String lf_vhj2ujGG = gf_WCDp90KI + lf_ngUqDPn9;
            if (p_tJJrJ4Lj.startsWith(lf_vhj2ujGG)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] p_9uGutaHo) throws IOException {
        C_NZyJv9pS lf_7teAwa8b = new C_NZyJv9pS();
        lf_7teAwa8b.m_edHRDDwM();
    }

    public void m_edHRDDwM() throws IOException {
        FileUtils.deleteDirectory(new File(gf_Q1vHXqL1));
        Collection<File> lf_LJzW4tRI = FileUtils.listFiles(new File(gf_WCDp90KI), null, true);
        lf_LJzW4tRI.stream().filter(lambda_lf_PISoXzJk -> !m_rKBQU6V2(lambda_lf_PISoXzJk.getPath()) && lambda_lf_PISoXzJk.isFile()).forEach(lambda_lf_e4l9EQcp -> {
            String lf_QVjyqhRG = lambda_lf_e4l9EQcp.getPath();
            String lf_zEvzTE2c = lf_QVjyqhRG.substring(gf_WCDp90KI.length());
            String lf_qPv3aTAg = gf_Q1vHXqL1 + lf_zEvzTE2c;
            File lf_qpcaTlse = new File(lf_qPv3aTAg);
            try {
                FileUtils.forceMkdirParent(lf_qpcaTlse);
                lf_qpcaTlse.createNewFile();
                if (lambda_lf_e4l9EQcp.getName().endsWith(".java")) {
                    String lf_dAQXKAbl = m_vC8ycnwE(lambda_lf_e4l9EQcp);
                    IOUtils.write(lf_dAQXKAbl, new FileOutputStream(lf_qpcaTlse), Charsets.UTF_8);
                } else {
                    IOUtils.copy(new FileInputStream(lambda_lf_e4l9EQcp), new FileOutputStream(lf_qpcaTlse));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String m_vC8ycnwE(File p_U0qkMiBN) throws FileNotFoundException {
        JavaParser lf_HYavB88g = new JavaParser();
        ParseResult<CompilationUnit> lf_h2QrVu9W = lf_HYavB88g.parse(p_U0qkMiBN);
        if (lf_h2QrVu9W.isSuccessful()) {
            Optional<CompilationUnit> lf_SgBKBSbV = lf_h2QrVu9W.getResult();
            CompilationUnit lf_SSwNWCsk = lf_SgBKBSbV.get();
            List<Node> lf_tHkdNrBJ = lf_SSwNWCsk.getChildNodes();
            m_g17TWlcr(lf_tHkdNrBJ);
            String lf_C7yPzFpd = lf_SSwNWCsk.toString();
            return lf_C7yPzFpd;
        } else {
            throw new RuntimeException("Parse Error");
        }
    }

    private void m_g17TWlcr(List<Node> p_EGycVM96) {
        for (Node lf_wXG8nsdC : p_EGycVM96) {
            Optional<Comment> lf_NMJT8Zfp = lf_wXG8nsdC.getComment();
            if (lf_NMJT8Zfp.isPresent()) {
                lf_wXG8nsdC.removeComment();
            } else {
                if (lf_wXG8nsdC instanceof LineComment) {
                    LineComment lf_4GN2kNHY = (LineComment) lf_wXG8nsdC;
                    lf_4GN2kNHY.setContent("");
                } else if (lf_wXG8nsdC instanceof JavadocComment) {
                    JavadocComment lf_V8br45La = (JavadocComment) lf_wXG8nsdC;
                    lf_V8br45La.setContent("");
                }
            }
            if (lf_wXG8nsdC.getChildNodes().size() > 0) {
                m_g17TWlcr(lf_wXG8nsdC.getChildNodes());
            }
        }
    }
}
