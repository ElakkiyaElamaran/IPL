package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO{

    @Override
    public int addMatch(Match match) throws SQLException {
      Connection connection=null;
      PreparedStatement statement=null;
      ResultSet rs=null;
      int generatedID=-1;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="insert into matches (first_team_id,second_team_id,match_date,venue,result,status,winner_team_id) values(?,?,?,?,?,?,?)";
        statement=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, match.getFirstTeamId());
        statement.setInt(2, match.getSecondTeamId());
        statement.setDate(3, new java.sql.Date(match.getMatchDate().getTime()));
        statement.setString(4, match.getVenue());
        statement.setString(5, match.getResult());
        statement.setString(6, match.getStatus());
        statement.setInt(7, match.getWinnerTeamId());
         statement.executeUpdate();
          rs=statement.getGeneratedKeys();
         if(rs.next())
         {
            generatedID=rs.getInt(1);
            match.setMatchId(generatedID);
         }
       }
        catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      finally
      {
       if(statement!=null)
       {
         statement.close();
       }
       if(connection!=null)
       {
         connection.close();
       }
      }
     return generatedID;

    }

    @Override
    public Match getMatchById(int matchId) throws SQLException{
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="select * from matches where match_id=? ";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,matchId);
        ResultSet rs=statement.executeQuery();
        if(rs.next())
        {
         int firstTeamId=rs.getInt("first_team_id");
         int secondTeamId=rs.getInt("second_team_id");
         Date matchDate=rs.getDate("match_date");
         String venue=rs.getString("venue");
         String result=rs.getString("result");
         String status=rs.getString("status");
         int  winnerTeamId=rs.getInt("winner_team_id");
         return new Match(matchId, firstTeamId, secondTeamId, matchDate, venue, result, status, winnerTeamId);
        }
       }
       catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      finally
      {
       if(statement!=null)
       {
         statement.close();
       }
       if(connection!=null)
       {
         connection.close();
       }
      }
return null;
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="update matches set first_team_id=?,second_team_id=?,match_date=?,venue=?,result=?,status=?,winner_team_id=? where match_id=? ";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,match.getFirstTeamId());
        statement.setInt(2,match.getSecondTeamId());
        statement.setDate(3,new java.sql.Date(match.getMatchDate().getTime()));
        statement.setString(4,match.getVenue());
        statement.setString(5,match.getResult());
        statement.setString(6,match.getStatus());
        statement.setInt(7,match.getWinnerTeamId());
        statement.setInt(8,match.getMatchId());
        statement.executeUpdate();
       }
       catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      finally
      {
       if(statement!=null)
       {
         statement.close();
       }
       if(connection!=null)
       {
         connection.close();
       }
      }
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException{
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="delete from matches where match_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,matchId);
        statement.executeUpdate();
       }
      catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      finally
      {
       if(statement!=null)
       {
         statement.close();
       }
       if(connection!=null)
       {
         connection.close();
       }
      }
    }

    @Override
    public List<Match> getAllMatches() throws SQLException{
      List<Match> matches=new ArrayList<>();
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="select * from matches";
        statement=connection.prepareStatement(sql);
        ResultSet rs=statement.executeQuery();
        while(rs.next())
        {
         int matchId=rs.getInt("match_id");
         int firstTeamId=rs.getInt("first_team_id");
         int secondTeamId=rs.getInt("second_team_id");
         Date matchDate=rs.getDate("match_date");
         String venue=rs.getString("venue");
         String result= rs.getString("result");
         String status=rs.getString("status");
         int winnerTeamId=rs.getInt("winner_team_id");
         matches.add(new Match(matchId, firstTeamId, secondTeamId, matchDate, venue, result, status, winnerTeamId));
        }
       }
      catch (SQLException e) {
         e.printStackTrace();
         throw e;
      }
      finally
      {
       if(statement!=null)
       {
         statement.close();
       }
       if(connection!=null)
       {
         connection.close();
       }
      }
      return matches;
    }

}
