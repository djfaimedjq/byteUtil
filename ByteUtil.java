package com.domed.api.util.token;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *
 * @Title: 操作二进制字符的工具包
 * @Description:
 * @param 
 * @return: 
 * @author: djf
 * Create Date: 2019/5/6  17:12
 * @throws
 */
@Component
public class ByteUtil {
    
    /**
     *
     * @Title: 把二进制的数组转化成16进制的字符串
     * @Description:
     * @param 
     * @return: 
     * @author: djf
     * Create Date: 2019/5/6  17:15
     * @throws
     */
    public String byte2HexStr(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }

        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }

        return stringBuilder.toString();
    }

    public String singleByte2Str(byte b){

        int v = b & 0xFF;
        StringBuilder stringBuilder = new StringBuilder("");
        String hv = Integer.toHexString(v).toUpperCase();
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);

        return stringBuilder.toString();
    }

    public void formatByte(byte[] bytes,int count){
        for (int i = 0 ; i < bytes.length ; i+=count){
            byte[] partBytes =   Arrays.copyOfRange(bytes, i, i+count);
            StringBuffer sb = new StringBuffer();

            int singleCount = i + count > bytes.length?bytes.length-i:count;

            for(int j = 0 ; j < singleCount ; j++){
                String byteStr =  singleByte2Str(bytes[i+j]);
                sb.append(byteStr);
                sb.append(" ");
            }

            int hexLocationCount = count * 3;
            System.out.printf("%-"+hexLocationCount+"s %s \r\n",sb.toString(),new String(partBytes).replaceAll("\n"," "));

        }

    }
}
