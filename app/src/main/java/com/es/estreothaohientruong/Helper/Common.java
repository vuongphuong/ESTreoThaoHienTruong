package com.es.estreothaohientruong.Helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by My_PC on 9/5/2017.
 */

public class Common {
    public static String POST = "POST";
    public static String GET = "GET";
    public static String URL = "/api/serviceMTB/";

    public static final int REQUEST_GET_MN_UNIT = 100;
    public static final int REQUEST_LOGIN = 101;
    public static final int REQUEST_REPORT = 102;
    public static final int REQUEST_SUBTATION = 103;

    public static final int REQUEST_PERMISSION_READ_PHONE = 110;
    public static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 111;
    public static final int READ_EXTERNAL_STORAGE = 112;

    public final static int SIZE_HEIGHT_IMAGE = 600; //có thể thay đổi
    public final static int SIZE_WIDTH_IMAGE_BASIC = 500; //lưu ý không thay đổi được vì chiều ngang 600 mới ghi đủ thông tin cơ bản.

    public static final String PROGRAM_PATH = "/TTHT/";
    public static final String PROGRAM_DB_PATH = "/TTHT/DB/";
    public static final String PROGRAM_DB_BACKUP_PATH = "/TTHT/DB/BACKUP/";
    public static final String DATABASE_NAME = "TTHT.s3db";

    @SuppressLint("HardwareIds")
    public static String GetIMEI(Context context) {
        try {
            TelephonyManager tManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            String IMEI = tManager.getDeviceId();
            if (IMEI == null) {
                Class<?> c = Class.forName("android.os.SystemProperties");
                Method get = c.getMethod("get", String.class);
                IMEI = (String) get.invoke(c, "ro.serialno");
            }

//            return Settings.Secure.getString(context.getContentResolver(),
//                    Settings.Secure.ANDROID_ID);
            return IMEI;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNetworkOnline(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null
                    && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getNetworkInfo(1);
                if (netInfo != null
                        && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;
    }
    public static void CheckForder() {
        try {
            File programDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_PATH);
            if (!programDirectory.exists()) {
                programDirectory.mkdirs();
            }

            File programDbDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_PATH);
            if (!programDbDirectory.exists()) {
                programDbDirectory.mkdirs();
            }
            File programSampleDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_BACKUP_PATH);
            if (!programSampleDirectory.exists()) {
                programSampleDirectory.mkdirs();
            }
//            File programPhotoDirectory = new File(Environment.getExternalStorageDirectory() + TthtConstantVariables.PROGRAM_PHOTOS_PATH);
//            if (!programPhotoDirectory.exists()) {
//                programPhotoDirectory.mkdirs();
//            }
//            String filePath = Environment.getExternalStorageDirectory() + TthtConstantVariables.PROGRAM_PATH + TthtConstantVariables.CFG_FILENAME;
//            File cfgFile = new File(filePath);
//            if (cfgFile.exists()) {
//                TthtCommon.cfgInfo = TthtCommon.GetFileConfig();
//                if (TthtCommon.cfgInfo == null) {
//                    TthtCommon.cfgInfo = new TthtConfigInfo();
//                }
//            } else {
//                TthtCommon.cfgInfo = new TthtConfigInfo();
//                TthtCommon.CreateFileConfig(TthtCommon.cfgInfo, cfgFile, "");
//            }
        } catch (Exception ex) {
        }
    }
    public static void LoadFolder(ContextWrapper ctx) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            File file_db = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_PATH);

            FilenameFilter fileNameFilter = new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if (!name.equals("BACKUP")) {
                        return true;
                    }
                    return false;
                }
            };

            String[] allFilesDb = file_db.list(fileNameFilter);
            for (int i = 0; i < allFilesDb.length; i++) {
                allFilesDb[i] = Environment.getExternalStorageDirectory() + PROGRAM_DB_PATH + allFilesDb[i];
            }
            if (allFilesDb != null)
                scanFile(ctx, allFilesDb);

            File file_db_backup = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_BACKUP_PATH);
            String[] allFilesDbBackup = file_db_backup.list();
            if (allFilesDbBackup.length > 0) {
                for (int i = 0; i < allFilesDbBackup.length; i++) {
                    allFilesDbBackup[i] = Environment.getExternalStorageDirectory() + PROGRAM_DB_BACKUP_PATH + allFilesDbBackup[i];
                }
                if (allFilesDbBackup != null)
                    scanFile(ctx, allFilesDbBackup);
            }
        } else {
            ctx.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri
                    .parse("file://" + Environment.getExternalStorageDirectory() + PROGRAM_PATH)));
        }
    }
    public static void scanFile(Context ctx, String[] allFiles) {
        MediaScannerConnection.scanFile(ctx, allFiles, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        AppLog.d("ExternalStorage", "Scanned " + path + ":");
                        AppLog.d("ExternalStorage", "uri=" + uri);
                    }
                });
    }
    public static int dpToPx(Context context, int dp){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)((dp * displayMetrics.density) + 0.5);
    }

    public static int convertDpToPixel(float dp, Context context) {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return height;
    }
    /**
     * @param context
     * @param PATH_ANH
     * @param VI_TRI_1:   dòng đầu
     * @param VI_TRI_2_1  : dòng thứ 2 bên trái
     * @param VI_TRI_2_2  : dòng thứ 2 bên phải
     * @param VI_TRI_3    : dòng thứ 3 bên trái
     * @param VI_TRI_4_1: dòng thứ 4 dưới cùng bên trái
     * @param VI_TRI_4_2: dòng thứ 4 dưới cùng bên phải
     * @return
     */
    public static Bitmap drawTextOnBitmapCongTo(Context context, String PATH_ANH, String VI_TRI_1, String VI_TRI_2_1, String VI_TRI_2_2, String VI_TRI_3, String VI_TRI_4_1, String VI_TRI_4_2) {
        try {
            String fileName = PATH_ANH;
            File fBitmap = new File(fileName);
            if (fBitmap.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bmRoot = BitmapFactory.decodeFile(fileName, options);
                if (bmRoot != null) {
                    Bitmap.Config bmConfig = bmRoot.getConfig();
                    if (bmConfig == null) {
                        bmConfig = android.graphics.Bitmap.Config.ARGB_8888;
                    }
                    bmRoot = bmRoot.copy(bmConfig, true);

                    //TODO Tạo paint để vẽ nền đen
                    Paint paint_background = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint_background.setColor(Color.BLACK);

                    //TODO tạo paint text để vẽ text
                    final int text_size = 20;
                    final int paddingBetweenText = 10;
                    Paint paint_text = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint_text.setColor(Color.WHITE);
                    paint_text.setTextSize(text_size);//textSize = 20
                    final int textHeight = Math.round(paint_text.descent() - paint_text.ascent());

                    // TODO tính dòng sẽ được vẽ của chuỗi dài chưa xác định TEN_KH, không cần xác định x, y
                    int soDongCuaTextVI_TRI_1 = drawTextAndBreakLine(true, null, paint_text, 0, 0, textHeight, bmRoot.getWidth(), VI_TRI_1, paddingBetweenText);

                    // TODO tính dòng sẽ được vẽ của chuỗi dài chưa xác định CHI_SO
                    int soDongCuaTextVI_TRI_3 = drawTextAndBreakLine(true, null, paint_text, 0, 0, textHeight, bmRoot.getWidth(), VI_TRI_3, paddingBetweenText);

                    //TODO tạo bitmap với diện tích như khung chứa để vẽ ảnh và thông tin
                    Bitmap.Config conf = Bitmap.Config.ARGB_8888;
                    Bitmap bitmapResult = null;
                    //TODO do fix cứng h của nội dung ảnh là SIZE_HEIGHT_IMAGE, nên khi resize thì w thay đổi,
                    //TODO nếu < 1 giá trị nào đó thì không đủ bề ngang w để ghi thông tin, (SIZE_HEIGHT_IMAGE >600 thì ghi đủ), ta chèn thêm viền đen vào nếu không đủ ghi
                    if (bmRoot.getWidth() > SIZE_WIDTH_IMAGE_BASIC) {
                        bitmapResult = Bitmap.createBitmap(
                                bmRoot.getWidth(),
                                paddingBetweenText / 2
                                        + (soDongCuaTextVI_TRI_1) * (textHeight + paddingBetweenText)
                                        + textHeight
                                        + paddingBetweenText
                                        + (soDongCuaTextVI_TRI_3) * (textHeight + paddingBetweenText)
                                        + SIZE_HEIGHT_IMAGE
                                        + paddingBetweenText
                                        + textHeight
                                        + paddingBetweenText / 2
                                , conf);
                    } else
                        bitmapResult = Bitmap.createBitmap(
                                SIZE_WIDTH_IMAGE_BASIC,
                                paddingBetweenText / 2
                                        + (soDongCuaTextVI_TRI_1) * (textHeight + paddingBetweenText)
                                        + textHeight
                                        + paddingBetweenText
                                        + (soDongCuaTextVI_TRI_3) * (textHeight + paddingBetweenText)
                                        + SIZE_HEIGHT_IMAGE
                                        + paddingBetweenText
                                        + textHeight
                                        + paddingBetweenText / 2
                                , conf);

                    //TODO khởi tạo canvas
                    Canvas canvas = new Canvas(bitmapResult);


                    //TODO vẽ ảnh lên khung tại tọa độ với trên ảnh (soDongCuaText  + 1dòng TYPE_IMAGE + 1 dòng chỉ số...) + (+ 1 dòng MA_DDO)
                    //TODO kiểm tra nếu anh có chiều cao lớn hơn bình thường
                    //TODO tức đã được đính kèm info thì ta lấy vị trí ảnh từ
                    int x0 = 0;
                    int y0 = paddingBetweenText / 2
                            + (soDongCuaTextVI_TRI_1) * (textHeight + paddingBetweenText)
                            + textHeight
                            + paddingBetweenText
                            + (soDongCuaTextVI_TRI_3) * (textHeight + paddingBetweenText); //vẽ từ vị trí trên TthtCommon.SIZE_HEIGHT_IMAGE

                    //TODO tạo khung chứa bitmap từ tọa độ x0, y0 tới .. ...
                    RectF frameBitmap = new RectF(x0, y0, x0 + bmRoot.getWidth(), y0 + SIZE_HEIGHT_IMAGE);


                    //TODO vẽ full ảnh resultBimap với màu đen làm nền
                    canvas.drawRect(0, 0, bitmapResult.getWidth(), bitmapResult.getHeight(), paint_background);

                    //TODO nếu đã được ghi
                    if (bmRoot.getHeight() > SIZE_HEIGHT_IMAGE) {
                        Rect src = new Rect(x0, bmRoot.getHeight() - textHeight - paddingBetweenText - Math.round(paddingBetweenText / 2) - SIZE_HEIGHT_IMAGE, bmRoot.getWidth(), bmRoot.getHeight() - textHeight - paddingBetweenText - Math.round(paddingBetweenText / 2));
                        Rect des = null;
                        //TODO nếu ảnh có w <= 600 thì vẽ ảnh ở giữa
                        if (bmRoot.getWidth() <= SIZE_WIDTH_IMAGE_BASIC) {
                            des = new Rect(Math.round((SIZE_WIDTH_IMAGE_BASIC - bmRoot.getWidth()) / 2), y0, SIZE_WIDTH_IMAGE_BASIC - Math.round((SIZE_WIDTH_IMAGE_BASIC - bmRoot.getWidth()) / 2), y0 + SIZE_HEIGHT_IMAGE);
                        } else {
                            des = new Rect(x0, y0, bitmapResult.getWidth(), y0 + SIZE_HEIGHT_IMAGE);
                        }
                        //TODO ngược lại vẽ full ảnh
                        //TODO vẽ một phần chính của ảnh bitmap trên trên khung chứa bitmap với bút paint màu đen
                        canvas.drawBitmap(bmRoot, src, des, paint_background);
                    } else {
                        //TODO vẽ full ở giữa
                        //TODO nếu ảnh có w <= 600 thì vẽ ảnh ở giữa
                        RectF frameBitmapCenter = null;
                        if (bmRoot.getWidth() <= SIZE_WIDTH_IMAGE_BASIC) {
                            frameBitmapCenter = new RectF(Math.round((SIZE_WIDTH_IMAGE_BASIC - bmRoot.getWidth()) / 2), y0, SIZE_WIDTH_IMAGE_BASIC - Math.round((SIZE_WIDTH_IMAGE_BASIC - bmRoot.getWidth()) / 2), y0 + SIZE_HEIGHT_IMAGE);
                        } else {
                            frameBitmapCenter = new RectF(x0, y0, bitmapResult.getWidth(), y0 + SIZE_HEIGHT_IMAGE);
                        }
                        //TODO vẽ full bitmap trên trên khung chứa bitmap với bút paint màu đen
                        canvas.drawBitmap(bmRoot, null, frameBitmapCenter, paint_background);
                    }

                    //TODO vẽ TEN_KH
                    drawTextAndBreakLine(false, canvas, paint_text, 0, paddingBetweenText / 2 + textHeight, textHeight, bmRoot.getWidth(), VI_TRI_1, paddingBetweenText);

                    //TODO vẽ TYPE IMAGE
                    //Vẽ 1 khung chứa TYPE IMAGE
                    Rect khungTYPE_IMAGE = new Rect();
                    paint_text.getTextBounds(VI_TRI_2_1, 0, VI_TRI_2_1.length(), khungTYPE_IMAGE);
                    int x_TYPE_IMAGE = 0;
                    int y_TYPE_IMAGE = soDongCuaTextVI_TRI_1 * (textHeight + paddingBetweenText) + textHeight;
                    canvas.drawRect(x_TYPE_IMAGE, y_TYPE_IMAGE - textHeight, VI_TRI_2_1.length(), y_TYPE_IMAGE + paddingBetweenText, paint_background);

                    //Vẽ text TYPE IMAGE
                    canvas.drawText(VI_TRI_2_1, x_TYPE_IMAGE, y_TYPE_IMAGE, paint_text);

                    //TODO vẽ Ngày
//                    String VI_TRI_2_2 = TthtCommon.getDateNow(TthtCommon.TYPE_DATENOW.ddMMyyyyHHmmss_Slash_Space_Colon.toString());
                    //Vẽ 1 khung chứa DATENOW
                    Rect khungDATENOW = new Rect();
                    paint_text.getTextBounds(VI_TRI_2_2, 0, VI_TRI_2_2.length(), khungDATENOW);
                    int textWidthDATENOW = Math.round(paint_text.measureText(VI_TRI_2_2));
                    int x_DATENOW = bitmapResult.getWidth() - textWidthDATENOW;
                    int y_DATENOW = y_TYPE_IMAGE;
                    canvas.drawRect(x_DATENOW, y_DATENOW - textHeight, bitmapResult.getWidth(), y_DATENOW + paddingBetweenText, paint_background);

                    //Vẽ text DATENOW
                    canvas.drawText(VI_TRI_2_2, x_DATENOW, y_DATENOW, paint_text);

                    //TODO vẽ CHI_SO
                    drawTextAndBreakLine(false, canvas, paint_text, 0, y_TYPE_IMAGE + textHeight + paddingBetweenText, textHeight, bmRoot.getWidth(), VI_TRI_3, paddingBetweenText);

                 /*   //Vẽ 1 khung chứa CHI_SO
                    Rect khungCHI_SO = new Rect();
                    paint_text.getTextBounds(VI_TRI_3, 0, (VI_TRI_3).length(), khungCHI_SO);
                    int x_CHI_SO = 0;
                    int y_CHI_SO = y_TYPE_IMAGE + textHeight + paddingBetweenText;
                    canvas.drawRect(x_CHI_SO, y_CHI_SO - textHeight, bitmapResult.getWidth(), y_CHI_SO + paddingBetweenText, paint_background);
                    //Vẽ text CHI_SO
                    canvas.drawText(VI_TRI_3, x_CHI_SO, y_CHI_SO, paint_text);*/

                    //TODO điền SO_CTO
                    Rect khungSO_CTO = new Rect();
                    paint_text.getTextBounds(VI_TRI_4_1, 0, (VI_TRI_4_1).length(), khungSO_CTO);
                    int x_SO_CTO = 0;
                    int y_SO_CTO = bitmapResult.getHeight();
                    canvas.drawRect(0, y_SO_CTO - textHeight - paddingBetweenText, VI_TRI_4_1.length(), y_SO_CTO, paint_background);

                    //Vẽ text SO_CTO cách thêm 1 khoảng dưới cùng 1 đoạn paddingBetweenText/2
                    canvas.drawText(VI_TRI_4_1, x_SO_CTO, y_SO_CTO - paddingBetweenText / 2, paint_text);

                    //TODO điền MA_DDO
                    Rect khungMA_DDO = new Rect();
                    paint_text.getTextBounds(VI_TRI_4_2, 0, VI_TRI_4_2.length(), khungMA_DDO);
                    int textWidthMA_DDO = Math.round(paint_text.measureText(VI_TRI_4_2));
                    int x_MA_DDO = bitmapResult.getWidth() - textWidthMA_DDO;
                    int y_MA_DDO = y_SO_CTO;
                    canvas.drawRect(x_MA_DDO, y_MA_DDO - textHeight - paddingBetweenText, bitmapResult.getWidth(), y_MA_DDO, paint_background);

                    //Vẽ text MA_DDO cách thêm 1 khoảng dưới cùng 1 đoạn paddingBetweenText/2
                    canvas.drawText(VI_TRI_4_2, x_MA_DDO, y_MA_DDO - paddingBetweenText / 2, paint_text);

                    BufferedOutputStream bos = null;
                    try {
                        bos = new BufferedOutputStream(new FileOutputStream(fileName));
                        bos.write(Common.encodeTobase64Byte(bitmapResult));
                        bos.close();
                        scanFile(context, new String[]{fileName});
                    } catch (IOException ex) {
                        throw new Exception(ex.getMessage());
                    }
                    return bitmapResult;
                } else {
                    throw new Exception("Lỗi khi xử lý ảnh!");
                }
            } else {
                throw new Exception("Không có ảnh trong máy!");
            }

        } catch (Exception ex) {
            AppAlertDialog.showAlertDialogGreen(context, "Lỗi", Color.RED, "Lỗi ghi lên ảnh\n" + ex.toString(), Color.WHITE, "OK", Color.RED);
            return null;
        }
    }

    /**
     * @param isCountLine: true: chỉ muốn lấy số dòng sẽ được vẽ
     *                     false: vẽ luôn
     * @param canvas:      null: nếu isCountLine == true
     *                     canvas: else
     * @param paint
     * @param x
     * @param textHeight
     * @param maxWidth
     * @param text
     */
    public static int drawTextAndBreakLine(final boolean isCountLine, final Canvas canvas, final Paint paint,
                                           float x, float y, float textHeight, float maxWidth, final String text, int paddingBetweenText) {
        String textToDisplay = text;
        String tempText = "";
        int countLine = 0;
        char[] chars;
        float lastY = y;
        int nextPos = 0;
        int lengthBeforeBreak = textToDisplay.length();
        do {
            countLine++;
            lengthBeforeBreak = textToDisplay.length();
            chars = textToDisplay.toCharArray();
            nextPos = paint.breakText(chars, 0, chars.length, maxWidth, null);
            tempText = textToDisplay.substring(0, nextPos);
            textToDisplay = textToDisplay.substring(nextPos, textToDisplay.length());
            if (!isCountLine) {
                canvas.drawText(tempText, x, lastY, paint);
            }
            lastY += textHeight + paddingBetweenText;
        } while (nextPos < lengthBeforeBreak);

        if (isCountLine)
            return countLine;
        else return -1;
    }
    public static byte[] encodeTobase64Byte(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] b = baos.toByteArray();
        return b;
    }
    public static Date currentDate(){
        return Calendar.getInstance().getTime();
    }
}
