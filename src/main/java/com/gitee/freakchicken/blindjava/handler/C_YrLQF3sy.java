package com.gitee.freakchicken.blindjava.handler;

import com.gitee.freakchicken.blindjava.util.C_0wyqfnek;
import com.gitee.freakchicken.blindjava.util.C_nZ4HWO7V;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.InitializerDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.stmt.BlockStmt;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class C_YrLQF3sy {

    private static final Logger gf_mJpnPYET = LoggerFactory.getLogger(C_YrLQF3sy.class);

    private static Map<String, Map<String, String>> gf_WSVBsSEg = new HashMap<>();

    List<File> gf_KOGhK1CK = new ArrayList<>();

    public static void main(String[] p_biTJFn1z) throws IOException {
        C_YrLQF3sy lf_FSZbRLLY = new C_YrLQF3sy();
        lf_FSZbRLLY.m_BhumHUxF();
    }

    public void m_BhumHUxF() throws IOException {
        m_911o2fFv();
        Collection<File> lf_8PbhPrOh = FileUtils.listFiles(new File(C_0wyqfnek.gf_vmUSIpx3), null, true);
        String lf_0jHk7M4B = C_0wyqfnek.gf_K8wuLk24 + "step1" + File.separator;
        FileUtils.deleteDirectory(new File(lf_0jHk7M4B));
        lf_8PbhPrOh.stream().filter(lambda_lf_uJSnkfqG -> !C_0wyqfnek.m_Czz3GRco(lambda_lf_uJSnkfqG.getPath()) && lambda_lf_uJSnkfqG.isFile()).forEach(lambda_lf_aDv5Zknt -> {
            String lf_cU3YqVgX = lambda_lf_aDv5Zknt.getPath();
            String lf_YA2kctSV = lf_cU3YqVgX.substring(C_0wyqfnek.gf_vmUSIpx3.length());
            File lf_x9QeOwM2 = new File(lf_0jHk7M4B + lf_YA2kctSV);
            try {
                FileUtils.forceMkdirParent(lf_x9QeOwM2);
                lf_x9QeOwM2.createNewFile();
                if (lambda_lf_aDv5Zknt.getName().endsWith(".java")) {
                    Map<String, String> lf_4ZbxBzgI = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_aDv5Zknt);
                    gf_mJpnPYET.info(lf_4ZbxBzgI.get("packageName") + ":" + lf_4ZbxBzgI.get("className"));
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_4ZbxBzgI.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_4ZbxBzgI.get("className")))) {
                        String lf_7Xp1CFjE = m_MJKJeCZs(lambda_lf_aDv5Zknt);
                        IOUtils.write(lf_7Xp1CFjE, new FileOutputStream(lf_x9QeOwM2), Charsets.UTF_8);
                        gf_KOGhK1CK.add(lf_x9QeOwM2);
                    } else {
                        gf_mJpnPYET.info("excluded: " + lf_0jHk7M4B);
                        IOUtils.copy(new FileInputStream(lambda_lf_aDv5Zknt), new FileOutputStream(lf_x9QeOwM2));
                    }
                } else {
                    IOUtils.copy(new FileInputStream(lambda_lf_aDv5Zknt), new FileOutputStream(lf_x9QeOwM2));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gf_mJpnPYET.info("变量名混淆成功");
    }

    private void m_911o2fFv() throws IOException {
        Collection<File> lf_U1ApkvaM = FileUtils.listFiles(new File(C_0wyqfnek.gf_vmUSIpx3), null, true);
        String lf_9z1gOFyX = C_0wyqfnek.gf_K8wuLk24 + "step1" + File.separator;
        FileUtils.deleteDirectory(new File(lf_9z1gOFyX));
        lf_U1ApkvaM.stream().filter(lambda_lf_ocm9ZBFd -> !C_0wyqfnek.m_Czz3GRco(lambda_lf_ocm9ZBFd.getPath()) && lambda_lf_ocm9ZBFd.isFile()).forEach(lambda_lf_QTXCMexI -> {
            try {
                if (lambda_lf_QTXCMexI.getName().endsWith(".java")) {
                    Map<String, String> lf_afPUwNUb = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_QTXCMexI);
                    gf_mJpnPYET.info(lf_afPUwNUb.get("packageName") + ":" + lf_afPUwNUb.get("className"));
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_afPUwNUb.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_afPUwNUb.get("className")))) {
                        m_WnBlPfCN(lambda_lf_QTXCMexI);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void m_WnBlPfCN(File p_I2CCgQir) throws FileNotFoundException {
        String lf_y8XBzVEz = null;
        JavaParser lf_ipl09Htb = new JavaParser();
        ParseResult<CompilationUnit> lf_1GMdPeRP = lf_ipl09Htb.parse(p_I2CCgQir);
        if (lf_1GMdPeRP.isSuccessful()) {
            Optional<CompilationUnit> lf_Wnold7pn = lf_1GMdPeRP.getResult();
            CompilationUnit lf_674ycgYI = lf_Wnold7pn.get();
            List<Node> lf_B8Sb6Zrk = lf_674ycgYI.getChildNodes();
            for (Node lf_tZClGsYu : lf_B8Sb6Zrk) {
                if (lf_tZClGsYu instanceof ImportDeclaration) {
                } else if (lf_tZClGsYu instanceof PackageDeclaration) {
                    lf_y8XBzVEz = ((PackageDeclaration) lf_tZClGsYu).getNameAsString();
                } else if (lf_tZClGsYu instanceof ClassOrInterfaceDeclaration) {
                    ClassOrInterfaceDeclaration lf_T5bRk4xE = (ClassOrInterfaceDeclaration) lf_tZClGsYu;
                    String lf_r649z4sY = lf_T5bRk4xE.getNameAsString();
                    List<FieldDeclaration> lf_1WEaJSRI = lf_T5bRk4xE.getFields();
                    String lf_8RrgYuVx = lf_y8XBzVEz + "." + lf_r649z4sY;
                    Map<String, String> lf_uJBfoXns = new HashMap<String, String>();
                    for (FieldDeclaration lf_1VJWSXWa : lf_1WEaJSRI) {
                        NodeList<VariableDeclarator> lf_eoyPbkVU = lf_1VJWSXWa.getVariables();
                        for (VariableDeclarator lf_rqB6uONR : lf_eoyPbkVU) {
                            String lf_sIjgIksh = lf_rqB6uONR.getNameAsString();
                            lf_uJBfoXns.put(lf_sIjgIksh, "gf_" + RandomStringUtils.random(8, true, true));
                        }
                    }
                    gf_WSVBsSEg.put(lf_8RrgYuVx, lf_uJBfoXns);
                }
            }
        } else {
            throw new RuntimeException("Parse Error");
        }
    }

    public String m_MJKJeCZs(File p_VuOLd7gb) throws FileNotFoundException {
        JavaParser lf_eR0MKdPs = new JavaParser();
        ParseResult<CompilationUnit> lf_N2t4p12e = lf_eR0MKdPs.parse(p_VuOLd7gb);
        if (lf_N2t4p12e.isSuccessful()) {
            Optional<CompilationUnit> lf_Hc8OKACB = lf_N2t4p12e.getResult();
            CompilationUnit lf_380WoPGW = lf_Hc8OKACB.get();
            PackageDeclaration lf_aGVTojqI = lf_380WoPGW.getPackageDeclaration().get();
            String lf_XvBQ9nO7 = lf_aGVTojqI.getNameAsString();
            NodeList<ImportDeclaration> lf_XKHLHPhm = lf_380WoPGW.getImports();
            List<String> lf_4AsZSB3c = lf_XKHLHPhm.stream().map(lambda_lf_42Flum6O -> lambda_lf_42Flum6O.getNameAsString()).collect(Collectors.toList());
            List<Node> lf_gTNldmC0 = lf_380WoPGW.getChildNodes();
            StringBuffer lf_h8BOduVX = new StringBuffer();
            for (Node lf_CJRdB6Bp : lf_gTNldmC0) {
                if (lf_CJRdB6Bp instanceof ImportDeclaration) {
                } else if (lf_CJRdB6Bp instanceof PackageDeclaration) {
                    // 
                } else if (lf_CJRdB6Bp instanceof ClassOrInterfaceDeclaration) {
                    ClassOrInterfaceDeclaration lf_I5Fy4nQ8 = (ClassOrInterfaceDeclaration) lf_CJRdB6Bp;
                    String lf_oeOoRwZd = lf_I5Fy4nQ8.getNameAsString();
                    List<Node> lf_x0jyR00L = lf_I5Fy4nQ8.getChildNodes();
                    List<MethodDeclaration> lf_1Z3gSsYp = lf_I5Fy4nQ8.getMethods();
                    List<FieldDeclaration> lf_BUJgNAZo = lf_I5Fy4nQ8.getFields();
                    String lf_j7OiTJyS = lf_XvBQ9nO7 + "." + lf_oeOoRwZd;
                    if (lf_I5Fy4nQ8.isInterface()) {
                    } else {
                        for (MethodDeclaration lf_EOkBclXh : lf_1Z3gSsYp) {
                            Map<String, String> lf_vtChmzax = new HashMap<>();
                            NodeList<AnnotationExpr> lf_UbiKBq2k = lf_EOkBclXh.getAnnotations();
                            List<String> lf_BS1OYtR2 = lf_UbiKBq2k.stream().map(lambda_lf_dYKmcugZ -> lambda_lf_dYKmcugZ.getNameAsString()).collect(Collectors.toList());
                            if (C_0wyqfnek.m_Y11kecGR(lf_XvBQ9nO7, lf_j7OiTJyS) || C_0wyqfnek.m_5C6xOsAg(lf_BS1OYtR2)) {
                                // 
                            } else {
                                NodeList<Parameter> lf_MQMhmAzk = lf_EOkBclXh.getParameters();
                                for (Parameter lf_nWZuB9Xb : lf_MQMhmAzk) {
                                    String lf_K73qmgfi = lf_nWZuB9Xb.getNameAsString();
                                    lf_vtChmzax.put(lf_K73qmgfi, "p_" + RandomStringUtils.random(8, true, true));
                                    lf_nWZuB9Xb.setName(lf_vtChmzax.get(lf_K73qmgfi));
                                }
                            }
                            Optional<BlockStmt> lf_YUcuOpNj = lf_EOkBclXh.getBody();
                            if (lf_YUcuOpNj.isPresent()) {
                                m_WAkQm4hJ(lf_YUcuOpNj.get().getChildNodes(), lf_vtChmzax);
                            }
                        }
                        Map<String, String> lf_DqA0DV21 = gf_WSVBsSEg.get(lf_j7OiTJyS);
                        for (FieldDeclaration lf_j5P8Qutj : lf_BUJgNAZo) {
                            NodeList<VariableDeclarator> lf_BowYG61F = lf_j5P8Qutj.getVariables();
                            for (VariableDeclarator lf_cWIGVn7T : lf_BowYG61F) {
                                String lf_ymcyxdNb = lf_cWIGVn7T.getNameAsString();
                                lf_cWIGVn7T.setName(lf_DqA0DV21.get(lf_ymcyxdNb));
                                // 
                                m_WAkQm4hJ(lf_cWIGVn7T.getChildNodes(), lf_DqA0DV21);
                            }
                        }
                        for (MethodDeclaration lf_QBlzv4fY : lf_1Z3gSsYp) {
                            Optional<BlockStmt> lf_imdiZ4OW = lf_QBlzv4fY.getBody();
                            if (lf_imdiZ4OW.isPresent()) {
                                m_Zn8DcsQB(lf_imdiZ4OW.get().getChildNodes(), lf_DqA0DV21);
                            }
                        }
                        List<InitializerDeclaration> lf_CRNPnrqh = lf_x0jyR00L.stream().filter(lambda_lf_i1Pv95vq -> lambda_lf_i1Pv95vq instanceof InitializerDeclaration).map(lambda_lf_DPNHB4dk -> (InitializerDeclaration) lambda_lf_DPNHB4dk).collect(Collectors.toList());
                        for (InitializerDeclaration lf_1LJsTNen : lf_CRNPnrqh) {
                            List<Node> lf_VhD200SJ = lf_1LJsTNen.getChildNodes();
                            m_WAkQm4hJ(lf_VhD200SJ, new HashMap<String, String>());
                            m_Zn8DcsQB(lf_VhD200SJ, lf_DqA0DV21);
                        }
                        List<ConstructorDeclaration> lf_bhZAxAJN = lf_x0jyR00L.stream().filter(lambda_lf_8BcGhZnT -> lambda_lf_8BcGhZnT instanceof ConstructorDeclaration).map(lambda_lf_wiLvSEy5 -> (ConstructorDeclaration) lambda_lf_wiLvSEy5).collect(Collectors.toList());
                        for (ConstructorDeclaration lf_zOtXNfBh : lf_bhZAxAJN) {
                            List<Node> lf_T8NVSfKd = lf_zOtXNfBh.getChildNodes();
                            Map<String, String> lf_yozYuGGb = new HashMap<String, String>();
                            NodeList<Parameter> lf_anBmXPnL = lf_zOtXNfBh.getParameters();
                            for (Parameter lf_zkq2gVcB : lf_anBmXPnL) {
                                String lf_MxqYSJwE = lf_zkq2gVcB.getNameAsString();
                                lf_yozYuGGb.put(lf_MxqYSJwE, "p_" + RandomStringUtils.random(8, true, true));
                                lf_zkq2gVcB.setName(lf_yozYuGGb.get(lf_MxqYSJwE));
                            }
                            m_WAkQm4hJ(lf_T8NVSfKd, lf_yozYuGGb);
                            m_Zn8DcsQB(lf_T8NVSfKd, lf_DqA0DV21);
                        }
                    }
                    m_SVjR7fpM(lf_x0jyR00L, gf_WSVBsSEg, lf_4AsZSB3c, lf_XvBQ9nO7);
                } else {
                }
                lf_h8BOduVX.append(lf_CJRdB6Bp.toString());
            }
            return lf_h8BOduVX.toString();
        } else {
            throw new RuntimeException("Parse Error");
        }
    }

    public void m_WAkQm4hJ(List<Node> p_lVqqHY3a, Map<String, String> p_JnEl7eby) {
        for (Node lf_STQwoZ7n : p_lVqqHY3a) {
            // 
            // 
            if (lf_STQwoZ7n instanceof VariableDeclarator) {
                VariableDeclarator lf_SfHEQo8Y = (VariableDeclarator) lf_STQwoZ7n;
                p_JnEl7eby.put(lf_SfHEQo8Y.getNameAsString(), "lf_" + RandomStringUtils.random(8, true, true));
                lf_SfHEQo8Y.setName(p_JnEl7eby.get(lf_SfHEQo8Y.getNameAsString()));
            }
            // 
            if (lf_STQwoZ7n instanceof LambdaExpr) {
                LambdaExpr lf_yFaPRWey = (LambdaExpr) lf_STQwoZ7n;
                NodeList<Parameter> lf_KAXMetUI = lf_yFaPRWey.getParameters();
                for (Parameter lf_cl8JTJH5 : lf_KAXMetUI) {
                    p_JnEl7eby.put(lf_cl8JTJH5.getNameAsString(), "lambda_lf_" + RandomStringUtils.random(8, true, true));
                    lf_cl8JTJH5.setName(p_JnEl7eby.get(lf_cl8JTJH5.getNameAsString()));
                }
            }
            if (lf_STQwoZ7n instanceof NameExpr) {
                NameExpr lf_rH6tRuWY = (NameExpr) lf_STQwoZ7n;
                if (p_JnEl7eby.containsKey(lf_rH6tRuWY.getNameAsString())) {
                    lf_rH6tRuWY.setName(p_JnEl7eby.get(lf_rH6tRuWY.getNameAsString()));
                }
            } else {
                List<Node> lf_L3yakWKo = lf_STQwoZ7n.getChildNodes();
                if (lf_L3yakWKo.size() > 0) {
                    m_WAkQm4hJ(lf_L3yakWKo, p_JnEl7eby);
                }
            }
        }
    }

    public void m_Zn8DcsQB(List<Node> p_9DbQmm5i, Map<String, String> p_C6py0des) {
        for (Node lf_A0vKoBVW : p_9DbQmm5i) {
            if (lf_A0vKoBVW instanceof NameExpr) {
                NameExpr lf_cgVzpVZn = (NameExpr) lf_A0vKoBVW;
                if (p_C6py0des.containsKey(lf_cgVzpVZn.getNameAsString())) {
                    lf_cgVzpVZn.setName(p_C6py0des.get(lf_cgVzpVZn.getNameAsString()));
                }
            } else if (lf_A0vKoBVW instanceof FieldAccessExpr) {
                FieldAccessExpr lf_et0jMHaf = (FieldAccessExpr) lf_A0vKoBVW;
                if (p_C6py0des.containsKey(lf_et0jMHaf.getNameAsString())) {
                    lf_et0jMHaf.setName(p_C6py0des.get(lf_et0jMHaf.getNameAsString()));
                }
            } else {
                List<Node> lf_Fkvq34ri = lf_A0vKoBVW.getChildNodes();
                if (lf_Fkvq34ri.size() > 0) {
                    m_Zn8DcsQB(lf_Fkvq34ri, p_C6py0des);
                }
            }
        }
    }

    public void m_SVjR7fpM(List<Node> p_l6h82VFO, Map<String, Map<String, String>> p_fHklhVGE, List<String> p_714wP4Vt, String p_lKtE3LkW) {
        for (Node lf_n4A56aK4 : p_l6h82VFO) {
            if (lf_n4A56aK4 instanceof FieldAccessExpr) {
                List<Node> lf_YmUQXSAy = lf_n4A56aK4.getChildNodes();
                if (lf_YmUQXSAy.size() == 2 && lf_YmUQXSAy.get(0) instanceof NameExpr && lf_YmUQXSAy.get(1) instanceof SimpleName) {
                    NameExpr lf_zAAmyyLo = (NameExpr) lf_YmUQXSAy.get(0);
                    SimpleName lf_EULCapmh = (SimpleName) lf_YmUQXSAy.get(1);
                    String lf_sWL8vVNF = lf_zAAmyyLo.getNameAsString();
                    Optional<String> lf_qXtqLuT7 = p_714wP4Vt.stream().filter(lambda_lf_08vm9z44 -> lambda_lf_08vm9z44.substring(lambda_lf_08vm9z44.lastIndexOf(".") + 1).equals(lf_sWL8vVNF)).findFirst();
                    if (lf_qXtqLuT7.isPresent()) {
                        String lf_OgaTEZEu = lf_qXtqLuT7.get();
                        if (p_fHklhVGE.containsKey(lf_OgaTEZEu)) {
                            Map<String, String> lf_MvKJGE1N = p_fHklhVGE.get(lf_OgaTEZEu);
                            if (lf_MvKJGE1N.containsKey(lf_EULCapmh.getIdentifier())) {
                                lf_EULCapmh.setIdentifier(lf_MvKJGE1N.get(lf_EULCapmh.getIdentifier()));
                            }
                        }
                    } else {
                        String lf_znGN5Pdr = p_lKtE3LkW + "." + lf_sWL8vVNF;
                        if (p_fHklhVGE.containsKey(lf_znGN5Pdr)) {
                            Map<String, String> lf_pogTQsOV = p_fHklhVGE.get(lf_znGN5Pdr);
                            if (lf_pogTQsOV.containsKey(lf_EULCapmh.getIdentifier())) {
                                lf_EULCapmh.setIdentifier(lf_pogTQsOV.get(lf_EULCapmh.getIdentifier()));
                            }
                        }
                    }
                }
            } else {
                List<Node> lf_YxQo55v6 = lf_n4A56aK4.getChildNodes();
                if (lf_YxQo55v6.size() > 0) {
                    m_SVjR7fpM(lf_YxQo55v6, p_fHklhVGE, p_714wP4Vt, p_lKtE3LkW);
                }
            }
        }
    }
}
