package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.repository.Board;
import board.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> list() {
		List<Board> ls = boardDao.selectAll();
		return ls;
	}

	@Override
	public Board detail(long num) {
		Board board = boardDao.selectOne(num);
		return board;
	}

	@Override
	public void regist(Board board) {
		boardDao.insert(board);
	}

	@Override
	public void edit(Board board) {
		boardDao.update(board);
	}

	@Override
	public void remove(long num) {
		boardDao.delete(num);
	}

	@Override
	public void readCnt(long num) {
		boardDao.update(num);
	}

}
