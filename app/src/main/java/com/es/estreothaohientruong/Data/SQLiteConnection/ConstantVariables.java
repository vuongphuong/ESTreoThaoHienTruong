package com.es.estreothaohientruong.Data.SQLiteConnection;

/**
 * Created by My_PC on 9/8/2017.
 */
public class ConstantVariables {

    public static final String PROGRAM_PHOTOS_PATH = "/TTHT/PHOTOS/";
    public static final String CFG_FILENAME = "TTHT.cfg";
    public static final String[] CFG_COLUMN = {"IP_SV_1", "VERSION"};

    public final static int MENU_CHI_TIET = 0;
    public final static int MENU_GHI_CHU = 1;
    public final static int MENU_XOA_CS = 2;

    public static final String NAMESPACE = "http://tempuri.org/";

    public static final String DATABASE_NAME = "TTHT.s3db";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_NAME_DVIQLY = "D_DVIQLY";
    static final String CREATE_TABLE_DVIQLY = "CREATE TABLE " + TABLE_NAME_DVIQLY + "(ID INTEGER PRIMARY KEY NOT NULL, " +
            "MA_DVIQLY TEXT, " + "TEN_DVIQLY TEXT)";

    static final String TABLE_NAME_TRAM = "TRAM";
    static final String CREATE_TABLE_TRAM = "CREATE TABLE " + TABLE_NAME_TRAM + "(ID_TRAM INTEGER PRIMARY KEY NOT NULL, " +
            "MA_TRAM TEXT, " + "MA_DVIQLY TEXT, " + "TEN_TRAM TEXT, " + "LOAI_TRAM TEXT, " + "CSUAT_TRAM INTEGER, " + "MA_CAP_DA TEXT, " + "MA_CAP_DA_RA TEXT, " + "DINH_DANH TEXT" + ")";

    static final String TABLE_NAME_REMEMBER = "D_REMEMBER";
    static final String CREATE_TABLE_REMEMBER = "CREATE TABLE " + TABLE_NAME_REMEMBER + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "MA_DVIQLY TEXT, " + "USERNAME TEXT, " + "PASSWORD TEXT)";

    /**
     * NGAY_THANG :   là ngày giờ đồng bộ
     * TINH_TRANG :   là thành công hoặc lỗi
     * TRANG_THAI :   là lấy về hay đầy lên
     */

    static final String TABLE_NAME_HISTORY_SYNC = "D_HISTORY";
    static final String CREATE_TABLE_HISTORY_SYNC = "CREATE TABLE " + TABLE_NAME_HISTORY_SYNC + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "SO_BB TEXT, " + "SO_CTO_TREO TEXT, " + "SO_CTO_THAO TEXT, " + "SO_BB_TU_TI TEXT, " + "SO_TU TEXT, " + "SO_TI TEXT, " + "SO_TRAM TEXT," +
            "NGAY_THANG TEXT, " + "TINH_TRANG TEXT, " + "TRANG_THAI TEXT)";

    static final String TABLE_NAME_BBAN_CONGTO = "BBAN_CONGTO";
    static final String CREATE_TABLE_BBAN_CONGTO = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_BBAN_CONGTO
            + "(MA_DVIQLY TEXT NOT NULL, " + "ID_BBAN_TRTH INTEGER NOT NULL, " + "MA_DDO TEXT, " + "SO_BBAN TEXT, "
            + "NGAY_TRTH TEXT, " + "MA_NVIEN TEXT, " + "MA_LDO TEXT, " + "NGAY_TAO TEXT, " + "NGUOI_TAO TEXT, "
            + "NGAY_SUA TEXT, " + "NGUOI_SUA TEXT, " + "MA_CNANG TEXT, " + "MA_YCAU_KNAI TEXT, " + "TRANG_THAI INTEGER, "
            + "GHI_CHU TEXT, " + "ID_BBAN_CONGTO INTEGER, " + "LOAI_BBAN TEXT, " + "TEN_KHANG TEXT, " + "DCHI_HDON TEXT, "
            + "DTHOAI TEXT, " + "MA_GCS_CTO TEXT, " + "MA_TRAM TEXT, " + "MA_HDONG TEXT, " + "LY_DO_TREO_THAO TEXT)";

    static final String TABLE_NAME_DETAIL_CONGTO = "DETAIL_CONGTO";
    static final String CREATE_TABLE_DETAIL_CONGTO = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DETAIL_CONGTO
            + "("
            + "MA_DVIQLY TEXT NOT NULL, "
            + "ID_BBAN_TRTH INTEGER NOT NULL, "
            + "MA_CTO TEXT, "
            + "SO_CTO TEXT, "
            + "LAN INTEGER, "
            + "MA_BDONG TEXT, "
            + "NGAY_BDONG TEXT, "
            + "MA_CLOAI TEXT, "
            + "LOAI_CTO TEXT, "
            + "VTRI_TREO INTEGER, "
            + "MA_SOCBOOC TEXT, "
            + "SO_VIENCBOOC INTEGER, "
            + "LOAI_HOM INTEGER, "
            + "MA_SOCHOM TEXT,"
            + "SO_VIENCHOM INTEGER, "
            + "HS_NHAN INTEGER, "
            + "NGAY_TAO TEXT, "
            + "NGUOI_TAO TEXT,"
            + "NGAY_SUA TEXT, "
            + "NGUOI_SUA TEXT, "
            + "MA_CNANG TEXT, "
            + "SO_TU TEXT,"
            + "SO_TI TEXT, "

            + "SO_COT TEXT, "
            + "SO_HOM TEXT, "
            + "CHI_SO TEXT, "
            + "NGAY_KDINH TEXT, "
            + "NAM_SX TEXT, "
            + "TEM_CQUANG TEXT, "
            + "MA_CHIKDINH TEXT, "
            + "MA_TEM TEXT, "
            + "SOVIEN_CHIKDINH INTEGER, "
            + "DIEN_AP TEXT, "
            + "DONG_DIEN TEXT, "
            + "HANGSO_K TEXT, "
            + "MA_NUOC TEXT, "
            + "TEN_NUOC TEXT, "
            + "ID_CHITIET_CTO INTEGER, "
            + "SO_KIM_NIEM_CHI TEXT, "
            + "TTRANG_NPHONG TEXT, "
            + "TEN_LOAI_CTO TEXT, "
            + "PHUONG_THUC_DO_XA TEXT, "
            + "GHI_CHU TEXT,"
            + "ID_BBAN_TUTI INTEGER,"
            + "HS_NHAN_SAULAP_TUTI INTEGER, "
            + "SO_TU_SAULAP_TUTI TEXT,"
            + "SO_TI_SAULAP_TUTI TEXT, "
            + "CHI_SO_SAULAP_TUTI TEXT, "
            + "DIEN_AP_SAULAP_TUTI TEXT, "
            + "DONG_DIEN_SAULAP_TUTI TEXT, "
            + "HANGSO_K_SAULAP_TUTI TEXT, "
            + "CAP_CX_SAULAP_TUTI INTEGER, "
            + "TRANG_THAI_DU_LIEU INTEGER)";

    static final String TABLE_NAME_CONGTO_TI = "CONGTO_TI";
    static final String CREATE_TABLE_CONGTO_TI = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_CONGTO_TI
            + "(MA_DVIQLY TEXT NOT NULL, " + "ID_BBAN_TRTH INTEGER NOT NULL, " + "MA_TI TEXT, " + "SO_TI TEXT, "
            + "LAN INTEGER, " + "MA_BDONG TEXT, " + "NGAY_BDONG TEXT, " + "MA_CLOAI TEXT, " + "TYSO_DAU TEXT, "
            + "NGAY_TAO TEXT, " + "NGUOI_TAO TEXT, " + "NGAY_SUA TEXT, " + "NGUOI_SUA TEXT," + "MA_CNANG TEXT, "
            + "ID_CONGTO_TI INTEGER)";

    static final String TABLE_NAME_CONGTO_TU = "CONGTO_TU";
    static final String CREATE_TABLE_CONGTO_TU = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_CONGTO_TU
            + "(MA_DVIQLY TEXT NOT NULL, " + "ID_BBAN_TRTH INTEGER NOT NULL, " + "MA_TU TEXT, " + "SO_TU TEXT, "
            + "LAN INTEGER, " + "MA_BDONG TEXT, " + "NGAY_BDONG TEXT, " + "MA_CLOAI TEXT, " + "TYSO_DAU TEXT, "
            + "NGAY_TAO TEXT, " + "NGUOI_TAO TEXT, " + "NGAY_SUA TEXT, " + "NGUOI_SUA TEXT," + "MA_CNANG TEXT, "
            + "ID_CONGTO_TU INTEGER)";

    static final String TABLE_NAME_ANH = "ANH";
    static final String CREATE_TABLE_ANH = "CREATE TABLE " + TABLE_NAME_ANH + "(ID INTEGER PRIMARY KEY NOT NULL, "
            + "ID_CHITIET_TUTI INTEGER, "
            + "TEN_ANH TEXT , "
            + "MA_DVIQLY TEXT, "
            + "ID_BBAN_TUTI INTEGER, "
            + "ID_CHITIET_CTO INTEGER, "
            + "TYPE INTEGER, "
            + "CREATE_DAY TEXT)";

    static final String TABLE_NAME_LOAI_CONGTO = "LOAI_CONG_TO";
    static final String CREATE_TABLE_LOAI_CONGTO =
            "CREATE TABLE "
                    + TABLE_NAME_LOAI_CONGTO
                    + "(MA_CLOAI TEXT PRIMARY KEY NOT NULL, "
                    + "TEN_LOAI_CTO TEXT NOT NULL, "
                    + "MO_TA TEXT, "
                    + "SO_PHA TEXT, "
                    + "SO_DAY TEXT, "
                    + "HS_NHAN INTEGER, "
                    + "SO_CS TEXT, "
                    + "CAP_CXAC_P TEXT, "
                    + "CAP_CXAC_Q TEXT, "
                    + "DONG_DIEN TEXT, "
                    + "DIEN_AP TEXT, "
                    + "VH_CONG TEXT, "
                    + "MA_NUOC TEXT, "
                    + "MA_HANG TEXT, "
                    + "HANGSO_K TEXT, "
                    + "PTHUC_DOXA TEXT, "
                    + "TEN_NUOC TEXT)";

    static final String TABLE_NAME_BBAN_TU_TI = "BBAN_TU_TI";
    static final String CREATE_TABLE_BBAN_TU_TI =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME_BBAN_TU_TI
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "MA_DVIQLY TEXT, "
                    + "ID_BBAN_TUTI INTEGER, "
                    + "MA_DDO TEXT, "
                    + "SO_BBAN TEXT, "
                    + "NGAY_TRTH TEXT, "
                    + "MA_NVIEN TEXT, "
                    + "TRANG_THAI INTEGER, "
                    + "TEN_KHANG TEXT, "
                    + "DCHI_HDON TEXT, "
                    + "DTHOAI TEXT, "
                    + "MA_GCS_CTO TEXT, "
                    + "MA_TRAM TEXT, "
                    + "LY_DO_TREO_THAO TEXT, "
                    + "MA_KHANG TEXT, "
                    + "ID_BBAN_WEB_TUTI INTEGER, "
                    + "NVIEN_KCHI TEXT)";


    static final String TABLE_NAME_CHITIET_TU_TI = "CHITIET_TU_TI";
    static final String CREATE_TABLE_CHITIET_TU_TI =
            "CREATE TABLE IF NOT EXISTS "
                    + TABLE_NAME_CHITIET_TU_TI
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "MA_CLOAI TEXT, "
                    + "LOAI_TU_TI TEXT, "
                    + "MO_TA TEXT, "
                    + "SO_PHA INTEGER, "
                    + "TYSO_DAU TEXT, "
                    + "CAP_CXAC INTEGER, "
                    + "CAP_DAP INTEGER, "
                    + "MA_NUOC TEXT, "
                    + "MA_HANG TEXT, "
                    + "TRANG_THAI INTEGER, "
                    + "IS_TU TEXT, "
                    + "ID_BBAN_TUTI INTEGER, "
                    + "ID_CHITIET_TUTI INTEGER, "
                    + "SO_TU_TI TEXT, "
                    + "NUOC_SX TEXT, "
                    + "SO_TEM_KDINH TEXT, "
                    + "NGAY_KDINH TEXT, "
                    + "MA_CHI_KDINH TEXT, "
                    + "MA_CHI_HOP_DDAY TEXT, "
                    + "SO_VONG_THANH_CAI INTEGER, "
                    + "TYSO_BIEN TEXT, "
                    + "MA_BDONG TEXT, "
                    + "MA_DVIQLY TEXT)";
}
