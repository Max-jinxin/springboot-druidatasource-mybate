package cn.joiner.mapper;

import cn.joiner.domain.CarPositionRelation;

public interface CarPositionRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPositionRelation record);

    int insertSelective(CarPositionRelation record);

    CarPositionRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPositionRelation record);

    int updateByPrimaryKey(CarPositionRelation record);
    /**
     * 更新status=1的remains_days
     * 根据实际时间NOW计算
     * @return
     */
    int updateRemainDays();
}