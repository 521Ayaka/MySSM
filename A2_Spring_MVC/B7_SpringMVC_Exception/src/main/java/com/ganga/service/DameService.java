package com.ganga.service;

import com.ganga.exception.MyException;
import java.io.FileNotFoundException;


public interface DameService {

    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;

}
