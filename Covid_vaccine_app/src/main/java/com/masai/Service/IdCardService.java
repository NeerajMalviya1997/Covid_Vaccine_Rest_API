package com.masai.Service;

import com.masai.exceptions.IdCardException;
import com.masai.exceptions.IdCardNotFoundException;
import com.masai.model.IDCard;


public interface IdCardService {

	public IDCard getIdcardByPanNo(String panNo,String key) throws IdCardNotFoundException;

	public IDCard getIdCardByAdharNo(Long adharno,String key) throws IdCardNotFoundException;

	public IDCard addIdCard(IDCard idCard) throws IdCardException;
}
