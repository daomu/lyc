package com.lyc0.lycwx.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupInfo {
    private String groupName;
    private String creatorOpenId;
    private List<String> memberOpenIds = new ArrayList<>();
    private List<Map<String,Long>> memberRecord = new ArrayList<>();
}
