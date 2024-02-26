package board.repository;

import java.util.List;

public interface BoardDao {
	
	public List<Board> selectAll();
	public Board selectOne(long num);
	public void insert(Board board);
	public void update(Board board);
	public void update(long num);
	public void delete(long num);
	
}
