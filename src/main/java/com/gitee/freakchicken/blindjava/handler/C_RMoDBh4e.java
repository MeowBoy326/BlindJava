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
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class C_RMoDBh4e {

    private static final Logger gf_lZGomCYO = LoggerFactory.getLogger(C_RMoDBh4e.class);

    private static final String gf_I3Yi8slJ = C_0wyqfnek.gf_K8wuLk24 + "step1" + File.separator;

    private static final String gf_a03tQd5J = C_0wyqfnek.gf_K8wuLk24 + "step2" + File.separator;

    // 
    // 
    static Map<String, Map<String, String>> gf_jT8KgeZq = new HashMap<>();

    public static boolean m_uuqjjJyP(String p_FsH1KvxO) {
        for (String lf_RvtauY0l : C_0wyqfnek.gf_b7ItIRzD) {
            String lf_6Xy9A19r = gf_I3Yi8slJ + lf_RvtauY0l;
            if (p_FsH1KvxO.startsWith(lf_6Xy9A19r)) {
                return true;
            }
        }
        return false;
    }

    public static void m_BtSU26Ro() throws IOException {
        FileUtils.deleteDirectory(new File(gf_a03tQd5J));
        Collection<File> lf_a2LXWiIa = FileUtils.listFiles(new File(gf_I3Yi8slJ), null, true);
        lf_a2LXWiIa.stream().filter(lambda_lf_GAqh66gx -> !m_uuqjjJyP(lambda_lf_GAqh66gx.getPath()) && lambda_lf_GAqh66gx.isFile()).forEach(lambda_lf_UAdwxt6V -> {
            String lf_2DGuusIc = lambda_lf_UAdwxt6V.getPath();
            String lf_rYi1bL38 = lf_2DGuusIc.substring(gf_I3Yi8slJ.length());
            String lf_14rAl9py = gf_a03tQd5J + lf_rYi1bL38;
            File lf_3QfJRLtz = new File(lf_14rAl9py);
            try {
                FileUtils.forceMkdirParent(lf_3QfJRLtz);
                lf_3QfJRLtz.createNewFile();
                if (lambda_lf_UAdwxt6V.getName().endsWith(".java")) {
                    Map<String, String> lf_GT665SmY = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_UAdwxt6V);
                    gf_lZGomCYO.info(lf_GT665SmY.get("packageName") + ":" + lf_GT665SmY.get("className"));
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_GT665SmY.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_GT665SmY.get("className")))) {
                        m_DLqej7Li(lambda_lf_UAdwxt6V);
                    } else {
                        gf_lZGomCYO.info("excluded: " + lf_14rAl9py);
                        IOUtils.copy(new FileInputStream(lambda_lf_UAdwxt6V), new FileOutputStream(lf_3QfJRLtz));
                    }
                } else {
                    IOUtils.copy(new FileInputStream(lambda_lf_UAdwxt6V), new FileOutputStream(lf_3QfJRLtz));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        lf_a2LXWiIa.stream().filter(lambda_lf_WWfmsJlv -> !m_uuqjjJyP(lambda_lf_WWfmsJlv.getPath()) && lambda_lf_WWfmsJlv.isFile()).forEach(lambda_lf_5u2Bz9BP -> {
            String lf_00fJQoJ7 = lambda_lf_5u2Bz9BP.getPath();
            String lf_I1eDQAl0 = lf_00fJQoJ7.substring(gf_I3Yi8slJ.length());
            String lf_0uGnstV8 = gf_a03tQd5J + lf_I1eDQAl0;
            File lf_He8CGXGQ = new File(lf_0uGnstV8);
            try {
                FileUtils.forceMkdirParent(lf_He8CGXGQ);
                lf_He8CGXGQ.createNewFile();
                if (lambda_lf_5u2Bz9BP.getName().endsWith(".java")) {
                    Map<String, String> lf_BWwuZCJQ = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_5u2Bz9BP);
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_BWwuZCJQ.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_BWwuZCJQ.get("className")))) {
                        String lf_wSQAfodQ = m_bXCaJTzA(lambda_lf_5u2Bz9BP);
                        IOUtils.write(lf_wSQAfodQ, new FileOutputStream(lf_He8CGXGQ), Charsets.UTF_8);
                    } else {
                        IOUtils.copy(new FileInputStream(lambda_lf_5u2Bz9BP), new FileOutputStream(lf_He8CGXGQ));
                    }
                } else {
                    IOUtils.copy(new FileInputStream(lambda_lf_5u2Bz9BP), new FileOutputStream(lf_He8CGXGQ));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gf_lZGomCYO.info("方法名混淆成功");
    }

    private static String m_bXCaJTzA(File p_m0qlvWYz) throws IOException {
        JavaParser lf_64qbNeMs = new JavaParser();
        ParseResult<CompilationUnit> lf_3wGtLMZa = lf_64qbNeMs.parse(p_m0qlvWYz);
        StringBuffer lf_ZMAGmm4o = new StringBuffer();
        if (lf_3wGtLMZa.isSuccessful()) {
            Optional<CompilationUnit> lf_zebBZoiF = lf_3wGtLMZa.getResult();
            CompilationUnit lf_6nQOtMNJ = lf_zebBZoiF.get();
            PackageDeclaration lf_sTNnTiU4 = lf_6nQOtMNJ.getPackageDeclaration().get();
            String lf_ei7ePDJp = lf_sTNnTiU4.getNameAsString();
            NodeList<ImportDeclaration> lf_ZRIONNYF = lf_6nQOtMNJ.getImports();
            List<String> lf_iElO7KyO = lf_ZRIONNYF.stream().map(lambda_lf_NfORUnsI -> lambda_lf_NfORUnsI.getNameAsString()).collect(Collectors.toList());
            lf_ZMAGmm4o.append(lf_sTNnTiU4.toString());
            lf_ZRIONNYF.stream().forEach(lambda_lf_TBOWXYaS -> {
                lf_ZMAGmm4o.append(lambda_lf_TBOWXYaS.toString());
            });
            NodeList<TypeDeclaration<?>> lf_Pg3eFOcg = lf_6nQOtMNJ.getTypes();
            lf_Pg3eFOcg.stream().forEach(lambda_lf_FH9fsUNl -> {
                String lf_T6XHyQGt = lambda_lf_FH9fsUNl.getNameAsString();
                String lf_13nfvcZ8 = lf_ei7ePDJp + "." + lf_T6XHyQGt;
                List<FieldDeclaration> lf_TRMEaUL2 = lambda_lf_FH9fsUNl.getFields();
                Map<String, String> lf_G0NXMxRA = new HashMap<>();
                for (FieldDeclaration lf_ApbIWbvl : lf_TRMEaUL2) {
                    NodeList<VariableDeclarator> lf_7QdWIbgg = lf_ApbIWbvl.getVariables();
                    for (VariableDeclarator lf_5sMUOsQK : lf_7QdWIbgg) {
                        String lf_0D3gAupf = lf_5sMUOsQK.getTypeAsString();
                        String lf_9be4NeKj = lf_5sMUOsQK.getNameAsString();
                        Optional<String> lf_YgzHiPbe = lf_iElO7KyO.stream().filter(lambda_lf_sVDS1hoA -> lambda_lf_sVDS1hoA.substring(lambda_lf_sVDS1hoA.lastIndexOf(".") + 1).equals(lf_0D3gAupf)).findFirst();
                        if (lf_YgzHiPbe.isPresent()) {
                            String lf_QY71A5ng = lf_YgzHiPbe.get();
                            lf_G0NXMxRA.put(lf_9be4NeKj, lf_QY71A5ng);
                        } else {
                            lf_G0NXMxRA.put(lf_9be4NeKj, null);
                        }
                    }
                }
                List<Node> lf_X733w03K = lambda_lf_FH9fsUNl.getChildNodes();
                m_9F4MwKht(lf_X733w03K, lf_G0NXMxRA, lf_13nfvcZ8, lf_iElO7KyO);
                // 
                for (MethodDeclaration lf_IJ1MO4aA : lambda_lf_FH9fsUNl.getMethods()) {
                    Optional<BlockStmt> lf_PyWdfI7S = lf_IJ1MO4aA.getBody();
                    if (lf_PyWdfI7S.isPresent()) {
                        Map<String, String> lf_1sCZQeRk = new HashMap<String, String>();
                        m_TUhdutJW(lf_PyWdfI7S.get().getChildNodes(), lf_1sCZQeRk, lf_13nfvcZ8, lf_iElO7KyO);
                    }
                }
                String lf_V5ASaHJW = lf_ei7ePDJp + "." + lf_T6XHyQGt;
                if (gf_jT8KgeZq.containsKey(lf_V5ASaHJW)) {
                    Map<String, String> lf_WCvDsfzA = gf_jT8KgeZq.get(lf_V5ASaHJW);
                    List<MethodDeclaration> lf_RIOvDaLd = lambda_lf_FH9fsUNl.getMethods();
                    lf_RIOvDaLd.stream().forEach(lambda_lf_9fDe6DJK -> {
                        if (lf_WCvDsfzA.containsKey(lambda_lf_9fDe6DJK.getNameAsString())) {
                            lambda_lf_9fDe6DJK.setName(lf_WCvDsfzA.get(lambda_lf_9fDe6DJK.getNameAsString()));
                        }
                    });
                }
                lf_ZMAGmm4o.append(lambda_lf_FH9fsUNl.toString());
            });
            return lf_ZMAGmm4o.toString();
            // 
            // 
            // 
        } else {
            throw new RuntimeException("parse failed");
        }
    }

    public static void m_TUhdutJW(List<Node> p_I7DVW65o, Map<String, String> p_WHRAerAA, String p_2GERLVMz, List<String> p_Yc7Cf3ca) {
        for (Node lf_lY6V3yV8 : p_I7DVW65o) {
            if (lf_lY6V3yV8 instanceof VariableDeclarator) {
                VariableDeclarator lf_plEhfxQE = (VariableDeclarator) lf_lY6V3yV8;
                String lf_Jbtv0aFC = lf_plEhfxQE.getTypeAsString();
                String lf_CZzhNJm2 = lf_plEhfxQE.getNameAsString();
                Optional<String> lf_R1ASv7ek = p_Yc7Cf3ca.stream().filter(lambda_lf_K9nFASXE -> lambda_lf_K9nFASXE.substring(lambda_lf_K9nFASXE.lastIndexOf(".") + 1).equals(lf_Jbtv0aFC)).findFirst();
                if (lf_R1ASv7ek.isPresent()) {
                    String lf_EDNrzDeW = lf_R1ASv7ek.get();
                    if (gf_jT8KgeZq.containsKey(lf_EDNrzDeW)) {
                        p_WHRAerAA.put(lf_CZzhNJm2, lf_EDNrzDeW);
                    }
                } else {
                    String lf_GaLDsshd = p_2GERLVMz.substring(0, p_2GERLVMz.lastIndexOf("."));
                    String lf_zZlAM1X5 = lf_GaLDsshd + "." + lf_Jbtv0aFC;
                    if (gf_jT8KgeZq.containsKey(lf_zZlAM1X5)) {
                        p_WHRAerAA.put(lf_CZzhNJm2, lf_zZlAM1X5);
                    }
                }
            }
            if (lf_lY6V3yV8 instanceof MethodCallExpr) {
                MethodCallExpr lf_d32OHRsI = (MethodCallExpr) lf_lY6V3yV8;
                List<Node> lf_L7gWVMkr = lf_d32OHRsI.getChildNodes();
                if (lf_L7gWVMkr.size() >= 2) {
                    if (lf_L7gWVMkr.get(0) instanceof NameExpr && lf_L7gWVMkr.get(1) instanceof SimpleName) {
                        String lf_EQThIXNP = ((NameExpr) lf_L7gWVMkr.get(0)).getNameAsString();
                        String lf_d3gkWPuJ = lf_d32OHRsI.getNameAsString();
                        if (p_WHRAerAA.containsKey(lf_EQThIXNP)) {
                            String lf_c6zPTp24 = p_WHRAerAA.get(lf_EQThIXNP);
                            if (lf_c6zPTp24 != null) {
                                if (gf_jT8KgeZq.containsKey(lf_c6zPTp24)) {
                                    Map<String, String> lf_LBWUn9mu = gf_jT8KgeZq.get(lf_c6zPTp24);
                                    if (lf_LBWUn9mu.containsKey(lf_d3gkWPuJ)) {
                                        String lf_F5DGrCV4 = lf_LBWUn9mu.get(lf_d3gkWPuJ);
                                        lf_d32OHRsI.setName(lf_F5DGrCV4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            List<Node> lf_wvrygrs3 = lf_lY6V3yV8.getChildNodes();
            if (lf_wvrygrs3.size() > 0) {
                m_TUhdutJW(lf_wvrygrs3, p_WHRAerAA, p_2GERLVMz, p_Yc7Cf3ca);
            }
        }
    }

    public static void m_9F4MwKht(List<Node> p_ChB6Sc5u, Map<String, String> p_L65Kfi8l, String p_YnAyETR6, List<String> p_CKYPe5xr) {
        for (Node lf_0EktZ8wL : p_ChB6Sc5u) {
            if (lf_0EktZ8wL instanceof MethodCallExpr) {
                MethodCallExpr lf_CGwLYzJ8 = (MethodCallExpr) lf_0EktZ8wL;
                List<Node> lf_HYY5ksqU = lf_CGwLYzJ8.getChildNodes();
                if (lf_HYY5ksqU.get(0) instanceof NameExpr) {
                    if (lf_HYY5ksqU.get(0) instanceof NameExpr && lf_HYY5ksqU.get(1) instanceof SimpleName) {
                        String lf_8Zbpls80 = ((NameExpr) lf_HYY5ksqU.get(0)).getNameAsString();
                        String lf_4gbIlTsu = lf_CGwLYzJ8.getNameAsString();
                        if (p_L65Kfi8l.containsKey(lf_8Zbpls80)) {
                            String lf_gq6EVFHU = p_L65Kfi8l.get(lf_8Zbpls80);
                            if (lf_gq6EVFHU != null) {
                                if (gf_jT8KgeZq.containsKey(lf_gq6EVFHU)) {
                                    Map<String, String> lf_WwG4kDhX = gf_jT8KgeZq.get(lf_gq6EVFHU);
                                    if (lf_WwG4kDhX.containsKey(lf_4gbIlTsu)) {
                                        String lf_x9BnQM7C = lf_WwG4kDhX.get(lf_4gbIlTsu);
                                        lf_CGwLYzJ8.setName(lf_x9BnQM7C);
                                    }
                                }
                            }
                        } else {
                            String lf_W4PHesgJ = lf_8Zbpls80;
                            Optional<String> lf_x0Oon2Vg = p_CKYPe5xr.stream().filter(lambda_lf_dPIDHefs -> lambda_lf_dPIDHefs.substring(lambda_lf_dPIDHefs.lastIndexOf(".") + 1).equals(lf_W4PHesgJ)).findFirst();
                            if (lf_x0Oon2Vg.isPresent()) {
                                String lf_RQSlzrM7 = lf_x0Oon2Vg.get();
                                if (gf_jT8KgeZq.containsKey(lf_RQSlzrM7)) {
                                    Map<String, String> lf_BfSAwG4g = gf_jT8KgeZq.get(lf_RQSlzrM7);
                                    if (lf_BfSAwG4g.containsKey(lf_4gbIlTsu)) {
                                        String lf_ZwgA0FOe = lf_BfSAwG4g.get(lf_4gbIlTsu);
                                        lf_CGwLYzJ8.setName(lf_ZwgA0FOe);
                                    }
                                }
                            } else {
                                String lf_T9f3YClq = p_YnAyETR6.substring(0, p_YnAyETR6.lastIndexOf("."));
                                String lf_oJ0hkNH5 = lf_T9f3YClq + "." + lf_W4PHesgJ;
                                if (gf_jT8KgeZq.containsKey(lf_oJ0hkNH5)) {
                                    Map<String, String> lf_iR8pvvcm = gf_jT8KgeZq.get(lf_oJ0hkNH5);
                                    if (lf_iR8pvvcm.containsKey(lf_4gbIlTsu)) {
                                        String lf_02QQqL3Z = lf_iR8pvvcm.get(lf_4gbIlTsu);
                                        lf_CGwLYzJ8.setName(lf_02QQqL3Z);
                                    }
                                }
                            }
                        }
                    }
                } else if (lf_HYY5ksqU.get(0) instanceof SimpleName) {
                    String lf_hfIZwb2d = lf_CGwLYzJ8.getNameAsString();
                    if (gf_jT8KgeZq.containsKey(p_YnAyETR6)) {
                        Map<String, String> lf_QRh8kV4p = gf_jT8KgeZq.get(p_YnAyETR6);
                        if (lf_QRh8kV4p.containsKey(lf_hfIZwb2d)) {
                            String lf_hTGCMpMA = lf_QRh8kV4p.get(lf_hfIZwb2d);
                            lf_CGwLYzJ8.setName(lf_hTGCMpMA);
                        }
                    }
                } else if (lf_HYY5ksqU.get(0) instanceof ThisExpr) {
                }
            }
            List<Node> lf_ByJD7CNS = lf_0EktZ8wL.getChildNodes();
            if (lf_ByJD7CNS.size() > 0) {
                m_9F4MwKht(lf_ByJD7CNS, p_L65Kfi8l, p_YnAyETR6, p_CKYPe5xr);
            }
        }
    }

    private static void m_DLqej7Li(File p_PqtGH31d) throws IOException {
        JavaParser lf_0dVoBhnJ = new JavaParser();
        ParseResult<CompilationUnit> lf_yWXhslIy = lf_0dVoBhnJ.parse(p_PqtGH31d);
        if (lf_yWXhslIy.isSuccessful()) {
            Optional<CompilationUnit> lf_8iBnQFKo = lf_yWXhslIy.getResult();
            CompilationUnit lf_EzEyic4J = lf_8iBnQFKo.get();
            String lf_Snn3mhPt = lf_EzEyic4J.getPackageDeclaration().get().getNameAsString();
            NodeList<TypeDeclaration<?>> lf_l9BGPBda = lf_EzEyic4J.getTypes();
            lf_l9BGPBda.stream().forEach(lambda_lf_5Lr6QGrv -> {
                String lf_59O7t8Vs = lambda_lf_5Lr6QGrv.getNameAsString();
                if (!C_0wyqfnek.m_xS95ysIl(lf_Snn3mhPt, lf_Snn3mhPt + "." + lf_59O7t8Vs)) {
                    List<MethodDeclaration> lf_j6hWEGoV = lambda_lf_5Lr6QGrv.getMethods();
                    Map<String, String> lf_Rc7QI6Hc = new HashMap<>();
                    Set<String> lf_2HQG3YOU = lf_j6hWEGoV.stream().filter(lambda_lf_4h6zY30T -> {
                        List<String> lf_61GCbA0j = lambda_lf_4h6zY30T.getAnnotations().stream().map(lambda_lf_Nhr6Y3TJ -> lambda_lf_Nhr6Y3TJ.getNameAsString()).collect(Collectors.toList());
                        return !C_0wyqfnek.m_TJR8hsZv(lf_61GCbA0j);
                    }).map(lambda_lf_ho2eFYUf -> {
                        String lf_u59uct3W = lambda_lf_ho2eFYUf.getNameAsString();
                        return lf_u59uct3W;
                    }).collect(Collectors.toSet());
                    lf_2HQG3YOU.remove("main");
                    if (lf_2HQG3YOU.size() > 0) {
                        lf_2HQG3YOU.stream().forEach(lambda_lf_oYeHKxaZ -> {
                            lf_Rc7QI6Hc.put(lambda_lf_oYeHKxaZ, "m_" + RandomStringUtils.random(8, true, true));
                        });
                        gf_jT8KgeZq.put(lf_Snn3mhPt + "." + lf_59O7t8Vs, lf_Rc7QI6Hc);
                    }
                }
            });
        }
    }

    public static void main(String[] p_XhJlfy5l) throws IOException {
        m_BtSU26Ro();
        // 
        // 
    }
}
