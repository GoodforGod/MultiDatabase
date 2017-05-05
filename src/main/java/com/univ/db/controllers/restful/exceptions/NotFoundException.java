package com.univ.db.controllers.restful.exceptions;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Default Comment
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

}
