/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.model.Emoji;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr Khang
 */
public class EmojiDAO {

    public static void createStatusEmoji(String statusId, int accountId, String emojiID) {
        try {

            String query = "DECLARE @statusID INT = ?,\n"
                    + "		@accountID INT = ?,\n"
                    + "		@emojiId INT = ?\n"
                    + "IF EXISTS (SELECT * FROM StatusEmotion WHERE StatusID = @statusID  and AccountUserID = @accountID)\n"
                    + "BEGIN\n"
                    + "	UPDATE StatusEmotion\n"
                    + "	SET EmojiID =@emojiId\n"
                    + "	WHERE StatusId = @statusID and AccountUserID = @accountID\n"
                    + "END\n"
                    + "ELSE\n"
                    + "BEGIN\n"
                    + "   INSERT INTO StatusEmotion\n"
                    + "   Values ( @statusID,@accountID,@emojiId)\n"
                    + "END";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(statusId));
            ps.setInt(2, accountId);
            ps.setInt(3, Integer.parseInt(emojiID));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Create Status Emoji Error");
        }
    }

    public static void deleteStatusEmoji(String statusId, int accountId) {
        try {

            String query = "DELETE FROM StatusEmotion\n"
                    + "WHERE StatusID = ? and AccountUserID = ? ;";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(statusId));
            ps.setInt(2, accountId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Status Emoji Error");
        }
    }

    public static int getStatusNumberOfEmojis(int StatusID) {
        try {
            int numberOfEmoji = 0;
            String query = "select count(*) \n"
                    + "from StatusEmotion\n"
                    + "where StatusID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, StatusID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return -1;
            } else {
                while (rs.next()) {
                    numberOfEmoji = rs.getInt(1);
                }
                return numberOfEmoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Status Emoji Error");
        }
        return -1;
    }

    public static List<String> getListStatusMaxEmojis(int StatusID) {
        try {
            List<String> list = new ArrayList<>();

            String query = "SELECT Top(2) EmojiImg\n"
                    + "FROM StatusEmotion se , Emoji e\n"
                    + "WHere StatusID = ? and se.EmojiID =e.EmojiID\n"
                    + "GROUP BY EmojiImg\n"
                    + "Order BY COUNT(EmojiImg) DESC ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, StatusID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    String count = rs.getString(1);
                    list.add(count);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Max Emoji Error");
        }
        return null;
    }

    public static List<Emoji> getListStatusEmoji(String StatusID) {
        try {
            List<Emoji> list = new ArrayList<>();
            String query = "Select Name, Avatar,EmojiID ,se.AccountUserID\n"
                    + "from StatusEmotion se  ,AccountProfile ap\n"
                    + "Where StatusID = ? and  se.AccountUserID =ap.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(StatusID));
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Emoji emoji = new Emoji(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    list.add(emoji);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Status Emoji Error");
        }
        return null;
    }

    public static void createCommentEmoji(String commentID, int accountId, String emojiID) {
        try {

            String query = "DECLARE @commentID INT = ?,\n"
                    + "        @accountID INT = ?,\n"
                    + "        @emojiId INT = ?\n"
                    + "IF EXISTS (SELECT * FROM CommentEmotion WHERE CommentID = @commentID  and AccountUserID = @accountID)\n"
                    + "BEGIN\n"
                    + "	UPDATE CommentEmotion\n"
                    + "	SET EmojiID =@emojiId\n"
                    + "	WHERE CommentID = @commentID and AccountUserID = @accountID\n"
                    + "END\n"
                    + "ELSE\n"
                    + "BEGIN\n"
                    + "	INSERT INTO CommentEmotion\n"
                    + "	Values ( @commentID,@accountID,@emojiId)\n"
                    + "END";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentID));
            ps.setInt(2, accountId);
            ps.setInt(3, Integer.parseInt(emojiID));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Create Comment Emoji Error");
        }
    }

    public static void deleteCommentEmoji(String commentId, int accountId) {
        try {

            String query = "DELETE FROM CommentEmotion\n"
                    + "WHERE CommentID = ? and AccountUserID = ? ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentId));
            ps.setInt(2, accountId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Status Emoji Error");
        }
    }

    public static List<Emoji> getListCommentEmoji(String commentID) {
        try {
            List<Emoji> list = new ArrayList<>();
            String query = "Select Name, Avatar,EmojiID,se.AccountUserID\n"
                    + "from CommentEmotion se  ,AccountProfile ap\n"
                    + "Where CommentID = ? and  se.AccountUserID =ap.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentID));
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Emoji emoji = new Emoji(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    list.add(emoji);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Status Emoji Error");
        }
        return null;
    }

    public static int getCommentNumberOfEmojis(int CommentID) {
        try {
            int numberOfEmoji = 0;
            String query = "select count(*) \n"
                    + "from CommentEmotion\n"
                    + "where CommentID = ? ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, CommentID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return -1;
            } else {
                while (rs.next()) {
                    numberOfEmoji = rs.getInt(1);
                }
                return numberOfEmoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment Emoji Error");
        }
        return -1;
    }

    public static List<String> getListCommentMaxEmojis(int CommentID) {
        try {
            List<String> list = new ArrayList<>();
            String query = "SELECT Top(2) EmojiImg\n"
                    + "FROM CommentEmotion ce , Emoji e\n"
                    + "WHere CommentID = ? and ce.EmojiID =e.EmojiID\n"
                    + "GROUP BY EmojiImg\n"
                    + "Order BY COUNT(EmojiImg) DESC ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, CommentID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    String count = rs.getString(1);
                    list.add(count);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Max Emoji Error");
        }
        return null;
    }

    public static void createComment2Emoji(String comment2Id, int accountId, String emojiID) {
        try {

            String query = "DECLARE @comment2ID INT = ?,\n"
                    + "        @accountID INT = ?,\n"
                    + "        @emojiId INT = ?\n"
                    + "IF EXISTS (SELECT * FROM Comment2Emotion WHERE Comment2ID = @comment2ID  and AccountUserID = @accountID)\n"
                    + "BEGIN\n"
                    + "	UPDATE Comment2Emotion\n"
                    + "	SET EmojiID =@emojiId\n"
                    + "	WHERE Comment2ID = @comment2ID and AccountUserID = @accountID\n"
                    + "END\n"
                    + "ELSE\n"
                    + "BEGIN\n"
                    + "	INSERT INTO Comment2Emotion\n"
                    + "	Values ( @comment2ID,@accountID,@emojiId)\n"
                    + "END";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(comment2Id));
            ps.setInt(2, accountId);
            ps.setInt(3, Integer.parseInt(emojiID));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Create Status Emoji Error");
        }
    }

    public static void deleteComment2Emoji(String comment2ID, int accountId) {
        try {

            String query = "DELETE FROM Comment2Emotion\n"
                    + "WHERE Comment2ID = ? and AccountUserID = ? ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(comment2ID));
            ps.setInt(2, accountId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Status Emoji Error");
        }
    }

    public static List<Emoji> getListComment2Emoji(String comment2ID) {
        try {
            List<Emoji> list = new ArrayList<>();
            String query = "Select Name, Avatar,EmojiID ,se.AccountUserID\n"
                    + "from Comment2Emotion se  ,AccountProfile ap\n"
                    + "Where Comment2ID = ? and  se.AccountUserID =ap.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(comment2ID));
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Emoji emoji = new Emoji(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    list.add(emoji);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment Emoji Error");
        }
        return null;
    }

    public static int getComment2NumberOfEmojis(int Comment2ID) {
        try {
            int numberOfEmoji = 0;
            String query = "select count(*) \n"
                    + "from Comment2Emotion\n"
                    + "where Comment2ID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Comment2ID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return -1;
            } else {
                while (rs.next()) {
                    numberOfEmoji = rs.getInt(1);
                }
                return numberOfEmoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment2 Emoji Error");
        }
        return -1;
    }

    public static List<String> getListComment2MaxEmojis(int Comment2ID) {
        try {
            List<String> list = new ArrayList<>();
            String query = "SELECT Top(2) EmojiImg\n"
                    + "FROM Comment2Emotion ce , Emoji e\n"
                    + "WHere Comment2ID = ? and ce.EmojiID =e.EmojiID\n"
                    + "GROUP BY EmojiImg\n"
                    + "Order BY COUNT(EmojiImg) DESC ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Comment2ID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    String count = rs.getString(1);
                    list.add(count);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Max Emoji Error");
        }
        return null;
    }

    public static int isStatusUserEmojis(int StatusID, int accountID) {
        try {
            int emoji = 0;
            String query = "SELECT * \n"
                    + "FROM StatusEmotion\n"
                    + "WHERE StatusID = ? and AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, StatusID);
            ps.setInt(2, accountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return 0;
            } else {
                while (rs.next()) {
                    emoji = rs.getInt(3);
                }
                return emoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Is User Status Emoji Error");
        }
        return 0;
    }

    public static int isCommentUserEmojis(int commentID, int accountID) {
        try {
            int emoji = 0;
            String query = "SELECT * \n"
                    + "FROM CommentEmotion\n"
                    + "WHERE CommentID = ? and AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, commentID);
            ps.setInt(2, accountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return 0;
            } else {
                while (rs.next()) {
                    emoji = rs.getInt(3);
                }
                return emoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Is User Comment Emoji Error");
        }
        return 0;
    }

    public static int isComment2UserEmojis(int comment2ID, int accountID) {
        try {
            int emoji = 0;
            String query = "SELECT * \n"
                    + "FROM Comment2Emotion\n"
                    + "WHERE Comment2ID = ? and AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, comment2ID);
            ps.setInt(2, accountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return 0;
            } else {
                while (rs.next()) {
                    emoji = rs.getInt(3);
                }
                return emoji;
            }
        } catch (SQLException ex) {
            System.err.println("Get Is User Comment2 Emoji Error");
        }
        return 0;
    }
}
