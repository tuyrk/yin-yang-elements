package com.cdutcm.elements.utils.serializer;

import com.cdutcm.elements.exception.ElementsException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.text.DateFormat;
import java.util.Date;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/2/4 19:16 星期日
 * Description:
 */
public class DateFormatSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            jsonGenerator.writeNumber(DateFormat.getDateInstance(DateFormat.YEAR_FIELD).format(date));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ElementsException(500, "内部服务器错误");
        }
    }
}
