package com.es.estreothaohientruong.Data.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My_PC on 9/19/2017.
 */

public class MeterEntity implements Parcelable {
    @SerializedName("MA_DVIQLY")
    private String MA_DVIQLY;
    @SerializedName("ID_BBAN_TRTH")
    private String ID_BBAN_TRTH;
    @SerializedName("MA_CTO")
    private String MA_CTO;
    @SerializedName("SO_CTO")
    private String SO_CTO;
    @SerializedName("LAN")
    private String LAN;
    @SerializedName("MA_BDONG")
    private String MA_BDONG;
    @SerializedName("NGAY_BDONG")
    private String NGAY_BDONG;
    @SerializedName("MA_CLOAI")
    private String MA_CLOAI;
    @SerializedName("LOAI_CTO")
    private String LOAI_CTO;
    @SerializedName("VTRI_TREO")
    private String VTRI_TREO;
    @SerializedName("MO_TA_VTRI_TREO")
    private String MO_TA_VTRI_TREO;
    @SerializedName("MA_SOCBOOC")
    private String MA_SOCBOOC;
    @SerializedName("SO_VIENCBOOC")
    private String SO_VIENCBOOC;
    @SerializedName("MA_SOCHOM")
    private String MA_SOCHOM;
    @SerializedName("SO_VIENCHOM")
    private String SO_VIENCHOM;
    @SerializedName("HS_NHAN")
    private String HS_NHAN;
    @SerializedName("NGAY_TAO")
    private String NGAY_TAO;
    @SerializedName("NGUOI_TAO")
    private String NGUOI_TAO;
    @SerializedName("NGAY_SUA")
    private String NGAY_SUA;
    @SerializedName("NGUOI_SUA")
    private String NGUOI_SUA;
    @SerializedName("MA_CNANG")
    private String MA_CNANG;
    @SerializedName("SO_TU")
    private String SO_TU;
    @SerializedName("SO_TI")
    private String SO_TI;
    @SerializedName("SO_COT")
    private String SO_COT;
    @SerializedName("SO_HOM")
    private String SO_HOM;
    @SerializedName("CHI_SO")
    private String CHI_SO;
    @SerializedName("NGAY_KDINH")
    private String NGAY_KDINH;
    @SerializedName("NAM_SX")
    private String NAM_SX;
    @SerializedName("TEM_CQUANG")
    private String TEM_CQUANG;
    @SerializedName("MA_CHIKDINH")
    private String MA_CHIKDINH;
    @SerializedName("MA_TEM")
    private String MA_TEM;
    @SerializedName("SOVIEN_CHIKDINH")
    private String SOVIEN_CHIKDINH;
    @SerializedName("DIEN_AP")
    private String DIEN_AP;
    @SerializedName("DONG_DIEN")
    private String DONG_DIEN;
    @SerializedName("HANGSO_K")
    private String HANGSO_K;
    @SerializedName("MA_NUOC")
    private String MA_NUOC;
    @SerializedName("TEN_NUOC")
    private String TEN_NUOC;
    @SerializedName("SOVIEN_CHIHOP")
    private String SOVIEN_CHIHOP;
    @SerializedName("SO_KIM_NIEM_CHI")
    private String SO_KIM_NIEM_CHI;
    @SerializedName("MA_CHIHOP")
    private String MA_CHIHOP;
    @SerializedName("TTRANG_NPHONG")
    private String TTRANG_NPHONG;
    @SerializedName("TEN_LOAI_CTO")
    private String TEN_LOAI_CTO;
    @SerializedName("PHUONG_THUC_DO_XA")
    private String PHUONG_THUC_DO_XA;
    @SerializedName("ID_CHITIET_CTO")
    private String ID_CHITIET_CTO;
    @SerializedName("ID_BBAN_TUTI")
    private String ID_BBAN_TUTI;
    @SerializedName("LOAI_HOM")
    private String LOAI_HOM;

    public MeterEntity(){

    }

    protected MeterEntity(Parcel in) {
        MA_DVIQLY = in.readString();
        ID_BBAN_TRTH = in.readString();
        MA_CTO = in.readString();
        SO_CTO = in.readString();
        LAN = in.readString();
        MA_BDONG = in.readString();
        NGAY_BDONG = in.readString();
        MA_CLOAI = in.readString();
        LOAI_CTO = in.readString();
        VTRI_TREO = in.readString();
        MO_TA_VTRI_TREO = in.readString();
        MA_SOCBOOC = in.readString();
        SO_VIENCBOOC = in.readString();
        MA_SOCHOM = in.readString();
        SO_VIENCHOM = in.readString();
        HS_NHAN = in.readString();
        NGAY_TAO = in.readString();
        NGUOI_TAO = in.readString();
        NGAY_SUA = in.readString();
        NGUOI_SUA = in.readString();
        MA_CNANG = in.readString();
        SO_TU = in.readString();
        SO_TI = in.readString();
        SO_COT = in.readString();
        SO_HOM = in.readString();
        CHI_SO = in.readString();
        NGAY_KDINH = in.readString();
        NAM_SX = in.readString();
        TEM_CQUANG = in.readString();
        MA_CHIKDINH = in.readString();
        MA_TEM = in.readString();
        SOVIEN_CHIKDINH = in.readString();
        DIEN_AP = in.readString();
        DONG_DIEN = in.readString();
        HANGSO_K = in.readString();
        MA_NUOC = in.readString();
        TEN_NUOC = in.readString();
        SOVIEN_CHIHOP = in.readString();
        SO_KIM_NIEM_CHI = in.readString();
        MA_CHIHOP = in.readString();
        TTRANG_NPHONG = in.readString();
        TEN_LOAI_CTO = in.readString();
        PHUONG_THUC_DO_XA = in.readString();
        ID_CHITIET_CTO = in.readString();
        ID_BBAN_TUTI = in.readString();
        LOAI_HOM = in.readString();
    }

    public static final Creator<MeterEntity> CREATOR = new Creator<MeterEntity>() {
        @Override
        public MeterEntity createFromParcel(Parcel in) {
            return new MeterEntity(in);
        }

        @Override
        public MeterEntity[] newArray(int size) {
            return new MeterEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(MA_DVIQLY);
        dest.writeString(ID_BBAN_TRTH);
        dest.writeString(MA_CTO);
        dest.writeString(SO_CTO);
        dest.writeString(LAN);
        dest.writeString(MA_BDONG);
        dest.writeString(NGAY_BDONG);
        dest.writeString(MA_CLOAI);
        dest.writeString(LOAI_CTO);
        dest.writeString(VTRI_TREO);
        dest.writeString(MO_TA_VTRI_TREO);
        dest.writeString(MA_SOCBOOC);
        dest.writeString(SO_VIENCBOOC);
        dest.writeString(MA_SOCHOM);
        dest.writeString(SO_VIENCHOM);
        dest.writeString(HS_NHAN);
        dest.writeString(NGAY_TAO);
        dest.writeString(NGUOI_TAO);
        dest.writeString(NGAY_SUA);
        dest.writeString(NGUOI_SUA);
        dest.writeString(MA_CNANG);
        dest.writeString(SO_TU);
        dest.writeString(SO_TI);
        dest.writeString(SO_COT);
        dest.writeString(SO_HOM);
        dest.writeString(CHI_SO);
        dest.writeString(NGAY_KDINH);
        dest.writeString(NAM_SX);
        dest.writeString(TEM_CQUANG);
        dest.writeString(MA_CHIKDINH);
        dest.writeString(MA_TEM);
        dest.writeString(SOVIEN_CHIKDINH);
        dest.writeString(DIEN_AP);
        dest.writeString(DONG_DIEN);
        dest.writeString(HANGSO_K);
        dest.writeString(MA_NUOC);
        dest.writeString(TEN_NUOC);
        dest.writeString(SOVIEN_CHIHOP);
        dest.writeString(SO_KIM_NIEM_CHI);
        dest.writeString(MA_CHIHOP);
        dest.writeString(TTRANG_NPHONG);
        dest.writeString(TEN_LOAI_CTO);
        dest.writeString(PHUONG_THUC_DO_XA);
        dest.writeString(ID_CHITIET_CTO);
        dest.writeString(ID_BBAN_TUTI);
        dest.writeString(LOAI_HOM);
    }
}
