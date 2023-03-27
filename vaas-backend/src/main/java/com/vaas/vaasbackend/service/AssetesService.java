package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAssete;
import com.vaas.vaasbackend.errors.AssetesNotFoundException;

import java.util.List;

public interface AssetesService {
   public List<TblAssete> ShowAssetes();
   public TblAssete ShowAssetes(Integer id) throws AssetesNotFoundException;
   public TblAssete SaveAssetes(TblAssete assete);
   public void DeleteAssetes(Integer id);
}
