package com.wafe.android3rdlib.custom.TreeView;

import com.wafe.android3rdlib.custom.TreeView.lib.TreeNodeId;
import com.wafe.android3rdlib.custom.TreeView.lib.TreeNodeLabel;
import com.wafe.android3rdlib.custom.TreeView.lib.TreeNodePid;

public class FileBean
{
	@TreeNodeId
	private int _id;
	@TreeNodePid
	private int parentId;
	@TreeNodeLabel
	private String name;
	private long length;
	private String desc;

	public FileBean(int _id, int parentId, String name)
	{
		super();
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
	}

}
