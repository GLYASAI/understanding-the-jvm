####局部变量可作为GCRoots

执行LocalVariablesTest, 得到JVM日志:
\
[GC (System.gc()) [PSYoungGen: 105513K->872K(458752K)] 105513K->82800K(983040K), 0.0379839 secs] [Times: user=0.11 sys=0.05, real=0.04 secs]

[Full GC (System.gc()) [PSYoungGen: 872K->0K(458752K)] [ParOldGen: 81928K->82634K(524288K)] 82800K->82634K(983040K), [Metaspace: 3466K->3466K(1056768K)], 0.0188586 secs] [Times: user=0.08 sys=0.00, real=0.02 secs]

第一次GC完成

[GC (System.gc()) [PSYoungGen: 7864K->96K(458752K)] 90498K->82730K(983040K), 0.0008936 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

[Full GC (System.gc()) [PSYoungGen: 96K->0K(458752K)] [ParOldGen: 82634K->684K(524288K)] 82730K->684K(983040K), [Metaspace: 3468K->3468K(1056768K)], 0.0051006 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 
第二次GC完成

[GC (System.gc()) [PSYoungGen: 105513K->872K(458752K)] 105513K->82800K(983040K)], Minor GC将instance(80M)转移到老年代中
\
[Full GC (System.gc()) [PSYoungGen: 872K->0K(458752K)] [ParOldGen: 81928K->82634K(524288K)] 82800K->82634K(983040K)], Full GC不会回收instance(80M), instance还保留在老年代中

 ####静态变量可作为GCRoots
 
 执行StaticVariablesTest, 得到JVM日志: 
 
 [GC (System.gc()) [PSYoungGen: 146473K->872K(458752K)] 146473K->82800K(983040K), 0.0369449 secs] [Times: user=0.11 sys=0.03, real=0.04 secs] 
 
 [Full GC (System.gc()) [PSYoungGen: 872K->0K(458752K)] [ParOldGen: 81928K->82634K(524288K)] 82800K->82634K(983040K), [Metaspace: 3466K->3466K(1056768K)], 0.0178840 secs] [Times: user=0.08 sys=0.02, real=0.02 secs]
 
 [GC (System.gc()) [PSYoungGen: 146473K->872K(458752K)] 146473K->82800K(983040K)], Minor GC将instance(80M)转移到老年代中, 并回收了temp(40M)
 \
 [Full GC (System.gc()) [PSYoungGen: 872K->0K(458752K)] [ParOldGen: 81928K->82634K(524288K)] 82800K->82634K(983040K)], Full GC没有回收instance(80M), instance依然保留在老年代