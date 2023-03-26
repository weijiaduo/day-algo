package com.wjd.lr.impl.function;

import com.wjd.lr.impl.function.dialect.*;

import static com.wjd.lr.impl.function.DialectType.*;

/**
 * 函数构建器工厂类
 *
 * @author weijiaduo
 * @since 2023/3/13
 */
public class FunctionBuilderFactory {

    /**
     * Create general function builder.
     *
     * @param type the type
     * @return the general function builder
     */
    public static GeneralFuncBuilder create(String type) {
        if (type == null) {
            return new GeneralFuncBuilder();
        }
        switch (type) {
            case ALIYUN_ANALYTIC_DB:
                return new AliyunAnalyticFuncBuilder();
            case ALIYUN_MAX_COMPUTE:
                return new AliyunMaxComputeFuncBuilder();
            case DB2:
            case DB2_V9:
            case DB2_400:
                return new DB2V9FuncBuilder();
            case CLICK_HOUSE:
                return new ClickHouseFuncBuilder();
            case DAMENG:
                return new DaMengFuncBuilder();
            case DAMENG_V6:
                return new DaMengV6FuncBuilder();
            case GAUSSDB:
                return new GaussFuncBuilder();
            case GAUSS100:
                return new Gauss100FuncBuilder();
            case GAUSS200:
                return new Gauss200FuncBuilder();
            case GREENPLUM:
                return new GreenplumFuncBuilder();
            case GBASE:
                return new GbaseFuncBuilder();
            case GBASE8T:
                return new Gbase8TFuncBuilder();
            case GBASE8S_V84:
                return new Gbase8SV84FuncBuilder();
            case GBASE8S_V88:
                return new Gbase8SV88FuncBuilder();
            case HADOOP_HIVE:
            case HADOOP_HIVE_V1:
                return new HadoopHiveFuncBuilder();
            case HANA:
                return new HANAFuncBuilder();
            case HUAWEI:
                return new HuaweiHiveFuncBuilder();
            case IMPALA:
                return new ImpalaFuncBuilder();
            case INFOBRIGHT:
                return new InfoBrightFuncBuilder();
            case INFORMIX:
                return new InformixFuncBuilder();
            case KINGBASE:
            case KINGBASE_V8:
                return new KingbaseFuncBuilder();
            case KINGBASEANALYTICS:
                return new KingbaseAnalyticsFuncBuilder();
            case KYLIN:
                return new KylinFuncBuilder();
            case MARIADB:
                return new MariaDBFuncBuilder();
            case MONETDB:
                return new MonetFuncBuilder();
            case MSSQL:
                return new MSSQLFuncBuilder();
            case MYSQL:
                return new MySQLFuncBuilder();
            case OBASE:
                return new ObaseFuncBuilder();
            case OCEANBASE:
                return new OceanBaseFuncBuilder();
            case OCEANBASE_ORACLE:
                return new OceanBaseOracleFuncBuilder();
            case ORACLE:
            case ORACLE_OCI:
                return new OracleFuncBuilder();
            case POSTGRESQL:
                return new PostgresqlFuncBuilder();
            case PRESTO:
                return new PrestoFuncBuilder();
            case RAPIDS:
                return new RapidsFuncBuilder();
            case SELECTDB:
                return new SelectDBFuncBuilder();
            case SHENTONG:
                return new ShenTongFuncBuilder();
            case STARROCKS:
                return new StarRocksFuncBuilder();
            case SYBASE:
                return new SybaseFuncBuilder();
            case TERADATA:
                return new TaradataFuncBuilder();
            case TERADATA_V12:
                return new TaradataV12FuncBuilder();
            case TIDB:
                return new TiDBFuncBuilder();
            case TIMESTEN:
                return new OracleTimesTenFuncBuilder();
            case VERTICA:
                return new VerticaFuncBuilder();
            case XINGHUAN:
                return new XinghuanFuncBuilder();
            default:
                return new GeneralFuncBuilder();
        }
    }
}
