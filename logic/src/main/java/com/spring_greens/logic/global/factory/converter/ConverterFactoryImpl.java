package com.spring_greens.logic.global.factory.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring_greens.logic.extraction.converter.ifs.ExtractionConverter;
import com.spring_greens.logic.global.factory.converter.ifs.ConverterFactory;

/**
 * ConverterFactory purpose is to break dependency of controller. <br>
 * if converterFactory is not exist, AbstractBaseController has many of service bean and converter etc. <br>
 * each of controller need to initialize bean by using constructor. <br>
 * in this case, each controller increases the number of parameters to constructor. <br>
 * <br>
 * let's assume one situation, we have so many controller that contained many services. <br>
 * if controller is changed or deleted, we have to change each of controller. <br>
 *
 * In order to prevent this, I create converter factory <br>
 * as a result, this way reduces the dependence between controller and each bean. <br>
 * @author itstime0809
 */

@Component
@RequiredArgsConstructor
public class ConverterFactoryImpl implements ConverterFactory {
    private final ExtractionConverter extractionConverter;

    @Override
    public ExtractionConverter getExtractionConverter(){
        return extractionConverter;
    }
}