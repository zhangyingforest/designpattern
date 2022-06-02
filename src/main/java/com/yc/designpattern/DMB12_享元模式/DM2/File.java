package com.yc.designpattern.DMB12_享元模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 云盘的文件类
 */
public  class File {
    protected String owner;   //文件的所有者
    protected String filename;  //文件名
    protected Resource resource;  //上传后的文件( hashid, content等)
    //TODO:  服务器的ip, 端口,  副本, 权限 ,.....

    public File(String owner, String filename) {
        this.owner = owner;
        this.filename = filename;
    }

    public String fileMeta() {// 文件存储到文件系统中需要的key
        if (this.owner == null || filename == null || resource == null) {
            return "未知文件";
        }
        return owner + "-" + filename + resource.getHashId();
    }


    public String display() {
        return fileMeta() + ", 资源内容：" + getResource().toString();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "File{" +
                "owner='" + owner + '\'' +
                ", filename='" + filename + '\'' +
                ", resource=" + resource +
                '}';
    }
}
