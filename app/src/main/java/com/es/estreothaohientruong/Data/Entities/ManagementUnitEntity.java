package com.es.estreothaohientruong.Data.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My_PC on 9/6/2017.
 */

public class ManagementUnitEntity implements Parcelable {
    @SerializedName("MA_DVIQLY")
    private String MA_DVIQLY;
    @SerializedName("TEN_DVIQLY")
    private String TEN_DVIQLY;
    @SerializedName("DIA_CHI")
    private String DIA_CHI;
    @SerializedName("DIEN_THOAI")
    private String DIEN_THOAI;
    @SerializedName("TAI_KHOAN")
    private String TAI_KHOAN;
    @SerializedName("MASO_THUE")
    private String MASO_THUE;
    @SerializedName("DAI_DIEN")
    private String DAI_DIEN;
    @SerializedName("CHUC_VU")
    private String CHUC_VU;
    @SerializedName("ORDERNUMBER")
    private String ORDERNUMBER;
    @SerializedName("NGAN_HANG")
    private String NGAN_HANG;
    @SerializedName("SO_FAX")
    private String SO_FAX;
    @SerializedName("EMAIL")
    private String EMAIL;
    @SerializedName("VUNG_DONGIA")
    private String VUNG_DONGIA;
    @SerializedName("MA_DVIDCHINH")
    private String MA_DVIDCHINH;
    @SerializedName("SO_QD")
    private String SO_QD;
    @SerializedName("NGAY_QD")
    private String NGAY_QD;
    @SerializedName("NGUOI_UYQUYEN")
    private String NGUOI_UYQUYEN;
    public ManagementUnitEntity(){

    }

    protected ManagementUnitEntity(Parcel in) {
        MA_DVIQLY = in.readString();
        TEN_DVIQLY = in.readString();
        DIA_CHI = in.readString();
        DIEN_THOAI = in.readString();
        TAI_KHOAN = in.readString();
        MASO_THUE = in.readString();
        DAI_DIEN = in.readString();
        CHUC_VU = in.readString();
        ORDERNUMBER = in.readString();
        NGAN_HANG = in.readString();
        SO_FAX = in.readString();
        EMAIL = in.readString();
        VUNG_DONGIA = in.readString();
        MA_DVIDCHINH = in.readString();
        SO_QD = in.readString();
        NGAY_QD = in.readString();
        NGUOI_UYQUYEN = in.readString();
    }

    public String getMA_DVIQLY() {
        return MA_DVIQLY;
    }

    public void setMA_DVIQLY(String MA_DVIQLY) {
        this.MA_DVIQLY = MA_DVIQLY;
    }

    public String getTEN_DVIQLY() {
        return TEN_DVIQLY;
    }

    public void setTEN_DVIQLY(String TEN_DVIQLY) {
        this.TEN_DVIQLY = TEN_DVIQLY;
    }

    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String DIA_CHI) {
        this.DIA_CHI = DIA_CHI;
    }

    public String getDIEN_THOAI() {
        return DIEN_THOAI;
    }

    public void setDIEN_THOAI(String DIEN_THOAI) {
        this.DIEN_THOAI = DIEN_THOAI;
    }

    public String getTAI_KHOAN() {
        return TAI_KHOAN;
    }

    public void setTAI_KHOAN(String TAI_KHOAN) {
        this.TAI_KHOAN = TAI_KHOAN;
    }

    public String getMASO_THUE() {
        return MASO_THUE;
    }

    public void setMASO_THUE(String MASO_THUE) {
        this.MASO_THUE = MASO_THUE;
    }

    public String getDAI_DIEN() {
        return DAI_DIEN;
    }

    public void setDAI_DIEN(String DAI_DIEN) {
        this.DAI_DIEN = DAI_DIEN;
    }

    public String getCHUC_VU() {
        return CHUC_VU;
    }

    public void setCHUC_VU(String CHUC_VU) {
        this.CHUC_VU = CHUC_VU;
    }

    public String getORDERNUMBER() {
        return ORDERNUMBER;
    }

    public void setORDERNUMBER(String ORDERNUMBER) {
        this.ORDERNUMBER = ORDERNUMBER;
    }

    public String getNGAN_HANG() {
        return NGAN_HANG;
    }

    public void setNGAN_HANG(String NGAN_HANG) {
        this.NGAN_HANG = NGAN_HANG;
    }

    public String getSO_FAX() {
        return SO_FAX;
    }

    public void setSO_FAX(String SO_FAX) {
        this.SO_FAX = SO_FAX;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getVUNG_DONGIA() {
        return VUNG_DONGIA;
    }

    public void setVUNG_DONGIA(String VUNG_DONGIA) {
        this.VUNG_DONGIA = VUNG_DONGIA;
    }

    public String getMA_DVIDCHINH() {
        return MA_DVIDCHINH;
    }

    public void setMA_DVIDCHINH(String MA_DVIDCHINH) {
        this.MA_DVIDCHINH = MA_DVIDCHINH;
    }

    public String getSO_QD() {
        return SO_QD;
    }

    public void setSO_QD(String SO_QD) {
        this.SO_QD = SO_QD;
    }

    public String getNGAY_QD() {
        return NGAY_QD;
    }

    public void setNGAY_QD(String NGAY_QD) {
        this.NGAY_QD = NGAY_QD;
    }

    public String getNGUOI_UYQUYEN() {
        return NGUOI_UYQUYEN;
    }

    public void setNGUOI_UYQUYEN(String NGUOI_UYQUYEN) {
        this.NGUOI_UYQUYEN = NGUOI_UYQUYEN;
    }

    public static final Creator<ManagementUnitEntity> CREATOR = new Creator<ManagementUnitEntity>() {
        @Override
        public ManagementUnitEntity createFromParcel(Parcel in) {
            return new ManagementUnitEntity(in);
        }

        @Override
        public ManagementUnitEntity[] newArray(int size) {
            return new ManagementUnitEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(MA_DVIQLY);
        dest.writeString(TEN_DVIQLY);
        dest.writeString(DIA_CHI);
        dest.writeString(DIEN_THOAI);
        dest.writeString(TAI_KHOAN);
        dest.writeString(MASO_THUE);
        dest.writeString(DAI_DIEN);
        dest.writeString(CHUC_VU);
        dest.writeString(ORDERNUMBER);
        dest.writeString(NGAN_HANG);
        dest.writeString(SO_FAX);
        dest.writeString(EMAIL);
        dest.writeString(VUNG_DONGIA);
        dest.writeString(MA_DVIDCHINH);
        dest.writeString(SO_QD);
        dest.writeString(NGAY_QD);
        dest.writeString(NGUOI_UYQUYEN);
    }
    @Override
    public String toString() {
        return TEN_DVIQLY;
    }
}
