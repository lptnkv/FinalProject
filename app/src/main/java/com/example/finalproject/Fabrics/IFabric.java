package com.example.finalproject.Fabrics;

import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Models.ITask;

public interface IFabric {
    ITask generateTask(Folder folder, int ind);
}
