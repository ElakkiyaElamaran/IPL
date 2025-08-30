package com.wecp.progressive.service.impl;

import java.util.List;

import com.wecp.progressive.dao.MatchDAO;
import com.wecp.progressive.entity.Match;
import com.wecp.progressive.service.MatchService;

public class MatchServiceImplJdbc  implements MatchService{

  private MatchDAO matchDAO;
  
    public MatchServiceImplJdbc(MatchDAO matchDAO) {
    this.matchDAO = matchDAO;
  }

    @Override
    public Integer addMatch(Match match) {
      return -1;
    }

    @Override
    public Match getMatchById(int matchId) {
       return null;
    }

    @Override
    public void updateMatch(Match match) {
        
    }

    @Override
    public void deleteMatch(int matchId) {
       
    }

    @Override
    public List<Match> getAllMatches() {
      return List.of();
    }


}