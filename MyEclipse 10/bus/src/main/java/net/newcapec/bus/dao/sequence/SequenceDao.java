package net.newcapec.bus.dao.sequence;

import net.newcapec.bus.dao.IDao;
import net.newcapec.bus.service.bo.Sequence;
import net.newcapec.bus.service.bo.search.SequenceSearch;

import org.springframework.stereotype.Component;

/**
 *
 * @author 黄鑫
 *
 */
@Component
public interface SequenceDao extends IDao<Sequence, AbstractSequence, SequenceSearch> {

}
