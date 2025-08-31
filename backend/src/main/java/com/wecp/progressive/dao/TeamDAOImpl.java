package com.wecp.progressive.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.classmate.ResolvedType;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO {

    @Override
    public int addTeam(Team team) throws SQLException{
       Connection connection=null;
      PreparedStatement statement=null;
      ResultSet rs=null;
      int generatedID=-1;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="insert into team(team_name,location,owner_name,establishment_year) values(?,?,?,?)";
        statement=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, team.getTeamName());
        statement.setString(2,team.getLocation());
        statement.setString(3, team.getOwnerName());
        statement.setInt(4, team.getEstablishmentYear());
        statement.executeUpdate();
       rs=statement.getGeneratedKeys();
        if(rs.next())
        {
         generatedID=rs.getInt(1);
         team.setTeamId(generatedID);
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
    public Team getTeamById(int teamId)  throws SQLException {
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="select * from team where team_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1, teamId);
        ResultSet rs=statement.executeQuery();
        if(rs.next())
        {
         String teamName=rs.getString("team_name");
         String location=rs.getString("location");
         String ownerName=rs.getString("owner_name");
         int establishmentYear=rs.getInt("establishment_year");
         return new Team(teamId, teamName, location, ownerName, establishmentYear);
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
    public void updateTeam(Team team)  throws SQLException{
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="update team set team_name=?,location=?,owner_name=?,establishment_year=? where team_id= ? ";
        statement=connection.prepareStatement(sql);
        statement.setString(1,team.getTeamName());
        statement.setString(2, team.getLocation());
        statement.setString(3, team.getOwnerName());
        statement.setInt(4, team.getEstablishmentYear());
        statement.setInt(5, team.getTeamId());
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
    public void deleteTeam(int teamId)  throws SQLException{
      Connection connection=null;
      PreparedStatement statement=null;
       try
       {
        connection=DatabaseConnectionManager.getConnection();
        String sql="delete from team where team_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,teamId);
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
    public List<Team> getAllTeams()  throws SQLException{
      List<Team> teams=new ArrayList<>();
      Connection connection=null;
      PreparedStatement statement=null;
      ResultSet rs=null;
      try
      {
       connection=DatabaseConnectionManager.getConnection();
       String sql="select * from team";
       statement=connection.prepareStatement(sql);
       rs=statement.executeQuery();
       while(rs.next())
       {
         int teamId=rs.getInt("team_id");
         String teamName=rs.getString("team_name");
         String location=rs.getString("location");
         String ownerName=rs.getString("owner_name");
         int establishmentYear=rs.getInt("establishment_year");
         teams.add(new Team(teamId, teamName, location, ownerName, establishmentYear));
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
      return teams;
    }



}
