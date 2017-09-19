package com.es.estreothaohientruong.Data.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My_PC on 9/19/2017.
 */

public class SyncHistoryEntity implements Parcelable {
    @SerializedName("SO_BB")
    private String SO_BB;
    @SerializedName("SO_CTO_TREO")
    private String SO_CTO_TREO;
    @SerializedName("SO_CTO_THAO")
    private String SO_CTO_THAO;
    @SerializedName("SO_BB_TU_TI")
    private String SO_BB_TU_TI;
    @SerializedName("SO_TU")
    private String SO_TU;
    @SerializedName("SO_TI")
    private String SO_TI;
    @SerializedName("SO_TRAM")
    private String SO_TRAM;
    @SerializedName("NGAY_THANG")
    private String NGAY_THANG;
    @SerializedName("TINH_TRANG")
    private String TINH_TRANG;
    @SerializedName("TRANG_THAI")
    private String TRANG_THAI;

    public SyncHistoryEntity(){
    }

    protected SyncHistoryEntity(Parcel in) {
        SO_BB = in.readString();
        SO_CTO_TREO = in.readString();
        SO_CTO_THAO = in.readString();
        SO_BB_TU_TI = in.readString();
        SO_TU = in.readString();
        SO_TI = in.readString();
        SO_TRAM = in.readString();
        NGAY_THANG = in.readString();
        TINH_TRANG = in.readString();
        TRANG_THAI = in.readString();
    }

    public static final Creator<SyncHistoryEntity> CREATOR = new Creator<SyncHistoryEntity>() {
        @Override
        public SyncHistoryEntity createFromParcel(Parcel in) {
            return new SyncHistoryEntity(in);
        }

        @Override
        public SyncHistoryEntity[] newArray(int size) {
            return new SyncHistoryEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getSO_BB() {
        return SO_BB;
    }

    public void setSO_BB(String SO_BB) {
        this.SO_BB = SO_BB;
    }

    public String getSO_CTO_TREO() {
        return SO_CTO_TREO;
    }

    public void setSO_CTO_TREO(String SO_CTO_TREO) {
        this.SO_CTO_TREO = SO_CTO_TREO;
    }

    public String getSO_CTO_THAO() {
        return SO_CTO_THAO;
    }

    public void setSO_CTO_THAO(String SO_CTO_THAO) {
        this.SO_CTO_THAO = SO_CTO_THAO;
    }

    public String getSO_BB_TU_TI() {
        return SO_BB_TU_TI;
    }

    public void setSO_BB_TU_TI(String SO_BB_TU_TI) {
        this.SO_BB_TU_TI = SO_BB_TU_TI;
    }

    public String getSO_TU() {
        return SO_TU;
    }

    public void setSO_TU(String SO_TU) {
        this.SO_TU = SO_TU;
    }

    public String getSO_TI() {
        return SO_TI;
    }

    public void setSO_TI(String SO_TI) {
        this.SO_TI = SO_TI;
    }

    public String getSO_TRAM() {
        return SO_TRAM;
    }

    public void setSO_TRAM(String SO_TRAM) {
        this.SO_TRAM = SO_TRAM;
    }

    public String getNGAY_THANG() {
        return NGAY_THANG;
    }

    public void setNGAY_THANG(String NGAY_THANG) {
        this.NGAY_THANG = NGAY_THANG;
    }

    public String getTINH_TRANG() {
        return TINH_TRANG;
    }

    public void setTINH_TRANG(String TINH_TRANG) {
        this.TINH_TRANG = TINH_TRANG;
    }

    public String getTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(String TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SO_BB);
        dest.writeString(SO_CTO_TREO);
        dest.writeString(SO_CTO_THAO);
        dest.writeString(SO_BB_TU_TI);
        dest.writeString(SO_TU);
        dest.writeString(SO_TI);
        dest.writeString(SO_TRAM);
        dest.writeString(NGAY_THANG);
        dest.writeString(TINH_TRANG);
        dest.writeString(TRANG_THAI);
    }
}
