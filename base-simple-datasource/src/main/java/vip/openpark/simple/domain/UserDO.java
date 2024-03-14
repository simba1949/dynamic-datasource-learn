package vip.openpark.simple.domain;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 表名：user
 * 表注释：用户信息表
*/
@Getter
@Setter
@ToString
@Table(name = "user")
public class UserDO {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 业务编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 用户登录名
     */
    @Column(name = "username")
    private String username;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮件
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别，0表示女，1表示男
     */
    @Column(name = "gender")
    private Byte gender;

    /**
     * 证件类型，0表示身份证，1表示护照
     */
    @Column(name = "card_type")
    private Integer cardType;

    /**
     * 证件号
     */
    @Column(name = "card_code")
    private String cardCode;

    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private LocalDateTime birthday;

    /**
     * 民族
     */
    @Column(name = "nation")
    private String nation;

    /**
     * 国家
     */
    @Column(name = "country_name")
    private String countryName;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 账号是否启用，0表示否，1表示是（未启用则不能登录账号）
     */
    @Column(name = "bl_enable")
    private Byte blEnable;

    /**
     * 账号有效期至（账号有些场景需要设置有效期，默认永久有效）
     */
    @Column(name = "account_valid_period")
    private LocalDateTime accountValidPeriod;

    /**
     * 密码有效期至（用于提示用户定期修改密码）
     */
    @Column(name = "password_valid_period")
    private LocalDateTime passwordValidPeriod;

    /**
     * 账号是否锁定，0表示否，1表示是（有些时候用户可以登录账号，但是因为账号锁定不能提现）
     */
    @Column(name = "bl_locked")
    private Byte blLocked;

    /**
     * 是否删除，0表示否，1表示是
     */
    @Column(name = "bl_delete")
    private Byte blDelete;

    /**
     * 版本号
     */
    @Column(name = "version")
    private Long version;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 创建人真实姓名
     */
    @Column(name = "creator")
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建人code
     */
    @Column(name = "creator_code")
    private String creatorCode;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private LocalDateTime gmtModify;

    /**
     * 修改人真实姓名
     */
    @Column(name = "modifier")
    private String modifier;

    /**
     * 修改人ID
     */
    @Column(name = "modifier_id")
    private Long modifierId;

    /**
     * 修改人code
     */
    @Column(name = "modifier_code")
    private String modifierCode;
}