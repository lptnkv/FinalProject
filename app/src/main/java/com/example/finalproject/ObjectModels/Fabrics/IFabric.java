package com.example.finalproject.ObjectModels.Fabrics;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.ObjectModels.ITask;

public interface IFabric {
    ITask generateTask(Folder folder, int ind);
}
