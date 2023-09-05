package com.gitee.freakchicken.blindjava.util;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class C_0wyqfnek {

    public static String gf_vmUSIpx3;

    public static String gf_K8wuLk24;

    public static List<String> gf_b7ItIRzD;

    public static List<String> gf_M9jypOfZ;

    public static List<String> gf_bbrV2eu3;

    public static List<String> gf_kvtnux8r;

    public static List<String> gf_dMY6SVjn;

    public static List<String> gf_n9DyaHEG;

    public static List<String> gf_Pzk1LFlE;

    public static List<String> gf_K6Jl8CAh;

    public static List<String> gf_QWhVg1tQ;

    public static List<String> gf_ruV7lkqE;

    public static List<String> gf_tFLsb3Rc;

    public static List<String> gf_gRoCZc0I;

    public static List<String> gf_9eMrBoFf;

    static {
        InputStream lf_CHCwP5aT = C_0wyqfnek.class.getClassLoader().getResourceAsStream("config.xml");
        try {
            m_BXASsx5C(lf_CHCwP5aT);
            File lf_j8xsFWlN = new File(gf_K8wuLk24);
            if (lf_j8xsFWlN.exists()) {
                // 
            }
            FileUtils.forceMkdir(lf_j8xsFWlN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void m_BXASsx5C(InputStream p_afy6iXnz) throws Exception {
        DocumentBuilderFactory lf_DXk9uLIw = DocumentBuilderFactory.newInstance();
        Document lf_qiwovjka = lf_DXk9uLIw.newDocumentBuilder().parse(p_afy6iXnz);
        Element lf_AbQBcKrJ = lf_qiwovjka.getDocumentElement();
        NodeList lf_3EKTHTo9 = lf_AbQBcKrJ.getChildNodes();
        for (int lf_4TdoB4W0 = 0; lf_4TdoB4W0 < lf_3EKTHTo9.getLength(); lf_4TdoB4W0++) {
            Node lf_e0ipXv36 = lf_3EKTHTo9.item(lf_4TdoB4W0);
            if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                String lf_unFGDZVf = lf_e0ipXv36.getNodeName();
                if (lf_unFGDZVf.equals("excludeJavaFile")) {
                    NodeList lf_6vtILaVP = lf_e0ipXv36.getChildNodes();
                    List<String> lf_KKMlGqNa = new ArrayList<>();
                    List<String> lf_DJxKHWa5 = new ArrayList<>();
                    for (int lf_wYsmqbsr = 0; lf_wYsmqbsr < lf_6vtILaVP.getLength(); lf_wYsmqbsr++) {
                        Node lf_aKuy7SQj = lf_6vtILaVP.item(lf_wYsmqbsr);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_IZsGXOli = lf_aKuy7SQj.getNodeName();
                            if ("class".equals(lf_IZsGXOli)) {
                                lf_KKMlGqNa.add(lf_aKuy7SQj.getTextContent());
                            } else if ("package".equals(lf_IZsGXOli)) {
                                lf_DJxKHWa5.add(lf_aKuy7SQj.getTextContent());
                            }
                        }
                    }
                    gf_M9jypOfZ = lf_KKMlGqNa;
                    gf_bbrV2eu3 = lf_DJxKHWa5;
                } else if (lf_unFGDZVf.equals("sourceDir")) {
                    gf_vmUSIpx3 = (lf_e0ipXv36.getTextContent());
                } else if (lf_unFGDZVf.equals("targetDir")) {
                    gf_K8wuLk24 = (lf_e0ipXv36.getTextContent());
                } else if (lf_unFGDZVf.equals("excludeDir")) {
                    List<String> lf_tTOgessn = new ArrayList<>();
                    NodeList lf_eNH7adIO = lf_e0ipXv36.getChildNodes();
                    for (int lf_yRTTiKUx = 0; lf_yRTTiKUx < lf_eNH7adIO.getLength(); lf_yRTTiKUx++) {
                        Node lf_GRZHv2Zv = lf_eNH7adIO.item(lf_yRTTiKUx);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_QdKZ2HMH = lf_GRZHv2Zv.getNodeName();
                            if ("directory".equals(lf_QdKZ2HMH)) {
                                lf_tTOgessn.add(lf_GRZHv2Zv.getTextContent());
                            }
                        }
                    }
                    gf_b7ItIRzD = lf_tTOgessn;
                } else if (lf_unFGDZVf.equals("keepMethodParameter")) {
                    NodeList lf_StqxVuHN = lf_e0ipXv36.getChildNodes();
                    List<String> lf_ccr0o5bT = new ArrayList<>();
                    List<String> lf_XAfF60eE = new ArrayList<>();
                    List<String> lf_dUtOlLOJ = new ArrayList<>();
                    for (int lf_MepMesNj = 0; lf_MepMesNj < lf_StqxVuHN.getLength(); lf_MepMesNj++) {
                        Node lf_u6KIHJi8 = lf_StqxVuHN.item(lf_MepMesNj);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_juRvC6Q5 = lf_u6KIHJi8.getNodeName();
                            if ("class".equals(lf_juRvC6Q5)) {
                                lf_ccr0o5bT.add(lf_u6KIHJi8.getTextContent());
                            } else if ("package".equals(lf_juRvC6Q5)) {
                                lf_XAfF60eE.add(lf_u6KIHJi8.getTextContent());
                            } else if ("methodHasAnnotation".equals(lf_juRvC6Q5)) {
                                lf_dUtOlLOJ.add(lf_u6KIHJi8.getTextContent());
                            }
                        }
                    }
                    gf_kvtnux8r = lf_ccr0o5bT;
                    gf_dMY6SVjn = lf_XAfF60eE;
                    gf_n9DyaHEG = lf_dUtOlLOJ;
                } else if (lf_unFGDZVf.equals("keepMethodName")) {
                    NodeList lf_gwueTDSr = lf_e0ipXv36.getChildNodes();
                    List<String> lf_VGzJWUNh = new ArrayList<>();
                    List<String> lf_VV9noeGH = new ArrayList<>();
                    List<String> lf_0TsijEL7 = new ArrayList<>();
                    for (int lf_EYfVxIqT = 0; lf_EYfVxIqT < lf_gwueTDSr.getLength(); lf_EYfVxIqT++) {
                        Node lf_3A7reI1H = lf_gwueTDSr.item(lf_EYfVxIqT);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_9AByDv4X = lf_3A7reI1H.getNodeName();
                            if ("class".equals(lf_9AByDv4X)) {
                                lf_VGzJWUNh.add(lf_3A7reI1H.getTextContent());
                            } else if ("package".equals(lf_9AByDv4X)) {
                                lf_VV9noeGH.add(lf_3A7reI1H.getTextContent());
                            } else if ("methodHasAnnotation".equals(lf_9AByDv4X)) {
                                lf_0TsijEL7.add(lf_3A7reI1H.getTextContent());
                            }
                        }
                    }
                    gf_Pzk1LFlE = lf_VGzJWUNh;
                    gf_K6Jl8CAh = lf_VV9noeGH;
                    gf_QWhVg1tQ = lf_0TsijEL7;
                } else if (lf_unFGDZVf.equals("keepClassName")) {
                    NodeList lf_MKtv7SgG = lf_e0ipXv36.getChildNodes();
                    List<String> lf_4rkwhTHU = new ArrayList<>();
                    List<String> lf_XFTH4cdB = new ArrayList<>();
                    List<String> lf_HdEchRjx = new ArrayList<>();
                    for (int lf_qyrZ3f6x = 0; lf_qyrZ3f6x < lf_MKtv7SgG.getLength(); lf_qyrZ3f6x++) {
                        Node lf_uDqZOOVR = lf_MKtv7SgG.item(lf_qyrZ3f6x);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_8SoVrm9g = lf_uDqZOOVR.getNodeName();
                            if ("class".equals(lf_8SoVrm9g)) {
                                lf_4rkwhTHU.add(lf_uDqZOOVR.getTextContent());
                            } else if ("package".equals(lf_8SoVrm9g)) {
                                lf_XFTH4cdB.add(lf_uDqZOOVR.getTextContent());
                            } else if ("classHasAnnotation".equals(lf_8SoVrm9g)) {
                                lf_HdEchRjx.add(lf_uDqZOOVR.getTextContent());
                            }
                        }
                    }
                    gf_ruV7lkqE = lf_4rkwhTHU;
                    gf_tFLsb3Rc = lf_XFTH4cdB;
                    gf_gRoCZc0I = lf_HdEchRjx;
                } else if (lf_unFGDZVf.equals("textFile")) {
                    NodeList lf_GPQZyELn = lf_e0ipXv36.getChildNodes();
                    List<String> lf_5IgCHXGy = new ArrayList<>();
                    for (int lf_JwOVs9g2 = 0; lf_JwOVs9g2 < lf_GPQZyELn.getLength(); lf_JwOVs9g2++) {
                        Node lf_xUbcU69K = lf_GPQZyELn.item(lf_JwOVs9g2);
                        if (lf_e0ipXv36.getNodeType() == Node.ELEMENT_NODE) {
                            String lf_69MAAJrc = lf_xUbcU69K.getNodeName();
                            if ("file".equals(lf_69MAAJrc)) {
                                lf_5IgCHXGy.add(lf_xUbcU69K.getTextContent());
                            }
                        }
                    }
                    gf_9eMrBoFf = lf_5IgCHXGy;
                }
            }
        }
    }

    public static boolean m_Y11kecGR(String p_NFC3iCzh, String p_dLqAjBLj) {
        for (String lf_2RgoRp2C : gf_dMY6SVjn) {
            if (p_NFC3iCzh.equals(lf_2RgoRp2C)) {
                return true;
            } else {
                if (p_NFC3iCzh.startsWith(lf_2RgoRp2C + ".")) {
                    return true;
                }
            }
        }
        for (String lf_JGUcmOK2 : gf_kvtnux8r) {
            if (p_dLqAjBLj.equals(lf_JGUcmOK2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_xS95ysIl(String p_Hv2a22lr, String p_KhPKgBXV) {
        for (String lf_DAXztltZ : gf_K6Jl8CAh) {
            if (p_Hv2a22lr.equals(lf_DAXztltZ)) {
                return true;
            } else {
                if (p_Hv2a22lr.startsWith(lf_DAXztltZ + ".")) {
                    return true;
                }
            }
        }
        for (String lf_yjnpOmFN : gf_Pzk1LFlE) {
            if (p_KhPKgBXV.equals(lf_yjnpOmFN)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_5C6xOsAg(List<String> p_HC0zy7EY) {
        for (String lf_wlawK6iL : gf_n9DyaHEG) {
            if (p_HC0zy7EY.contains(lf_wlawK6iL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_TJR8hsZv(List<String> p_R2qaX0MI) {
        for (String lf_b5nSSXjq : gf_QWhVg1tQ) {
            if (p_R2qaX0MI.contains(lf_b5nSSXjq)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_6gZPmnqh(List<String> p_B1FzHI89) {
        for (String lf_q1YrzZgL : gf_gRoCZc0I) {
            if (p_B1FzHI89.contains(lf_q1YrzZgL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_hYlsFdBY(String p_BVrZW8Cm) {
        for (String lf_D4FMU54m : gf_bbrV2eu3) {
            if (p_BVrZW8Cm.equals(lf_D4FMU54m)) {
                return true;
            } else {
                if (p_BVrZW8Cm.startsWith(lf_D4FMU54m + ".")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m_IB5tx6Zk(String p_bWDpv7PK) {
        for (String lf_1qzs3NCR : gf_M9jypOfZ) {
            if (p_bWDpv7PK.equals(lf_1qzs3NCR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m_Czz3GRco(String p_WFOi6Q3s) {
        for (String lf_D5xzIYBQ : gf_b7ItIRzD) {
            String lf_pmDNHiHv = gf_vmUSIpx3 + lf_D5xzIYBQ;
            if (p_WFOi6Q3s.startsWith(lf_pmDNHiHv)) {
                return true;
            }
        }
        return false;
    }
}
