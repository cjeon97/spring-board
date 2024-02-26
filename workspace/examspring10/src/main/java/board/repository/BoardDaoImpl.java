package board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSessionTemplate sst;
	
	private static final String mapperNamespace = "board.repository.board.";

	@Override
	public List<Board> selectAll() {
		return sst.selectList(mapperNamespace + "selectAll", Board.class);
	}

	@Override
	public Board selectOne(long num) {
		return sst.selectOne(mapperNamespace + "selectOne", num);
	}

	@Override
	public void insert(Board board) {
		sst.insert(mapperNamespace+"insert", board);
	}

	@Override
	public void update(Board board) {
		sst.update(mapperNamespace+"update", board);
	}

	@Override
	public void delete(long num) {
		sst.delete(mapperNamespace+"delete", num);
	}

	@Override
	public void update(long num) {
		sst.update(mapperNamespace+"updateCnt", num);
	}
	
	

}
