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
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class C_tlGFzJIA {

    private static final Logger gf_9NUzInOA = LoggerFactory.getLogger(C_tlGFzJIA.class);

    private static final String gf_wuB0tUpW = C_0wyqfnek.gf_K8wuLk24 + "step2" + File.separator;

    private static final String gf_PXOBbJd1 = C_0wyqfnek.gf_K8wuLk24 + "step3" + File.separator;

    static Map<String, String> gf_lCUXiBd0 = new HashMap<>();

    private static boolean m_RN1AFnxu(String p_6zaNadB8) {
        for (String lf_A35JQosp : C_0wyqfnek.gf_b7ItIRzD) {
            String lf_g31F1mtX = gf_wuB0tUpW + lf_A35JQosp;
            if (p_6zaNadB8.startsWith(lf_g31F1mtX)) {
                return true;
            }
        }
        return false;
    }

    public static void m_smHmx8Ia() throws IOException {
        Collection<File> lf_WuB0NzWt = FileUtils.listFiles(new File(gf_wuB0tUpW), null, true);
        FileUtils.deleteDirectory(new File(gf_PXOBbJd1));
        FileUtils.forceMkdir(new File(gf_PXOBbJd1));
        lf_WuB0NzWt.stream().filter(lambda_lf_I4aOUIdi -> !m_RN1AFnxu(lambda_lf_I4aOUIdi.getPath()) && lambda_lf_I4aOUIdi.isFile()).forEach(lambda_lf_JR8h8FES -> {
            String lf_BdjZsLCC = lambda_lf_JR8h8FES.getPath();
            String lf_WNqUP5zy = lf_BdjZsLCC.substring(gf_wuB0tUpW.length());
            String lf_cA11I4s6 = gf_PXOBbJd1 + lf_WNqUP5zy;
            JavaParser lf_t7u4mV9H = new JavaParser();
            List<String> lf_XLBG0HqX = new ArrayList<>();
            File lf_2uPfo6mg = new File(lf_cA11I4s6);
            gf_9NUzInOA.info(lf_cA11I4s6);
            try {
                FileUtils.forceMkdirParent(lf_2uPfo6mg);
                if (lambda_lf_JR8h8FES.getName().endsWith(".java")) {
                    ParseResult<CompilationUnit> lf_Hes75myU = lf_t7u4mV9H.parse(lambda_lf_JR8h8FES);
                    if (lf_Hes75myU.isSuccessful()) {
                        Optional<CompilationUnit> lf_M3P0JDjY = lf_Hes75myU.getResult();
                        CompilationUnit lf_Z1ndxVeP = lf_M3P0JDjY.get();
                        NodeList<TypeDeclaration<?>> lf_xcXLZXUQ = lf_Z1ndxVeP.getTypes();
                        TypeDeclaration<?> lf_Hl46TrCf = lf_xcXLZXUQ.getFirst().get();
                        NodeList<AnnotationExpr> lf_jFUhp2cU = lf_Hl46TrCf.getAnnotations();
                        lf_XLBG0HqX = lf_jFUhp2cU.stream().map(lambda_lf_gVqdX8Pt -> lambda_lf_gVqdX8Pt.getNameAsString()).collect(Collectors.toList());
                    }
                    Map<String, String> lf_wNGegte7 = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_JR8h8FES);
                    // 
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_wNGegte7.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_wNGegte7.get("className"))) && (!C_0wyqfnek.m_6gZPmnqh(lf_XLBG0HqX))) {
                        String lf_MlTmBHo9 = lf_wNGegte7.get("className");
                        String lf_x5pTTW2k = lf_wNGegte7.get("packageName");
                        gf_lCUXiBd0.put(lf_MlTmBHo9, lf_x5pTTW2k + ".C_" + RandomStringUtils.random(8, true, true));
                    } else {
                        gf_9NUzInOA.info("excluded: " + lf_cA11I4s6);
                        IOUtils.copy(new FileInputStream(lambda_lf_JR8h8FES), new FileOutputStream(lf_2uPfo6mg));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        lf_WuB0NzWt.stream().filter(lambda_lf_uym7OCIf -> !m_RN1AFnxu(lambda_lf_uym7OCIf.getPath()) && lambda_lf_uym7OCIf.isFile()).forEach(lambda_lf_Hfa6NsqA -> {
            String lf_2JxtZKtc = lambda_lf_Hfa6NsqA.getPath();
            String lf_faDDVLL4 = lf_2JxtZKtc.substring(gf_wuB0tUpW.length());
            String lf_eNYmHPH6 = lf_faDDVLL4.substring(lf_faDDVLL4.lastIndexOf('.') + 1);
            String lf_eTaLrz0e = gf_PXOBbJd1 + lf_faDDVLL4;
            File lf_hMW7iGcr = new File(lf_eTaLrz0e);
            try {
                FileUtils.forceMkdirParent(lf_hMW7iGcr);
                if (lambda_lf_Hfa6NsqA.getName().endsWith(".java")) {
                    Map<String, String> lf_VSOEm5oY = C_nZ4HWO7V.m_ABgEbiUl(lambda_lf_Hfa6NsqA);
                    System.out.println(lf_VSOEm5oY.get("packageName") + ":" + lf_VSOEm5oY.get("className"));
                    if ((!C_0wyqfnek.m_hYlsFdBY(lf_VSOEm5oY.get("packageName"))) && (!C_0wyqfnek.m_IB5tx6Zk(lf_VSOEm5oY.get("className")))) {
                        String lf_JENlRUGG = m_vjJRa2Hv(lambda_lf_Hfa6NsqA);
                        if (gf_lCUXiBd0.containsKey(lf_VSOEm5oY.get("className"))) {
                            String lf_L24J4fWI = gf_lCUXiBd0.get(lf_VSOEm5oY.get("className"));
                            String lf_wxaCxl1X = lf_L24J4fWI.substring(lf_L24J4fWI.lastIndexOf(".") + 1);
                            String lf_gzCqlxWS = lf_eTaLrz0e.substring(0, lf_eTaLrz0e.lastIndexOf("\\") + 1) + lf_wxaCxl1X + ".java";
                            IOUtils.write(lf_JENlRUGG, new FileOutputStream(new File(lf_gzCqlxWS)), Charsets.UTF_8);
                        } else
                            IOUtils.write(lf_JENlRUGG, new FileOutputStream(lf_hMW7iGcr), Charsets.UTF_8);
                    } else {
                        gf_9NUzInOA.info("excluded: " + lf_eTaLrz0e);
                    }
                } else {
                    if (C_0wyqfnek.gf_9eMrBoFf.contains(lf_eNYmHPH6)) {
                        String lf_yvnOb0Jf = IOUtils.toString(new FileInputStream(lambda_lf_Hfa6NsqA), Charsets.UTF_8);
                        for (String lf_CXfVsuj7 : gf_lCUXiBd0.keySet()) {
                            String lf_xpRcLare = gf_lCUXiBd0.get(lf_CXfVsuj7);
                            lf_yvnOb0Jf = lf_yvnOb0Jf.replace(lf_CXfVsuj7, lf_xpRcLare);
                        }
                        IOUtils.write(lf_yvnOb0Jf, new FileOutputStream(lf_hMW7iGcr), Charsets.UTF_8);
                    } else {
                        IOUtils.copy(new FileInputStream(lambda_lf_Hfa6NsqA), new FileOutputStream(lf_hMW7iGcr));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gf_9NUzInOA.info("类名混淆成功");
    }

    private static String m_vjJRa2Hv(File p_gXuil6je) throws IOException {
        JavaParser lf_LpSQ5KUl = new JavaParser();
        ParseResult<CompilationUnit> lf_XnJfmmBL = lf_LpSQ5KUl.parse(p_gXuil6je);
        if (lf_XnJfmmBL.isSuccessful()) {
            Optional<CompilationUnit> lf_Bhi0rb1K = lf_XnJfmmBL.getResult();
            CompilationUnit lf_QBbP2D28 = lf_Bhi0rb1K.get();
            PackageDeclaration lf_KnqKdkVt = lf_QBbP2D28.getPackageDeclaration().get();
            String lf_vsTi3ncj = lf_KnqKdkVt.getNameAsString();
            NodeList<ImportDeclaration> lf_QQHyIhsE = lf_QBbP2D28.getImports();
            List<String> lf_1kU0L7zb = lf_QQHyIhsE.stream().map(lambda_lf_1ZnpdfZy -> lambda_lf_1ZnpdfZy.getNameAsString()).collect(Collectors.toList());
            List<Node> lf_tt3GHNYw = lf_QBbP2D28.getChildNodes();
            lf_QBbP2D28.getTypes().stream().forEach(lambda_lf_2FHB8nnT -> {
                List<ConstructorDeclaration> lf_l60ky6rR = lambda_lf_2FHB8nnT.getConstructors();
                if (lf_l60ky6rR.size() > 0) {
                    String lf_VP5oplZW = lambda_lf_2FHB8nnT.getNameAsString();
                    if (gf_lCUXiBd0.containsKey(lf_vsTi3ncj + "." + lf_VP5oplZW)) {
                        String lf_2QVtVNc0 = gf_lCUXiBd0.get(lf_vsTi3ncj + "." + lf_VP5oplZW);
                        String lf_Ms518aT9 = lf_2QVtVNc0.substring(lf_2QVtVNc0.lastIndexOf(".") + 1);
                        lf_l60ky6rR.stream().forEach(lambda_lf_vSk7k2ar -> {
                            lambda_lf_vSk7k2ar.setName(lf_Ms518aT9);
                        });
                    }
                }
            });
            lf_QBbP2D28.getTypes().stream().forEach(lambda_lf_Lzb772Rx -> {
                String lf_hHYQCiNT = lambda_lf_Lzb772Rx.getNameAsString();
                if (gf_lCUXiBd0.containsKey(lf_vsTi3ncj + "." + lf_hHYQCiNT)) {
                    String lf_dqz0Uvee = gf_lCUXiBd0.get(lf_vsTi3ncj + "." + lf_hHYQCiNT);
                    String lf_lqwHTDaq = lf_dqz0Uvee.substring(lf_dqz0Uvee.lastIndexOf(".") + 1);
                    lambda_lf_Lzb772Rx.setName(lf_lqwHTDaq);
                }
            });
            m_JuPBwGxX(lf_tt3GHNYw, lf_1kU0L7zb, lf_vsTi3ncj);
            lf_QQHyIhsE.stream().forEach(lambda_lf_Fn4OHnwt -> {
                String lf_8BL3s6q0 = lambda_lf_Fn4OHnwt.getNameAsString();
                if (gf_lCUXiBd0.containsKey(lf_8BL3s6q0)) {
                    lambda_lf_Fn4OHnwt.setName(gf_lCUXiBd0.get(lf_8BL3s6q0));
                }
            });
            return lf_QBbP2D28.toString();
        }
        return null;
    }

    private static void m_JuPBwGxX(List<Node> p_FmrUx6Pf, List<String> p_XqyGbIHc, String p_INquBnQY) {
        for (Node lf_av3cdNrN : p_FmrUx6Pf) {
            if (lf_av3cdNrN instanceof ClassOrInterfaceType) {
                ClassOrInterfaceType lf_nmHd2nMS = (ClassOrInterfaceType) lf_av3cdNrN;
                String lf_ZD7tEmu4 = lf_nmHd2nMS.getNameAsString();
                Optional<String> lf_OtcHv2Es = p_XqyGbIHc.stream().filter(lambda_lf_jsWczslK -> lambda_lf_jsWczslK.substring(lambda_lf_jsWczslK.lastIndexOf(".") + 1).equals(lf_ZD7tEmu4)).findFirst();
                if (lf_OtcHv2Es.isPresent()) {
                    String lf_zUDHGjfW = lf_OtcHv2Es.get();
                    if (gf_lCUXiBd0.containsKey(lf_zUDHGjfW)) {
                        String lf_wcMLNpH2 = gf_lCUXiBd0.get(lf_zUDHGjfW);
                        String lf_FVUPfEtc = lf_wcMLNpH2.substring(lf_wcMLNpH2.lastIndexOf(".") + 1);
                        lf_nmHd2nMS.setName(lf_FVUPfEtc);
                    }
                } else {
                    String lf_Aq95xHTa = p_INquBnQY + "." + lf_ZD7tEmu4;
                    if (gf_lCUXiBd0.containsKey(lf_Aq95xHTa)) {
                        String lf_tCbSltRR = gf_lCUXiBd0.get(lf_Aq95xHTa);
                        String lf_3xFm71Zl = lf_tCbSltRR.substring(lf_tCbSltRR.lastIndexOf(".") + 1);
                        lf_nmHd2nMS.setName(lf_3xFm71Zl);
                    }
                }
            } else if (lf_av3cdNrN instanceof NameExpr) {
                Optional<Node> lf_CAq7Uqpe = lf_av3cdNrN.getParentNode();
                if (lf_CAq7Uqpe.isPresent()) {
                    Node lf_o32FwycK = lf_CAq7Uqpe.get();
                    if (lf_o32FwycK instanceof MethodCallExpr) {
                        NameExpr lf_ZtPSHSju = (NameExpr) lf_av3cdNrN;
                        String lf_G9ysjPMG = lf_ZtPSHSju.getNameAsString();
                        Optional<String> lf_K7zXWHVy = p_XqyGbIHc.stream().filter(lambda_lf_RN6H9vRA -> lambda_lf_RN6H9vRA.substring(lambda_lf_RN6H9vRA.lastIndexOf(".") + 1).equals(lf_G9ysjPMG)).findFirst();
                        if (lf_K7zXWHVy.isPresent()) {
                            String lf_FxNEKthP = lf_K7zXWHVy.get();
                            if (gf_lCUXiBd0.containsKey(lf_FxNEKthP)) {
                                String lf_A3HsnpAB = gf_lCUXiBd0.get(lf_FxNEKthP);
                                String lf_2LLIUerS = lf_A3HsnpAB.substring(lf_A3HsnpAB.lastIndexOf(".") + 1);
                                lf_ZtPSHSju.setName(lf_2LLIUerS);
                            }
                        } else {
                            String lf_Emg3Qt7B = p_INquBnQY + "." + lf_G9ysjPMG;
                            if (gf_lCUXiBd0.containsKey(lf_Emg3Qt7B)) {
                                String lf_AMKFhWRW = gf_lCUXiBd0.get(lf_Emg3Qt7B);
                                String lf_LLQubMLj = lf_AMKFhWRW.substring(lf_AMKFhWRW.lastIndexOf(".") + 1);
                                lf_ZtPSHSju.setName(lf_LLQubMLj);
                            }
                        }
                    } else if (lf_o32FwycK instanceof FieldAccessExpr) {
                        NameExpr lf_c9Li45Vg = (NameExpr) lf_av3cdNrN;
                        String lf_tLhp5Wpg = lf_c9Li45Vg.getNameAsString();
                        Optional<String> lf_gH7mbmwE = p_XqyGbIHc.stream().filter(lambda_lf_P05ADKeq -> lambda_lf_P05ADKeq.substring(lambda_lf_P05ADKeq.lastIndexOf(".") + 1).equals(lf_tLhp5Wpg)).findFirst();
                        if (lf_gH7mbmwE.isPresent()) {
                            String lf_aWd1IAyy = lf_gH7mbmwE.get();
                            if (gf_lCUXiBd0.containsKey(lf_aWd1IAyy)) {
                                String lf_X9GB1kBi = gf_lCUXiBd0.get(lf_aWd1IAyy);
                                String lf_KDTZePPh = lf_X9GB1kBi.substring(lf_X9GB1kBi.lastIndexOf(".") + 1);
                                lf_c9Li45Vg.setName(lf_KDTZePPh);
                            }
                        } else {
                            String lf_FqW74ude = p_INquBnQY + "." + lf_tLhp5Wpg;
                            if (gf_lCUXiBd0.containsKey(lf_FqW74ude)) {
                                String lf_hxzeoCdb = gf_lCUXiBd0.get(lf_FqW74ude);
                                String lf_0yXH3wa7 = lf_hxzeoCdb.substring(lf_hxzeoCdb.lastIndexOf(".") + 1);
                                lf_c9Li45Vg.setName(lf_0yXH3wa7);
                            }
                        }
                    }
                }
            }
            if (lf_av3cdNrN.getChildNodes().size() > 0) {
                m_JuPBwGxX(lf_av3cdNrN.getChildNodes(), p_XqyGbIHc, p_INquBnQY);
            }
        }
    }

    public static void main(String[] p_zUAwpxFK) throws IOException {
        m_smHmx8Ia();
    }
}
