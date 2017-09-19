package com.es.estreothaohientruong.Data.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My_PC on 9/8/2017.
 */

public class SubstationEntity implements Parcelable {
    @SerializedName("MA_TRAM")
    private String MA_TRAM;
    @SerializedName("MA_DVIQLY")
    private String MA_DVIQLY;
    @SerializedName("TEN_TRAM")
    private String TEN_TRAM;
    @SerializedName("LOAI_TRAM")
    private String LOAI_TRAM;
    @SerializedName("CSUAT_TRAM")
    private String CSUAT_TRAM;
    @SerializedName("MA_CAP_DA")
    private String MA_CAP_DA;
    @SerializedName("MA_CAP_DA_RA")
    private String MA_CAP_DA_RA;
    @SerializedName("DINH_DANH")
    private String DINH_DANH;

    protected SubstationEntity(Parcel in) {
        MA_TRAM = in.readString();
        MA_DVIQLY = in.readString();
        TEN_TRAM = in.readString();
        LOAI_TRAM = in.readString();
        CSUAT_TRAM = in.readString();
        MA_CAP_DA = in.readString();
        MA_CAP_DA_RA = in.readString();
        DINH_DANH = in.readString();
    }

    public String getMA_TRAM() {
        return MA_TRAM;
    }

    public void setMA_TRAM(String MA_TRAM) {
        this.MA_TRAM = MA_TRAM;
    }

    public String getMA_DVIQLY() {
        return MA_DVIQLY;
    }

    public void setMA_DVIQLY(String MA_DVIQLY) {
        this.MA_DVIQLY = MA_DVIQLY;
    }

    public String getTEN_TRAM() {
        return TEN_TRAM;
    }

    public void setTEN_TRAM(String TEN_TRAM) {
        this.TEN_TRAM = TEN_TRAM;
    }

    public String getLOAI_TRAM() {
        return LOAI_TRAM;
    }

    public void setLOAI_TRAM(String LOAI_TRAM) {
        this.LOAI_TRAM = LOAI_TRAM;
    }

    public String getCSUAT_TRAM() {
        return CSUAT_TRAM;
    }

    public void setCSUAT_TRAM(String CSUAT_TRAM) {
        this.CSUAT_TRAM = CSUAT_TRAM;
    }

    public String getMA_CAP_DA() {
        return MA_CAP_DA;
    }

    public void setMA_CAP_DA(String MA_CAP_DA) {
        this.MA_CAP_DA = MA_CAP_DA;
    }

    public String getMA_CAP_DA_RA() {
        return MA_CAP_DA_RA;
    }

    public void setMA_CAP_DA_RA(String MA_CAP_DA_RA) {
        this.MA_CAP_DA_RA = MA_CAP_DA_RA;
    }

    public String getDINH_DANH() {
        return DINH_DANH;
    }

    public void setDINH_DANH(String DINH_DANH) {
        this.DINH_DANH = DINH_DANH;
    }

    public static final Creator<SubstationEntity> CREATOR = new Creator<SubstationEntity>() {
        @Override
        public SubstationEntity createFromParcel(Parcel in) {
            return new SubstationEntity(in);
        }

        @Override
        public SubstationEntity[] newArray(int size) {
            return new SubstationEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(MA_TRAM);
        dest.writeString(MA_DVIQLY);
        dest.writeString(TEN_TRAM);
        dest.writeString(LOAI_TRAM);
        dest.writeString(CSUAT_TRAM);
        dest.writeString(MA_CAP_DA);
        dest.writeString(MA_CAP_DA_RA);
        dest.writeString(DINH_DANH);
    }
}
