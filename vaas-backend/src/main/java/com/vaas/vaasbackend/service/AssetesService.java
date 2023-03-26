package com.vaas.vaasbackend.service;

import com.vaas.vaasbackend.entity.TblAssete;

import java.util.List;

public interface AssetesService {
   public List<TblAssete> ShowAssetes();
   public TblAssete ShowAssetes(Integer id);
   public TblAssete SaveAssetes(TblAssete assete);
}
