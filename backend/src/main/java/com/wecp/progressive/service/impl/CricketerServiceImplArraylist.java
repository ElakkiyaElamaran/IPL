package com.wecp.progressive.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.service.CricketerService;
public class CricketerServiceImplArraylist  implements CricketerService {
   public static List<Cricketer>cricketerList=new ArrayList<>();
    @Override
    public Integer addCricketer(Cricketer cricketer) {
      cricketerList.add(cricketer);
      return cricketerList.size();
    }
    @Override
    public Cricketer getCricketerById(int cricketerId) {
     return null;
    }
    @Override
    public void updateCricketer(Cricketer cricketer) {
    }
    @Override
    public void deleteCricketer(int cricketerId) {  
    }
    public List<Cricketer> getAllCricketersSortedByExperience()
{
  List<Cricketer> sortedCricketer= cricketerList;
  sortedCricketer.sort(Comparator.comparing(Cricketer::getExperience));
  return sortedCricketer;
}
    @Override
    public List<Cricketer> getAllCricketers() {
       return cricketerList;
    }
@Override
public void emptyArrayList()
{
  cricketerList=new ArrayList<>();
}
}