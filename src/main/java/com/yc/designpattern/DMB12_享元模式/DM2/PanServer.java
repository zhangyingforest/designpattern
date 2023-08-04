package com.yc.designpattern.DMB12_享元模式.DM2;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: design-pattern-yc
 * @description: 网盘类: 最好是单例
 */
public class PanServer {

    private static PanServer panServer = new PanServer(); // 单例模式

    private Map<String, Resource> resourceSystem; // 资源系统，相当于享元池
    private Map<String, File> fileSystem;   // 文件系统(存文件的元数据 )

    public PanServer() {
        resourceSystem = new HashMap<String, Resource>();
        fileSystem = new HashMap<String, File>();
    }

    public static PanServer getInstance() {
        return panServer;
    }

    public String upload(String username, LocalFile localFile) {
        long startTime = System.currentTimeMillis();
        //TODO:   hadoop或是fastDFS   ->    创建待保存的文件的元数据    服务器的ip, 端口,  副本, 权限 ,.....
        File file = new File(username, localFile.getFilename());
        //根据内容计算文件hash值
        String hashId = HashUtil.computeHashId(localFile.getContent());
        System.out.println(username + " 上传文件");
        try {
            if (resourceSystem.containsKey(hashId)) {
                System.out.println(String.format("检测到内容相同的文件《%s》，为了节约空间，重用文件", localFile.getFilename()));
                file.setResource(this.resourceSystem.get(hashId));
                Thread.sleep(100);
            } else {
                System.out.println(String.format("文件《%s》上传中....", localFile.getFilename()));
                Resource newResource = new Resource(localFile.getContent());
                file.setResource(newResource);
                this.resourceSystem.put(newResource.getHashId(), newResource); // 将资源对象存储到资源池中
                Thread.sleep(3000);     // 上传文件需要耗费一定时间
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将文件存到文件系统
        fileSystem.put(file.fileMeta(), file);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("文件上传完成，共耗费 %s 毫秒\n", endTime - startTime));
        return file.fileMeta();
    }


    public void download(String fileKey) {
        File file = this.fileSystem.get(fileKey);
        if (file == null) {
            System.out.println("文件不存在");
        } else {
            System.out.println("下载文件：" + file.display());
        }
        // 转为 LocalFile 返回
    }
}
