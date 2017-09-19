package com.es.estreothaohientruong.Data.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My_PC on 9/8/2017.
 */

public class ReportEntity implements Parcelable {
    @SerializedName("ID_BBAN_TRTH")
    private String ID_BBAN_TRTH;
    @SerializedName("MA_CNANG")
    private String MA_CNANG;
    @SerializedName("MA_DDO")
    private String MA_DDO;
    @SerializedName("MA_DVIQLY")
    private String MA_DVIQLY;
    @SerializedName("MA_LDO")
    private String MA_LDO;
    @SerializedName("MA_NVIEN")
    private String MA_NVIEN;
    @SerializedName("MA_YCAU_KNAI")
    private String MA_YCAU_KNAI;
    @SerializedName("NGAY_SUA")
    private String NGAY_SUA;
    @SerializedName("NGAY_TAO")
    private String NGAY_TAO;
    @SerializedName("NGAY_TRTH")
    private String NGAY_TRTH;
    @SerializedName("NGUOI_SUA")
    private String NGUOI_SUA;
    @SerializedName("NGUOI_TAO")
    private String NGUOI_TAO;
    @SerializedName("SO_BBAN")
    private String SO_BBAN;
    @SerializedName("TRANG_THAI")
    private String TRANG_THAI;
    @SerializedName("GHI_CHU")
    private String GHI_CHU;
    @SerializedName("LOAI_BBAN")
    private String LOAI_BBAN;
    @SerializedName("TEN_KHANG")
    private String TEN_KHANG;
    @SerializedName("DCHI_HDON")
    private String DCHI_HDON;
    @SerializedName("DTHOAI")
    private String DTHOAI;
    @SerializedName("MA_GCS_CTO")
    private String MA_GCS_CTO;
    @SerializedName("MA_TRAM")
    private String MA_TRAM;
    @SerializedName("MA_HDONG")
    private String MA_HDONG;
    @SerializedName("LY_DO_TREO_THAO")
    private String LY_DO_TREO_THAO;

    public ReportEntity() {
    }

    protected ReportEntity(Parcel in) {
        ID_BBAN_TRTH = in.readString();
        MA_CNANG = in.readString();
        MA_DDO = in.readString();
        MA_DVIQLY = in.readString();
        MA_LDO = in.readString();
        MA_NVIEN = in.readString();
        MA_YCAU_KNAI = in.readString();
        NGAY_SUA = in.readString();
        NGAY_TAO = in.readString();
        NGAY_TRTH = in.readString();
        NGUOI_SUA = in.readString();
        NGUOI_TAO = in.readString();
        SO_BBAN = in.readString();
        TRANG_THAI = in.readString();
        GHI_CHU = in.readString();
        LOAI_BBAN = in.readString();
        TEN_KHANG = in.readString();
        DCHI_HDON = in.readString();
        DTHOAI = in.readString();
        MA_GCS_CTO = in.readString();
        MA_TRAM = in.readString();
        MA_HDONG = in.readString();
        LY_DO_TREO_THAO = in.readString();
    }

    public static final Creator<ReportEntity> CREATOR = new Creator<ReportEntity>() {
        @Override
        public ReportEntity createFromParcel(Parcel in) {
            return new ReportEntity(in);
        }

        @Override
        public ReportEntity[] newArray(int size) {
            return new ReportEntity[size];
        }
    };

    public String getID_BBAN_TRTH() {
        return ID_BBAN_TRTH;
    }

    public void setID_BBAN_TRTH(String ID_BBAN_TRTH) {
        this.ID_BBAN_TRTH = ID_BBAN_TRTH;
    }

    public String getMA_CNANG() {
        return MA_CNANG;
    }

    public void setMA_CNANG(String MA_CNANG) {
        this.MA_CNANG = MA_CNANG;
    }

    public String getMA_DDO() {
        return MA_DDO;
    }

    public void setMA_DDO(String MA_DDO) {
        this.MA_DDO = MA_DDO;
    }

    public String getMA_DVIQLY() {
        return MA_DVIQLY;
    }

    public void setMA_DVIQLY(String MA_DVIQLY) {
        this.MA_DVIQLY = MA_DVIQLY;
    }

    public String getMA_LDO() {
        return MA_LDO;
    }

    public void setMA_LDO(String MA_LDO) {
        this.MA_LDO = MA_LDO;
    }

    public String getMA_NVIEN() {
        return MA_NVIEN;
    }

    public void setMA_NVIEN(String MA_NVIEN) {
        this.MA_NVIEN = MA_NVIEN;
    }

    public String getMA_YCAU_KNAI() {
        return MA_YCAU_KNAI;
    }

    public void setMA_YCAU_KNAI(String MA_YCAU_KNAI) {
        this.MA_YCAU_KNAI = MA_YCAU_KNAI;
    }

    public String getNGAY_SUA() {
        return NGAY_SUA;
    }

    public void setNGAY_SUA(String NGAY_SUA) {
        this.NGAY_SUA = NGAY_SUA;
    }

    public String getNGAY_TAO() {
        return NGAY_TAO;
    }

    public void setNGAY_TAO(String NGAY_TAO) {
        this.NGAY_TAO = NGAY_TAO;
    }

    public String getNGAY_TRTH() {
        return NGAY_TRTH;
    }

    public void setNGAY_TRTH(String NGAY_TRTH) {
        this.NGAY_TRTH = NGAY_TRTH;
    }

    public String getNGUOI_SUA() {
        return NGUOI_SUA;
    }

    public void setNGUOI_SUA(String NGUOI_SUA) {
        this.NGUOI_SUA = NGUOI_SUA;
    }

    public String getNGUOI_TAO() {
        return NGUOI_TAO;
    }

    public void setNGUOI_TAO(String NGUOI_TAO) {
        this.NGUOI_TAO = NGUOI_TAO;
    }

    public String getSO_BBAN() {
        return SO_BBAN;
    }

    public void setSO_BBAN(String SO_BBAN) {
        this.SO_BBAN = SO_BBAN;
    }

    public String getTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(String TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    public String getGHI_CHU() {
        return GHI_CHU;
    }

    public void setGHI_CHU(String GHI_CHU) {
        this.GHI_CHU = GHI_CHU;
    }

    public String getLOAI_BBAN() {
        return LOAI_BBAN;
    }

    public void setLOAI_BBAN(String LOAI_BBAN) {
        this.LOAI_BBAN = LOAI_BBAN;
    }

    public String getTEN_KHANG() {
        return TEN_KHANG;
    }

    public void setTEN_KHANG(String TEN_KHANG) {
        this.TEN_KHANG = TEN_KHANG;
    }

    public String getDCHI_HDON() {
        return DCHI_HDON;
    }

    public void setDCHI_HDON(String DCHI_HDON) {
        this.DCHI_HDON = DCHI_HDON;
    }

    public String getDTHOAI() {
        return DTHOAI;
    }

    public void setDTHOAI(String DTHOAI) {
        this.DTHOAI = DTHOAI;
    }

    public String getMA_GCS_CTO() {
        return MA_GCS_CTO;
    }

    public void setMA_GCS_CTO(String MA_GCS_CTO) {
        this.MA_GCS_CTO = MA_GCS_CTO;
    }

    public String getMA_TRAM() {
        return MA_TRAM;
    }

    public void setMA_TRAM(String MA_TRAM) {
        this.MA_TRAM = MA_TRAM;
    }

    public String getMA_HDONG() {
        return MA_HDONG;
    }

    public void setMA_HDONG(String MA_HDONG) {
        this.MA_HDONG = MA_HDONG;
    }

    public String getLY_DO_TREO_THAO() {
        return LY_DO_TREO_THAO;
    }

    public void setLY_DO_TREO_THAO(String LY_DO_TREO_THAO) {
        this.LY_DO_TREO_THAO = LY_DO_TREO_THAO;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID_BBAN_TRTH);
        dest.writeString(MA_CNANG);
        dest.writeString(MA_DDO);
        dest.writeString(MA_DVIQLY);
        dest.writeString(MA_LDO);
        dest.writeString(MA_NVIEN);
        dest.writeString(MA_YCAU_KNAI);
        dest.writeString(NGAY_SUA);
        dest.writeString(NGAY_TAO);
        dest.writeString(NGAY_TRTH);
        dest.writeString(NGUOI_SUA);
        dest.writeString(NGUOI_TAO);
        dest.writeString(SO_BBAN);
        dest.writeString(TRANG_THAI);
        dest.writeString(GHI_CHU);
        dest.writeString(LOAI_BBAN);
        dest.writeString(TEN_KHANG);
        dest.writeString(DCHI_HDON);
        dest.writeString(DTHOAI);
        dest.writeString(MA_GCS_CTO);
        dest.writeString(MA_TRAM);
        dest.writeString(MA_HDONG);
        dest.writeString(LY_DO_TREO_THAO);
    }
}
