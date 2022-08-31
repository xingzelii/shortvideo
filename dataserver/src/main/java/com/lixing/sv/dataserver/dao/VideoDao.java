package com.lixing.sv.dataserver.dao;

import org.apache.ibatis.annotations.Mapper;
import com.lixing.sv.entitys.VideoForDao;

@Mapper
public interface VideoDao {
	public int addVideo(VideoForDao v);
	public long queryMaxId();
	public int favourite(long id);
	public void disfavourite(long id);
}
