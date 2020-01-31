package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.hostDao;
import com.sprinboot.dazuoye.pojo.Host;
import com.sprinboot.dazuoye.service.hostServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class hostServicesImpl implements hostServices {
    @Resource
    private hostDao hostDao;

    //    开播添加主播信息
    @Override
    public int insertHost(String username, String name, String appid, String title, String roomSum) throws Exception {
        Host host = new Host();
        host.setAppid(appid);
        host.setName(name);
        host.setUsername(username);
        host.setTitle(title);
        host.setRoomSum(roomSum);
        return hostDao.insertHost(host);
    }

    @Override
    public List<Host> getHostInfo(String username) throws Exception {
        List<Host> host = hostDao.getHostInfo(username);
        if (host != null) {
            return host;
        }
        return null;
    }


}
