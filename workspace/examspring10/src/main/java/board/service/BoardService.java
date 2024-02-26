package board.service;

import java.util.List;

import board.repository.Board;

public interface BoardService {
	public List<Board> list();
	public Board detail(long num);
	public void regist(Board board);
	public void edit(Board board);
	public void readCnt(long num);
	public void remove(long num);
}
