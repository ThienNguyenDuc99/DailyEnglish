package com.pip.dao;

import com.pip.entity.Context;

import java.util.List;

public interface ContextDAO {

    void addContext(Context context, int id);

    List<Context> getContextbyVoca(int id);
}
