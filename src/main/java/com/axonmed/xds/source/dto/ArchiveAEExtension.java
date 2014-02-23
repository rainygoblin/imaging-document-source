package com.axonmed.xds.source.dto;

import org.dcm4che.net.AEExtension;

import com.axonmed.xds.source.model.ServerPartition;

public class ArchiveAEExtension extends AEExtension {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8129337635051325665L;

	private ServerPartition serverPartition;
	
	
	public ServerPartition getServerPartition() {
		return serverPartition;
	}


	public void setServerPartition(ServerPartition serverPartition) {
		this.serverPartition = serverPartition;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
    public void reconfigure(AEExtension from) {
        ArchiveAEExtension arcae = (ArchiveAEExtension) from;
        this.serverPartition = arcae.getServerPartition();
	}
}