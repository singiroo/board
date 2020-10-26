package kr.or.ddit.post.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.PostVO;

public class PostService implements PostServiceI {

	private PostDaoI postDao;
	private SqlSession sqlSession;
	
	@Override
	public Map<String, Object> getPostListPage(Map<String, Object> map) {
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		List<PostVO> postList = null;	//출력할 글 목록
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int totalPage = 1;	//출력할 전체 페이지수
		try {
			postList = postDao.getPostList(sqlSession, map);
			totalPage = (int)Math.floor((double)postDao.getAllPostCnt(sqlSession, (String)map.get("boardid"))
					/ ((PageVO)map.get("page")).getPageSize());			
			resultMap.put("postList", postList);
			resultMap.put("totalPage", totalPage);			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		sqlSession.close();
		
		return resultMap;
	}

}
